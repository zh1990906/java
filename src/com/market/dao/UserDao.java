/**
 * 
 */
package com.market.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.market.bean.User;
import com.market.utils.JdbcUtils;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 上午10:39:12
 */
public class UserDao {
	
	
	//注册
	public int addUser(User user){
		int n = 0;
		String sql="insert into user(uname,tel,area,sex,username,password,email)values(?,?,?,?,?,?,?)";
		Object[] params = {user.getUname(),user.getTel(),user.getArea(),user.getSex(),user.getUsername(),user.getPassword(),user.getEmail()};
		//执行sql语句
		try {
			n = JdbcUtils.qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	//手机号是否重复
	public User queryUserByTel(String tel){
		User user = null;
		String sql="select * from user where tel = ?";
		try {
			user = JdbcUtils.qr.query(sql, new BeanHandler<>(User.class), tel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//用户名是否重复
	public User queryUserByName(String name){
		User user = null;
		String sql="select * from user where username = ?";
		try {
			user = JdbcUtils.qr.query(sql, new BeanHandler<>(User.class), name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	//邮箱是否重复
	public User queryUserByEmail(String email){
		User user = null;
		String sql="select * from user where email = ?";
		try {
			user = JdbcUtils.qr.query(sql, new BeanHandler<>(User.class), email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	//登录
	public User userLogin(String name,String pwd){
		User user = null;
		String sql="select * from user where username = ? and password=?";
		try {
			user = JdbcUtils.qr.query(sql, new BeanHandler<>(User.class),name,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	//查询用户信息
	public List<User> queryUser(){
		List<User> list = null;
		String sql="select * from user";
		try {
			list = JdbcUtils.qr.query(sql, new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//分页查询
	public List<User> queryUserByPage(PageUtils p){
		List<User> list = null;
		String sql="select * from user limit ?,?";
		try {
			list = JdbcUtils.qr.query(sql, new BeanListHandler<>(User.class),p.getStartIndex(),p.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//用户总记录数
	public int queryUserCount(){
		Number n = 0;
		String sql="select count(*) from user";
		try {
			n = (Number)JdbcUtils.qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n.intValue();
	}
	
	//根据id删除用户信息
	public int deleteUserById(String id){
		int n = 0;
		String sql="delete from user where uid = ?";
		try {
			n =JdbcUtils.qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	//邮件发送类
	public void Mailmail(String email,String yz) throws MessagingException{       
		   
        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱端口587
        props.put("mail.smtp.port", "587");
        // 此处填写，写信人的账号
        props.put("mail.user", "1780098232@qq.com");
        // 此处填写16位STMP口令
        props.put("mail.password", "neptlvfvogciceah");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人的邮箱
        InternetAddress to = new InternetAddress(email);
        message.setRecipient(RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("邮件验证");

        // 设置邮件的内容体
        message.setContent("本次验证码："+yz, "text/html;charset=UTF-8");

        // 最后当然就是发送邮件啦
        Transport.send(message);
	   
	   
   }
}
