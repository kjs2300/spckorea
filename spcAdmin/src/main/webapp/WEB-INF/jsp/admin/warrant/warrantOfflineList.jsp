<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript" src="<c:url value='/resources/common/jquery.js'/>"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>

<h1 class="h1-tit">일반 수료증</h1>

<div class="tab-cont">
    <ul>
        <li><a href="<c:url value='/warrant/warrantGeneralDefault.do' />">기본 양식</a></li>
        <li><a href="<c:url value='/warrant/warrantOnlineList.do' />">온라인 등록</a></li>
        <li class="on"><a href="<c:url value='/warrant/warrantOfflineList.do' />">오프라인 등록</a></li>
        <li><a href="<c:url value='/warrant/warrantOrgList.do' />">기관교육 등록</a></li>
    </ul>
</div>

<div class="search-wrap">
    <form id="listForm" name="listForm" target="_self" action="/warrant/warrantOfflineList.do" method="post" onsubmit="">
    <input type="hidden" id="license_idx"   name="license_idx"  value="${warrantVo.license_idx}"/>
    <input type="hidden" id="gubun1"      name="gubun1"     value='I'   />
    <input type="hidden" id="license_type"   name="license_type"  value="B"/>
    <div class="search-cont">
        <select class="select">
            <option>분류1</option>
        </select>

        <select class="select">
            <option>분류2</option>
        </select>

        <select class="select">
            <option>분류3</option>
        </select>

        <button class="search-btn">검색</button>
        <button class="search-btn white-btn ml20">초기화</button>
    </div>
    </form>

</div>

<div class="btn-cont mb20">
    <button class="mid-btn blue-btn" onclick="location.href = '<c:url value='/warrant/warrantOfflineReq.do' />'; ">등록</button>
    <button class="mid-btn white-btn" onClick="javascript:btnDel();">선택삭제</button>
</div>

<div class="table-wrap">
    <table class="list-tb">
        <caption>선택, 분류1, 분류2, 분류3(교육명), 교육일(종료일), 수료증 발급 활성화, 등록일, 관리 정보가 있는 테이블</caption>
        <colgroup>
            <col width="5%"/>
            <col width="5%"/>
            <col width="9%"/>
            <col width="11%"/>
            <col width="*"/>
            <col width="11%"/>
            <col width="11%"/>
            <col width="11%"/>
            <col width="15%"/>
        </colgroup>
        <thead>
            <tr>
                <th><input type="checkbox" class="check-box"/></th>
                <th>No.</th>
                <th>분류1</th>
                <th>분류2</th>
                <th>분류3(교육명)</th>
                <th>교육일<br/>(종료일)</th>
                <th>수료증 발급<br/>활성화</th>
                <th>등록일</th>
                <th>관리</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="result" items="${resultList}" varStatus="status">
	            <tr>
	                <td><input type="checkbox" id='checkNo' name='checkNo' value="${result.license_idx}" class="check-box"/></td>
	                <td>${status.index + 1}</td>
	                <td>${result.category1_name}</td>
	                <td>${result.category2_name}</td>
	                <td class="tl">${result.category3_name}</td>
	                <td>2021.10.05</td>
	                <td><c:if test="${result.license_status}">비활성</c:if> <c:if test="${!result.license_status}">활성</c:if></td>
	                <td>${result.reg_dt}</td>
	                <td>
	                    <button class="sm-btn black-btn" onClick="javascript:fn_edit('${result.license_idx}',  'E', 'warrantOfflineList');">수정</button>
	                    <button class="sm-btn white-btn" onClick="javascript:fn_delete('${result.license_idx}');">삭제</button>
	                </td>
	            </tr>
            </c:forEach>
            <c:if test="${empty resultList }">
	             <tr>
	                 <td colspan='9'/>Data 없습니다.</td>
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

<script type="text/javascript">
 
 $(document).ready(function(){
 });
 
function fn_edit(key1, str) {
 	var frm = document.listForm;
 	$("#license_idx").val(key1);
  	frm.action = "<c:url value='/warrant/warrantOfflineReq.do'/>";
 	frm.submit();
}

function fn_delete(idx) {
	var idxArray = new Array();

	idxArray.push(idx);
	if(confirm('삭제 처리하시겠습니까?')) {
		setDel(idxArray);
	}

}

var btnDel = function() {

	var idxArray = new Array();

	$("input[name=checkNo]:checked").each(function() {
		idxArray.push($(this).val());
	});

	if(idxArray.length < 1){
		alert("선택한 내역이 없습니다.");
		return false;
	}
	
	if(confirm('삭제 처리하시겠습니까?')) {
		setDel(idxArray);
	}
	
};

var setDel = function(idxArray){
    $.ajax({
        url: "/warrant/warrantDel.do",
        type: "POST",
        data: { "boardIdxArray" : idxArray },
        success: function(data) {
        	if(data == 'SUCCESS'){
        		alert("처리 완료하였습니다.");
        		location.reload();
        	}
        },
        error: function(data) {
        	console.log(JSON.stringify(data));
        	alert("처리중 오류가 발생했습니다.");
        }
    });
};

 </script>