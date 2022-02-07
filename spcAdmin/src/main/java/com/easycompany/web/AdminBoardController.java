package com.easycompany.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycompany.cmm.vo.DefaultVO;

@Controller
@RequestMapping("adBoard")
public class AdminBoardController {
	
	@RequestMapping(value = "/noticeList.do")
	public String getNoticeList(@ModelAttribute("searchVO") DefaultVO searchVo, ModelMap model) throws Exception {

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

		return "noticeList";
	}
	
	@RequestMapping(value = "/noticeReq.do")
	public String noticeReq(@ModelAttribute("searchVO") DefaultVO searchVo, ModelMap model) throws Exception {

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

}
