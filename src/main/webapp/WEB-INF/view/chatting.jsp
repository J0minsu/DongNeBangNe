<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Document</title>
</head>
<body>
	<h1>POPUP !!</h1>

	<c:forEach var="item" items="${MessengerTexts}">
		<p>[${item.getTime() }] ${item.getFromUser() } :
			${item.getMessengerText}
	</c:forEach>


	<hr>
	<hr>


	<input type="text" name="messengerText" />
	<form method=POST action="/api/messengers/text">
		<%! MessengerText messengerText = new MessengerText(item.getMessenger(), item.getFromUser(), messengerText);%> 
	</form>

</body>
</html>