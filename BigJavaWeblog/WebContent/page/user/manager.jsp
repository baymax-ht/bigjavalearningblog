<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager</title>
<base href="http://localhost:8080/BigJavaWeblog/">
<link type="text/css" rel="stylesheet" href="page/user/style.css" >
<script type="text/javascript" src="page/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		//给delete绑定单击事件
		//返回true确认，false取消
		/**
			有个this对象是当前的dom对象
		*/
		$("a.deleteClass").click(function(){
			return confirm("是否要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
		});
	});
</script>
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
<table border=1>
	<tr>
				<td>用户名</td>
				<td>点赞量</td>
				<td>阅读量</td>
				<td colspan="1">操作<td>
			</tr>
			<c:forEach items="${requestScope.page.items }" var="manager">
			<tr>
				<td>${manager.username }</td>
				<td>${manager.likes }</td>
				<td>${manager.reading }</td>
				<td><a href="managerservlet?action=getManager&id=${manager.id }&pageNo=${requestScope.page.pageNo}">修改 </a></td>
				<td><a class="deleteClass" 
				href="managerservlet?action=delete&id=${manager.id }&pageNo=${requestScope.page.pageNo}">删除</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="page/manager/edit.jsp?pageNo=${requestScope.page.pageTotal }">添加用户</a></td>
			</tr>
</table>
<div id="page_nav">
	<c:if test="${requestScope.page.pageNo > 1 }">
	<a href="managerservlet?action=page&pageNo=1">首页</a>
	<a href="managerservlet?action=page&pageNo=${requestScope.page.pageNo-1 }">上一页</a>
	</c:if>
	
	<%-- 页码输出的范围--%>
	<!-- 1 页码小于等于5 -->
	
	
	<c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal }">
	<a href="managerservlet?action=page&pageNo=${requestScope.page.pageNo+1 }">下一页</a>
	<a href="managerservlet?action=page&pageNo=${requestScope.page.pageTotal }">末页</a>
	</c:if>
	共${requestScope.page.pageTotal }页，${requestScope.page.pageTotalCount }条记录
	到第<input value="${param.pageNo }" name="pn" id="pn_input">页
	<input id="search" type="button" value="确定">
	<script type="text/javascript">
		$(function(){
			$("#search").click (function(){
				var pageNo = $("#pn_input").val();
				var pageTotal = ${requestScope.page.pageTotal};
				if(pageNo<1){
					pageNo=1;
				}
				if(pageNo>pageTotal){
					pageNo=pageTotal;
				}
				location.href="http://localhost:8080/BigJavaWeblog/managerservlet?action=page&pageNo="+pageNo;
			});
		});
	</script>
</div>
</div>
<%@ include file="/page/common/footer.jsp" %>
</body>
</html>