package kr.co.oraclejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.oraclejava.service.UserService;
@RestController
public class RestApiController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String RestApiController(@PathVariable String user_id) {
		
		boolean chk=userService.checkUserIdExist(user_id);
		
		return chk+ "";
		
	}
}
//html형태의 데이터가 아니라면 RestController를 사용
//문자열이 아닌 데이터는 json처리