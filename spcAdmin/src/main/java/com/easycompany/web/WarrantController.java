package com.easycompany.web;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.easycompany.service.SectorService;
import com.easycompany.service.WarrantService;
import com.easycompany.service.vo.LmsVo;
import com.easycompany.service.vo.WarrantVo;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("warrant")
public class WarrantController {
	
	@Autowired
	private WarrantService warrantService;
	
	@Autowired
	private SectorService sectorService;
	
	/** EgovPropertyService */
	@Autowired
	protected EgovPropertyService propertiesService;
	
	
	@Value("#{dbinfo['file.path']}")
	private String filePath;
	
	@RequestMapping(value = "/warrantGeneralDefault.do")
	public String warrantGeneralDefault(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request) throws Exception {

		return "warrantGeneralDefault";
	}
	
	@RequestMapping(value = "/warrantOnlineList.do")
	public String warrantOnlineList(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request) throws Exception {
		paramMap.put("pageSize", 10);
		paramMap.put("recordCountPerPage", 10);
		paramMap.put("AdminAccount", request.getSession().getAttribute("AdminAccount"));
		if(!paramMap.containsKey("pageIndex")) {
		  paramMap.put("pageIndex", 1);
		}
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(Integer.parseInt(paramMap.get("pageIndex").toString()));
		paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("recordCountPerPage").toString()));
		paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		  
		int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getRecordCountPerPage();
		paramMap.put("offset",offset);
		  
		paramMap.put("site", "on");
		paramMap.put("sqlName", "getCategoryList1");
		List<Map<String, Object>> category1list = sectorService.getSelectList(paramMap);
		model.addAttribute("category1list", category1list);
		
		paramMap.put("sqlName", "getCategoryList2");
		List<Map<String, Object>> category2list = sectorService.getSelectList(paramMap);
		model.addAttribute("category2list", category2list);
		  
		paramMap.put("sqlName", "getCategoryList3");
		List<Map<String, Object>> category3list = sectorService.getSelectList(paramMap);
		model.addAttribute("category3list", category3list);
		
		paramMap.put("license_type", "A");
		paramMap.put("sqlName", "warrantOnlineList");
		List<Map<String, Object>> list = warrantService.getSelectList(paramMap);
		model.addAttribute("resultList", list);
		  
		paramMap.put("sqlName", "warrantOnlineListCnt");
		int totCnt = warrantService.getSelectListCnt(paramMap);
		model.addAttribute("totCnt", totCnt);
		paginationInfo.setTotalRecordCount(totCnt);

		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("path", request.getServletPath());
		model.addAllAttributes(paramMap);
		  
		return "warrantOnlineList";
	}
	
	@RequestMapping(value = "/warrantOnlineReq.do")
	public String warrantOnlineReq(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request) throws Exception {
		paramMap.put("site", "on");
		paramMap.put("sqlName", "getCategoryList1");
		List<Map<String, Object>> category1list = sectorService.getSelectList(paramMap);
		model.addAttribute("category1list", category1list);
		if(paramMap.get("actFlag") == "U") {
			paramMap.put("license_type", "A");
			paramMap.put("sqlName", "selectDetailOnline");	
			Map<String, Object> result = warrantService.getSelectData(paramMap);
		  	model.addAttribute("result", result);
		}
		model.addAttribute("path", request.getServletPath());
		model.addAllAttributes(paramMap);
		return "warrantOnlineReq";
	}
	
	@RequestMapping(value = "/warrantSave.do")
	@ResponseBody
	public Map<String, Object> warrantSave(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) throws Exception {
		int resultCnt = 0;
		 Map<String, Object> result = new HashMap<String, Object>();
		try {
			
			paramMap.put("AdminAccount", request.getSession().getAttribute("AdminAccount"));
			
			
			if ("I".equals(paramMap.get("actFlag").toString())) { // 저장
				paramMap.put("sqlName", "warrantSave");
				resultCnt = warrantService.insertData(paramMap);
				
			} else if("E".equals(paramMap.get("actFlag").toString())) { // 수정
				paramMap.put("sqlName", "warrantUpdate");
				resultCnt = warrantService.updateData(paramMap);
			}
//			
		} catch (Exception e) {
			result.put("result", "FAIL");	 
		}
		result.put("result",resultCnt > 0 ? "SUCCESS" : "FAIL");
		return result;
	}
	
	@RequestMapping(value = "/warrantOfflineList.do")
	public String warrantOfflineList(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request) throws Exception {
		paramMap.put("pageSize", 10);
		paramMap.put("recordCountPerPage", 10);
		paramMap.put("AdminAccount", request.getSession().getAttribute("AdminAccount"));
		if(!paramMap.containsKey("pageIndex")) {
		  paramMap.put("pageIndex", 1);
		}
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(Integer.parseInt(paramMap.get("pageIndex").toString()));
		paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("recordCountPerPage").toString()));
		paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		  
		int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getRecordCountPerPage();
		paramMap.put("offset",offset);
		  
		paramMap.put("site", "on");
		paramMap.put("sqlName", "getCategoryList1");
		List<Map<String, Object>> category1list = sectorService.getSelectList(paramMap);
		model.addAttribute("category1list", category1list);
		
		paramMap.put("sqlName", "getCategoryList2");
		List<Map<String, Object>> category2list = sectorService.getSelectList(paramMap);
		model.addAttribute("category2list", category2list);
		  
		paramMap.put("sqlName", "getCategoryList3");
		List<Map<String, Object>> category3list = sectorService.getSelectList(paramMap);
		model.addAttribute("category3list", category3list);
		
		paramMap.put("license_type", "B");
		paramMap.put("sqlName", "warrantOnlineList");
		List<Map<String, Object>> list = warrantService.getSelectList(paramMap);
		model.addAttribute("resultList", list);
		  
		paramMap.put("sqlName", "warrantOnlineListCnt");
		int totCnt = warrantService.getSelectListCnt(paramMap);
		model.addAttribute("totCnt", totCnt);
		paginationInfo.setTotalRecordCount(totCnt);

		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("path", request.getServletPath());
		model.addAllAttributes(paramMap);
		
		return "warrantOfflineList";
	}
	@RequestMapping(value = "/warrantOfflineReq.do")
	public String warrantOfflineReq(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request) throws Exception {
		paramMap.put("site", "on");
		paramMap.put("sqlName", "getCategoryList1");
		List<Map<String, Object>> category1list = sectorService.getSelectList(paramMap);
		model.addAttribute("category1list", category1list);
		if(paramMap.get("actFlag") == "U") {
			paramMap.put("license_type", "B");
			paramMap.put("sqlName", "selectDetailOnline");	
			Map<String, Object> result = warrantService.getSelectData(paramMap);
		  	model.addAttribute("result", result);
		}
		model.addAttribute("path", request.getServletPath());
		model.addAllAttributes(paramMap);
		return "warrantOfflineReq";
	}
	
	@RequestMapping(value = "/warrantOrgList.do")
	public String warrantOrgList(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request) throws Exception {
		paramMap.put("pageSize", 10);
		paramMap.put("recordCountPerPage", 10);
		paramMap.put("AdminAccount", request.getSession().getAttribute("AdminAccount"));
		if(!paramMap.containsKey("pageIndex")) {
		  paramMap.put("pageIndex", 1);
		}
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(Integer.parseInt(paramMap.get("pageIndex").toString()));
		paginationInfo.setRecordCountPerPage(Integer.parseInt(paramMap.get("recordCountPerPage").toString()));
		paginationInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		  
		int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getRecordCountPerPage();
		paramMap.put("offset",offset);
		  
		paramMap.put("site", "on");
		paramMap.put("sqlName", "getCategoryList1");
		List<Map<String, Object>> category1list = sectorService.getSelectList(paramMap);
		model.addAttribute("category1list", category1list);
		
		paramMap.put("sqlName", "getCategoryList2");
		List<Map<String, Object>> category2list = sectorService.getSelectList(paramMap);
		model.addAttribute("category2list", category2list);
		  
		paramMap.put("sqlName", "getCategoryList3");
		List<Map<String, Object>> category3list = sectorService.getSelectList(paramMap);
		model.addAttribute("category3list", category3list);
		  
		paramMap.put("license_type", "C");
		paramMap.put("sqlName", "warrantOnlineList");
		List<Map<String, Object>> list = warrantService.getSelectList(paramMap);
		model.addAttribute("resultList", list);
		  
		paramMap.put("sqlName", "warrantOnlineListCnt");
		int totCnt = warrantService.getSelectListCnt(paramMap);
		model.addAttribute("totCnt", totCnt);
		paginationInfo.setTotalRecordCount(totCnt);

		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("path", request.getServletPath());
		model.addAllAttributes(paramMap);

		return "warrantOrgList";
	}
	@RequestMapping(value = "/warrantOrgReq.do")
	public String warrantOrgReq(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request) throws Exception {
		paramMap.put("site", "on");
		paramMap.put("sqlName", "getCategoryList1");
		List<Map<String, Object>> category1list = sectorService.getSelectList(paramMap);
		model.addAttribute("category1list", category1list);
		if(paramMap.get("actFlag") == "U") {
			paramMap.put("license_type", "C");
			paramMap.put("sqlName", "selectDetailOnline");	
			Map<String, Object> result = warrantService.getSelectData(paramMap);
		  	model.addAttribute("result", result);
		}
		model.addAttribute("path", request.getServletPath());
		model.addAllAttributes(paramMap);
		
		return "warrantOrgReq";
	}
	
	@RequestMapping(value = "/warrantDel.do")
	@ResponseBody
	public String warrantDel(HttpServletRequest request, @RequestParam(value="boardIdxArray[]") List<String> boardIdxStrArray) throws Exception {
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
		    
		    map.put("sqlName", "warrantDel");
		    resultCnt = warrantService.deleteData(map);
		    result = (resultCnt > 0 ? "SUCCESS" : "FAIL");
		    
		} catch (Exception e) {
			result = "FAIL";
		}
		
		return result;
	}

}
