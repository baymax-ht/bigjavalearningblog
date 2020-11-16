package power.work.dao;

import power.work.bean.Room;

import java.util.List;

public interface RoomDao {
    public Room queryRoom(int roomid);

    List<Room> queryRoomList();
}
