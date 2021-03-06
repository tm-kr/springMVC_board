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
<link rel="stylesheet" href="resources/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="common/header.jsp" flush="false" />

	<div class="container">
		<div class="login ">
			<div class="mt-5 mb-5 border-bottom">
				<h2 class="mb-3"><b>Simple board</b></h2>
			</div>
			<form:form commandName="LoginCommand" method="POST">
				<input type="text" class="form-control" placeholder="아이디" name="id" ><br>
				<input type="password" class="form-control mb-5" placeholder="비밀번호" name="password">
				<div class=" mb-3">
					<button type="submit" class="btn btn-primary mb-3" >로그인</button>
				</div>
			</form:form>
			<h6>아이디가 없으신가요? <a href="join">회원가입하기</a></h6>
		</div>
	</div>
</body>
</html>