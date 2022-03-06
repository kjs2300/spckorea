package com.easycompany.web.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easycompany.cmm.vo.DefaultVO;
import com.easycompany.service.InstructorService;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping({"user"})
public class InstructorController
{

  @Autowired
  private InstructorService instructorService;
  
  @Autowired
  protected EgovPropertyService propertiesService;

  @Value("#{dbinfo['file.path']}")
  private String filePath;

  @Value("#{dbinfo['web.path']}")
  private String webPath;

  
  @RequestMapping({"/instructor01List.do"})
  public String instructor01List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  paramMap.put("pageUnit", this.propertiesService.getInt("pageUnit"));
	  paramMap.put("pageSize", this.propertiesService.getInt("pageSize"));
	  paramMap.put("recordCountPerPage", vo.getRecordCountPerPage());
	  
	  PaginationInfo paginationInfo = new PaginationInfo();
	  paginationInfo.setCurrentPageNo(vo.getPageIndex());
	  paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("pageUnit").toString()));
	  paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
	  
	  int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	  paramMap.put("offset",offset);
	  paramMap.put("board_type","05"); 	  
	  paramMap.put("sqlName", "getBoardList");
	  List<Map<String, Object>> list = instructorService.getSelectList(paramMap);
	  model.addAttribute("resultList", list);
	  
	  paramMap.put("sqlName", "getBoardListCnt");
	  int totCnt = instructorService.getSelectListCnt(paramMap);
	  model.addAttribute("totCnt", totCnt);
	  paginationInfo.setTotalRecordCount(totCnt);
	  
	  model.addAttribute("paginationInfo", paginationInfo);
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructor01List";
  }
  
  @RequestMapping({"/instructor01View.do"})
  public String instructor01View(@RequestParam Map<String, Object> paramMap, ModelMap model ,HttpServletRequest request) throws Exception {
	    paramMap.put("board_type","05"); 	 
	    paramMap.put("sqlName", "getBoardView");	
		Map<String, Object> result = instructorService.getSelectData(paramMap);
	  	model.addAttribute("result", result);
		model.addAttribute("path", request.getServletPath());
	    model.addAllAttributes(paramMap);
		return "instructor01View";
  }
  
  @RequestMapping({"/instructor02List.do"})
  public String instructor02List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructor02List";
  }
  
  @RequestMapping({"/instructor03List.do"})
  public String instructor03List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructor03List";
  }
  
  @RequestMapping({"/instructor04List.do"})
  public String instructor04List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructor04List";
  }
  
  @RequestMapping({"/instructor04lecture.do"})
  public String instructor04lecture(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructor04lecture";
  }
  
  @RequestMapping({"/instructor04absence.do"})
  public String instructor04absence(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructor04absence";
  }
  
  @RequestMapping({"/instructor05List.do"})
  public String instructor05List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructor05List";
  }
}