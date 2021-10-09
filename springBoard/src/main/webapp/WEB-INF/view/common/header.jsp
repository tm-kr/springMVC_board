<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header shadow">
		<div class="header2">
			<h3 style="float: left"><a href="${pageContext.request.contextPath}/index/1" style="color: white">Simple board</a></h3>
			<c:if test="${empty sessionScope.id }">
			<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='${pageContext.request.contextPath}/login'">로그인</button>
			</c:if>
			<c:if test="${not empty sessionScope.id }">
				<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='${pageContext.request.contextPath}/logout'">로그아웃</button>
			</c:if>
		</div>
	</div>
</body>
</html>