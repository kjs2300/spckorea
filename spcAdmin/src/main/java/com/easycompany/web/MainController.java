package com.easycompany.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.easycompany.cmm.util.FileUtil;
import com.easycompany.cmm.util.StringUtil;
import com.easycompany.cmm.vo.LoginVo;
import com.easycompany.service.MainService;
import com.easycompany.service.vo.BoardVo;
import com.easycompany.service.vo.MainVo;

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
				
				MainVo fileDeleteVo1 = mainService.getCommonDetail(mainVo);
				
				String fileFullPath = fileDeleteVo1.getFile_full_path();
				mainVo.setFile_id(fileVo.getFile_uuid());
				mainVo.setFile_name(fileVo.getFile_name());
				mainVo.setFile_full_path(fileVo.getFile_full_path());
				mainVo.setFile_size(fileVo.getFile_size());
				mainVo.setFile_seq(fileDeleteVo1.getFile_seq());
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
	
	/** admin >  메인이미지  List  */
	@RequestMapping(value = "/imgList.do")
	public String imgList(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model,HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		
		/** EgovPropertyService.sample */
		mainVo.setPageUnit(propertiesService.getInt("pageUnit"));
		mainVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(mainVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(mainVo.getPageUnit());
		paginationInfo.setPageSize(mainVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		mainVo.setOffset(offset);
		
		if ( StringUtil.isEmpty(mainVo.getGubun1())) {
			mainVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(mainVo.getGubun2())) {
			mainVo.setGubun2("img");
		}		
		
		List<MainVo> list = mainService.getCommonList(mainVo);
		model.addAttribute("resultList", list);
				
		int totCnt = mainService.getCommonCount(mainVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
			
		mainVo.setReg_id(loginvo.getId());		
		model.addAttribute("mainVo",   mainVo);
	
		return "imgList";
	}

	
	/** admin > 메인이미지 등록  */
	@RequestMapping(value = "/imgReg.do")
	public String imgReg(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model,HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		
		if ( StringUtil.isEmpty(mainVo.getGubun1())) {
			mainVo.setGubun1("R");
		}		
		if ( StringUtil.isEmpty(mainVo.getGubun2())) {
			mainVo.setGubun2("img");
		}	
		
		MainVo mainForm = mainService.getCommonDetail(mainVo);
		
		
		mainVo.setReg_id(loginvo.getId());		
		model.addAttribute("mainVo",   mainVo);
		model.addAttribute("mainForm", mainForm);

		return "imgReg";
	}

	@RequestMapping(value = "/imgSave.do")
	@ResponseBody
	public MainVo imgSave(HttpServletRequest request, MainVo mainVo) throws Exception {
		
		int resultCnt = 0;
		
		try {
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			mainVo.setReg_id(loginvo.getId());
		
			if ( StringUtil.isEmpty(mainVo.getGubun2())) {
				mainVo.setGubun2("img");
			}
			
			String fileAddpath = filePath + File.separator + mainVo.getGubun2();
			
			if("I".equals(mainVo.getGubun1())) {
				mainVo.setGubun3("I");
				
				//fileUpload
				BoardVo fileVo= FileUtil.uploadFile (request,  fileAddpath);
				
				
				mainVo.setFile_id(fileVo.getFile_uuid());
				mainVo.setFile_name(fileVo.getFile_name());
				mainVo.setFile_full_path(fileVo.getFile_full_path());
				mainVo.setFile_size(fileVo.getFile_size());
				resultCnt = mainService.insertCommon(mainVo);
			}
			
			
			if("E".equals(mainVo.getGubun1())) {
				
				if(! "N".equals(mainVo.getGubun3())) {
				
					BoardVo fileVo= FileUtil.uploadFile (request,  fileAddpath);
					MainVo fileDeleteVo1 = mainService.getCommonDetail(mainVo);
					
					String fileFullPath = fileDeleteVo1.getFile_full_path();
					mainVo.setFile_id(fileVo.getFile_uuid());
					mainVo.setFile_name(fileVo.getFile_name());
					mainVo.setFile_full_path(fileVo.getFile_full_path());
					mainVo.setFile_size(fileVo.getFile_size());
					mainVo.setFile_seq(fileDeleteVo1.getFile_seq());
					resultCnt = mainService.updateCommon(mainVo);
					if(fileFullPath != null && fileFullPath.length()>3) {
						FileUtil.deleteFile(request, fileFullPath);
					}
				}else {
					mainVo.setGubun3("I");
					resultCnt = mainService.updateCommon(mainVo);
				}
			}


			if("D".equals(mainVo.getGubun1())) {
				
				mainVo.setGubun3("I");
				
				MainVo fileDeleteVo = mainService.getCommonDetail(mainVo);
				resultCnt = mainService.deleteCommon(mainVo);
			
				if(fileDeleteVo != null) { 
					String fileFullPath = fileDeleteVo.getFile_full_path();
					if(fileFullPath != null && fileFullPath.length()>3) {
						FileUtil.deleteFile(request, fileFullPath);
					}
				}
			}

			mainVo.setResult((resultCnt > 0 ? "SUCCESS" : "FAIL") );

			
		} catch (Exception e) {
			mainVo.setResult("FAIL");
		}
		
		return mainVo;
	}
	
	/** admin >  메인 배너  List  */
	@RequestMapping(value = "/bannerList.do")
	public String bannerList(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model,HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		
		/** EgovPropertyService.sample */
		mainVo.setPageUnit(propertiesService.getInt("pageUnit"));
		mainVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(mainVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(mainVo.getPageUnit());
		paginationInfo.setPageSize(mainVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		mainVo.setOffset(offset);
		
		if ( StringUtil.isEmpty(mainVo.getGubun1())) {
			mainVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(mainVo.getGubun2())) {
			mainVo.setGubun2("banner");
		}
		
		
		List<MainVo> list = mainService.getCommonList(mainVo);
		model.addAttribute("resultList", list);
			
		
		int totCnt = mainService.getCommonCount(mainVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
	
		
		mainVo.setReg_id(loginvo.getId());		
		model.addAttribute("mainVo",   mainVo);
	

		return "bannerList";
	}

	
	/** admin > 메인배너 등록  */
	@RequestMapping(value = "/bannerReg.do")
	public String bannerReg(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model,HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		
		if ( StringUtil.isEmpty(mainVo.getGubun1())) {
			mainVo.setGubun1("R");
		}		
		if ( StringUtil.isEmpty(mainVo.getGubun2())) {
			mainVo.setGubun2("banner");
		}	
		
		MainVo mainForm = mainService.getCommonDetail(mainVo);
		
		
		mainVo.setReg_id(loginvo.getId());		
		model.addAttribute("mainVo",   mainVo);
		model.addAttribute("mainForm", mainForm);

		return "bannerReg";
	}

	@RequestMapping(value = "/bannerSave.do")
	@ResponseBody
	public MainVo bannerSave(HttpServletRequest request, MainVo mainVo) throws Exception {
		
		int resultCnt = 0;
		
		try {
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			mainVo.setReg_id(loginvo.getId());
		
			if ( StringUtil.isEmpty(mainVo.getGubun2())) {
				mainVo.setGubun2("banner");
			}
			
			String fileAddpath = filePath + File.separator + mainVo.getGubun2();
			
			if("I".equals(mainVo.getGubun1())) {
				
				mainVo.setGubun3("I");
				//fileUpload
				BoardVo fileVo= FileUtil.uploadFile (request,  fileAddpath);
				
				
				mainVo.setFile_id(fileVo.getFile_uuid());
				mainVo.setFile_name(fileVo.getFile_name());
				mainVo.setFile_full_path(fileVo.getFile_full_path());
				mainVo.setFile_size(fileVo.getFile_size());
				resultCnt = mainService.insertCommon(mainVo);
			}
				
			if("E".equals(mainVo.getGubun1())) {
				
				if(! "N".equals(mainVo.getGubun3())) {
				
					BoardVo fileVo= FileUtil.uploadFile (request,  fileAddpath);
					MainVo fileDeleteVo1 = mainService.getCommonDetail(mainVo);
					
					String fileFullPath = fileDeleteVo1.getFile_full_path();
					mainVo.setFile_id(fileVo.getFile_uuid());
					mainVo.setFile_name(fileVo.getFile_name());
					mainVo.setFile_full_path(fileVo.getFile_full_path());
					mainVo.setFile_size(fileVo.getFile_size());
					mainVo.setFile_seq(fileDeleteVo1.getFile_seq());
					resultCnt = mainService.updateCommon(mainVo);
					if(fileFullPath != null && fileFullPath.length()>3) {
						FileUtil.deleteFile(request, fileFullPath);
					}
				}else {
					mainVo.setGubun3("I");
					resultCnt = mainService.updateCommon(mainVo);
				}
			}

			if("D".equals(mainVo.getGubun1())) {
				
				mainVo.setGubun3("I");
				
				MainVo fileDeleteVo = mainService.getCommonDetail(mainVo);
				resultCnt = mainService.deleteCommon(mainVo);
			
				if(fileDeleteVo != null) { 
					String fileFullPath = fileDeleteVo.getFile_full_path();
					if(fileFullPath != null && fileFullPath.length()>3) {
						FileUtil.deleteFile(request, fileFullPath);
					}
				}
			}

			mainVo.setResult((resultCnt > 0 ? "SUCCESS" : "FAIL") );
			
		} catch (Exception e) {
			mainVo.setResult("FAIL");
		}
		
		return mainVo;
	}
	
	/** admin >  팝업관리  List  */
	@RequestMapping(value = "/popupList.do")
	public String popupList(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model,HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		
		/** EgovPropertyService.sample */
		mainVo.setPageUnit(propertiesService.getInt("pageUnit"));
		mainVo.setPageSize(propertiesService.getInt("pageSize"));
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(mainVo.getPageIndex());
		paginationInfo.setRecordCountPerPage(mainVo.getPageUnit());
		paginationInfo.setPageSize(mainVo.getPageSize());
		
		/***  offSet 설정  ***/
		int offset = ((paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize());
		mainVo.setOffset(offset);
		
		if ( StringUtil.isEmpty(mainVo.getGubun1())) {
			mainVo.setGubun1("R");
		}
		
		if ( StringUtil.isEmpty(mainVo.getGubun2())) {
			mainVo.setGubun2("popup");
		}
		
		List<MainVo> list = mainService.getCommonList(mainVo);
		model.addAttribute("resultList", list);
				
		int totCnt = mainService.getCommonCount(mainVo);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
				
		mainVo.setReg_id(loginvo.getId());		
		model.addAttribute("mainVo",   mainVo);
	
		return "popupList";
	}

	
	/** admin > 메인팝업 등록  */
	@RequestMapping(value = "/popupReg.do")
	public String popupReg(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model,HttpServletRequest request) throws Exception {

		LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
		
		if ( StringUtil.isEmpty(mainVo.getGubun1())) {
			mainVo.setGubun1("R");
		}		
		if ( StringUtil.isEmpty(mainVo.getGubun2())) {
			mainVo.setGubun2("popup");
		}	
		
		MainVo mainForm = mainService.getCommonDetail(mainVo);
				
		mainVo.setReg_id(loginvo.getId());		
		model.addAttribute("mainVo",   mainVo);
		model.addAttribute("mainForm", mainForm);

		return "popupReg";
	}

	@RequestMapping(value = "/popupSave.do")
	@ResponseBody
	public MainVo popupSave(HttpServletRequest request, MainVo mainVo) throws Exception {
		
		int resultCnt = 0;
		
		try {
			
			LoginVo loginvo = (LoginVo) WebUtils.getSessionAttribute(request, "AdminAccount");
			
			mainVo.setReg_id(loginvo.getId());
		
			if ( StringUtil.isEmpty(mainVo.getGubun2())) {
				mainVo.setGubun2("popup");
			}
			
			mainVo.setGubun3("N");
			
			if("I".equals(mainVo.getGubun1())) {
				
				resultCnt = mainService.insertCommon(mainVo);
			}
						
			if("E".equals(mainVo.getGubun1())) {				
				resultCnt = mainService.updateCommon(mainVo);
			}

			if("D".equals(mainVo.getGubun1())) {
				resultCnt = mainService.deleteCommon(mainVo);
			}
			
			//전체삭제
			if("A".equals(mainVo.getGubun1())){
				String[] ArraysStr = mainVo.getCheckdstr().split(",");
				for(String s : ArraysStr) {
					mainVo.setPopup_no(Integer.parseInt(s));
					resultCnt = mainService.deleteCommon(mainVo);		
				}	
			}
			
			mainVo.setResult((resultCnt > 0 ? "SUCCESS" : "FAIL") );
			
		} catch (Exception e) {
			mainVo.setResult("FAIL");
		}
		
		return mainVo;
	}
}
