
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript" src="<c:url value='/resources/common/jquery.js'/>"></script>

 <script type="text/javaScript" language="javascript" defer="defer">
     <!--
    
     function fn_load(str) {
    	var frm = document.commonForm;
 		$("#gubun1").val('R'); 
		$("#gubun2").val('category2'); 
    	frm.action = "<c:url value='/edu/eduInfoRegCate.do'/>";    
    	frm.submit();
     }
     
 	function goOkPage(){	
		var frm = document.commonForm;
		$("#gubun1").val('R'); 
		$("#gubun2").val('category2'); 
		frm.action = "<c:url value='/edu/eduInfoRegCate.do'/>";
		frm.submit();
	}
	
     
     function fn_save(gubun1){
    	
    	var category3_name = $("#category3_name").val();
 		var category3_cont = $("#category3_cont").val();
 	    var category1_key  = $("#category1_key").val();
 	    var category2_key  = $("#category2_key").val();
 	    var category3_key  = $("#category3_key").val();
 	    
 		if (category3_name == ""){			
 			alert("카테고리3명을 입력해주세요.");
 			$("#category3_name").focus();
 			return;
 		}
 		
 		if (category3_cont == ""){			
 			alert("내용을 입력해주세요.");
 			$("#category3_cont").focus();
 			return;
 		}
 		
 		if (gubun1 == "I"){	
	 		var file= $("input[name=files]")[0].files[0];
	
	 		if( file ==null || file =='null' || file =='undefined' || file ==undefined){
	 			alert("선택된 파일이 없습니다.");	
	 			return;
	 		}
 		}
 		
 		
 		var formData = new FormData(); 
 		formData.append("category1_key",  category1_key);
 		formData.append("category2_key",  category2_key);
 		formData.append("category3_key",  category3_key);
 		formData.append("category3_name", category3_name);
 		formData.append("gubun1",         gubun1);
 		formData.append("category3_cont", category3_cont);
 		formData.append("files", $("input[name=files]")[0].files[0]);
 		
 		var msg = "카테고리를 등록 하시겠습니까?";
 		if (gubun1 == "E"){
 			msg = "카테고리를 수정 하시겠습니까?"
 		}else if (gubun1 == "D"){
 			msg = "카테고리를 삭제 하시겠습니까?"
 		}
 		
 		var yn = confirm(msg);		
 		if(yn){
 				
 			$.ajax({	
 				//data     : $("#commonForm").serialize(),
 				data       : formData,
 			    url		   : "<c:url value='/edu/eduInfoRegCate3Save.do'/>",
 			    dataType   : "JSON",
 		        processData: false, 
 		        contentType: false,
 				type	   : "POST",	
 		        success    : function(obj) {
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
 	

     //-->
 </script>
 
          <h1 class="h1-tit">교육안내 등록</h1>
          <form  id="commonForm" name="commonForm"  method="post"   enctype="multipart/form-data" >
			<input type="hidden" id="pageIndex"      name="pageIndex"      class="input-box" value=1 />
			<input type="hidden" id="category1_name" name="category1_name" class="input-box" value="${categoryVo.category1_name}" />
			<input type="hidden" id="category1_key"  name="category1_key"  class="input-box" value="${categoryVo.category1_key}"  />
			<input type="hidden" id="category2_name" name="category2_name" class="input-box" value="${categoryVo.category2_name}" />
			<input type="hidden" id="category2_key"  name="category2_key"  class="input-box" value="${categoryVo.category2_key}" />
			<input type="hidden" id="category3_key"  name="category3_key"  class="input-box" value="${categoryForm.category3_key}" />
			<input type="hidden" id="gubun1"         name="gubun1"         class="input-box" value=''/>
			<input type="hidden" id="gubun2"         name="gubun2"         class="input-box" value=''/>
           <div class="sub-cont">
               <button class="mid-btn black-btn" onClick="fn_load('${categoryVo.gubun2}');">전체분류 보기</button>
              <div class="req-box">
                  <label for="categoryFname">
				        ${categoryVo.category1_name} >  ${categoryVo.category2_name} >  카테고리03 등록
                  </label>
              </div>              
          </div>          
         
         
           <div class="table-wrap">
                    <table class="detail-tb">
                        <caption>카테고리3명, 상세내용, 자료업로드 정보가 있는 테이블</caption>
                        <colgroup>
                            <col width="20%"/>
                            <col width="*"/>
                        </colgroup>
                        <tbody>
                            <tr>
                                <th><span class="red-txt">*</span>카테고리3명</th>
                                <td>
                                    <input type="text" class="input-box" id='category3_name' name='category3_name' value="${categoryForm.category3_name}" />
                                </td>
                            </tr>
                            <tr>
                                <th><span class="red-txt">*</span>상세내용</th>
                                <td>
                                    <div class="editor-box">
                                    <textarea id="category3_cont" name="category3_cont" cols="60" rows="10" >${categoryForm.category3_cont}</textarea>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="red-txt">*</span>자료 업로드</th>
                                <td>
                                    <div class="upload-box">
                                      <input id="files" name="files" type="file"   id="fileNm" multiple accept=".jpg, .jpeg, .png"/>
                                    </div>

                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
				</form>
	            <div class="btn-cont">
		            <c:if test="${empty categoryForm.category3_name }">
		            	<button class="mid-btn blue-btn"  onClick="javascript:fn_save('I');">저장</button>
		            </c:if>                    
                    <c:if test="${not empty categoryForm.category3_name }">
	                    <button class="mid-btn blue-btn"  onClick="javascript:fn_save('E');">수정</button>
	               	    <button class="mid-btn black-btn" onClick="javascript:fn_save('D');">삭제</button>
               	   </c:if>
                </div>

   
