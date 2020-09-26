<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>百度异步联想搜索</title>
<base href="http://localhost:8080/BigJavaWeblog/">
<script type="text/javascript" src="page/script/jquery-1.7.2.js"></script>
<style type="text/css">
	.mover {background: #ccc; }
	.mout {background: #fff };
</style>
</head>

<script>
	var xmlhttp;
	function createXMLHttpRequest() {
		//创建XMLHttpRequest对象
		try {
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				try {
					xmlhttp = new XMLHttpRequest();
					if (xmlhttp.overrideMimeType) {
						xmlhttp.overrideMimeType("text/xml");
					}
				} catch (e) {
				}
			}
		}
	}
	function doAjax(url) {
		//促使XMLHttpRequest
		createXMLHttpRequest();
		if (xmlhttp != null) {
			//设置回调函数
			xmlhttp.onreadystatechange = processRequest;

			xmlhttp.open("post", url, true, "", "");
			//如果以post方式请求，必须加上请求头信息
			xmlhttp.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xmlhttp.send(null);
		} else {
			alert("XMLHttpRequest对象未初始化");
		}
	}
	function processRequest() {
		var suggestDiv = document.getElementById("suggest");
		var originText = document.myForm.keyword.value;
		suggestDiv.innerHTML = "";
		if (xmlhttp.readyState == 4) {
			if (xmlhttp.status == 200) {
				if (xmlhttp.responseText != null) {
					//var words = xmlhttp.responseText.split(",", 5);
					
					var suggestionWords = xmlhttp.responseText.split(",",5);
					var suggestObj = document.getElementById("suggest");
					for (var i=0; i<suggestionWords.length; i++) {
						var s = document.createElement("div");
						s.id = "s" + i;
						s.innerText = suggestionWords[i];
						s.style.color = "blue";
						s.onmouseover = function() {this.className = "mover"; }
						s.onmouseout  = function() {this.className = "mout"; }
						s.addEventListener("click", function(event) {
							var word = document.getElementById(''+event.target.id).innerText;
							useSearch(word);
						});
						suggestObj.appendChild(s);
					}
				}	
			} else {
				alert("校验用户名Ajax请求未正常返回！\nError:" + xmlhttp.status + ""
						+ xmlhttp.statusText);
			}
		}
	}
	//选择某条联想后执行
	function useSearch(word) {
		document.myForm.keyword.value = word;
		suggestClear();
	}
	//异步联想搜索
	function searchSuggest(x) {
		var keyword = x;
		if (keyword.trim() == "") {
			suggestClear();
			return false;
		}else{
			document.getElementById("suggest").style.display="block";
		}
		doAjax("user?action=autoComplete&keyword=" + keyword);
		//使用Ajax提交到后台wevlet进行异步处理
	}
	function suggestClear() {
		document.getElementById("suggest").style.display = "none";
	}
	
	 /*  window.onload = function() {
		//var words = xmlhttp.responseText.split(",", 5);
		var suggestionWords = ['admin','admin222','admin123'];
		
		var suggestObj = document.getElementById("suggest");
		for (var i=0; i<suggestionWords.length; i++) {
			var s = document.createElement("div");
			s.id = "s" + i;
			s.innerText = suggestionWords[i];
			s.style.color = "blue";
			s.onmouseover = function() {this.className = "mover"; }
			s.onmouseout = function() {this.className = "mout"; }
			s.addEventListener("click", function(event) {
				document.getElementsByName("keyword")[0].value = document.getElementById(''+event.target.id).innerText;
				
			});
			suggestObj.appendChild(s);
		}
	}  */
</script>
<body>
	<h3>AJAX异步联想功能</h3>
	<form action="" method="post" name="myForm">
		<input type="text" name="keyword"
			onkeyup="searchSuggest(this.value)" autocomplete="off"><input type="submit" value="Google" />
		<div id="suggest"
			style="width: 200px; border: 1px solid silver;">
		</div>
	</form>
</body>
</html>