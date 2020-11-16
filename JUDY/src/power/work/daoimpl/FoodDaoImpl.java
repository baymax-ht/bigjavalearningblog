package power.work.daoimpl;

import power.work.bean.Food;
import power.work.dao.BaseDao;
import power.work.dao.FoodDao;
import power.work.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FoodDaoImpl extends BaseDao implements FoodDao {
    //查询所有的食物消息
    @Override
    public List<Food> queryFoodForList() {
        String sql = "select `id`,`name`,`price`,`imagepath` from foods";
        return queryForList(Food.class,sql);
    }
    //查询总食物数
    @Override
    public Integer queryTotalFoodCount() {
        String sql = "select count(*) from foods";
        Number count = (Number)querySingleValues(sql);
        return count.intValue();
    }
    //查询寻当前页数据
    @Override
    public List<Food> queryPageNoCount(int begin, int pageSize) {
       String sql = "select `id`,`name`,`price`,`imagepath` imagepath from foods limit ?,?";
        return queryForList(Food.class,sql,begin,pageSize);
    }
    //分页查询购物车
    @Override
    public List<Food> queryPageNoCount(int begin, int pageSize, Integer user_id) {
        String sql = "select f.id,f.name,f.price,f.imagepath,r.quantity quantity from `foods` f,`cart` c,`relation` r,`user` u where r.cid = c.id and r.fid = f.id and u.user_id = c.uid and u.user_id =? limit ?,? ";
        return queryForList(Food.class,sql,user_id,begin,pageSize);
    }

    //改变购物车信息
    @Override
    public void changeCart( Integer user_id,Integer foodid) {
        Connection connection = JDBCUtils.getConnectionOne();
        PreparedStatement ps;
        //查询
        String sqlexistfid = "select * from relation where cid=? and fid=? ";
        String sql = "insert into relation (`cid`,`fid`,`quantity`)values(?,?,1)";
        try {
            ps = connection.prepareStatement(sqlexistfid);
            ps.setInt(1,user_id);
            ps.setInt(2,foodid);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                System.out.println("商品已存在购物车中请勿重复添加");
            }else{
                ps = connection.prepareStatement(sql);
                ps.setInt(1,user_id);
                ps.setInt(2,foodid);
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //查询购物车的数量
    @Override
    public Integer queryCountForCart(Integer user_id) {
        String sql = "select count(*) from relation where cid=?";
        Number carCount = (Number)querySingleValues(sql,user_id);
        return carCount.intValue();
    }
    //删除购物车
    @Override
    public void deleteRelation(Integer user_id, Integer foodid) {
        Connection conn = JDBCUtils.getConnectionOne();
        String sql = "delete from relation where cid=? and fid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,user_id);
            ps.setInt(2,foodid);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //查询中食物
    @Override
    public Food queryFoodForOne(Integer food_id) {
        String sql = "select * from foods where id=?";
        return queryForOne(Food.class,sql,food_id);
    }
    //修改cart表中的totalPrice用于回显
    @Override
    public void updateCartTotalPrice(Integer user_id,Double totalPrice) {
        Connection conn = JDBCUtils.getConnectionOne();
        String sql = "update cart set total_price=total_price+? where uid=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1,totalPrice);
            ps.setInt(2,user_id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
