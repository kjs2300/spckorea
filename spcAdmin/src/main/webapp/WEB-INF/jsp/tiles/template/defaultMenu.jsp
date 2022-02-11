<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
 <ul class="depth01-menu">
    <li>
        <a href="#">메인화면</a>
        <ul class="depth02-menu">
            <li <c:if test="${path =='/main/logoList.do'}">   class="active" </c:if> ><a href="<c:url value='/main/logoList.do' />">  로고        </a></li>
            <li <c:if test="${path =='/main/imgList.do'}">    class="active" </c:if> ><a href="<c:url value='/main/imgList.do'    />">메인이미지 </a></li>
            <li <c:if test="${path =='/main/bannerList.do'}"> class="active" </c:if> ><a href="<c:url value='/main/bannerList.do' />">배너관리    </a></li>
            <li <c:if test="${path =='/main/popupList.do'}">  class="active" </c:if> ><a href="<c:url value='/main/popupList.do' />"> 팝업창 관리 </a></li>
        </ul>
    </li>
    <li>
        <a href="#">교육안내</a>
        <ul class="depth02-menu">
            <li><a href="<c:url value='/edu/eduInfoRegList.do' />">교육안내 등록</a></li>
            <li><a href="<c:url value='/edu/eduInfoScheduleList.do' />">교육일정</a></li>
        </ul>
    </li>
    <li>
        <a href="#">교육등록</a>
        <ul class="depth02-menu">
            <li><a href="<c:url value='/edu/eduInfoClassList.do'  />">교육분류 등록  </a></li>
            <li><a href="<c:url value='/edu/eduInfoOnlineList.do' />">온라인 교육    </a></li>
            <li><a href="<c:url value='/edu/eduInfoOfflineList.do'/>">오프라인 교육</a></li>
        </ul>
    </li>
    <li>
        <a href="#">교육신청</a>
        <ul class="depth02-menu">
            <li><a href="<c:url value='/edu/eduInfoOnlineMangList.do'/>">신청자 관리</a></li>
        </ul>

    </li>
    <li>
        <a href="#">기관(결과보고)</a>
        <ul class="depth02-menu">
            <li><a href="<c:url value='/edu/eduStatustList.do'/>">기관(결과보고)</a></li>
            <li><a href="<c:url value='/edu/eduTitleList.do'/>">교육신청 현황</a></li>
            <li><a href="<c:url value='/edu/eduReportList.do'/>">교육결과 보고</a></li>
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
	 <li>
        <a href="#">게시판</a>
        <ul class="depth02-menu">
            <li><a href="<c:url value='/adBoard/noticeList.do' />">공지사항</a></li>
            <li><a href="<c:url value='/adBoard/referenceList.do' />">자료실</a></li>
            <li><a href="<c:url value='/adBoard/faqList.do' />">FAQ</a></li>
            <li><a href="<c:url value='/adBoard/partiList.do' />">참여마당</a></li>
            <li><a href="<c:url value='/adBoard/instructList.do' />">강사 공지사항</a></li>
            <li><a href="<c:url value='/adBoard/instructReferList.do' />">강사 자료실</a></li>
        </ul>
    </li>
    <li>
        <a href="#">수료증/기타</a>    
    </li>
</ul>