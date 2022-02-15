<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>

 <div class="lnb-wrap">
 	  <c:if test="${fn:contains(path, '/user/summaryList')}">
	      <aside class="tit">개요</aside>
	      <div class="lnb-menu">
	          <ul>
	                 <li <c:if test="${path =='/user/summaryList01.do'}">   class="on" </c:if>>
	                 	<a href="${pageContext.request.contextPath}/user/summaryList01.do">생명지킴이란?</a>
	                 </li>
		             <li <c:if test="${path =='/user/summaryList02.do'}">   class="on" </c:if>>
		             	<a href="${pageContext.request.contextPath}/user/summaryList02.do">생명지킴이 교육 강사</a>
		             </li>
		             <li <c:if test="${path =='/user/summaryList03.do'}">   class="on" </c:if>>
		             	<a href="${pageContext.request.contextPath}/user/summaryList03.do">자살 유족 서비스 전문가</a>
		             </li>
		             <li <c:if test="${path =='/user/summaryList04.do'}">   class="on" </c:if>>
		             	<a href="${pageContext.request.contextPath}/user/summaryList04.do">심리부검 주면담원</a>
		             </li>
		             <li <c:if test="${path =='/user/summaryList05.do'}">   class="on" </c:if>>
		             	<a href="${pageContext.request.contextPath}/user/summaryList05.do">자살 사후대응 전문가</a>
		            </li>
		      </ul>
	      </div>
     </c:if>
      <c:if test="${fn:contains(path, '/user/info')}">
	      <aside class="tit">개요</aside>
	      <div class="lnb-menu">
	          <ul>
	                 <li <c:if test="${path =='/user/info01.do'}">   class="on" </c:if>>
	                 	<a href="${pageContext.request.contextPath}/user/info01.do">생명지킴이 교육</a>
	                 </li>
		             <li <c:if test="${path =='/user/info02.do'}">   class="on" </c:if>>
		             	<a href="${pageContext.request.contextPath}/user/info02.do">생명지킴이 강사<br/>양성 교육</a>
		             </li>
		             <li <c:if test="${path =='/user/info03.do'}">   class="on" </c:if>>
		             	<a href="${pageContext.request.contextPath}/user/info03.do">실무자 역량 강화 교육</a>
		             </li>
		             <li <c:if test="${path =='/user/info04.do'}">   class="on" </c:if>>
		             	<a href="${pageContext.request.contextPath}/user/info04.do">자살 유족 서비스제공<br/> 인력교육</a>
		             </li>
		             <li <c:if test="${path =='/user/info05.do'}">   class="on" </c:if>>
		             	<a href="${pageContext.request.contextPath}/user/info05.do">광역주도형 심리부검면담원<br/> 양성교육</a>
		            </li>
		            <li <c:if test="${path =='/user/info06.do'}">   class="on" </c:if>>
		             	<a href="${pageContext.request.contextPath}/user/info06.do">자살사후대응 전문가<br/> 양성교육</a>
		            </li>
		      </ul>
	      </div>
     </c:if>
  </div>