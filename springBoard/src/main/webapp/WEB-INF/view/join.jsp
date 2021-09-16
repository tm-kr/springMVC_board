<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="header shadow">
		<div class="header2">
			<h3 style="float: left"><a href="index" style="color: white">Simple board</a></h3>
			<c:if test="${empty sessionScope.id }">
			<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='login'">로그인</button>
			</c:if>
			<c:if test="${not empty sessionScope.id }">
				<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='logout'">로그아웃</button>
			</c:if>
		</div>
		
	</div>
	
	<div class="container">
		<div class="login ">
			<div class="mt-5 mb-5 border-bottom">
				<h2 class="mb-3"><b>Simple board</b></h2>
			</div>
			<form:form commandName="memberVO" method="POST">
				<div class="join">
					<label><b>아이디</b></label>
					<input type="text" class="form-control" name="id" ><br>
					<label><b>비밀번호</b></label>
					<input type="password" class="form-control" name="password"><br>
					<label><b>이름</b></label>
					<input type="text" class="form-control" name="name" ><br>
					<label><b>이메일</b></label>
					<input type="text" class="form-control mb-5" name="email" >
				</div>
				<div class=" d-grid gap-2 mb-3">
					<button type="submit" class="btn btn-primary mb-5">회원가입</button>
				</div>
			</form:form>
			<footer class="mt-3 mb-5">
				<br>Copyright &copy; 2021 TaeMin<br>All Rights Reserved.
			</footer>
		</div>
	</div>
	
	
</body>
</html>