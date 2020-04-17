<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<html>
<head>	
<title>Write</title>
<script>
	$(document).ready(function(){
		$("#save").click(function(){
			oEditors.getById["memo"].exec("UPDATE_CONTENTS_FIELD", []);
			$("#memo").submit();
		});
	});
</script>
</head>
<body>
	<div class="div_input">
		<p3>[임시저장]</p3>
	</div>
	<form:form name="temp" modelAttribute="temp" action="${pageContext.request.contextPath}/temp/save.do" method="post">
		<div class="div_input">
			<label for="" class="label_input">구분</label>
			<form:select path="gubun" class="select1">
				<form:options items="${gubun}" itemLabel="codeDtlNm" itemValue="codeDtlCd"/>
			</form:select>
		</div>				
		<div class="div_input1">
			<label for="" class="label_input1" height="1000">내용</label>
		</div>
		<div class="div_smartEditer">
			<form:textarea path="memo" id="memo" name="memo" class="textarea1"></form:textarea>
			<script type="text/javascript">
				var oEditors = [];
				nhn.husky.EZCreator.createInIFrame({
					oAppRef: oEditors,
					elPlaceHolder: "memo",
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
						oEditors.getById["memo"].exec("PASTE_HTML", [""]);
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