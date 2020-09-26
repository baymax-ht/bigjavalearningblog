<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
		#starter {
			width: 985px;
			height: 180px;
		}
		#starter .logo {
			width: 850px; 
			height: 180px;
			float: left;
		}
		#starter .menu {
			width: 100px; 
			height: 50px; 
			float: right; 
			text-align: right;
			padding: 15px;
		}
		#navi {
			width: 985px;
			height: 90px;
			float: left;
			border: 1px solid #ccc;
		}
		#navi ul li{
			list-style: none;
			float: left;
			padding: 10px;
		}
		#navi ul li a {
			font-size: 18px;
			font-style: bold;
			text-decoration: none;
		}
		#navi ul li a:hover {
			font-size: 20px;
			color: #ff0;
		}
	</style>
</head>
<body>

		<div id="head">
			<!-- 网站头部 -->
			<div id="starter">
				<div class="logo">
					<a href="index.jsp">
						<img src="images/uugai.com_1592289558246.png" width="848" height="180" />
					</a>
				</div>
				
				<!-- 功能栏 -->
				<div class="menu">
					
					 <%
					 	String login = (String) session.getAttribute("CURREN_LOGIN_USER");
					 	if (login == null) {
					 %>
					 	<a href="page/user/login.jsp">登录</a>
						<a href="page/user/register.jsp">注册</a><br/>
						<br/>
						<a href="managerservlet?action=page">用户信息管理</a>
					 <%
						} else {
					 %>
					 	欢迎您, <%=login %><br/>
					 	<a href="user?action=logout">退出</a><br/>
					 	<a href="managerservlet?action=page">用户信息管理</a>
					 <%
						}
					 %>
				</div>
			</div>
			
			<!-- 博客导航部分 -->
			<div id="navi">
				<ul>
					<li><a href="index.jsp">首页</a></li>
					<li><a href="about.jsp">关于我</a></li>
					<li><input type="text" placeholder="请输入..."><input type="button" value="搜索"/>
					<li><a href="page/user/upblog.jsp">发布博客</a></li>
				</ul>
			</div>
		</div>
</body>
</html>