

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script type="text/javascript" src="<c:url value='/resources/common/jquery.js'/>"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

 <script type="text/javaScript" language="javascript" defer="defer">
 <!-- 
 $(document).ready(function(){
   
	 $("#train_s_date, #train_e_date").datepicker({
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
	 
	 $("#input_img").on('change', function(){
	    readInputFile(this);
	}); 
	 
	$("#btn-delete").click(function(event) {
	    var $input = $(".inp-img");
	    var $preview = $('#preview');
	    resetInputFile($input, $preview);
	});
   	
	 $('#category1_key').change(function(){
		var val  = $(this).val();

		if( val ==""){
			return;
		}
		$("#gubun3").val('categorycode2');
		$("#category2_key").val(0);
		$("#category3_key").val(0);
		
		 $.ajax({	
		    url     : "<c:url value='/edu/eduInfoCategoryCodeList.do'/>",
		    data    : $("#commonForm").serialize(),
	        dataType: "JSON",
	        cache   : false,
			async   : true,
			type	: "POST",	
			success: function(data, opt, inx){
			var option = '';
			option += '<option value="">선택 하세요</opton>'; //선택
			$.each(data, function(i, ret){
				option += '<option value="'+ret.code_cd+'">'+ret.code_name+'</option>';		
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
		$("#gubun3").val('categorycode3');
		$("#category3_key").val(0);
				
		 $.ajax({	
		    url     : "<c:url value='/edu/eduInfoCategoryCodeList.do'/>",
		    data    : $("#commonForm").serialize(),
	        dataType: "JSON",
	        cache   : false,
			async   : true,
			type	: "POST",	
			success: function(data, opt, inx){
			var option = '';
			option += '<option value="">선택 하세요</opton>'; //선택
			$.each(data, function(i, ret){
				option += '<option value="'+ret.code_cd+'">'+ret.code_name+'</option>';		
			});
			$('select[name=category3_key]').html(option);						
	        },	       
	        error 	: function(xhr, status, error) {}
	        
	     });
	 });
	
	$("#addTR").click(function () {
	
		var row = "<div class='grid-box'>";
			row += "<input type='text' id='edu_curr1;  name='edu_curr1' class='input-box' />";
			row += "<input type='text' id='edu_curr2;  name='edu_curr3' class='input-box' />";
			row += "<input type='text' id='edu_curr3;  name='edu_curr3' class='input-box' />";
			row += "<td><span>삭제</span></td>";
			row += "</div>";
		$("#insertCurr").append(row);
	});
	
	$("#insertCurr").on("click", "span", function() {
	 
		$(this).closest("div").remove();
	});
	
  });	
 
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
	   var popup_cn     = $("#popup_cn").val();
	   var popup_no     = $("#popup_no").val();
	   var gubun2       = $("#gubun2").val();
	   
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
	
	function fn_load(){	
		var frm = document.commonForm;
		$("#gubun1").val('I'); 
		frm.action = "<c:url value='/main/popupReg.do'/>";
		frm.submit();
	}
	
	// 등록 이미지 등록 미리보기
	function readInputFile(input) {
	    if(input.files && input.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function (e) {
	            $('#preview').html("<img heigth='200px' width='120px' src="+ e.target.result +">");
	        }
	        reader.readAsDataURL(input.files[0]);
	    }
	}
	 
	 
	// 등록 이미지 삭제 ( input file reset )
	function resetInputFile($input, $preview) {
	    var agent = navigator.userAgent.toLowerCase();
	    if((navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1)) {
	        // ie 일때
	        $input.replaceWith($input.clone(true));
	        $preview.empty();
	    } else {
	        //other
	        $input.val("");
	        $preview.empty();
	    }       
	}
	 

     //-->
 </script>
 
           <form  id="commonForm" name="commonForm"  method="post"  >
			<input type="hidden" id="gubun1"   name="gubun1"   class="input-box" />
			<input type="hidden" id="gubun2"   name="gubun2"   class="input-box" value='eduInfoOnline'/>
			<input type="hidden" id="gubun3"   name="gubun3"   class="input-box" />
			<input type="hidden" id="edu_no"   name="edu_no" class="input-box" value='${categoryVo.edu_no}'/>

			
            <h1 class="h1-tit">온라인 교육 등록</h1>

                <div class="table-wrap">
                    <table class="detail-tb">
                        <caption>교육분류, 교육명, 강사명, 교육기간, 교육내용, 교육방식, 학습시간, 교육대상, 교육정원,교육상태, 노출여부, 안내문, 교육 소개, 교육 목표, 커리큘럼 정보가 있는 테이블</caption>
                        <colgroup>
                            <col width="10%"/>
                            <col width="15%"/>
                            <col width="*"/>
                        </colgroup>
                        <tbody>
                            <tr>
                                <th colspan="2"><span class="red-txt">*</span>교육분류</th>
                                <td>
                                    <select class="select mr30"  id="category1_key" name="category1_key">
                                       <c:if test="${not empty categoryForm.category1_name }">
                                    		<option value='${categoryForm.category1_key}'>${categoryForm.category1_name}</option>
                                    	</c:if>
                                        <option value=''>선택 하세요</option>
	                                    <c:forEach var="result" items="${category1list}" varStatus="status">
	                                    	<option value='${result.code_cd}'>${result.code_name}</option>
	                                    </c:forEach>
                                    </select>
                                    <select class="select"  id="category2_key" name="category2_key">
                                        <option value=''>선택 하세요</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th colspan="2"><span class="red-txt">*</span>교육명</th>
                                <td>
                                    <select class="select lg-width"  id="category3_key" name="category3_key">
                                        <option value=''>선택 하세요</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th colspan="2"><span class="red-txt">*</span>강사명</th>
                                <td><input type="text"  id="inst_nm" name="inst_nm" class="input-box" value=""/></td>
                            </tr>
                            <tr>
                                <th colspan="2">교육기간</th>
                                <td>
                                    <div class="tb-cont">
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="set_use_yn" name="set_use_yn" value="N" checked>
                                            <label for="">설정 없음</label>
                                        </div>
                                        <div class="radio-cont mr10">
                                            <input type="radio" class="radio-box" id="set_use_yn" name="set_use_yn" value="Y">
                                            <label for="">기간선택</label>
                                        </div>
    
                                        <div class="picker-wrap">
                                            <input type="text" id="train_s_date"  name="train_s_date" readonly class="input-box"/>
                                            <span class="next-ico">-</span>
                                            <input type="text" id="train_e_date"  name="train_e_date" readonly class="input-box"/>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th colspan="2">교육내용</th>
                                <td><input type="text" id="edu_cont"  name="edu_cont" class="input-box" value=""/></td>
                            </tr>
                            <tr>
                                <th colspan="2">교육방식</th>
                                <td><input type="text" id="edu_method"  name="edu_method" class="input-box" value=""/></td>
                            </tr>
                            <tr>
                                <th colspan="2">교육대상</th>
                                <td>
                                    <input type="text" id="edu_target"  name="edu_target" class="input-box" value=""/>
                                    <span class="point">ex. 성인, 청소년, 중장년, 노인, 이어줌인, 대학생, 직장인 등</span>
                                </td>
                            </tr>
                            <tr>
                                <th colspan="2">교육정원</th>
                                <td>
                                    <input type="text" id="edu_garden"  name="edu_garden" class="input-box" value=""/>
                                    <span class="point">ex. 기입하지 않으면 무한대, 신청인원과 연동</span>
                                </td>
                            </tr>
                            <tr>
                                <th colspan="2">교육상태</th>
                                <td>
                                    <div class="tb-cont">
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="edu_status"  name="edu_status" value="I" checked>
                                            <label for="">신청중</label>
                                        </div>
                                          
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="edu_status"  name="edu_status" value="C">
                                            <label for="">신청취소</label>
                                        </div>
                                        
                                        <div class="radio-cont mr10">
                                            <input type="radio" class="radio-box" id="edu_status"  name="edu_status" value="F">
                                            <label for="">신청마감</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="edu_status"  name="edu_status" value="P">
                                            <label for="">사용중지</label>
                                        </div>
                                        
                                        <div class="radio-cont mr10">
                                            <input type="radio" class="radio-box" id="edu_status"  name="edu_status" value="R">
                                            <label for="">결과보고</label>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th colspan="2">교육 노출여부</th>
                                <td>
                                    <div class="tb-cont">
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box"  id="exp_use_yn"  name="exp_use_yn" value="Y" checked>
                                            <label for="">YES</label>
                                        </div>
                                          
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="exp_use_yn"  name="exp_use_yn" value="N">
                                            <label for="">NO</label>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th colspan="2">안내문</th>
                                <td>
                                    <div class="upload-box">
                                        <input  id="input_img"  type="file"   name="input_img" accept=".jpg, .jpeg, .png"/>
                                        <button id="btn-delete" type='button' class="sm-btn black-btn">삭제</button>
                                        <div id="preview"></div>
                                        <span class="point">권장사이즈 : 600px * 600px</span>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th rowspan="3" class="no-border-b">교육상세</th>
                                <th>교육 소개</th>
                                <td><input type="text" id="edu_intro"  name="edu_intro"  class="input-box lg-width" value=""/></td>
                            </tr>
                            <tr>
                                <th>교육 목표</th>
                                <td><input type="text" id="edu_goals"  name="edu_goals"  class="input-box lg-width" value=""/></td>
                            </tr>
                            <tr>
                                <th>커리큘럼</th>
                                <td>
                                 <div id="insertCurr">
                                    <div class="grid-box">
                                        <input type="text" id="edu_curr1"  name="edu_curr1" class="input-box" value=""/>
                                        <input type="text" id="edu_curr2"  name="edu_curr2" class="input-box" value=""/>
                                        <input type="text" id="edu_curr3"  name="edu_curr3" class="input-box" value=""/>
                                    </div>
                                 </div>
                                     
                                    <button type="button" id="addTR" class="sm-btn black-btn">+ 추가</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="btn-cont">
                    <button type="button"  onClick="javascript:fn_save('E');"  class="mid-btn blue-btn">저장</button>
                    <button type="button" onClick="javascript:history.back();" class="mid-btn white-btn">취소</button>
                </div>

			</form>
            