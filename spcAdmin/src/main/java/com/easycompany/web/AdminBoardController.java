package com.easycompany.web;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.easycompany.cmm.util.FileUtil;
import com.easycompany.cmm.util.StringUtil;
import com.easycompany.cmm.vo.LoginVo;
import com.easycompany.service.AdBoardService;
import com.easycompany.service.vo.AdBoardVo;
import com.easycompany.service.vo.BoardVo;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("adBoard")
public class AdminBoardController {
	
	@Autowired
	private AdBoardService adBoardService;
	
	/** EgovPropertyService */
	@Autowired
	protected EgovPropertyService propertiesService;
	
	@Value("#{dbinfo['file.path']}")
	private String filePath;
	
	@RequestMapping(value = "/noticeList.do")
	public String getNoticeList(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model, HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		/** EgovPropertyService.sample */
		adBoardVo.setPageUnit(propertiesService.getInt("pageUnit"));
		adBoardVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(adBoardVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(adBoardVo.getPageUnit());
		paginationInfo.setPageSize(adBoardVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		adBoardVo.setOffset(offset);
		
		adBoardVo.setBoard_type("01");
		List<AdBoardVo> list = adBoardService.getBoardList(adBoardVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = adBoardService.getBoardCount(adBoardVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		adBoardVo.setReg_id(loginvo.getId());		
		model.addAttribute("adBoardVo",   adBoardVo);
		model.addAttribute("path",      request.getServletPath());

		return "noticeList";
	}
	
	@RequestMapping(value = "/noticeReq.do")
	public String noticeReq(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model) throws Exception {
		if(adBoardVo.getBoard_idx() != null) {
			AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
			if(detailData != null ) {
				List<BoardVo> files = adBoardService.selectFileList(adBoardVo);
				model.addAttribute("resultFileList", files);
			}
			model.addAttribute("detailData",  detailData);
		}
		return "noticeReq";
	}
	
	@RequestMapping(value = "/noticeSave.do")
	@ResponseBody
	public AdBoardVo noticeSave(@RequestParam("article_file") List<MultipartFile> multipartFile, HttpServletRequest request, AdBoardVo adBoardVo) throws Exception {
		int resultCnt = 0;
		try {
			
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			String fileAddpath = this.filePath + File.separator + "board";
			List<Map<String, Object>> fileSavelist = null;
			ArrayList<String> fileList = new ArrayList<>();
			
			if ("I".equals(adBoardVo.getGubun1())) { // 저장
				fileSavelist = FileUtil.uploadFileMulti(multipartFile, request, fileAddpath); 
				resultCnt = adBoardService.insertBoard(adBoardVo, fileSavelist);
				adBoardVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
			} else if("E".equals(adBoardVo.getGubun1())) { // 수정
//				resultCnt = adBoardService.updateBoard(adBoardVo);
				String[] ArraysStr = adBoardVo.getCheckdstr().split(",");
		    	  if(ArraysStr.length >0){
		    		  BoardVo boardVo = new BoardVo();
		    		  for (String s : ArraysStr) {
		    	        	if(!StringUtil.isEmpty(s)) {
		    	        		boardVo.setFile_seq(Integer.parseInt(s));
		    	        		BoardVo fileCategoryVo = adBoardService.selectFile(boardVo);
		    	                fileList.add(fileCategoryVo.getFile_full_path());
		    	        	}        	
		    	      }   
		    	  }
		          
		          //파일업로드
		    	  if (multipartFile !=null && multipartFile.size() > 0) {
		      		fileSavelist = FileUtil.uploadFileMulti(multipartFile, request, fileAddpath); 
		      	  }
		    	  
		    	  //파일 추가, 정보업데이트
		          resultCnt = adBoardService.updateBoard(adBoardVo, fileSavelist);
		          
		          //성공 시 파일 삭제
		          if(resultCnt > 0) {
			       	   if (fileList !=null && fileList.size() > 0) {
			       		for (String fileFullPath : fileList) {
			       			FileUtil.deleteFile(request, fileFullPath);
			            }
			       	  }
			      }
				adBoardVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
			}
			
		} catch (Exception e) {
			adBoardVo.setResult("FAIL");
		}
		return adBoardVo;
	}
	
	@RequestMapping(value = "/noticeDel.do")
	@ResponseBody
	public String noticeDel(HttpServletRequest request, @RequestParam(value="boardIdxArray[]") List<String> boardIdxStrArray) throws Exception {
		int resultCnt = 0;
		String result = "";
		try {
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			List<Long> boardIdxList = new ArrayList<Long>();
			
			for(String idxStr : boardIdxStrArray){
				boardIdxList.add(Long.parseLong(idxStr));
			}
			
		    HashMap<String, Object> map = new HashMap<String, Object>();
		    map.put("boardIdxList", boardIdxList);
		    
		    resultCnt = adBoardService.delBoard(map);
		    result = (resultCnt > 0 ? "SUCCESS" : "FAIL");
		    
		} catch (Exception e) {
			result = "FAIL";
		}
		
		return result;
	}
	
	@RequestMapping(value = "/referenceList.do")
	public String getReferenceList(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model, HttpServletRequest request) throws Exception {
		
		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		/** EgovPropertyService.sample */
		adBoardVo.setPageUnit(propertiesService.getInt("pageUnit"));
		adBoardVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(adBoardVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(adBoardVo.getPageUnit());
		paginationInfo.setPageSize(adBoardVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		adBoardVo.setOffset(offset);
		adBoardVo.setBoard_type("02");
		List<AdBoardVo> list = adBoardService.getBoardList(adBoardVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = adBoardService.getBoardCount(adBoardVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		adBoardVo.setReg_id(loginvo.getId());		
		model.addAttribute("adBoardVo",   adBoardVo);
		model.addAttribute("path",      request.getServletPath());

		return "referenceList";
	}
	
	@RequestMapping(value = "/referenceReq.do")
	public String referenceReq(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model) throws Exception {

	if(adBoardVo.getBoard_idx() != null) {
		adBoardVo.setBoard_type("02");
		AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
		if(detailData != null ) {
			List<BoardVo> files = adBoardService.selectFileList(adBoardVo);
			model.addAttribute("resultFileList", files);
		}
		model.addAttribute("detailData",  detailData);
	}

		return "referenceReq";
	}
	
	@RequestMapping(value = "/faqList.do")
	public String faqList(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model, HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		/** EgovPropertyService.sample */
		adBoardVo.setPageUnit(propertiesService.getInt("pageUnit"));
		adBoardVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(adBoardVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(adBoardVo.getPageUnit());
		paginationInfo.setPageSize(adBoardVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		adBoardVo.setOffset(offset);
		adBoardVo.setBoard_type("03");
		List<AdBoardVo> list = adBoardService.getBoardList(adBoardVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = adBoardService.getBoardCount(adBoardVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		adBoardVo.setReg_id(loginvo.getId());		
		model.addAttribute("adBoardVo",   adBoardVo);
		model.addAttribute("path",      request.getServletPath());

		return "faqList";
	}
	
	@RequestMapping(value = "/faqReq.do")
	public String faqReq(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model) throws Exception {

		if(adBoardVo.getBoard_idx() != null) {
			adBoardVo.setBoard_type("03");
			AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
			if(detailData != null ) {
				List<BoardVo> files = adBoardService.selectFileList(adBoardVo);
				model.addAttribute("resultFileList", files);
			}
			model.addAttribute("detailData",  detailData);
		}

		return "faqReq";
	}
	
	@RequestMapping(value = "/partiList.do")
	public String partiList(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model, HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		/** EgovPropertyService.sample */
		adBoardVo.setPageUnit(propertiesService.getInt("pageUnit"));
		adBoardVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(adBoardVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(adBoardVo.getPageUnit());
		paginationInfo.setPageSize(adBoardVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		adBoardVo.setOffset(offset);
		adBoardVo.setBoard_type("04");
		List<AdBoardVo> list = adBoardService.getBoardList(adBoardVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = adBoardService.getBoardCount(adBoardVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		adBoardVo.setReg_id(loginvo.getId());		
		model.addAttribute("adBoardVo",   adBoardVo);
		model.addAttribute("path",      request.getServletPath());

		return "partiList";
	}
	
	@RequestMapping(value = "/partiReq.do")
	public String partiReq(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model) throws Exception {

		if(adBoardVo.getBoard_idx() != null) {
			adBoardVo.setBoard_type("04");
			AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
			if(detailData != null ) {
				List<BoardVo> files = adBoardService.selectFileList(adBoardVo);
				model.addAttribute("resultFileList", files);
			}
			model.addAttribute("detailData",  detailData);
		}

		return "partiReq";
	}
	
	@RequestMapping(value = "/instructList.do")
	public String instructList(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model, HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		/** EgovPropertyService.sample */
		adBoardVo.setPageUnit(propertiesService.getInt("pageUnit"));
		adBoardVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(adBoardVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(adBoardVo.getPageUnit());
		paginationInfo.setPageSize(adBoardVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		adBoardVo.setOffset(offset);
		adBoardVo.setBoard_type("05");
		List<AdBoardVo> list = adBoardService.getBoardList(adBoardVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = adBoardService.getBoardCount(adBoardVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		adBoardVo.setReg_id(loginvo.getId());		
		model.addAttribute("adBoardVo",   adBoardVo);
		model.addAttribute("path",      request.getServletPath());

		return "instructList";
	}
	
	@RequestMapping(value = "/instructReq.do")
	public String instructReq(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model) throws Exception {

		if(adBoardVo.getBoard_idx() != null) {
			adBoardVo.setBoard_type("05");
			AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
			if(detailData != null ) {
				List<BoardVo> files = adBoardService.selectFileList(adBoardVo);
				model.addAttribute("resultFileList", files);
			}
			model.addAttribute("detailData",  detailData);
		}

		return "instructReq";
	}
	
	@RequestMapping(value = "/instructReferList.do")
	public String instructReferList(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model, HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		/** EgovPropertyService.sample */
		adBoardVo.setPageUnit(propertiesService.getInt("pageUnit"));
		adBoardVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(adBoardVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(adBoardVo.getPageUnit());
		paginationInfo.setPageSize(adBoardVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		adBoardVo.setOffset(offset);
		adBoardVo.setBoard_type("06");
		List<AdBoardVo> list = adBoardService.getBoardList(adBoardVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = adBoardService.getBoardCount(adBoardVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		adBoardVo.setReg_id(loginvo.getId());		
		model.addAttribute("adBoardVo",   adBoardVo);
		model.addAttribute("path",      request.getServletPath());

		return "instructReferList";
	}
	
	@RequestMapping(value = "/instructReferReq.do")
	public String instructReferReq(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model) throws Exception {

		if(adBoardVo.getBoard_idx() != null) {
			adBoardVo.setBoard_type("06");
			AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
			if(detailData != null ) {
				List<BoardVo> files = adBoardService.selectFileList(adBoardVo);
				model.addAttribute("resultFileList", files);
			}
			model.addAttribute("detailData",  detailData);
		}

		return "instructReferReq";
	}
	
	@RequestMapping({"/fileDownload.do"})
	@ResponseBody
	public void fileDownload(HttpServletRequest request, HttpServletResponse response, BoardVo boardVo) throws Exception {
		boardVo = adBoardService.selectFile(boardVo);
		
	    BoardVo boardVoForm = new BoardVo();
	    boardVoForm.setFile_uuid(boardVo.getFile_uuid());
	    boardVoForm.setFile_name(boardVo.getFile_name());
	    boardVoForm.setFile_full_path(boardVo.getFile_full_path());
	    boardVoForm.setFile_size(boardVo.getFile_size());	 
	
	    FileUtil.fileDownload(request, response, boardVoForm);
	}

}
