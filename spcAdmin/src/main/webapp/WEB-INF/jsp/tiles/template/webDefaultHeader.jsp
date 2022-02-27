<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>

	<div id="header">
        <div class="top-wrap">
            <a  href="${pageContext.request.contextPath}/user/webMain.do">홈</a>|<a>공지사항</a>|<a>마이페이지</a>|<a>나의 강의실</a>|<a>로그아웃</a>
        </div>

        <div class="nav-wrap">
            <a class="logo" href="${pageContext.request.contextPath}/user/webMain.do">
            	<c:if test="${not empty logoForm.logo_no }">
            		<c:set var="ppx" value="${fn:split(logoForm.file_name,'.')}" />
            		<img src="/${logoForm.webPath}/${logoForm.gubun2}/${logoForm.file_id}.${ppx[1]}"  alt="${logoForm.file_name}"/>
            	</c:if>
            	<c:if test="${empty logoForm.logo_no }">
            		<img src="${pageContext.request.contextPath}/user/images/common/logo.png" alt="생명존중희망재단 사용자 로고"/>
            	</c:if>
            	                
            </a>
            <nav id="navigation">
                <ul>
                    <li><a href="#">개요</a></li>
                    <li><a href="#">교육안내</a></li>
                    <li><a href="#">생명지킴이 교육신청</a></li>
                    <li><a href="#">분야별 교육신청</a></li>
                    <!-- 
                    <li><a href="#">기관회원 공간</a></li>
                     -->
                    <li><a href="#">생명지킴이 강사 공간</a></li>
                </ul>
            </nav>
        </div>
    </div>