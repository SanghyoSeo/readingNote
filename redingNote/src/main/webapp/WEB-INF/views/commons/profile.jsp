<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
.title {
	margin: 30px 0 70px 45px;
	font-size: 24px;
	font-weight: bold;
}
.info_container {
	border: 1px solid rgb(52, 152, 219);
	border-radius: 5px;
	width: 80vh;
	margin: 0 auto;
}
.info_box {
	padding: 20px;
	display: flex;
	justify-content: space-between;
	vertical-align: middle;
}
.info {
	padding: 10px;
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
hr {
	margin: 0;
}
#id {
	font-weight: bold;
}
input {
	padding: 10px;
	font-size: 16px;
}
.remove {
	
}
.remove:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="title">내정보</div>
	<div>
		<div class="info_container">
			<div class="info_box">
				<span class="info">
					<span id="id">아이디 :</span> 
					${loginUser.id}
				</span>
				<span class="btn">비밀번호 변경</span>
			</div>
			<hr>
			<form action="<%=request.getContextPath() %>/commons/modifyName" class="info_box" id="nameForm" method="post">
				<input name="id" value="${loginUser.id}" type="hidden">
				<input name="name" placeholder="이름: ${loginUser.name}" value="">
				<span class="btn" onclick="goPage('nameForm')" >이름 변경</span>
			</form>
			<hr>
			<form action="<%=request.getContextPath() %>/commons/modifyEmail" class="info_box" id="emailForm" method="post">
				<input name="id" value="${loginUser.id}" type="hidden">
				<input name="email" placeholder="이메일: ${loginUser.email}" value="">
				<span class="btn" onclick="goPage('emailForm')" >이메일 변경</span>
			</form>
			<hr>
			<div class="info_box">
				<span class="info">010-1234-5678</span>
				<span class="btn">전화번호 변경</span>
			</div>
		</div>
			<div class="remove">회원탈퇴 ></div>
	</div>	
<script>
function goPage(form) {
	let newForm = document.getElementById(form);
	
	newForm.submit();
}
</script>
</body>
</html>