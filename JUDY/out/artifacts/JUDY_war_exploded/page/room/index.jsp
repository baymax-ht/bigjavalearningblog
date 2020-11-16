<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/10/20
  Time: 9:23
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
    <link rel="stylesheet" type="text/css" href="page/static/room.css">
    <script type="text/javascript" src="page/script/jquery.min.js"></script>
</head>
<script type="text/javascript">
    $(function(){
        $(".right_foot_money_count").mouseover(function(){
            $(this).addClass("count_border_css");
        }).mouseout(function(){
            $(this).removeClass("count_border_css");
        });
        $(".right_foot_money_count").click(function(){
            if (confirm("是否提交住房信息？")) {
                return true;
            }else{
                return false;
            }
        });
    });
</script>
<body>
<div id="main">
<%@include file="head.jsp"%>
<%@include file="body.jsp"%>
<%@include file="/foot.jsp"%>
</div>
</body>
</html>
