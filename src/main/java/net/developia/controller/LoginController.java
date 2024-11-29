package net.developia.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import net.developia.domain.CustomUser;
import net.developia.domain.MemberVO;
import net.developia.mapper.MemberMapper;

@Controller
public class LoginController {
	
	@Autowired
	private MemberMapper membermapper;

	@PostMapping("/loginAsUser1")
    public String loginAsUser(HttpServletRequest request) {

        // 사용자 정보 설정

        MemberVO memberVO = membermapper.read(13);
        
        CustomUser customUser = new CustomUser(memberVO);
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                customUser,  // CustomUser 객체
                null,  // 비밀번호는 이미 비교된 상태
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))  // 권한 설정
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        HttpSession session = request.getSession();
        session.setAttribute("userid", customUser.getUsername());

        // 로그인 성공 후 리다이렉트 할 페이지로 이동
        return "redirect:/board/pocky-mypage";  // 예: 홈 페이지로 이동
    }
	
	@PostMapping("/loginAsUser2")
    public String loginAsUser2(HttpServletRequest request) {

        // 사용자 정보 설정

        MemberVO memberVO = membermapper.read(14);
        
        CustomUser customUser = new CustomUser(memberVO);
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                customUser,  // CustomUser 객체
                null,  // 비밀번호는 이미 비교된 상태
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))  // 권한 설정
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        HttpSession session = request.getSession();
        session.setAttribute("userid", customUser.getUsername());

        // 로그인 성공 후 리다이렉트 할 페이지로 이동
        return "redirect:/board/pocky-mypage";  // 예: 홈 페이지로 이동
    }
	
	@PostMapping("/loginAsUser3")
    public String loginAsUser3(HttpServletRequest request) {

        // 사용자 정보 설정

        MemberVO memberVO = membermapper.read(15);
        
        CustomUser customUser = new CustomUser(memberVO);
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                customUser,  // CustomUser 객체
                null,  // 비밀번호는 이미 비교된 상태
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))  // 권한 설정
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        HttpSession session = request.getSession();
        session.setAttribute("userid", customUser.getUsername());

        // 로그인 성공 후 리다이렉트 할 페이지로 이동
        return "redirect:/board/pocky-mypage";  // 예: 홈 페이지로 이동
    }
	
	@PostMapping("/loginAsUser4")
    public String loginAsUser4(HttpServletRequest request) {

         // 사용자 정보 설정

        MemberVO memberVO = membermapper.read(16);
        
        CustomUser customUser = new CustomUser(memberVO);
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                customUser,  // CustomUser 객체
                null,  // 비밀번호는 이미 비교된 상태
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))  // 권한 설정
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        HttpSession session = request.getSession();
        session.setAttribute("userid", customUser.getUsername());

        // 로그인 성공 후 리다이렉트 할 페이지로 이동
        return "redirect:/board/pocky-mypage";  // 예: 홈 페이지로 이동
    }
	
	@PostMapping("/loginAsUser5")
    public String loginAsUser5(HttpServletRequest request) {

        // 사용자 정보 설정

        MemberVO memberVO = membermapper.read(17);
        
        CustomUser customUser = new CustomUser(memberVO);
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                customUser,  // CustomUser 객체
                null,  // 비밀번호는 이미 비교된 상태
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))  // 권한 설정
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        HttpSession session = request.getSession();
        session.setAttribute("userid", customUser.getUsername());

        // 로그인 성공 후 리다이렉트 할 페이지로 이동
        return "redirect:/board/pocky-mypage";  // 예: 홈 페이지로 이동
    }
}