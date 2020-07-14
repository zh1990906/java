package com.market.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author ZH
 * 上午10:12:31
 */
@WebServlet("/ResoultServlet")
public class ResoultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public ResoultServlet() {
        super();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置头部信息防止乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String clientCheckcode=request.getParameter("yan").toUpperCase();//接收客户端提交上来的参数，使用toUpperCase()可以实现不区分大小写
        String serverCheckcode=(String)request.getSession().getAttribute("checkcode");//从session中提取验证码
        
          if(clientCheckcode.equals(serverCheckcode)){
                response.getWriter().write("验证码正确，通过");
            }else{
                response.getWriter().write("验证码错误，失败");
            }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
