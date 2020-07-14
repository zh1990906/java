/**
 * 
 */
package com.market.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.beans.BeansUtils;
import com.mchange.v2.codegen.bean.BeangenUtils;
import com.market.bean.User;
import com.market.service.UserService;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 上午10:49:22
 */
@WebServlet("/userServlet")
public class UserServlet extends BaseServlet{
	UserService userService = new UserService();
	
	//注册
	public void userRegister(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1.获取页面数据
		Map<String, String[]> map = req.getParameterMap();
		User user = new User();
		BeanUtils.populate(user, map);//将存储在map中的页面数据，映射到user对象中
		int n = userService.addUser(user);
		if(n>0){
			//添加成功
			resp.sendRedirect("user/login.jsp");
		}else{
			//添加失败
			resp.getWriter().print("添加失败");
		}
	}
	
	//手机号是否被注册
	public void queryUserByTel(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1.获取页面的手机号
		String tel = req.getParameter("tel");
		boolean flag = userService.queryUserByTel(tel);
		resp.getWriter().print(flag);//服务器给页面响应
	}
	
	//用户名是否被注册
	public void queryUserByName(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1.获取页面的账号
		String username = req.getParameter("username");
		boolean flag = userService.queryUserByName(username);
		resp.getWriter().print(flag);//服务器给页面响应
	}
	
	
	//邮箱是否被注册
	public void queryUserByEmail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1.获取页面的账号
		String email = req.getParameter("email");
		boolean flag = userService.queryUserByEmail(email);
		resp.getWriter().print(flag);//服务器给页面响应
	}
	
	
	//登录
	public void userLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//获取页面发送的用户名和密码
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		User user = userService.userLogin(username, pwd);
		if(user==null){
			//登录失败-->给一个错误的提示信息
			req.setAttribute("msg", "用户名或者密码错误");//将错误信息存放到request对象作用域
			req.getRequestDispatcher("user/login.jsp").forward(req, resp);
		}else{
			//登录成功-->首页
			System.out.println(username);
			/*
			req.setAttribute("username", username);
			req.getRequestDispatcher("user/index.jsp").forward(req, resp);*/
			IndexServlet indexServlet = new IndexServlet();
			indexServlet.queryIndexover(req, resp, username);
		}
	}
	
	//出售登录
	public void userLogintwo(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//获取页面发送的用户名和密码
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		User user = userService.userLogin(username, pwd);
		if(user==null){
			//登录失败
			req.getRequestDispatcher("usersell/login.jsp").forward(req, resp);
		}else{
			//登录成功-->首页
			
			
			
			ProductServlet productServlet = new ProductServlet();
			System.out.println(username);
			productServlet.userqueryProductByPage(req, resp, username);
		}
	}
	
	public void usernewLogintwo(HttpServletRequest req, HttpServletResponse resp,String uid) throws Exception {
		//获取页面发送的用户名和密码
		ProductServlet productServlet = new ProductServlet();
		productServlet.userqueryProductByPage(req, resp, uid);
	}
	
	
	//管理员登录   admin666 666666
	public void adminLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//获取页面的数据-->用户名和密码
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		HttpSession session = req.getSession();
		if("admin666".equals(name)&&"666666".equals(pwd)){
			//登录成功--->进入后台首页
			
			session.setAttribute("user", name);
			resp.sendRedirect("admin/main.jsp");
		}else{
			//继续登录
			resp.sendRedirect("admin/login.jsp");
		}
	}
	
	
	//查询所有信息
	public void queryUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<User> list = userService.queryUser();
		req.setAttribute("list",list);
		req.getRequestDispatcher("admin/user_list.jsp").forward(req, resp);
	}
	
	//分页查询
	public void queryUserByPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String curPage = req.getParameter("curPage");
		//获取总记录数
		int rows = userService.queryUserCount();
		PageUtils pu = new PageUtils(rows, curPage,5);
		List<User> list = userService.queryUserByPage(pu);
		req.setAttribute("list",list);
		req.setAttribute("pageUtils",pu);
		req.getRequestDispatcher("admin/user_list.jsp").forward(req, resp);
	}
	
	
	//根据id删除
	public void deleteUserById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//获取id值
		String uid = req.getParameter("uid");
		int n = userService.deleteUserById(uid);
		if(n>0){
			//删除成功
			queryUserByPage(req,resp);
		}else{
			resp.getWriter().print("删除失败!");
		}
	}
	
	
	//批量删除
	public void batchDeleteUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//获取用户的的id
		String[] ids = req.getParameterValues("uid");
		for(String uid:ids){
			userService.deleteUserById(uid);
		}
		queryUserByPage(req,resp);
	}
	
	//发送邮件
	public void Mail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//1.获取页面的邮箱
		String mail = req.getParameter("mail");
		String yz = req.getParameter("yz");
		userService.Mail(mail, yz);
		
	}
}
