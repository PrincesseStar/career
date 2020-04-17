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
		
		$("#telno").change(function(){
		    var currentVal = $(this).val();
		    $.ajax({
		    	url : "${pageContext.request.contextPath}/person/check.do",
		    	type : "get",
		    	dataType : "text",
		    	data : "telno="+$(this).val(),
		    	success : function(result) {
		    		alert("Success");
		    	},
		    	error : function() {
		    		alert();	
		    	}	
		    });
		});
		
	});
</script>
</head>
<body>
	<div class="div_input">
		<p3>[개발자 등록]</p3>
	</div>
	<form:form name="person" modelAttribute="person" action="${pageContext.request.contextPath}/person/save.do" method="post">
		<div class="div_input">
			<label for="" class="label_input">기술1</label>
			<form:select path="skill1" class="select1">
				<form:options items="${skill}" itemLabel="skillName" itemValue="skillName"/>
			</form:select>
			<label for="" class="label_input">기술2</label>
			<form:select path="skill2" class="select1">
				<form:options items="${skill}" itemLabel="skillName" itemValue="skillName"/>
			</form:select>	
			<label for="" class="label_input">기술3</label>
			<form:select path="skill3" class="select1">
				<form:options items="${skill}" itemLabel="skillName" itemValue="skillName"/>
			</form:select>							
		</div>
		<div class="div_input">
			<label for="" class="label_input">성명</label>
			<form:input type="text" path="name" class="select1" />
			<label for="" class="label_input">전화번호</label>
			<form:input type="text" id="telno" path="telno" class="select1"/>	
			<label for="" class="label_input">이메일</label>
			<form:input type="text" path="email" class="select1" />						
		</div>	
		<div class="div_input">
			<label for="" class="label_input">생년</label>
			<form:input type="text" path="birth" class="select2" />
			<p5>년생 4자리로 입력&nbsp&nbsp&nbsp</p5>
			<label for="" class="label_input">처음상태</label>
			<form:select path="firstStatus" class="select1">
				<form:options items="${firstStatus}" itemLabel="firstStatus" itemValue="firstStatus"/>
			</form:select>
			<label for="" class="label_input">현상태</label>
			<form:select path="nowStatus" class="select1">
				<form:options items="${nowStatus}" itemLabel="nowStatus" itemValue="nowStatus"/>
			</form:select>					
		</div>	
		<div class="div_input">
			<label for="" class="label_input">영업관리</label>
			<form:select path="business" class="select1">
				<form:options items="${businessStatus}" itemLabel="businessStatus" itemValue="businessStatus"/>
			</form:select>
			<label for="" class="label_input">중요도</label>
			<form:select path="import1" class="select1">
				<form:options items="${importStatus}" itemLabel="importStatus" itemValue="importStatus"/>
			</form:select>
			<label for="" class="label_input">등급</label>
			<form:input type="text" path="grade" class="select1" />						
		</div>	
		<div class="div_input">
			<label for="" class="label_input">종료예정일</label>
			<form:input type="text" path="finishDate" class="select1" />
			<label for="" class="label_input">프로젝트</label>
			<form:input type="text" path="project" class="select3" />							
		</div>			
		<div class="div_input">
			<label for="" class="label_input">대지역</label>
			<form:input type="text" path="area1" class="select1" />
			<label for="" class="label_input">소지역</label>
			<form:input type="text" path="area2" class="select1" />	
			<label for="" class="label_input">자격증</label>
			<form:select path="license" class="select1">
				<form:options items="${licenseStatus}" itemLabel="licenseStatus" itemValue="licenseStatus"/>
			</form:select>					
		</div>							
		<div class="div_input1">
			<label for="" class="label_input1" height="1000">메모</label>
		</div>
		<div class="div_smartEditer">
			<textarea id="memo" name="memo" class="textarea1"></textarea>
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