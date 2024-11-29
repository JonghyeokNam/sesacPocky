package net.developia.mapper;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;
import net.developia.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:**/*-context.xml")
@WebAppConfiguration
@Log4j
public class MemberMapperTests {
	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testRead() {
		MemberVO vo = mapper.read(11);
		
		log.info(vo);

	}
	
	@Test
	public void testUpdate() {
		MemberVO member;
		
        member = new MemberVO();
        member.setId(1);
        member.setName("Taemin");
        member.setEmail("aaaa@email.com");
        member.setPhone_num("01012341234");
        member.setClub_name("클라이밍");
        
		int rowsAffected = mapper.update(member);
		
		assertEquals(1, rowsAffected);
	}
}
