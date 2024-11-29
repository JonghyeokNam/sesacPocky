package net.developia.reply.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.developia.reply.domain.ReplyVO;
import net.developia.reply.mapper.ReplyMapper;
import net.developia.util.page.PageObject;

@Log4j
@Service
@AllArgsConstructor
@Primary
public class ReplyServiceImpl implements ReplyService {

    private ReplyMapper mapper;

    @Override
    public int register(ReplyVO vo) {
        log.info("댓글 등록: " + vo);
        return mapper.insert(vo);
    }

    @Override
    public ReplyVO get(Long id) {
        log.info("댓글 조회: " + id);
        return mapper.read(id);
    }

    @Override
    public int modify(ReplyVO vo) {
        log.info("댓글 수정: " + vo);
        return mapper.update(vo);
    }

    @Override
    public int remove(Long id) {
        log.info("댓글 삭제: " + id);
        return mapper.delete(id);
    }

    @Override
    public List<ReplyVO> getList(PageObject pageObject, Long boardId) {
        log.info("댓글 목록 조회 - 게시글 ID: " + boardId);
        return mapper.getListWithPaging(pageObject, boardId);
    }

}
