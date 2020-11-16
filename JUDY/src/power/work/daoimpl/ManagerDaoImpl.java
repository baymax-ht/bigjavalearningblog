package power.work.daoimpl;

import power.work.bean.Manager;
import power.work.dao.BaseDao;
import power.work.dao.ManagerDao;

import java.util.List;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {
    @Override
    public List<Manager> queryListManager() {
        String sql = "select * from manager";
        return queryForList(Manager.class,sql);
    }

    @Override
    public Manager existManagerName(String username) {
        String sql ="select * from manager where name=?";
        return queryForOne(Manager.class,sql,username);
    }
}
