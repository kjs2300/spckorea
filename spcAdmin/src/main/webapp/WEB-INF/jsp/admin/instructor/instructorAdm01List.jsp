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

<h1 class="h1-tit">강사 자격 정보</h1>

<div class="search-wrap">
    <div class="search-cont  search-sub full-width">
        <h3 class="h3-tit">강사 자격범위</h3>

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
                <option>분류3</option>
            </select>
        </div>
    </div>

    <div class="search-cont search-sub">
        <h3 class="h3-tit">기관명</h3>

        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="" checked>
            <label for="">전체</label>
        </div>
        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="">
            <input type="text" class="input-box" placeholder="직접입력"/>
        </div>
    </div>

    <div class="search-cont search-sub">
        <h3 class="h3-tit">지역</h3>

        <div class="radio-cont">
            <input type="text" class="input-box" placeholder="직접입력"/>
        </div>
    </div>

    <div class="search-cont search-sub">
        <h3 class="h3-tit">강사명</h3>
        
        <div class="radio-cont">
            <input type="text" class="input-box" placeholder="직접입력"/>
        </div>
    </div>

    <div class="search-cont search-sub">
        <h3 class="h3-tit">강사상태</h3>
        
        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="" checked>
            <label for="">전체</label>
        </div>

        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="">
            <label for="">활동</label>
        </div>

        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="">
            <label for="">상실(일반)</label>
        </div>

        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="">
            <label for="">휴직</label>
        </div>
    </div>

    <div class="search-cont search-sub full-width">
        <h3 class="h3-tit">강사분류</h3>

        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="" checked>
            <label for="">전체</label>
        </div>
        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="">
            <label for="">일반강사</label>
        </div>
        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="">
            <label for="">실무자</label>
        </div>
        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="">
            <label for="">공공기간(학교, 군, 경찰, 도시철도 등)</label>
        </div>
        <div class="radio-cont">
            <input type="radio" class="radio-box" id="" name="" value="">
            <label for="">기업(삼성,현대. sk 등)</label>
        </div>
    </div>

    <div class="search-cont">
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
        
        <button class="search-btn">검색</button>
        <button class="search-btn white-btn ml20">초기화</button>
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