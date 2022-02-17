package com.easycompany.web.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import com.easycompany.cmm.util.StringUtil;
import com.easycompany.cmm.vo.LoginVo;
import com.easycompany.service.MainService;
import com.easycompany.service.AdBoardService;
import com.easycompany.service.vo.AdBoardVo;
import com.easycompany.service.vo.MainVo;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
@RequestMapping({"user"})
public class WebMainController
{

  @Autowired
  private MainService mainService;
  
  @Autowired
  private AdBoardService adBoardService;

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
    
    //logo  가져오기
    mainVo.setGubun2("logo");
    MainVo logoForm = this.mainService.getCommonDetail(mainVo);
    logoForm.setWebPath(this.webPath);
    logoForm.setGubun2("logo");
    model.addAttribute("logoForm",  logoForm);
    
    //popup list 가져오기
    mainVo.setGubun2("popup");
    List popupList = this.mainService.getCommonList(mainVo);
    model.addAttribute("popupList", popupList);
    
    //image 가져오기
    mainVo.setGubun2("img");
    List imgList = this.mainService.getCommonList(mainVo);
    model.addAttribute("imgList", imgList);
    model.addAttribute("mainVo",  mainVo);
    
    //공지사항 가져오기
    AdBoardVo adBoardVo = new AdBoardVo();
    adBoardVo.setBoard_type("01");
    adBoardVo.setRecordCountPerPage(5);
    adBoardVo.setOffset(0);
	List<AdBoardVo> notiList = adBoardService.getBoardList(adBoardVo);
	model.addAttribute("notiList", notiList);
	
    
    model.addAttribute("path",    request.getServletPath());

    return "webMain";
  }

  
  @RequestMapping({"/popup.do"})
  public String popupReg(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");

    if (StringUtil.isEmpty(mainVo.getGubun1())) {
      mainVo.setGubun1("R");
    }
    if (StringUtil.isEmpty(mainVo.getGubun2())) {
      mainVo.setGubun2("popup");
    }
    mainVo.setWebPath(this.webPath);

    MainVo mainForm = this.mainService.getCommonDetail(mainVo);

    mainVo.setReg_id(loginvo.getId());
    model.addAttribute("mainVo", mainVo);
    model.addAttribute("mainForm", mainForm);
    model.addAttribute("path", request.getServletPath());

    return "mainPop";
  }
  /*
   * 사용자 페이지 > 개요 > 생명지킴이
   */
  @RequestMapping({"/summaryList01.do"})
  public String summaryList01(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "summaryList01";
  }
  
  /*
   * 사용자 페이지 > 개요 > 생명지킴이 교육 강사
   */
  @RequestMapping({"/summaryList02.do"})
  public String summaryList02(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "summaryList02";
  }
  
  /*
   * 사용자 페이지 > 개요 > 자살 유족 서비스 전문가
   */
  @RequestMapping({"/summaryList03.do"})
  public String summaryList03(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "summaryList03";
  }
  
  /*
   * 사용자 페이지 > 개요 > 심리부검 주면담원
   */
  @RequestMapping({"/summaryList04.do"})
  public String summaryList04(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "summaryList04";
  }
  
  /*
   * 사용자 페이지 > 개요 > 자살 사후대응 전문가
   */
  @RequestMapping({"/summaryList05.do"})
  public String summaryList05(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "summaryList05";
  }
  
  /*
   * 교육안내  > 생명지킴이 강사양성 교육
   */
  @RequestMapping({"/info01.do"})
  public String info01(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "info01";
  }
  
  /*
   * 교육안내 > 생명지킴이 강사양성 교육
   */
  @RequestMapping({"/info02.do"})
  public String info02(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "info02";
  }
  
  
  /*
   * 교육안내 > 실무자 역량 강화 교육
   */
  @RequestMapping({"/info03.do"})
  public String info03(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "info03";
  }
  
  /*
   * 교육안내 > 자살 유족 서비스제공 인력교육
   */
  @RequestMapping({"/info04.do"})
  public String info04(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "info04";
  }
  
  /*
   * 교육안내 > 광역주도형 심리부검면담원 양성교육
   */
  @RequestMapping({"/info05.do"})
  public String info05(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "info05";
  }
  
  /*
   * 교육안내 > 자살사후대응 전문가 양성교육
   */
  @RequestMapping({"/info06.do"})
  public String info06(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
    model.addAttribute("path",      request.getServletPath());
    return "info06";
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