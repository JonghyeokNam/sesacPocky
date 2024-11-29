package net.developia.service;

import net.developia.domain.MemberVO;

public interface MemberService {
	MemberVO getMemberById(int userId);
	int updateMember(MemberVO member);
}
