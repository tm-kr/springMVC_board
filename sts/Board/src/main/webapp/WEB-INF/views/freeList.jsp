<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="content ">
			<div class="contentL">
				<div class="search shadow-sm">
					<div class="search-top">
						<h2 style="float: left">자유</h2>
						<c:if test="${not empty sessionScope.id }">
						<div style="float: right"><a href="write"><img alt="" src="resources/img/write.jpg"></a></div>
						</c:if>
					</div>
					<br><br>
					<div>
						<div class="search-cate" style="float: left"><a style ="color: #98a0a7" href="free?search=${search }">최신순</a>  
																	<a style ="color: #98a0a7" href="free?sort=popular&search=${search}">조회순</a></div>  
						<form class="d-flex" style="float: right" action="">
					      <input class="form-control me-2" type="search" placeholder="검색할 내용" aria-label="Search" name="search">
					      <button class="btn btn-secondary" type="submit">search</button>
						</form>
					</div>
					  
					
				</div>
				<div class="list shadow-sm">
					<c:if test="${empty boardList}">
							<img class="mt-5" alt="" src="resources/img/noserch.jpg">
					</c:if>
					
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
					<c:if test="${not empty boardList}">
					<nav aria-label="Page navigation example">
					  <ul class="pagination mt-3" >
					    <li class="page-item">
					      <a class="page-link" href="free/${page.startPage + 2 - page.countPage}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    
					    <c:forEach var="i"  begin="${page.startPage }" end="${page.endPage }">
					    	<li class="page-item"><a class="page-link" href="free/${i}">${i}</a></li>
					    </c:forEach>
					    
					    <c:if test="${page.block > page.endPage}">
					    <li class="page-item">
					      <a class="page-link" href="free/${page.startPage + page.countPage}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					    </c:if>
					  </ul>
					</nav>
					</c:if>
				</div>	
			</div>
			
			<jsp:include page="common/sidebar.jsp" flush="false" />
			
		</div>
	</div>
	
	<jsp:include page="common/footer.jsp" flush="false" />
	
	
</body>
</html>