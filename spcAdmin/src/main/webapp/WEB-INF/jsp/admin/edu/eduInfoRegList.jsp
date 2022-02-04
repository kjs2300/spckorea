
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <script type="text/javaScript" language="javascript" defer="defer">
     <!--
    
     function fn_load(str) {
    	var frm = document.commonForm;
     	frm.action = "<c:url value='/edu/eduInfoRegCate.do'/>";
    	frm.submit();
     }
     
	  /* pagination 페이지 링크 function */
     function fn_egov_link_page(pageNo){
     	document.listForm.pageIndex.value = pageNo;
     	document.listForm.action = "<c:url value='/board/boardList.do'/>";
        	document.listForm.submit();
     }
     
     //-->
 </script>
 
                <h1 class="h1-tit">교육안내 등록</h1>
				<form  id="commonForm" name="commonForm"  method="post"  action="">
					<input type="hidden" id="gubun1"         name="gubun1"   value='I'            class="input-box" />
 				    <input type="hidden" id="gubun2"         name="gubun2"   value='category1'    class="input-box" />	
 				    <input type="hidden" id="pageIndex"      name="pageIndex"      class="input-box" value=1 />	
	           </form>
	                <div class="sub-cont">
	                    <button type="button" class="mid-btn black-btn">전체분류 보기</button>
	                    <button type="button" class="mid-btn blue-btn" onClick="fn_load('1');">등록</button>
	                </div>
               
                <div class="table-wrap">
                    <table class="list-tb">
                        <caption>카테고리1, 카테고리2, 카테고리3, 관리 정보가 있는 테이블</caption>
                        <colgroup>
                            <col width="30%"/>
                            <col width="30%"/>
                            <col width="30%"/>
                          </colgroup>
                        <thead>
                            <tr>
                                <th>카테고리01</th>
                                <th>카테고리02</th>
                                <th>카테고리03</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="result" items="${resultList}" varStatus="status">
                            <tr>
                                <td>${result.category1_name}</td>
                                <td>${result.category2_name}</td>
                                <td>${result.category3_name}</td>
                            </tr>
                            </c:forEach>
	                        <c:if test="${empty resultList }">
				             <tr>
				                 <td colspan='3'/>Data 없습니다.</td>
				             </tr>
				        	</c:if>
                        </tbody>
                    </table>
                </div>
                <div class="page-wrap">
             	 <ul class="paging">
	    			<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
	  	  		 </ul>
	            </div>
           