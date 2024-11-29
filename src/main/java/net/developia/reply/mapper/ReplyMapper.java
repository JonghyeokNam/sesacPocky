package net.developia.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.developia.reply.domain.ReplyVO;
import net.developia.util.page.PageObject;

public interface ReplyMapper {

	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long rno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO reply);
	
	public List<ReplyVO> getListWithPaging(
			@Param("po") PageObject pageObject,
			@Param("board_id") Long board_id);
}
