package com.ssh.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**     
 * 缁鎮曠粔甯窗User   
 * 缁粯寮挎潻甯窗閻劍鍩涙穱鈩冧紖鐎圭偘缍�
 * 閸掓稑缂撴禍鐚寸窗anan   
 * 閸掓稑缂撻弮鍫曟？閿涳拷012-12-21 娑撳宕�0:55:19   
 * 娣囶喗鏁兼禍鐚寸窗anan  
 * 娣囶喗鏁奸弮鍫曟？閿涳拷012-12-21 娑撳宕�0:55:19   
 * 娣囶喗鏁兼径鍥ㄦ暈閿涳拷  
 * @version        
 * */


@Entity
@Table(name = "user",catalog="test1")
public class User {
	/**
	 * 閻劍鍩沬d
	 */
	@Id
	@Column(name = "userId")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue
	private int userId;
	
	/**
	 * 閻劍鍩涢崥锟�	 */
//	@Column(name = "userName", length = 50)
	private String userName;
	
	/**
	 * 閻劍鍩涢惂璇茬秿鐎靛棛鐖�
	 */
//	@Column(name = "passWord", length = 50)
	private String passWord;

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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
	}

	public User(int userId, String userName, String passWord) {
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}

	public User(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public User(int userId) {
		this.userId = userId;
	}

	public User() {
		
	}

}
