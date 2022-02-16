package com.easycompany.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.easycompany.service.LmsService;
import com.easycompany.service.vo.AdBoardVo;
import com.easycompany.service.vo.BoardVo;
import com.easycompany.service.vo.LmsVo;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("lms")
public class LmsController {
	
	@Autowired
	private LmsService lmsService;
	
	/** EgovPropertyService */
	@Autowired
	protected EgovPropertyService propertiesService;
	
	@Value("#{dbinfo['file.path']}")
	private String filePath;
	
	@RequestMapping(value = "/contentsList.do")
	public String contentsList(@ModelAttribute("lmsVo") LmsVo lmsVo, ModelMap model, HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		/** EgovPropertyService.sample */
		lmsVo.setPageUnit(propertiesService.getInt("pageUnit"));
		lmsVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(lmsVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(lmsVo.getPageUnit());
		paginationInfo.setPageSize(lmsVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		lmsVo.setOffset(offset);
		
		List<LmsVo> list = lmsService.contentsList(lmsVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = lmsService.contentsListCnt(lmsVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		lmsVo.setReg_id(loginvo.getId());		
		model.addAttribute("lmsVo",   lmsVo);
		model.addAttribute("path",      request.getServletPath());

		return "contentsList";
	}
	
	@RequestMapping(value = "/contentsReq.do")
	public String noticeReq(@ModelAttribute("lmsVo") LmsVo lmsVo, ModelMap model, HttpServletRequest request) throws Exception {
		if(lmsVo.getContent_idx() > 0) {
			LmsVo detailData = lmsService.selectDetailLms(lmsVo);
//			if(detailData != null ) {
//				List<BoardVo> files = adBoardService.selectFileList(adBoardVo);
//				model.addAttribute("resultFileList", files);
//			}
			model.addAttribute("detailData",  detailData);
			model.addAttribute("path",      request.getServletPath());
		}
		return "contentsReq";
	}
	
	@RequestMapping(value = "/contentsSave.do")
	@ResponseBody
	public LmsVo contentsSave(HttpServletRequest request, LmsVo lmsVo, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2) throws Exception {
		int resultCnt = 0;
		try {
			
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			ArrayList<String> fileList = new ArrayList<>();
			
			if ("I".equals(lmsVo.getGubun1())) { // 저장
				resultCnt = lmsService.contentsSave(lmsVo, file1, file2);
				
			} else if("E".equals(lmsVo.getGubun1())) { // 수정
//				resultCnt = adBoardService.updateBoard(adBoardVo);
//				String[] ArraysStr = adBoardVo.getCheckdstr().split(",");
//		    	  if(ArraysStr.length >0){
//		    		  BoardVo boardVo = new BoardVo();
//		    		  for (String s : ArraysStr) {
//		    	        	if(!StringUtil.isEmpty(s)) {
//		    	        		boardVo.setFile_seq(Integer.parseInt(s));
//		    	        		BoardVo fileCategoryVo = adBoardService.selectFile(boardVo);
//		    	                fileList.add(fileCategoryVo.getFile_full_path());
//		    	        	}        	
//		    	      }   
//		    	  }
//		          
//		          //파일업로드
//		    	  if (multipartFile !=null && multipartFile.size() > 0) {
//		      		fileSavelist = FileUtil.uploadFileMulti(multipartFile, request, fileAddpath); 
//		      	  }
//		    	  
//		    	  //파일 추가, 정보업데이트
//		          resultCnt = adBoardService.updateBoard(adBoardVo, fileSavelist);
//		          
//		          //성공 시 파일 삭제
//		          if(resultCnt > 0) {
//			       	   if (fileList !=null && fileList.size() > 0) {
//			       		for (String fileFullPath : fileList) {
//			       			FileUtil.deleteFile(request, fileFullPath);
//			            }
//			       	  }
//			      }
//				adBoardVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
			}
//			
		} catch (Exception e) {
			lmsVo.setResult("FAIL");
		}
		return lmsVo;
	}

}
