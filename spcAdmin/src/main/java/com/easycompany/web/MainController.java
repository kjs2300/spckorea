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
	public String logoList(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model,HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		
		if ( StringUtil.isEmpty(mainVo.getGubun1())) {
			mainVo.setGubun1("R");
		}		
		if ( StringUtil.isEmpty(mainVo.getGubun2())) {
			mainVo.setGubun2("logo");
		}	
		if ( StringUtil.isEmpty(mainVo.getGubun2())) {
			mainVo.setGubun2("logo");
		}	
		MainVo mainForm = mainService.getCommonDetail(mainVo);
		
		
		mainVo.setReg_id(loginvo.getId());		
		model.addAttribute("mainVo",   mainVo);
		model.addAttribute("mainForm", mainForm);

		return "logoList";
	}

	
	@RequestMapping(value = "/logoSave.do")
	@ResponseBody
	public MainVo logoSave(HttpServletRequest request, MainVo mainVo) throws Exception {
		
		int resultCnt = 0;
		
		try {
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			mainVo.setReg_id(loginvo.getId());
		
			if ( StringUtil.isEmpty(mainVo.getGubun1())) {
				mainVo.setGubun1("R");
			}
			
			if ( StringUtil.isEmpty(mainVo.getGubun2())) {
				mainVo.setGubun2("logo");
			}
			
			String fileAddpath = filePath + File.separator + mainVo.getGubun2();
			
			if("I".equals(mainVo.getGubun1())) {
				//fileUpload
				BoardVo fileVo= FileUtil.uploadFile (request,  fileAddpath);
				
				mainVo.setFile_id(fileVo.getFile_uuid());
				mainVo.setFile_name(fileVo.getFile_name());
				mainVo.setFile_full_path(fileVo.getFile_full_path());
				mainVo.setFile_size(fileVo.getFile_size());
				resultCnt = mainService.insertCommon(mainVo);
			}
			
			
			if("E".equals(mainVo.getGubun1())) {
				BoardVo fileVo= FileUtil.uploadFile (request,  fileAddpath);
				
				String fileFullPath = mainVo.getFile_full_path();
				mainVo.setFile_id(fileVo.getFile_uuid());
				mainVo.setFile_name(fileVo.getFile_name());
				mainVo.setFile_full_path(fileVo.getFile_full_path());
				mainVo.setFile_size(fileVo.getFile_size());
				resultCnt = mainService.updateCommon(mainVo);
				
				FileUtil.deleteFile(request, fileFullPath);
			}

			/*
			 * 
			if("D".equals(mainVo.getGubun1())) {
				resultCnt = mainService.deleteCategory(mainVo);
			}
			*/
			mainVo.setResult((resultCnt > 0 ? "SUCCESS" : "FAIL") );

			
		} catch (Exception e) {
			mainVo.setResult("FAIL");
		}
		
		return mainVo;
	}
	
	
	/** 게시판 -   File Downlaod */
	@RequestMapping(value = "/fileDownload.do")
	@ResponseBody
	public void fileDownload(HttpServletRequest request, HttpServletResponse response, MainVo mainVo) throws Exception {
		
		MainVo fileVo = mainService.getCommonDetail(mainVo);
		
		BoardVo boardVoForm = new BoardVo();
		boardVoForm.setFile_uuid(fileVo.getFile_id());
		boardVoForm.setFile_name(fileVo.getFile_name());
		boardVoForm.setFile_full_path(fileVo.getFile_full_path());
		boardVoForm.setFile_size(fileVo.getFile_size());
		
		FileUtil.fileDownload(request, response, boardVoForm);
		
	}
	
	
	
}


