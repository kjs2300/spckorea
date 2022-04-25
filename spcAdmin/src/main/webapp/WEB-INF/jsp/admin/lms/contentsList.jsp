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
 <script type="text/javaScript" language="javascript" defer="defer">
 $(document).ready(function(){		
	 $("#start_date, #end_date").datepicker({
		  	dateFormat: 'yy-mm-dd' //달력 날짜 형태
	       ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
		  ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
		  ,changeYear: true //option값 년 선택 가능
		  ,changeMonth: true //option값  월 선택 가능                
		  ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
		  ,buttonImage: "<c:url value='/images/common/ico_calendar.png'/>" //버튼 이미지 경로
		  ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
		  ,buttonText: "선택" //버튼 호버 텍스트              
		  ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
		  ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
		  ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
		  ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
		  ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
		  ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
		  ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
	});
	 
	 $('#category1_key').change(function(){
			var val  = $(this).val();

			if( val ==""){
				return;
			}
			
			$("#category2_key").val("");
					
			 $.ajax({	
			    url     : "<c:url value='/user/category2list.do'/>",
			    data    : $("#commonForm").serialize(),
		        dataType: "JSON",
		        cache   : false,
				async   : true,
				type	: "POST",	
				success: function(data, opt, inx){
				var option = '';
				option += '<option value="0">선택 하세요</opton>'; //선택
				$.each(data, function(i, ret){
					option += '<option value="'+ret.CATEGORY2_KEY+'">'+ret.CATEGORY2_NAME+'</option>';		
				});
				$('select[name=category2_key]').html(option);						
		        },	       
		        error 	: function(xhr, status, error) {}
		        
		     });
		 });
	 
	 $('#category2_key').change(function(){
			var val  = $(this).val();

			if( val ==""){
				return;
			}
			
			$("#category3_key").val("");
					
			 $.ajax({	
			    url     : "<c:url value='/user/category3list.do'/>",
			    data    : $("#commonForm").serialize(),
		        dataType: "JSON",
		        cache   : false,
				async   : true,
				type	: "POST",	
				success: function(data, opt, inx){
				var option = '';
				option += '<option value="0">선택 하세요</opton>'; //선택
				$.each(data, function(i, ret){
					option += '<option value="'+ret.CATEGORY3_KEY+'">'+ret.CATEGORY3_NAME+'</option>';		
				});
				$('select[name=category3_key]').html(option);						
		        },	       
		        error 	: function(xhr, status, error) {}
		        
		     });
		 });
 });
 
 function fn_clear(){
	 $("[type='text']").val("");
 }
 
 function fn_egov_link_page(pageNo){
	 var frm = document.commonForm;
	 $("#pageIndex").val(pageNo); 
 	 frm.action = "<c:url value='/adm/contentsList.do'/>";
   	 frm.submit();
 }
 
</script>
<h1 class="h1-tit">콘텐츠/교육자료 등록</h1>

<div class="search-wrap">
	<form id="listForm" name="listForm" target="_self" action="/lms/contentsList.do" method="post" onsubmit="">
    <input type="hidden" id="content_idx"   name="content_idx"  value="${content_idx}"/>
    <input type="hidden" id="gubun1"      name="gubun1"     value='I'   />
	    <div class="search-cont search-sub">
	        <h3 class="h3-tit">구분</h3>
	
	        <div class="radio-cont">
	            <input type="radio" class="radio-box" id="searchCondition" name="searchCondition" value="ALL" checked>
	            <label for="">전체</label>
	        </div>
	        <div class="radio-cont">
	            <input type="radio" class="radio-box" id="searchCondition" name="searchCondition" value="CATEGORY">
	            <select class="select"  id="category1_key" name="category1_key">
	            	<option value='' >선택 하세요</option>
					<c:forEach var="result" items="${category1list}" varStatus="status">
						<option value='${result.CATEGORY1_KEY}' >${result.CATEGORY1_NAME}</option>
					</c:forEach>
	            </select>
	                           <select class="select"  id="category2_key" name="category2_key">
	            	<option value='' >선택 하세요</option>
					<c:forEach var="result" items="${category2list}" varStatus="status">
						<option value='${result.CATEGORY2_KEY}' >${result.CATEGORY2_NAME}</option>
					</c:forEach>
	            </select>
	            <select class="select lg-width"  id="category3_key" name="category3_key">
	            	<option value='' >선택 하세요</option>
					<c:forEach var="result" items="${category3list}" varStatus="status">
						<option value='${result.CATEGORY3_KEY}' >${result.CATEGORY3_NAME}</option>
					</c:forEach>
	            </select>
	        </div>
	    </div>
	
	    <div class="search-cont search-sub">
	        <h3 class="h3-tit">교육현황</h3>
	
	        <div class="radio-cont">
	            <input type="radio" class="radio-box" id="edu_status" name="edu_status" value="ALL" <c:if test="${edu_status == 'ALL' || (empty edu_status)}">checked </c:if>>
	            <label for="">전체</label>
	        </div>
	        <div class="radio-cont">
	            <input type="radio" class="radio-box" id="edu_status" name="edu_status" value="2" <c:if test="${edu_status == '1'}">checked </c:if>>
	            <label for="">진행중(노출)</label>
	        </div>
	        <div class="radio-cont">
	            <input type="radio" class="radio-box" id="edu_status" name="edu_status" value="1" <c:if test="${edu_status == '1'}">checked </c:if>>
	            <label for="">대기중(미노출)</label>
	        </div>
	        <div class="radio-cont">
	            <input type="radio" class="radio-box" id="edu_status" name="edu_status" value="3" <c:if test="${edu_status == '3'}">checked </c:if>>
	            <label for="">종료</label>
	        </div>
	    </div>
	
	    <div class="search-cont search-sub">
	        <h3 class="h3-tit">콘텐츠</h3>
	
	        <div class="radio-cont">
	            <input type="radio" class="radio-box" id="con_chk" name="con_chk" value="ALL" <c:if test="${con_chk == 'ALL' || (empty con_chk)}">checked </c:if>>
	            <label for="">전체</label>
	        </div>
	        <div class="radio-cont">
	            <input type="radio" class="radio-box" id="con_chk" name="con_chk" value="1" <c:if test="${con_chk == '1'}">checked </c:if>>
	            <label for="">등록</label>
	        </div>
	        <div class="radio-cont">
	            <input type="radio" class="radio-box" id="con_chk" name="con_chk" value="2" <c:if test="${con_chk == '2'}">checked </c:if>>
	            <label for="">미등록</label>
	        </div>
	    </div>
	
	    <div class="search-cont">
	
	        <div class="radio-cont">
	            <input type="radio" class="radio-box" id="searchDate" name="searchDate" value="ALL" <c:if test="${searchDate == 'ALL' || (empty searchDate)}">checked </c:if>>
	            <label for="dateAll">전체</label>
	        </div>
	          
	        <div class="radio-cont mr10">
	            <input type="radio" class="radio-box" id="searchDate" name="searchDate" value="CHECK" <c:if test="${searchDate == 'CHECK'}">checked </c:if>>
	            <label for="dateTerm">기간선택</label>
	        </div>
	        <div class="picker-wrap">
	            <input type="text" id="start_date" name="start_date" class="input-box" readonly value="${start_date}"/>
	             <span class="next-ico">-</span>
	             <input type="text" id="end_date" name="end_date" class="input-box" readonly value="${end_date}"/>
	        </div>
	        
	        <button type="submit" class="search-btn">검색</button>
	        <button class="search-btn white-btn ml20">초기화</button>
	    </div>
    </form>

