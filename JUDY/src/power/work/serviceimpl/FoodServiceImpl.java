package power.work.serviceimpl;

import power.work.bean.Food;
import power.work.bean.Page;
import power.work.dao.FoodDao;
import power.work.daoimpl.FoodDaoImpl;
import power.work.service.FoodService;

import java.util.List;

public class FoodServiceImpl implements FoodService {
    FoodDao foodDao = new FoodDaoImpl();
    @Override
    public List<Food> queryAllFoods() {
        return foodDao.queryFoodForList();
    }
    //分页
    @Override
    public Page<Food> page(int pageNo, int pageSize) {
        //设置四个参数
        Page<Food> foodPage = new Page<Food>();
        //设置每页显示数量
        foodPage.setPageSize(pageSize);
        //1:获取和设置总记录数
        Integer pageTotalCount = foodDao.queryTotalFoodCount();
        foodPage.setPageTotalCount(pageTotalCount);
        //2：获取和设置总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize>0){
            pageTotal+=1;
        }
        foodPage.setPageTotal(pageTotal);
        foodPage.setPageNo(pageNo);
        //3:获取当前页数据
        int pageNoBegin = foodPage.getPageNo();
        if (pageNoBegin==0){
            pageNoBegin=1;
        }
        int begin = (pageNoBegin-1)*pageSize;
        List<Food> foodList= foodDao.queryPageNoCount(begin,pageSize);
        foodPage.setItems(foodList);
        return foodPage;
    }

    @Override
    public Page<Food> page(int pageNo, int pageSize, Integer user_id) {
        //设置四个参数
        Page<Food> foodPage = new Page<Food>();
        //设置每页显示数量
        foodPage.setPageSize(pageSize);
        //1:获取和设置总记录数
        Integer pageTotalCount = foodDao.queryCountForCart(user_id);
        foodPage.setPageTotalCount(pageTotalCount);
        //2：获取和设置总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize>0){
            pageTotal+=1;
        }
        foodPage.setPageTotal(pageTotal);
        foodPage.setPageNo(pageNo);
        //3:获取当前页数据
        int pageNoBegin = foodPage.getPageNo();
        if (pageNoBegin==0){
            pageNoBegin=1;
        }
        int begin = (pageNoBegin-1)*pageSize;
        List<Food> foodList= foodDao.queryPageNoCount(begin,pageSize,user_id);
        foodPage.setItems(foodList);
        return foodPage;
    }

    //修改购物车信息
    @Override
    public void updateCart(Integer user_id,Integer foodid) {
        foodDao.changeCart(user_id,foodid);
    }
    //购物车里的商品数
    @Override
    public Integer cartCount(Integer user_id) {
        return foodDao.queryCountForCart(user_id);
    }

    //删除购物车
    @Override
    public void deleteCart(Integer user_id, Integer foodid) {
        foodDao.deleteRelation(user_id,foodid);
    }
    //单独查询一种食物
    @Override
    public Food queryFoodsById(Integer food_id) {
        return foodDao.queryFoodForOne(food_id);
    }
    //计算金额并且修改cart表中的中金额，可供回显
    @Override
    public void countMoney(Integer user_id,Double totalPrice) {
        foodDao.updateCartTotalPrice(user_id,totalPrice);
    }
}
