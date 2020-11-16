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
<!-- 注册 -->
<div class="form sign-up">
    <h2>立即注册</h2>
    <span class="errorMsg"> ${requestScope.msg } </span>
    <form action="" method="post">
        <label>
            <span>用户名</span>
            <input type="text" />
        </label>
        <label>
            <span>密码</span>
            <input type="password" />
        </label>
        <label>
                    <span class="sex">性别:男<input type="radio" name="sex" class="sexboy">
                    女<input type="radio" name="sex" class="sexgirl"></span>
        </label>
        <label>
            <span>电话</span>
            <input type="text" name="phonenumber">
        </label>
        <label>
            <span>身份证号</span>
            <input type="text" name="idcard">
        </label>
        <button type="button" class="submit">注 册</button>
    </form>
</div>
</div>
</body>
</html>
