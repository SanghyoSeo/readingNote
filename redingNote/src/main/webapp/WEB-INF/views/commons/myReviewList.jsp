<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tr>
			<th>아이디</th>
			<th>도서 제목</th>
			<th>리뷰내용</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${reviewList}" var="review">
			<tr>
				<td>${review.id}</td>
				<td>${review.title}</td>
				<td>${review.contents}</td>
				<td>
					<fmt:formatDate value="${review.review_date}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>