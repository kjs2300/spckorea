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
import com.easycompany.service.MyService;
import com.easycompany.service.SectorService;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping({"my"})
public class MyController
{

  @Autowired
  private MyService myService;
  
  @Autowired
  private SectorService sectorService;
  
  @Autowired
  protected EgovPropertyService propertiesService;

  @Value("#{dbinfo['file.path']}")
  private String filePath;

  @Value("#{dbinfo['web.path']}")
  private String webPath;

  /*
   * 사용자 페이지 > 분야별 교육신청 > 교육신청
   */
  @RequestMapping({"/my01info.do"})
  public String my01info(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  return "my01info";
  }

  @RequestMapping({"/my01cart.do"})
  public String my01cart(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  paramMap.put("pageUnit", this.propertiesService.getInt("pageUnit"));
	  paramMap.put("pageSize", this.propertiesService.getInt("pageSize"));
	  paramMap.put("recordCountPerPage", vo.getRecordCountPerPage());
	  paramMap.put("UserAccount", request.getSession().getAttribute("UserAccount"));
	  
	  PaginationInfo paginationInfo = new PaginationInfo();
	  paginationInfo.setCurrentPageNo(vo.getPageIndex());
	  paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("pageUnit").toString()));
	  paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
	  
	  int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	  paramMap.put("offset",offset);
	    	  
	  paramMap.put("category1_key", "1");//일반:1,강사:3,실무자:2
	  paramMap.put("sqlName", "getCartList");
	  List<Map<String, Object>> list = myService.getSelectList(paramMap);
	  model.addAttribute("resultList", list);
	  
	  paramMap.put("sqlName", "getCartListCnt");
	  int totCnt = myService.getSelectListCnt(paramMap);
	  model.addAttribute("totCnt", totCnt);
	  paginationInfo.setTotalRecordCount(totCnt);
	  
	  model.addAttribute("paginationInfo", paginationInfo);
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  return "my01cart";
  }
  
  @RequestMapping({"/cartDel.do"})
  @ResponseBody
  public String cartDel(HttpServletRequest request, @RequestParam(value="basket_no[]") List<Long> basketList, @RequestParam Map<String, Object> paramMap) throws Exception {
		int resultCnt = 0;
		String result = "";
		try {
			paramMap.put("UserAccount", request.getSession().getAttribute("UserAccount"));
			paramMap.put("basketList", basketList); 
			paramMap.put("sqlName", "deleteCart"); 
			resultCnt = myService.deleteData(paramMap);
		    result = (resultCnt > 0 ? "SUCCESS" : "FAIL");
		    
		} catch (Exception e) {
			result = "FAIL";
		}
		
		return result;
	}
  
  @RequestMapping({"/my01status.do"})
  public String my01status(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
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
	  
	  paramMap.put("sqlName", "getStatusList");
	  List<Map<String, Object>> list = myService.getSelectList(paramMap);
	  model.addAttribute("resultList", list);
	  
	  paramMap.put("sqlName", "getStatusListCnt");
	  int totCnt = myService.getSelectListCnt(paramMap);
	  model.addAttribute("totCnt", totCnt);
	  paginationInfo.setTotalRecordCount(totCnt);
	  
	  model.addAttribute("paginationInfo", paginationInfo);
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  return "my01status";
  }
  
  @RequestMapping({"/my01edu.do"})
  public String my01edu(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
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
	  
	  paramMap.put("sqlName", "getEduList");
	  List<Map<String, Object>> list = myService.getSelectList(paramMap);
	  model.addAttribute("resultList", list);
	  
	  paramMap.put("sqlName", "getEduListCnt");
	  int totCnt = myService.getSelectListCnt(paramMap);
	  model.addAttribute("totCnt", totCnt);
	  paginationInfo.setTotalRecordCount(totCnt);
	  
	  model.addAttribute("paginationInfo", paginationInfo);
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  return "my01edu";
  }
  
  @RequestMapping({"/my01warrant.do"})
  public String my01warrant(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  paramMap.put("pageUnit", this.propertiesService.getInt("pageUnit"));
	  paramMap.put("pageSize", this.propertiesService.getInt("pageSize"));
	  paramMap.put("recordCountPerPage", vo.getRecordCountPerPage());
	  
	  PaginationInfo paginationInfo = new PaginationInfo();
	  paginationInfo.setCurrentPageNo(vo.getPageIndex());
	  paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("pageUnit").toString()));
	  paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
	  
	  int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	  paramMap.put("offset",offset);
	    	  
	  paramMap.put("sqlName", "getMyList");
	  List<Map<String, Object>> list = myService.getSelectList(paramMap);
	  model.addAttribute("resultList", list);
	  
	  paramMap.put("sqlName", "getMyListCnt");
	  int totCnt = myService.getSelectListCnt(paramMap);
	  model.addAttribute("totCnt", totCnt);
	  paginationInfo.setTotalRecordCount(totCnt);
	  
	  model.addAttribute("paginationInfo", paginationInfo);
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  
	  return "my01warrant";
  }
  
  @RequestMapping({"/my01mylist.do"})
  public String my01mylist(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model, HttpServletRequest request) throws Exception{
	  paramMap.put("pageUnit", this.propertiesService.getInt("pageUnit"));
	  paramMap.put("pageSize", this.propertiesService.getInt("pageSize"));
	  paramMap.put("recordCountPerPage", vo.getRecordCountPerPage());
	  
	  PaginationInfo paginationInfo = new PaginationInfo();
	  paginationInfo.setCurrentPageNo(vo.getPageIndex());
	  paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("pageUnit").toString()));
	  paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
	  
	  int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	  paramMap.put("offset",offset);
	    	  
	  paramMap.put("sqlName", "getMyList");
	  List<Map<String, Object>> list = myService.getSelectList(paramMap);
	  model.addAttribute("resultList", list);
	  
	  paramMap.put("sqlName", "getMyListCnt");
	  int totCnt = myService.getSelectListCnt(paramMap);
	  model.addAttribute("totCnt", totCnt);
	  paginationInfo.setTotalRecordCount(totCnt);
	  
	  model.addAttribute("paginationInfo", paginationInfo);
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	  
	  
	  return "my01mylist";
  }
  
  @RequestMapping({"/popMyClass.do"})
  public String popMyClass(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model ,HttpServletRequest request)  throws Exception {
	  
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	
	    return "popMyClass";
  }
  
  @RequestMapping({"/popMyPlayer.do"})
  public String popMyPlayer(@RequestParam Map<String, Object> paramMap, DefaultVO vo, ModelMap model ,HttpServletRequest request)  throws Exception {
	  paramMap.put("UserAccount", request.getSession().getAttribute("UserAccount"));
	  paramMap.put("sqlName", "getOnclassTime");
	  model.addAttribute("result", myService.getSelectData(paramMap));
	  
	  model.addAttribute("path", request.getServletPath());
	  model.addAllAttributes(paramMap);
	
	    return "popMyPlayer";
  }
  
  @RequestMapping({"/onclassUpdate.do"})
  @ResponseBody
  public Map<String, Object> sectorSave(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) throws Exception {
	    int resultCnt = 0;
	    Map<String, Object> result = new HashMap<String, Object>();
	    try {
	      paramMap.put("UserAccount", request.getSession().getAttribute("UserAccount"));
	      paramMap.put("sqlName", "onclassUpdate");	
    	  
	      resultCnt = myService.updateData(paramMap);
	      
	      if(resultCnt < 1) {
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