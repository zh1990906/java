/**
 * 
 */
package com.market.bean;

/**
 * 
 * @author ZH
 * 上午10:36:39
 */
public class User {
	private int uid;//用户编号
	private String uname;//真实姓名
	private int sex;//性别
	private String tel;//电话
	private String area;//地区
	private String username;//用户名
	private String password;//密码
	private String email;//密码
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String uname, int sex, String tel, String area, String username, String password) {
		super();
		this.uname = uname;
		this.sex = sex;
		this.tel = tel;
		this.area = area;
		this.username = username;
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", sex=" + sex + ", tel=" + tel + ", area=" + area
				+ ", username=" + username + ", password=" + password + "]";
	}
	
}
