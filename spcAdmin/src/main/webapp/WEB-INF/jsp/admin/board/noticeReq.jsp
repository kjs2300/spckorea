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


<body>

                <h1 class="h1-tit">ê³µì§ì¬í­</h1>


                <div class="search-wrap">
                    
                    <div class="search-cont">

                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="" name="" value="" checked>
                            <label for="">ì ì²´</label>
                        </div>
                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="" name="" value="">
                            <label for="">ì ëª©</label>
                        </div>
                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="" name="" value="">
                            <label for="">ìì±ìëª</label>
                        </div>
                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="" name="" value="">
                            <label for="">ë´ì©</label>
                        </div>
                    </div>

                    <div class="search-cont">

                        <div class="radio-cont">
                            <input type="radio" class="radio-box" id="dateAll" name="radioGroupDate" value="" checked>
                            <label for="dateAll">ì ì²´</label>
                        </div>
                          
                        <div class="radio-cont mr10">
                            <input type="radio" class="radio-box" id="dateTerm" name="radioGroupDate" value="">
                            <label for="dateTerm">ê¸°ê°ì í</label>
                        </div>
                        <div class="picker-wrap">
                            <input type="text" id="datepickerFrom" class="input-box"/>
                            <span class="next-ico">-</span>
                            <input type="text" id="datepickerTo" class="input-box"/>
                        </div>
                        
                        <button class="search-btn">ê²ì</button>
                        <button class="search-btn white-btn ml20">ì´ê¸°í</button>
                    </div>

                </div>
                
                <div class="btn-cont mb20">
                    <button class="mid-btn blue-btn" onclick="location.href = '/adBoard/noticeReq.do'; ">ë±ë¡</button>
                    <button class="mid-btn white-btn">ì íì­ì </button>
                </div>
                
                <div class="table-wrap">
                    <table class="list-tb">
                        <caption>ì í, ì¹´íê³ ë¦¬, ì ëª©, ì²¨ë¶íì¼, ìì±ì¼, ìì±ì, ì¡°íì, ê´ë¦¬ ì ë³´ê° ìë íì´ë¸</caption>
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
                                <th>ì¹´íê³ ë¦¬</th>
                                <th>ì ëª©</th>
                                <th>ì²¨ë¶íì¼</th>
                                <th>ìì±ì¼</th>
                                <th>ìì±ì</th>
                                <th>ì¡°íì</th>
                                <th colspan="2">ê´ë¦¬</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input type="checkbox" class="check-box"/></td>
                                <td>1</td>
                                <td>ê³µì§</td>
                                <td class="tl">2021ë ìëªì§í´ì´ ê°ì¬ ë³´ìêµì¡ ì¤ì ìë´</td>
                                <td><button class="sm-btn white-btn">ë¤ì´ë¡ë</button></td>
                                <td>2021.10.05</td>
                                <td>ê´ë¦¬ì</td>
                                <td>120</td>
                                <td><button class="sm-btn black-btn">ìì </button></td>
                                <td><button class="sm-btn white-btn">ì­ì </button></td>
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
