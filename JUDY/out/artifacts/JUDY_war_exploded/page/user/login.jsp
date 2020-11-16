<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/10/13
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 登录 -->
<div class="form sign-in">
    <h2>欢迎回来</h2>
    <form action="" method="post">
        <label>
            <span>用户名</span>
            <input type="text" name="username"/>
        </label>
        <label>
            <span>密码</span>
            <input type="password" />
        </label>
        <p class="forgot-pass"><a href="javascript:">忘记密码？</a></p>
        <button type="button" class="submit">登 录</button>
    </form>
</div>
<div class="sub-cont">
    <div class="img">
        <div class="img__text m--up">
            <h2>还未注册？</h2>
            <p>立即注册，发现大量机会！</p>
        </div>
        <div class="img__text m--in">
            <h2>已有帐号？</h2>
            <p>有帐号就登录吧，好久不见了！</p>
        </div>
        <div class="img__btn">
            <span class="m--up">注 册</span>
            <span class="m--in">登 录</span>
        </div>
    </div>
</div>
</body>
</html>
