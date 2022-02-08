<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
                <h1 class="h1-tit">자료실</h1>


                <div class="search-wrap">
                    
                    <div class="search-cont">

                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="" name="" value="" checked>
                            <label for="">전체</label>
                        </div>
                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="" name="" value="">
                            <label for="">제목</label>
                        </div>
                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="" name="" value="">
                            <label for="">작성자명</label>
                        </div>
                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="" name="" value="">
                            <label for="">내용</label>
                        </div>
                    </div>

                    <div class="search-cont">

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

                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="" name="" value="" checked>
                            <label for="">전체</label>
                        </div>
                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="" name="" value="">
                            <select class="select">
                                <option>분류1</option>
                            </select>
                            <select class="select">
                                <option>분류2</option>
                            </select>
                            <select class="select">
                                <option>분류 3 : 교육명</option>
                            </select>
                        </div>
                        
                        <button class="search-btn">검색</button>
                        <button class="search-btn white-btn ml20">초기화</button>
                    </div>

                </div>
                
                <div class="btn-cont mb20">
                    <button class="mid-btn blue-btn" onclick="location.href = '/adBoard/referenceReq.do'; ">등록</button>
                    <button class="mid-btn white-btn">선택삭제</button>
                </div>
                
                <div class="table-wrap">
                    <table class="list-tb">
                        <caption>선택, 제목, 분류1, 분류2, 분류3, 첨부파일, 작성일, 작성자, 조회수, 관리 정보가 있는 테이블</caption>
                        <colgroup>
                            <col width="4%"/>
                            <col width="5%"/>
                            <col width="*"/>
                            <col width="9%"/>
                            <col width="10%"/>
                            <col width="10%"/>
                            <col width="9%"/>
                            <col width="8%"/>
                            <col width="6%"/>
                            <col width="6%"/>
                            <col width="7%"/>
                            <col width="7%"/>
                        </colgroup>
                        <thead>
                            <tr>
                                <th><input type="checkbox" class="check-box"/></th>
                                <th>No.</th>
                                <th>제목</th>
                                <th>분류1</th>
                                <th>분류2</th>
                                <th>분류3</th>
                                <th>첨부파일</th>
                                <th>작성일</th>
                                <th>작성자</th>
                                <th>조회수</th>
                                <th colspan="2">관리</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input type="checkbox" class="check-box"/></td>
                                <td>1</td>
                                <td class="tl">2021년 생명지킴이 강사 보수교육 실시 안내</td>
                                <td class="tl">분류분류분류1</td>
                                <td class="tl">분류분류분류분류분류2</td>
                                <td class="tl">분류분류분류분류분류분류분류3</td>
                                <td><button class="sm-btn white-btn">다운로드</button></td>
                                <td>2021.10.05</td>
                                <td>관리자</td>
                                <td>120</td>
                                <td><button class="sm-btn black-btn">수정</button></td>
                                <td><button class="sm-btn white-btn">삭제</button></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
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
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
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
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
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
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
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
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
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
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
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
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
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
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
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
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
                                <td class="tl"></td>
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
