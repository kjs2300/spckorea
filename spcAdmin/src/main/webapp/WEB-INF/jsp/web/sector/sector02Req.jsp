
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
                        
                        <div class="comp">
                            <h4 class="h4-tit">교육정보</h4>
                            <div class="table-wrap">
                                <table class="detail-tb">
                                    <caption>교육분류, 교육명, 강사명, 교육기간, 교육방식, 교육대상, 교육상태 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="20%"/>
                                        <col width="*"/>
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>교육분류</th>
                                            <td>
                                                <span>분류1</span>
                                                <span>분류2</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>교육명</th>
                                            <td>보고듣고말하기2.0 기본형(120분)</td>
                                        </tr>
                                        <tr>
                                            <th>강사명</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>교육기간</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>교육방식</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>교육대상</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>교육상태</th>
                                            <td></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="comp">
                            <h4 class="h4-tit">신청자 정보</h4>
                            <div class="table-wrap">
                                <table class="detail-tb">
                                    <caption>회원유형, 이름, 아이디, 휴대폰, 이메일 정보가 있는 테이블</caption>
                                    <colgroup>
                                        <col width="20%"/>
                                        <col width="*"/>
                                    </colgroup>
                                    <tbody>
                                        <tr>
                                            <th>회원유형</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>이름</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>아이디</th>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <th>휴대폰</th>
                                            <td><input type="text" class="input-box lg-width" placeholder="- 없이 입력해주세요" value=""/></td>
                                        </tr>
                                        <tr>
                                            <th>이메일</th>
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
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        
                        <!---- button begin ---->
                        <div class="btn-cont">
                            <button class="lg-btn orange-btn">신청하기</button>
                            <button class="lg-btn white-btn">목록</button>
                        </div>
                        <!---- button end ---->
                        

                    </div>
                </div>
                <!--  container end -->