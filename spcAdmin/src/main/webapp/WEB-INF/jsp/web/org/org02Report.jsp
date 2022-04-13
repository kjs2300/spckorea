
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
   $("#edu_date").datepicker({
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
 });
 
 function email_chg(){
	 $("#app_email2").val("");
	 if($("#eml_sel").val() != ""){
		 $("#app_email2").val($("#eml_sel").val());
	 }
 }
 
 function insSelect(str){
	var param = str.split(",");
	$("#user_nm").val(param[2]);
	$("#area_nm").val(param[1]);
	$("#instructor_idx").val(param[0]);
 }
 
 function fn_save(){
		if(confirm("교육 신청을 하시겠습니까?")){
			$.ajax({	
				data       : $("#commonForm").serialize(),
			    url		   : "<c:url value='/user/orgSave.do'/>",
			    dataType   : "JSON",
		        processData: false, 
 		        cache    : false,
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
				fn_goList();				 
			}else {				
				alert("등록이 실패 했습니다.");	
				return false;
			}
		}
	}	
 
 function openWindowPop(url, name){
	    var options = 'top=10, left=10, width=700px, height=600px, status=no, menubar=no, toolbar=no, resizable=no';
	    window.open(url, name, options);
	}	
 
 	function fn_goList(){
		document.location = "<c:url value='/user/org01List.do'/>";
	 }	
</script>

<!-- container  begin -->
                <div id="container">
				
                    <div class="tit-wrap">
                        <h1 class="h1-tit">기관회원 교육신청 현황</h1>

                        <div class="side-cont">
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_home.png" alt="홈 바로가기"/>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>기관 회원 서비스</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>기관회원 교육신청 현황</span>
                        </div>
                    </div>

                    <div class="contents-wrap">
                    <form  id="commonForm" name="commonForm"  method="post"  action="">
                        <div class="comp">
                            <h4 class="h4-tit">교육 결과 보고</h4>
                            <button class="mid-btn white-btn">엑셀 다운로드</button>
                            
                            <div class="comp mt20">
                            <div class="table-wrap">
            
                                <table class="detail-tb">
                                    <caption>기관명, 기관주소, 신청자명, 휴대폰, 이메일, 강사명, 교육일시, 교육명, 교육대상, 교육인원, 교육장소, 비고 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="15%"/>
                                        <col width="20%"/>
                                        <col width="15%"/>
                                        <col width="20%"/>
                                        <col width="15%"/>
                                        <col width="*"/>
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>기관명</th>
                                            <td>중앙자살예방센터</td>
                                            <th>기관주소</th>
                                            <td>서울 중구 을지로6</td>
                                            <th>신청자명</th>
                                            <td>이세훈</td>
                                        </tr>
                                        <tr>
                                            <th>휴대폰</th>
                                            <td>01022545655</td>
                                            <th>이메일</th>
                                            <td>spcedu@spckorea.or.kr</td>
                                            <th>강사명</th>
                                            <td>이진영</td>
                                        </tr>
                                        <tr>
                                            <th>교육일시</th>
                                            <td>2021.10.06</td>
                                            <th>교육명</th>
                                            <td>보고듣고말하기 2.0 기본형</td>
                                            <th>교육대상</th>
                                            <td>성인</td>
                                        </tr>
                                        <tr></tr>
                                            <th>교육인원</th>
                                            <td><span>87</span>/<span>200</span></td>
                                            <th>교육장소</th>
                                            <td>대회의실</td>
                                            <th>비고</th>
                                            <td>서울에서 개최</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        
                         <div class="comp">
                            <div class="tit-cont">
                                <h4 class="h4-tit">생명지킴이 교육생 참석 여부</h4>
                                <button class="mid-btn white-btn">선택삭제</button>
                            </div>

                            <div class="table-wrap">
                    

                                <table class="list-tb">
                                    <caption>회원유형, 이름, 아이디, 휴대폰, 이메일 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="4%"/>
                                        <col width="6%"/>
                                        <col width="8%"/>
                                        <col width="7%"/>
                                        <col width="10%"/>
                                        <col width="10%"/>
                                        <col width="18%"/>
                                        <col width="12%"/>
                                        <col width="*"/>
                                        <col width="9%"/>
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th><input type="checkbox" class="check-box"/></th>
                                            <th>No.</th>
                                            <th>이름</th>
                                            <th>성별</th>
                                            <th>직업</th>
                                            <th>생년원일</th>
                                            <th>이메일</th>
                                            <th>연락처</th>
                                            <th>주소</th>
                                            <th>
                                                참석여부<br/>
                                                <input type="checkbox" class="check-box"/>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>1</td>
                                            <td>홍길동</td>
                                            <td>남</td>
                                            <td>교사</td>
                                            <td>1970.10.05</td>
                                            <td>honggildong@naver.com</td>
                                            <td>01012345678</td>
                                            <td class="tl">경기 성남시 분당구 판교로 264 더플래닛</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <!---- button begin ---->
                        <div class="btn-cont">
                            <button class="lg-btn orange-btn">제출</button>
                            <button class="lg-btn white-btn">목록</button>
                        </div>
                        <!---- button end ---->

                    </div>
                </div>