<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.title {
	margin: 30px 0 20px 45px;
	font-size: 24px;
}
.btn {
	padding: 10px;
	background: lightgray;
	border: 0 solid;
	border-radius: 5px;
	display: inline-block;
	text-align: center;
}
.btn:hover {
	cursor: pointer;
	background: rgb(52, 152, 219);
	color: white;
}
#removeForm {
	text-align: center;
}
.pwd {
	padding: 10px;
	margin: 20px;
}
</style>
</head>
<body>
	<div class="title">탈퇴하시려면 현재 비밀번호를 입력해주세요</div>
	
	<form method="post" id="removeForm">
		<input type="password" name="pwd" class="pwd" id="pwd">
		<br>
		<div onclick="goPage('removeForm')" class="btn">비밀번호 확인</div>
	</form>
	

<script>
function goPage(form) {
	let newForm = document.getElementById(form);
	let value = document.getElementById("pwd").value;
	
	if (value == null || value == "undefined" || value == "") {
		alert("비밀번호를 입력해주세요");
	} else {
		newForm.submit();
	}
}

let input = document.getElementById("pwd");
input.removeEventListener()

<c:if test="${param.error eq 1}" >
	alert("비밀번호가 일치하지 않습니다.");
</c:if>
</script>
</body>
</html>