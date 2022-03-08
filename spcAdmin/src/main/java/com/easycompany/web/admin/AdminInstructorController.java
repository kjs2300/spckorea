package com.easycompany.web.admin;

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
import com.easycompany.service.SectorService;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping({"inst"})
public class AdminInstructorController
{
  @Autowired
  private InstructorService instructorService;
  
  @Autowired
  private SectorService sectorService;
  
  @Autowired
  protected EgovPropertyService propertiesService;

  @Value("#{dbinfo['file.path']}")
  private String filePath;

  @Value("#{dbinfo['web.path']}")
  private String webPath;

  
  @RequestMapping({"/instructorAdm01List.do"})
  public String instructorAdm01List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  paramMap.put("pageUnit", this.propertiesService.getInt("pageUnit"));
	  paramMap.put("pageSize", this.propertiesService.getInt("pageSize"));
	  paramMap.put("recordCountPerPage", vo.getRecordCountPerPage());
	  
	  PaginationInfo paginationInfo = new PaginationInfo();
	  paginationInfo.setCurrentPageNo(vo.getPageIndex());
	  paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("pageUnit").toString()));
	  paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
	  
	  int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	  paramMap.put("offset",offset);
	    
	  paramMap.put("sqlName", "getCategoryList1");
	  List<Map<String, Object>> category1list = sectorService.getSelectList(paramMap);
	  model.addAttribute("category1list", category1list);
	  	  
	  paramMap.put("sqlName", "getCategoryList2");
	  List<Map<String, Object>> category2list = sectorService.getSelectList(paramMap);
	  model.addAttribute("category2list", category2list);
	  
	  paramMap.put("sqlName", "getCategoryList3");
	  List<Map<String, Object>> category3list = sectorService.getSelectList(paramMap);
	  model.addAttribute("category3list", category3list);
	  
	  paramMap.put("sqlName", "getSectorList");
	  List<Map<String, Object>> list = sectorService.getSelectList(paramMap);
	  model.addAttribute("resultList", list);
	  
	  paramMap.put("sqlName", "getSectorListCnt");
	  int totCnt = sectorService.getSelectListCnt(paramMap);
	  model.addAttribute("totCnt", totCnt);
	  paginationInfo.setTotalRecordCount(totCnt);
	  
	  model.addAttribute("paginationInfo", paginationInfo);
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructorAdm01List";
  }
  
  @RequestMapping({"/instructorAdm01View.do"})
  public String instructorAdm01View(@RequestParam Map<String, Object> paramMap, ModelMap model ,HttpServletRequest request) throws Exception {
	    paramMap.put("board_type","05"); 	 
	    paramMap.put("sqlName", "getBoardView");	
		Map<String, Object> result = instructorService.getSelectData(paramMap);
	  	model.addAttribute("result", result);
		model.addAttribute("path", request.getServletPath());
	    model.addAllAttributes(paramMap);
		return "instructorAdm01View";
  }
  
  @RequestMapping({"/instructorAdm02List.do"})
  public String instructorAdm02List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructorAdm02List";
  }
  
  @RequestMapping({"/instructorAdm03List.do"})
  public String instructorAdm03List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructorAdm03List";
  }
  
  @RequestMapping({"/instructorAdm04List.do"})
  public String instructorAdm04List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructorAdm04List";
  }
  
  @RequestMapping({"/instructorAdm04lecture.do"})
  public String instructorAdm04lecture(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructorAdm04lecture";
  }
  
  @RequestMapping({"/instructorAdm04absence.do"})
  public String instructorAdm04absence(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructorAdm04absence";
  }
  
  @RequestMapping({"/instructorAdm05List.do"})
  public String instructorAdm05List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "instructorAdm05List";
  }
}