<%@ page pageEncoding="UTF-8"%>
<nav>
    <ul id="menu">
       <li><a href="${pageContext.request.contextPath}/">Home</a></li>
       <li><a href="${pageContext.request.contextPath}/login.do">login List</a></li>
       <li><a href="${pageContext.request.contextPath}/logout.do">logout List</a></li>
       <li><a href="${pageContext.request.contextPath}/employeeList.do">사원리스트 List</a></li>
       <li><a href="${pageContext.request.contextPath}/departmentList.do?depth=1">부서정보</a></li>	
       <li><a href="${pageContext.request.contextPath}/board/boardList.do">게시판</a></li>

    </ul>
</nav>
