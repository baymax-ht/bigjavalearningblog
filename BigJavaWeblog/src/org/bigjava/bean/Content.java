package org.bigjava.bean;

public class Content {
	private Integer id;
	private String username;
	private String reading;
	public Content() {};
	public Content(Integer id, String username,String reading) {
		super();
		this.id = id;
		this.username = username;
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
	public String getReading() {
		return reading;
	}
	public void setReading(String reading) {
		this.reading = reading;
	}
	@Override
	public String toString() {
		return "Content [id=" + id + ", username=" + username + ",  reading=" + reading
				+ "]";
	}
	
	
	

}
