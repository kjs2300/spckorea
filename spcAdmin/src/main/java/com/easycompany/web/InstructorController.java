package com.easycompany.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import com.easycompany.cmm.vo.LoginVo;
import com.easycompany.service.InstructorService;
import com.easycompany.service.vo.AdBoardVo;
import com.easycompany.service.vo.InstructorVo;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("instructor")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	/** EgovPropertyService */
	@Autowired
	protected EgovPropertyService propertiesService;
	
//	@RequestMapping(value = "/instructorList.do")
//	public String instructorList(@ModelAttribute("instructorVo") InstructorVo instructorVo, ModelMap model, HttpServletRequest request) throws Exception {
//
//		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
//		/** EgovPropertyService.sample */
//		instructorVo.setPageUnit(propertiesService.getInt("pageUnit"));
//		instructorVo.setPageSize(propertiesService.getInt("pageSize"));
//		
//		/** pageing setting */
//		PaginationInfo paginationInfo = new PaginationInfo();
//		paginationInfo.setCurrentPageNo(instructorVo.getPageIndex());
//		paginationInfo.setRecordCountPerPage(instructorVo.getPageUnit());
//		paginationInfo.setPageSize(instructorVo.getPageSize());
//		
//		/***  offSet 설정  ***/
//		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
//		instructorVo.setOffset(offset);
//		
//		instructorVo.setBoard_type("01");
//		List<AdBoardVo> list = instructorService.getBoardList(instructorVo);
//		model.addAttribute("resultList", list);
//			
//		
//		int totCnt = instructorService.getBoardCount(instructorVo);
//		paginationInfo.setTotalRecordCount(totCnt);
//		model.addAttribute("paginationInfo", paginationInfo);
//		
//		instructorVo.setReg_id(loginvo.getId());		
//		model.addAttribute("adBoardVo",   instructorVo);
//
//		return "instructorList";
//	}
//	
//	@RequestMapping(value = "/instructorReq.do")
//	public String noticeReq(@ModelAttribute("instructorVo") InstructorVo instructorVo, ModelMap model) throws Exception {
//		if(instructorVo.getBoard_idx() != null) {
//			AdBoardVo detailData = instructorService.selectDetailBoard(instructorVo);
//			model.addAttribute("detailData",  detailData);
//		}
//		return "instructorReq";
//	}

}
