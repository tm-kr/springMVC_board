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
			<h3 style="float: left"><a href="${pageContext.request.contextPath}/index/1" style="color: white">Simple board</a></h3>
			<c:if test="${empty sessionScope.id }">
			<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='${pageContext.request.contextPath}/login'">로그인</button>
			</c:if>
			<c:if test="${not empty sessionScope.id }">
				<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='${pageContext.request.contextPath}/logout'">로그아웃</button>
			</c:if>
		</div>
	</div>

	<div class="container">
		<div class="setting shadow-sm">
			<h3 class="mb-5">개인 정보 관리</h3>
		<table class="table">
			<tr>
			   	<th scope="row" ></th>
			    <td colspan="3" ></td>
		   	</tr>
			<tr>
			   	<th scope="row" class="table-active">아이디</th>
			    <td colspan="3" >svs1014</td>
		   	</tr>
		   	<tr>
			   	<th scope="row" class="table-active">이름</th>
			    <td colspan="3" >김태민</td>
		   	</tr>
		   	<tr>
			   	<th scope="row" class="table-active">이메일</th>
			    <td colspan="3" >svs1014@naver.com</td>
		   	</tr>
		</table>
		<h4 class="mt-5 mb-5">비밀번호 변경</h4>
		<div style="width: 300px; margin: auto;">
			<form:form commandName="boardVO" method="POST">
				<input type="password" class="form-control" name="password"><br>
				<input type="password" class="form-control" name="password"><br>
				<div class="d-grid gap-2">
				  <button class="btn btn-info" type="submit">변경하기</button>
				</div>
			</form:form>
		</div>
		</div>
		

		
		<footer class="mt-5 mb-5">
			<br>Copyright &copy; 2021 김태민 All Rights Reserved.<br>
			이 사이트는 그 어떠한 상업적 목적도 없습니다.
		</footer>
	</div>
	
</body>
</html>