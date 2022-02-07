<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--  container begin -->
        <article id="container">

            <!--  contents begin -->
            <section class="contents-wrap">
                <h1 class="h1-tit">공지사항 등록</h1>


                <div class="table-wrap">
                    <table class="detail-tb">
                        <caption>제목, 작성자, 패스워드, 내용, 첨부파일 정보가 있는 테이블</caption>
                        <colgroup>
                            <col width="20%"/>
                            <col width="30%"/>
                            <col width="20%"/>
                            <col width="*"/>
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>제목</th>
                                <td colspan="3">
                                    <input type="text" class="input-box w768" value=""/>
                                </td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td><input type="text" class="input-box" value=""/></td>
                                <th>패스워드</th>
                                <td><input type="text" class="input-box" value=""/></td>
                            </tr>
                            <tr>
                                <th>내용</th>
                                <td colspan="3">
                                    <div class="editor-box"><textarea name="contents" id="contents" rows="10" cols="100" style="width: 100%; height: 553px; border: 1px solid #ddd; display: none;"></textarea></div>
                                </td>
                            </tr>
                            <tr>
                                <th>첨부파일</th>
                                <td colspan="3">
                                    <div class="upload-box">
                                        <input type="file" />
                                    </div>
                                    <div class="upload-box">
                                        <input type="file" />
                                    </div>
                                    <div class="upload-box">
                                        <input type="file" />
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="btn-cont">
                    <button class="mid-btn blue-btn">저장</button>
                    <button class="mid-btn white-btn">취소</button>
                    <button class="mid-btn black-btn">목록</button>
                </div>
            </section>
            <!--  contents end -->

        </article>
<script type="text/javascript">

var oEditors = [];

var sLang = "ko_KR"; // 언어 (ko_KR/ en_US/ ja_JP/ zh_CN/ zh_TW), default = ko_KR

// 추가 글꼴 목록
//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

nhn.husky.EZCreator.createInIFrame({
	oAppRef : oEditors,
	elPlaceHolder : "contents",
	sSkinURI : "/js/SE2/SmartEditor2Skin.html",
	htParams : {
		bUseToolbar : true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : false, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : true, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		//bSkipXssFilter : true,		// client-side xss filter 무시 여부 (true:사용하지 않음 / 그외:사용)
		//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
		fOnBeforeUnload : function() {
			//alert("완료!");
		},
		I18N_LOCALE : sLang
	}, //boolean
	fOnAppLoad : function() {
		//예제 코드
		//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
		$('iframe').contents().find('.se2_multy').show();
		$('iframe').contents().find('.se2_multy').on("click", function(event) {
			editImgUpLoad();
		});
	},
	fCreator : "createSEditor2"
});
</script>