package org.bigjava.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bigjava.bean.Manager;
import org.bigjava.bean.Page;
import org.bigjava.service.ManagerService;
import org.bigjava.service.biz.ManagerServiceImpl;
import org.bigjava.utils.Webutils;

public class ManagerServlet extends BaseServlet{
	private ManagerService managerservice = new ManagerServiceImpl();
	/**
	 * 处理分页功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void page(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1获取请求的参数pageNo,pageSize
		int pageNo = Webutils.parseInt(request.getParameter("pageNo"), 1);
		int pageSize = Webutils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
		//2调用managerservice.page
		Page<Manager> page = managerservice.page(pageNo,pageSize);
		//3page对象存到request域中
		request.setAttribute("page", page);
		//4请求转发
		request.getRequestDispatcher("/page/user/manager.jsp").forward(request, response);
		
	}
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1:获取请求的参数
		 */
		int pageNo = Webutils.parseInt(request.getParameter("pageNo"),0);
		pageNo+=1;
		Manager manager = Webutils.copyParamToBean(request.getParameterMap(), new Manager());
		//2:调用managerservice处理业务
		managerservice.addManager(manager);
		//3:重定向到managerservlet会出现bug
//		request.getRequestDispatcher("/managerservlet?action=list").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/managerservlet?action=page&pageNo="+pageNo);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1获取请求的参数
		int id = Webutils.parseInt(request.getParameter("id"), 0);
		//2调用managerservice.deleteManagerById
		managerservice.deleteManagerById(id);
		//3重定向回manager列表
		response.sendRedirect(request.getContextPath()+"/managerservlet?action=page&pageNo="+request.getParameter("pageNo"));
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1:获取请求的参数封装成Manager对象
		Manager manager = Webutils.copyParamToBean(request.getParameterMap(), new Manager());
		//2:调用ManagerService.updateManager()修改图书
		managerservice.updateManager(manager);
		//3:重定向回manager.jsp
		response.sendRedirect(request.getContextPath()+"/managerservlet?action=page&pageNo="+request.getParameter("pageNo"));
		
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Manager> manager= managerservice.queryManager();
		request.setAttribute("manager", manager);
		request.getRequestDispatcher("/page/user/manager.jsp").forward(request, response);
		
	}
	protected void getManager(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1：获取请求的图书参数
		int id = Webutils.parseInt(request.getParameter("id"), 0);
		//2：调用managerservice.queryManagerById
		Manager manager = managerservice.queryManagerById(id);
		//3:保存到request域中
		request.setAttribute("manager", manager);
		//4请求转发到edit.jsp
		request.getRequestDispatcher("/page/manager/edit.jsp").forward(request, response);
		}
	
}
