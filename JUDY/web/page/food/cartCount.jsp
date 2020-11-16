<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/11/4
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>cartCount</title>
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
    <script>
        $(function () {
           $("a.deleteCart").click(function () {
               return confirm("是否要删除【" + $(this).parent().parent().find("td:nth-child(2)").text() + "】?");
           });
           $(".allCheck").click(function () {
               $(":checkbox[name='items']").prop("checked",this.checked);
           });
            $(":checkbox[name='items']").click(function () {
                // 要检查 是否满选
                var allCount = $(":checkbox[name='items']").length;
                // 再获取选中的个数
                var checkedCount = $(":checkbox[name='items']:checked").length;

                $(".allCheck").prop("checked",allCount == checkedCount);
            });
            $(".countMoney").click(function () {
                return confirm("是否要结算【" + $(this).parent().parent().find("td:nth-child(2)").text() + "】?");
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
                    <a href="foodServlet?action=page" class="back">回到菜单</a>
                </div>
            </div>
            <%--<a href="index.jsp">回到主页</a>--%>
            <%--<a href="foodServlet?action=cartView">购物车(${requestScope.cartCount})</a>--%>
        </div>
        <div id="body">
            <div class="body_table">
                <table width="70%" align="center" border="1">
                    <tr>
                        <th>全选<input type="checkbox" class="allCheck"></th>
                        <th>商品</th>
                        <th>商品名称</th>
                        <th>商品图</th>
                        <th>商品价格</th>
                        <th>商品数量</th>
                        <th>结算</th>
                        <th>状态</th>
                    </tr>
                    <c:forEach items="${requestScope.pageCart.items}" var="cart">
                        <form action="foodServlet" method="post">
                            <input type="hidden" name="action" value="countCartMoney">
                            <input type="hidden" name="food_id" value="${cart.id}">
                            <tr>
                                <td><input type="checkbox" name="items"></td>
                                <td>${cart.id}</td>
                                <td >${cart.name}</td>
                                <td><img src="${cart.imagepath}" width="200px height=200px"></td>
                                <td>${cart.price}</td>
                                <td><input type="number" name="quantity" min="1" max="99" value="1"></td>
                                <td><input type="submit" name="submit" value="结算" class="countMoney"></td>
                                <td><a href="/JUDY/foodServlet?action=deleteCart&foodid=${cart.id}" class="deleteCart">删除</a></td>
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
