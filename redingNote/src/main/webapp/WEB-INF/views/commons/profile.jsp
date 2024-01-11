<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
.info_container {
	border: 1px solid gray;
	border-radius: 5px;
	width: 80vh;
}
.info_box {
	padding: 20px;
}
.btn {
	padding: 5px;
	background: lightgray;
	border: 0 solid;
	border-radius: 5px;
	display: inline-block;
	text-align: center;
}
.btn:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<h1>나의 프로필</h1>
	<div style="">
	<div class="info_container">
		<div class="info_box">
			<span>이름</span>
			<div style="text-align: right; display: inline-block">
				<span class="btn">이름 변경</span>
			</div>
		</div>
		<hr>
		<div class="info_box">
			<span>아이디 나오는 곳</span>
			<span class="btn">비밀번호 변경</span>
		</div>
		<hr>
		<div class="info_box">
			<span>이메일</span>
			<span class="btn">이메일 변경</span>
		</div>
		<hr>
		<div class="info_box">
			<span>010-1234-5678</span>
			<span class="btn">전화번호 변경</span>
		</div>
	</div>
	</div>	
</body>
</html>