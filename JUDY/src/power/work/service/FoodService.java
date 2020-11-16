package power.work.service;

import power.work.bean.Food;
import power.work.bean.Page;

import java.util.List;

public interface FoodService {
    public List<Food> queryAllFoods();

    Page<Food> page(int pageNo, int pageSize);
    //购物车分页
    Page<Food> page(int pageNo, int pageSize,Integer user_id);

    void updateCart(Integer user_id,Integer foodid);

    Integer cartCount(Integer user_id);

    void deleteCart(Integer user_id, Integer foodid);

    Food queryFoodsById(Integer food_id);

    void countMoney(Integer user_id,Double totalPrice);
}
