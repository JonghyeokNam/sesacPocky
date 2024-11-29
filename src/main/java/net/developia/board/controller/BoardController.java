package net.developia.board.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;
import net.developia.board.service.BoardService;
import net.developia.board.vo.BoardVO;
import net.developia.util.page.PageObject;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	

	@Autowired
	@Qualifier("boardServiceImpl")
	private BoardService service;
	
	//---  게시판 리스트 ---------------------------------
	@GetMapping("/list.do")	
	public String list(Model model, HttpServletRequest request) throws Exception {
		log.info("list.do");
		
		
		PageObject pageObject = PageObject.getInstance(request);
		
		
		model.addAttribute("list", service.list(pageObject));
		log.info(pageObject);
		model.addAttribute("pageObject", pageObject);
		return "board/list";		
	
	}
	
	//---  게시판 글보기 ---------------------------------
	@GetMapping("/view.do")
	public String view(Model model,  Long no, int inc) {
		log.info("view.do");
		
		model.addAttribute("vo", service.view(no, inc));
		
		return "board/view";
	}
	
	//---  게시판 글등록 폼 ------------------------------------
	@GetMapping("/writeForm.do")
	public String writeForm() {
		log.info("writeForm.do");
	
		return "board/writeForm";
	}
	
	//---  게시판 글등록 처리 ------------------------------------
	@PostMapping("/write.do")
	public String write(BoardVO vo, RedirectAttributes rttr) {
		service.write(vo);
		
		// 처리 결과에 대한 메시지 처리
		rttr.addFlashAttribute("msg", "일반 게시판 글등록이 되었습니다.");
		
		return "redirect:list.do";
	}
	
	
	
}
