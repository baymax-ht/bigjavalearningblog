<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		body  {
			font-size: 14px;
			background: #F8F8FF;
		}
		#container {
			width: 990px;;
			height: auto;
			border: 1px solid #ccc;
			margin: 0 auto;
		}
		#h {
			width: 985px;
			height: 280px;
		}
		#m {
			width: 985px;
			height: 500spx;
		}
		#f {
			width: 985px;
		}	
	</style>
	
	<script type="text/javascript">
	</script>
</head>
<body>
	<div id="container">
	
		<!-- 头部区域 -->
		<div id="h">
			<%@include file="head.jsp" %>
		</div>
		
		<!-- 中间区域 -->
		<div id="m">
			<%@ include file="main.jsp" %>
		</div>
		
		<!-- 脚步区域 -->
		<div id="f">
			<%@ include file="page/common/footer.jsp" %>
		</div>
	
	</div>
</body>
</html>