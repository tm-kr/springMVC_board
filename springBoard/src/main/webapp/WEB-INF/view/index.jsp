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
			<h3 style="float: left"><a href="${pageContext.request.contextPath}/index" style="color: white">Simple board</a></h3>
			<c:if test="${empty sessionScope.id }">
			<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='${pageContext.request.contextPath}/login'">로그인</button>
			</c:if>
			<c:if test="${not empty sessionScope.id }">
				<button style="float: right" type="button" class="btn btn-outline-light" onclick="location.href='${pageContext.request.contextPath}/logout'">로그아웃</button>
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
						<div style="float: right"><a href="${pageContext.request.contextPath}/write"><img alt="" src="${pageContext.request.contextPath}/resources/img/write.jpg"></a></div>
						</c:if>
					</div>
					<br><br>
					<div>
						<div class="search-cate" style="float: left"><a style ="color: #98a0a7" href="${pageContext.request.contextPath}/index">최신순</a>  
																	<a style ="color: #98a0a7" href="${pageContext.request.contextPath}/popular/1">조회순</a></div>  
						<form class="d-flex" style="float: right">
					      <input class="form-control me-2" type="search" placeholder="검색할 내용" aria-label="Search">
					      <button class="btn btn-secondary" type="submit">search</button>
						</form>
					</div>
					  
					
				</div>
				<div class="list shadow-sm">
					
					<c:forEach var="board" items="${boardList }" varStatus="loop">
						<a href="<c:url value="/read/${board.num }"/>">
						<div class="list-card ">
								<div class="card">
									  <div class="card-header">
									   ${board.writer }<div style="float: right">조회수 ${board.views }</div>
									  </div>
									  <div class="card-body list-group-item list-group-item-action">
									    <h5 class="card-title">${board.title }</h5>
									    <p class="card-text ul-title">${board.category } | 작성일: ${board.regdate } </p>
									  </div>
								</div>
						</div>
					</a>
					</c:forEach>
					
					<nav aria-label="Page navigation example">
					  <ul class="pagination mt-3" >
					    <li class="page-item">
					      <a class="page-link" href="${pageContext.request.contextPath}/index/${page.startPage + 2 - page.countPage}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    
					    <c:forEach var="i"  begin="${page.startPage }" end="${page.endPage }">
					    	<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/index/${i}">${i}</a></li>
					    </c:forEach>
					    
					    <c:if test="${page.block > page.endPage}">
					    <li class="page-item">
					      <a class="page-link" href="${pageContext.request.contextPath}/index/${page.startPage + page.countPage}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					    </c:if>
					  </ul>
					</nav>
					
				</div>	
			</div>
			
		
			<div class="profile shadow-sm">
				<c:if test="${empty sessionScope.id }">
					 <div class="d-grid gap-2 profile-top">
						   <button class="btn btn-info" type="button" onclick="location.href='${pageContext.request.contextPath}/login'">로그인</button>
						   <button class="btn btn-info" type="button" onclick="location.href='${pageContext.request.contextPath}/join'">회원가입</button>
					 </div>
				 </c:if>
				 <c:if test="${not empty sessionScope.id }">
				 	<div class="profile-top">
				 		<h6 class="ul-title id-title">${id}님 환영합니다!</h6>
				 		<button class="btn btn-info" type="button" onclick="location.href='${pageContext.request.contextPath}/write'">글쓰기</button>
				 		<button class="btn btn-outline-info" type="button" onclick="location.href='${pageContext.request.contextPath}/login'">내가 쓴 글</button>
				 		<button class="btn btn-outline-info" type="button" onclick="location.href='${pageContext.request.contextPath}/login'">내정보</button>
					</div>
				</c:if>
				 <div class="profile-mid">
				 	<h6 class="ul-title">홈</h6>
				 	<h5><a style="color: black" href="${pageContext.request.contextPath}/index">전체</a></h5>
				 </div>
				 <div class="profile-mid">
				 	<h6 class="ul-title">정보</h6>
				 	<h5><a style="color: black" href="${pageContext.request.contextPath}/notice">공지사항</a></h5>
				 	<h5><a style="color: black" href="${pageContext.request.contextPath}/news">긴급 뉴스</a></h5>
				 </div>
				 <div class="profile-bottom">
				 	<h6 class="ul-title">커뮤니티</h6>
				 	<h5><a style="color: black" href="${pageContext.request.contextPath}/notice">자유</a></h5>
				 	<h5><a style="color: black" href="${pageContext.request.contextPath}/notice">유머</a></h5>
				 	<h5 style="text-decoration: line-through;">팬 아트</h5>
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