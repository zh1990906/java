/**
 * 
 */
package com.market.bean;

/**
 * 
 * @author ZH
 * 上午10:36:14
 */
public class Category {
	private int cid;
	private String cname;
	private int state;
	private int sortNum;
	private String description;
	private String createTime;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getSortNum() {
		return sortNum;
	}
	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Category(String cname, int state, int sortNum, String description, String createTime) {
		super();
		this.cname = cname;
		this.state = state;
		this.sortNum = sortNum;
		this.description = description;
		this.createTime = createTime;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
