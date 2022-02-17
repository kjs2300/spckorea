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
        <li><a href="<c:url value='/warrant/warrantOfflineList.do' />">오프라인 등록</a></li>
        <li class="on"><a href="<c:url value='/warrant/warrantOrgList.do' />">기관교육 등록</a></li>
    </ul>
</div>


<form id="commonForm" name="commonForm" method="post">
<input type="hidden" name="license_idx" id="license_idx" value="${ not empty detailData.license_idx ? detailData.license_idx : '0'}">
<input type="hidden" id="gubun1"  name="gubun1"  />
<input type="hidden" id="license_type"   name="license_type"  value="C"/>
<div class="table-wrap">
    <table class="detail-tb">
        <caption>기본양식, 분류선택, 수료증 발급 활성화 정보가 있는 테이블</caption>
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
                    <select class="select mr30">
                        <option>분류1</option>
                        <option>일반</option>
                        <option>기관</option>
                        <option>강사</option>
                        <option>실무자</option>
                    </select>
                    <select class="select">
                        <option>분류2</option>
                    </select>
                    <select class="select lg-width">
                        <option>분류3(교육명)</option>
                    </select>
                </td>
            </tr>
            <c:if test="${not empty detailData.license_idx }">
            <tr>
                <th>수료증 발급 활성화</th>
                <td>
                    <div class="radio-cont">
                        <input type="radio" class="radio-box" id="license_status" name="license_status" value="false" <c:if test="${!detailData.license_status}">checked </c:if>/>
                        <label for="">활성</label>
                    </div>
                    <div class="radio-cont">
                        <input type="radio" class="radio-box" id="license_status" name="license_status" value="true" <c:if test="${detailData.license_status}">checked </c:if>/>
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
    <c:if test="${empty detailData.license_idx }">
     		<button type="button" class="mid-btn blue-btn"   onClick="javascript:fn_save('I');">저장</button>
     </c:if>
     <c:if test="${not empty detailData.license_idx }">
     		<button type="button" class="mid-btn blue-btn"   onClick="javascript:fn_save('E');">저장</button>
     </c:if>
    <button class="mid-btn white-btn" onClick="javascript:history.back();">취소</button>
</div>

<script type="text/javascript">

$(document).ready(function() {
});


function fn_save(gubun1){
	
	$("#gubun1").val(gubun1); 
	
	var title       = $("#title").val();
	var reg_id = $("#reg_id").val();
	   

	var msg = "일반수료증 등록 하시겠습니까?";
	if (gubun1 == "E"){
		msg = "일반수료증 수정 하시겠습니까?";
	}
	var formData = new FormData($('#commonForm')[0]);
		
		var yn = confirm(msg);	
		if(yn){
				
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
	frm.action = "<c:url value='/warrant/warrantOrgList.do'/>";    
	frm.submit();
 }
 
</script>