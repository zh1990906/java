/**
 * 
 */
package com.market.service;

import java.util.List;

import com.market.bean.Category;
import com.market.bean.Product;
import com.market.dao.ProductDao;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 上午10:08:32
 */
public class ProductService {
	ProductDao productDao = new ProductDao();
	CategoryService categoryService = new CategoryService();
	
	
	//分页查询
	public List<Product> queryProductByPage(PageUtils pu){
		List<Product> list = productDao.queryProductByPage(pu);
		
		for(Product p:list){
			//通过cid查询category对象
			Category c = categoryService.queryCategoryById(p.getCid()+"");
			p.setCategory(c);
		}
		return list;
	}
	
	//用户上传分页查询
	public List<Product> userqueryProductByPage(PageUtils pu,String uid){
		List<Product> list = productDao.userqueryProductByPage(pu,uid);
		
		for(Product p:list){
			
			Category c = categoryService.userqueryCategoryById(p.getCid()+"",uid);
			p.setCategory(c);
		}
		return list;
	}
	
	
	//已出售分页查询
	public List<Product> userqueryProductByPages(PageUtils pu,String uid){
		List<Product> list = productDao.userqueryProductByPages(pu,uid);
	
		for(Product p:list){
			
			Category c = categoryService.userqueryCategoryByIds(p.getCid()+"",uid);
			p.setCategory(c);
		}
		return list;
	}
	
	
	
	//查询数量
	public int queryProductCount(){
		return productDao.queryProductCount();
	}
	
	//用户查询记录数
	public int userqueryProductCount(String uid){
		return productDao.userqueryProductCount(uid);
	}
	//用户查询记录数
	public int userqueryProductCounts(String uid){
		return productDao.userqueryProductCounts(uid);
	}
	
	//添加商品
	public int addProduct(Product p){
		return productDao.addProduct(p);
	}
	
	
	public int useraddProduct(Product p,String uid) {
		return productDao.useraddProduct(p,uid);
	}
	
	
	
	//根据id查询商品
	public Product queryProductById(String id){
		return productDao.queryProductById(id);
	}
	
	
	//修改商品信息
	public int updateProduct(Product p){
		return productDao.updateProduct(p);
	}
	
	//根据state查询
	public List<Product> queryProductByLimit(int size,int state){
		System.out.println(size+"  "+state);
		return productDao.queryProductByLimit(size, state);
	}
	
	//根据cid查询
	public List<Product> queryProductByCid(int cid,int size){
		return productDao.queryProductByCid(cid, size);
	}
	public int userdeleteProductByid(String sid) {
		return productDao.userdeleteProductByid(sid);
	}
}
