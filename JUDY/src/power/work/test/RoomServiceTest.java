package power.work.test;

import org.junit.Test;
import power.work.service.RoomService;
import power.work.serviceimpl.RoomServiceImpl;

public class RoomServiceTest {
    RoomService roomService = new RoomServiceImpl();
    @Test
    public void RoomMsg(){
        System.out.println(roomService.roomMsg(103));
    }
}
