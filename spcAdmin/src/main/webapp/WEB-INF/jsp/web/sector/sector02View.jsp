
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


     <!-- container  begin -->
                <div id="container">

                    <div class="tit-wrap">
                        <h1 class="h1-tit">교육신청</h1>

                        <div class="side-cont">
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_home.png" alt="홈 바로가기"/>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>분야별 교육신청</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>생명지킴이 강사 양성교육</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>교육신청</span>
                        </div>
                    </div>

                    <div class="contents-wrap">

                        <!---- view-wrap begin ---->
                        <div class="view-wrap">
                            <span class="badge-normal">일반</span>
                            <span class="tag">온라인생명 지킴이 교육</span>
                            <h3 class="h3-tit">보고듣고말하기2.0 기본형(120분)</h3>
                            <ul class="summary-cont">
                                <li>
                                    <label>교육내용 :</label>
                                    <span>2021년 제 11차 생명지킴이 강사양성 교육</span>
                                </li>
                                <li>
                                    <label>교육기간 :</label>
                                    <span>2021.01.01</span>~<span>2022.11.07</span>
                                </li>
                                <li>
                                    <label>교육방식 :</label>
                                    <span>오프라인 교육</span>
                                </li>
                                <li>
                                    <label>학습시간 :</label>
                                    <span>120</span>분
                                </li>
                                <li>
                                    <label>강사명 :</label>
                                    <span>이선우</span>
                                </li>
                                <li>
                                    <label>안내문 :</label>
                                    <a class="link">다운로드</a>
                                </li>
                                
                            </ul>
                        </div>
                        <!---- view-wrap end ---->

                        <div class="comp">
                            <h4 class="h4-tit">상세내용</h4>
                            
                            <div class="table-wrap">
                                <table class="detail-tb">
                                    <caption>교육소개, 교육목표, 차시 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="20%"/>
                                        <col width="*"/>
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>교육소개</th>
                                            <td>본 학습은 보고듣고말하기2.0 기본형으로 기초적인 학습에 중접을 둡니다.</td>
                                        </tr>
                                        <tr>
                                            <th>교육목표</th>
                                            <td>생명지킴이의 자질을 보완하고 …………….</td>
                                        </tr>
                                        <tr>
                                            <th>차시</th>
                                            <td>
                                                <ul class="dot-list">
                                                    <li>1회차 - 보고듣고말하기 기초편 – 45분</li>
                                                    <li>2회차 - 보도듣고말하기 심화편 – 75분</li>
                                                </ul>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>

                        <!---- button begin ---->
                        <div class="btn-cont">
                            <button class="lg-btn orange-btn">수강신청</button>
                            <button class="lg-btn navy-btn">장바구니</button>
                            <button class="lg-btn white-btn">목록</button>
                        </div>
                        <!---- button end ---->

                    </div>
                </div>
                <!--  container end -->