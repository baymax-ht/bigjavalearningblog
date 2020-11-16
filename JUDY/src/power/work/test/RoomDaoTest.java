package power.work.test;

import org.junit.Test;
import power.work.dao.RoomDao;
import power.work.daoimpl.RoomDaoImpl;

public class RoomDaoTest {
    RoomDao dao = new RoomDaoImpl();
    @Test
    public void queryRoom(){
        System.out.println(dao.queryRoom(102));
    }
}
