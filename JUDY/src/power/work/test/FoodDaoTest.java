package power.work.test;

import org.junit.Test;
import power.work.bean.Food;
import power.work.dao.FoodDao;
import power.work.daoimpl.FoodDaoImpl;

import java.util.List;

public class FoodDaoTest {
    FoodDao foodDao = new FoodDaoImpl();
    //查询所有食物
    @Test
    public void queryAllFood(){
        List<Food> foodList = foodDao.queryFoodForList();
        for (Food food : foodList) {
            System.out.println(food);
        }
    }
    //查询食物总记录数
    @Test
    public void TotalCountFoods(){
        System.out.println(foodDao.queryTotalFoodCount());
    }
    //查询当前页数据
    @Test
    public void pageNoCount(){
        List<Food> foodList = foodDao.queryPageNoCount(0,4);
        for (Food food : foodList) {
            System.out.println(food);
        }
    }
    //修改添加到购物车
    @Test
    public void addCart(){
        foodDao.changeCart(1,4);
    }
    //修改购物车数量
    @Test
    public void queryCart(){
        System.out.println(foodDao.queryCountForCart(1));
    }
    //查询购物车
    @Test
    public void pageNoCountCart(){
        List<Food> foodList = foodDao.queryPageNoCount(0, 2, 1);
        for (Food food : foodList) {
            System.out.println(food);
        }
    }
    //删除购物车
    @Test
    public void deleteCart(){
        foodDao.deleteRelation(34,3);
    }
    /**
     * 查询一种食物的所有信息
     */
    @Test
    public void queryFoodForOne(){
        Food food = foodDao.queryFoodForOne(2);
        System.out.println(food.toString());
    }
    /**
     * 修改cart的总金额
     */
    @Test
    public void updateTotalPrice(){
        foodDao.updateCartTotalPrice(1, (double)100);
    }
}
