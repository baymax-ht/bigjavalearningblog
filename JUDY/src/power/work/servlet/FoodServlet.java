package power.work.servlet;

import power.work.bean.Food;
import power.work.bean.Page;
import power.work.bean.User;
import power.work.service.FoodService;
import power.work.service.UserService;
import power.work.serviceimpl.FoodServiceImpl;
import power.work.serviceimpl.UserServiceImpl;
import power.work.utils.WebUitls;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FoodServlet extends BaseServlet {
    private FoodService foodService = new FoodServiceImpl();
    private UserService userService = new UserServiceImpl();
    protected void ListAllFoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> foodList = foodService.queryAllFoods();
        req.getSession().setAttribute("food",foodList);
        req.getRequestDispatcher("page/food/index.jsp").forward(req,resp);
    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("CURREN_LOGIN_USER");
        if(username==null){
            resp.sendRedirect("index.jsp");
            return;
        }
        User user = userService.queryUserByName(username);
        Integer user_id = user.getUser_id();
        int cartCount = foodService.cartCount(user_id);
        req.setAttribute("cartCount",cartCount);
        //1：获取请求的参数pageNo和pageSize
        int pageNo = WebUitls.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUitls.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2:调用user的page(pageNo,pageSize)获得的page对象
        Page<Food> page = foodService.page(pageNo,pageSize);
        //3:保存page对象到request域中
        req.setAttribute("page",page);
        System.out.println("cartCount"+req.getAttribute("cartCount"));
//        //4:请求转发到page/admin/manager.jsp页面
        req.getRequestDispatcher("page/food/index.jsp").forward(req,resp);
    }
    protected void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String food_id = req.getParameter("food_id");
        if (username == null || food_id==null) {
            resp.sendRedirect("index.jsp");
        }else{
            //购物车与商品之间的关系，求cartid，cartid是由userid查找，quantity自动加一
            Integer foodid = WebUitls.parseInt(food_id,1);
            User user = userService.queryUserByName(username);
            Integer user_id = user.getUser_id();
            foodService.updateCart(user_id,foodid);
            req.getRequestDispatcher("foodServlet?action=page").forward(req,resp);
        }
    }
    //购物车回显
    protected void cartView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //用户id，购物车id,通过id查询具体的购物车细节
        //获取用户id
        String username = (String) req.getSession().getAttribute("CURREN_LOGIN_USER");
        User user = userService.queryUserByName(username);
        Integer user_id = user.getUser_id();
        //通过用户id遍历购物车内的东西
        //1：获取请求的参数pageNo和pageSize
        int pageNo = WebUitls.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUitls.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2:调用user的page(pageNo,pageSize)获得的page对象
        Page<Food> pageCart = foodService.page(pageNo,pageSize,user_id);
        //3:保存page对象到request域中
        req.setAttribute("pageCart",pageCart);
//        //4:请求转发到page/admin/manager.jsp页面
        req.getRequestDispatcher("page/food/cartCount.jsp").forward(req,resp);
    }
    protected void deleteCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //删除购物车需要哪些参数，userid，foodid
        //获取用户id
        String username = (String) req.getSession().getAttribute("CURREN_LOGIN_USER");
        User user = userService.queryUserByName(username);
        Integer user_id = user.getUser_id();
        //获取从前台传来的foodid
        String food_id = req.getParameter("foodid");
        Integer foodid = WebUitls.parseInt(food_id,1);
        foodService.deleteCart(user_id,foodid);
        resp.sendRedirect(req.getContextPath()+"/foodServlet?action=cartView&pageNo=1");
    }
    protected void countCartMoney(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //结算金钱需要的参数，fid，uid,quantity,price,name,
        //获取用户id
        String username = (String) req.getSession().getAttribute("CURREN_LOGIN_USER");
        User user = userService.queryUserByName(username);
        Integer user_id = user.getUser_id();
        //获取食物的id
        String foodid = req.getParameter("food_id");
        Integer food_id = WebUitls.parseInt(foodid,1);
        Food food = foodService.queryFoodsById(food_id);
        Double singlePrice = food.getPrice();
        String quantity = req.getParameter("quantity");
        Integer much = WebUitls.parseInt(quantity,1);
        Double totalPrice = much * singlePrice;
        //算钱成功后修改购物车表的totalPrice
        /**
         * 修改cart中表的信息需要哪些参数，只需要uid
         */
        foodService.countMoney(user_id,totalPrice);
        //然后把relation表中的这条记录进行删除
        foodService.deleteCart(user_id,food_id);
        req.getRequestDispatcher("/foodServlet?action=cartView&pageNo=1").forward(req,resp);
    }
}
