<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String login = (String)session.getAttribute("CURREN_LOGIN_USER");
	if("root".equals(login)){
		
	}else{
		response.sendRedirect("index.jsp");
	}
	%>
</body>
</html>