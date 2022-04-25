package com.easycompany.web;

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

import com.easycompany.cmm.vo.LoginVo;
import com.easycompany.service.LmsService;
import com.easycompany.service.SectorService;
import com.easycompany.service.vo.LmsVo;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("lms")
public class LmsController {
	
	@Autowired
	private LmsService lmsService;

	@Autowired
	private SectorService sectorService;
	  
	/** EgovPropertyService */
	@Autowired
	protected EgovPropertyService propertiesService;
	
	@Value("#{dbinfo['file.path']}")
	private String filePath;
	
	@RequestMapping(value = "/contentsList.do")
	public String contentsList(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request) throws Exception {
		  paramMap.put("pageSize", 10);
		  paramMap.put("recordCountPerPage", 10);
		  paramMap.put("UserAccount", request.getSession().getAttribute("AdminAccount"));
		  if(!paramMap.containsKey("pageIndex")) {
			  paramMap.put("pageIndex", 1);
		  }
		  PaginationInfo paginationInfo = new PaginationInfo();
		  paginationInfo.setCurrentPageNo(Integer.parseInt(paramMap.get("pageIndex").toString()));
		  paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("recordCountPerPage").toString()));
		  paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		  
		  int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getRecordCountPerPage();
		  paramMap.put("offset",offset);
		
		  paramMap.put("sqlName", "getCategoryList1");
		  paramMap.put("site","on");
		  List<Map<String, Object>> category1list = sectorService.getSelectList(paramMap);
		  model.addAttribute("category1list", category1list);
		  
		  paramMap.put("sqlName", "contentsList");
		  List<Map<String, Object>> list = lmsService.getSelectList(paramMap);
		  model.addAttribute("resultList", list);
			
		  paramMap.put("sqlName", "contentsListCnt");
		  int totCnt = lmsService.getSelectListCnt(paramMap);
		  model.addAttribute("totCnt", totCnt);
		  paginationInfo.setTotalRecordCount(totCnt);
		
		  model.addAttribute("sessionId", request.getSession().getAttribute("UserAccount"));
		  model.addAttribute("paginationInfo", paginationInfo);
		  model.addAttribute("path", request.getServletPath());
		  model.addAllAttributes(paramMap);

		return "contentsList";
	}
	
	@RequestMapping(value = "/contentsReq.do")
	public String noticeReq(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request) throws Exception {
		if(paramMap.get("flag").equals("U")) {			  
		  	paramMap.put("sqlName", "selectDetailLms");	
			Map<String, Object> result = lmsService.getSelectData(paramMap);
		  	model.addAttribute("result", result);
		}
		paramMap.put("sqlName", "getCategoryList1");
		paramMap.put("site","on");
		List<Map<String, Object>> category1list = sectorService.getSelectList(paramMap);
		model.addAttribute("category1list", category1list);
		  
	  	model.addAttribute("path", request.getServletPath());
		model.addAllAttributes(paramMap);
		
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
				//resultCnt = lmsService.contentsSave(lmsVo, file1, file2, request);
				lmsVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
				
			} else if("E".equals(lmsVo.getGubun1())) { // 수정
				//resultCnt = lmsService.updateContents(paramMap);
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
				lmsVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
			}
//			
		} catch (Exception e) {
			lmsVo.setResult("FAIL");
		}
		return lmsVo;
	}
	
	@RequestMapping(value = "/studentList.do")
	public String studentList(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request) throws Exception {
		  paramMap.put("pageSize", 10);
		  paramMap.put("recordCountPerPage", 10);
		  paramMap.put("UserAccount", request.getSession().getAttribute("AdminAccount"));
		  if(!paramMap.containsKey("pageIndex")) {
			  paramMap.put("pageIndex", 1);
		  }
		  PaginationInfo paginationInfo = new PaginationInfo();
		  paginationInfo.setCurrentPageNo(Integer.parseInt(paramMap.get("pageIndex").toString()));
		  paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("recordCountPerPage").toString()));
		  paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		  
		  int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getRecordCountPerPage();
		  paramMap.put("offset",offset);
		
		  paramMap.put("sqlName", "contentsList");
		  List<Map<String, Object>> list = lmsService.getSelectList(paramMap);
		  model.addAttribute("resultList", list);
			
		  paramMap.put("sqlName", "contentsListCnt");
		  int totCnt = lmsService.getSelectListCnt(paramMap);
		  model.addAttribute("totCnt", totCnt);
		  paginationInfo.setTotalRecordCount(totCnt);
		
		  model.addAttribute("sessionId", request.getSession().getAttribute("UserAccount"));
		  model.addAttribute("paginationInfo", paginationInfo);
		  model.addAttribute("path", request.getServletPath());
		  model.addAllAttributes(paramMap);
		  
		return "studentList";
	}

}
