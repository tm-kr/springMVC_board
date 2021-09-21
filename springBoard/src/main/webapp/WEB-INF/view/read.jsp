<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h3 style="float: left"><a href="/index" style="color: white">Simple board</a></h3>
			<c:if test="${empty sessionScope.id }">
			<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='login'">로그인</button>
			</c:if>
			<c:if test="${not empty sessionScope.id }">
				<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='logout'">로그아웃</button>
			</c:if>
		</div>
		
	</div>
	
	<div class="container">
		<div class="content2">
		
			<div class="contentL">
				<div class="content-read shadow-sm">
					<div class="content-header">
						<h3 >${boardVO.title }</h3>
						<h6 class="ul-title">${boardVO.regdate } &nbsp;|&nbsp;  ${boardVO.writer }  &nbsp;|&nbsp;  조회 ${boardVO.views}</h6>
					</div>
					
					<div class="content-mid">
						${boardVO.content }
					</div>
					<div class="content-bottom">
						<button type="button" class="btn btn-info" onclick="location.href='index'" >목록</button>
					</div>
				</div>
			</div>
		
			<div class="profile shadow-sm">
				 <c:if test="${empty sessionScope.id }">
					 <div class="d-grid gap-2 profile-top">
						   <button class="btn btn-info" type="button" onclick="location.href='login'">로그인</button>
						   <button class="btn btn-info" type="button" onclick="location.href='join'">회원가입</button>
					 </div>
				 </c:if>
				 <c:if test="${not empty sessionScope.id }">
				 	<div class="profile-top">
				 		<h6 class="ul-title id-title">${id}님 환영합니다!</h6>
				 		<button class="btn btn-info" type="button" onclick="location.href='write'">글쓰기</button>
				 		<button class="btn btn-outline-info" type="button" onclick="location.href='login'">내가 쓴 글</button>
				 		<button class="btn btn-outline-info" type="button" onclick="location.href='login'">내정보</button>
					</div>
				</c:if>
				 <div class="profile-mid">
				 	<h6 class="ul-title">홈</h6>
				 	<h5>전체</h5>
				 </div>
				 <div class="profile-mid">
				 	<h6 class="ul-title">정보</h6>
				 	<h5>공지사항</h5>
				 	<h5>긴급 뉴스</h5>
				 </div>
				 <div class="profile-bottom">
				 	<h6 class="ul-title">커뮤니티</h6>
				 	<h5>자유</h5>
				 	<h5>유머</h5>
				 	<h5>팬아트</h5>
				 </div>
			</div>
			
		</div>
		
		<footer class="mt-3 mb-5">
			<br>Copyright &copy; 2021 김태민 All Rights Reserved.<br>
			이 사이트는 그 어떠한 상업적 목적도 없습니다.
		</footer>
	</div>
	
	
</body>
</html>