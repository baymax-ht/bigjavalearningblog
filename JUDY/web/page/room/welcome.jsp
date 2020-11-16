<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/10/20
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    %>
</head>
<body>
欢迎入住朱迪酒店，您的房间号为${sessionScope.room_id},您花费了${sessionScope.money}
<a href="index.jsp">回到主页</a>
</body>
</html>
