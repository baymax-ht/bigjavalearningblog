package power.work.servlet;

import org.junit.Test;
import power.work.bean.User;
import power.work.service.UserService;
import power.work.serviceimpl.UserServiceImpl;
import power.work.utils.BW_Constants;
import power.work.utils.WebUitls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    //登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginuser = userService.login(new User(null, username, password, null,null,null));
        if (loginuser == null) {
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            System.out.println("用户名或密码错误");
            request.getRequestDispatcher("/page/user/loandre.jsp").forward(request, response);
        } else {
            System.out.println("登录成功");
            request.getSession().setAttribute(BW_Constants.CURRENT_LOGIN_USER, username);
            queryUserForName(request,response);
            request.getRequestDispatcher("managerServlet?action=queryListManager").forward(request,response);
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
    //登出
    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("utf-8");
        // 获得前台的用户名和密码
        String usernameString = req.getParameter("username");
        String passwordString = req.getParameter("password");
        String sexString = req.getParameter("sex");
        String phoneString = req.getParameter("phonenumber");
        String idcardString = req.getParameter("idcard");
        String sex;
        if ("male".equals(sexString)){
            sex = "男";
    }else {
        sex = "女";
    }
        //User user = WebUitls.copyParamToBean(req.getParameterMap(), new User());
        // 检查用户名是否存在
        if (userService.existsusername(usernameString)) {
            // 不可用]
            req.setAttribute("remsg", "用户名已存在！");
            req.setAttribute("username", usernameString);
            System.out.println("用户名[" + usernameString + "]不可用");
            req.getRequestDispatcher("/page/user/loandre.jsp").forward(req, resp);
        } else {
            // 可用
            userService.register(new User(null,usernameString,passwordString,sex,phoneString,idcardString));
            // 保存登录用户到Session
            req.getSession().setAttribute(BW_Constants.CURRENT_LOGIN_USER, usernameString);
            req.getRequestDispatcher("managerServlet?action=queryListManager").forward(req,resp);
        }
    }
    //开房
    protected void openRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,ParseException {
        //获取checkIn时间和checkOut时间
        String start = (String) req.getSession().getAttribute("start");
        String end = (String) req.getSession().getAttribute("end");
        String username = (String) req.getSession().getAttribute("CURREN_LOGIN_USER");
        System.out.println(username);
        int gradeid=WebUitls.parseInt(req.getParameter("grade_id"),0);
        if (gradeid==0||username==null){
            resp.sendRedirect("/JUDY/page/room/index.jsp");
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date now = sdf.parse(start);
            Date used = sdf.parse(end);
            long l = used.getTime() - now.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            int days = (int) day;
            int roomid = userService.distributionRoom(gradeid);
            System.out.println("roomid："+roomid);
            if (roomid==0){
                System.out.println("抱歉选择的房间已满");
                resp.sendRedirect("/JUDY/page/room/index.jsp");
            }else{
                userService.changeRoom(roomid,username);
                double money = userService.countMoney(days, roomid);
                userService.saveRoomContent(username,days,money);
                queryUserForName(req,resp);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }

        }
    }
    //退房
    protected void checkOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据username和room_id判断用户退房的房间，并销毁session
        String username = (String) req.getSession().getAttribute("CURREN_LOGIN_USER");
        User user= (User)req.getSession().getAttribute("user");
        int roomid = user.getRoom_id();
        System.out.println("room_id"+roomid);
        userService.changeRoom(0,username);
        userService.checkOutRoom(roomid);
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");
    }
    //房间信息回显
    protected void queryUserForName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("CURREN_LOGIN_USER");
        User user = userService.queryUserByName(username);
        req.getSession().setAttribute("user",user);
    }
    protected void existUsernameAndIdCard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String idcard = req.getParameter("idcard");
        if (username==null && idcard==null){
            resp.sendRedirect("page/user/forget.jsp");
        }else{
            if (userService.existManager(username)==false){
                System.out.println("用户名为管理员不可更改密码");
                resp.sendRedirect("page/user/forget.jsp");
            }else if(userService.existsUsernameAndIdcard(username,idcard)){
                req.getSession().setAttribute("username",username);
                req.getRequestDispatcher("page/user/changePassword.jsp").forward(req,resp);
            }else{
                resp.sendRedirect("page/user/forget.jsp");
            }
        }
    }
    protected void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        String password = req.getParameter("password");
        if (username==null && password==null){
            resp.sendRedirect("page/user/changePassword.jsp");
        }else{
            userService.changePassword(username,password);
            req.getSession().invalidate();
            req.getRequestDispatcher("page/user/loandre.jsp").forward(req,resp);
        }
    }
}

