<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>校验用户名是否可用</title>
<base href="http://localhost:8080/BigJavaWeblog/">
<script type="text/javascript" src="page/script/jquery-1.7.2.js"></script>
</head>

<script>
	var xmlhttp;
	function createXMLHttpRequest(){
		//创建XMLHttpRequest对象
		try{
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
			xmlhttp=  new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				try{
					xmlhttp = new XMLHttpRequest();
					if(xmlhttp.overrideMimeType){
					   xmlhttp.overrideMimeType("text/xml");
					}
				}catch(e){}
			}
		}
	}
	function doAjax(url){
		//促使XMLHttpRequest
		createXMLHttpRequest();
		if(xmlhttp != null){
			//设置回调函数
			xmlhttp.onreadystatechange = processRequest;
			
			xmlhttp.open("post",url,true,"","");
			//如果以post方式请求，必须加上请求头信息
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send(null);
		}else{
			alert("XMLHttpRequest对象未初始化");
		}
	}
	function processRequest(){
		var rtnMessDiv = document.getElementById("rtnMess");
		if(xmlhttp.readyState == 4){
			if(xmlhttp.status==200){
				if(xmlhttp.responseText=="true"){
					// rtnMessDiv.innerHTML = "<font color='green'>登录成功</font>";
					window.location = "http://localhost:8080/BigJavaWeblog/page/user/welcome.jsp";
				}else{
					rtnMessDiv.innerHTML = "<font color='red'>用户名或密码错误</font>";
				}
			}else{
				alert("校验用户名Ajax请求未正常返回！\nError:"+xmlhttp.status+""+xmlhttp.statusText);
			}
		}
	}
	function login(){
		var username = document.myForm.username.value;
		var password = document.myForm.password.value;
		if(username.trim()==""){
			alert("用户名不能为空");
			return false;
		}else if(password.trim()==""){
			alert("密码不能为空");
			return false;
		}
		else{
			//使用Ajax提交到后台wevlet进行异步处理
			doAjax("user?action=loginAjax&username="+username+"&password="+password);
		}
	}
</script>
<body>
	<form action="" method="post" name="myForm">
	username<input type="text" name="username"><br/>
	password<input type="password" name="password"><br/>
	<input type="button" value="submit" onclick="login()">
	<div id="rtnMess" style="display:inline;">
	</div>
	<div id="timeInfo" style="display:inline;"></div>
	<br/>
	<a href="/page/user/LoginAjax.jsp">异步联想搜索 </a>
	</form>
</body>
</html>