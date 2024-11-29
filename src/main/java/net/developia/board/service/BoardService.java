package net.developia.board.service;

import java.util.List;

import net.developia.board.vo.BoardVO;
import net.developia.board.vo.ClubVO;
import net.developia.util.page.PageObject;

public interface BoardService {

	// 일반 게시판 리스트
	public List<BoardVO> list(PageObject pageObject);
	
	// 일반 게시판 글보기
	public BoardVO view(Long no, int inc);
	
	// 일반 게시판 글등록
	public Integer write(BoardVO vo);
	
	// 일반 게시판 글수정
	public Integer update(BoardVO vo);
	
	// 일반 게시판 글삭제
	public Integer delete(BoardVO vo);
	
	public List<ClubVO> getListClubid();
	
}