</div>

<div class="btn-cont mb20">
    <dl class="count-txt">
        <dt>전체 <span>56</span></dt>
        <dt class="blue-txt">진행중<span>115</span></dt>
        
        <dt class="red-txt">대기중 <span>15</span></dt>
        <dt class="gray-txt">종료 <span>10</span></dt>
    </dl>

    <button class="mid-btn blue-btn" onclick="location.href = '<c:url value='/lms/contentsReq.do' />'; ">등록</button>
</div>

<div class="table-wrap scroll-wrap">
    <table class="list-tb">
        <caption>선택, 분류1, 분류2, 분류3, 교육현황, 차시, 강의시간, 개설일, 콘텐츠, 교육자료, 관리 정보가 있는 테이블</caption>
        <colgroup>
            <col width="4%"/>
            <col width="6%"/>
            <col width="10%"/>
            <col width="10%"/>
            <col width="*"/>
            <col width="7%"/>
            <col width="7%"/>
            <col width="7%"/>
            <col width="10%"/>
            <col width="7%"/>
            <col width="7%"/>
            <col width="5%"/>
            <col width="5%"/>
        </colgroup>
        <thead>
            <tr>
                <th><input type="checkbox" class="check-box"/></th>
                <th>No.</th>
                <th>분류1</th>
                <th>분류2</th>
                <th>분류3</th>
                <th>교육현황</th>
                <th>차시</th>
                <th>강의시간(분)</th>
                <th>개설일</th>
                <th>콘텐츠</th>
                <th>교육자료</th>
                <th colspan="2">관리</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="result" items="${resultList}" varStatus="status">
	            <tr>
	                <td><input type="checkbox" id='checkNo' name='checkNo' value="${result.content_idx}" class="check-box"/></td>
	                <td>${status.index + 1}</td>
	                <td class="tl">${result.category1_name}</td>
	                <td class="tl">${result.category2_name}</td>
	                <td class="tl">${result.category3_name}</td>
	                <td>${result.edu_status}</td>
	                <td>${result.lms_cnt}</td>
	                <td>${result.edu_time} 분</td>
	                <td>${result.reg_dt}</td>
	                <td>등록</td>
	                <td>미등록</td>
	                <td><button class="sm-btn black-btn" onClick="javascript:fn_edit('${result.content_idx}',  'E', 'noticeList');">수정</button></td>
	                <td><button class="sm-btn white-btn" onClick="javascript:fn_delete('${result.content_idx}');">삭제</button></td>
	            </tr>
            </c:forEach>
            <c:if test="${empty resultList }">
             <tr>
                 <td colspan='12'/>Data 없습니다.</td>
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
	 $("#start_date, #end_date").datepicker({
	  	dateFormat: 'yy-mm-dd' //달력 날짜 형태
       ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
          ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
          ,changeYear: true //option값 년 선택 가능
          ,changeMonth: true //option값  월 선택 가능                
          ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
          ,buttonImage: "<c:url value='/images/common/ico_calendar.png'/>" //버튼 이미지 경로
          ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
          ,buttonText: "선택" //버튼 호버 텍스트              
          ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
          ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
          ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
          ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
          ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
          ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
          ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
    });
});
 
function fn_edit(key1, str) {
 	var frm = document.listForm;
 	$("#content_idx").val(key1);
  	frm.action = "<c:url value='/lms/contentsReq.do'/>";
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
        url: "/lms/contentsDel.do",
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