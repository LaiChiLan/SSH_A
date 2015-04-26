package com.ssh.user.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.user.dao.UserDao;
import com.ssh.user.model.User;
import com.ssh.user.service.UserService;


/**     
 * 缁鎮曠粔甯窗UserServiceImpl   
 * 缁粯寮挎潻甯窗閻劍鍩涙穱鈩冧紖閹垮秳缍旀稉姘闁槒绶幒銉ュ經鐎圭偟骞�
 * 閸掓稑缂撴禍鐚寸窗anan   
 * 閸掓稑缂撻弮鍫曟？閿涳拷012-12-21 娑撳宕�1:08:18   
 * 娣囶喗鏁兼禍鐚寸窗anan  
 * 娣囶喗鏁奸弮鍫曟？閿涳拷012-12-21 娑撳宕�1:08:18   
 * 娣囶喗鏁兼径鍥ㄦ暈閿涳拷  
 * @version        
 * */
@Service("userService")
public class UserServiceImpl implements UserService {
	//浣犲幓鐪�
	@Resource(name="userDao")
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean isExitUser(String userName) {
		return userDao.isExitByName(userName);
	}

	public void save(User user) {
		userDao.addUser(user);
	}

	public List<User> getUsers() {
		List<User> users = userDao.selectUser();
		return users;
	}

	public void del(int userId) {
		userDao.delUser(userId);

	}

	public void update(User user) {
		userDao.updateUser(user);

	}

	public User getUserById(int userId) {
		return userDao.getUserByUserId(userId);
	}

	public boolean isExitByNameAndPass(User user) {
		return userDao.isExitByNameAndPass(user);
	}

}
