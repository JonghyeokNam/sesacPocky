package net.developia.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;
import net.developia.domain.BoardVO;
import net.developia.domain.CustomUser;
import net.developia.domain.MemberVO;
import net.developia.mapper.MemberMapper;
import net.developia.service.BookmarkService;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

@RequestMapping("/board/*")
@Controller
@Log4j
public class BookmarkController {
	@Autowired
	private BookmarkService bookmarkService;
	
	@GetMapping("/{username}/bookmark")
	 public String getBookmarkedBoards(@PathVariable("username") String username, Principal principal, Model model) {
	    if (principal == null) {
	        log.info("로그인된 사용자 정보가 없습니다.");
	    } else {
	    	log.info("로그인 성공!");
	    	log.info(principal.getName());
	    	log.info(Integer.parseInt(principal.getName()));
	    }
		
		try {
        	String userId = principal.getName();
        	int memberId = Integer.parseInt(userId);
        	
        	List<BoardVO> bookmarkedBoards = bookmarkService.getBookmarkedBoards(memberId);
            model.addAttribute("bookmarkedBoards", bookmarkedBoards);
            
        } catch (Exception e) {
        	e.printStackTrace();
        	model.addAttribute("error", "북마크 정보를 불러오는 중 문제가 발생했습니다.");
        }
        
        return "board/bookmark";
    }
	
	@GetMapping("/{username}/bookmark2")
	 public String getBookmarkedBoards2(@PathVariable("username") String username, Principal principal, Model model) {
	    if (principal == null) {
	        log.info("로그인된 사용자 정보가 없습니다.");
	    } else {
	    	log.info("로그인 성공!");
	    	log.info(principal.getName());
	    	log.info(Integer.parseInt(principal.getName()));
	    }
		
		try {
       	String userId = principal.getName();
       	int memberId = Integer.parseInt(userId);
       	
       	List<BoardVO> bookmarkedBoards = bookmarkService.getBookmarkedBoards(memberId);
           model.addAttribute("bookmarkedBoards", bookmarkedBoards);
           
       } catch (Exception e) {
       	e.printStackTrace();
       	model.addAttribute("error", "북마크 정보를 불러오는 중 문제가 발생했습니다.");
       }
       
       return "board/bookmark2";
   }
}
