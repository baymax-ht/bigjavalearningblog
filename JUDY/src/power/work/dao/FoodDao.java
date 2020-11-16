package power.work.dao;

import power.work.bean.Food;

import java.util.List;

public interface FoodDao {
    public List<Food> queryFoodForList();

    Integer queryTotalFoodCount();

    List<Food> queryPageNoCount(int begin, int pageSize);
    //购物车查询
    List<Food> queryPageNoCount(int begin, int pageSize,Integer user_id);

    void changeCart(Integer user_id,Integer foodid);

    Integer queryCountForCart(Integer user_id);

    void deleteRelation(Integer user_id, Integer foodid);

    Food queryFoodForOne(Integer food_id);

    void updateCartTotalPrice(Integer user_id,Double totalPrice);
}
