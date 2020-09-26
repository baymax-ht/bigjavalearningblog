<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Learningblog登入</title>
<base href="http://localhost:8080/BigJavaWeblog/">
<link type="text/css" rel="stylesheet" href="page/user/style.css" >
</head>
<body>
		<div id="login_header">
			<img  src="page/img/logo.png" height="100px" weight="100px">
		</div>
			<div class="login_banner">
				<div id="l_content">
					<span class="login_word">欢迎登入</span>
				</div>
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>大白博客</h1>
								<a href="page/user/register.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
								<!--<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg") %>-->
								${ empty requestScope.msg ?"请输入用户名和密码" :requestScope.msg}
								 </span>
							</div>
							<div class="form">
								<form action="user" name="loginForm" method="post">
								<input type="hidden" name="action" value="login"/>
									<label>用户名称</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" 
									value="${requestScope.username }"
									/>
									<br />
									<br />
									<label>用户密码</label>
									<input class="itxt" type="password" placeholder="请输入密码 " autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登入" id="sub_btn" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%@ include file="/page/common/footer.jsp" %>
</body>
</html>