/**
 * 
 */
package com.market.service;

import java.util.List;

import com.market.bean.Category;
import com.market.dao.CategoryDao;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 上午10:41:28
 */
public class CategoryService {
	CategoryDao categoryDao = new CategoryDao();
	
	//类别的分页
	public List<Category> queryCategoryByPage(PageUtils pu){
		return categoryDao.queryCategoryByPage(pu);
	}
	
	//查询记录数
	public int queryCategoryCount(){
		return categoryDao.queryCategoryCount();
	}
	
	//类别添加
	public int addCategory(Category c){
		return categoryDao.addCategory(c);
	}
	//根据id删除
	public int deleteShopById(String id){
		return categoryDao.deleteShopById(id);
	}
	
	//根据id查询类别信息
	public Category queryCategoryById(String id) {
		return categoryDao.queryCategoryById(id);
	}
	
	
	//根据id查询类别信息
	public Category userqueryCategoryById(String id,String uid) {
		return categoryDao.userqueryCategoryById(id,uid);
	}
	
	
	//根据id查询类别信息
	public Category userqueryCategoryByIds(String id,String uid) {
		return categoryDao.userqueryCategoryByIds(id,uid);
	}
	
	//修改类别
	public int updateCategory(Category c) {
		return categoryDao.updateCategory(c);
	}
	
	//查询所有
	public List<Category> queryCategory(){
		return categoryDao.queryCategory();
	}
}
