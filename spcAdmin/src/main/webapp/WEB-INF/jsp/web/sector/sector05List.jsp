
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
		 $('#category1_key').change(function(){
			var val  = $(this).val();

			if( val ==""){
				return;
			}
			
			$("#category2_key").val("");
 			$("#category3_key").val("");
			
			 $.ajax({	
			    url     : "<c:url value='/user/category2list.do'/>",
			    data    : $("#commonForm").serialize(),
		        dataType: "JSON",
		        cache   : false,
				async   : true,
				type	: "POST",	
				success: function(data, opt, inx){
				var option = '';
				option += '<option value="">선택 하세요</opton>'; //선택
				$.each(data, function(i, ret){
					option += '<option value="'+ret.CATEGORY2_KEY+'">'+ret.CATEGORY2_NAME+'</option>';		
				});
				$('select[name=category2_key]').html(option);						
	        },	       
		        error 	: function(xhr, status, error) {}
		        
		     });
		 });
				 
		$('#category2_key').change(function(){
			var val  = $(this).val();

			if( val ==""){
				return;
			}
			
			$("#category3_key").val("");
					
			 $.ajax({	
			    url     : "<c:url value='/user/category3list.do'/>",
			    data    : $("#commonForm").serialize(),
		        dataType: "JSON",
		        cache   : false,
				async   : true,
				type	: "POST",	
				success: function(data, opt, inx){
				var option = '';
				option += '<option value="0">선택 하세요</opton>'; //선택
				$.each(data, function(i, ret){
					option += '<option value="'+ret.CATEGORY3_KEY+'">'+ret.CATEGORY3_NAME+'</option>';		
				});
				$('select[name=category3_key]').html(option);						
		        },	       
		        error 	: function(xhr, status, error) {}
		        
		     });
		 }); 
 });
</script>

     <!-- container  begin -->
                <div id="container">

                    <div class="tit-wrap">
                        <h1 class="h1-tit">교육신청</h1>

                        <div class="side-cont">
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_home.png" alt="홈 바로가기"/>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>분야별 교육신청</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>자살사후대응 전문가 양성교육</span>
                            <img src="${pageContext.request.contextPath}/user/images/common/ico_next.png" alt="다음 아이콘"/>
                            <span>교육신청</span>
                        </div>
                    </div>

                    <div class="contents-wrap">

                        <!---- search-wrap begin ---->
                        <div class="search-wrap">
                            <div class="search-cont">
                                <label>분류 :</label>
                                <select class="select mr30"  id="category1_key" name="category1_key">
			                        <option value=''>선택 하세요</option>
			                    	<c:forEach var="result" items="${category1list}" varStatus="status">
			                    		<option value='${result.CATEGORY1_KEY}' <c:if test="${category1_key == result.CATEGORY1_KEY}">selected</c:if>>${result.CATEGORY1_NAME}</option>
			                        </c:forEach>
			                    </select>
                                <select class="select"  id="category2_key" name="category2_key">
                                </select>
                                <select class="select lg-width"  id="category3_key" name="category3_key">
                                </select>
                                <select class="select" id="site" name="site">
                                    <option value="">전체</option>
                                    <option value="on">온라인</option>
                                    <option value="off">오프라인</option>
                                </select>
                            </div>
                            
                            <div class="btn-cont">
                                <button class="lg-btn orange-btn">검색</button>
                                <button class="lg-btn navy-btn">초기화</button>
                            </div>
                        </div>
                        <!---- search-wrap end ---->

                        <!---- sub-cont begin ---->
                        <div class="tit-cont">
                            <p class="total">전체 : <span>100</span>건</p>
                            <select class="select">
                                <option>교육기간순</option>
                                <option>교육등록순</option>
                            </select>
                        </div>
                        <!---- sub-cont end ---->

                        <div class="list-wrap">
                            <ul>
                                <li>
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
                                </li>
                                <li>
                                    <span class="badge-org">기관</span>
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
                                </li>
                                <li>
                                    <span class="badge-instruct">강사</span>
                                    <span class="tag">분류2</span>
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
                                </li>
                                <li>
                                    <span class="badge-worker">실무자</span>
                                    <span class="tag">분류2</span>
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
                                </li>
                            </ul>
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