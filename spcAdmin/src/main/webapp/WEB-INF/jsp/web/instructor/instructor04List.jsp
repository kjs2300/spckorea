
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
                        <h1 class="h1-tit">강사자격 정보</h1>

                        <div class="side-cont">
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_home.png" alt="홈 바로가기"/>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>생명지킴이 강사 공간</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>자격관리</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>강사자격 정보</span>
                        </div>
                    </div>

                    <div class="contents-wrap">

                        <!---- view-wrap begin ---->
                        <div class="view-wrap">
                            <h4 class="h4-tit">강사 기본정보</h4>
                            <ul class="summary-cont">
                                <li>
                                    <label>소속기관 :</label>
                                    <span>한국생명존중 희망재단</span>
                                </li>
                                <li>
                                    <label>지역 :</label>
                                    <span>서울</span>
                                </li>
                                <li>
                                    <label>연락처 :</label>
                                    <span>01044280505</span>
                                </li>
                            </ul>

                            <h4 class="h4-tit">강사 수료 정보 <span class="point">( 강사수료증 발급은 마이페이지에서 가능합니다.)</span>
                            </h4>
                            
                            <ul class="summary-cont">
                                <li>
                                    <label>수료번호 :</label>
                                    <span>교육 제21-0068호</span>
                                </li>
                                <li>
                                    <label>수료일 :</label>
                                    <span>2021.07.15</span>
                                </li>
                                <li>
                                    <label>강사상태 :</label>
                                    <span>활동강사</span>
                                </li>
                            </ul>
                        </div>
                        <!---- view-wrap end ---->


                        <div class="comp">
                            <h4 class="h4-tit">자격범위 및 자격유지 기간</h4>

                            <div class="table-wrap">
                                <table class="list-tb"> <!------  20211224 수정  --------->
                                    <caption>자격범위 및 자격유지 기간, 자격, 자격 유지기간 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="*"/>
                                        <col width="10%"/>
                                        <col width="30%"/>
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th>자격범위 및 자격유지 기간</th>
                                            <th>자격</th>
                                            <th>자격 유지기간</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="tl">보고듣고말하기2.0 기본형(120분)</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                        <tr>
                                            <td class="tl">보고듣고말하기 2.0 청년</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                        <tr>
                                            <td class="tl">보고듣고말하기 2.0 중년</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                        <tr>
                                            <td class="tl">보고듣고말하기 2.0 노인</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                        <tr>
                                            <td class="tl">보고듣고말하기 2.0 중학생</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                        <tr>
                                            <td class="tl">보고듣고말하기 2.0 고등학생</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                        <tr>
                                            <td class="tl">이어줌인 직장인</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                        <tr>
                                            <td class="tl">이어줌인 노인</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                    </tbody>
                                </table><!------  //20211224 수정  --------->
                            </div>
                        </div>

                        <!---- page begin ---->
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
                        <!---- page end ---->

                    </div>
                </div>
                <!--  container end -->