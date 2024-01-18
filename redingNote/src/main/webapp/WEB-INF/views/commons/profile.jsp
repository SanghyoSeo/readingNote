<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
.title {
	margin: 30px 45px 70px 45px;
	font-size: 24px;
	display: flex;
	justify-content: space-between;
}
.info_container {
	border: 1px solid rgb(52, 152, 219);
	border-radius: 10px;
	width: 80vh;
	margin: 0 auto;
	padding: 10px 20px 10px 20px;
}
.info_box {
	display: flex;
	justify-content: space-between;
	vertical-align: middle;
	margin-bottom: 15px
}
.info {
	font-size: 20px;
	margin-top: 10px;
	margin-bottom: 5px;
}
.btn {
	padding: 10px;
	background: rgb(52, 152, 219);
	border: 0 solid;
	border-radius: 5px;
	display: inline-block;
	text-align: center;
	color: white;
}
.btn:hover {
	cursor: pointer;
}
input {
	padding: 10px;
	font-size: 16px;
}
.remove {
	text-decoration: none;
	color: black;
}
.remove:hover {
	cursor: pointer;
}
#remove_wrapper {
	width: 84vh;
	margin: 0 auto;
	margin-top: 5px;
}
hr {
    background: lightgray;
    height: 1px;
    border: 0;
}
#logout {
	font-size: 18px;
}
#logout:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="title">
		<span>내정보</span>
		<span onclick="location.href='<%=request.getContextPath() %>/commons/logout'" id="logout">
			로그아웃
		</span>
	</div>
	<div>
		<div class="info_container">
			<div class="info">아이디</div>
			<div class="info_box">
				<span style="font-size: 20px; padding: 5px;">${loginUser.id}</span> 
				<span class="btn" onclick="javascript:OpenWindow('checkPwd', '비밀번호 변경', 600, 500)">
					비밀번호 변경
				</span>
			</div>
			<hr>
			<div class="info">이름</div>
			<form action="<%=request.getContextPath() %>/commons/modifyName" class="info_box" 
				  id="nameForm" method="post" onsubmit="return false">
				<input name="id" value="${loginUser.id}" type="hidden">
				<input name="name" placeholder="${loginUser.name}" value="" onsubmit="return false">
				<span class="btn" onclick="goPage('nameForm', 'name')" >이름 변경</span>
			</form>
			<hr>
			<div class="info">이메일</div>
			<form action="<%=request.getContextPath() %>/commons/modifyEmail" class="info_box" 
				  id="emailForm" method="post" onsubmit="return false">
				<input name="id" value="${loginUser.id}" type="hidden">
				<input name="email" placeholder="${loginUser.email}" value="">
				<span class="btn" onclick="goPage('emailForm', 'email')" >이메일 변경</span>
			</form>
		</div>
		<div id="remove_wrapper">
			<a href="javascript:OpenWindow('remove', '회원탈퇴', 600, 500)" class="remove">회원탈퇴 ></a>
		</div>
	</div>
	<div onclick="javascript:OpenWindow('myReviewList', '내 리뷰 목록', 600, 500)">내 리뷰 목록</div>
	
	
<script>
function goPage(form, name) {
	let newForm = document.getElementById(form);
	let value = document.getElementsByName(name)[0].value;
	
	if (value == null || value == "undefined" || value == "") {
		alert("내용을 입력해주세요");
	} else {
		newForm.submit();
	}
}
</script>
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>
</body>
</html>