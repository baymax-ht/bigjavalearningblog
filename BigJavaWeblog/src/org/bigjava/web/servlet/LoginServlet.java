package org.bigjava.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bigjava.bean.User;
import org.bigjava.constant.BW_Constants;
import org.bigjava.service.UserService;
import org.bigjava.service.biz.UserServiceImpl;

public class LoginServlet extends HttpServlet{
	private UserService userservice = new UserServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User loginuser = userservice.login(new User(null,username,password,null));
		if(loginuser==null) {
			System.out.println("用户名或密码错误");
			request.getRequestDispatcher("/page/user/login.jsp").forward(request, response);
		}else {
			System.out.println("登录成功");
			request.getSession().setAttribute(BW_Constants.CURRENT_LOGIN_USER, 
					username);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
