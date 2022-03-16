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
	  paramMap.put("pageSize", 10);
	  paramMap.put("recordCountPerPage", 10);
	  paramMap.put("UserAccount", request.getSession().getAttribute("UserAccount"));
	  if(!paramMap.containsKey("pageIndex")) {
		  paramMap.put("pageIndex", 1);
	  }
	  PaginationInfo paginationInfo = new PaginationInfo();
	  paginationInfo.setCurrentPageNo(Integer.parseInt(paramMap.get("pageIndex").toString()));
	  paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("recordCountPerPage").toString()));
	  paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
	  
	  int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getRecordCountPerPage();
	  paramMap.put("offset",offset);
	  paramMap.put("site","");
	  paramMap.put("sqlName", "getCategoryList1");
	  List<Map<String, Object>> category1list = sectorService.getSelectList(paramMap);
	  model.addAttribute("category1list", category1list);
	  	  
	  paramMap.put("sqlName", "getCategoryList2");
	  List<Map<String, Object>> category2list = sectorService.getSelectList(paramMap);
	  model.addAttribute("category2list", category2list);
	  
	  paramMap.put("sqlName", "getCategoryList3");
	  List<Map<String, Object>> category3list = sectorService.getSelectList(paramMap);
	  model.addAttribute("category3list", category3list);
	  
	  paramMap.put("sqlName", "getCodeList");
	  paramMap.put("code","32");
	  List<Map<String, Object>> codeList = instructorService.getSelectList(paramMap);
	  model.addAttribute("codeList", codeList);
	  
	  
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
	  paramMap.put("UserAccount", request.getSession().getAttribute("UserAccount"));  
	  //paramMap.put("sqlName", "getBoardView");	
	  //Map<String, Object> result = instructorService.getSelectData(paramMap);
	  //model.addAttribute("result", result);
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
}