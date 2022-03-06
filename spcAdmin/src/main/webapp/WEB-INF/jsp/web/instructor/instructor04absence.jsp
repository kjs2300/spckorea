
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
 function fn_detail(edu_no){
	document.location = "<c:url value='/user/sectorView.do'/>"+"?edu_no="+edu_no+"&idx="+$('#idx').val();
 }	
</script>
     <!-- container  begin -->
                <div id="container">
                    <div class="tit-wrap">
                        <h1 class="h1-tit">강사휴직 신청</h1>

                        <div class="side-cont">
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_home.png" alt="홈 바로가기"/>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>생명지킴이 강사 공간</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>자격관리</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>강사휴직 신청</span>
                        </div>
                    </div>

                    <div class="contents-wrap">
                        
                        <div class="comp">
                            <div class="table-wrap">
                                <table class="detail-tb">
                                    <caption>강사명, 소속기관, 주소, 연락처, 수료증번호, 휴직사유, 휴직기간, 신청서 양식, 신청서 첨부 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="20%"/>
                                        <col width="*"/>
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>강사명</th>
                                            <td>이지인</td>
                                        </tr>
                                        <tr>
                                            <th>소속기관</th>
                                            <td>한국생명존중희망재단</td>
                                        </tr>
                                        <tr>
                                            <th>주소</th>
                                            <td>서울 중구 을지로 6 (을지로1가) 재능빌딩 11층</td>
                                        </tr>
                                        <tr>
                                            <th>연락처</th>
                                            <td>02-2203-0053</td>
                                        </tr>
                                        <tr>
                                            <th>수료증번호</th>
                                            <td>교육 제21-0068호</td>
                                        </tr>
                                        <tr>
                                            <th>휴직사유</th>
                                            <td>
                                                <div class="radio-cont">
                                                    <input type="radio" class="radio-box" id="" name="" value="">
                                                    <label for="">출산 및 육아</label>
                                                </div>
                                                <div class="radio-cont">
                                                    <input type="radio" class="radio-box" id="" name="" value="">
                                                    <label for="">병가</label>
                                                </div>
                                                <div class="radio-cont">
                                                    <input type="radio" class="radio-box" id="" name="" value="">
                                                    <label for="">해외연수</label>
                                                </div>
                                                <div class="radio-cont">
                                                    <input type="radio" class="radio-box" id="" name="" value="">
                                                    <label for="">기타</label>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>휴직기간</th>
                                            <td>
                                                <div class="picker-wrap">
                                                    <input type="text" id="datepickerFrom" class="input-box"/>
                                                    <span class="next-ico">-</span>
                                                    <input type="text" id="datepickerTo" class="input-box"/>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>신청서 양식</th>
                                            <td><button class="sm-btn white-btn">신청하기</button></td>
                                        </tr>
                                        <tr>
                                            <th>신청서 첨부</th>
                                            <td>
                                                <div class="upload-box">
                                                    <input type="file" />
                                                    <button class="sm-btn black-btn">삭제</button>
                                                    <label>
                                                        파일명: <span>2021년 강사 교육 안내</span>
                                                    </label>
                                                    <p class="point">파일크기 200MB 이하</p>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <!---- button begin ---->
                        <div class="btn-cont">
                            <button class="lg-btn orange-btn">신청하기</button>
                        </div>
                        <!---- button end ---->
                       

                    </div>
                </div>
                <!--  container end -->