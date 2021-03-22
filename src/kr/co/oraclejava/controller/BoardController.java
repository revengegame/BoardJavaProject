package kr.co.oraclejava.controller;

import java.net.ContentHandler;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.hibernate.validator.internal.constraintvalidators.bv.number.InfinityNumberComparatorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.LimitedDataBufferList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.oraclejava.beans.ContentBean;
import kr.co.oraclejava.beans.UserBean;
import kr.co.oraclejava.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	//어노테이션을 이용한다는 것은 비즈니스 로직에만 개발자가 전념
	//기존 객체 관리는 개발자가 해왔는데 이제는 스프링프레임워크가 자동으로 객체 생성 관리
	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		
		String boardInfoName=boardService.getBoardInfoName(board_info_idx);
		model.addAttribute("boardInfoName", boardInfoName);
		
		List<ContentBean> contentList=boardService.getContentList(board_info_idx);
		model.addAttribute("contentList", contentList);
		
		return "board/main";
	}
	
	@GetMapping("/read")//read반복
	public String read(@RequestParam("board_info_idx") int board_info_idx, @RequestParam("content_idx") int content_idx, Model model) {
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		
		ContentBean readContentBean=boardService.getContentInfo(content_idx);
		model.addAttribute("readContentBean", readContentBean);
		//로그인한 사람의 인덱스 번호
		model.addAttribute("loginUserBean", loginUserBean);
		return "board/read";
	}
	
	@GetMapping("/write")
	public String write(@ModelAttribute("writeContentBean") ContentBean writeContentBean,@RequestParam("board_info_idx") int board_info_idx) {
		
		writeContentBean.setContent_board_idx(board_info_idx);
		return "board/write";
	}
	

	@PostMapping("/write_pro")
	public String write_pro(@Valid @ModelAttribute("writeContentBean") ContentBean writeContentBean, BindingResult result) {
		if(result.hasErrors()) {
			return "board/write";
		}
		boardService.addContentInfo(writeContentBean);
		return "board/write_success";
	}
	
	@GetMapping("/modify")//read반복
	public String modify() {
		
		return "board/modify";
	}
	
	@GetMapping("/delete")//read반복
	public String delete(@RequestParam("board_info_idx") int board_info_idx,@RequestParam("content_idx") int content_idx, Model model) {
		boardService.deleteContentInfo(content_idx);
		
		model.addAttribute("board_info_idx", board_info_idx);
		
		return "board/delete";
	}
	
	@GetMapping("not_write")
	public String not_write() {
		
		
		return "board/not_write";
	}
	

}