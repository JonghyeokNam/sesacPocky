package net.developia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.developia.domain.CustomUser;
import net.developia.domain.MemberVO;
import net.developia.mapper.MemberMapper;

@Log4j
@Service("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

		log.warn("Load User By UserName : " + id);
		
		int userid = Integer.parseInt(id);

		MemberVO vo = memberMapper.read(userid);

		log.warn("queried by member mapper: " + vo);

		return vo == null ? null : new CustomUser(vo);
	} 

}