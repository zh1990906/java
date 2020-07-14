package com.market.bean;

public class Sale {
	private int sid;
	private int pid;
	private int cid;
	private String pname;
	private double price;
	private String description;
	private String pic;
	private int state;
	private String createTime;
	private Category category;//临时属性
	private String seller_uid=null; //上传人id
	private String buy_uid;
	
	
	
	
	public Sale(int pid, int cid, String pname, double price, String description, String pic, int state,
			String createTime, String seller_uid, String buy_uid) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.pname = pname;
		this.price = price;
		this.description = description;
		this.pic = pic;
		this.state = state;
		this.createTime = createTime;
		this.seller_uid = seller_uid;
		this.buy_uid = buy_uid;
	}


	public int getSid() {
		return sid;
	}
	
	
	public void setSid(int sid) {
		this.sid = sid;
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
	public String getSeller_uid() {
		return seller_uid;
	}
	public void setSeller_uid(String seller_uid) {
		this.seller_uid = seller_uid;
	}
	public String getBuy_uid() {
		return buy_uid;
	}
	public void setBuy_uid(String buy_uid) {
		this.buy_uid = buy_uid;
	}
	@Override
	public String toString() {
		return "Sale [pid=" + pid + ", cid=" + cid + ", pname=" + pname + ", price=" + price + ", description="
				+ description + ", pic=" + pic + ", state=" + state + ", createTime=" + createTime + ", category="
				+ category + ", seller_uid=" + seller_uid + ", buy_uid=" + buy_uid + "]";
	}
	
}
