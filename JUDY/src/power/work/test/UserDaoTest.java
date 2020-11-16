package power.work.test;

import org.junit.Test;
import power.work.bean.Page;
import power.work.bean.User;
import power.work.dao.UserDao;
import power.work.daoimpl.UserDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUsername(){
//        if (userDao.queryUserName("admin")==null){
//            System.out.println("用户名可用");
//        }else {
//            System.out.println("用户名已存在不可用");
//        }
        System.out.println(userDao.queryUserName("admin"));
    }
    @Test
    public void saveUser(){
        userDao.saveUser(new User(29,"admin12345789","admin","女","12313213","12315125"));
    }
    @Test
    public void queryUsernameAndPassword(){
        if (userDao.queryUsernameAndPassword("admin","admin")==null){
            System.out.println("抱歉您的用户名或密码错误");
        }else {
            System.out.println("欢迎登录");
        }
    }
    @Test
    public void queryRoom(){
        try {
            System.out.println(userDao.queryPrice(306));;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void queryDistributionRoom(){
        int roomid = userDao.queryDistributionRoom(5);
        System.out.println(roomid);
    }
    @Test
    public void changeUserRoomStaus(){
        userDao.changeUserRoomStaus(0,"admin");
    }
    @Test
    public void changRoomStaus(){
        userDao.changeRoomStaus(210);
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(userDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (User user : userDao.queryForPageItems(2, Page.PAGE_SIZE)) {
            System.out.println(user);
        }
    }
    @Test
    public void delete() {
        userDao.delete(5);
    }
    @Test
    public void update() {
        userDao.update(new User(12,"admin_hong","admin","男","12313216","12315126"));
    }


    @Test
    public void queryUser(){
        List<User> userList=userDao.queryListUser(0,4,"admin");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }
    @Test
    public void queryUserSelectLikeUser(){
        System.out.println(userDao.queryForSelectLikeTotalCount("1234"));
    }
    @Test
    public void saveUserDaysAndMoney(){
        userDao.saveRoomDaysAndMoney("admin",1,70);
    }
    @Test
    public void queryUserForName(){
        System.out.println(userDao.queryUserForName("admin"));
    }
    //测试查询用户名和idcard
    @Test
    public void queryUserNameAndidcard(){
        System.out.println(userDao.queryUsernameAndIdcard("admin","23562359913"));
    }
    //修改密码
    @Test
    public void changePassword(){
       userDao.updateUserPassword("admin","adminnnn");
    }
}
