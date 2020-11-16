package power.work.test;

import org.junit.Test;
import power.work.bean.Page;
import power.work.bean.User;
import power.work.service.UserService;
import power.work.serviceimpl.UserServiceImpl;

import java.util.List;

public class UserServiceTest {
    private UserService userService = new UserServiceImpl();
    @Test
    public void register(){
        userService.register(new User(null,"admin1234","admin","女","12313213","12315125"));
    }
    @Test
    public void login(){
        System.out.println(userService.login(new User(null,"admin1234","admin",null,null,null)));
    }
    @Test
    public void existUsername(){
        if(userService.existsusername("hong")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
    @Test
    public void countMoney(){
        System.out.println(userService.countMoney(3,206));
    }
    @Test
    public void distribution(){
        userService.distributionRoom(1);
    }
    @Test
    public void changeRoom(){
        userService.changeRoom(0,"admin");
    }
    @Test
    public void changeRoomHabit(){
        userService.checkOutRoom(210);
    }
    @Test
    public void page(){
        System.out.println(userService.page(1, Page.PAGE_SIZE));
    }
    @Test
    public void deleteById(){
        userService.deleteUserById(6);
    }
    @Test
    public void saveDaysAndMoney(){
        userService.saveRoomContent("admin",0,0);
    }
    @Test
    public void queryUserByName(){
        System.out.println(userService.queryUserByName("admin"));
    }
    @Test
    public void queryUserNameIdcard(){

        System.out.println(userService.existsUsernameAndIdcard("admin","23562359913"));
    }
    @Test
    public void changePassword(){
        userService.changePassword("admin","admin");
    }
    @Test
    public void existManager(){
        System.out.println(userService.existManager("admn"));
    }
}
