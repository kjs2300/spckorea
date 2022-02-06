package com.easycompany.web;


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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.easycompany.cmm.util.FileUtil;
import com.easycompany.cmm.util.StringUtil;
import com.easycompany.cmm.vo.LoginVo;
import com.easycompany.service.vo.BoardVo;
import com.easycompany.service.vo.CategoryVo;
import com.easycompany.service.EduService;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("edu")
public class EduController {

	@Autowired
	private EduService eduService;
	
	/** EgovPropertyService */
	@Autowired
	protected EgovPropertyService propertiesService;
	
	@Value("#{dbinfo['file.path']}")
	private String filePath;

	/** admin > 교육안내등록  > List  */
	@RequestMapping(value = "/eduInfoRegList.do")
	public String getEduInfoRegList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception {

		/** EgovPropertyService.sample */
		categoryVo.setPageUnit(propertiesService.getInt("pageUnit"));
		categoryVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
		paginationInfo.setPageSize(categoryVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		categoryVo.setOffset(offset);
		
		if ( StringUtil.isEmpty(categoryVo.getGubun1())) {
			categoryVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
			categoryVo.setGubun2("category");
		}
		
		List<CategoryVo> list = eduService.getCategoryList(categoryVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = eduService.getCategoryCount(categoryVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "eduInfoRegList";
	}

	/** admin > 교육안내등록  > List  */
	@RequestMapping(value = "/eduInfoRegCate.do")
	public String getEduInfoRegCate(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception {

		if ( StringUtil.isEmpty(categoryVo.getGubun1())) {
			categoryVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
			categoryVo.setGubun2("category1");
		}
		
		/** EgovPropertyService.sample */
		categoryVo.setPageUnit(propertiesService.getInt("pageUnit"));
		categoryVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
		paginationInfo.setPageSize(categoryVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		categoryVo.setOffset(offset);
		
		List<CategoryVo> list = eduService.getCategoryList(categoryVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = eduService.getCategoryCount(categoryVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("categoryVo",     categoryVo);

		return "eduInfoRegCate";
	}
	
	@RequestMapping(value = "/eduInfoRegCateSave.do")
	@ResponseBody
	public CategoryVo eduInfoRegCateSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
		
		int resultCnt = 0;
		
		try {
			
			
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			categoryVo.setReg_id(loginvo.getId());
		
			if("I".equals(categoryVo.getGubun1())){

				resultCnt = eduService.getCategoryExist(categoryVo);
	
				
				if(resultCnt ==1) {
					categoryVo.setResult("EXIST");
				}else {
					resultCnt = eduService.insertCatgegory(categoryVo);				
					categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;		
				}
				
			}
			
			if("E".equals(categoryVo.getGubun1())){
				
				resultCnt = eduService.updateCategory(categoryVo);				
				categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;	
			}

			if("D".equals(categoryVo.getGubun1())){
				resultCnt = eduService.deleteCategory(categoryVo);				
				categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;	
			}
			
			
		} catch (Exception e) {
			categoryVo.setResult("FAIL");
		}
		
		return categoryVo;
	}
	
	/** admin > 교육안내등록  > List  */
	@RequestMapping(value = "/eduInfoRegCate3.do")
	public String getEduInfoRegCate3(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception {

		if ( StringUtil.isEmpty(categoryVo.getGubun1())) {
			categoryVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
			categoryVo.setGubun2("category3");
		}
		
		CategoryVo categoryForm = eduService.getCategoryDetail(categoryVo);
	
		model.addAttribute("categoryVo",    categoryVo);
		model.addAttribute("categoryForm",  categoryForm);

		return "eduInfoRegCate3";
	}
	
	
	@RequestMapping(value = "/eduInfoRegCate3Save.do")
	@ResponseBody
	public CategoryVo eduInfoRegCate3Save(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
		
		int resultCnt = 0;
		
		try {
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			categoryVo.setReg_id(loginvo.getId());
			categoryVo.setGubun2("category3");
			
			if("I".equals(categoryVo.getGubun1())) {
				//fileUpload
				BoardVo fileVo= FileUtil.uploadFile ( request,  filePath);
				
				categoryVo.setFile_uuid(fileVo.getFile_uuid());
				categoryVo.setFile_name(fileVo.getFile_name());
				categoryVo.setFile_full_path(fileVo.getFile_full_path());
				categoryVo.setFile_size(fileVo.getFile_size());
				resultCnt = eduService.insertCatgegory3(categoryVo);
			}
			
			if("E".equals(categoryVo.getGubun1())) {
				resultCnt = eduService.updateCategory(categoryVo);
			}

			if("D".equals(categoryVo.getGubun1())) {
				resultCnt = eduService.deleteCategory(categoryVo);
			}
			
		    categoryVo.setResult((resultCnt > 0 ? "SUCCESS" : "FAIL") );

			
		} catch (Exception e) {
			categoryVo.setResult("FAIL");
		}
		
		return categoryVo;
	}
	
	/** admin > 교육안내등록  > List  */
	@RequestMapping(value = "/eduInfoScheduleList.do")
	public String eduInfoScheduleList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model,HttpServletRequest request) throws Exception {
		
		/** EgovPropertyService.sample */
		categoryVo.setPageUnit(propertiesService.getInt("pageUnit"));
		categoryVo.setPageSize(propertiesService.getInt("pageSize"));
		
		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		categoryVo.setReg_id(loginvo.getId());
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
		paginationInfo.setPageSize(categoryVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		categoryVo.setOffset(offset);
		
		if ( StringUtil.isEmpty(categoryVo.getGubun1())) {
			categoryVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getCheckdate())) {
			categoryVo.setCheckdate("ALL");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
			categoryVo.setGubun2("eduInfoScheduleList");
		}
		
		List<CategoryVo> list = eduService.getCategoryList(categoryVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = eduService.getCategoryCount(categoryVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "eduInfoScheduleList";
	}
	
	/** admin > 교육일정  > 등록  */
	@RequestMapping(value = "/eduInfoScheduleCate.do")
	public String eduInfoScheduleCate(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception {

		if ( StringUtil.isEmpty(categoryVo.getGubun1())) {
			categoryVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
			categoryVo.setGubun2("eduInfoScheduleList");
		}
		
		CategoryVo categoryForm = eduService.getCategoryDetail(categoryVo);
		
		categoryVo.setGubun3("categorycode1");
		
		List<CategoryVo> category1list = eduService.getCategoryCodeList(categoryVo);
	
		model.addAttribute("categoryVo",    categoryVo);
		model.addAttribute("category1list", category1list);
		model.addAttribute("categoryForm",  categoryForm);

		return "eduInfoScheduleCate";
	}
	
	@RequestMapping(value = "/eduInfoScheduleCateSave.do")
	@ResponseBody
	public CategoryVo eduInfoScheduleCateSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
		
		int resultCnt = 0;
		
		try {
			
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			categoryVo.setReg_id(loginvo.getId());
			categoryVo.setGubun2("category3");
			
			if("I".equals(categoryVo.getGubun1())) {
				//fileUpload
				BoardVo fileVo= FileUtil.uploadFile ( request,  filePath);
				
				categoryVo.setFile_uuid(fileVo.getFile_uuid());
				categoryVo.setFile_name(fileVo.getFile_name());
				categoryVo.setFile_full_path(fileVo.getFile_full_path());
				categoryVo.setFile_size(fileVo.getFile_size());
				resultCnt = eduService.insertCatgegory3(categoryVo);
			}
			
			if("E".equals(categoryVo.getGubun1())) {
				resultCnt = eduService.updateCategory(categoryVo);
			}

			if("D".equals(categoryVo.getGubun1())) {
				resultCnt = eduService.deleteCategory(categoryVo);
			}
			
		    categoryVo.setResult((resultCnt > 0 ? "SUCCESS" : "FAIL") );

			
		} catch (Exception e) {
			categoryVo.setResult("FAIL");
		}
		
		return categoryVo;
	}
		

	@RequestMapping(value = "/eduInfoScheduleSave.do")
	@ResponseBody
	public CategoryVo eduInfoScheduleSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
		
		int resultCnt = 0;
		
		try {
			
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			categoryVo.setReg_id(loginvo.getId());
			
			if("I".equals(categoryVo.getGubun1())){
				resultCnt = eduService.insertSchedule(categoryVo);				
				categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;	
			}
			
			if("E".equals(categoryVo.getGubun1())){
				resultCnt = eduService.updateSchedule(categoryVo);				
				categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;	
			}
			
			//전체삭제
			if("A".equals(categoryVo.getGubun1())){
				String[] ArraysStr = categoryVo.getCheckdstr().split(",");
				for(String s : ArraysStr) {
					categoryVo.setEdu_key(Integer.parseInt(s));
					resultCnt = eduService.deleteSchedule(categoryVo);		
				}						
				categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;	
			}
			
			if("D".equals(categoryVo.getGubun1())){
				
				resultCnt = eduService.deleteSchedule(categoryVo);				
				categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;	
			}		
			
			
		} catch (Exception e) {
			categoryVo.setResult("FAIL");
		}
		
		return categoryVo;
	}
	
	@RequestMapping("/excelDownload.do")
	public ModelAndView excelDownload(@ModelAttribute("categoryVo") CategoryVo categoryVo) throws Exception {
		
	
		categoryVo.setRecordCountPerPage(10000);	
		categoryVo.setOffset(0);		
		categoryVo.setGubun1("R");	
		categoryVo.setGubun2("eduInfoScheduleList");
		
		List<CategoryVo> list = eduService.getCategoryList(categoryVo);
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list",     list);
		map.put("filename", categoryVo.getExcelFileName());

		return new ModelAndView("schduleExcelView", map);
	}
	
	@RequestMapping(value = "/eduInfoClassList.do")
	public String eduInfoClassList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception {

		/** EgovPropertyService.sample */
		categoryVo.setPageUnit(propertiesService.getInt("pageUnit"));
		categoryVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
		paginationInfo.setPageSize(categoryVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		categoryVo.setOffset(offset);
		
		if ( StringUtil.isEmpty(categoryVo.getGubun1())) {
			categoryVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
			categoryVo.setGubun2("categoryClass");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getSite())) {
			categoryVo.setSite("on");
		}
		
		List<CategoryVo> list = eduService.getCategoryList(categoryVo);
		model.addAttribute("resultList", list);
		
		int totCnt = eduService.getCategoryCount(categoryVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("categoryVo",     categoryVo);

		return "eduInfoClassList";
	}

	@RequestMapping(value = "/eduInfoClassCate.do")
	public String eduInfoClassCate(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception {

		if ( StringUtil.isEmpty(categoryVo.getGubun1())) {
			categoryVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
			categoryVo.setGubun2("category4");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getSite())) {
			categoryVo.setSite("on");
		}
		
		/** EgovPropertyService.sample */
		categoryVo.setPageUnit(propertiesService.getInt("pageUnit"));
		categoryVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
		paginationInfo.setPageSize(categoryVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		categoryVo.setOffset(offset);
		
		List<CategoryVo> list = eduService.getCategoryList(categoryVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = eduService.getCategoryCount(categoryVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("categoryVo",     categoryVo);

		return "eduInfoClassCate";
	}
	
	@RequestMapping(value = "/eduInfoClassCateSave.do")
	@ResponseBody
	public CategoryVo eduInfoClassCateSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
		
		int resultCnt = 0;
		
		try {
			
			
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			categoryVo.setReg_id(loginvo.getId());
		
			if("I".equals(categoryVo.getGubun1())){

				resultCnt = eduService.getCategoryExist(categoryVo);
	
				
				if(resultCnt ==1) {
					categoryVo.setResult("EXIST");
				}else {
					resultCnt = eduService.insertCatgegory(categoryVo);				
					categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;		
				}
				
			}
			
			if("E".equals(categoryVo.getGubun1())){
				
				resultCnt = eduService.updateCategory(categoryVo);				
				categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;	
			}

			if("D".equals(categoryVo.getGubun1())){
				resultCnt = eduService.deleteCategory(categoryVo);				
				categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;	
			}
			
			
		} catch (Exception e) {
			categoryVo.setResult("FAIL");
		}
		
		return categoryVo;
	}
	
	@RequestMapping(value = "/eduInfoCategoryCodeList.do")
	@ResponseBody
	public List<CategoryVo> eduInfoCategoryCodeList(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
	
		List<CategoryVo> category1list = null;
		try {
			if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
				categoryVo.setGubun2("eduInfoScheduleList");
			}
			if ( StringUtil.isEmpty(categoryVo.getSite())) {
				categoryVo.setSite("on");
			}
			category1list = eduService.getCategoryCodeList(categoryVo);
		} catch (Exception e) {
			categoryVo.setResult("FAIL");
		}
		
		return category1list;
	}
	
	
	@RequestMapping(value = "/eduInfoOnlineList.do")
	public String eduInfoOnlineList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception {

		/** EgovPropertyService.sample */
		categoryVo.setPageUnit(propertiesService.getInt("pageUnit"));
		categoryVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
		paginationInfo.setPageSize(categoryVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		categoryVo.setOffset(offset);
		
		if ( StringUtil.isEmpty(categoryVo.getGubun1())) {
			categoryVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
			categoryVo.setGubun2("eduInfoOnline");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getSite())) {
			categoryVo.setSite("on");
		}
		
		List<CategoryVo> list = eduService.getCategoryList(categoryVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = eduService.getCategoryCount(categoryVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("categoryVo",     categoryVo);

		return "eduInfoClassList";
	}

	@RequestMapping(value = "/eduInfoOnlineReg.do")
	public String eduInfoOnlineReg(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception {

		if ( StringUtil.isEmpty(categoryVo.getGubun1())) {
			categoryVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
			categoryVo.setGubun2("eduInfoOnline");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getSite())) {
			categoryVo.setSite("on");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun1())) {
			categoryVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
			categoryVo.setGubun2("eduInfoOnline");
		}
		
		categoryVo.setGubun3("categorycode1");
		List<CategoryVo> category1list = eduService.getCategoryCodeList(categoryVo);
		model.addAttribute("category1list", category1list);
		
		/*
		CategoryVo categoryForm = eduService.getCategoryDetail(categoryVo);
	
		model.addAttribute("categoryForm",  categoryForm);
		*/
		
		model.addAttribute("categoryVo",    categoryVo);

		return "eduInfoOnlineReg";
	}
	
	@RequestMapping(value = "/eduInfoOnlineSave.do")
	@ResponseBody
	public CategoryVo eduInfoOnlineSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
		
		int resultCnt = 0;
		
		try {
			
			
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			categoryVo.setReg_id(loginvo.getId());
			
			if ( StringUtil.isEmpty(categoryVo.getGubun2())) {
				categoryVo.setGubun2("eduInfoOnline");
			}
			
			if ( StringUtil.isEmpty(categoryVo.getSite())) {
				categoryVo.setSite("on");
			}
		
			if("I".equals(categoryVo.getGubun1())){

				resultCnt = eduService.getCategoryExist(categoryVo);
	
				
				if(resultCnt ==1) {
					categoryVo.setResult("EXIST");
				}else {
					resultCnt = eduService.insertCatgegory(categoryVo);				
					categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;		
				}
				
			}
			
			if("E".equals(categoryVo.getGubun1())){
				
				resultCnt = eduService.updateCategory(categoryVo);				
				categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;	
			}

			if("D".equals(categoryVo.getGubun1())){
				resultCnt = eduService.deleteCategory(categoryVo);				
				categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL") ;	
			}
			
			
		} catch (Exception e) {
			categoryVo.setResult("FAIL");
		}
		
		return categoryVo;
	}
	
	
}


