<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/10/22
  Time: 9:07
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
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="page/static/userRoomMsg.css">
    <script type="text/javascript" src="page/script/jquery.min.js"></script>
</head>
<body>
<div id="main">
    <%@include file="roomMsgHead.jsp"%>
    <%@include file="roomMsgBody.jsp"%>
    <%@include file="/foot.jsp"%>
</div>

</body>
</html>
