package org.bigjava.web.servlet;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.bigjava.bean.User;
import org.bigjava.constant.BW_Constants;
import org.bigjava.service.UserService;
import org.bigjava.service.biz.UserServiceImpl;
import org.bigjava.utils.Webutils;

public class UsersServlet extends BaseServlet {
	private UserService userservice = new UserServiceImpl();
	
	protected void autoComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String keywordString = request.getParameter("keyword");
		StringBuffer stringBuffer = new StringBuffer();
		List<String> list = userservice.autoSearch(keywordString);
		if (list.isEmpty()) {
			out.print("");
		}else {
			for (int i = 0; i < list.size(); i++) {
				if (i==list.size()-1) {
					stringBuffer.append(list.get(i));
				}else {
					stringBuffer.append(list.get(i)).append(",");
				}
			}
			out.print(stringBuffer.toString());
			
		}
		System.out.println("stringbuffer��ֵ"+stringBuffer);
		
	}
	protected void loginAjax(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		User ajaxUser = userservice.login(new User(null,username,password,null));
		System.out.println(ajaxUser);
		if (ajaxUser == null) {
			response.getWriter().write("false");
		}else {
			request.getSession().setAttribute("ajaxUser", ajaxUser);
			response.getWriter().write("true");
			
		}
	}
	protected void validateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		if(userservice.existsusername(username)) {
			response.getWriter().write("true");
		
		}else {
			response.getWriter().write("false");
		}
	}
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath());

	}
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User loginuser = userservice.login(new User(null, username, password, null));
		if (loginuser == null) {
			request.setAttribute("msg", "�û������������");
			request.setAttribute("username", username);
			System.out.println("�û������������");
			request.getRequestDispatcher("/page/user/login.jsp").forward(request, response);
		} else {
			System.out.println("��¼�ɹ�");
			request.getSession().setAttribute(BW_Constants.CURRENT_LOGIN_USER, username);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������
		String token = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
		
		request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
		
		request.setCharacterEncoding("utf-8");

		// ���ǰ̨���û���������
		String usernameString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		String emailString = request.getParameter("email");
		String codeString = request.getParameter("code");

		User user = Webutils.copyParamToBean(request.getParameterMap(), new User());
		if (token !=null &&token.equalsIgnoreCase(codeString)) {
			// ����û����Ƿ����
			if (userservice.existsusername(usernameString)) {
				// ������]
				request.setAttribute("msg", "�û����Ѵ��ڣ�");
				request.setAttribute("username", usernameString);
				request.setAttribute("email", emailString);
				System.out.println("�û���[" + usernameString + "]������");
				request.getRequestDispatcher("/page/user/register.jsp").forward(request, response);
			} else {
				// ����
				userservice.register(new User(null, usernameString, passwordString, emailString));
				// �����¼�û���Session
				request.getSession().setAttribute(BW_Constants.CURRENT_LOGIN_USER, usernameString);
				request.getRequestDispatcher("/index.jsp").forward(request, response);

			}
		} else {
			request.setAttribute("msg", "��֤�����");
			request.setAttribute("username", usernameString);
			request.setAttribute("email", emailString);
			System.out.println("��֤��[" + codeString + "]����");
			request.getRequestDispatcher("/page/user/register.jsp").forward(request, response);
		}
	}

}
