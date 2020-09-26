<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager</title>
<base href="http://localhost:8080/BigJavaWeblog/">
<link type="text/css" rel="stylesheet" href="page/user/style.css" >
<style type="text/css">
	#login_header{
			margin-left: 400px;
		}
</style>
</head>
<body>
<div id="login_header">
			<img  src="page/img/logo.png"height="100px">
		</div>
<div id="main">
<form action="managerservlet" method="post">
<input type="hidden" name="pageNo" value="${param.pageNo }"/>
<input type="hidden" name="action" value="${empty param.id ? "add" : "update" }"/>
<input type="hidden" name="id" value="${requestScope.manager.id }"/>
<table border=1>
			<tr>
			<td>用户名</td>
			<td>点赞量</td>
			<td>阅读量</td>
			<td>操作</td>
			</tr>
			<tr>
				<td><input name="username" type="text" value="${requestScope.manager.username }"></td>
				<td><input name="likes" type="text" value="${requestScope.manager.likes }"></td>
				<td><input name="reading" type="text" value="${requestScope.manager.reading }"></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
</table>
</form>
</div>
<%@ include file="/page/common/footer.jsp" %>
</body>
</html>