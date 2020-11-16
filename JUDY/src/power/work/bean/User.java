package power.work.bean;

import java.util.Date;

public class User {
    public Integer user_id;
    public String username;
    public String password;
    public String sex;
    public String phonenumber;
    public String idcard;
    public Integer room_id;
    public Date createtime;
    public Integer days;
    public double money;

    public User() {
    }
    public User(String username, String password, String sex, String phonenumber, String idcard) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phonenumber = phonenumber;
        this.idcard = idcard;
    }
    public User(Integer user_id, String username, String password, String sex, String phonenumber, String idcard) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phonenumber = phonenumber;
        this.idcard = idcard;
    }

    public User(Integer user_id, String username, String password, String sex, String phonenumber, String idcard, Integer room_id, Date createtime) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phonenumber = phonenumber;
        this.idcard = idcard;
        this.room_id = room_id;
        this.createtime = createtime;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", idcard='" + idcard + '\'' +
                ", room_id=" + room_id +
                ", createtime=" + createtime +
                ", days=" + days +
                ", money=" + money +
                '}';
    }
}
