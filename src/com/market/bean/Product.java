/**
 * 
 */
package com.market.bean;

/**
 * 
 * @author ZH
 * 上午10:36:30
 */
public class Product {
	private int pid;
	private int cid;
	private String pname;
	private double price;
	private String description;
	private String pic;
	private int state;
	private String createTime;
	private Category category;//临时属性
	private String uid=null; //上传人id
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Product() {
	}
	public Product(int cid, String pname, double price, String description, String pic, int state, String createTime) {
		super();
		this.cid = cid;
		this.pname = pname;
		this.price = price;
		this.description = description;
		this.pic = pic;
		this.state = state;
		this.createTime = createTime;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", cid=" + cid + ", pname=" + pname + ", price=" + price + ", description="
				+ description + ", pic=" + pic + ", state=" + state + ", createTime=" + createTime + "]";
	}
	
}
