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

<h1 class="h1-tit">참여마당</h1>

<div class="search-wrap">
	<form id="listForm" name="listForm" target="_self" action="/adBoard/partiList.do" method="post" onsubmit="">
     <input type="hidden" id="board_idx"   name="board_idx"  value="${adBoardVo.board_idx}"/>
     <input type="hidden" id="gubun1"      name="gubun1"     value='I'   />
    
    <div class="search-cont">

        <div class="radio-cont">
            <input type="radio" class="radio-box" id="radio" name="radio" value="ALL" <c:if test="${adBoardVo.searchCondition =='ALL'  || (empty adBoardVo.searchCondition) }">checked </c:if>>
            <label for="">전체</label>
        </div>
        <div class="radio-cont">
            <input type="radio" class="radio-box" id="radio" name="radio" value="TITLE" <c:if test="${adBoardVo.searchCondition =='TITLE'}">checked </c:if>>
            <label for="">제목</label>
        </div>
        <div class="radio-cont">
            <input type="radio" class="radio-box" id="radio" name="radio" value="REG_NM" <c:if test="${adBoardVo.searchCondition =='REG_NM'}">checked </c:if>>
            <label for="">작성자명</label>
        </div>
        <div class="radio-cont">
            <input type="radio" class="radio-box" id="radio" name="radio" value="CONTENTS" <c:if test="${adBoardVo.searchCondition =='CONTENTS'}">checked </c:if>>
            <label for="">내용</label>
        </div>
        <input type="text" id='searchKeyword' name='searchKeyword' value="${adBoardVo.searchKeyword}" class="input-box" placeholder="직접입력"/>
    </div>

    <div class="search-cont">

        <div class="radio-cont">
            <input type="radio" class="radio-box" id="dateAll" name="radioGroupDate" value="ALL" <c:if test="${adBoardVo.searchDate == 'ALL' || (empty adBoardVo.searchCondition)}">checked </c:if>>
            <label for="dateAll">전체</label>
        </div>
          
        <div class="radio-cont mr10">
            <input type="radio" class="radio-box" id="dateTerm" name="radioGroupDate" value="CHECK" <c:if test="${adBoardVo.searchDate == 'CHECK'}">checked </c:if>>
            <label for="dateTerm">기간선택</label>
        </div>
        <div class="picker-wrap">
            <input type="text" id="board_start_date" name="board_start_date" class="input-box" readonly value="${adBoardVo.board_start_date}"/>
            <span class="next-ico">-</span>
            <input type="text" id="board_end_date" name="board_end_date" class="input-box" readonly value="${adBoardVo.board_end_date}"/>
        </div>
        
        <button type="submit" class="search-btn">검색</button>
        <button class="search-btn white-btn ml20">초기화</button>
    </div>
    </form>

</div>

<div class="btn-cont mb20">
    <button class="mid-btn blue-btn">등록</button>
    <button class="mid-btn white-btn">선택삭제</button>
</div>

<div class="table-wrap">
    <table class="list-tb">
        <caption>선택, 카테고리, 제목, 첨부파일, 작성일, 작성자, 조회수, 관리 정보가 있는 테이블</caption>
        <colgroup>
            <col width="5%"/>
            <col width="7%"/>
            <col width="9%"/>
            <col width="*"/>
            <col width="10%"/>
            <col width="10%"/>
            <col width="8%"/>
            <col width="8%"/>
            <col width="7%"/>
            <col width="7%"/>
        </colgroup>
        <thead>
            <tr>
                <th><input type="checkbox" class="check-box"/></th>
                <th>No.</th>
                <th>카테고리</th>
                <th>제목</th>
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
                <td>공지</td>
                <td class="tl">2021년 생명지킴이 강사 보수교육 실시 안내</td>
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
                <td></td>
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
                <td></td>
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
                <td></td>
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
                <td></td>
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
                <td></td>
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
                <td></td>
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
                <td></td>
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
                <td></td>
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
                <td></td>
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