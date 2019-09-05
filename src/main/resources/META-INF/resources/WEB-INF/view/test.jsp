<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<input type="button" value="팝업창 호출" onclick="showPopup();" />
	<!-- he -->
</body>
</html>