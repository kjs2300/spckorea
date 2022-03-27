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


<form id="commonForm" name="commonForm" method="post">
<input type="hidden" name="cour_no" id="cour_no" value="${cour_no}">
<div class="pop-wrap sm-pop">
        <!-- <div class="pop-header">
            <h1 class="h1-tit"></h1>
            <button class="close-btn"><img src="./images/common/close.png" alt="닫기"/></button>
        </div> -->
        <div class="pop-cont">
            <div class="table-wrap">
                <table class="detail-tb">
                    <caption>교육번호, 분야 정보가 있는 테이블</caption>
                    <colgroup>
                        <col width="25%"/>
                        <col width="*"/>
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>교육번호</th>
                            <td>
                                <input type="text" class="input-box" placeholder="">
                                <p class="point">* 네자리 번호를 입력하세요. (ex. 0854)</p>
                            </td>
                        </tr>
                        <tr>
                            <th>분야</th>
                            <td>
                                <input type="text" class="input-box lg-width" placeholder="직접입력">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <p class="point">* 등록을 누르시면 해당 회원 마이페이지에서 수료증 발급이 활성화 됩니다.</p>
        </div>
        <div class="pop-footer">
            <button class="mid-btn blue-btn">등록</button>
            <button class="mid-btn white-btn">취소</button>
        </div>
    </div>
</form>

<div class="btn-cont">
     <button type="button" class="mid-btn blue-btn"   onClick="javascript:fn_save();">저장</button>
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
			document.location = "<c:url value='/warrant/warrantOnlineList.do'/>";  		 
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