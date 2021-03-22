package kr.co.oraclejava.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.oraclejava.beans.UserBean;
import kr.co.oraclejava.mapper.UserMapper;

@Repository
public class UserDAO {

	@Autowired
	private UserMapper userMapper;
	
	public String checkUserIdExist(String user_id){
		
		return userMapper.checkUserIdExist(user_id);		
	}
	
	//UserBean이라는 DTO클래스에 setXXX()를 톹하여 데이터를 클래스 변수에 저장
	public void addUserInfo(UserBean joinUserBean) {
		userMapper.addUserInfo(joinUserBean);
	}
	
	//
	public UserBean getLoginUserInfo(UserBean tempLoginUserBean) {
		return userMapper.getLoginUserInfo(tempLoginUserBean);
	}
	
	public UserBean getModifyUserInfo(int user_idx) {
		return userMapper.getModifyUserInfo(user_idx);
	}
	
	public void modifyUserInfo(UserBean modifyUserBean) {
		userMapper.modifyUserInfo(modifyUserBean);
	}

}
