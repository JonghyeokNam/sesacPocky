package net.developia.service;

import java.util.List;

import net.developia.domain.BoardVO;

public interface BookmarkService {
    // 특정 회원의 북마크된 게시글 조회
    public List<BoardVO> getBookmarkedBoards(int memberid) throws Exception;
}
