<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("비밀번호가 변경되었습니다.");
	window.close();
	window.opener.location.href="<%=request.getContextPath() %>/commons/profile";
</script>