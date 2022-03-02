
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
  
</script>
     <!-- container  begin -->
            <div id="container">

                    <div class="tit-wrap">
                        <h1 class="h1-tit">신청현황</h1>

                        <div class="side-cont">
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_home.png" alt="홈 바로가기"/>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>마이페이지</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>일반</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>신청현황</span>
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
                                <label>교육분류 :</label>
                                <select class="select">
                                    <option>분류를 선택해 주세요</option>
                                    <option>분류1</option>
                                </select>
                                <select class="select">
                                    <option>분류를 선택해 주세요</option>
                                    <option>분류2</option>
                                </select>
                                <select class="select">
                                    <option>분류를 선택해 주세요</option>
                                    <option>분류3</option>
                                </select>
                            </div>

                            <div class="btn-cont">
                                <button class="lg-btn orange-btn">검색</button>
                                <button class="lg-btn navy-btn">초기화</button>
                            </div>
                        </div>
                        <!---- search-wrap end ---->

                        <div class="btn-cont mb20">
                            <button class="lg-btn white-btn">선택삭제</button>
                        </div>

                        <div class="comp mt0">
                            <div class="table-wrap">
                                <table class="list-tb">
                                    <caption>분류1, 분류2, 분류3(교육명), 강사명, 신청일, 취소 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="8%"/>
                                        <col width="10%"/>
                                        <col width="14%"/>
                                        <col width="*"/>
                                        <col width="10%"/>
                                        <col width="10%"/>
                                        <col width="10%"/>
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>분류1</th>
                                            <th>분류2</th>
                                            <th>분류3(교육명)</th>
                                            <th>강사명</th>
                                            <th>신청일</th>
                                            <th>취소</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>3</td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl">보고 듣고 말하기 2.0 청소년</td>
                                            <td>이진우</td>
                                            <td>2021.12.15</td>
                                            <td><button class="sm-btn white-btn">취소</button></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl">보고 듣고 말하기 2.0 청소년</td>
                                            <td>이진우</td>
                                            <td>2021.12.15</td>
                                            <td><button class="sm-btn white-btn">취소</button></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
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