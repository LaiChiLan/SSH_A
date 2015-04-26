package com.ssh.user.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.user.dao.UserDao;
import com.ssh.user.model.User;
import com.ssh.util.*;
/**     
 * 缂侇偉顕ч幃鏇犵矓鐢喚绐桿serDaoImpl   
 * 缂侇偆绮鎸庢交鐢喚绐楅柣顤屽妽閸╂盯骞掕閸╂ao閻庡湱鍋熼獮鍥极閻楀牆绁﹂幖瀛樻尰閹奸攱鎷呭鍕闁告瑱绲介悿鍕偝閿燂拷 * 闁告帗绋戠紓鎾寸閻氬绐梐nan   
 * 闁告帗绋戠紓鎾诲籍閸洘锛熼柨娑虫嫹012-12-21 濞戞挸顑呭畷锟�:07:43   
 * 濞ｅ浂鍠楅弫鍏肩閻氬绐梐nan  
 * 濞ｅ浂鍠楅弫濂稿籍閸洘锛熼柨娑虫嫹012-12-21 濞戞挸顑呭畷锟�:07:43   
 * 濞ｅ浂鍠楅弫鍏煎緞閸ャ劍鏆堥柨娑虫嫹  
 * @version        
 * */
//閹跺イserDao鐎圭偘缍嬮崠锟�
@ContextConfiguration(locations = {"classpath*:applicationContext*.xml"})

@Repository("userDao")
public class UserDaoImpl     implements UserDao{
    private String HQL;
 	 @Resource(name="sessionFactory") 
	 SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	public void addUser(User user)  {
	 	Session session =  sessionFactory.getCurrentSession();
	 	Transaction tc =  (Transaction)session.beginTransaction();
	 
		session.save(user);
		try {
		  	tc.commit();
		} catch (Exception e) {
	 	 	tc.rollback();
			e.printStackTrace(); 
		} 
		session.close();
	}

	public void delUser(int userId) {
		Session session =  sessionFactory.getCurrentSession();
		Transaction tc = (Transaction) session.beginTransaction();
		User u = new User(userId);
		session.delete(u);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		session.close();
	}

	public void updateUser(User user) {
		Session session =  sessionFactory.getCurrentSession();
		Transaction tc = (Transaction) session.beginTransaction();
		session.update(user);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.close();
		
	}

	public List<User> selectUser()  {
		List<User> users = new ArrayList<User>();
		Session session =  sessionFactory.getCurrentSession();
		Transaction tc = (Transaction) session.beginTransaction();
		List list = session.createQuery("From User").list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			User u = (User) iterator.next();
			users.add(u);
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return users;
	}

	public User getUserByUserId(int userId)  {
		Session session =  sessionFactory.getCurrentSession();
		Transaction tc = (Transaction) session.beginTransaction();
		//load 闁哄嫷鍨甸鈺呭及鎼淬垺娈堕柟璇″枛缁ㄨ鲸绋夐婵堫伇閻庤鑹鹃悺銊╁捶閵娿劎绠归柡澹溿値鍞剁憸鐗堟穿缁辨繂鈻介埄鍐╃畳闁告帗鐟︽慨銈夊礄閻氬绐桹bjectNotFoundException
		//get 濠碘�鍊归悘澶愬蓟閵夈倗鐟濋柛鎺撳椤斿洩銇愰弴顏嗙閺夆晜鏌ㄥú鏍儍閸曨剚笑濞戞搫鎷烽柌娓榰ll
		User user = (User)session.load(User.class, userId);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return user;
	}

	public boolean isExitByName(String userName)  {
		Session session =  sessionFactory.getCurrentSession();
		Transaction tc = (Transaction) session.beginTransaction();
		List user = (List)session.createQuery("From User u where u.userName=:userName").setString("userName", userName).list();
		if(user.size()>0){
			try {
				tc.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
			return true;
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return false;
	}

	public boolean isExitByNameAndPass(User user)  {
		System.out.println("testASAAAAAAAAAA");
		Session session =  sessionFactory.getCurrentSession();
	 
		//Transaction tc = (Transaction) session.beginTransaction();
		HQL = "From User u where u.userName=:userName and u.passWord=:passWord" ;
		List users = (List)session.createQuery(HQL)
				.setString("userName", user.getUserName())
				.setString("passWord",user.getPassWord());
		//List users = (List)session.createQuery("From User u where u.userName=:userName and u.passWord=:passWord").setString("userName", user.getUserName()).setString("passWord", user.getPassWord()).list();
		
		if(users.size()>0){
			session.close();
			return true;
		}
	 
		session.close();
		return false;
	}

}
