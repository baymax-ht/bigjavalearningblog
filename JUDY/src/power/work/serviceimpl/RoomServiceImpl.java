package power.work.serviceimpl;

import power.work.bean.Room;
import power.work.dao.RoomDao;
import power.work.daoimpl.RoomDaoImpl;
import power.work.service.RoomService;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    RoomDao roomDao = new RoomDaoImpl();
    @Override
    public Room roomMsg(int roomid) {
        return roomDao.queryRoom(roomid);
    }

    @Override
    public List<Integer> roomPrice() {
        List<Integer> priceList = new ArrayList<Integer>();
        List<Room> roomList = roomDao.queryRoomList();
        return priceList;
    }
}
