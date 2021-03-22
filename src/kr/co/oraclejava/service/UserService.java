package kr.co.oraclejava.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.oraclejava.beans.UserBean;
import kr.co.oraclejava.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDao;
	
	@Resource(name="loginUserBean") 
	private UserBean loginUserBean;
	
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true; //DB에 없는 아이디
		}else {
			return false; //DB에 존재하는 아이디
		}
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}
	
	//
	public void getLoginUserInfo(UserBean tempLoginUserBean){
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2 != null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx()); 
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name()); 
			loginUserBean.setUserLogin(true); 
		}		
	}
			
	public UserBean getModifyUserInfo(UserBean modifyUserBean) {		
		UserBean tempModifyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_idx());
		
		modifyUserBean.setUser_id(tempModifyUserBean.getUser_id()); 
		modifyUserBean.setUser_name(tempModifyUserBean.getUser_name()); 
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		return modifyUserBean; 						
	}

	public void modifyUserInfo(UserBean modifyUserBean) {
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx()); 		
		userDao.modifyUserInfo(modifyUserBean); 
	}
	

}
