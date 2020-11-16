<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/11/3
  Time: 14:50
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
    <link rel="stylesheet" href="page/static/foodCart.css">
    <script type="text/javascript" src="page/script/jquery.min.js"></script>
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
                <a href="index.jsp" class="back">回到主页</a>
                <a href="foodServlet?action=cartView" class="cartHead">订单(${requestScope.cartCount})</a>
            </div>
        </div>
        <%--<a href="index.jsp">回到主页</a>--%>
        <%--<a href="foodServlet?action=cartView">购物车(${requestScope.cartCount})</a>--%>
    </div>
    <div id="body">
        <div class="body_table">
            <table width="70%" align="center" border="1">
                <tr>
                    <th>id</th>
                    <th>名称</th>
                    <th>价钱</th>
                    <th>图片地址</th>
                    <th>添加购物车</th>
                </tr>
                <c:forEach items="${requestScope.page.items}" var="food">
                    <form action="foodServlet" method="post">
                        <input type="hidden" name="food_id" value="${food.id}">
                        <input type="hidden" name="username" value="${sessionScope.CURREN_LOGIN_USER}">
                        <input type="hidden" name="action" value="addCart">
                        <tr>
                            <td>${food.id}</td>
                            <td>${food.name}</td>
                            <td>${food.price}</td>
                            <td><img src="${food.imagepath}" width="200px height=200px"></td>
                            <c:if test="${sessionScope.CURREN_LOGIN_USER!=null}">
                                <td><button class="addCart">添加到购物车</button></td>
                            </c:if>
                        </tr>
                    </form>
                </c:forEach>
            </table>
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
