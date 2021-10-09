<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<div class="content2">
		
			<div class="contentL shadow-sm">
				<div>
					<form:form commandName="boardVO" method="POST">
						<div class="write">
							<h3>글쓰기</h3><br>
							<select class="form-select" aria-label="Default select example" name="category">
							  <option value="자유"selected>자유 게시판</option>
							  <option value="유머">유머 게시판</option>
							</select><br> 
							<input type="text" class="form-control" placeholder="제목 (10자 이내)" name="title" ><br>
							<input class="form-control" type="file" id="formFile" name="uploadFile"><br>
							<textarea class="form-control" placeholder="파일 설명  (1000자 이내)" name="content"></textarea>
							<div class="btn1 mt-3">
								<button type="submit" class="btn btn-outline-secondary" >작성하기</button>	
								<button type="button" class="btn btn-outline-secondary" onclick="location.href='index'" >취소</button>	
							</div>
						</div>
						<input type="hidden" name="writer" value="${id}">
					</form:form>
				</div>
					  
					
			</div>
			
			<jsp:include page="common/sidebar.jsp" flush="false" />
			
		</div>
	</div>
	
	<jsp:include page="common/footer.jsp" flush="false" />
	
	
</body>
</html>