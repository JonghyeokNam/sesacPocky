package net.developia.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import lombok.extern.java.Log;
import net.developia.domain.CustomUser;
import net.developia.domain.MemberVO;
import net.developia.mapper.MemberMapper;
import net.developia.service.MemberService;

@Controller
@Log
@RequestMapping("/board/*")
public class MyPageController {
	
	@Autowired
	private MemberMapper membermapper;

   @GetMapping("/pocky-home")
   public String home() {
      log.info("pocky-home");
      return "board/pocky-home";
   }
   @GetMapping("/pocky-main")
   public String main() {
      log.info("pocky-main");
      return "board/pocky-main";
   }
   @GetMapping("/pocky-mypage")
   public String mypage() {
      log.info("pocky-mypage");
      return "board/pocky-mypage";
   }
   @GetMapping("/pocky-board")
   public String list() {
      log.info("pocky-mypage");
      return "board/pocky-board";
   }
   
   @GetMapping(value = "/mypage/modify")
   public String edityMyPage(@RequestParam("username") String username, Principal principal, Model model) {
	   int id = Integer.parseInt(principal.getName());
	   
	   CustomUser user = new CustomUser(membermapper.read(id));  
	   model.addAttribute("member", user);
	   
	   
	   return "board/editMyPage";
   }
   
   @PostMapping("/updateMypage")
   public String updateMyPage(Authentication authentication, Model model) {
	   
	   return "redirect:/board/pocky-mypage";
   }
}