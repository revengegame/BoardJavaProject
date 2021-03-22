package kr.co.oraclejava.validator;

import org.springframework.validation.Validator;
import kr.co.oraclejava.beans.UserBean;
import org.springframework.validation.Errors;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userBean = (UserBean) target;

		String beanName = errors.getObjectName();
				
		//비밀번호 확인
		if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
			if (userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals"); 
		}
		
		//아이디중복 확인 체크
		if(beanName.equals("joinUserBean")) {
			if(userBean.isUserIdExist() == false) {
				errors.rejectValue("user_id", "DontCheckUserIdExist");
					}
				}
		}
	}
}
