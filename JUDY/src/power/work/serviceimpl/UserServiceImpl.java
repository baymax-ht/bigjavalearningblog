package power.work.serviceimpl;

import power.work.bean.Page;
import power.work.bean.User;
import power.work.dao.ManagerDao;
import power.work.dao.UserDao;
import power.work.daoimpl.ManagerDaoImpl;
import power.work.daoimpl.UserDaoImpl;
import power.work.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    private ManagerDao managerDao = new ManagerDaoImpl();
    //注册
    @Override
    public void register(User user) {
        dao.saveUser(user);
    }
    //登录
    @Override
    public User login(User user) {
        return dao.queryUsernameAndPassword(user.getUsername(),user.getPassword());
    }
    //用户名是否存在
    @Override
    public boolean existsusername(String username) {
        if(dao.queryUserName(username)==null){
            System.out.println("用户名可用");
            return false;
        }return true;
    }
    //算钱
    @Override
    public double countMoney(int days,int roomid) {
        double price=0;
        price = dao.queryPrice(roomid);
        return days*price;
    }
    //随机分配房间
    @Override
    public int distributionRoom(int gradeid) {
        return dao.queryDistributionRoom(gradeid);
    }
    //改变房间号
    @Override
    public void changeRoom(int roomid, String username) {
        dao.changeUserRoomStaus(roomid,username);
    }
    //退房
    @Override
    public void checkOutRoom(int room_id) {
        dao.changeRoomStaus(room_id);
    }
    //分页
    @Override
    public Page<User> page(int pageNo, int pageSize) {
        Page<User> page = new Page<User>();
        //设置每页显示数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=dao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount/pageSize;
        if (pageTotalCount % pageSize>0){
            pageTotal+=1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据
        int pageNoBegin = page.getPageNo();
        if (pageNoBegin==0){
            pageNoBegin=1;
        }
        int begin = (pageNoBegin-1)*pageSize;
        List<User> items=dao.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }
    //通过id删除user
    @Override
    public void deleteUserById(int id) {
        dao.delete(id);
    }
    //修改user
    @Override
    public void updateUser(User user) {
        dao.update(user);
    }
    //通过id查询user
    @Override
    public User queryUserById(int id) {
        return dao.queryUser(id);
    }
    //模糊查询分页
    @Override
    public Page<User> selectLike(int pageNo, int pageSize,String username) {
        Page<User> page = new Page<User>();
        //设置每页显示数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=dao.queryForSelectLikeTotalCount(username);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount/pageSize;
        if (pageTotalCount % pageSize>0){
            pageTotal+=1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据
        int pageNoBegin = page.getPageNo();
        if (pageNoBegin==0){
            pageNoBegin=1;
        }
        int begin = (pageNoBegin-1)*pageSize;
        List<User> items=dao.queryListUser(begin,pageSize,username);
        page.setItems(items);
        return page;
    }
    //保存用户的天数和金钱
    @Override
    public void saveRoomContent(String username, int days, double money) {
        dao.saveRoomDaysAndMoney(username,days,money);
    }
    //通过用户名查询用户信息
    @Override
    public User queryUserByName(String username) {
        return (User) dao.queryUserForName(username);
    }

    //查询用户名或身份证号是否为空
    @Override
    public boolean existsUsernameAndIdcard(String username, String idcard) {
        if(dao.queryUsernameAndIdcard(username,idcard)==null){
            //System.out.println("用户名或身份证号不正确");
            return false;
        }else{
            return true;
        }
    }
    //修改密码
    @Override
    public void changePassword(String username, String password) {
        dao.updateUserPassword(username,password);
    }

    @Override
    public boolean existManager(String username) {
        if(managerDao.existManagerName(username)==null){
            return true;
        }else {
            return false;
        }
    }
}