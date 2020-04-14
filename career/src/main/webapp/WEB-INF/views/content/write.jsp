<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<html>
<head>	
<title>Write</title>
<script>
	$(document).ready(function(){
		$("#save").click(function(){
			alert("test");
			oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
			$("#content").submit();
		});
	});
</script>
</head>
<body>
	<div class="div_input">
		<p3>프로젝트 등록</p3>
	</div>
	<form:form name="content" modelAttribute="Content" action="${pageContext.request.contextPath}/content/save.do" method="post">
		<div class="div_input">
			<label for="" class="label_input">프로젝트명</label>
			<form:input type="text" path="title" class="input_content" />
		</div>
		<div class="div_input">
			<label for="" class="label_input">사용언어</label>
			<form:select path="language" class="select1">
				<form:options items="${language}" itemLabel="codeDtlNm" itemValue="codeDtlCd"/>
			</form:select>
		</div>	
		<div class="div_input">
			<label for="" class="label_input">위치</label>
			<form:input type="text" path="location" class="input_content" />
		</div>				
		<div class="div_input1">
			<label for="" class="label_input1" height="1000">내용</label>
		</div>
		<div class="div_smartEditer">
			<textarea id="content" name="content" class="textarea1"></textarea>
			<script type="text/javascript">
				var oEditors = [];
				nhn.husky.EZCreator.createInIFrame({
					oAppRef: oEditors,
					elPlaceHolder: "content",
					sSkinURI: "${pageContext.request.contextPath}/resources/smartEditor/SmartEditor2Skin.html",
					htParams : {
						bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bSkipXssFilter : true,		// client-side xss filter 무시 여부 (true:사용하지 않음 / 그외:사용)
						//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
						fOnBeforeUnload : function(){
							alert("완료!");
						},
					}, //boolean
					fOnAppLoad : function(){
						//예제 코드
						oEditors.getById["content"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
					},
					fCreator: "createSEditor2"
				});
			</script>	
		</div>	
		<div class=div_input2>
			<button type="submit" id="save" class="btn_save">저장하기</button>
		</div>				
	</form:form>	
</body>
</html>