
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="<c:url value='/resources/common/jquery.js'/>"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


 <script type="text/javaScript" language="javascript" defer="defer">
 $(document).ready(function(){		
	 	
 });
 function fn_save(){
	   if ($("#mbl_telno").val() == ""){			
			alert("휴대폰을 입력하세요.");
			$("#mbl_telno").focus();
			return;
		}
	   if ($("#eml_addr1").val() == ""){			
			alert("이메일을 입력하세요.");
			$("#eml_addr1").focus();
			return;
		}	
	   if ($("#eml_addr2").val() == ""){			
			alert("이메일을 입력하세요.");
			$("#eml_addr2").focus();
			return;
		}	

		var formData = new FormData(); 
		formData.append("mbl_telno",   $("#mbl_telno").val());
		formData.append("eml_addr1",   $("#eml_addr1").val());
		formData.append("eml_addr2",   $("#eml_addr2").val());
		formData.append("gubun",   	   "R");
		formData.append("edu_no",   $("#edu_no").val());
		
			
		if(confirm("교육 신청을 하시겠습니까?")){
				
			$.ajax({	
				data       : formData,
			    url		   : "<c:url value='/user/sectorSave.do'/>",
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
 
 function email_chg(){
	 $("#eml_addr2").val("");
	 if($("#eml_sel").val() != ""){
		 $("#eml_addr2").val($("#eml_sel").val());
	 }
 }
 
 function commonCallBack(obj){
		if(obj != null){		
			
			var result = obj.result;
			
			if(result == "SUCCESS"){				
				alert("성공하였습니다.");				
				fn_goList();				 
			}else {				
				alert("등록이 실패 했습니다.");	
				return false;
			}
		}
	}	
 
 	function fn_goList(){
		document.location = "<c:url value='/user/sectorList.do'/>"+"?edu_no="+$('#edu_no').val()+"&idx="+$('#idx').val();
	 }	
</script>

<!-- container  begin -->
                <div id="container">

                    <div class="tit-wrap">
                        <h1 class="h1-tit">교육신청</h1>

                        <div class="side-cont">
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_home.png" alt="홈 바로가기"/>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>기관 회원 서비스</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>기관회원 교육신청</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>교육신청</span>
                        </div>
                    </div>

                    <div class="contents-wrap">
                        <input type="hidden" id="edu_no" name="edu_no" value="${edu_no}">
                        <input type="hidden" id="idx" name="idx" value="${idx}">
                        <div class="comp">
                            <h4 class="h4-tit">정보입력</h4>
                            <div class="table-wrap">
                                <table class="detail-tb">
                                    <caption>기관명, 기관주소, 신청자명, 신청인 휴대폰, 신청인 이메일, 강사선택, 교육명(분류3), 교육대상, 교육일시, 교육시간, 교육인원, 교육장소 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="20%"/>
                                        <col width="*"/>
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>기관명</th>
                                            <td>
                                                <div class="tb-cont">
                                                    <select class="select">
                                                        <option>지역선택</option>
                                                        <option>서울</option>
                                                        <option>부산</option>
                                                    </select>
                                                    <input type="text" class="input-box" value=""/>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>기관주소</th>
                                            <td>
                                                <input type="text" class="input-box lg-width" readonly value=""/>
                                                <button class="sm-btn navy-btn">주소검색</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>신청자명</th>
                                            <td>
                                                <input type="text" class="input-box" value=""/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>신청인 휴대폰</th>
                                            <td>
                                                <input type="text" class="input-box lg-width" placeholder="- 없이 입력해주세요" value=""/>
                                                <p class="point">* 연락 가능한 신청인의 휴대번호를 정확히 입력하시기 바랍니다.</p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>신청인 이메일</th>
                                            <td>
                                                <div class="tb-cont">
                                                    <input type="text" class="input-box" value=""/>
                                                    <span>@</span>
                                                    <input type="text" class="input-box" value=""/>
                                                    <select class="select">
                                                        <option>직접입력</option>
                                                        <option>naver.com</option>
                                                        <option>gmail.com</option>
                                                    </select>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>강사선택</th>
                                            <td>
                                                <div class="tb-cont">
                                                    <div class="radio-cont">
                                                        <input type="radio" class="radio-box" id="" name="" value="" checked>
                                                        <input type="text" class="input-box" readonly value=""/>
                                                        <input type="text" class="input-box" readonly value=""/>
                                                        <button class="sm-btn navy-btn">검색</button>
                                                    </div>
                                                    
                                                    <div class="radio-cont">
                                                        <input type="radio" class="radio-box" id="" name="" value="">
                                                        <label for="">직접입력</label>
                                                        <input type="text" class="input-box" value=""/>
                                                    </div>
            
                                                    <div class="radio-cont">
                                                        <input type="radio" class="radio-box" id="" name="" value="">
                                                        <label for="">강사섭외 필요</label>
                                                    </div>
                                                    <p class="point ml20">* 이어줌인 교육의 경우, 강사들이 충분하지 않아 섭외가 어려울 수 있습니다.</p>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>교육명</th>
                                            <td>
                                                <input type="text" class="input-box" readonly value=""/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>교육대상</th>
                                            <td>
                                                <input type="text" class="input-box" readonly value=""/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>교육일시</th>
                                            <td>
                                                <div class="tb-cont">
                                                    <div class="picker-wrap">
                                                        <input type="text" id="datepickerDefault" class="input-box"/>
                                                    </div>
                                                    <div class="time-cont">
                                                        <select class="select">
                                                            <option>00</option>
                                                            <option>01</option>
                                                        </select>
                                                        <span>시</span>
                                                        <select class="select">
                                                            <option>00</option>
                                                            <option>01</option>
                                                        </select>
                                                        <span>분</span>
                                                    </div>
                                                    <span class="next-ico">~</span>
                                                    <div class="time-cont">
                                                        <select class="select">
                                                            <option>00</option>
                                                            <option>01</option>
                                                        </select>
                                                        <span>시</span>
                                                        <select class="select">
                                                            <option>00</option>
                                                            <option>01</option>
                                                        </select>
                                                        <span>분</span>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>교육시간</th>
                                            <td>
                                                <input type="text" class="input-box" value=""/>
                                                <span>분</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>교육인원</th>
                                            <td>
                                                <input type="text" class="input-box" value=""/>
                                                <span>명</span>
                                                <p class="point ml20">* 청소년 50명, 그 외 200명 신청 시 초과신청 불가 (비대면교육은 해당없음)</p>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>교육장소</th>
                                            <td>
                                                <input type="text" class="input-box" value=""/>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <!---- button begin ---->
                        <div class="btn-cont">
                            <button class="lg-btn orange-btn" onClick="fn_save();">신청하기</button>
                            <button class="lg-btn white-btn">목록</button>
                        </div>
                        <!---- button end ---->
                        

                    </div>
                </div>
                <!--  container end -->