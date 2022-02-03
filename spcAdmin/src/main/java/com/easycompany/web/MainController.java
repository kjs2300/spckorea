package com.easycompany.web;

import java.io.File;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.easycompany.cmm.util.EgovFileScrty;
import com.easycompany.cmm.util.FileUtil;
import com.easycompany.cmm.util.StringUtil;
import com.easycompany.cmm.vo.Account;
import com.easycompany.cmm.vo.DefaultVO;
import com.easycompany.cmm.vo.LoginVo;
import com.easycompany.service.vo.MainVo;
import com.easycompany.service.vo.BoardVo;
import com.easycompany.service.vo.CategoryVo;
import com.easycompany.service.MainService;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping("main")
public class MainController {

	
	
	@Autowired
	private MainService mainService;
	
	/** EgovPropertyService */
	@Autowired
	protected EgovPropertyService propertiesService;
	
	@Value("#{dbinfo['file.path']}")
	private String filePath;

	/** admin > 메인관리  > List  */
	@RequestMapping(value = "/logoList.do")
	public String getEduInfoRegList(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model,HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		
		mainVo.setReg_id(loginvo.getId());
		
		model.addAttribute("mainVo", mainVo);

		return "logoList";
	}

	/*
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
	*/
	}


