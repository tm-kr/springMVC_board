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
			<div class="profile shadow-sm">
				<c:if test="${empty sessionScope.id }">
					 <div class="d-grid gap-2 profile-top">
						   <button class="btn btn-info" type="button" onclick="location.href='/login'">로그인</button>
						   <button class="btn btn-info" type="button" onclick="location.href='/join'">회원가입</button>
					 </div>
				 </c:if>
				 <c:if test="${not empty sessionScope.id }">
				 	<div class="profile-top">
				 		<h6 class="ul-title id-title">${id}님 환영합니다!</h6>
				 		<button class="btn btn-info" type="button" onclick="location.href='/write'">글쓰기</button>
				 		<button class="btn btn-outline-info" type="button" onclick="location.href='/myPost'">내가 쓴 글</button>
				 		<button class="btn btn-outline-info" type="button" onclick="location.href='/setting'">내정보</button>
					</div>
				</c:if>
				 <div class="profile-mid">
				 	<h6 class="ul-title">홈</h6>
				 	<h5><a style="color: black" href="/index">전체</a></h5>
				 </div>
				 <div class="profile-mid">
				 	<h6 class="ul-title">정보</h6>
				 	<h5><a style="color: black" href="/notice">공지사항</a></h5>
				 	<h5><a style="color: black" href="/news">긴급 뉴스</a></h5>
				 </div>
				 <div class="profile-bottom">
				 	<h6 class="ul-title">커뮤니티</h6>
				 	<h5><a style="color: black" href="/free">자유</a></h5>
				 	<h5><a style="color: black" href="/humor">유머</a></h5>
				 	<h5 style="text-decoration: line-through;">팬 아트</h5>
				 </div>
				 
				 <div class="">
				 	<img alt="" src="/resources/img/advertisement.png" style="margin-top: 8%;" >
				 </div>
			</div>
</body>
</html>