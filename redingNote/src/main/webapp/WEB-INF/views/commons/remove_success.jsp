<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("회원 탈퇴가 완료되었습니다.");
	window.close();
	window.opener.location.href="<%=request.getContextPath() %>/commons/login";
</script>