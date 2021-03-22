package kr.co.oraclejava.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.oraclejava.beans.UserBean;

@Configuration//사용할 빈을 타입으로 객체 설정
public class RootAppContext {

	@Bean("loginUserBean")
	@SessionScope//로그인 내용을 세션영역에 저장하기 위하여 사용
	public UserBean loginUserBean() {
		return new UserBean();
	}
}
