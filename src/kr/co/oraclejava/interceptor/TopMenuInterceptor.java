package kr.co.oraclejava.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.oraclejava.beans.BoardInfoBean;
import kr.co.oraclejava.beans.UserBean;
import kr.co.oraclejava.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{

	private TopMenuService topMenuService;
	private UserBean loginUserBean;
	
	//생성자를 이용한 객체 주입 
	public TopMenuInterceptor(TopMenuService topMenuService, UserBean loginUserBean) {
		this.topMenuService = topMenuService; 
		this.loginUserBean = loginUserBean;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserBean", loginUserBean); 		
		
		return true;
	}
	
}
