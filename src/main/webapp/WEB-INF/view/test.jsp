<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script language="javascript">
	function showPopup() {
		window.open("/api/messengers/msjo/jwseo", "a",
				"width=400, height=300, left=100, top=50");
	}
</script>
</head>
<body>
	This is Home page that team Silort's ByLive's

	<%=request.getAttribute("text")%>
	<img src="<c:url value="https://bylivetest.s3.ap-northeast-2.amazonaws.com/img/userProfile/1/%ED%99%94%EB%A1%B1.jpg" />" alt="image"
				style="width: 30%" />
	<input type="button" value="팝업창 호출" onclick="showPopup();" />
	<!-- he -->
</body>
</html>