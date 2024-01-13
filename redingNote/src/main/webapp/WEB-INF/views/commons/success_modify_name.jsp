<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("이름이 변경되었습니다.");
	location.href="<%=request.getContextPath() %>/commons/profile";
</script>