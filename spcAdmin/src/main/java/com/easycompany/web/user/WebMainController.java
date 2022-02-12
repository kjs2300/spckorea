package com.easycompany.web.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycompany.cmm.util.StringUtil;
import com.easycompany.service.MainService;
import com.easycompany.service.vo.MainVo;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
@RequestMapping({"user"})
public class WebMainController
{

  @Autowired
  private MainService mainService;

  @Autowired
  protected EgovPropertyService propertiesService;

  @Value("#{dbinfo['file.path']}")
  private String filePath;

  @Value("#{dbinfo['web.path']}")
  private String webPath;

  /*
   * 사용자 페이지 메인 페이지
   */
  @RequestMapping({"/webMain.do"})
  public String webMain(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
   
    if (StringUtil.isEmpty(mainVo.getGubun1())) {
      mainVo.setGubun1("R");
    }
    if (StringUtil.isEmpty(mainVo.getGubun2())) {
      mainVo.setGubun2("logo");
    }
    mainVo.setWebPath(this.webPath);

    MainVo mainForm = this.mainService.getCommonDetail(mainVo);

    model.addAttribute("mainVo",    mainVo);
    model.addAttribute("mainForm",  mainForm);
    model.addAttribute("path",      request.getServletPath());

    return "webMain";
  }

  /*
   * 사용자 페이지 > 개요
   */
  @RequestMapping({"/summaryList.do"})
  public String summaryList(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
   
    if (StringUtil.isEmpty(mainVo.getGubun1())) {
      mainVo.setGubun1("R");
    }
    if (StringUtil.isEmpty(mainVo.getGubun2())) {
      mainVo.setGubun2("logo");
    }
    mainVo.setWebPath(this.webPath);

    MainVo mainForm = this.mainService.getCommonDetail(mainVo);

    model.addAttribute("mainVo",    mainVo);
    model.addAttribute("mainForm",  mainForm);
    model.addAttribute("path",      request.getServletPath());

    return "summaryList";
  }
  
  /*
   * 사용자 페이지 > 교육안내 > 일반 교육안내
   */
  @RequestMapping({"/normalInfo.do"})
  public String normalInfo(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
   
    if (StringUtil.isEmpty(mainVo.getGubun1())) {
      mainVo.setGubun1("R");
    }
    if (StringUtil.isEmpty(mainVo.getGubun2())) {
      mainVo.setGubun2("logo");
    }
    mainVo.setWebPath(this.webPath);

    MainVo mainForm = this.mainService.getCommonDetail(mainVo);

    model.addAttribute("mainVo",    mainVo);
    model.addAttribute("mainForm",  mainForm);
    model.addAttribute("path",      request.getServletPath());

    return "normalInfo";
  }
  
  /*
   * 사용자 페이지 > 생명지킴이교육 > 교육신청  > 온라인 생명 지킴이 교육
   */
  @RequestMapping({"/lifeReqOn.do"})
  public String lifeReqOn(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
   
    if (StringUtil.isEmpty(mainVo.getGubun1())) {
      mainVo.setGubun1("R");
    }
    if (StringUtil.isEmpty(mainVo.getGubun2())) {
      mainVo.setGubun2("logo");
    }
    mainVo.setWebPath(this.webPath);

    MainVo mainForm = this.mainService.getCommonDetail(mainVo);

    model.addAttribute("mainVo",    mainVo);
    model.addAttribute("mainForm",  mainForm);
    model.addAttribute("path",      request.getServletPath());

    return "lifeReqOn";
  }
  
  /*
   * 사용자 페이지 > 기관 회원 서비스  > 기관 회원 교육신청  >  교육소개 
   */
  @RequestMapping({"/userOrgInfo.do"})
  public String userOrgInfo(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
   
    if (StringUtil.isEmpty(mainVo.getGubun1())) {
      mainVo.setGubun1("R");
    }
    if (StringUtil.isEmpty(mainVo.getGubun2())) {
      mainVo.setGubun2("logo");
    }
    mainVo.setWebPath(this.webPath);

    MainVo mainForm = this.mainService.getCommonDetail(mainVo);

    model.addAttribute("mainVo",    mainVo);
    model.addAttribute("mainForm",  mainForm);
    model.addAttribute("path",      request.getServletPath());

    return "userOrgInfo";
  }
  
  /*
   * 사용자 페이지 > 생명지킴이 강사 공간   > 강사 공지사항
   */
  @RequestMapping({"/userInstNotiList.do"})
  public String userInstNotiList(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
   
    if (StringUtil.isEmpty(mainVo.getGubun1())) {
      mainVo.setGubun1("R");
    }
    if (StringUtil.isEmpty(mainVo.getGubun2())) {
      mainVo.setGubun2("logo");
    }
    mainVo.setWebPath(this.webPath);

    MainVo mainForm = this.mainService.getCommonDetail(mainVo);

    model.addAttribute("mainVo",    mainVo);
    model.addAttribute("mainForm",  mainForm);
    model.addAttribute("path",      request.getServletPath());

    return "userInstNotiList";
  }
}