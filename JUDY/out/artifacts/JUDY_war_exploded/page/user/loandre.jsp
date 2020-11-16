<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/10/15
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <title>login and register</title>
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
    <link rel="stylesheet" href="page/static/login.css">
    <script type="text/javascript" src="page/script/jquery.min.js"></script>
    <script>
        $(function(){
            $("#username").blur(function() {
                //1：获取用户名
                var username = this.value;
            });
            $("#sub_btn").click(function(){
                //验证用户名由字母，数字和下划线组成
                var usernameText = $("#username").val();
                var usernamePatt = /^\w{5,12}$/;
                if (!usernamePatt.test(usernameText)) {
                    $("span.reerrorMsg").text("用户名不合法！");
                    return false;
                }
                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                var passwordText = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(passwordText)) {
                    $("span.reerrorMsg").text("密码不合法！");

                    return false;
                }
                // 验证确认密码：和密码相同
                var repwdText = $("#repassword").val();
                if (repwdText != passwordText) {
                    $("span.reerrorMsg").text("确认密码和密码不一致！");
                    return false;
                }

                // //验证电话号：必须由数字组成，且7~18
                var phoneText = $("#phonenumber").val();
                var phonePatt = /^\d{11,18}$/;
                if (!phonePatt.test(phoneText)) {
                    $("span.reerrorMsg").text("电话号码不合法");
                    return false;
                }

                //验证身份证号必须由数字组成且位数等于18
                var idcardText = $("#idcard").val();
                var idcardPatt =  /^\d{18}$/;
                if (!idcardPatt.test(idcardText)) {
                    $("span.reerrorMsg").text("身份证号不合法");
                    return false;
                }
                $("span.reerrorMsg").text("");
            });
        });
    </script>
</head>
<body>

<div class="dowebok">
    <!-- 登录 -->
    <div class="form sign-in">
        <h2>欢迎回来</h2>
        <div class="msgcont">
        <span class="errorMsg">
            <!--<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg") %>-->
            ${ empty requestScope.msg ?"请输入用户名和密码" :requestScope.msg}
        </span>
        </div>
        <form action="userServlet" method="post">
            <input type="hidden" name="action" value="login"/>
            <label>
                <span>用户名</span>
                <input type="text" name="username"/>
            </label>
            <label>
                <span>密码</span>
                <input type="password" name="password"/>
            </label>
            <p class="forgot-pass"><a href="page/user/forget.jsp">忘记密码？</a></p>
            <input  type="submit" name="submit" class="submit" value="登录">
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
        <!-- 注册 -->
        <div class="form sign-up">
            <h2>立即注册</h2>
            <div class="reerrormsg">
                <span class="reerrorMsg">${requestScope.remsg}</span>
            </div>
            <form action="userServlet" method="post">
                <input type="hidden" name="action" value="register"/>
                <label>
                    <span>用户名</span>
                    <input type="text" name="username" id="username"/>
                </label>
                <label>
                    <span>密码</span>
                    <input type="password" name="password" id="password"/>
                </label>
                <label>
                    <span>再次确认密码</span>
                    <input type="password" name="repassword" id="repassword"/>
                </label>
                <label>
                    <span class="sex">性别:男<input type="radio" name="sex" class="sexboy" value="male">
                    女<input type="radio" name="sex" class="sexgirl" value="female"></span>
                </label>
                <label>
                    <span>电话</span>
                    <input type="text" name="phonenumber" id="phonenumber">
                </label>
                <label>
                    <span>身份证号</span>
                    <input type="text" name="idcard" id="idcard">
                </label>
                <input  type="submit" name="submit" class="resubmit" id="sub_btn" value="注册">
                </form>
        </div>
    </div>
</div>
    <script src="page/script/login.js"></script>
</body>
</html>
