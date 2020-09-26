<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 4+1 -->
	<%!
		//获取总页数
		public int getcountpage(int pageTotalCount,int pageSize){
		int pageTotal = 0;
		pageTotal=(pageTotalCount % pageSize ==0)?(pageTotalCount / pageSize):(pageTotalCount/pageSize+1);
		return pageTotal;
	}
	%>
	<%
		//4个参数
		int pageNo = 1;
		int pageSize = 3;
		int pageTotal;
		int pageTotalCount=0;
		//pageToatalCount总记录数
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bigjava19", "root", "123456");
		
		String querysql ="select count(*) from user";
		PreparedStatement pStatement = conn.prepareStatement(querysql);
		ResultSet rs=pStatement.executeQuery();
		if(rs.next()){
			pageTotalCount = rs.getInt(1);
		}
		pageTotal = getcountpage(pageTotalCount, pageSize);
		
		String pageNoString = request.getParameter("pageNo");
		//判断
		if(pageNoString==null){
			pageNoString="1";
		}
		pageNo = Integer.parseInt(pageNoString);
		if(pageNo<=0){
			pageNo=1;
		}
		if(pageNo>pageTotal){
			pageNo = pageTotal;
		}
		
		int begin = pageSize*(pageNo-1);
		int ending = pageSize;
		//limit两个参数
		String limitsql = "select * from user limit ?,?";
		pStatement = conn.prepareStatement(limitsql);
		pStatement.setInt(1, begin);
		pStatement.setInt(2, ending);
		rs= pStatement.executeQuery();
		while(rs.next()){
			out.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getString(3) +"\t"+ rs.getString(4) +"<br />");
		}
		rs.close();
		pStatement.close();
		conn.close();
	%>
	<a href="News.jsp?pageNo=1">首页</a>&nbsp;
	 	  <a href="News.jsp?pageNo=<%= pageNo-1%>">上一页</a>
		  <a href="News.jsp?pageNo=<%= pageNo+1%>">下一页</a>
		  <a href="News.jsp?pageNo=<%=pageTotal%>">末页</a>
</body>
</html>