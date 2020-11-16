package power.work.test;

import org.junit.Test;
import power.work.bean.Food;
import power.work.bean.Page;
import power.work.service.FoodService;
import power.work.serviceimpl.FoodServiceImpl;

import java.util.List;

public class FoodServiceTest {
    FoodService service = new FoodServiceImpl();
    @Test
    public void queryListFood(){
        List<Food> foodList=service.queryAllFoods();
        for (Food food : foodList) {
            System.out.println(food);
        }
    }
    @Test
    public void queryPage(){
        System.out.println(service.page(1,4));
    }
    //修改relation关系表
    @Test
    public void changeCart(){
        service.updateCart(1,3);
    }
    //查询购物车数量
    @Test
    public void cartCount(){
        System.out.println(service.cartCount(2));
    }
    //删除购物车
    @Test
    public void deleteCart(){
        service.deleteCart(34,2);
    }
    //查询一种食物
    @Test
    public void queryFoodForId(){
        Food food = service.queryFoodsById(2);
        System.out.println(food);
    }
    /**
     * 修改购物车表中的totalprice
     */
    @Test
    public void countMoney(){
        service.countMoney(1,(double)0);
    }
}
