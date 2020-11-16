<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/11/2
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forget the password</title>
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
               var username = $(".filed_username").val();
               var idcard = $(".filed_idcard").val();
               if (username=="" || idcard==""){
                   alert("不能为空");
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
                <form action="userServlet?action=existUsernameAndIdCard" method="post">
                    <div class="forget_username">
                        <input type="text" name="username" class="filed_username" placeholder="请输入用户名">
                    </div>
                    <div class="forget_idcard"><input type="text" name="idcard" class="filed_idcard" placeholder="请输入身份证号"></div>
                    <div class="forget_button"><input type="submit" name="submit" class="filed_submit" value="下一步"></div>
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
