package power.work.bean;

public class Room {
    Integer id;
    Integer room_nubmer;
    String room_habit;
    Integer grade_id;
    public Room(){}

    public Room(Integer id, Integer room_nubmer, String room_habit, Integer grade_id) {
        this.id = id;
        this.room_nubmer = room_nubmer;
        this.room_habit = room_habit;
        this.grade_id = grade_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom_nubmer() {
        return room_nubmer;
    }

    public void setRoom_nubmer(Integer room_nubmer) {
        this.room_nubmer = room_nubmer;
    }

    public String getRoom_habit() {
        return room_habit;
    }

    public void setRoom_habit(String room_habit) {
        this.room_habit = room_habit;
    }

    public Integer getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Integer grade_id) {
        this.grade_id = grade_id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", room_nubmer=" + room_nubmer +
                ", room_habit='" + room_habit + '\'' +
                ", grade_id=" + grade_id +
                '}';
    }
}
