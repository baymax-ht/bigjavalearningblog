package power.work.dao;

import power.work.bean.User;

import java.util.List;

public interface UserDao{
    /**
     * 查询用户信息
     * @param username
     * @return
     */
    public User queryUserName(String username);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public void saveUser(User user);

    /**
     * 登录操作
     */
    public User queryUsernameAndPassword(String username, String password);

    public double queryPrice(int roomid);

    public int queryDistributionRoom(int gradeid);
    public void changeUserRoomStaus(int roomid,String username);

    public void changeRoomStaus(int room_id);

    Integer queryForPageTotalCount();

    List<User> queryForPageItems(int begin, int pageSize);

    public void delete(int id);

    public int update(User user);

    public User queryUser(int id);

    List<User> queryListUser(int begin,int pageSize,String username);

    Integer queryForSelectLikeTotalCount(String username);

    void saveRoomDaysAndMoney(String username, int days, double money);

    Object queryUserForName(String username);
    //通过用户名，身份证号查询
    User queryUsernameAndIdcard(String username, String idcard);

    void updateUserPassword(String username, String password);
}
