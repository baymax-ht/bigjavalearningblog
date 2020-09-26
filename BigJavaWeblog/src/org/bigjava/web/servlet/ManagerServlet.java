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
	 * �����ҳ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void page(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1��ȡ����Ĳ���pageNo,pageSize
		int pageNo = Webutils.parseInt(request.getParameter("pageNo"), 1);
		int pageSize = Webutils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
		//2����managerservice.page
		Page<Manager> page = managerservice.page(pageNo,pageSize);
		//3page����浽request����
		request.setAttribute("page", page);
		//4����ת��
		request.getRequestDispatcher("/page/user/manager.jsp").forward(request, response);
		
	}
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1:��ȡ����Ĳ���
		 */
		int pageNo = Webutils.parseInt(request.getParameter("pageNo"),0);
		pageNo+=1;
		Manager manager = Webutils.copyParamToBean(request.getParameterMap(), new Manager());
		//2:����managerservice����ҵ��
		managerservice.addManager(manager);
		//3:�ض���managerservlet�����bug
//		request.getRequestDispatcher("/managerservlet?action=list").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/managerservlet?action=page&pageNo="+pageNo);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1��ȡ����Ĳ���
		int id = Webutils.parseInt(request.getParameter("id"), 0);
		//2����managerservice.deleteManagerById
		managerservice.deleteManagerById(id);
		//3�ض����manager�б�
		response.sendRedirect(request.getContextPath()+"/managerservlet?action=page&pageNo="+request.getParameter("pageNo"));
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1:��ȡ����Ĳ�����װ��Manager����
		Manager manager = Webutils.copyParamToBean(request.getParameterMap(), new Manager());
		//2:����ManagerService.updateManager()�޸�ͼ��
		managerservice.updateManager(manager);
		//3:�ض����manager.jsp
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
		//1����ȡ�����ͼ�����
		int id = Webutils.parseInt(request.getParameter("id"), 0);
		//2������managerservice.queryManagerById
		Manager manager = managerservice.queryManagerById(id);
		//3:���浽request����
		request.setAttribute("manager", manager);
		//4����ת����edit.jsp
		request.getRequestDispatcher("/page/manager/edit.jsp").forward(request, response);
		}
	
}
