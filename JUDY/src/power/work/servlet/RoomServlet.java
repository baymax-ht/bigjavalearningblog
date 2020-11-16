package power.work.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomServlet extends BaseServlet {
    //传递开房和退房时间
    protected void checkIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String login = (String)req.getSession().getAttribute("CURREN_LOGIN_USER");
        Date now;
        try {
            now = sdf.parse(start);
            Date used = sdf.parse(end);
            String nowTimeString = sdf.format(new Date());
            Date nowTimeDate = sdf.parse(nowTimeString);
            long nowTimeLong = nowTimeDate.getTime()-now.getTime();
            long l = used.getTime() - now.getTime();
            long day = l/(24*60*60*1000);
            int days=(int)day;
            if (l<=0 || start==null || end==null || login==null || nowTimeLong>0) {
                System.out.println("您所选择的时间不合法或登录后才能选择时间！");
                resp.sendRedirect("index.jsp");
            }else {
                req.getSession().setAttribute("start", start);
                req.getSession().setAttribute("end",end);
                req.getRequestDispatcher("/page/room/index.jsp").forward(req, resp);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
