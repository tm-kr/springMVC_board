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
		<div class="content2">
		
			<div class="contentL">
				<div class="content-read shadow-sm">
					<div class="content-header">
						<h3 >[ 긴급뉴스 ]</h3><br>
					</div>
					
					<div class="content-mid">
						<h6>긴급뉴스가 없습니다.</h6>
					</div>
					<div class="content-bottom">
						<button type="button" class="btn btn-info" onclick="location.href='index'" >목록</button>
					</div>
				</div>
			</div>
		
			<jsp:include page="common/sidebar.jsp" flush="false" />
			
		</div>
	</div>
	<jsp:include page="common/footer.jsp" flush="false" />
	
</body>
</html>