/**
 * 
 */
package com.market.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.market.bean.Category;
import com.market.bean.Product;
import com.market.service.CategoryService;
import com.market.service.ProductService;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 上午10:09:17
 */
@WebServlet("/indexServlet")
public class IndexServlet extends BaseServlet{
	CategoryService categoryService = new CategoryService();
	ProductService productService =new ProductService();
	
	 
	public void queryIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PageUtils pu = new PageUtils(10, "1", 10);
		List<Category> list = categoryService.queryCategoryByPage(pu);
		//全新产品
		List<Product> newproducts = productService.queryProductByLimit(5,0);
		//九成新
		List<Product> nineproducts = productService.queryProductByLimit(5,1);
		//八成新
		List<Product> eightproducts = productService.queryProductByLimit(5,2);
		//五成新
		List<Product> five = productService.queryProductByLimit(5,3);
		//三成新
		List<Product> three = productService.queryProductByLimit(5,4);
		//查询小类别热门产品的4个商品 state=1

		List<Product> goods = productService.queryProductByCid(1,4);
		req.setAttribute("eightproducts", eightproducts);

		req.setAttribute("clist", list);
		req.setAttribute("newproducts", newproducts);
		req.setAttribute("nineproducts", nineproducts);
		req.setAttribute("five", five);
		req.setAttribute("three", three);
		req.setAttribute("goods", goods);
		System.out.println(goods);
		req.getRequestDispatcher("user/index.jsp").forward(req, resp);
		
	}
	
	//用户登录成功之后的跳转
	public void queryIndexover(HttpServletRequest req, HttpServletResponse resp,String username) throws ServletException, IOException {
		//查询前10个类别信息
		PageUtils pu = new PageUtils(10, "1", 10);
		List<Category> list = categoryService.queryCategoryByPage(pu);
		//全新产品
		List<Product> newproducts = productService.queryProductByLimit(5,0);
		//九成新
		List<Product> nineproducts = productService.queryProductByLimit(5,1);
		//八成新
		List<Product> eightproducts = productService.queryProductByLimit(5,2);
		//五成新
		List<Product> five = productService.queryProductByLimit(5,3);
		//三成新
		List<Product> three = productService.queryProductByLimit(5,4);
		//查询小类别热门产品的4个商品 state=1
		List<Product> goods = productService.queryProductByCid(1,4);
		System.out.println(five);
		req.setAttribute("eightproducts", eightproducts);
		req.setAttribute("goods", goods);
		req.setAttribute("clist", list);
		req.setAttribute("newproducts", newproducts);
		req.setAttribute("nineproducts", nineproducts);
		req.setAttribute("five", five);
		req.setAttribute("three", three);
		req.setAttribute("username", username);
		System.out.println(goods);
		req.getRequestDispatcher("user/index.jsp").forward(req, resp);
	}
}
