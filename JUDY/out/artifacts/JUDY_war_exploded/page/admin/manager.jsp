<%--
  Created by IntelliJ IDEA.
  User: 我不敢说来生
  Date: 2020/10/13
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        pageContext.setAttribute("basePath",basePath);
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="page/static/manager.css">
    <script type="text/javascript" src="page/script/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function(){
                return confirm("是否要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
            });
            $("a.back").click(function () {
               history.back();
            });
        });
    </script>
    <style type="text/css">
        .table_content{
            width: 80%;
            height: 380px;
            position: relative;
            top: 20%;
            left: 10%;
        }

        .menu_mainpage{
            position: relative;
            left: 800px;
            bottom:20px;
        }
        .menu_mainpage a{
            text-decoration: none;
            font-size: 15px;
            font-family: serif;
            color: #F8F8F8;
        }
        .page_nav{
            margin: 0 auto;
            width: 60%;
        }
        /*
        搜索框
        */
        .search_text{
            width: 300px;
            height: 50px;
            position: relative;
            left: 30%;
        }
        #search_input{
            width: 200px;
            height: 30px;
            border-right: 0px;
            border-color:#302D2D;
            border-top-left-radius: 10px;
            border-bottom-left-radius: 10px;
        }
        #search_submit{
            width:80px;
            height: 30px;
            text-align: center;
            color: white;
            border: 0;
            background: #302D2D;
            position: relative;
            top: 0.03cm;
            left: -4.3px;
            border-top-right-radius: 10px;
            border-bottom-right-radius: 10px;
        }
    </style>
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
            <a href="" class="back">回到主页</a>
        </div>
    </div>
</div>
    <div id="body">
        <div class="body_table">
            <div class="table_content">
                <div class="content_search">
                <form method="post" action="managerServlet?action=listUser">
                    <div class="search_text">
                        <input type="text" name="content" placeholder="请输入您要搜索的内容" id="search_input">
                        <input type="submit" value="搜索一下" id="search_submit">
                    </div>
                </form>
                </div>
                <table border="1px">
                    <tr>
                        <th>用户名</th>
                        <th>密码</th>
                        <th>性别</th>
                        <th>电话号码</th>
                        <th>身份证号</th>
                        <th>房间号</th>
                        <th>创建时间</th>
                        <th clowspan="1">操作</th>
                    </tr>
                    <c:forEach items="${requestScope.page.items}" var="user">
                        <tr>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td>${user.sex}</td>
                            <td>${user.phonenumber}</td>
                            <td>${user.idcard}</td>
                            <td>${user.room_id}</td>
                            <td>${user.createtime}</td>
                            <td><a href="managerServlet?action=getUser&id=${user.user_id }&pageNo=${requestScope.page.pageNo}">修改 </a></td>
                            <td><a class="deleteClass"
                                   href="managerServlet?action=delete&id=${user.user_id }&pageNo=${requestScope.page.pageNo}">删除</a></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><a href="page/admin/edit.jsp?pageNo=${requestScope.page.pageTotal}">添加用户</a></td>
                    </tr>
                </table>
                <div class="page_button">
                    <div class="page_nav">
                    <c:if test="${requestScope.page.pageNo>1}">
                    <a href="managerServlet?action=page&pageNo=1">首页</a>
                    <a href="managerServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
                    </c:if>
                    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
                    <a href="managerServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
                    <a href="managerServlet?action=page&pageNo=${requestScope.page.pageTotal}">尾页</a>
                    </c:if>
                    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
                    到第<input type="${requestScope.page.pageNo}" name="pn" id="pn_input">页
                    <input type="button" id="search"value="确定">
                    <script type="text/javascript">
                        /*跳到指定页码*/
                        $(function () {
                           $("#search").click(function () {
                               var pageNo = $("#pn_input").val();
                               var pageTotal = ${requestScope.page.pageTotal};
                               if (pageNo<1 || pageNo>pageTotal){
                                   alert("您输入的页码无效");
                               }else{
                               //提供了location跳转
                               location.href="${pageScope.basePath}managerServlet?action=page&pageNo="+pageNo;
                               }
                           });
                        });
                    </script>
                </div>
                </div>
            </div>
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
