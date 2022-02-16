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

<h1 class="h1-tit">수강생/수료생 현황</h1>

<div class="search-wrap">
    <div class="search-cont">
        <div class="radio-cont">
            <input type="radio" class="radio-box" id="dateAll" name="" value="" checked>
            <label for="dateAll">전체</label>
        </div>
        <div class="radio-cont mr10">
            <input type="radio" class="radio-box" id="dateTerm" name="" value="">
            <label for="dateTerm">수강생</label>
        </div>
        <div class="radio-cont mr10">
            <input type="radio" class="radio-box" id="dateTerm" name="" value="">
            <label for="dateTerm">수료생</label>
        </div>
    </div>

    <div class="search-cont search-sub">
        <h3 class="h3-tit">구분</h3>

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
    <dl class="count-txt">
        <dt>전체 <span>4256</span></dt>
        <dt>수강생 <span>2700</span></dt>
        <dt>수료생 <span>1556</span></dt>
    </dl>

    <button class="mid-btn black-btn">엑셀다운</button>
    <button class="mid-btn white-btn">선택삭제</button>
</div>

<div class="table-wrap">
    <table class="list-tb">
        <caption>선택, 분류1, 분류2, 분류3, 강사명, 개설일, 수강생, 수료생 정보가 있는 테이블</caption>
        <colgroup>
            <col width="6%"/>
            <col width="8%"/>
            <col width="12%"/>
            <col width="17%"/>
            <col width="*"/>
            <col width="9%"/>
            <col width="9%"/>
            <col width="8%"/>
            <col width="8%"/>
        </colgroup>
        <thead>
            <tr>
                <th><input type="checkbox" class="check-box"/></th>
                <th>No.</th>
                <th>분류1</th>
                <th>분류2</th>
                <th>분류3</th>
                <th>강사명</th>
                <th>개설일</th>
                <th>수강생</th>
                <th>수료생</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="checkbox" class="check-box"/></td>
                <td>1</td>
                <td class="tl">분류분류1</td>
                <td class="tl">분류분류분류분류분2</td>
                <td class="tl">분류분류분류분류분류분류3</td>
                <td>이진영</td>
                <td>2021.10.05</td>
                <td><a class="link">500</a></td>
                <td><a class="link">400</a></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td class="tl"></td>
                <td class="tl"></td>
                <td class="tl"></td>
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