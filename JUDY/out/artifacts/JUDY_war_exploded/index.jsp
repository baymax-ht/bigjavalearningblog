<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/10/4
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
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
      <link rel="stylesheet" type="text/css" href="page/static/lrtk.css">
    <link rel="stylesheet" type="text/css" href="page/static/style.css">

    <script type="text/javascript" src="page/script/jquery.min.js"></script>
    <script type="text/javascript" src="page/script/lrscroll.js"></script>
    <script type="text/javascript">
        $(function(){
            /*
            submit样式
            */
            $("#select_submit").mouseover(function(){
                $(this).addClass("submit_color2");
            }).mouseout(function(){
                $(this).removeClass("submit_color2");
            });
        });
    </script>
  </head>
  <body>
  <div id="main">
    <%@include file="head.jsp"%>
    <%@include file="body.jsp"%>
    <%@include file="foot.jsp"%>
  </div>
  </body>
</html>
