
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
                        <h1 class="h1-tit">강사 자료실</h1>

                        <div class="side-cont">
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_home.png" alt="홈 바로가기"/>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>생명지킴이 강사 공간</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>강사 자료실</span>
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
                                <label>교육명 :</label>
                                <div class="radio-cont">
                                    <input type="radio" class="radio-box" id="" name="" value="" checked>
                                    <label for="">전체</label>
                                </div>
                                <div class="radio-cont mr10">
                                    <input type="radio" class="radio-box" id="" name="" value="">
                                    <input type="text" class="input-box" placeholder="직접입력"/>
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
                                <button class="lg-btn orange-btn">검색</button>
                                <button class="lg-btn navy-btn">초기화</button>
                            </div>
                        </div>
                        <!---- search-wrap end ---->

                        <div class="comp">
                            <div class="table-wrap">
                                <table class="list-tb">
                                    <caption>교육명, 제목, 첨부파일, 작성일, 작성자, 조회수 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="7%"/>
                                        <col width="18%"/>
                                        <col width="*"/>
                                        <col width="13%"/>
                                        <col width="13%"/>
                                        <col width="9%"/>
                                        <col width="8%"/>
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>교육명</th>
                                            <th>제목</th>
                                            <th>첨부파일</th>
                                            <th>작성일</th>
                                            <th>작성자</th>
                                            <th>조회수</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>10</td>
                                            <td class="tl">보고 듣고 말하기 2.0 청소년</td>
                                            <td class="tl"><a class="link" href="">2021년 생명지킴이 강사 보수교육 실시 안내</a></td>
                                            <td><button class="sm-btn white-btn">다운로드</button></td>
                                            <td>2021.05.26</td>
                                            <td>관리자</td>
                                            <td>183</td>
                                        </tr>
                                        <tr>
                                            <td>9</td>
                                            <td class="tl">보고 듣고 말하기 2.0 청소년</td>
                                            <td class="tl"><a class="link" href="">2021년 생명지킴이 강사 보수교육 실시 안내</a></td>
                                            <td><button class="sm-btn white-btn">다운로드</button></td>
                                            <td>2021.05.26</td>
                                            <td>관리자</td>
                                            <td>183</td>
                                        </tr>
                                        <tr>
                                            <td>8</td>
                                            <td class="tl"></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td class="tl"></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td class="tl"></td>
                                            <td class="tl"></td>
                                            <td></td>
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