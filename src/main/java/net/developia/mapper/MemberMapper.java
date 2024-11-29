package net.developia.mapper;

import net.developia.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO read(int userid);
	int update(MemberVO member);
}
