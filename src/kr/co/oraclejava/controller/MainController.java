package kr.co.oraclejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	//@RequestMapping("/main") 클래스와 메소드 둘다 적용
	@GetMapping("/main")
	public String main(){
		
		return "main";
	}
}
