/**
 * 
 */
package com.market.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.market.bean.Product;
import com.market.utils.JdbcUtils;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 上午10:06:15
 */
public class ProductDao {
	//分页查询
	public List<Product> queryProductByPage(PageUtils pu){
		List<Product> list = null;
		String sql="select * from product limit ?,?";
		try {
			list = JdbcUtils.qr.query(sql, new BeanListHandler<>(Product.class), pu.getStartIndex(),pu.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//用户分页查询
	public List<Product> userqueryProductByPage(PageUtils pu,String uid){
		List<Product> list = null;
		String sql="select * from product WHERE uid = '"+uid+"' limit ?,?";
		try {
			list = JdbcUtils.qr.query(sql, new BeanListHandler<>(Product.class), pu.getStartIndex(),pu.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	//用户分页查询
	public List<Product> userqueryProductByPages(PageUtils pu,String uid){
		List<Product> list = null;
		String sql="select * from sale WHERE seller_uid = '"+uid+"' limit ?,?";
		try {
			list = JdbcUtils.qr.query(sql, new BeanListHandler<>(Product.class), pu.getStartIndex(),pu.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//查询记录数
	public int queryProductCount(){
		Number n = 0;
		String sql="select count(*) from product";
		try {
			n = (Number)JdbcUtils.qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n.intValue();
	}
	
	//用户查询
	public int userqueryProductCount(String uid){
		Number n = 0;
		String sql="select count(*) from product where uid = '"+uid+"'";
		try {
			n = (Number)JdbcUtils.qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n.intValue();
	}
	

	//用户查询
	public int userqueryProductCounts(String uid){
		Number n = 0;
		String sql="select count(*) from sale where seller_uid = '"+uid+"'";
		try {
			n = (Number)JdbcUtils.qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n.intValue();
	}
	
	//查询记录数
	public int addProduct(Product p){
		int n=0;
		String sql="insert into product(cid,pname,price,state,description,createTime,pic)values(?,?,?,?,?,?,?)";
		Object[] params={p.getCid(),p.getPname(),p.getPrice(),p.getState(),p.getDescription(),p.getCreateTime(),p.getPic()};
		try {
			n = JdbcUtils.qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	
	
	
	public int useraddProduct(Product p,String uid){
		int n=0;
		String sql="insert into product(cid,pname,price,state,description,createTime,pic,uid)values(?,?,?,?,?,?,?,'"+uid+"')";
		Object[] params={p.getCid(),p.getPname(),p.getPrice(),p.getState(),p.getDescription(),p.getCreateTime(),p.getPic()};
		try {
			n = JdbcUtils.qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	
	
	
	//id查询
	public Product queryProductById(String id){
		Product p = null;
		String sql="select * from product where pid = ?";
		try {
			p = JdbcUtils.qr.query(sql, new BeanHandler<>(Product.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	//更新商品
	public int updateProduct(Product p){
		int n =0;
		StringBuffer sql=new StringBuffer("update product set cid=?,pname=?,price=?,state=?,"
				+ "description=?,createTime=? ");
		if(p.getPic()!=null){
			sql.append(",pic= '"+p.getPic()+"'");
		}
		sql.append(" where pid=?");
		Object[] params={p.getCid(),p.getPname(),p.getPrice(),p.getState(),p.getDescription(),p.getCreateTime(),p.getPid()};
		try {
			n = JdbcUtils.qr.update(sql.toString(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	//根据state查询
	public List<Product> queryProductByLimit(int size,int state){
		List<Product> list = null;
		String sql="select * from product where state= ? limit ?";
		try {
			list = JdbcUtils.qr.query(sql, new BeanListHandler<>(Product.class),state,size);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//根据cid查询
	public List<Product> queryProductByCid(int cid,int size){
		List<Product> list = null;
		String sql="select * from product where cid= ? limit ?";
		try {
			list = JdbcUtils.qr.query(sql, new BeanListHandler<>(Product.class),cid,size);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int userdeleteProductByid(String pid) {
		int n = 0;
		String sql="delete from product where pid = ?";
		try {
			n =JdbcUtils.qr.update(sql, pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	
}
