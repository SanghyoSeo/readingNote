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
	margin: 30px 0 10px 40px;
	font-size: 24px;
}
.btn {
	padding: 10px;
	background: rgb(231, 76, 60);
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
#removeForm {
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
	<div class="title">회원 탈퇴</div>
	<div style="margin: 0 0 40px 40px">탈퇴하시려면 아이디와 비밀번호를 입력해주세요</div>
	
	<form method="post" id="removeForm">
		<div class="textWrapper">
			<div class="text">아이디</div>
		</div>
		<input type="text" name="id" class="account" id="id">
		<br>
		<div class="textWrapper">
			<span class="text">비밀번호</span>
		</div>
		<input type="password" name="pwd" class="account" id="pwd">
		<br>
		<div onclick="goPage('removeForm')" class="btn">회원 탈퇴</div>
		<div onclick="javascript:CloseWindow()" class="close">취소</div>
	</form>
	

<script>
function goPage(form) {
	let newForm = document.getElementById(form);
	let value = document.getElementById("pwd").value;
	
	if (value == null || value == "undefined" || value == "") {
		alert("아이디와 비밀번호를 입력해주세요");
	} else {
		let con = confirm("정말 탈퇴하시겠습니까?");
		
		if (con) {
			newForm.submit();
		}
	}
}


<c:if test="${param.error eq 1}" >
	alert("아이디가 일치하지 않습니다.");
</c:if>
<c:if test="${param.error eq 2}" >
	alert("비밀번호가 일치하지 않습니다.");
</c:if>
</script>
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>
</body>
</html>