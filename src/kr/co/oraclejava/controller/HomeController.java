package kr.co.oraclejava.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main(HttpServletRequest request) {
		System.out.println("main");
		//컴퓨터상의 물리적 실제 경로 출력
		System.out.println(request.getServletContext().getRealPath("/"));
		return "redirect:/main";//main.jsp
	}
}
