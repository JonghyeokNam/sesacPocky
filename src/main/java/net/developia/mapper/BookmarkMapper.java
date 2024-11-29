package net.developia.mapper;

import java.util.List;

import net.developia.domain.BoardVO;

public interface BookmarkMapper {
    // 북마크된 게시글 상세정보 조회
    List<BoardVO> getBookmarkedBoards(int member_id);
}
