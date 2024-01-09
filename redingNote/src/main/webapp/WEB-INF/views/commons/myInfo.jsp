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
	background: rgb(211, 84, 0);
	float: left;
	width: 230px;
	height: 1000px;
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

</style>
<body>
	<div class="container">
		<!-- 옆 메뉴 -->
		<nav class="side_menu">
			<div id="logo"></div>
			<div class="title" onclick="">리딩노트</div>
			<div class="menu" onclick="location.href='profile'">나의 프로필</div>
			<div class="menu" onclick="">나의 리뷰</div>
			<div class="menu" onclick="location.href='remove'">회원 탈퇴</div>
		</nav>

		<!-- 정보 표시 -->
		<section>
			
		</section>
	</div>
</body>
</html>