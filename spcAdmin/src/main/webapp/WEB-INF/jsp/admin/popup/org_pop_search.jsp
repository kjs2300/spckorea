
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript" src="<c:url value='/resources/common/jquery.js'/>"></script>

 <script type="text/javaScript" language="javascript" defer="defer">
 <!--
 

 	function goOkPage(){	
		var frm = document.commonForm;
		$("#gubun1").val('R'); 
		frm.action = "<c:url value='/main/popupList.do'/>";
		frm.submit();
	}
	    
	function fn_save(gubun1){
 	
	   var popup_nm     = $("#popup_nm").val();
	   var popup_ar     = $("#popup_ar").val();
	   var popup_hg     = $("#popup_hg").val();
	   var otpt_xaxs_lc = $("#otpt_xaxs_lc").val();
	   var otpt_yaxs_lc = $("#otpt_yaxs_lc").val();
	   var popup_no     = $("#popup_no").val();
	   var gubun2       = $("#gubun2").val();
	   
	   oEditors.getById["popup_cn"].exec("UPDATE_CONTENTS_FIELD", []);
	   var popup_cn = document.getElementById("popup_cn").value;;
	   $("#popup_cn").val(popup_cn);
	   
	   $("#gubun1").val(gubun1);
	     
	   if (popup_nm == ""){			
			alert("제목을 입력하세요.");
			$("#popup_nm").focus();
			return;
		}		
  
		if (popup_ar == ""){			
			alert("창의 가로를 입력 하세요.");
			 $("#popup_ar").focus();
			return;
		}
		
		if (popup_hg == ""){			
			alert("창의 세로를 입력 하세요.");
			 $("#popup_hg").focus();
			return;
		}
		
		if (otpt_xaxs_lc == ""){			
			alert("창위치 left 를 입력 하세요.");
			$("#otpt_xaxs_lc").focus();
			return;
		}
		
		if (otpt_yaxs_lc == ""){			
			alert("창위치 top을 입력 하세요.");
			$("#otpt_yaxs_lc").focus();
			return;
		}
		
		if (popup_cn == ""){			
			alert("내용을 입력 하세요.");
			$("#popup_cn").focus();
			return;
		}
		
		var msg = "팝업을  등록 하시겠습니까?";
		if (gubun1 == "E"){
			msg = "팝얼을  수정 하시겠습니까?"
		}
		
		var formData = new FormData(); 
		formData.append("gubun1",       gubun1);
		formData.append("gubun2",       gubun2);
		
		formData.append("popup_nm",     popup_nm);
		formData.append("popup_ar",     popup_ar);
	    formData.append("popup_hg",     popup_hg);
		formData.append("otpt_xaxs_lc", otpt_xaxs_lc);
		
		formData.append("otpt_yaxs_lc", otpt_yaxs_lc);
		formData.append("popup_cn",     popup_cn);
		formData.append("popup_no",     popup_no);
		
		
		var yn = confirm(msg);		
		if(yn){
				
			$.ajax({	
 				data     : $("#commonForm").serialize(),
 			    url		 : "<c:url value='/main/popupSave.do'/>",
 		        dataType : "JSON",
 		        cache    : false,
 		        async    : false,
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
				goOkPage();				 
			} else if(result == "EXIST"){				
				alert("이미 등록 되었습니다.");	
				return false;
			}else {				
				alert("등록이 실패 했습니다.");	
				return false;
			}
		}
	}	
	function fn_submit(){
		window.opener.document.getElementById("coper_nm_auto").value = "기관명 전달";
	    self.close();
	}
     //-->
 </script>
 	<form  id="commonForm" name="commonForm"  method="post"  >
           
	<div class="dim-layer"> </div>
	    <div class="pop-wrap">
	        <div class="pop-header">
	            <h1 class="h1-tit">기관명 검색</h1>
	            <button type="button"  onClick="javascript:self.close();"  class="close-btn"><img src="${pageContext.request.contextPath}/images/common/close.png" alt="닫기"/></button>
	        </div>
	        <div class="pop-cont">
	
	            <div class="search-wrap">
	                <div class="search-cont">
	                    <select class="select">
	                        <option>지역선택</option>
	                    </select>
	                    <input type="text" class="input-box"/>
	                    <button class="search-btn">검색</button>
	                </div>
	            </div>
	
	            <div class="table-wrap">
	                <table class="list-tb">
	                    <caption>선택, 지역, 소속기관 정보가 있는 테이블</caption>
	                    <colgroup>
	                        <col width="10%"/>
	                        <col width="10%"/>
	                        <col width="*"/>
	                        <col width="30%"/>
	                    </colgroup>
	                    <thead>
	                        <tr>
	                            <th>선택</th>
	                            <th>No.</th>
	                            <th>지역</th>
	                            <th>소속기관</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        <tr>
	                            <td><input type="radio" class="radio-box" id="" name="" value=""></td>
	                            <td>1</td>
	                            <td></td>
	                            <td></td>
	                        </tr>
	                    </tbody>
	                </table>
	            </div>
	
	        </div>
	        <div class="pop-footer">
	            <button type="button"  onClick="javascript:fn_submit();" class="mid-btn blue-btn">확인</button>
	            <button type="button"  onClick="javascript:self.close();" class="mid-btn white-btn">취소</button>
	        </div>
	    </div>
	 
	
	</form>
						            

