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
//			System.out.println("���浽���ݿ���");
//			response.sendRedirect(request.getContextPath()+"/jstl.jsp");
//		}else {
//			System.out.println("�벻Ҫ�ظ��ύ��");
//		}
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �����������
		request.setCharacterEncoding("utf-8");

		// ���ǰ̨���û���������
		String usernameString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		String emailString = request.getParameter("email");
		String codeString = request.getParameter("code");
		if ("abcde".equalsIgnoreCase(codeString)) {
			// ����û����Ƿ����
			if (userservice.existsusername(usernameString)) {
				// ������]
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
			System.out.println("��֤��[" + codeString + "]����");
			request.getRequestDispatcher("/page/user/register.html").forward(request, response);
		}
	}
	// У���û���������
//		if ("root".equals(usernameString) &&
//				"123456".equals(passwordString)) {
//			// �����¼�û���Session
//			request.getSession().setAttribute(BW_Constants.CURRENT_LOGIN_USER, 
//					usernameString);
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//		} else {
//			request.getRequestDispatcher("/page/user/login.html").forward(request, response);
//		}
//		
//	}

}
