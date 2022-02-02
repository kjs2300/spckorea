
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <script type="text/javaScript" language="javascript" defer="defer">
     <!--
    
     function fn_load(str) {
    	var frm = document.commonForm;
     	frm.action = "<c:url value='/edu/eduInfoClassCate.do'/>";
    	frm.submit();
     }
     //-->
 </script>
			   <form  id="commonForm" name="commonForm"  method="post"  action="">
					<input type="hidden" id="gubun1"         name="gubun1"   value='I'                      class="input-box" />
 				    <input type="hidden" id="gubun2"         name="gubun2"   value='category4'              class="input-box" />		
 				    <input type="hidden" id="divsion"        name="division" value="${categoryVo.division}" class="input-box"/>
	           </form>
 
                 <h1 class="h1-tit">교육분류 등록</h1>

                <div class="tab-cont">
                    <ul>
                        <li class="on"><a href="">온라인 교육</a></li>
                        <li><a href="">오프라인 교육</a></li>
                    </ul>
                </div>

                <div class="sub-cont">
                    <button class="mid-btn black-btn">전체분류 보기</button>
                     <button class="mid-btn blue-btn" onClick="fn_load('1');">등록</button>
                </div>
                
                <div class="table-wrap">
                    <table class="list-tb">
                        <caption>분류1, 분류2, 분류3, 관리 정보가 있는 테이블</caption>
                        <colgroup>
                            <col width="30%"/>
                            <col width="30%"/>
                            <col width="30%"/>
                            <col width="*"/>
                        </colgroup>
                        <thead>
                            <tr>
                                <th>분류1</th>
                                <th>분류2</th>
                                <th>분류3</th>
                                <th>관리</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>일반</td>
                                <td>온라인생명 지킴이 교육</td>
                                <td>보고듣고말하기2.0 기본형(120분)</td>
                                <td><button class="sm-btn blue-btn">수정</button></td>
                            </tr>

                        </tbody>
                    </table>
                </div>
                <div class="page-wrap">
             	 <ul class="paging">
	    			<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
	  	  		 </ul>
	            </div>
           