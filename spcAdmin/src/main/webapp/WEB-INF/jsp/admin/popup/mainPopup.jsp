
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript" src="<c:url value='/resources/common/jquery.js'/>"></script>


<div id="wrap" class="sty02">   
    <div class="popWarp">
        <p class="popTit"><c:out value="${mainForm.popup_nm}"/><span class="popClose"><a href="" title="닫기" onclick="self.close();">닫기</a></span></p>
        <div class="popCont" style="padding: 10px;">
            <div class="NumDesc" style="height: <c:out value='${vo.POPUP_HG-100}' />px">
                
                <c:if test="${not empty mainForm.popup_cn}">
                    <div class="popContent">
                        <html:xss>
                            <c:out value="${mainForm.popup_cn}" escapeXml="false" />
                        </html:xss>
                    </div>
                </c:if>
            </div>
        
            <div class="AR MgT5"><input type="checkbox" onclick="gfnCloseWin('pop<c:out value="${mainForm.popup_no}" />')" id="pop" style="vertical-align: middle;" /> <label for="pop" class="labelPop">오늘하루 보이지 않기&nbsp;</label></div>
        </div>
    </div>
</div>

