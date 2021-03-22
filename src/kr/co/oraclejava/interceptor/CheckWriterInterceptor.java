package kr.co.oraclejava.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.oraclejava.beans.ContentBean;
import kr.co.oraclejava.beans.UserBean;
import kr.co.oraclejava.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{	

	private UserBean loginUserBean;
	private BoardService boardService;
	
	public CheckWriterInterceptor(UserBean loginUserBean, BoardService boardService) {
		this.loginUserBean = loginUserBean;
		this.boardService = boardService;
	}
	
	//로그인이 안되어 있으면 false(로그인 먼저 하라는 박스 표출시 사용), 로그인이 되어 있으면 true
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("CheckWriterInterceptor preHandle");
		System.out.println ((new Throwable ()).getStackTrace()[0]);
		
		//외부에서 그냥 치고 들어올 경우.
		String str1 = request.getParameter("content_idx");
		int content_idx = Integer.parseInt(str1);
		ContentBean currentContentBean = boardService.getContentInfo(content_idx);
		
		//기존 로그인 체크를 아래와 같이 변경. 확인 해 볼 것.
		if(currentContentBean.getContent_writer_idx() != loginUserBean.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/board/not_writer");
			return false;	//비정상적으로 접근 한 경우.
		}
		
		return true;
	}
}