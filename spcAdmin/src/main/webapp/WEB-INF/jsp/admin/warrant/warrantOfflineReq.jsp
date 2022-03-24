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


<form id="commonForm" name="commonForm" method="post">
<input type="hidden" name="license_idx" id="license_idx" value="${license_idx}">
<input type="hidden" id="license_type"   name="license_type"  value="B"/>
<input type="hidden" id="actFlag"  name="actFlag" value="${actFlag}" />
<div class="table-wrap">
    <table class="detail-tb">
        <caption>기본양식, 분류선택, 교육일(종료일), 수료증 발급 활성화 정보가 있는 테이블</caption>
        <colgroup>
            <col width="20%"/>
            <col width="*"/>
        </colgroup>
        <tbody>
            <tr>
                <th>기본양식</th>
                <td>고정</td>
            </tr>
            <tr>
                <th>분류선택</th>
                <td>
                    <select class="select mr30"  id="category1_key" name="category1_key">
			        	<option value=''>선택 하세요</option>
						<c:forEach var="result" items="${category1list}" varStatus="status">
						     <option value='${result.CATEGORY1_KEY}' <c:if test="${category1_key == result.CATEGORY1_KEY}">selected</c:if>>${result.CATEGORY1_NAME}</option>
						 </c:forEach>
					</select>
			        <select class="select"  id="category2_key" name="category2_key">
			        	<option value=''>선택 하세요</option> 
						<c:forEach var="result" items="${category2list}" varStatus="status">
						     <option value='${result.CATEGORY2_KEY}' <c:if test="${category2_key == result.CATEGORY2_KEY}">selected</c:if>>${result.CATEGORY2_NAME}</option>
						</c:forEach>
			        </select>
			        <select class="select lg-width"  id="category3_key" name="category3_key">
			            <option value=''>선택 하세요</option>
						<c:forEach var="result" items="${category3list}" varStatus="status">
						     <option value='${result.CATEGORY3_KEY}' <c:if test="${category3_key == result.CATEGORY3_KEY}">selected</c:if>>${result.CATEGORY3_NAME}</option>
						</c:forEach>
			        </select>
                </td>
            </tr>
            <tr>
                <th>교육일(종료일)</th>
                <td>
                    <div class="picker-wrap">
                        <input type="text" id="edu_edate" name="edu_edate" class="input-box" readonly value="${result.EDU_EDATE}"/>
                    </div>
                </td>
            </tr>
            <c:if test="${actFlag == 'U'}">
            <tr>
                <th>수료증 발급 활성화</th>
                <td>
                    <div class="radio-cont">
                        <input type="radio" class="radio-box" id="license_status" name="license_status" value="0" <c:if test="${result.LICENSE_STATUS == false}">checked </c:if>/>
                        <label for="">활성</label>
                    </div>
                    <div class="radio-cont">
                        <input type="radio" class="radio-box" id="license_status" name="license_status" value="1" <c:if test="${result.LICENSE_STATUS == true}">checked </c:if>/>
                        <label for="">비활성</label>
                    </div>
                </td>
            </tr>
            </c:if>
        </tbody>
    </table>
</div>
</form>

<div class="btn-cont">
     <button type="button" class="mid-btn blue-btn"   onClick="javascript:fn_save();">저장</button>
    <button class="mid-btn white-btn" onClick="javascript:history.back();">취소</button>
</div>

<script type="text/javascript">

$(document).ready(function() {
	$("#edu_edate").datepicker({
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
		$("#category3_key").val("");
		
		 $.ajax({	
		    url     : "<c:url value='/user/category2list.do'/>",
		    data    : $("#commonForm").serialize(),
	        dataType: "JSON",
	        cache   : false,
			async   : true,
			type	: "POST",	
			success: function(data, opt, inx){
			var option = '';
			option += '<option value="">선택 하세요</opton>'; //선택
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


function fn_save(){
	if($("#category3_key").val() == ""){
		alert("분류를 선택 해 주세요.");
		return;
	}
	
	var formData = new FormData($('#commonForm')[0]);
		
	if(confirm("일반수료증을 저장 하시겠습니까?")){
			$.ajax({	
				data     : formData,
			    url		 : "<c:url value='/warrant/warrantSave.do'/>",
		        dataType : "JSON",
		        processData: false, 
		        contentType: false,
				type	 : "POST",	
		        success  : function(obj) {
		        	commonCallBack(obj);				
		        },	       
		        error 	: function(xhr, status, error) {} 		        
		    });
		}
	}
function commonCallBack(obj){
	if(obj != null){		
		
		var result = obj.result;
		
		if(result == "SUCCESS"){				
			alert("성공하였습니다.");				
			document.location = "<c:url value='/warrant/warrantOfflineList.do'/>"; 			 
		} else if(result == "EXIST"){				
			alert("이미 등록 되었습니다.");	
			return false;
		}else {				
			alert("등록이 실패 했습니다.");	
			return false;
		}
	}
}
</script>