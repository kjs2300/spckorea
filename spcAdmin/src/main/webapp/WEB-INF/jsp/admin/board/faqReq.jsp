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

<h1 class="h1-tit">FAQ ${ not empty detailData.board_idx ? "수정" : "등록"}</h1>

<form id="commonForm" name="commonForm" method="post">
<input type="hidden" name="board_idx" id="board_idx" value="${ not empty detailData.board_idx ? detailData.board_idx : '0'}">
<input type="hidden" name="board_type" id="board_type" value="03">
<input type="hidden" id="gubun1"  name="gubun1"  />
<div class="table-wrap">
    <table class="detail-tb">
        <caption>제목, 작성자, 패스워드, 내용, 첨부파일 정보가 있는 테이블</caption>
        <colgroup>
            <col width="20%"/>
            <col width="30%"/>
            <col width="20%"/>
            <col width="*"/>
        </colgroup>
        <tbody>
            <tr>
                <th>제목</th>
                <td colspan="3">
                    <input type="text" class="input-box w768" id="title" name="title" value="${detailData.title}"/>
                </td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" class="input-box" id="reg_id" name="reg_id" value="${detailData.reg_id}"/></td>
                <th>패스워드</th>
                <td><input type="text" class="input-box" value=""/></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    <div class="editor-box"><textarea name="contents" id="contents" rows="10" cols="100" style="width: 100%; height: 100%; border: 1px solid #ddd; display: none;">${detailData.contents}</textarea></div>
                </td>
            </tr>
            <tr>
                <th>첨부파일</th>
                <td colspan="3">
                    <div class="upload-box">
                        <input type="file" />
                    </div>
                    <div class="upload-box">
                        <input type="file" />
                    </div>
                    <div class="upload-box">
                        <input type="file" />
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
</div>
</form>

<div class="btn-cont">
	<c:if test="${empty detailData.board_idx }">
     		<button type="button" class="mid-btn blue-btn"   onClick="javascript:fn_save('I');">저장</button>
     </c:if>
     <c:if test="${not empty detailData.board_idx }">
     		<button type="button" class="mid-btn blue-btn"   onClick="javascript:fn_save('E');">저장</button>
     </c:if>
    <button class="mid-btn white-btn" onClick="javascript:history.back();">취소</button>
    <button class="mid-btn black-btn" onClick="javascript:history.back();">목록</button>
</div>

<script type="text/javascript">

var oEditors = [];

var sLang = "ko_KR"; // 언어 (ko_KR/ en_US/ ja_JP/ zh_CN/ zh_TW), default = ko_KR

// 추가 글꼴 목록
//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

nhn.husky.EZCreator.createInIFrame({
	oAppRef : oEditors,
	elPlaceHolder : "contents",
	sSkinURI : "/js/SE2/SmartEditor2Skin.html",
	htParams : {
		bUseToolbar : true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : false, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : true, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		//bSkipXssFilter : true,		// client-side xss filter 무시 여부 (true:사용하지 않음 / 그외:사용)
		//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
		fOnBeforeUnload : function() {
			//alert("완료!");
		},
		I18N_LOCALE : sLang
	}, //boolean
	fOnAppLoad : function() {
		//예제 코드
		//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
		$('iframe').contents().find('.se2_multy').show();
		$('iframe').contents().find('.se2_multy').on("click", function(event) {
			editImgUpLoad();
		});
	},
	fCreator : "createSEditor2"
});

function fn_save(gubun1){
	oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
	var content = document.getElementById("contents").value;;

	$("#gubun1").val(gubun1); 
	
	var title       = $("#title").val();
	var reg_id = $("#reg_id").val();
	   
    if (title == ""){			
		alert("제목을 입력해주세요");
		return;
	}
    if(content == "" || content == null || content == '&nbsp;' || content == '<br>' || content == '<br/>' || content == '<p>&nbsp;</p>'){ 
    	return alert("본문을 작성해주세요."); oEditors.getById["contents"].exec("FOCUS"); //포커싱 return; 
   	}

	var msg = "공지사항 등록 하시겠습니까?";
	if (gubun1 == "E"){
		msg = "공지사항 수정 하시겠습니까?";
	}
		
		var yn = confirm(msg);	
		if(yn){
				
			$.ajax({	
				data     : $("#commonForm").serialize(),
			    url		 : "<c:url value='/adBoard/noticeSave.do'/>",
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
	frm.action = "<c:url value='/adBoard/faqList.do'/>";    
	frm.submit();
 }
</script>