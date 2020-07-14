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

import com.market.bean.Category;
import com.market.bean.Product;
import com.market.service.CategoryService;
import com.market.service.ProductService;
import com.market.utils.DateUtils;
import com.market.utils.FileUploadUtils;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 上午10:11:24
 */
@WebServlet("/productServlet")
public class ProductServlet extends BaseServlet{
	ProductService productService = new ProductService();
	CategoryService categoryService = new CategoryService();
	
	public void queryProductByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String curPage = req.getParameter("curPage");
		int rows = productService.queryProductCount();
		PageUtils pu = new PageUtils(rows, curPage,5);
		List<Product> list = productService.queryProductByPage(pu);
		req.setAttribute("list",list);
		req.setAttribute("pageUtils",pu);
		req.getRequestDispatcher("product/product_list.jsp").forward(req, resp);
	}
	
	
	//普通用户的分页查询
	public void userqueryProductByPage(HttpServletRequest req, HttpServletResponse resp ,String uid) throws ServletException, IOException {
		String curPage = req.getParameter("curPage");
		int rows = productService.userqueryProductCount(uid);
		PageUtils pu = new PageUtils(rows, curPage,5);
		List<Product> list = productService.userqueryProductByPage(pu,uid);
		req.setAttribute("list",list);
		req.setAttribute("pageUtils",pu);
		req.setAttribute("uid",uid);
		System.out.println(uid);
		req.getRequestDispatcher("usersell/usersell_list.jsp").forward(req, resp);
	}
	public void usernewqueryProductByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String curPage = req.getParameter("curPage");
		String uid = req.getParameter("uid");
		int rows = productService.userqueryProductCount(uid);
		PageUtils pu = new PageUtils(rows, curPage,5);
		List<Product> list = productService.userqueryProductByPage(pu,uid);
		req.setAttribute("list",list);
		req.setAttribute("pageUtils",pu);
		req.setAttribute("uid",uid);
		System.out.println(uid);
		req.getRequestDispatcher("usersell/usersell_list.jsp").forward(req, resp);
	}
	
	
	//商品添加跳转
	public void addProductUI(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		List<Category> clist = categoryService.queryCategory();
		req.setAttribute("clist", clist);
		req.getRequestDispatcher("product/product_add.jsp").forward(req, resp);
	}
	
	
	//用户添加商品跳转
	public void useraddProductUI(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		List<Category> clist = categoryService.queryCategory();
		req.setAttribute("clist", clist);
		String uid = req.getParameter("uid");
		
		
		System.out.println(uid+"123");
		req.setAttribute("uid", uid);
		req.getRequestDispatcher("usersell/usersell_add.jsp").forward(req, resp);
	}
	
	
	
	//商品添加
	public void addProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//获取页面表单的数据
		String title=java.net.URLDecoder.decode(req.getParameter("title"),"UTF-8");
		Map<String, String> map = FileUploadUtils.upload(req, resp);
		Product p = new Product();
		BeanUtils.populate(p, map);
		int n = productService.addProduct(p);
		if(n>0){
			//商品添加成功
			queryProductByPage(req,resp);
		}else{
			resp.getWriter().print("商品添加失败");
		}
	}
	
	
	//用户添加出售的商品
	public void useraddProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//获取页面表单的数据
		Map<String, String> map = FileUploadUtils.upload(req, resp);
		String uid = req.getParameter("uid");;
		//System.out.println(uid+"99999999");
		//map.put(req.getParameterValues("uid"), "uid");
		Product p = new Product();
		BeanUtils.populate(p, map);
		int n = productService.useraddProduct(p,uid);
		if(n>0){
			//商品添加成功
			
			resp.getWriter().print("添加成功");
			String path = req.getContextPath();
			System.out.println(path);
			resp.sendRedirect(path+"/usersell/login.jsp");
		}else{
			resp.getWriter().print("商品添加失败");
		}
	}
	
	
	
	
	//修改界面
	public void updateProductUI(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String pid = req.getParameter("pid");
		Product product = productService.queryProductById(pid);
		List<Category> clist = categoryService.queryCategory();
		req.setAttribute("clist", clist);
		req.setAttribute("p", product);
		req.setAttribute("d", DateUtils.strToDate(product.getCreateTime()));
		req.getRequestDispatcher("product/product_update.jsp").forward(req, resp);
	}
	
	//用户修改信息
	public void userupdateProductUI(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String pid = req.getParameter("pid");
		String uid = req.getParameter("uid");
		Product product = productService.queryProductById(pid);
		List<Category> clist = categoryService.queryCategory();
		req.setAttribute("clist", clist);
		req.setAttribute("p", product);
		req.setAttribute("uid", uid);
		req.setAttribute("d", DateUtils.strToDate(product.getCreateTime()));
		req.getRequestDispatcher("usersell/usersell_update.jsp").forward(req, resp);
	}
	
	
	//修改商品信息
	public void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Map<String, String> map = FileUploadUtils.upload(req, resp);
		Product p = new Product();
		BeanUtils.populate(p, map);
		int n = productService.updateProduct(p);
		if(n>0){
			//修改成功
			queryProductByPage(req,resp);
		}else{
			//修改失败
			resp.getWriter().print("商品修改失败");
		}
	}
	
	//用户修改产品
	public void userupdateProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Map<String, String> map = FileUploadUtils.upload(req, resp);
		String uid = req.getParameter("uid");
		Product p = new Product();
		BeanUtils.populate(p, map);
		int n = productService.updateProduct(p);
		if(n>0){
			//修改成功
			userqueryProductByPage(req,resp,uid);
		}else{
			//修改失败
			resp.getWriter().print("商品修改失败");
		}
	}
	
	
	//删除
	public void userdeleteProductByid(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String uid = req.getParameter("uid");
		String pid = req.getParameter("pid");
		int n = productService.userdeleteProductByid(pid);
		if(n>0){
			//删除成功
			userqueryProductByPage(req, resp, uid);
		}else{
			resp.getWriter().print("删除失败!");
		}
	}
	//批量删除
	public void userbatchDeleteByid(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String uid = req.getParameter("uid");
		String[] ids= req.getParameterValues("pid");
		System.out.println(uid);
		for(int i = 0 ; i < ids.length;i++) {
			System.out.println(ids[i]);
		}
		for(String pid:ids){
			productService.userdeleteProductByid(pid);
		}
		userqueryProductByPage(req, resp, uid);
		
	}
	
	
	//管理员批量删除
	public void adminbatchDeleteByid(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String[] ids= req.getParameterValues("pid");
		for(String pid:ids){
			productService.userdeleteProductByid(pid); //偷懒 直接用普通用户的方式删除 或者说是删除的统一模式
		}
		queryProductByPage(req, resp);
		
	}
	//管理员删除
	public void admindeleteProductByid(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String pid = req.getParameter("pid");
		int n = productService.userdeleteProductByid(pid);
		if(n>0){
			//删除成功
			queryProductByPage(req, resp);
		}else{
			resp.getWriter().print("删除失败!");
		}
	}
	
	
	
	//查询已出售
	public void usersellqueryProductByPage(HttpServletRequest req, HttpServletResponse resp ,String uid) throws ServletException, IOException {
		String curPage = req.getParameter("curPage");
		int rows = productService.userqueryProductCount(uid);
		PageUtils pu = new PageUtils(rows, curPage,5);
		List<Product> list = productService.userqueryProductByPage(pu,uid);
		req.setAttribute("list",list);
		req.setAttribute("pageUtils",pu);
		req.setAttribute("uid",uid);
		System.out.println(uid);
		req.getRequestDispatcher("usersell/usersell_list.jsp").forward(req, resp);
	}
	
}
