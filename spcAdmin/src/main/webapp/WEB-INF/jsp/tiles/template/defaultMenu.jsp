<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 
path 사용하기 위해 
Controller에 추가하면 사용 가능.
model.addAttribute("path", request.getServletPath());
 -->
 <ul class="depth01-menu">
    <li <c:if test="${fn:contains(path, '/main/logo') || fn:contains(path, '/main/img')  || fn:contains(path, '/main/banner') || fn:contains(path, '/main/popup') }">  class="on" </c:if> >
        <a href="#">메인화면</a>
        <ul class="depth02-menu">
            <li <c:if test="${fn:contains(path, '/main/logo')}">   class="active" </c:if> ><a href="<c:url value='/main/logoList.do' />">  로고        </a></li>
            <li <c:if test="${fn:contains(path, '/main/img')}">    class="active" </c:if> ><a href="<c:url value='/main/imgList.do'    />">메인이미지 </a></li>
            <li <c:if test="${fn:contains(path, '/main/banner')}"> class="active" </c:if> ><a href="<c:url value='/main/bannerList.do' />">배너관리    </a></li>
            <li <c:if test="${fn:contains(path, '/main/popup')}">  class="active" </c:if> ><a href="<c:url value='/main/popupList.do' />"> 팝업창 관리 </a></li>
        </ul>
    </li> 
    <li <c:if test="${fn:contains(path, '/edu/eduInfoReg') || fn:contains(path, '/edu/eduInfoSchedule') }">  class="on" </c:if> >
        <a href="#">교육안내</a>
        <ul class="depth02-menu">
            <li <c:if test="${fn:contains(path, '/edu/eduInfoReg')}">        class="active" </c:if> > <a href="<c:url value='/edu/eduInfoRegList.do' />">     교육안내 등록</a></li>
            <li <c:if test="${fn:contains(path, '/edu/eduInfoSchedule')}">   class="active" </c:if> > <a href="<c:url value='/edu/eduInfoScheduleList.do' />">교육일정      </a></li>
        </ul>
    </li>
    <li <c:if test="${fn:contains(path, '/edu/eduInfoOffline') ||fn:contains(path, '/edu/eduInfoNoOrgline') || fn:contains(path, '/edu/eduInfoClass') || fn:contains(path, '/edu//edu/eduInfoOnlineList') }">  class="on" </c:if> >
        <a href="#">교육등록</a>
        <ul class="depth02-menu">
            <li <c:if test="${fn:contains(path, '/edu/eduInfoClass')}">   class="active" </c:if> > <a href="<c:url value='/edu/eduInfoClassList.do'  />">교육분류 등록  </a></li>
            <li <c:if test="${fn:contains(path, '/edu/eduInfoOnlineList')  || fn:contains(path, '/edu/eduInfoOnlineReg')}">  class="active" </c:if> > <a href="<c:url value='/edu/eduInfoOnlineList.do' />">온라인 교육    </a></li>
            <li <c:if test="${fn:contains(path, '/edu/eduInfoOffline')  || fn:contains(path, '/edu/eduInfoNoOrgline')}">  class="active" </c:if> > <a href="<c:url value='/edu/eduInfoOfflineList.do'/>">오프라인 교육</a></li>
        </ul>
    </li>
    <li <c:if test="${fn:contains(path, '/edu/eduInfoOnlineMang')}">   class="on" </c:if> >
        <a href="#">교육신청</a>
        <ul class="depth02-menu">
            <li <c:if test="${fn:contains(path, '/edu/eduInfoOnlineMang')}">   class="active" </c:if> ><a href="<c:url value='/edu/eduInfoOnlineMangList.do'/>">신청자 관리</a></li>
        </ul>

    </li>
    <li <c:if test="${fn:contains(path, '/edu/eduStatus') || fn:contains(path, '/edu/eduTitle') || fn:contains(path, '/edu/eduReport') }">  class="on" </c:if> >
        <a href="#">기관(결과보고)</a>
        <ul class="depth02-menu">
            <li <c:if test="${fn:contains(path, '/edu/eduStatus')}">   class="active" </c:if>><a href="<c:url value='/edu/eduStatustList.do'/>">기관(결과보고)</a></li>
            <li <c:if test="${fn:contains(path, '/edu/eduTitle')}">    class="active" </c:if>><a href="<c:url value='/edu/eduTitleList.do'/>">  교육신청 현황</a></li>
            <li <c:if test="${fn:contains(path, '/edu/eduReport')}">   class="active" </c:if>><a href="<c:url value='/edu/eduReportList.do'/>"> 교육결과 보고</a></li>
        </ul>
    </li>
    <li>
        <a href="#">강사공간</a>
        <ul class="depth02-menu">
            <li><a href="#">강사 자격정보</a></li>
            <li><a href="#">강사 활동 지정</a></li>
            <li><a href="#">강사 활동 현황</a></li>
            <li><a href="#">강사 활동 신청현황</a></li>
            <li><a href="#">강사 휴직 신청</a></li>
        </ul>
    </li>
    <li>
        <a href="#">LMS</a>
        <ul class="depth02-menu">
            <li><a href="#">콘텐츠/교육자료 등록</a></li>
            <li><a href="#">퀴즈 등록</a></li>
            <li><a href="#">수강생/수료생 현황</a></li>
        </ul>
    </li>
 
	<li <c:if test="${path =='/adBoard/noticeList.do' || path =='/adBoard/referenceList.do' || adBoard =='/adBoard/faqList.do' || adBoard =='/adBoard/partiList.do'|| adBoard =='/adBoard/instructList.do'|| adBoard =='/adBoard/instructReferList.do'}">  class="on" </c:if> >
        <a href="#">게시판</a>
        <ul class="depth02-menu">
            <li <c:if test="${path =='/adBoard/noticeList.do'}" >        class="active" </c:if>><a href="<c:url value='/adBoard/noticeList.do' />">공지사항</a></li>
            <li <c:if test="${path =='/adBoard/referenceList.do'}" >     class="active" </c:if>><a href="<c:url value='/adBoard/referenceList.do' />">자료실</a></li>
            <li <c:if test="${path =='/adBoard/faqList.do'}" >           class="active" </c:if>><a href="<c:url value='/adBoard/faqList.do' />">FAQ</a></li>
            <li <c:if test="${path =='/adBoard/partiList.do'}" >         class="active" </c:if>><a href="<c:url value='/adBoard/partiList.do' />">참여마당</a></li>
            <li <c:if test="${path =='/adBoard/instructList.do'}" >      class="active" </c:if>><a href="<c:url value='/adBoard/instructList.do' />">강사 공지사항</a></li>
            <li <c:if test="${path =='/adBoard/instructReferList.do'}" > class="active" </c:if>><a href="<c:url value='/adBoard/instructReferList.do' />">강사 자료실</a></li>
        </ul>
    </li>
    <li>
        <a href="#">수료증/기타</a>    
    </li>
</ul>