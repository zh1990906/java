package com.market.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.market.bean.Category;
import com.market.bean.Product;
import com.market.bean.Sale;
import com.market.utils.JdbcUtils;
import com.market.utils.PageUtils;

public class SaleDao {
	
	//更新买家
	public int updateSale(String buy_uid,String pid){
		int n =0;
		String sql="update sale set buy_uid=? where pid = ?";
		
		
		try {
			n = JdbcUtils.qr.update(sql,buy_uid,pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	//查询数量 
	public int usersellNum(String uid){
		Number n = 0;
		String sql="select count(*) from sale where seller_uid = '"+uid+"'";
		try {
			n = (Number)JdbcUtils.qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n.intValue();
	}
	
	//用户查询自己的信息
	public Category usersellqueryCategoryById( String uid) {
		Category c = null;
		String sql = "select * from sale where seller_uid= ?";
		
		try {
			c = JdbcUtils.qr.query(sql, new BeanHandler<>(Category.class),uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return c;
	}
	
	//出售商品的分页查询
	public List<Sale> usersellqueryProductByPage(PageUtils pu,String uid){
		List<Sale> list = null;
		String sql="select * from sale WHERE seller_uid = '"+uid+"' limit ?,?";
		try {
			list = JdbcUtils.qr.query(sql, new BeanListHandler<>(Sale.class), pu.getStartIndex(),pu.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//删除已出售
	public int userselldeleteProductByid(String pic) {
		int n = 0;
		String sql="delete from sale where pic = ?";
		try {
			n =JdbcUtils.qr.update(sql, pic);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
}
