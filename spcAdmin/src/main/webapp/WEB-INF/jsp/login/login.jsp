<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">	
	$(document).ready(function(){	
		$("#password").keyup(function(e){
			if(e.keyCode == 13)  loginProcess();
		});
		
		loginProcess();

	});
	
	/**  페이지 이동 */
	function goOkPage(){	
		var frm = document.commonForm;
		frm.action = "<c:url value='/main/imgList.do'/>";
		frm.submit();
	}
		
	/** 로그인 - 로그인 확인  */
	function loginProcess(){
	
		var id = $("#id").val();
		var password = $("#password").val();
		
			
		if (id == ""){			
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return;
		}
		if (password == ""){			
			alert("암호를 입력해주세요.");
			$("#password").focus();
			return;
		}
		
		$.ajax({	
			data     : $("#commonForm").serialize(),
		    url		 : "<c:url value='/login/loginCheckProcess.do'/>",
	        dataType : "JSON",
	        cache    : false,
	        async    : false,
			type	 : "POST",	
	        success  : function(obj) {
	        	commonCallBack(obj);				
	        },	       
	        error 	: function(xhr, status, error) {}
	        
	    });
		
		//var frm = document.commonForm;
		//frm.action = "<c:url value='/login/loginCheckProcess.do'/>";
		//frm.submit();		
	}	
	
	/** 콜백 함수 */
	function commonCallBack(obj){
	
		if(obj != null){		
			
			var result = obj.result;
			
			if(result == "SUCCESS"){				
				//alert("로그인에 성공하였습니다.");				
				goOkPage();				 
			}else {				
				alert("로그인에 실패 했습니다.");	
				return false;
			}
		}
	}	
</script>
<!-- 로그인 -->
	<section id="loginArea">
		<form class="form_login" id="commonForm" name="commonForm"  method="post"  action="">
			<h1 class="logo_login"> Admin Login Page</h1>
			<li><input  class="input_large" type="text"    id="id"       name ="id"       value='kjs2300' maxlength="11" placeholder="아이디(핸드폰번호)" required></li>
			<li><input  class="input_large" type="password"id="password" name ="password" value='1234'    placeholder="비밀번호" required></li>
		</form>
			<li><button class="btn_login"   onclick="javascript:loginProcess();" >로그인</button></li>
	</section>
<!-- #loginArea -->