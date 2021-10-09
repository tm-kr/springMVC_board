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
		<div class="setting shadow-sm">
			<h3 class="mb-5">개인 정보 관리</h3>
		<table class="table">
			<tr>
			   	<th scope="row" ></th>
			    <td colspan="3" ></td>
		   	</tr>
			<tr>
			   	<th scope="row" class="table-active">아이디</th>
			    <td colspan="3" >${member.id }</td>
		   	</tr>
		   	<tr>
			   	<th scope="row" class="table-active">이름</th>
			    <td colspan="3" >${member.name }</td>
		   	</tr>
		   	<tr>
			   	<th scope="row" class="table-active">이메일</th>
			    <td colspan="3" >${member.email }</td>
		   	</tr>
		</table>
		<h4 class="mt-5 mb-5">비밀번호 변경</h4>
		<div style="width: 300px; margin: auto;">
			<form:form commandName="boardVO" method="POST">
				<input type="password" placeholder="현재 비밀번호 입력" class="form-control" name="oldPass"><br>
				<input type="password" placeholder="신규 비밀번호 입력" class="form-control" name="newPass"><br>
				<div class="d-grid gap-2">
				  <button class="btn btn-info" type="submit">변경하기</button>
				</div>
			</form:form>
		</div>
		</div>
	</div>
	<jsp:include page="common/footer.jsp" flush="false" />
	
</body>
</html>