package power.work.test;

import org.junit.Test;
import power.work.bean.Manager;
import power.work.service.ManagerService;

import java.util.List;

public class ManagerServiceImpl {
    ManagerService managerService = new power.work.serviceimpl.ManagerServiceImpl();
    @Test
    public void queryListForMnager(){
        List<Manager> managers = managerService.queryListForManager();
        for (Manager manager : managers) {
            System.out.println(manager);
        }
    }
}
