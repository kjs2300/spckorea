package com.easycompany.web.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.easycompany.cmm.vo.DefaultVO;
import com.easycompany.service.OrgService;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping({"user"})
public class OrgController
{

  @Autowired
  private OrgService orgService;
  
  @Autowired
  protected EgovPropertyService propertiesService;

  @Value("#{dbinfo['file.path']}")
  private String filePath;

  @Value("#{dbinfo['web.path']}")
  private String webPath;

  @RequestMapping({"/org01info.do"})
  public String org01info(@RequestParam Map<String, Object> paramMap, ModelMap model ,HttpServletRequest request) throws Exception {
	  	model.addAttribute("path", request.getServletPath());
	    model.addAllAttributes(paramMap);
		return "org01info";
  }
  
  @RequestMapping({"/org01List.do"})
  public String org01List(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
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
	  
	  paramMap.put("sqlName", "getOrgList");
	  List<Map<String, Object>> list = orgService.getSelectList(paramMap);
	  model.addAttribute("resultList", list);
	  
	  paramMap.put("sqlName", "getOrgListCnt");
	  int totCnt = orgService.getSelectListCnt(paramMap);
	  model.addAttribute("totCnt", totCnt);
	  paginationInfo.setTotalRecordCount(totCnt);
	  
	  model.addAttribute("paginationInfo", paginationInfo);
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "org01List";
  }
    
  @RequestMapping({"/org01Req.do"})
  public String orgView(@RequestParam Map<String, Object> paramMap, ModelMap model ,HttpServletRequest request) throws Exception {
		paramMap.put("sqlName", "getOrgView");	
		Map<String, Object> result = orgService.getSelectData(paramMap);
	  	model.addAttribute("result", result);
	  	model.addAttribute("path", request.getServletPath());
	    model.addAllAttributes(paramMap);
		return "org01Req";
  }
  
  @RequestMapping({"/orgReq.do"})
  public String orgReq(@RequestParam Map<String, Object> paramMap, ModelMap model ,HttpServletRequest request) throws Exception {
		paramMap.put("sqlName", "getOrgView");	
		Map<String, Object> result = orgService.getSelectData(paramMap);
	  	model.addAttribute("result", result);
	  	model.addAttribute("UserAccount", request.getSession().getAttribute("UserAccount"));
	  	model.addAttribute("path", request.getServletPath());
	    model.addAllAttributes(paramMap);
		return "org"+paramMap.get("idx")+"Req";
  }
  
  @RequestMapping({"/orgSaveCheck.do"})
  @ResponseBody
  public Map<String, Object> orgSaveCheck(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) throws Exception {
	    int resultCnt = 0;
	    Map<String, Object> result = new HashMap<String, Object>();
	    try {
	      paramMap.put("UserAccount", request.getSession().getAttribute("UserAccount"));
	      if(paramMap.get("gubun").toString().equals("B")) {
	    	  paramMap.put("sqlName", "getBasketCheck");	
	      }else if(paramMap.get("gubun").toString().equals("R")) {
	    	  paramMap.put("sqlName", "getRegistCheck");	
	      }
	      resultCnt = orgService.getSelectListCnt(paramMap);
	      
	      if(resultCnt == 0) {
	    	  result.put("result", "SUCCESS");
	      }else {
	    	  result.put("result", "FAIL");	 
	      }
	    } catch (Exception e) {
	      result.put("result", "FAIL");
	    }
	
	    return result;
  }
  
  @RequestMapping({"/orgSave.do"})
  @ResponseBody
  public Map<String, Object> orgSave(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) throws Exception {
	    int resultCnt = 0;
	    Map<String, Object> result = new HashMap<String, Object>();
	    try {
	      paramMap.put("UserAccount", request.getSession().getAttribute("UserAccount"));
	      if(paramMap.get("gubun").toString().equals("B")) {
	    	  paramMap.put("sqlName", "basketInsert");	
	      }else if(paramMap.get("gubun").toString().equals("R")) {
	    	  paramMap.put("sqlName", "registInsert");	
	      }
	      resultCnt = orgService.insertData(paramMap);
	      
	      if(resultCnt > 0) {
	    	  result.put("result", "SUCCESS");
	      }else {
	    	  result.put("result", "FAIL");	 
	      }
	    } catch (Exception e) {
	      result.put("result", "FAIL");
	    }
	
	    return result;
  }
}