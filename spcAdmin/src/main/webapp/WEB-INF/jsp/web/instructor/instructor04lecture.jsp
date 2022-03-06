
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
                        <h1 class="h1-tit">강의내역</h1>

                        <div class="side-cont">
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_home.png" alt="홈 바로가기"/>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>생명지킴이 강사 공간</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>자격관리</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>강의내역</span>
                        </div>
                    </div>

                    <div class="contents-wrap">

                        <!---- search-wrap begin ---->
                        <div class="search-wrap">
                            <div class="search-cont">
                                <label>기간 :</label>
                                <div class="picker-wrap">
                                    <input type="text" id="datepickerFrom" class="input-box"/>
                                    <span class="next-ico">-</span>
                                    <input type="text" id="datepickerTo" class="input-box"/>
                                </div>
                            </div>
                            <div class="search-cont">
                                <label>분류 :</label>
                                <select class="select">
                                    <option>분류 1</option>
                                    <option>일반</option>
                                </select>
                                <select class="select">
                                    <option>분류 2</option>
                                </select>
                                <select class="select">
                                    <option>분류 3</option>
                                </select>
                            </div>

                            <div class="search-cont">
                                <label>지역 :</label>
                                <div class="radio-cont">
                                    <input type="radio" class="radio-box" id="" name="" value="" checked>
                                    <label for="">전체</label>
                                </div>
                                <div class="radio-cont">
                                    <input type="radio" class="radio-box" id="" name="" value="">
                                    <select class="select">
                                        <option>지역선택</option>
                                        <option>서울</option>
                                    </select>
                                </div>

                                <label>기관명 :</label>
                                <div class="radio-cont">
                                    <input type="radio" class="radio-box" id="" name="" value="" checked>
                                    <label for="">전체</label>
                                </div>
                                <div class="radio-cont">
                                    <input type="radio" class="radio-box" id="" name="radioGroupDate" value="">
                                    <input type="text" class="input-box" placeholder="직접입력"/>
                                </div>
                            </div>

                            <div class="btn-cont mb20">
                                <button class="lg-btn orange-btn">검색</button>
                                <button class="lg-btn navy-btn">초기화</button>
                            </div>
                        </div>
                        <!---- search-wrap end ---->

                        <!---- summary-wrap begin ---->
                        <div class="summary-wrap">
                            <ul class="summary-cont">
                                <li>
                                    <label>당해년도 강의횟수 :</label>
                                    <span>5</span>
                                </li>
                                <li>
                                    <label>총 누적 강의 횟수 :</label>
                                    <span>23</span>
                                </li>
                            </ul>
                        </div>
                        <!---- summary-wrap end ---->

                        <div class="comp mt20">
                            <div class="table-wrap">
                                <table class="list-tb">
                                    <caption>교육일시, 지역, 교육장소, 기관명, 교육명, 교육대상, 교육인원, 신청하기 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="15%"/>
                                        <col width="20%"/>
                                        <col width="20%"/>
                                        <col width="20%"/>
                                        <col width="*"/>
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th>분류1</th>
                                            <th>분류2</th>
                                            <th>분류3</th>
                                            <th>자격</th>
                                            <th>자격 유지기간</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>일반</td>
                                            <td class="tl">온라인생명 지킴이 교육</td>
                                            <td class="tl">보고듣고말하기2.0 기본형(120분)</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                        <tr>
                                            <td>일반</td>
                                            <td class="tl">온라인생명 지킴이 교육</td>
                                            <td class="tl">보고듣고말하기2.0 기본형(120분)</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                        <tr>
                                            <td>일반</td>
                                            <td class="tl">온라인생명 지킴이 교육</td>
                                            <td class="tl">보고듣고말하기2.0 기본형(120분)</td>
                                            <td><input type="checkbox" class="check-box"/></td>
                                            <td>
                                                <span>2019-07-15</span>~<span>2020-12-31</span></td>
                                        </tr>
                                    </tbody>
                                </table>
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