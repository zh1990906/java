/**
 * 
 */
package com.market.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.market.bean.Category;
import com.sun.org.apache.regexp.internal.recompile;
import com.market.utils.JdbcUtils;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 上午10:36:49
 */
public class CategoryDao {
	/**
	 * 
	 * @param pu
	 * @return
	 */
	public List<Category> queryCategoryByPage(PageUtils pu){
		List<Category> list = null;
		String sql="select * from category limit ?,?";
		try {
			list = JdbcUtils.qr.query(sql, new BeanListHandler<>(Category.class), pu.getStartIndex(),pu.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//查询记录数量
	public int queryCategoryCount(){
		Number n = 0;
		String sql="select count(*) from category";
		try {
			n = (Number)JdbcUtils.qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n.intValue();
	}
	
	
	//添加类
	public int addCategory(Category c){
		int n = 0;
		String sql="insert into category(cname,state,sortNum,description,createTime)values(?,?,?,?,?)";
		Object[] params = {c.getCname(),c.getState(),c.getSortNum(),c.getDescription(),c.getCreateTime()};
		try {
			n = JdbcUtils.qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	
	//根据id删除用户信息
	public int deleteShopById(String id){
		int n = 0;
		String sql="delete from category where cid = ?";
		try {
			n =JdbcUtils.qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	
	//根据id查询信息
	public Category queryCategoryById(String id) {
		Category c = null;
		String sql = "select * from category where cid = ?";
		
		try {
			c = JdbcUtils.qr.query(sql, new BeanHandler<>(Category.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	
	
	//用户查询自己信息
		public Category userqueryCategoryById(String id,String uid) {
			Category c = null;
			String sql = "select * from category where cid = ? ";
			
			try {
				c = JdbcUtils.qr.query(sql, new BeanHandler<>(Category.class),id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;
		}
	
		
		//用户查询自己信息
			public Category userqueryCategoryByIds(String id,String uid) {
				Category c = null;
				String sql = "select * from sale where seller_uid = ? ";
				
				try {
					c = JdbcUtils.qr.query(sql, new BeanHandler<>(Category.class),uid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return c;
			}
		
		
	//修改类别
	public int updateCategory(Category c) {
		int n = 0;
		String sql = "update category set cname = ?,state = ?,sortNum = ?,createTime=?,description=? where cid = ?";
		Object[] params = {c.getCname(),c.getState(),c.getSortNum(),c.getCreateTime(),c.getDescription(),c.getCid()};
		try {
			n = JdbcUtils.qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	
	
	//查询所有类别
	public List<Category> queryCategory(){
		List<Category> list = null;
		String sql="select * from category";
		try {
			list = JdbcUtils.qr.query(sql, new BeanListHandler<>(Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
