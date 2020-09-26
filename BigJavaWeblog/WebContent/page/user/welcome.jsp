<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.bigjava.bean.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	User loginUser = (User)request.getSession().getAttribute("ajaxUser");
%>
<h4>welcome, <%=loginUser.getUsername() %></h4>
</body>
</html>