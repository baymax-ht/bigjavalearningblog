package power.work.test;

import org.junit.Test;
import power.work.bean.Manager;
import power.work.dao.ManagerDao;
import power.work.daoimpl.ManagerDaoImpl;

import java.util.List;

public class ManagerDaoTest {
    ManagerDao managerDao = new ManagerDaoImpl();
    @Test
    public void queryListManager(){
        List<Manager> managerList = managerDao.queryListManager();
        for (Manager manager : managerList) {
            System.out.println(manager);
        }
    }
    @Test
    public void managerName(){
        System.out.println(managerDao.existManagerName("admn"));
    }
}
