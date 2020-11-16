<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/10/13
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%
        String basePath=request.getScheme()
                +"://"
                +request.getServerName()
                +":"
                +request.getServerPort()
                +request.getContextPath()
                +"/";
        pageContext.setAttribute("basePath",basePath);
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="page/static/manager.css">
    <script type="text/javascript" src="page/script/jquery.min.js"></script>
    <style type="text/css">
        .body_form{
            width: 1000px;
            height: 100px;
            position: relative;
            left: 300px;
            top: 40%;
        }
    </style>
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
        </div>
    </div>
    <div id="body">
        <div class="body_form">
        <form method="post" action="managerServlet">
            <input type="hidden" name="pageNo" value="${param.pageNo }"/>
            <input type="hidden" name="action" value="${empty param.id ? "add" : "update" }"/>
            <input type="hidden" name="id" value="${requestScope.user.user_id }"/>
        <table  border="1">
            <tr>
                <th>用户名</th>
                <th>密码</th>
                <th>性别</th>
                <th>电话号码</th>
                <th>身份证号</th>
                <th>操作</th>
            </tr>
            <tr>
                <td><input type="text" name="username" value="${requestScope.user.username}"></td>
                <td><input type="text" name="password" value="${requestScope.user.password}"></td>
                <td>男<input type="radio" name="sex" value="man"/>女<input type="radio" name="sex" value="women"/></td>
                <td><input type="text" name="phonenumber" value="${requestScope.user.phonenumber}" ></td>
                <td><input type="text" name="idcard" value="${requestScope.user.idcard}"></td>
                <td><input type="submit" name="submit" value="提交"></td>
            </tr>
        </table>
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
