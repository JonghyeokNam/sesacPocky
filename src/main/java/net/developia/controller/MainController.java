package net.developia.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;
import net.developia.board.controller.BoardController;
import net.developia.board.service.BoardService;
import net.developia.util.page.PageObject;

@Controller
@Log4j
public class MainController {
	
	//---  메인페이지 ---------------------------------
	@GetMapping("/index.do")	
	public String index() {
		
		return "index";		
	
	}
	
}
