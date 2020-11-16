package power.work.servlet;

import power.work.bean.Manager;
import power.work.bean.Page;
import power.work.bean.User;
import power.work.service.ManagerService;
import power.work.service.UserService;
import power.work.serviceimpl.ManagerServiceImpl;
import power.work.serviceimpl.UserServiceImpl;
import power.work.utils.BW_Constants;
import power.work.utils.WebUitls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManagerServlet extends BaseServlet {
    ManagerService managerService = new ManagerServiceImpl();
    UserService userService = new UserServiceImpl();
    //删除用户
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：获取请求的参数
        int id = WebUitls.parseInt(req.getParameter("id"),0);
        userService.deleteUserById(id);
        resp.sendRedirect(req.getContextPath()+"/managerServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }
    //修改用户信息
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2:获得前台的用户名和密码
        int id = WebUitls.parseInt(req.getParameter("id"),0);
        String usernameString = req.getParameter("username");
        System.out.println("username"+usernameString);
        String passwordString = req.getParameter("password");
        String sexString = req.getParameter("sex");
        String phoneString = req.getParameter("phonenumber");
        String idcardString = req.getParameter("idcard");
        String sex;
        if ("man".equals(sexString)){
            sex = "男";
        }else {
            sex = "女";
        }

        userService.updateUser(new User(id,usernameString,passwordString,sex,phoneString,idcardString));
        resp.sendRedirect(req.getContextPath()+"/managerServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }
    //添加用户
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1:获取请求的参数
        System.out.println("这里是添加用户");
        int pageNo = WebUitls.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        //2:获得前台的用户名和密码
        String usernameString = req.getParameter("username");
        System.out.println("username"+usernameString);
        String passwordString = req.getParameter("password");
        String sexString = req.getParameter("sex");
        String phoneString = req.getParameter("phonenumber");
        String idcardString = req.getParameter("idcard");
        String sex;
        if ("man".equals(sexString)){
            sex = "男";
        }else {
            sex = "女";
        }
        // 检查用户名是否存在
        if (userService.existsusername(usernameString)) {
            // 不可用]
            req.setAttribute("remsg", "用户名已存在！");
            System.out.println("用户名[" + usernameString + "]不可用");
            req.getRequestDispatcher("/page/admin/edit.jsp").forward(req, resp);
        } else {
            // 可用
            userService.register(new User(usernameString,passwordString,sex,phoneString,idcardString));
           resp.sendRedirect(req.getContextPath()+"/managerServlet?action=page&pageNo="+pageNo);
        }

    }
    //用户查询
    protected void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("content");
        //1：获取请求的参数pageNo和pageSize
        int pageNo = WebUitls.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUitls.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        if (username==null){
            resp.sendRedirect(req.getContextPath()+"/managerServlet?action=page&pageNo="+pageNo);
        }else {
            //2:获取page对象
            Page<User> page = userService.selectLike(pageNo, pageSize, username);
            //3：保存到request域中
            req.setAttribute("page", page);
            //4:请求转发到page/admin/manager.jsp中
            req.getRequestDispatcher("page/admin/manager.jsp").forward(req, resp);
        }
    }
    //分页处理
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1：获取请求的参数pageNo和pageSize
        int pageNo = WebUitls.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUitls.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2:调用user的page(pageNo,pageSize)获得的page对象
        Page<User> page = userService.page(pageNo,pageSize);
        //3:保存page对象到request域中
        req.setAttribute("page",page);
        //4:请求转发到page/admin/manager.jsp页面
        req.getRequestDispatcher("page/admin/manager.jsp").forward(req,resp);
    }
    //通过id查询用户
    protected void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUitls.parseInt(req.getParameter("id"),0);
        User user = userService.queryUserById(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/page/admin/edit.jsp").forward(req, resp);
    }
    //查询管理员
    protected void queryListManager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manager> managerList = managerService.queryListForManager();
        req.getSession().setAttribute("manager",managerList);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
