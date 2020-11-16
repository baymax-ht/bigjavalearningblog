package power.work.daoimpl;

import power.work.bean.User;
import power.work.dao.BaseDao;
import power.work.dao.UserDao;
import power.work.utils.JDBCUtils;
import power.work.utils.WebUitls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    //判断用户名是否存在
    @Override
    public User queryUserName(String username) {
        String sql = "select * from user where username=?";
        return queryForOne(User.class,sql,username);
    }
//保存用户
    @Override
    public void saveUser(User user) {
        String sql="insert into user(`username`,`password`,`sex`,`phonenumber`,`idcard`)values(?,?,?,?,?)";
        String sqlcart = "insert into cart(`id`,`uid`,`total_price`)values(?,?,0)";
        Connection conn = JDBCUtils.getConnectionOne();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getPhonenumber());
            ps.setString(5,user.getIdcard());
            ps.execute();
            //通过用户名查到用户并取出id
            User user1 = queryUserForName(user.getUsername());
            Integer uid = user1.getUser_id();
            ps = conn.prepareStatement(sqlcart);
            ps.setInt(1,uid);
            ps.setInt(2,uid);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//查询用户名和密码，用作登录
    @Override
    public User queryUsernameAndPassword(String username, String password) {
        String sql = "select `user_id`,`username`,`password`,`phonenumber`,`idcard`,`createtime` from user where binary username=? And password=?";
        return queryForOne(User.class,sql,username,password);
    }
//查询房间价钱
    @Override
    public double queryPrice(int roomid){
        Connection connection = JDBCUtils.getConnectionOne();
        String sql="select rg.price from room r,roomgrade rg where r.grade_id=rg.grade_id and r.room_number=?";
        String price;
        double pricemoney = 0;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,roomid);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
               price=(resultSet.getString("price"));
               pricemoney = Double.parseDouble(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pricemoney;
    }
//随机分配房间
    @Override
    public int queryDistributionRoom(int gradeid) {
        int roomid=0;
        Connection connection = JDBCUtils.getConnectionOne();
        String sql ="select room_number,room_habit from room where grade_id=? and room_habit !='true'";
        String sqlhabit = "update room set room_habit='true' where room_number=?";
        PreparedStatement ps=null;
        List<Integer> linkedList = new LinkedList<Integer>();
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,gradeid);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                //将房间号取出存入list中以便随机分配
                linkedList.add(resultSet.getInt("room_number"));
            }
            //随机分配房间，并将房间的habit属性改为true
            int index = (int)(Math.random()*linkedList.size());
            if (index<0){
                roomid=0;
            }else{
                roomid =linkedList.get(index);
                ps=connection.prepareStatement(sqlhabit);
                ps.setInt(1,roomid);
                ps.execute();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return roomid;
    }
    //改变用户的房间入住号码
    @Override
    public void changeUserRoomStaus(int roomid,String username) {
        Connection connection = JDBCUtils.getConnectionOne();
        String sql = "update user set room_id=?,days=?,money=? where username=?";
        PreparedStatement ps = null;
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,roomid);
            ps.setInt(2,0);
            ps.setDouble(3,0);
            ps.setString(4,username);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //改变房间住房情况
    @Override
    public void changeRoomStaus(int room_id) {
        Connection connection = JDBCUtils.getConnectionOne();
        String sql = "update room set room_habit='false' where room_number=?";
        PreparedStatement ps = null;
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,room_id);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //查询用户总记录数
    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from user";
        Number count = (Number) querySingleValues(sql);
        return count.intValue();
    }
    //查询当前页用户数据
    @Override
    public List<User> queryForPageItems(int begin, int pageSize) {
        String sql = "select `user_id`,`username`,`password`,`sex`,`phonenumber`,`idcard`,`room_id`,`createtime` createtime from user limit ?,?";
        return queryForList(User.class,sql,begin,pageSize);
    }
    //对用户进行增删改
    @Override
    public void delete(int id) {
        String sqlClose = "SET FOREIGN_KEY_CHECKS = 0";
        String sql = "delete from user where user_id=?";
        String sqlOpen = "SET FOREIGN_KEY_CHECKS = 1";
        Connection connection = JDBCUtils.getConnectionOne();
        PreparedStatement ps;
        try {
            ps=connection.prepareStatement(sqlClose);
            ps.execute();
            ps= connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            ps=connection.prepareStatement(sqlOpen);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(User user) {
        String sql = "update user set `username`=?,`password`=?,`sex`=?,`phonenumber`=?,`idcard`=? where `user_id`=?";
       return update(sql,user.getUsername(),user.getPassword(),user.getSex(),user.getPhonenumber(),user.getIdcard(),user.getUser_id());
    }

    @Override
    public User queryUser(int id) {
        String sql = "select `user_id`,`username`,`password`,`sex`,`phonenumber`,`idcard`,`room_id` from user where user_id=? ";
        return queryForOne(User.class,sql,id);
    }
    //模糊查询用户信息
    @Override
    public List<User> queryListUser(int begin,int pageSize,String username) {
        String sql = "select * from user  where username like ? order by username asc limit ?,? ";
        Connection connection = JDBCUtils.getConnectionOne();
        List<User> userList = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,"%"+username+"%");
            ps.setInt(2,begin);
            ps.setInt(3,pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User user = new User(rs.getInt("user_id"),rs.getString("username"),rs.getString("password"),rs.getString("sex"),rs.getString("phonenumber"),rs.getString("idcard"),rs.getInt("room_id"),rs.getDate("createtime"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    //模糊查询总记录数
    @Override
    public Integer queryForSelectLikeTotalCount(String username) {
        String sql = "select count(*) from user  where username like ? order by username asc ";
        int count = 0;
        Connection connection = JDBCUtils.getConnectionOne();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,"%"+username+"%");
            ResultSet rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    //保存用户的开房金额和天数
    @Override
    public void saveRoomDaysAndMoney(String username, int days, double money) {
        String sql = "update user set `days`=?,`money`=? where `username`=?";
        Connection connection = JDBCUtils.getConnectionOne();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,days);
            ps.setDouble(2,money);
            ps.setString(3,username);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //通过用户名查询用户信息
    @Override
    public User queryUserForName(String username) {
        String sql ="select*from user where username=?";
        return queryForOne(User.class,sql,username);
    }
    //查询数据库里的usernameandidcard
    @Override
    public User queryUsernameAndIdcard(String username, String idcard) {
        String sql ="select * from user where username=? And idcard=?";
        return queryForOne(User.class,sql,username,idcard);
    }
    //修改user的密码
    @Override
    public void updateUserPassword(String username, String password) {
        Connection conn = JDBCUtils.getConnectionOne();
        String sql = "update user set password=? where username=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,username);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}