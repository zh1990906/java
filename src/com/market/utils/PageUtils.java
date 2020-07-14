/**
 * 
 */
package com.market.utils;

/**
 * 
 * @author ZH
 * 上午10:46:33
 */
public class PageUtils {
	/*1.总记录数   2.当前页  3.上一页  4.下一页  5.最大页  6.每一页的起始行的下标 */
	private int rows;//总记录数
	private int curPage;//当前页
	private int prevPage;//上一页
	private int nextPage;//下一页
	private int totalPage;//最大页
	private int startIndex;//每一页起始行下标
	private int pageSize;//页容量
	//给以上的属性进行初始化
	public PageUtils(int rows,String page,int size) {
		this.rows = rows;
		this.pageSize = size;
		initCurPage(page);
		initPrevPage();
		initTotalPage();
		initNextPage();
		initStartIndex();
	}
	//当前页初始化方法
	public void initCurPage(String page){
		if(page==null||page==""){
			this.curPage=1;
		}else{
			this.curPage = Integer.valueOf(page);
		}
	}
	//上一页初始化
	public void initPrevPage(){
		if(this.curPage<=1){
			this.prevPage=1;
		}else{
			this.prevPage = this.curPage-1;
		}
	}
	//下一页初始化
	public void initNextPage(){
		if(this.curPage>=this.totalPage){
			this.nextPage = this.totalPage;
		}else{
			this.nextPage = this.curPage+1;
		}
	}
	//最大页码初始化
	public void initTotalPage(){
		this.totalPage = (this.rows%this.pageSize==0?this.rows/this.pageSize:this.rows/this.pageSize+1);
	}
	//每一页起始行下标的初始化
	public void initStartIndex(){
		this.startIndex = (this.curPage-1)*this.pageSize;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString() {
		return "PageUtils [rows=" + rows + ", curPage=" + curPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage
				+ ", totalPage=" + totalPage + ", startIndex=" + startIndex + ", pageSize=" + pageSize + "]";
	}
	public static void main(String[] args) {
		PageUtils p = new PageUtils(18, "3",5);
		System.out.println(p);
	}
}
