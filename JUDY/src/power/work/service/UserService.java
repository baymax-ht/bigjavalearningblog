package power.work.service;

import power.work.bean.Page;
import power.work.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 注册
     * @param user
     */
    public void register(User user);
    /**
     * 登录
     * @param user
     */
    public User login(User user);
    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean existsusername(String username);

    public double countMoney(int days,int roomid);

    public int distributionRoom(int gradeid);
    public void changeRoom(int roomid,String username);

    public void checkOutRoom(int room_id);

    Page<User> page(int pageNo, int pageSize);

    public void deleteUserById(int id);

    public void updateUser(User user);

    public User queryUserById(int id);

    Page<User> selectLike(int pageNo, int pageSize,String username);

    void saveRoomContent(String username, int days, double money);

    public User queryUserByName(String username);
    //忘记密码，判断用户名或身份证号不为空
    boolean existsUsernameAndIdcard(String username, String idcard);

    void changePassword(String username, String password);

    boolean existManager(String username);
}
