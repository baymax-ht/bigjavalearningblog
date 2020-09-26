package org.bigjava.bean;

import java.util.Date;

public class User {

//	private String address;		// 地址
//	private Date createTime;	// 创建时间
//	private String email;		// 电子邮件
//	private char gender;		// 性别
//	private String hobbys;		// 爱好
//	private long id;			// 用户id
//	private String mobilePhone; // 手机号码
//	private String password;	// 密码
//	private String username;	// 用户名
//	private byte userStatus;	// 用户状态
//	
//	public User() {
//		super();
//	}
//	public User(long id, String username, String password, char gender, String hobbys, String email, String mobilePhone,
//			String address, byte userStatus, Date createTime) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.gender = gender;
//		this.hobbys = hobbys;
//		this.email = email;
//		this.mobilePhone = mobilePhone;
//		this.address = address;
//		this.userStatus = userStatus;
//		this.createTime = createTime;
//	}
//	
//	public String getAddress() {
//		return address;
//	}
//	public Date getCreateTime() {
//		return createTime;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public char getGender() {
//		return gender;
//	}
//	public String getHobbys() {
//		return hobbys;
//	}
//	public long getId() {
//		return id;
//	}
//	public String getMobilePhone() {
//		return mobilePhone;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public byte getUserStatus() {
//		return userStatus;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public void setGender(char gender) {
//		this.gender = gender;
//	}
//	public void setHobbys(String hobbys) {
//		this.hobbys = hobbys;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public void setMobilePhone(String mobilePhone) {
//		this.mobilePhone = mobilePhone;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public void setUserStatus(byte userStatus) {
//		this.userStatus = userStatus;
//	}
//	
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender
//				+ ", hobbys=" + hobbys + ", email=" + email + ", mobilePhone=" + mobilePhone + ", address=" + address
//				+ ", userStatus=" + userStatus + ", createTime=" + createTime + "]";
//	}
	private Integer id;
	private String username;
	private String password;
	private String mail;
	
	public User() {
		super();
	}
	public User(Integer id, String username, String password, String mail) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.mail = mail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", mail=" + mail + "]";
	}
	
}
