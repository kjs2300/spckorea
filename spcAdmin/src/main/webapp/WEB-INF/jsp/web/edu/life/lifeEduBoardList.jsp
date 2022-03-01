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


	<!-- container  begin -->
   <div id="container">

       <div class="tit-wrap">
           <h1 class="h1-tit">생명지킴이 활동 수기</h1>

           <div class="side-cont">
               <img src="${pageContext.request.contextPath}/user/images/common/ico_home.png" alt="홈 바로가기"/>
               <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
               <span>생명지킴이교육</span>
               <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
               <span>생명지킴이 활동 수기</span>
           </div>
       </div>

       <div class="contents-wrap">
           <!---- search-wrap begin ---->
           <div class="search-wrap">
               <div class="search-cont">
                   <label>기간 :</label>
                   <div class="radio-cont">
                       <input type="radio" class="radio-box" id="dateAll" name="radioGroupDate" value="" checked>
                       <label for="dateAll">전체</label>
                   </div>
                     
                   <div class="radio-cont">
                       <input type="radio" class="radio-box" id="dateToday" name="radioGroupDate" value="">
                       <label for="dateToday">오늘</label>
                   </div>
                   
                   <div class="radio-cont mr10">
                       <input type="radio" class="radio-box" id="dateTerm" name="radioGroupDate" value="">
                       <label for="dateTerm">기간선택</label>
                   </div>
                   <div class="picker-wrap">
                       <input type="text" id="datepickerFrom" class="input-box"/>
                       <span class="next-ico">-</span>
                       <input type="text" id="datepickerTo" class="input-box"/>
                   </div>
               </div>
               <div class="search-cont">
                   <label>검색어 :</label>
                   <div class="radio-cont">
                       <input type="radio" class="radio-box" id="" name="radioGroupDate" value="" checked>
                       <label for="">전체</label>
                   </div>
                     
                   <div class="radio-cont">
                       <input type="radio" class="radio-box" id="" name="radioGroupDate" value="">
                       <label for="">제목</label>
                   </div>
                   
                   <div class="radio-cont mr10">
                       <input type="radio" class="radio-box" id="" name="radioGroupDate" value="">
                       <label for="">작성자명</label>
                   </div>
                   <div class="radio-cont mr10">
                       <input type="radio" class="radio-box" id="" name="radioGroupDate" value="">
                       <label for="">내용</label>
                       <input type="text" class="input-box" placeholder="직접입력"/>
                   </div>
               </div>

               <div class="btn-cont">
                   <button  type="button" class="lg-btn orange-btn">검색</button>
                   <button  type="reset"  class="lg-btn navy-btn">초기화</button>
               </div>
           </div>
           <!---- search-wrap end ---->

           <!---- txt-group begin ---->
           <dl class="txt-group">
               <dt>본 게시판은 생명지킴이 활동 경험을 나누는 공간입니다.</dt>
               <dd>책임 있는 게시를 위해 실명으로 게시되고 있으며, 욕설, 비방, 광고성 글, 허위사실유포 등 본 게시판의 목적에 맞지 않는 글은 게시자에게 통보 없이 삭제될 수 있습니다. </dd>
               <dd>동일 내용의 반복 게재, 게시판 도배 등 홈페이지의 정상적인 운영을 저해하는 경우 글쓰기 권한이 제한될 수 있음을 알려드립니다.</dd>
               <dd>중요한 개인정보 보호를 위해 성명, 주민등록번호, 연락처, 집주소 등의 게시나 등록을 금지합니다.</dd>
               <dd>정보통신망이용촉진 및 정보보호 등에 관한 법률 제70조에 의거 사람을 비방할 목적으로 정보통신망을 통하여 공공연하게 사실을 드러내어 다른 사람의 명예를 훼손한 자는 처벌받을 수 있음을 알려드리며, 등록된 게시물은 게시자에게 통보 없이 삭제될 수 있음을 알려드립니다.</dd>
               <dd>타인의 저작권을 포함한 지적재산권 및 기타권리를 침해하는 내용물은 등록할 수 없으며, 이와 같은 게시물로 인해 발생하는 결과에 대한 책임은 작성자 본인에게 있습니다.</dd>
           </dl>
           <!---- txt-group end ---->

           <!---- sub-cont begin ---->
           <div class="btn-cont mb20">
               <button class="sm-btn navy-btn">등록</button>
           </div>
           <!---- sub-cont end ---->

           <div class="comp mt20">
           <div class="table-wrap">
               <table class="list-tb">
                   <caption>교육소개, 교육목표, 차시 정보가 있는 테이블</caption>
                   <colgroup>
                       <col width="7%"/>
                       <col width="*"/>
                       <col width="10%"/>
                       <col width="13%"/>
                       <col width="10%"/>
                   </colgroup>
                   <thead>
                       <tr>
                           <th>No.</th>
                           <th>제목</th>
                           <th>작성자</th>
                           <th>작성일</th>
                           <th>조회수</th>
                       </tr>
                   </thead>
                   <tbody>
                   	<c:forEach var="result" items="${resultList}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td class="tl"><a class="link" href="#">${result.title}</a></td>
                            <td>${result.reg_id}</td>
                            <td>${fn:substring(result.reg_dt,0,10) }</td>
                            <td>${result.view_cnt}</td>
                        </tr>
                       </c:forEach>
     <c:if test="${empty resultList }">
       <tr>
           <td colspan='5'/>Data 없습니다.</td>
       </tr>
   	</c:if>
                   </tbody>
               </table>
           </div>
       </div>
        <!---- page begin ---->
       <div class="page-wrap">
   <ul class="paging">
       <ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
   </ul>
 </div>
        <!---- page end ---->	
       </div>
   </div>
   <!--  container end -->


 
<script type="text/javascript">
 
 $(document).ready(function(){
		 $("#board_start_date, #board_end_date").datepicker({
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
 
function fn_edit(key1, str) {
 	var frm = document.listForm;
 	$("#board_idx").val(key1);
  	frm.action = "<c:url value='/adBoard/noticeReq.do'/>";
 	frm.submit();
}

function fn_delete(idx) {
	var idxArray = new Array();

	idxArray.push(idx);
	if(confirm('삭제 처리하시겠습니까?')) {
		setDel(idxArray);
	}

}

var btnDel = function() {

	var idxArray = new Array();

	$("input[name=checkNo]:checked").each(function() {
		idxArray.push($(this).val());
	});

	if(idxArray.length < 1){
		alert("선택한 내역이 없습니다.");
		return false;
	}
	
	if(confirm('삭제 처리하시겠습니까?')) {
		setDel(idxArray);
	}
	
};

var setDel = function(idxArray){
    $.ajax({
        url: "/adBoard/noticeDel.do",
        type: "POST",
        data: { "boardIdxArray" : idxArray },
        success: function(data) {
        	if(data == 'SUCCESS'){
        		alert("처리 완료하였습니다.");
        		location.reload();
        	}
        },
        error: function(data) {
        	console.log(JSON.stringify(data));
        	alert("처리중 오류가 발생했습니다.");
        }
    });
};

 </script>