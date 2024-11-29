package net.developia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.developia.domain.MemberVO;
import net.developia.mapper.MemberMapper;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper membermapper;
	
	@Override
	public MemberVO getMemberById(int userId) {
		return membermapper.read(userId);
	}

	@Override
	public int updateMember(MemberVO member) {
		return membermapper.update(member);
	}

}
