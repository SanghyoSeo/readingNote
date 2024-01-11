<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원용 내정보</title>
</head>
<style>
body {
	margin: 0;
}
.container {
	display: flex;
	width: 100%;
	height: 100%;
}
.side_menu {
	background: rgb(52, 152, 219);
	float: left;
	width: 230px;
	height: 100vh;
}
.title {
	font-size: 36px;
	font-weight: bold;
	color: white;
	margin: 20px;
	margin-bottom: 100px;
}
.title:hover {
	cursor: pointer;
}
.menu {
	color: white;
	font-size: 20px;
	margin-left: 45px;
	margin-bottom: 30px;
}
.menu:hover {
	cursor: pointer;
}
.iframe_container {
	aspect-ratio: 16 / 9;
	width: 90%
}
iframe {
	display: block;
	width: 100%;
	height: 100%;
	border: 0;
}
</style>
<body>
	<div class="container">
		<!-- 옆 메뉴 -->
		<nav class="side_menu">
			<div id="logo"></div>
			<div class="title" onclick="">리딩노트</div>
			<div class="menu" onclick="location.href='profile'">나의 프로필</div>
			<div class="menu" onclick="">나의 리뷰</div>
			<div class="menu" onclick="changeIframeUrl('/commons/profile?id=${loginUser}')">회원 탈퇴</div>
		</nav>


</body>
</html>