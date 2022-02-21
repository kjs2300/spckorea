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
import com.easycompany.service.EduService;
import com.easycompany.service.AdBoardService;
import com.easycompany.service.vo.AdBoardVo;
import com.easycompany.service.vo.MainVo;
import com.easycompany.service.vo.CategoryVo;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping({"user"})
public class WebMainController
{

  @Autowired
  private MainService mainService;
  
  @Autowired
  private EduService eduService;
  
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
   * 생명지킴이 교육신청 > 교육신청  > 온라인교육
   */
  @RequestMapping({"/lifeEduOnLieList.do"})
  public String lifeEduOnLieList(@ModelAttribute("CategoryVo") CategoryVo categoryVo, ModelMap model, HttpServletRequest request)
    throws Exception
  {
   
	LoginVo loginvo = (LoginVo)WebUtils.getSessionAttribute(request, "AdminAccount");
	  
   	categoryVo.setGubun1("R");
   	categoryVo.setGubun2("lifeEduOnLieList");
    
   	String edu_status ="신청중";
   	String edu_site   = "on";
    //  온라인에서 Category1_key 1: 일반, 2: 실무자  3:강사
   	/*
   	on	1	1	12	일반	온라인교육	일반 온라인 교육1
	on	1	1	13	일반	온라인교육	일반 온라인 교육2
	on	1	2	14	일반	생명지킴이 강사 양성 교육	생명지킴이 양성교육1
	on	3	7	15	강사	강사 보수 교육	강사교육1
	on	2	3	16	실무자	실무자 역량 강화 교육	실무자 역량 강화 교육1
	on	2	4	17	실무자	자살유족 서비스 제공 인력 교육	자살유족 서비스 제공 인력 교육1
	on	2	5	18	실무자	광역주도형 심리부검 주면담원 양성교육	광역주도형 심리부검 주면담원 양성교육1
	on	2	6	19	실무자	자살사후대응 전문가 양성교육	자살사후대응 전문가 양성교육1
	off	4	8	20	일반	생명지킴이 강사 양성 교육	생명지킴이 강사 양성 교육1
	off	5	9	21	실무자	실무자 역량 강화 교육	실무자 역량 강화 교육1
	off	5	10	22	실무자	자살유족 서비스 제공 인력 교육	자살유족 서비스 제공 인력 교육1
	off	5	11	23	실무자	광역주도형 심리부검 주면담원 양성교육	광역주도형 심리부검 주면담원 양성교육1
	off	5	12	24	실무자	자살사후대응 전문가 양성교육	자살사후대응 전문가 양성교육1
	off	7	14	1	기관	교육개설	보고듣고말하기 2.0 기본형

   	 */
    categoryVo.setCategory1_key(1);
    categoryVo.setCategory2_key(1);
    categoryVo.setEdu_site(edu_site);
    categoryVo.setEdu_status(edu_status);
  
    
    categoryVo.setPageUnit(this.propertiesService.getInt("pageUnit"));
    categoryVo.setPageSize(this.propertiesService.getInt("pageSize"));

    PaginationInfo paginationInfo = new PaginationInfo();
    paginationInfo.setCurrentPageNo(categoryVo.getPageIndex());
    paginationInfo.setRecordCountPerPage(categoryVo.getPageUnit());
    paginationInfo.setPageSize(categoryVo.getPageSize());

    int offset = (paginationInfo.getCurrentPageNo() - 1) * paginationInfo.getPageSize();
    categoryVo.setOffset(offset);
 
    if (StringUtil.isEmpty(categoryVo.getSort_ordr())) {
        categoryVo.setSort_ordr("TRAIN_S_DATE");
    }
    
    if (StringUtil.isEmpty(categoryVo.getSearchCondition())) {
        categoryVo.setSearchCondition("CATEGORY3_NAME");
    }
    
    List list = this.eduService.getEducationList(categoryVo);
    model.addAttribute("resultList", list);

    int totCnt = this.eduService.getEducationCount(categoryVo);
    paginationInfo.setTotalRecordCount(totCnt);
    model.addAttribute("paginationInfo", paginationInfo);    
     
    categoryVo.setCategory3_key(0);
    //분류1
    categoryVo.setGubun3("categorycode1");
    List category1list = this.eduService.getCategoryCodeList(categoryVo);
    model.addAttribute("category1list", category1list);
    
    //분류2
    categoryVo.setGubun3("categorycode2");
    List category2list = this.eduService.getCategoryCodeList(categoryVo);
    model.addAttribute("category2list", category2list);
        
    //분류3
    categoryVo.setGubun3("categorycode3");
    List category3list = this.eduService.getCategoryCodeList(categoryVo);
    model.addAttribute("category3list", category3list);
        
    categoryVo.setWebPath(this.webPath);
    model.addAttribute("categoryVo", categoryVo);
    model.addAttribute("path",       request.getServletPath());

    return "lifeEduOnLieList";
  }
  
  /*
   * 생명지킴이 교육신청 > 교육신청  > 교육 기관별
   */
  @RequestMapping({"/lifeEduOrgList.do"})
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

    return "lifeEduOrgList";
  }
  
  /*
   * 생명지킴이 교육신청 > 교육일정  
   */
  @RequestMapping({"/lifeEduSch.do"})
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

    return "lifeEduSch";
  }
  
  /*
   * 생명지킴이 교육신청 > 생명지킴이 활동 수기  
   */
  @RequestMapping({"/lifeEduBoard.do"})
  public String lifeEduBoard(@ModelAttribute("MainVo") MainVo mainVo, ModelMap model, HttpServletRequest request)
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

    return "lifeEduBoard";
  }
}