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

<h1 class="h1-tit">콘텐츠 ${ not empty detailData.content_idx ? "수정" : "등록"}</h1>

<form id="commonForm" name="commonForm" method="post" enctype="Multipart/form-data">
	<input type="hidden" name="edu_sub_no" id="edu_sub_no" value="${edu_sub_no}">
	<input type="hidden" id="flag"  name="flag" value="${flag}"/>
	<input type="hidden" id="checkdstr"      name="checkdstr"      class="input-box" value=''/>
	<input type="hidden" id="file_seq"       name="file_seq"       class="input-box" value=0/>
	<div class="table-wrap">
	    <table class="detail-tb">
	        <caption>교육분류, 교육명, 차시, 차시명, 강의시간, 교육 인증시간, 콘텐츠 등록, 교육자료 등록, 교육현황 정보가 있는 테이블</caption>
	        <colgroup>
	            <col width="20%"/>
	            <col width="*"/>
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>분류1,2</th>
	                <td>
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
	                </td>
	            </tr>
	            <tr>
	                <th>교육명(분류3)</th>
	                <td>
	                    <select class="select lg-width"  id="category3_key" name="category3_key">
			            	<option value='' >선택 하세요</option>
							<c:forEach var="result" items="${category3list}" varStatus="status">
								<option value='${result.CATEGORY3_KEY}' >${result.CATEGORY3_NAME}</option>
							</c:forEach>
			            </select>
	                </td>
	            </tr>
	            <tr>
	                <th>차시</th>
	                <td>
	                    <input type="text" class="input-box" id="lms_cnt" name="lms_cnt" value="${detailData.lms_cnt}"/>
	                    <span>회</span>
	                </td>
	            </tr>
	            <tr>
	                <th>차시명</th>
	                <td><input type="text" class="input-box lg-width" id="lms_title" name="lms_title" value="${detailData.lms_title}"/></td>
	            </tr>
	            <tr>
	                <th>강의시간</th>
	                <td>
	                    <input type="text" class="input-box" id="edu_time" name="edu_time" value="${detailData.edu_time}"/>
	                    <span>분</span>
	                </td>
	            </tr>
	            <tr>
	                <th>교육 인증시간</th>
	                <td>
	                    <input type="text" class="input-box" id="edu_time_cf" name="edu_time_cf" value="${detailData.edu_time_cf}"/>
	                    <span>분</span>
	                </td>
	            </tr>
	            <tr>
	                <th>콘텐츠 등록</th>
	                <td>
	                    <div class="upload-box">
	                        <input type="file" id="file1" name="file1"/>
	                        <button class="sm-btn black-btn">삭제</button>
	                        <label>파일명: <span>2021년 강사 안내문</span></label>
	                        <button class="sm-btn white-btn">미리보기</button>
	                        <span class="point">권장사이즈 : 10MB이내</span>
	                    </div>
	                </td>
	            </tr>
	            <tr>
	                <th>교육자료 등록</th>
	                <td>
	                    <div class="upload-box">
	                        <input type="file" id="file2" name="file2"/>
	                        <button class="sm-btn black-btn">삭제</button>
	                        <label>파일명: <span>2021년 강사 안내문</span></label>
	                        <button class="sm-btn white-btn">미리보기</button>
	                        <span class="point">권장사이즈 : 10MB이내</span>
	                    </div>
	                </td>
	            </tr>
	            <tr>
	                <th>교육현황</th>
	                <td>
	                    <div class="tb-cont">
	                        <div class="radio-cont">
	                            <input type="radio" class="radio-box" id="edu_status" name="edu_status" value="I" <c:if test="${detailData.edu_status == 'I'}">checked </c:if>>
	                            <label for="">진행중(노출)</label>
	                        </div>
	                          
	                        <div class="radio-cont">
	                            <input type="radio" class="radio-box" id="edu_status" name="edu_status" value="D" <c:if test="${detailData.edu_status == 'D'}">checked </c:if>>
	                            <label for="">대기중(미노출)</label>
	                        </div>
	                        
	                        <div class="radio-cont mr10">
	                            <input type="radio" class="radio-box" id="edu_status" name="edu_status" value="D" <c:if test="${detailData.edu_status == 'D'}">checked </c:if>>
	                            <label for="">종료</label>
	                        </div>
	                    </div>
	                </td>
	            </tr>
	        </tbody>
	    </table>
	</div>
</form>

<div class="btn-cont">
	<c:if test="${empty detailData.content_idx }">
     		<button type="button" class="mid-btn blue-btn"   onClick="javascript:fn_save('I');">저장</button>
     </c:if>
     <c:if test="${not empty detailData.content_idx }">
     		<button type="button" class="mid-btn blue-btn"   onClick="javascript:fn_save('E');">저장</button>
     </c:if>
    <button class="mid-btn white-btn" onClick="javascript:history.back();">취소</button>
</div>

<script type="text/javascript">
$(document).ready(function() {
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

function fn_save(gubun1){
	var formData = new FormData($('#commonForm')[0]);
	

	$("#gubun1").val(gubun1); 
	
	var title       = $("#title").val();
	var reg_id = $("#reg_id").val();
	   
    if (title == ""){			
		alert("제목을 입력해주세요");
		return;
	}

	var msg = "콘텐츠 등록 하시겠습니까?";
	if (gubun1 == "E"){
		msg = "콘텐츠 수정 하시겠습니까?";
	}
	formData.append("file1",    $("input[name=file1]")[0].files[0]);
	formData.append("file2",    $("input[name=file2]")[0].files[0]);
		
		var yn = confirm(msg);	
		if(yn){
			$.ajax({	
				data     : formData,
			    url		 : "<c:url value='/lms/contentsSave.do'/>",
		        dataType : "JSON",
				type	 : "POST",
				processData: false, 
		        contentType: false,
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
			fn_load('R');				 
		} else if(result == "EXIST"){				
			alert("이미 등록 되었습니다.");	
			return false;
		}else {				
			alert("등록이 실패 했습니다.");	
			return false;
		}
	}
}

function fn_load(str) {
	var frm = document.commonForm;
	frm.action = "<c:url value='/lms/contentsList.do'/>";    
	frm.submit();
 }
 

function fileDownload(key1){
	var frm = document.commonForm;
	$("#file_seq").val(key1)
	frm.action = "<c:url value='/lms/fileDownload.do'/>";
	frm.submit();
}

</script>