package com.market.service;

import java.util.List;

import org.apache.catalina.LifecycleListener;

import com.market.bean.Category;
import com.market.bean.Product;
import com.market.bean.Sale;
import com.market.dao.SaleDao;
import com.market.utils.PageUtils;

public class SaleService {
	
	Category category = new Category();
	CategoryService categoryService = new CategoryService();
	
	//更新买家
	SaleDao saleDao = new SaleDao();
	public int updateSale(String buy_uid,String pid) {
		int n = 0;
		n = saleDao.updateSale(buy_uid, pid);
		return n;
	}
	
	//查询数量
	public int usersellNum(String uid) {
		return saleDao.usersellNum(uid);
	}
	
	//查询已出售的个人信息
	public Category usersellqueryCategoryById(String uid) {
		return saleDao.usersellqueryCategoryById(uid);
	}
	
	public List<Sale> usersellqueryProductByPage(PageUtils pu,String uid) {
		List<Sale> list = saleDao.usersellqueryProductByPage(pu,uid);
		for(Sale s:list){
			//通过cid查询category对象
			Category c = categoryService.queryCategoryById(s.getCid()+"");
			s.setCategory(c);
		}
		return list;
		
	}
	
	public int userselldeleteProductByid(String pic) {
		return saleDao.userselldeleteProductByid(pic);
	}
}
