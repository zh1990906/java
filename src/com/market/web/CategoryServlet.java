/**
 * 
 */
package com.market.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import com.sun.java.swing.plaf.windows.WindowsBorders.DashedBorder;
import com.market.bean.Category;
import com.market.service.CategoryService;
import com.market.utils.DateUtils;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 上午10:47:25
 */
@WebServlet("/categoryServlet")
public class CategoryServlet extends BaseServlet{
	CategoryService categoryService = new CategoryService();
	
	//类别查询
	public void queryCategoryByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取当前页
		String curPage = req.getParameter("curPage");
		//获取总记录数
		int rows = categoryService.queryCategoryCount();
		PageUtils pu = new PageUtils(rows, curPage,5);
		List<Category> list = categoryService.queryCategoryByPage(pu);
		req.setAttribute("list",list);
		req.setAttribute("pageUtils",pu);
		req.getRequestDispatcher("category/category_list.jsp").forward(req, resp);
	}
	
	
	//添加类
	public void addCategory(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//获取添加页面的所有数据
		Map<String, String[]> map = req.getParameterMap();
		Category c = new Category();
		//将页面的数据映射到对象的属性中
		BeanUtils.populate(c, map);
		//将数据添加到数据库
		int n = categoryService.addCategory(c);
		if(n>0){
			//添加成功-->查询界面
			queryCategoryByPage(req,resp);
		}else{
			resp.getWriter().print("添加类别失败");
		}
	}
	/**
	 * 根据id删除用户信息
	 */
	public void deleteShopById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//获取id值
		String cid = req.getParameter("cid");
		int n = categoryService.deleteShopById(cid);
		if(n>0){
			//删除成功
			queryCategoryByPage(req,resp);
		}else{
			resp.getWriter().print("删除失败!");
		}
	}
	/*
	 * 批量删除
	 * */
	public void batchDeleteShop(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String[] ids = req.getParameterValues("cid");
		for(String cid:ids){
			categoryService.deleteShopById(cid);
		}
		queryCategoryByPage(req,resp);
	}
	
	//到修改界面
	public void updateCategoryUI(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String cid = req.getParameter("cid");
		Category c = categoryService.queryCategoryById(cid);
		req.setAttribute("c", c);
		req.setAttribute("d", DateUtils.strToDate(c.getCreateTime()));
		req.getRequestDispatcher("category/category_update.jsp").forward(req, resp);
	}
	public void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map<String, String[]> map = req.getParameterMap();
		Category c = new Category();
		BeanUtils.populate(c, map);
		int n = categoryService.updateCategory(c);
		if(n>0) {
			queryCategoryByPage(req, resp);
		}
		else {
			resp.getWriter().print("修改失败");
		}
	}
}
