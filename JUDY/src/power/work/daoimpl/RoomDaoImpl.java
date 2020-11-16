package power.work.daoimpl;

import power.work.bean.Room;
import power.work.dao.BaseDao;
import power.work.dao.RoomDao;

import java.util.List;

public class RoomDaoImpl extends BaseDao implements RoomDao{
    @Override
    public Room queryRoom(int roomid) {
        String sql = "select*from room where room_number=?";
        return queryForOne(Room.class,sql,roomid);
    }

    @Override
    public List<Room> queryRoomList() {
        String sql = "select*from room r,roomgrade rg where r.grade_id=rg.grade_id";
        return null;
    }
}
