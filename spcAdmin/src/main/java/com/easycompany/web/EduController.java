package com.easycompany.web;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.easycompany.service.EduService;
import com.easycompany.service.vo.BoardVo;
import com.easycompany.service.vo.CategoryVo;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping({"edu"})
public class EduController
{

  @Autowired
  private EduService eduService;

  @Autowired
  protected EgovPropertyService propertiesService;

  @Value("#{dbinfo['file.path']}")
  private String filePath;

  @Value("#{dbinfo['web.path']}")
  private String webPath;

  @RequestMapping({"/eduInfoRegList.do"})
  public String getEduInfoRegList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));

    PaginationInfo paginationInfo = new PaginationInfo();
    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
    paginationInfo.setPageSize(categoryVo.getPageSize());

    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
    categoryVo.setOffset(offset);

    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
      categoryVo.setGubun1("R");
    }

    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
      categoryVo.setGubun2("category");
    }

    List list = this.eduService.getCategoryList(categoryVo);
    model.addAttribute("resultList", list);

    int totCnt = this.eduService.getCategoryCount(categoryVo);
    paginationInfo.setTotalRecordCount(totCnt);
    model.addAttribute("paginationInfo", paginationInfo);

    return "eduInfoRegList";
  }

  @RequestMapping({"/eduInfoRegCate.do"})
  public String getEduInfoRegCate(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
      categoryVo.setGubun1("R");
    }

    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
      categoryVo.setGubun2("category1");
    }

    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));

    PaginationInfo paginationInfo = new PaginationInfo();
    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
    paginationInfo.setPageSize(categoryVo.getPageSize());

    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
    categoryVo.setOffset(offset);

    List list = this.eduService.getCategoryList(categoryVo);
    model.addAttribute("resultList", list);

    int totCnt = this.eduService.getCategoryCount(categoryVo);
    paginationInfo.setTotalRecordCount(totCnt);
    model.addAttribute("paginationInfo", paginationInfo);
    model.addAttribute("categoryVo", categoryVo);

    return "eduInfoRegCate";
  }

  @RequestMapping({"/eduInfoRegCateSave.do"})
  @ResponseBody
  public CategoryVo eduInfoRegCateSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
    int resultCnt = 0;
    try
    {
      LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");

      categoryVo.setReg_id(loginvo.getId());

      if ("I".equals(categoryVo.getGubun1()))
      {
        resultCnt = this.eduService.getCategoryExist(categoryVo);

        if (resultCnt == 1) {
          categoryVo.setResult("EXIST");
        } else {
          resultCnt = this.eduService.insertCatgegory(categoryVo);
          categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
        }

      }

      if ("E".equals(categoryVo.getGubun1()))
      {
        resultCnt = this.eduService.updateCategory(categoryVo);
        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
      }

      if ("D".equals(categoryVo.getGubun1())) {
        resultCnt = this.eduService.deleteCategory(categoryVo);
        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
      }
    }
    catch (Exception e)
    {
      categoryVo.setResult("FAIL");
    }

    return categoryVo;
  }

  @RequestMapping({"/eduInfoRegCate3.do"})
  public String getEduInfoRegCate3(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
      categoryVo.setGubun1("R");
    }

    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
      categoryVo.setGubun2("category3");
    }

    CategoryVo categoryForm = this.eduService.getCategoryDetail(categoryVo);

    model.addAttribute("categoryVo", categoryVo);
    model.addAttribute("categoryForm", categoryForm);

    return "eduInfoRegCate3";
  }

  @RequestMapping({"/eduInfoRegCate3Save.do"})
  @ResponseBody
  public CategoryVo eduInfoRegCate3Save(HttpServletRequest request, CategoryVo categoryVo) throws Exception
  {
    int resultCnt = 0;
    try
    {
      LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");

      categoryVo.setReg_id(loginvo.getId());
      categoryVo.setGubun2("category3");

      if ("I".equals(categoryVo.getGubun1()))
      {
        BoardVo fileVo = FileUtil.uploadFile(request, this.filePath);

        categoryVo.setFile_uuid(fileVo.getFile_uuid());
        categoryVo.setFile_name(fileVo.getFile_name());
        categoryVo.setFile_full_path(fileVo.getFile_full_path());
        categoryVo.setFile_size(fileVo.getFile_size());
        resultCnt = this.eduService.insertCatgegory3(categoryVo);
      }

      if ("E".equals(categoryVo.getGubun1())) {
        resultCnt = this.eduService.updateCategory(categoryVo);
      }

      if ("D".equals(categoryVo.getGubun1())) {
        resultCnt = this.eduService.deleteCategory(categoryVo);
      }

      categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
    }
    catch (Exception e)
    {
      categoryVo.setResult("FAIL");
    }

    return categoryVo;
  }

  @RequestMapping({"/eduInfoScheduleList.do"})
  public String eduInfoScheduleList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));

    LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");
    categoryVo.setReg_id(loginvo.getId());

    PaginationInfo paginationInfo = new PaginationInfo();
    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
    paginationInfo.setPageSize(categoryVo.getPageSize());

    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
    categoryVo.setOffset(offset);

    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
      categoryVo.setGubun1("R");
    }

    if (StringUtil.isEmpty(categoryVo.getCheckdate())) {
      categoryVo.setCheckdate("ALL");
    }

    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
      categoryVo.setGubun2("eduInfoScheduleList");
    }

    List list = this.eduService.getCategoryList(categoryVo);
    model.addAttribute("resultList", list);

    int totCnt = this.eduService.getCategoryCount(categoryVo);
    paginationInfo.setTotalRecordCount(totCnt);
    model.addAttribute("paginationInfo", paginationInfo);

    return "eduInfoScheduleList";
  }

  @RequestMapping({"/eduInfoScheduleCate.do"})
  public String eduInfoScheduleCate(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
      categoryVo.setGubun1("R");
    }

    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
      categoryVo.setGubun2("eduInfoScheduleList");
    }

    CategoryVo categoryForm = this.eduService.getCategoryDetail(categoryVo);

    categoryVo.setGubun3("categorycode1");

    List category1list = this.eduService.getCategoryCodeList(categoryVo);

    model.addAttribute("categoryVo", categoryVo);
    model.addAttribute("category1list", category1list);
    model.addAttribute("categoryForm", categoryForm);

    return "eduInfoScheduleCate";
  }

  @RequestMapping({"/eduInfoScheduleCateSave.do"})
  @ResponseBody
  public CategoryVo eduInfoScheduleCateSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
    int resultCnt = 0;
    try
    {
      LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");

      categoryVo.setReg_id(loginvo.getId());
      categoryVo.setGubun2("category3");

      if ("I".equals(categoryVo.getGubun1()))
      {
        BoardVo fileVo = FileUtil.uploadFile(request, this.filePath);

        categoryVo.setFile_uuid(fileVo.getFile_uuid());
        categoryVo.setFile_name(fileVo.getFile_name());
        categoryVo.setFile_full_path(fileVo.getFile_full_path());
        categoryVo.setFile_size(fileVo.getFile_size());
        resultCnt = this.eduService.insertCatgegory3(categoryVo);
      }

      if ("E".equals(categoryVo.getGubun1())) {
        resultCnt = this.eduService.updateCategory(categoryVo);
      }

      if ("D".equals(categoryVo.getGubun1())) {
        resultCnt = this.eduService.deleteCategory(categoryVo);
      }

      categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
    }
    catch (Exception e)
    {
      categoryVo.setResult("FAIL");
    }

    return categoryVo;
  }

  @RequestMapping({"/eduInfoScheduleSave.do"})
  @ResponseBody
  public CategoryVo eduInfoScheduleSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception
  {
    int resultCnt = 0;
    try
    {
      LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");

      categoryVo.setReg_id(loginvo.getId());

      if ("I".equals(categoryVo.getGubun1())) {
        resultCnt = this.eduService.insertSchedule(categoryVo);
        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
      }

      if ("E".equals(categoryVo.getGubun1())) {
        resultCnt = this.eduService.updateSchedule(categoryVo);
        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
      }

      if ("A".equals(categoryVo.getGubun1())) {
        String[] ArraysStr = categoryVo.getCheckdstr().split(",");
        for (String s : ArraysStr) {
          categoryVo.setEdu_key(Integer.parseInt(s));
          resultCnt = this.eduService.deleteSchedule(categoryVo);
        }
        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
      }

      if ("D".equals(categoryVo.getGubun1()))
      {
        resultCnt = this.eduService.deleteSchedule(categoryVo);
        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
      }
    }
    catch (Exception e)
    {
      categoryVo.setResult("FAIL");
    }

    return categoryVo;
  }

  @RequestMapping({"/excelDownload.do"})
  public ModelAndView excelDownload(@ModelAttribute("categoryVo") CategoryVo categoryVo)
    throws Exception
  {
	    categoryVo.setRecordCountPerPage(10000);
	    categoryVo.setOffset(0);
	    categoryVo.setGubun1("R");
	    categoryVo.setGubun2("eduInfoScheduleList");
	
	    List list = this.eduService.getCategoryList(categoryVo);
	
	    Map map = new HashMap();
	    map.put("list", list);
	    map.put("filename", categoryVo.getExcelFileName());
	
	    return new ModelAndView("schduleExcelView", map);
  }

  @RequestMapping({"/eduInfoClassList.do"})
  public String eduInfoClassList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
	    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
	    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));
	
	    PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
	    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
	    paginationInfo.setPageSize(categoryVo.getPageSize());
	
	    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	    categoryVo.setOffset(offset);
	
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("categoryClass");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getSite())) {
	      categoryVo.setSite("on");
	    }
	
	    List list = this.eduService.getCategoryList(categoryVo);
	    model.addAttribute("resultList", list);
	
	    int totCnt = this.eduService.getCategoryCount(categoryVo);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduInfoClassList";
  }

  @RequestMapping({"/eduInfoClassCate.do"})
  public String eduInfoClassCate(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception
  {
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("category4");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getSite())) {
	      categoryVo.setSite("on");
	    }
	
	    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
	    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));
	
	    PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
	    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
	    paginationInfo.setPageSize(categoryVo.getPageSize());
	
	    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	    categoryVo.setOffset(offset);
	
	    List list = this.eduService.getCategoryList(categoryVo);
	    model.addAttribute("resultList", list);
	
	    int totCnt = this.eduService.getCategoryCount(categoryVo);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduInfoClassCate";
  }

  @RequestMapping({"/eduInfoClassCateSave.do"})
  @ResponseBody
  public CategoryVo eduInfoClassCateSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
	    int resultCnt = 0;
	    try
	    {
	      LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");
	
	      categoryVo.setReg_id(loginvo.getId());
	
	      if ("I".equals(categoryVo.getGubun1()))
	      {
	        resultCnt = this.eduService.getCategoryExist(categoryVo);
	
	        if (resultCnt == 1) {
	          categoryVo.setResult("EXIST");
	        } else {
	          resultCnt = this.eduService.insertCatgegory(categoryVo);
	          categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	        }
	
	      }
	
	      if ("E".equals(categoryVo.getGubun1()))
	      {
	        resultCnt = this.eduService.updateCategory(categoryVo);
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	
	      if ("D".equals(categoryVo.getGubun1())) {
	        resultCnt = this.eduService.deleteCategory(categoryVo);
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	    }
	    catch (Exception e)
	    {
	      categoryVo.setResult("FAIL");
	    }
	
	    return categoryVo;
  }

  @RequestMapping({"/eduInfoCategoryCodeList.do"})
  @ResponseBody
  public List<CategoryVo> eduInfoCategoryCodeList(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
	    List category1list = null;
	    try {
	      if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	        categoryVo.setGubun2("eduInfoScheduleList");
	      }
	      if (StringUtil.isEmpty(categoryVo.getSite())) {
	        categoryVo.setSite("on");
	      }
	      category1list = this.eduService.getCategoryCodeList(categoryVo);
	    } catch (Exception e) {
	      categoryVo.setResult("FAIL");
	    }
	
	    return category1list;
  }

  /*
   * 온라인 교육 List
   */
  @RequestMapping({"/eduInfoOnlineList.do"})
  public String eduInfoOnlineList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
	    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
	    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));
	
	    PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
	    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
	    paginationInfo.setPageSize(categoryVo.getPageSize());
	
	    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	    categoryVo.setOffset(offset);
	
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoOnline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
	        categoryVo.setEdu_site("on");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getSite())) {
	        categoryVo.setSite("on");
	    }
	    
	    categoryVo.setWebPath(this.webPath);
	
	    categoryVo.setGubun3("categorycode1");
	    List category1list = this.eduService.getCategoryCodeList(categoryVo);
	    model.addAttribute("category1list", category1list);
	
	    List list = this.eduService.getEducationList(categoryVo);
	    model.addAttribute("resultList", list);
	
	    int totCnt = this.eduService.getEducationCount(categoryVo);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduInfoOnlineList";
  }

  /*
   * 온라인 교육 등록/수정
   */
  @RequestMapping({"/eduInfoOnlineReg.do"})
  public String eduInfoOnlineReg(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception
  {
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoOnline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
	        categoryVo.setEdu_site("on");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getSite())) {
	        categoryVo.setSite("on");
	    }
	
	    categoryVo.setWebPath(this.webPath);
	
	    categoryVo.setGubun3("categorycode1");
	    List category1list = this.eduService.getCategoryCodeList(categoryVo);
	    model.addAttribute("category1list", category1list);
	
	    CategoryVo categoryForm = this.eduService.getEduCationDetail(categoryVo);
	    model.addAttribute("categoryForm", categoryForm);
	
	    List categoryFormSubList = this.eduService.getEduCationDetailSub(categoryVo);
	    model.addAttribute("categoryFormSubList", categoryFormSubList);
	
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduInfoOnlineReg";
  }

  /*
   * 온라인 교육 저장
   */
  @RequestMapping({"/eduInfoOnlineSave.do"})
  @ResponseBody
  public CategoryVo eduInfoOnlineSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
	    int resultCnt = 0;
	    try
	    {
	      LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");
	
	      categoryVo.setReg_id(loginvo.getId());
	
	      if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	        categoryVo.setGubun2("eduInfoOnline");
	      }
	
	      if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
	          categoryVo.setEdu_site("on");
	      }
	
	      if (StringUtil.isEmpty(categoryVo.getSite())) {
	          categoryVo.setSite("on");
	      }
	
	      if (StringUtil.isEmpty(categoryVo.getFileExit())) {
	        categoryVo.setFileExit("NO");
	      }
	
	      String fileAddpath = this.filePath + File.separator + categoryVo.getGubun2();
	
	      if ("I".equals(categoryVo.getGubun1()))
	      {
	        if ("YES".equals(categoryVo.getFileExit())) {
	          BoardVo fileVo = FileUtil.uploadFile(request, fileAddpath);
	          categoryVo.setFile_uuid(fileVo.getFile_uuid());
	          categoryVo.setFile_name(fileVo.getFile_name());
	          categoryVo.setFile_full_path(fileVo.getFile_full_path());
	          categoryVo.setFile_size(fileVo.getFile_size());
	          categoryVo.setEdu_notice(fileVo.getFile_uuid());
	        }
	
	        resultCnt = this.eduService.insertEducation(categoryVo);
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	
	      if ("E".equals(categoryVo.getGubun1()))
	      {
	    	 CategoryVo fileCategoryVo = this.eduService.getEduCationFile(categoryVo);
	    	 
	         String fileFullPath = "";
	         
	         if( fileCategoryVo !=null) {
	        	 fileFullPath = fileCategoryVo.getFile_full_path();
	         }
	         if ("YES".equals(categoryVo.getFileExit())) {
	          BoardVo fileVo = FileUtil.uploadFile(request, fileAddpath);
	          categoryVo.setFile_uuid(fileVo.getFile_uuid());
	          categoryVo.setFile_name(fileVo.getFile_name());
	          categoryVo.setFile_full_path(fileVo.getFile_full_path());
	          categoryVo.setFile_size(fileVo.getFile_size());
	        }
	
	        resultCnt = this.eduService.updateEduCation(categoryVo);
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	
	        if ((resultCnt > 0) && ("YES".equals(categoryVo.getFileExit())))
	        {
	          if ((fileFullPath != null) && (fileFullPath.length() > 3))
	          {
	            FileUtil.deleteFile(request, fileFullPath);
	          }
	
	        }
	
	      }
	
	      if ("D".equals(categoryVo.getGubun1())) {
	    	  
	    	 CategoryVo fileCategoryVo = this.eduService.getEduCationFile(categoryVo);
		    	 
			 String fileFullPath = "";
			     
		     if( fileCategoryVo !=null) {
		    	 fileFullPath = fileCategoryVo.getFile_full_path();
		     }
			resultCnt = this.eduService.deleteEduCation(categoryVo);
			if ((fileFullPath != null) && (fileFullPath.length() > 3)) {
			  FileUtil.deleteFile(request, fileFullPath);
			}
			categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	
	      if ("A".equals(categoryVo.getGubun1())) {
	        String[] ArraysStr = categoryVo.getCheckdstr().split(",");
	        for (String s : ArraysStr) {
	          categoryVo.setEdu_no(Integer.parseInt(s));
	          CategoryVo fileCategoryVo = this.eduService.getEduCationFile(categoryVo);
		      String fileFullPath = "";
	          if( fileCategoryVo !=null) {
	        	  fileFullPath = fileCategoryVo.getFile_full_path();
	          }
	          resultCnt = this.eduService.deleteEduCation(categoryVo);
	          if ((fileFullPath != null) && (fileFullPath.length() > 3)) {
	            FileUtil.deleteFile(request, fileFullPath);
	          }
	        }
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	    }
	    catch (Exception e)
	    {
	      categoryVo.setResult("FAIL");
	    }
	
	    return categoryVo;
  }

  @RequestMapping({"/eduInfoOfflineList.do"})
  public String eduInfoOfflineList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
	    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
	    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));
	
	    PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
	    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
	    paginationInfo.setPageSize(categoryVo.getPageSize());
	
	    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	    categoryVo.setOffset(offset);
	
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoOffline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
	      categoryVo.setEdu_site("off");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getSite())) {
	      categoryVo.setSite("off");
	    }
	
	    categoryVo.setWebPath(this.webPath);
	
	    List list = this.eduService.getEducationList(categoryVo);
	    model.addAttribute("resultList", list);
	
	    int totCnt = this.eduService.getEducationCount(categoryVo);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduInfoOfflineList";
  }

  @RequestMapping({"/eduInfoOfflineReg.do"})
  public String eduInfoOfflineReg(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception
  {
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoOffline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
	      categoryVo.setEdu_site("off");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getSite())) {
	      categoryVo.setSite("off");
	    }
	
	    categoryVo.setWebPath(this.webPath);
	
	    categoryVo.setGubun3("categorycode1");
	    List category1list = this.eduService.getCategoryCodeList(categoryVo);
	    model.addAttribute("category1list", category1list);
	
	    CategoryVo categoryForm = this.eduService.getEduCationDetail(categoryVo);
	    model.addAttribute("categoryForm", categoryForm);
	
	    List categoryFormSubList = this.eduService.getEduCationDetailSub(categoryVo);
	    model.addAttribute("categoryFormSubList", categoryFormSubList);
	
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduInfoOfflineReg";
  }

  @RequestMapping({"/eduInfoOfflineSave.do"})
  @ResponseBody
  public CategoryVo eduInfoOfflineSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
	    int resultCnt = 0;
	    try
	    {
	      LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");
	
	      categoryVo.setReg_id(loginvo.getId());
	
	      if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	        categoryVo.setGubun2("eduInfoOffline");
	      }
	
	      if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
	        categoryVo.setEdu_site("off");
	      }
	
	      if (StringUtil.isEmpty(categoryVo.getSite())) {
	        categoryVo.setSite("off");
	      }
	
	      if (StringUtil.isEmpty(categoryVo.getFileExit())) {
	        categoryVo.setFileExit("NO");
	      }
	
	      if ("I".equals(categoryVo.getGubun1()))
	      {
	        resultCnt = this.eduService.insertEducation(categoryVo);
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	
	      if ("E".equals(categoryVo.getGubun1())) {
	        resultCnt = this.eduService.updateEduCation(categoryVo);
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	
	      if ("D".equals(categoryVo.getGubun1()))
	      {
	        resultCnt = this.eduService.deleteEduCation(categoryVo);
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	
	      if ("A".equals(categoryVo.getGubun1())) {
	        String[] ArraysStr = categoryVo.getCheckdstr().split(",");
	        for (String s : ArraysStr) {
	          categoryVo.setEdu_no(Integer.parseInt(s));
	          resultCnt = this.eduService.deleteEduCation(categoryVo);
	        }
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	    }
	    catch (Exception e)
	    {
	      categoryVo.setResult("FAIL");
	    }
	
	    return categoryVo;
  }

  /*
   * 오프라인 교육[기관외] List
   */
  @RequestMapping({"/eduInfoNoOrglineList.do"})
  public String eduInfoNoOrglineList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
	    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
	    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));
	
	    PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
	    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
	    paginationInfo.setPageSize(categoryVo.getPageSize());
	
	    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	    categoryVo.setOffset(offset);
	
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoNoOrgline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
		    categoryVo.setEdu_site("nooff");
	    }
		
		if (StringUtil.isEmpty(categoryVo.getSite())) {
		   categoryVo.setSite("off");
		}
	    
		categoryVo.setWebPath(this.webPath);
	
	    categoryVo.setGubun3("categorycode1");
	    List category1list = this.eduService.getCategoryCodeList(categoryVo);
	    model.addAttribute("category1list", category1list);
	
	    List list = this.eduService.getEducationList(categoryVo);
	    model.addAttribute("resultList", list);
	
	    int totCnt = this.eduService.getEducationCount(categoryVo);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduInfoNoOrglineList";
  }

  /*
   * 오프라인 교육[기관외] 등록/수정
   */
  @RequestMapping({"/eduInfoNoOrglineReg.do"})
  public String eduInfoNoOrglineeReg(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model) throws Exception
  {
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoNoOrgline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
	        categoryVo.setEdu_site("nooff");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getSite())) {
	        categoryVo.setSite("off");
	    }
	
	    categoryVo.setWebPath(this.webPath);
	
	    categoryVo.setGubun3("categorycode1");
	    List category1list = this.eduService.getCategoryCodeList(categoryVo);
	    model.addAttribute("category1list", category1list);
	
	    CategoryVo categoryForm = this.eduService.getEduCationDetail(categoryVo);
	    model.addAttribute("categoryForm", categoryForm);
	
	    List categoryFormSubList = this.eduService.getEduCationDetailSub(categoryVo);
	    model.addAttribute("categoryFormSubList", categoryFormSubList);
	
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduInfoNoOrglineReg";
  }

  /*
   * 오프라인 교육[기관외] 교육 저장
   */
  @RequestMapping({"/eduInfoNoOrglineSave.do"})
  @ResponseBody
  public CategoryVo eduInfoNoOrglineSave(HttpServletRequest request, CategoryVo categoryVo) throws Exception {
	    int resultCnt = 0;
	    try
	    {
	      LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");
	
	      categoryVo.setReg_id(loginvo.getId());
	
	      if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	        categoryVo.setGubun2("eduInfoNoOrgline");
	      }
	
	      if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
	          categoryVo.setEdu_site("nooff");
	      }
	
	      if (StringUtil.isEmpty(categoryVo.getSite())) {
	          categoryVo.setSite("off");
	      }
	
	      if (StringUtil.isEmpty(categoryVo.getFileExit())) {
	        categoryVo.setFileExit("NO");
	      }
	
	      String fileAddpath = this.filePath + File.separator + categoryVo.getGubun2();
	
	      if ("I".equals(categoryVo.getGubun1()))
	      {
	        if ("YES".equals(categoryVo.getFileExit())) {
	          BoardVo fileVo = FileUtil.uploadFile(request, fileAddpath);
	          categoryVo.setFile_uuid(fileVo.getFile_uuid());
	          categoryVo.setFile_name(fileVo.getFile_name());
	          categoryVo.setFile_full_path(fileVo.getFile_full_path());
	          categoryVo.setFile_size(fileVo.getFile_size());
	          categoryVo.setEdu_notice(fileVo.getFile_uuid());
	        }
	
	        resultCnt = this.eduService.insertEducation(categoryVo);
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	
	      
	      if ("E".equals(categoryVo.getGubun1()))
	      {
	    	CategoryVo fileCategoryVo = this.eduService.getEduCationFile(categoryVo);
		    String fileFullPath = "";
			if( fileCategoryVo !=null) {
				fileFullPath = fileCategoryVo.getFile_full_path();
			}	 
		        
	        if ("YES".equals(categoryVo.getFileExit())) {
	          BoardVo fileVo = FileUtil.uploadFile(request, fileAddpath);
	          categoryVo.setFile_uuid(fileVo.getFile_uuid());
	          categoryVo.setFile_name(fileVo.getFile_name());
	          categoryVo.setFile_full_path(fileVo.getFile_full_path());
	          categoryVo.setFile_size(fileVo.getFile_size());
	        }
	
	        resultCnt = this.eduService.updateEduCation(categoryVo);
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	
	        if ((resultCnt > 0) && ("YES".equals(categoryVo.getFileExit())))
	        {
	          if ((fileFullPath != null) && (fileFullPath.length() > 3))
	          {
	            FileUtil.deleteFile(request, fileFullPath);
	          }
	
	        }
	
	      }
	
	      if ("D".equals(categoryVo.getGubun1())) {
	    	  
	    	CategoryVo fileCategoryVo = this.eduService.getEduCationFile(categoryVo);
		    String fileFullPath = "";
			if( fileCategoryVo !=null) {
				fileFullPath = fileCategoryVo.getFile_full_path();
			}
	        resultCnt = this.eduService.deleteEduCation(categoryVo);
	        if ((fileFullPath != null) && (fileFullPath.length() > 3)) {
	          FileUtil.deleteFile(request, fileFullPath);
	        }
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	
	      if ("A".equals(categoryVo.getGubun1())) {
	        String[] ArraysStr = categoryVo.getCheckdstr().split(",");
	        for (String s : ArraysStr) {
	          categoryVo.setEdu_no(Integer.parseInt(s));
	         
	          CategoryVo fileCategoryVo = this.eduService.getEduCationFile(categoryVo);
		      String fileFullPath = "";
			  if( fileCategoryVo !=null) {
				  fileFullPath = fileCategoryVo.getFile_full_path();
			  }
	          
			  resultCnt = this.eduService.deleteEduCation(categoryVo);
	          if ((fileFullPath != null) && (fileFullPath.length() > 3)) {
	            FileUtil.deleteFile(request, fileFullPath);
	          }
	        }
	        categoryVo.setResult(resultCnt > 0 ? "SUCCESS" : "FAIL");
	      }
	    }
	    catch (Exception e)
	    {
	      categoryVo.setResult("FAIL");
	    }
	
	    return categoryVo;
  }
  
  @RequestMapping({"/excelDownloadOnLine.do"})
  public ModelAndView excelDownloadOnLine(@ModelAttribute("categoryVo") CategoryVo categoryVo)
    throws Exception
  {
	    categoryVo.setRecordCountPerPage(10000);
	    categoryVo.setOffset(0);
	    categoryVo.setGubun1("R");
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoOnline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
	      categoryVo.setEdu_site("off");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getSite())) {
	      categoryVo.setSite("on");
	    }
	
	    List list = this.eduService.getEducationList(categoryVo);
	
	    Map map = new HashMap();
	    map.put("list", list);
	    map.put("categoryVo", categoryVo);
	    map.put("filename", categoryVo.getExcelFileName());
	
	    return new ModelAndView("onLineEducationExcelView", map);
  }
  
  @RequestMapping({"/fileDownload.do"})
  @ResponseBody
  public void fileDownload(HttpServletRequest request, HttpServletResponse response, CategoryVo categoryVo)
    throws Exception
  {
	CategoryVo fileCategoryVo = this.eduService.getEduCationFile(categoryVo);
	
    BoardVo boardVoForm = new BoardVo();
    boardVoForm.setFile_uuid(fileCategoryVo.getFile_uuid());
    boardVoForm.setFile_name(fileCategoryVo.getFile_name());
    boardVoForm.setFile_full_path(fileCategoryVo.getFile_full_path());
    boardVoForm.setFile_size(fileCategoryVo.getFile_size());	 

    FileUtil.fileDownload(request, response, boardVoForm);
  }
  
  /*
  * 온라인 교육 관리 List
  */
 @RequestMapping({"/eduInfoOnlineMangList.do"})
 public String eduInfoOnlineMangList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
   throws Exception
 {
	    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
	    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));
	
	    PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
	    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
	    paginationInfo.setPageSize(categoryVo.getPageSize());
	
	    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	    categoryVo.setOffset(offset);
	
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoOnline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
	        categoryVo.setEdu_site("on");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getSite())) {
	        categoryVo.setSite("on");
	    }
	    
	    categoryVo.setWebPath(this.webPath);
	
	    categoryVo.setGubun3("categorycode1");
	    List category1list = this.eduService.getCategoryCodeList(categoryVo);
	    model.addAttribute("category1list", category1list);
	
	    List list = this.eduService.getEducationList(categoryVo);
	    model.addAttribute("resultList", list);
	
	    int totCnt = this.eduService.getEducationCount(categoryVo);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduInfoOnlineMangList";
 }
  
  /*
   * 오프라인 교육 관리 List
   */
  @RequestMapping({"/eduInfoNoOrglineMangList.do"})
  public String eduInfoNoOrglineMangList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
	    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
	    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));
	
	    PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
	    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
	    paginationInfo.setPageSize(categoryVo.getPageSize());
	
	    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	    categoryVo.setOffset(offset);
	
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoNoOrgline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
		    categoryVo.setEdu_site("nooff");
	    }
		
		if (StringUtil.isEmpty(categoryVo.getSite())) {
		   categoryVo.setSite("off");
		}
	    
		categoryVo.setWebPath(this.webPath);
	
	    categoryVo.setGubun3("categorycode1");
	    List category1list = this.eduService.getCategoryCodeList(categoryVo);
	    model.addAttribute("category1list", category1list);
	
	    List list = this.eduService.getEducationList(categoryVo);
	    model.addAttribute("resultList", list);
	
	    int totCnt = this.eduService.getEducationCount(categoryVo);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduInfoNoOrglineMangList";
  }

  /*
   * 기관(결과보고) > 교육신청현황  List
   */
  @RequestMapping({"/eduStatustList.do"})
  public String eduStatustList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
	    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
	    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));
	
	    PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
	    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
	    paginationInfo.setPageSize(categoryVo.getPageSize());
	
	    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	    categoryVo.setOffset(offset);
	
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoNoOrgline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
		    categoryVo.setEdu_site("nooff");
	    }
		
		if (StringUtil.isEmpty(categoryVo.getSite())) {
		   categoryVo.setSite("off");
		}
	    
		categoryVo.setWebPath(this.webPath);
	
	    categoryVo.setGubun3("categorycode1");
	    List category1list = this.eduService.getCategoryCodeList(categoryVo);
	    model.addAttribute("category1list", category1list);
	
	    List list = this.eduService.getEducationList(categoryVo);
	    model.addAttribute("resultList", list);
	
	    int totCnt = this.eduService.getEducationCount(categoryVo);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduStatustList";
  }
  
  /*
   * 기관(결과보고) > 교육명 별 신청자  List
   */
  @RequestMapping({"/eduTitleList.do"})
  public String eduTitleList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)
    throws Exception
  {
	    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
	    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));
	
	    PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
	    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
	    paginationInfo.setPageSize(categoryVo.getPageSize());
	
	    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	    categoryVo.setOffset(offset);
	
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoNoOrgline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
		    categoryVo.setEdu_site("nooff");
	    }
		
		if (StringUtil.isEmpty(categoryVo.getSite())) {
		   categoryVo.setSite("off");
		}
	    
		categoryVo.setWebPath(this.webPath);
	
	    categoryVo.setGubun3("categorycode1");
	    List category1list = this.eduService.getCategoryCodeList(categoryVo);
	    model.addAttribute("category1list", category1list);
	
	    List list = this.eduService.getEducationList(categoryVo);
	    model.addAttribute("resultList", list);
	
	    int totCnt = this.eduService.getEducationCount(categoryVo);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduTitleList";
  }
  
  /*
   * 기관(결과보고) > 교육 결과 보고  List
   */
  @RequestMapping({"/eduReportList.do"})
  public String eduReportList(@ModelAttribute("categoryVo") CategoryVo categoryVo, ModelMap model)  throws Exception
  {
	    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
	    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));
	
	    PaginationInfo paginationInfo = new PaginationInfo();
	    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
	    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
	    paginationInfo.setPageSize(categoryVo.getPageSize());
	
	    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
	    categoryVo.setOffset(offset);
	
	    if (StringUtil.isEmpty(categoryVo.getGubun1())) {
	      categoryVo.setGubun1("R");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getGubun2())) {
	      categoryVo.setGubun2("eduInfoNoOrgline");
	    }
	
	    if (StringUtil.isEmpty(categoryVo.getEdu_site())) {
		    categoryVo.setEdu_site("nooff");
	    }
		
		if (StringUtil.isEmpty(categoryVo.getSite())) {
		   categoryVo.setSite("off");
		}
	    
		categoryVo.setWebPath(this.webPath);
	
	    categoryVo.setGubun3("categorycode1");
	    List category1list = this.eduService.getCategoryCodeList(categoryVo);
	    model.addAttribute("category1list", category1list);
	
	    List list = this.eduService.getEducationList(categoryVo);
	    model.addAttribute("resultList", list);
	
	    int totCnt = this.eduService.getEducationCount(categoryVo);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("categoryVo", categoryVo);
	
	    return "eduReportList";
  }
}