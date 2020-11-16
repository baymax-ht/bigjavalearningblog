package power.work.service;

import power.work.bean.Room;

import java.util.List;

public interface RoomService {
    public Room roomMsg(int roomid);
    public List<Integer> roomPrice();
}
