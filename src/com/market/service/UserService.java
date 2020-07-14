/**
 * 
 */
package com.market.service;

import java.util.List;

import javax.mail.MessagingException;

import com.market.bean.User;
import com.market.dao.UserDao;
import com.market.utils.PageUtils;

/**
 * 
 * @author ZH
 * 上午10:43:37
 */
public class UserService {
	UserDao userDao = new UserDao();
	
	//注册
	public int addUser(User user){
		return userDao.addUser(user);
	};
	
	//手机号是否重复
	public boolean queryUserByTel(String tel){
		User user = userDao.queryUserByTel(tel);
		if(user==null){
			//手机号可以注册
			return true;
		}else{
			//手机号已经注册
			return false;
		}
	}
	
	//用户名是否重复
	public boolean queryUserByName(String name){
		User user = userDao.queryUserByName(name);
		if(user==null){
			//用户名可以注册
			return true;
		}else{
			//用户名已经注册
			return false;
		}
	}
	
	//邮箱是否重复
	public boolean queryUserByEmail(String email){
		User user = userDao.queryUserByEmail(email);
		if(user==null){
			//邮箱可以注册
			return true;
		}else{
			//邮箱已经注册
			return false;
		}
	}
	
	
	//用户登录
	public User userLogin(String name,String pwd){
		return userDao.userLogin(name, pwd);
	}
	
	//查询所有信息
	public List<User> queryUser(){
		return userDao.queryUser();
	}
	
	//分页查询
	public List<User> queryUserByPage(PageUtils p){
		return userDao.queryUserByPage(p);
	}
	
	//查询总记录数
	public int queryUserCount(){
		return userDao.queryUserCount();
	}
	//根据id删除信息
	public int deleteUserById(String id){
		return userDao.deleteUserById(id);
	}
	
	//发送邮件
	public void Mail(String mail,String yz) {
		try {
			userDao.Mailmail(mail, yz);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
