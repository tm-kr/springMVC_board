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
						<h3 >${boardVO.title }</h3>
						<h6 class="ul-title">${boardVO.regdate } &nbsp;|&nbsp;  ${boardVO.writer }  &nbsp;|&nbsp;  조회 ${boardVO.views}</h6>
					</div>
					
					<div class="content-mid">
						${boardVO.content }
					</div>
					<div class="content-mid2">
						<h6>업로드한 파일 : </h6>
					</div>
					<div class="content-bottom">
						<c:if test="${boardVO.writer == sessionScope.id }">
								<button type="button" class="btn btn-outline-danger" onclick="delete_Event()">삭제</button>
								<button type="button" class="btn btn-outline-secondary" onclick="location.href='<c:url value="/edit/${boardVO.num }"/>'">수정</button>
						</c:if>
						<button type="button" class="btn btn-outline-info" onclick="location.href='index'" >목록</button>
					</div>
				</div>
			</div>
		
			<jsp:include page="common/sidebar.jsp" flush="false" />
			
		</div>
	</div>
	<jsp:include page="common/footer.jsp" flush="false" />
	
<script>
	function delete_Event(){
 
        if (confirm('정말 삭제하시겠습니까?')) {
             // 확인 click 글삭제
        	location.replace("<c:url value="/delete/${boardVO.num }"/>");
        } else {
            // 취소 click 글삭제 취소
        	location.replace("<c:url value="/read/${boardVO.num }"/>");
		}
    }

</script>


	
</body>
</html>