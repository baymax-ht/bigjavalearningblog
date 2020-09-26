package org.bigjava.bean;

public class Manager {
	private Integer id;
	private String username;
	private Integer likes;
	private Integer reading;
	public Manager() {};
	public Manager(Integer id, String username, Integer likes, Integer reading) {
		super();
		this.id = id;
		this.username = username;
		this.likes = likes;
		this.reading = reading;
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
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public Integer getReading() {
		return reading;
	}
	public void setReading(Integer reading) {
		this.reading = reading;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", username=" + username + ", likes=" + likes + ", reading=" + reading + "]";
	}
	
}
