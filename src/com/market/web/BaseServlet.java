/**
 * 
 */
package com.market.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**、
 * 
 * @author ZH
 * 上午10:46:50
 */
@WebServlet("/baseServlet")
public class BaseServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//utf-8解码
		resp.setContentType("text/html;charset=utf-8");//返回数据格式和编码格式
		//获取对应Servlet的Class对象
		Class<? extends BaseServlet> clazz = this.getClass();
		
		String method = req.getParameter("method");
		if(method==null||method==""){
			throw new RuntimeException("没有获取method参数值!!");
		}else{
			try {
				//获取指定的公有的方法-->public
				Method m = clazz.getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
				//调用对应Servlet中的method方法
				m.invoke(this, req,resp);
			} catch (Exception  e) {
				e.printStackTrace();
			}
		}
		
	}

}
