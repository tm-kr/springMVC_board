<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='login'">로그인</button>
		</div>
		
	</div>
	
	<div class="container">
		<div class="login ">
			<div class="mt-5 mb-5 border-bottom">
				<h2 class="mb-3"><b>Simple board</b></h2>
			</div>
			<form method="post" action="${pageContext.request.contextPath}/login">
				<input type="text" class="form-control" placeholder="아이디" name="id" ><br>
				<input type="password" class="form-control mb-5" placeholder="비밀번호" name="pass">
				<div class=" mb-3">
					<button type="submit" class="btn btn-primary mb-3" onclick="location.href='${pageContext.request.contextPath}/login'">로그인</button>
				</div>
			</form>
			<h6>아이디가 없으신가요? <a href="join">회원가입하기</a></h6>
		</div>
	</div>
	
	
</body>
</html>