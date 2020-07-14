package com.market.web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.bean.Category;
import com.market.bean.Product;
import com.market.bean.Sale;
import com.market.service.CategoryService;
import com.market.service.ProductService;
import com.market.service.SaleService;
import com.market.utils.DateUtils;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 下午4:38:07
 */
@WebServlet("/usersellServlet")
public class UsersellServlet extends BaseServlet{
	ProductService productService = new ProductService();
	CategoryService categoryService = new CategoryService();
	SaleService saleService = new SaleService();
	
	//点击跳转
	public void commoditydetails(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String pid = req.getParameter("pid");
		String uid = req.getParameter("uid");
		System.out.println(uid);
		if(uid == "")
		{//此时没有登录需要登录才可以
			resp.sendRedirect("user/login.jsp");
		}
		else
		{
			Product product = productService.queryProductById(pid);
			List<Category> clist = categoryService.queryCategory();
			req.setAttribute("clist", clist);
			req.setAttribute("p", product);
			req.setAttribute("uid", uid);
			req.setAttribute("d", DateUtils.strToDate(product.getCreateTime()));
			req.getRequestDispatcher("sale/usersale.jsp").forward(req, resp);
		}
		
	}
	//购买
	public void saleByid(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String pid = req.getParameter("pid");
		String uid = req.getParameter("uid");
		
		//购买就是删除 并且更新一下购买的人即可
		//调用product表的删除操作
		int n = productService.userdeleteProductByid(pid);
		if(n>0) {
			//购买成功
			//更新一下购买表
			saleService.updateSale(uid, pid);
			IndexServlet indexServlet = new IndexServlet();
			indexServlet.queryIndexover(req, resp, uid);
			
		}
		else {
			resp.getWriter().print("商品购买失败");
		}
		
	}
	
	
	//已出售
	public void soldByid(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String uid = req.getParameter("uid");
		String curPage = req.getParameter("curPage");
		//去数据库查询数据
		int rows = productService.userqueryProductCounts(uid);
		PageUtils pu = new PageUtils(rows, curPage,5);
		List<Product> list = productService.userqueryProductByPages(pu,uid);
		req.setAttribute("list",list);
		req.setAttribute("pageUtils",pu);
		req.setAttribute("uid",uid);
		System.out.println(uid);
		req.getRequestDispatcher("usersell/usersell_sold.jsp").forward(req, resp);
		
	}
	
	
	
	//删除已出售
	public void userselldeleteProductByid(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String uid = req.getParameter("uid");
		String pic = req.getParameter("pic");
		System.out.println(pic);
		int n = saleService.userselldeleteProductByid(pic);
		if(n>0){
			String curPage = req.getParameter("curPage");
			//去数据库查询数据
			int rows = productService.userqueryProductCounts(uid);
			PageUtils pu = new PageUtils(rows, curPage,5);
			List<Product> list = productService.userqueryProductByPages(pu,uid);
			req.setAttribute("list",list);
			req.setAttribute("pageUtils",pu);
			req.setAttribute("uid",uid);
			System.out.println(uid);
			req.getRequestDispatcher("usersell/usersell_sold.jsp").forward(req, resp);
		}else{
			resp.getWriter().print("删除失败!");
		}
	}

}
