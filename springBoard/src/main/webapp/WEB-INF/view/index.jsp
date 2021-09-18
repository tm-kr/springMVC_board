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
		<div class="content ">
			<div class="contentL">
				<div class="search shadow-sm">
					<div class="search-top">
						<h2 style="float: left">전체</h2>
						<c:if test="${not empty sessionScope.id }">
						<div style="float: right"><a href="write"><img alt="" src="${pageContext.request.contextPath}/resources/img/write.jpg"></a></div>
						</c:if>
					</div>
					<br><br>
					<div>
						<div class="search-cate" style="float: left">최신순  인기순</div>  
						<form class="d-flex" style="float: right">
					      <input class="form-control me-2" type="search" placeholder="검색할 내용" aria-label="Search">
					      <button class="btn btn-secondary" type="submit">search</button>
						</form>
					</div>
					  
					
				</div>
				<div class="list shadow-sm">
				
					<a href="#">
					<div class="list-card ">
							<div class="card">
								  <div class="card-header">
								    김태민<div style="float: right">조회수 31</div>
								  </div>
								  <div class="card-body list-group-item list-group-item-action">
								    <h5 class="card-title">게시글 제목이 들어오는 곳</h5>
								    <p class="card-text ul-title">작성일: 2021-08-13 </p>
								  </div>
							</div>
					</div>
					</a>
					
					<a href="#">
					<div class="list-card">
						<div class="card">
							  <div class="card-header">
							    김태민<div style="float: right">조회수 313</div>
							  </div>
							  <div class="card-body list-group-item list-group-item-action">
							    <h5 class="card-title">제목 뭐로하지?</h5>
							    <p class="card-text ul-title">작성일: 2021-08-13 </p>
							  </div>
						</div>
					</div>
					</a>
					<a href="#">
					<div class="list-card">
						<div class="card">
							  <div class="card-header">
							    김태민<div style="float: right">조회수 12</div>
							  </div>
							  <div class="card-body list-group-item list-group-item-action">
							    <h5 class="card-title">게시글 제목</h5>
							    <p class="card-text ul-title">작성일: 2021-08-13 </p>
							  </div>
						</div>
					</div>
					</a>
					<a href="#">
					<div class="list-card">
						<div class="card">
							  <div class="card-header">
							    김태민<div style="float: right">조회수 22</div>
							  </div>
							  <div class="card-body list-group-item list-group-item-action">
							    <h5 class="card-title">게시판 만들기!</h5>
							    <p class="card-text ul-title">작성일: 2021-08-13 </p>
							  </div>
						</div>
					</div>
					</a>
					<a href="#">
					<div class="list-card">
						<div class="card">
							  <div class="card-header">
							    김태민<div style="float: right">조회수 54</div>
							  </div>
							  <div class="card-body list-group-item list-group-item-action">
							    <h5 class="card-title">제목</h5>
							    <p class="card-text ul-title">작성일: 2021-08-13 </p>
							  </div>
						</div>
					</div>
					</a>
					
					<nav aria-label="Page navigation example">
					  <ul class="pagination mt-3" >
					    <li class="page-item">
					      <a class="page-link" href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    <li class="page-item"><a class="page-link" href="#">1</a></li>
					    <li class="page-item"><a class="page-link" href="#">2</a></li>
					    <li class="page-item"><a class="page-link" href="#">3</a></li>
					    <li class="page-item">
					      <a class="page-link" href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					</nav>
					
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