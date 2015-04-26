package com.ssh.user.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.user.dao.UserDao;
import com.ssh.user.dao.impl.UserDaoImpl;
import com.ssh.user.model.User;
import org.springframework.test.context.ContextConfiguration;


@Controller 
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -2266695172069461659L;
    private String tempflag;
  //  private String userName;
  //  private String passWord;
    
  //  @Autowired
    private User user;
	public void setUser(User user) {
		this.user = user;
	}
  
	public User getUser() {
		return user;
	}


	@Resource(name="userDao")
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Action(value = "/login", results = {
			@Result(name = "loginSuccess", location = "/loginSuss.jsp"),
			@Result(name = "loginFailer", location = "/loginFailer.jsp") }
	       )
	public String login(){
	   //     User user = new User();
	   //     user.setUserName(userName);
	       // user.setPassWord(passWord);
	       //    UserDao userDao = new UserDaoImpl();
	        
		System.out.println("hihihih");
		
		        userDao.addUser(user);
		        
				boolean flag = userDao.isExitByNameAndPass(user);
				if(flag){
					System.out.println("suss");
					tempflag = "loginSuccess";
				}
				System.out.println("fail");
				tempflag = "loginFailer";
 	
				 
	   return tempflag;
	   
	   
	}
 
/*
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}*/
}
