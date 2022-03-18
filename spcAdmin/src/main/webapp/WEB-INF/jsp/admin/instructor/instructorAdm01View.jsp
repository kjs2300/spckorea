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

 <script type="text/javaScript" language="javascript" defer="defer">
 $(document).ready(function(){		
	 $("#start_date, #end_date").datepicker({
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
  
 function email_chg(){
	 $("#eml_addr2").val("");
	 if($("#eml_sel").val() != ""){
		 $("#eml_addr2").val($("#eml_sel").val());
	 }
 }
 
 function fn_clearBtn(){
	 $("#category3_key").val("");
	 $("#site").val("");
	 $("#searchDate").eq(0).prop("checked",true);
	 $("#searchCondition").eq(0).prop("checked",true);
	 $("[type='text']").val("");
 }
 
 function fn_detail(edu_no){
	//document.location = "<c:url value='/user/sectorView.do'/>"+"?edu_no="+edu_no+"&idx="+$('#idx').val();
 }	
</script>

<div class="search-wrap">
	<h1 class="h1-tit">강사 자격 정보</h1>

                <div class="table-wrap">
                    <h2 class="h2-tit">회원정보</h2>

                    <table class="detail-tb">
                        <caption>아이디, 이름, 비밀번호, 전화번호, 휴대폰, 팩스번호, 이메일, 성별 정보가 있는 테이블</caption>
                        <colgroup>
                            <col width="20%"/>
                            <col width="*"/>
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>아이디</th>
                                <td>${UserAccount.id}</td>
                            </tr>
                            <tr>
                                <th>이름</th>
                                <td><input type="text" id="user_nm" name="user_nm" class="input-box lg-width" value="${UserAccount.name}"/></td>
                            </tr>
                            <tr>
                                <th>비밀번호</th>
                                <td>
                                    <input type="password" id="password" name="password" class="input-box lg-width" value=""/>
                                    <span class="point">변경 할 경우에만 입력하세요.</span>
                                </td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                                <td>
                                    <input type="text" id="telno" name="telno" class="input-box lg-width" placeholder="- 없이 입력해주세요" value="${UserAccount.telno}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>휴대폰</th>
                                <td>
                                    <input type="text" id="mbl_telno" name="mbl_telno" class="input-box lg-width" placeholder="- 없이 입력해주세요" value="${UserAccount.mbl_telno}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>팩스번호</th>
                                <td>
                                    <input type="text" id="faxno" name="faxno" class="input-box lg-width" placeholder="- 없이 입력해주세요" value="${UserAccount.faxno}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td>
                                    <div class="tb-cont">
                                    	<c:set var="email" value="${fn:split(UserAccount.eml_addr, '@')}" />
                                        <input type="text" id="eml_addr1" name="eml_addr1" class="input-box" value="${email[0]}"/>
                                        <span>@</span>
                                        <input type="text" id="eml_addr2" name="eml_addr2" class="input-box" value="${email[1]}"/>
                                        <select class="select" id="eml_sel" name="eml_sel" onchange="email_chg();">
                                            <option>직접입력</option>
                                            <option value="naver.com">naver.com</option>
                                            <option value="gmail.com">gmail.com</option>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>성별</th>
                                <td>
                                    <div class="tb-cont">
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="user_sex" name="user_sex" value="M" <c:if test="${UserAccount.user_sex == 'M'}">checked</c:if>>
                                            <label>남자</label>
                                        </div>
                                          
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="user_sex" name="user_sex" value="W" <c:if test="${UserAccount.user_sex == 'W'}">checked</c:if>>
                                            <label>여자</label>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="table-wrap">
                    <h2 class="h2-tit">강사정보 1</h2>

                    <table class="detail-tb">
                        <caption>활동상태, 강사분류, 지역, 기관명, 휴직이력, 신청서 보기, 휴직기간 정보가 있는 테이블</caption>
                        <colgroup>
                            <col width="20%"/>
                            <col width="30%"/>
                            <col width="20%"/>
                            <col width="*"/>
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>활동상태</th>
                                <td colspan="3">
                                    <div class="tb-cont">
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="status" name="status" value="1">
                                            <label>활동</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="status" name="status"value="2">
                                            <label>상실(일반)</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="status" name="status" value="3">
                                            <label>휴직</label>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>활동상태</th>
                                <td colspan="3">
                                    <div class="tb-cont">
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="class" name="class" value="0">
                                            <label>전체</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="class" name="class" value="1">
                                            <label>일반강사</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="class" name="class" value="2">
                                            <label>실무자</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="class" name="class" value="3">
                                            <label>공공기간(학교, 군, 경찰, 도시철도 등)</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="class" name="class" value="4">
                                            <label>기업(삼성,현대. sk 등)</label>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>지역</th>
                                <td>
                                    <select id="area_cd" name="area_cd" class="select">
                                        <c:forEach var="code" items="${codeList}" varStatus="status">
											<option value='${code.CD}' <c:if test="${result.area_cd == code.CD}">selected</c:if>>${code.CD_NM}</option>
										</c:forEach>
                                    </select>
                                </td>
                                <th>기관명</th>
                                <td>
                                    <input type="text" id="coper_nm" name="coper_nm" class="input-box" value="${result.coper_nm}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>휴직이력</th>
                                <td>
                                    <input type="text" class="input-box" value=""/>
                                </td>
                                <th>신청서 보기</th>
                                <td>
                                    <a class="link block">신청서1</a>
                                    <a class="link block">신청서2</a>
                                    <a class="link block">신청서3</a>
                                </td>
                            </tr>
                            <tr>
                                <th>휴직기간</th>
                                <td colspan="3">
                                    <div class="picker-wrap">
                                        <input type="text" id="datepickerFrom02" class="input-box"/>
                                        <span class="next-ico">-</span>
                                        <input type="text" id="datepickerTo02" class="input-box"/>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="table-wrap">
                    <h2 class="h2-tit">강사정보 2</h2>

                    <table class="detail-tb">
                        <caption>수료증번호, 최종수료일, 교육횟수, 교육 누적횟수, 오프라인 2회 교육, 온라인 보수 교육 정보가 있는 테이블</caption>
                        <colgroup>
                            <col width="20%"/>
                            <col width="30%"/>
                            <col width="20%"/>
                            <col width="*"/>
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>수료증번호</th>
                                <td>교육 제21 – 0000호</td>
                                <th>최종 수료일</th>
                                <td>
                                    <div class="picker-wrap">
                                        <input type="text" id="datepickerDefault" class="input-box"/>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>교육횟수 (해당 년도)</th>
                                <td>32</td>
                                <th>교육 누적횟수</th>
                                <td>82</td>
                            </tr>
                            <tr>
                                <th>오프라인 2회 교육</th>
                                <td colspan="3">
                                    <div class="tb-cont">
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="" name="" value="" checked>
                                            <label>완료</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="" name="" value="">
                                            <label>미완료</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="" name="" value="">
                                            <label>해당년도 수료 시 체크 ( 오프/온라인 교육 모두 완료 시 1년 자격연장 )</label>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>온라인 보수 교육</th>
                                <td colspan="3">
                                    <div class="tb-cont">
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="" name="" value="" checked>
                                            <label>완료</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="" name="" value="">
                                            <label>미완료</label>
                                        </div>
                                        <div class="radio-cont">
                                            <input type="radio" class="radio-box" id="" name="" value="">
                                            <label>해당년도 수료 시 체크 ( 오프/온라인 교육 모두 완료 시 1년 자격연장 )</label>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="table-wrap">
                    <h2 class="h2-tit">강사 자격기간 정보</h2>

                    <!------   20211223  수정  ------>
                    <table class="list-tb">
                        <caption>자격기간, 강사자격정보, 수료일, 유지기간, 관리 정보가 있는 테이블</caption>
                        <colgroup>
                            <col width="15%"/>
                            <col width="*"/>
                            <col width="15%"/>
                            <col width="30%"/>
                            <col width="10%"/>
                        </colgroup>
                        <thead>
                            <tr>
                                <th>자격기간</th>
                                <th>강사 자격정보</th>
                                <th>수료일</th>   
                                <th>유지기간</th>
                                <th>관리</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td rowspan="4" class="no-border-b"></td>
                                <td class="tl">보고듣고말하기 2.0 기본형</td>
                                <td><input type="text" class="input-box" value="" readonly/></td>
                                <td>
                                    <div class="picker-wrap">
                                        <input type="text" id="datepickerFrom" class="input-box"/>
                                        <span class="next-ico">-</span>
                                        <input type="text" id="datepickerTo" class="input-box"/>
                                    </div>
                                </td>
                                <td><button class="sm-btn blue-btn">수정</button></td>
                            </tr>
                            <tr>
                                <td class="tl">보고듣고말하기 2.0 중학생</td>
                                <td><input type="text" class="input-box" value="" readonly/></td>
                                <td>
                                    <div class="picker-wrap">
                                        <input type="text" id="datepickerFrom" class="input-box"/>
                                        <span class="next-ico">-</span>
                                        <input type="text" id="datepickerTo" class="input-box"/>
                                    </div>
                                </td>
                                <td><button class="sm-btn blue-btn">수정</button></td>
                            </tr>
                            <tr>
                                <td class="tl">이어줌인 직장인</td>
                                <td><input type="text" class="input-box" value="" readonly/></td>
                                <td>
                                    <div class="picker-wrap">
                                        <input type="text" id="datepickerFrom" class="input-box"/>
                                        <span class="next-ico">-</span>
                                        <input type="text" id="datepickerTo" class="input-box"/>
                                    </div>
                                </td>
                                <td><button class="sm-btn blue-btn">수정</button></td>
                            </tr>
                            <tr>
                                <td class="tl">이어줌인 노인</td>
                                <td><input type="text" class="input-box" value="" readonly/></td>
                                <td>
                                    <div class="picker-wrap">
                                        <input type="text" id="datepickerFrom" class="input-box"/>
                                        <span class="next-ico">-</span>
                                        <input type="text" id="datepickerTo" class="input-box"/>
                                    </div>
                                </td>
                                <td><button class="sm-btn blue-btn">수정</button></td>
                            </tr>
                        </tbody>
                    </table><!------   // 20211223  수정  ------>
                </div>

                <div class="btn-cont">
                    <button class="mid-btn blue-btn">저장하기</button>
                    <button class="mid-btn white-btn">취소</button>
                </div>
</div>

<div class="btn-cont mb20">
    <dl class="count-txt">
        <dt>전체 <span>115</span></dt>
        <dt class="green-txt">활동<span>115</span></dt>
        <dt class="gray-txt">상실(일반) <span>115</span></dt>
        <dt class="purple-txt">휴직 <span>115</span></dt>
    </dl>

    <button class="mid-btn black-btn">엑셀다운</button>
    <button class="mid-btn white-btn">선택삭제</button>
</div>

<div class="table-wrap scroll-wrap">
    <table class="list-tb">
        <caption>선택, 상태, 강사명, 강사분류, 성별, 이메일, 연락처, 강의횟수,누적 강의횟수, 지역, 소속기관, 최종 수료일, 오프라인 2회교육, 온라인 보수교육, 수정 정보가 있는 테이블</caption>
        <colgroup>
            <col width="3%"/>
            <col width="4%"/>
            <col width="5%"/>
            <col width="8%"/>
            <col width="6%"/>
            <col width="5%"/>
            <col width="*"/>
            <col width="8%"/>
            <col width="6%"/>
            <col width="6%"/>
            <col width="6%"/>
            <col width="6%"/>
            <col width="6%"/>
            <col width="6%"/>
            <col width="6%"/>
            <col width="6%"/>
        </colgroup>
        <thead>
            <tr>
                <th><input type="checkbox" class="check-box"/></th>
                <th>No.</th>
                <th>상태</th>   
                <th>강사(ID)</th>
                <th>강사분류</th>
                <th>성별</th>
                <th>이메일</th>
                <th>연락처</th>
                <th>강의횟수</th>
                <th>누적<br/>강의횟수</th>
                <th>지역</th>
                <th>소속기관</th>
                <th>최종<br/>수료일</th>
                <th>오프라인<br/>2회교육</th>
                <th>온라인<br/>보수교육</th>
                <th>수정</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="checkbox" class="check-box"/></td>
                <td>1</td>
                <td>활동</td>
                <td><span class="block">이보람</span><span  class="block">fgfdfdgfdgg</span></td>
                <td>기업</td>
                <td>남</td>
                <td>fgfdfdgfdgg@naver.com</td>
                <td>01012345678</td>
                <td>32</td>
                <td>120</td>
                <td>서울</td>
                <td>한신만어ㅏㅣ러ㅏㅁ러</td>
                <td>2021.10.05</td>
                <td><span class="blue-txt">완료</span></td>
                <td><span class="red-txt">미완료</span></td>
                <td><button class="sm-btn blue-btn">수정</button></td>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
</div>

<div class="page-wrap">
    <ul class="paging">
        <li><a>&lt;&lt;</a></li>
        <li><a>&lt;</a></li>
        <li class="on"><a>1</a></li>
        <li><a>2</a></li>
        <li><a>3</a></li>
        <li><a>4</a></li>
        <li><a>5</a></li>
        <li><a>6</a></li>
        <li><a>7</a></li>
        <li><a>8</a></li>
        <li><a>9</a></li>
        <li><a>10</a></li>
        <li><a>&gt;</a></li>
        <li><a>&gt;&gt;</a></li>
    </ul>
</div>