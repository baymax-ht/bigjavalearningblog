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
</head>
<body>
<div id="body">
    <div class="user_room_msg">
        <div class="room_msg_ul">
            <ul>
                <lt><h3>用户房间信息</h3></lt>
                <li><span>&nbsp;&nbsp;&nbsp;用户名:&nbsp;&nbsp;&nbsp;${sessionScope.CURREN_LOGIN_USER}</span></li>
                <li><span>&nbsp;&nbsp;&nbsp;房间号:&nbsp;&nbsp;&nbsp;${sessionScope.user.room_id}</span></li>
                <li><span>入住天数:&nbsp;&nbsp;&nbsp;${sessionScope.user.days}</span></li>
                <li><span>消费金额:&nbsp;&nbsp;&nbsp;${sessionScope.user.money}</span></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
