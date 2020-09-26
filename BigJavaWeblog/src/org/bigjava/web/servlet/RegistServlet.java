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
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;
public class RegistServlet extends HttpServlet {
	UserService userservice = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String token = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
//		
//		request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
//		
//		String code = request.getParameter("code");
//		if(token !=null && token.equalsIgnoreCase(code)){
//			System.out.println("保存到数据库中");
//			response.sendRedirect(request.getContextPath()+"/jstl.jsp");
//		}else {
//			System.out.println("请不要重复提交表单");
//		}
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求编码
		request.setCharacterEncoding("utf-8");

		// 获得前台的用户名和密码
		String usernameString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		String emailString = request.getParameter("email");
		String codeString = request.getParameter("code");
		if ("abcde".equalsIgnoreCase(codeString)) {
			// 检查用户名是否存在
			if (userservice.existsusername(usernameString)) {
				// 不可用]
				System.out.println("用户名[" + usernameString + "]不可用");
				request.getRequestDispatcher("/page/user/register.jsp").forward(request, response);
			} else {
				// 可用
				userservice.register(new User(null, usernameString, passwordString, emailString));
				// 保存登录用户到Session
				request.getSession().setAttribute(BW_Constants.CURRENT_LOGIN_USER, usernameString);
				request.getRequestDispatcher("/index.jsp").forward(request, response);

			}
		} else {
			System.out.println("验证码[" + codeString + "]错误");
			request.getRequestDispatcher("/page/user/register.html").forward(request, response);
		}
	}
	// 校验用户名和密码
//		if ("root".equals(usernameString) &&
//				"123456".equals(passwordString)) {
//			// 保存登录用户到Session
//			request.getSession().setAttribute(BW_Constants.CURRENT_LOGIN_USER, 
//					usernameString);
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//		} else {
//			request.getRequestDispatcher("/page/user/login.html").forward(request, response);
//		}
//		
//	}

}
