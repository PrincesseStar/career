<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<html>
<head>
<script type="text/javascript">
$(function(){
    //전역변수선언
    var editor_object = [];
     
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: editor_object,
        elPlaceHolder: "content",
        sSkinURI: "${pageContext.request.contextPath}/resources/smartEditor/SmartEditor2Skin.html",
        htParams : {
            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,            
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : true,    
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true,
        }
    });
     
    //전송버튼 클릭이벤트
    $("#savebutton").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        editor_object.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
         
        // 이부분에 에디터 validation 검증
        //폼 submit
        $("#frm").submit();

    })
})

</script>
<title>Write</title>
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
			<!--<label for="" class="label_input1" height="1000">내용</label>-->
			<textarea name="content" id="content" class="textarea1"/>
		</div>
		<div class=div_input2>
			<!--<button type="submit" id="save" class="btn_save">저장하기</button>-->
		</div>			
	</form:form>
</body>
</html>