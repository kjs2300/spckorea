package com.easycompany.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.out.println("+++++++++++++++++++++++++++"+adBoardVo.getBoard_idx());
		if(adBoardVo.getBoard_idx() != null) {
			AdBoardVo detailData = adBoardService.selectDetailBoard(adBoardVo);
			model.addAttribute("detailData",  detailData);
		}
		return "noticeReq";
	}
	
	@RequestMapping(value = "/referenceList.do")
	public String getReferenceList(@ModelAttribute("searchVO") DefaultVO searchVo, ModelMap model) throws Exception {

//		/** EgovPropertyService.sample */
//		searchVo.setPageUnit(propertiesService.getInt("pageUnit"));
//		searchVo.setPageSize(propertiesService.getInt("pageSize"));
//		
//		/** pageing setting */
//		PaginationInfo paginationInfo = new PaginationInfo();
//		paginationInfo.setCurrentPageNo(searchVo.getPageIndex());
//		paginationInfo.setRecordCountPerPage(searchVo.getPageUnit());
//		paginationInfo.setPageSize(searchVo.getPageSize());
//		
//		/***  offSet 설정  ***/
//		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
//		searchVo.setOffset(offset);
//		
//		List<BoardVo> list = boardService.getBoardList(searchVo);
//		model.addAttribute("resultList", list);
//			
//		
//		int totCnt = boardService.getBoardCount(searchVo);
//		paginationInfo.setTotalRecordCount(totCnt);
//		model.addAttribute("paginationInfo", paginationInfo);

		return "referenceList";
	}
	
	@RequestMapping(value = "/referenceReq.do")
	public String referenceReq(@ModelAttribute("searchVO") DefaultVO searchVo, ModelMap model) throws Exception {

//		/** EgovPropertyService.sample */
//		searchVo.setPageUnit(propertiesService.getInt("pageUnit"));
//		searchVo.setPageSize(propertiesService.getInt("pageSize"));
//		
//		/** pageing setting */
//		PaginationInfo paginationInfo = new PaginationInfo();
//		paginationInfo.setCurrentPageNo(searchVo.getPageIndex());
//		paginationInfo.setRecordCountPerPage(searchVo.getPageUnit());
//		paginationInfo.setPageSize(searchVo.getPageSize());
//		
//		/***  offSet 설정  ***/
//		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
//		searchVo.setOffset(offset);
//		
//		List<BoardVo> list = boardService.getBoardList(searchVo);
//		model.addAttribute("resultList", list);
//			
//		
//		int totCnt = boardService.getBoardCount(searchVo);
//		paginationInfo.setTotalRecordCount(totCnt);
//		model.addAttribute("paginationInfo", paginationInfo);

		return "referenceReq";
	}
	
	@RequestMapping(value = "/faqList.do")
	public String faqList(@ModelAttribute("searchVO") DefaultVO searchVo, ModelMap model) throws Exception {

//		/** EgovPropertyService.sample */
//		searchVo.setPageUnit(propertiesService.getInt("pageUnit"));
//		searchVo.setPageSize(propertiesService.getInt("pageSize"));
//		
//		/** pageing setting */
//		PaginationInfo paginationInfo = new PaginationInfo();
//		paginationInfo.setCurrentPageNo(searchVo.getPageIndex());
//		paginationInfo.setRecordCountPerPage(searchVo.getPageUnit());
//		paginationInfo.setPageSize(searchVo.getPageSize());
//		
//		/***  offSet 설정  ***/
//		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
//		searchVo.setOffset(offset);
//		
//		List<BoardVo> list = boardService.getBoardList(searchVo);
//		model.addAttribute("resultList", list);
//			
//		
//		int totCnt = boardService.getBoardCount(searchVo);
//		paginationInfo.setTotalRecordCount(totCnt);
//		model.addAttribute("paginationInfo", paginationInfo);

		return "faqList";
	}
	
	@RequestMapping(value = "/faqReq.do")
	public String faqReq(@ModelAttribute("searchVO") DefaultVO searchVo, ModelMap model) throws Exception {

//		/** EgovPropertyService.sample */
//		searchVo.setPageUnit(propertiesService.getInt("pageUnit"));
//		searchVo.setPageSize(propertiesService.getInt("pageSize"));
//		
//		/** pageing setting */
//		PaginationInfo paginationInfo = new PaginationInfo();
//		paginationInfo.setCurrentPageNo(searchVo.getPageIndex());
//		paginationInfo.setRecordCountPerPage(searchVo.getPageUnit());
//		paginationInfo.setPageSize(searchVo.getPageSize());
//		
//		/***  offSet 설정  ***/
//		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
//		searchVo.setOffset(offset);
//		
//		List<BoardVo> list = boardService.getBoardList(searchVo);
//		model.addAttribute("resultList", list);
//			
//		
//		int totCnt = boardService.getBoardCount(searchVo);
//		paginationInfo.setTotalRecordCount(totCnt);
//		model.addAttribute("paginationInfo", paginationInfo);

		return "faqReq";
	}

}
