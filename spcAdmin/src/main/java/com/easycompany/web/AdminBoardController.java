package com.easycompany.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.easycompany.cmm.vo.DefaultVO;
import com.easycompany.cmm.vo.LoginVo;
import com.easycompany.service.AdBoardService;
import com.easycompany.service.vo.AdBoardVo;

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

		return "noticeList";
	}
	
	@RequestMapping(value = "/noticeReq.do")
	public String noticeReq(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model) throws Exception {
		if(adBoardVo.getBoard_idx() != null) {
			AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
			model.addAttribute("detailData",  detailData);
		}
		return "noticeReq";
	}
	
	@RequestMapping(value = "/noticeSave.do")
	@ResponseBody
	public AdBoardVo noticeSave(HttpServletRequest request, AdBoardVo adBoardVo) throws Exception {
		int resultCnt = 0;
		try {
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			if ("I".equals(adBoardVo.getGubun1())) { // 저장
				resultCnt = adBoardService.insertBoard(adBoardVo);
				adBoardVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
			} else if("E".equals(adBoardVo.getGubun1())) { // 수정
				resultCnt = adBoardService.updateBoard(adBoardVo);
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

		return "referenceList";
	}
	
	@RequestMapping(value = "/referenceReq.do")
	public String referenceReq(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model) throws Exception {

	if(adBoardVo.getBoard_idx() != null) {
		adBoardVo.setBoard_type("02");
		AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
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

		return "faqList";
	}
	
	@RequestMapping(value = "/faqReq.do")
	public String faqReq(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model) throws Exception {

		if(adBoardVo.getBoard_idx() != null) {
			adBoardVo.setBoard_type("03");
			AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
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
		adBoardVo.setBoard_type("03");
		List<AdBoardVo> list = adBoardService.getBoardList(adBoardVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = adBoardService.getBoardCount(adBoardVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		adBoardVo.setReg_id(loginvo.getId());		
		model.addAttribute("adBoardVo",   adBoardVo);

		return "partiList";
	}
	
	@RequestMapping(value = "/partiReq.do")
	public String partiReq(@ModelAttribute("adBoardVo") AdBoardVo adBoardVo, ModelMap model) throws Exception {

		if(adBoardVo.getBoard_idx() != null) {
			adBoardVo.setBoard_type("03");
			AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
			model.addAttribute("detailData",  detailData);
		}

		return "partiReq";
	}

}
