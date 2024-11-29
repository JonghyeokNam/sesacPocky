package net.developia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.developia.domain.BoardVO;
import net.developia.mapper.BookmarkMapper;

@Log4j
@Service
@AllArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {
	
	@Autowired
	private BookmarkMapper bookmarkmapper;

	@Override
	public List<BoardVO> getBookmarkedBoards(int memberid) throws Exception{
		return bookmarkmapper.getBookmarkedBoards(memberid);
	}

}
