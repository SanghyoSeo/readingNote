<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"></style>
<style>
.title {
	margin: 30px 0 10px 40px;
	font-size: 24px;
}
.btn {
	padding: 10px;
	background: rgb(52, 152, 219);
	color: white;
	border: 0 solid;
	border-radius: 5px;
	display: inline-block;
	text-align: center;
}
.btn:hover {
	cursor: pointer;
}
.close {
	padding: 10px;
	background: lightgray;
	border: 0 solid;
	border-radius: 5px;
	display: inline-block;
	text-align: center;
}
.close:hover {
	cursor: pointer;
}
#searchForm {
	text-align: center;
}
.account {
	padding: 10px;
	margin-bottom: 20px;
}
.textWrapper {
	font-size: 20px;
	margin-bottom: 5px;
}
.text {
	display: inline-block;
	width: 191px;
	margin: 0 auto;
	text-align: left;
}
</style>
</head>
<body>
	<div class="title">비밀번호 찾기</div>
	<div style="margin: 0 0 40px 40px">아이디, 이름, 이메일을 입력해주세요</div>
	
	<form method="post" id="searchForm">
		<div class="textWrapper">
			<span class="text">아이디</span>
		</div>
		<input type="text" name="id" class="account" id="id">
		<br>
		<div class="textWrapper">
			<span class="text">이름</span>
		</div>
		<input type="text" name="name" class="account" id="name">
		<br>
		<div class="textWrapper">
			<span class="text">이메일</span>
		</div>
		<input type="text" name="email" class="account" id="email">
		<br>
		<div onclick="goPage('searchForm')" class="btn">비밀번호 찾기</div>
		<div onclick="javascript:CloseWindow()" class="close">취소</div>
	</form>

<script>
function goPage(form) {
	let newForm = document.getElementById(form);
	let idValue = document.getElementById("id").value;
	let nameValue = document.getElementById("name").value;
	let emailValue = document.getElementById("email").value;
	
	if (idValue == null || idValue == "undefined" || idValue == "") {
		alert("아이디를 입력해주세요");
		return;
	}
	if (nameValue == null || nameValue == "undefined" || nameValue == "") {
		alert("이름을 입력해주세요");
		return;
	}
	if (emailValue == null || emailValue == "undefined" || emailValue == "") {
		alert("이메일을 입력해주세요");
		return;
	}
	
	newForm.submit();			
	
}

<c:if test="${param.error eq 1}" >
	alert("계정이 존재하지 않습니다.");
</c:if>
<c:if test="${param.success eq 1}" >
	alert("비밀번호는 " + "${param.searchPwd}" + " 입니다.");
</c:if>
</script>
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>
</body>
</html>