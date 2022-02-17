package com.easycompany.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	/** EgovPropertyService */
	@Autowired
	protected EgovPropertyService propertiesService;
	
	@Value("#{dbinfo['file.path']}")
	private String filePath;
	
	@RequestMapping(value = "/warrantGeneralDefault.do")
	public String warrantGeneralDefault(@ModelAttribute("warrantVo") WarrantVo warrantVo, ModelMap model, HttpServletRequest request) throws Exception {

//		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
//		/** EgovPropertyService.sample */
//		lmsVo.setPageUnit(propertiesService.getInt("pageUnit"));
//		lmsVo.setPageSize(propertiesService.getInt("pageSize"));
//		
//		/** pageing setting */
//		PaginationInfo paginationInfo = new PaginationInfo();
//		paginationInfo.setCurrentPageNo(lmsVo.getPageIndex());
//		paginationInfo.setRecordCountPerPage(lmsVo.getPageUnit());
//		paginationInfo.setPageSize(lmsVo.getPageSize());
//		
//		/***  offSet 설정  ***/
//		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
//		lmsVo.setOffset(offset);
//		
//		List<LmsVo> list = lmsService.contentsList(lmsVo);
//		model.addAttribute("resultList", list);
//			
//		
//		int totCnt = lmsService.contentsListCnt(lmsVo);
//		paginationInfo.setTotalRecordCount(totCnt);
//		model.addAttribute("paginationInfo", paginationInfo);
//		
//		lmsVo.setReg_id(loginvo.getId());		
//		model.addAttribute("lmsVo",   lmsVo);
//		model.addAttribute("path",      request.getServletPath());

		return "warrantGeneralDefault";
	}
	
	@RequestMapping(value = "/warrantOnlineList.do")
	public String warrantOnlineList(@ModelAttribute("warrantVo") WarrantVo warrantVo, ModelMap model, HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		/** EgovPropertyService.sample */
		warrantVo.setPageUnit(propertiesService.getInt("pageUnit"));
		warrantVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(warrantVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(warrantVo.getPageUnit());
		paginationInfo.setPageSize(warrantVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		warrantVo.setOffset(offset);
		
		warrantVo.setLicense_type("A");
		List<WarrantVo> list = warrantService.warrantOnlineList(warrantVo);
		model.addAttribute("resultList", list);
		System.out.println("+++++++++++++++++++++"+list.get(0).getLicense_status());
		
		int totCnt = warrantService.warrantOnlineListCnt(warrantVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		warrantVo.setReg_id(loginvo.getId());		
		model.addAttribute("warrantVo",   warrantVo);
		model.addAttribute("path",      request.getServletPath());

		return "warrantOnlineList";
	}
	@RequestMapping(value = "/warrantOnlineReq.do")
	public String warrantOnlineReq(@ModelAttribute("warrantVo") WarrantVo warrantVo, ModelMap model, HttpServletRequest request) throws Exception {
		if(warrantVo.getLicense_idx() > 0) {
			warrantVo.setLicense_type("A");
			WarrantVo detailData = warrantService.selectDetailOnline(warrantVo);
			model.addAttribute("detailData",  detailData);
			model.addAttribute("path",      request.getServletPath());
		}
		return "warrantOnlineReq";
	}
	
	@RequestMapping(value = "/warrantSave.do")
	@ResponseBody
	public WarrantVo warrantSave(HttpServletRequest request, WarrantVo warrantVo) throws Exception {
		int resultCnt = 0;
		try {
			
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			
			if ("I".equals(warrantVo.getGubun1())) { // 저장
				resultCnt = warrantService.warrantSave(warrantVo);
				
			} else if("E".equals(warrantVo.getGubun1())) { // 수정
				resultCnt = warrantService.warrantUpdate(warrantVo);
			}
//			
		} catch (Exception e) {
			warrantVo.setResult("FAIL");
		}
		warrantVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
		return warrantVo;
	}
	
	@RequestMapping(value = "/warrantOfflineList.do")
	public String warrantOfflineList(@ModelAttribute("warrantVo") WarrantVo warrantVo, ModelMap model, HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		/** EgovPropertyService.sample */
		warrantVo.setPageUnit(propertiesService.getInt("pageUnit"));
		warrantVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(warrantVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(warrantVo.getPageUnit());
		paginationInfo.setPageSize(warrantVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		warrantVo.setOffset(offset);
		
		warrantVo.setLicense_type("B");
		List<WarrantVo> list = warrantService.warrantOnlineList(warrantVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = warrantService.warrantOnlineListCnt(warrantVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		warrantVo.setReg_id(loginvo.getId());		
		model.addAttribute("warrantVo",   warrantVo);
		model.addAttribute("path",      request.getServletPath());

		return "warrantOfflineList";
	}
	@RequestMapping(value = "/warrantOfflineReq.do")
	public String warrantOfflineReq(@ModelAttribute("warrantVo") WarrantVo warrantVo, ModelMap model, HttpServletRequest request) throws Exception {
		if(warrantVo.getLicense_idx() > 0) {
			warrantVo.setLicense_type("B");
			WarrantVo detailData = warrantService.selectDetailOnline(warrantVo);
			model.addAttribute("detailData",  detailData);
			model.addAttribute("path",      request.getServletPath());
		}
		return "warrantOfflineReq";
	}
	
	@RequestMapping(value = "/warrantOrgList.do")
	public String warrantOrgList(@ModelAttribute("warrantVo") WarrantVo warrantVo, ModelMap model, HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		/** EgovPropertyService.sample */
		warrantVo.setPageUnit(propertiesService.getInt("pageUnit"));
		warrantVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(warrantVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(warrantVo.getPageUnit());
		paginationInfo.setPageSize(warrantVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		warrantVo.setOffset(offset);
		
		warrantVo.setLicense_type("C");
		List<WarrantVo> list = warrantService.warrantOnlineList(warrantVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = warrantService.warrantOnlineListCnt(warrantVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		warrantVo.setReg_id(loginvo.getId());		
		model.addAttribute("warrantVo",   warrantVo);
		model.addAttribute("path",      request.getServletPath());

		return "warrantOrgList";
	}
	@RequestMapping(value = "/warrantOrgReq.do")
	public String warrantOrgReq(@ModelAttribute("warrantVo") WarrantVo warrantVo, ModelMap model, HttpServletRequest request) throws Exception {
		if(warrantVo.getLicense_idx() > 0) {
			warrantVo.setLicense_type("C");
			WarrantVo detailData = warrantService.selectDetailOnline(warrantVo);
			model.addAttribute("detailData",  detailData);
			model.addAttribute("path",      request.getServletPath());
		}
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
		    
		    resultCnt = warrantService.warrantDel(map);
		    result = (resultCnt > 0 ? "SUCCESS" : "FAIL");
		    
		} catch (Exception e) {
			result = "FAIL";
		}
		
		return result;
	}

}
