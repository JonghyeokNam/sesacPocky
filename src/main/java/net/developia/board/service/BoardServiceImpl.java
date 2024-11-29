package net.developia.board.service;

import java.sql.Clob;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import net.developia.board.mapper.BoardMapper;
import net.developia.board.vo.BoardVO;
import net.developia.board.vo.ClubVO;
import net.developia.util.page.PageObject;

@Service
@Log4j
@Qualifier("boardServiceImpl")
public class BoardServiceImpl implements BoardService{

	
	@Inject
	private BoardMapper mapper;

	//  게시판 리스트
	public List<BoardVO> list(PageObject pageObject) {
		log.info("list() 실행");
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		return mapper.list(pageObject);
	}

	// 일반 게시판 글보기
	public BoardVO view(Long no, int inc) {
		log.info("view() 실행");
		if (inc == 1)
			mapper.increase(no);
		return mapper.view(no);
	}
	


	// 게시판 글등록
	public Integer write(BoardVO vo) {
		log.info(vo);
		return mapper.write(vo);
	}

	// 게시판 글수정
	public Integer update(BoardVO vo) {
		log.info(vo);
		return mapper.update(vo);
	}
	
	//  게시판 글삭제
	@Override
	public Integer delete(BoardVO vo) {
		log.info(vo);
		return mapper.delete(vo);
	}

	@Override
	public List<ClubVO> getListClubid() {
		// TODO Auto-generated method stub
		return mapper.getListClubid();
	}
}
