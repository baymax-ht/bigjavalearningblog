<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/11/2
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>changePassword</title>
    <%
        String basePath=request.getScheme()
                +"://"
                +request.getServerName()
                +":"
                +request.getServerPort()
                +request.getContextPath()
                +"/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="page/static/forget.css">
    <script type="text/javascript" src="page/script/jquery.min.js"></script>
    <script>
        $(function () {
            $(".filed_submit").click(function () {
                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                var passwordText = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(passwordText)) {
                    alert("密码格式不符合规范");
                    return false;
                }
                // 验证确认密码：和密码相同
                var repwdText = $("#repassword").val();
                if (repwdText != passwordText) {
                    alert("两次密码不一致");
                    return false;
                }
            });

        });
    </script>
</head>
<body>
<div id="main">
    <div id="head">
        <div class="left_logo">
            <div class="logo_title">
                <div class="logo_title_word">
                    <a href="">朱迪</a>
                </div>
            </div>
            <div class="menu_mainpage">
                <a href="" class="back">回到主页</a>
            </div>
        </div>
    </div>
    <div id="body">
        <div class="menu_forget">
            <form action="userServlet?action=updatePassword" method="post">
                <div class="forget_username">
                    <input type="password" name="password" id="password" class="filed_username" placeholder="请输入新密码">
                </div>
                <div class="forget_idcard"><input type="password" name="repassword" id="repassword" class="filed_idcard" placeholder="请再次输入新密码"></div>
                <div class="forget_button"><input type="submit" name="submit" class="filed_submit" value="修改"></div>
            </form>
        </div>
    </div>
    <div id="foot">
        <div class="foot_title">
            <div class="title_logo">
                <a href="" class="title_logo_word">朱迪</a>
            </div>
        </div>
        <div class="foot_email">
            <div class="email_content">
                <span>© 2356235991qq.com</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
