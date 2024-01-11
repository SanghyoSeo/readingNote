<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리딩노트 로그인</title>
<style>
#title {
	text-align: center;
	margin-top: 80px;
	font-size: 36px;
	font-weight: bold;
}

#loginbox {
	border: 1px solid gray;
	border-radius: 5px;
	width: 400px;
	height: 240px;
	margin: 40px;
	display: inline-block;
}
#login {
	text-align: center;
	margin: 40px;
}
#id, #pwd {
	padding: 10px;
	margin-bottom: 20px;
	width: 280px;
}
#login_btn {
	width: 310px;
	height: 40px;
	background: rgb(52, 152, 219);
	color: white;
	font-size: 16px;
	border: 0 solid;
	border-radius: 5px;
}
#login_btn:hover {
	cursor: pointer;
	background: rgb(41, 128, 185);
}
.bottom_btn {
	margin-right: 10px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div id="title">리딩노트</div>

	<div style="text-align: center;">
	<div id="loginbox">
		<form method="post" id="login">
			<input type="text" name="id" id="id" placeholder="아이디"><br> 
			<input type="password" name="pwd" id="pwd" id="id" placeholder="패스워드"><br> 
			<input type="submit" value="로그인" id="login_btn">
		</form>
	</div>
	</div>
	<div style="text-align: center;">
		<span class="bottom_btn" onclick="">비밀번호 찾기</span>
		<span class="bottom_btn">|</span>
		<span class="bottom_btn" onclick="">아이디 찾기</span>
		<span class="bottom_btn">|</span>
		<span class="bottom_btn" onclick="">회원가입</span>
	</div>

<script>
	<c:if test="${param.error eq 1}">
	alert("아이디가 일치하지 않습니다.");
	</c:if>
	<c:if test="${param.error eq 2}">
	alert("패스워드가 일치하지 않습니다.");
	</c:if>
</script>
</body>
</html>