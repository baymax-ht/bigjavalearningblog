<%@ page import="power.work.utils.BW_Constants" %>
<%@ page import="java.util.List" %>
<%@ page import="power.work.bean.Manager" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/10/13
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="head">
    <div class="logo">
        <a href="" class="logo_word">朱迪</a></br>
        <ul class="menu">
            <li><a href="" >关于我</a></li>
            <li><a href="" >购物</a></li>
            <li><a href="foodServlet?action=page" >订餐</a></li>
            <li><a href="" >预订</a></li>
            <%--判断用户是否登录--%>
            <c:if test="${sessionScope.CURREN_LOGIN_USER==null}">
                <li><a href="page/user/loandre.jsp">登录或注册</a></li>
            </c:if>
            <c:if test="${sessionScope.CURREN_LOGIN_USER!=null}">
                <li><a class="welcome_word">欢迎您,${sessionScope.CURREN_LOGIN_USER}</a></li>
                <li><a href="userServlet?action=logout">退出</a></li>
            </c:if>
            <%--判断用户是否开房--%>
            <c:if test="${sessionScope.user.room_id !=null && sessionScope.user.room_id !=0}">
                <li><a href="userServlet?action=checkOut">退房</a></li>
                <li><a href="page/room/userRoomMsg.jsp">我的开房信息</a></li>
            </c:if>
            <%--判断用户是否为管理员--%>
            <c:forEach items="${sessionScope.manager}" var="manager">
                <c:if test="${manager.name == sessionScope.CURREN_LOGIN_USER}">
                    <li><a href="managerServlet?action=page">管理用户</a></li>
                </c:if>
            </c:forEach>
            <%--将当下时间赋值给日历，更好的用户体验--%>
            <%
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = simpleDateFormat.format(new Date());
            %>
        </ul>
    </div>
    <div class="photo">
        <a href=""><img src="page/images/head_photo1.jpg" width="100%" height="514px"></a>
    </div>
    <div class="time">
        <div class="booking">
            <div class="booking_title">
                <h2>出行选择</h2>
            </div>
            <div class="booking_form">
                <form class="booking_form_time" action="roomServlet?action=checkIn" method="post">
                    <div class="form_select">
                        <div class="form_select_location">
                            <label>酒店位置</label>
                            <div class="select_location">
                                <span class="select_location_check">中国，江西，南昌，高新大道1888号</span>
                            </div>
                        </div>
                        <div class="form_select_start">
                            <label>入住时间</label>
                            <div class="form_select_starttime">
                                <input type="date" name="start" id="select_start" value="<%=date%>">
                            </div>
                        </div>
                        <div class="form_select_end">
                            <label>退房时间</label>
                            <div class="form_select_endtime">
                                <input type="date" name="end" id="select_end" value="<%=date%>">
                            </div>
                        </div>
                        <input type="submit" name="submit" value="提交" id="select_submit" class="select_submit">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>