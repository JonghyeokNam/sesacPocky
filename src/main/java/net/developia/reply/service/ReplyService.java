package net.developia.reply.service;

import java.util.List;

import net.developia.reply.domain.ReplyVO;
import net.developia.util.page.PageObject;

public interface ReplyService {

	public int register(ReplyVO vo);
	
	public ReplyVO get(Long id);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long id);
	
	public List<ReplyVO> getList(PageObject pageObject, Long board_id);
}
