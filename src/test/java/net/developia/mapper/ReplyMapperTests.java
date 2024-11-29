package net.developia.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;
import net.developia.reply.domain.ReplyVO;
import net.developia.reply.mapper.ReplyMapper;
import net.developia.util.page.PageObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:**/*-context.xml")
@WebAppConfiguration
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void testMapper() {
		log.info(replyMapper);
	}
	
	@Test
    public void testInsert() {
        ReplyVO reply = new ReplyVO();
        reply.setBoard_id(999L); // 테스트에 사용할 게시글 ID
        reply.setMember_id(16L); // 테스트에 사용할 사용자 ID
        reply.setReply("테스트 댓글입니다.");

        int result = replyMapper.insert(reply);
        log.info("댓글 등록 결과: " + result);
    }
	
	@Test
    public void testRead() {
        Long id = 1L; // 읽을 댓글의 ID를 설정
        ReplyVO reply = replyMapper.read(id);

        log.info("댓글 조회 결과: " + reply);
    }
	
	@Test
    public void testUpdate() {
        ReplyVO reply = new ReplyVO();
        reply.setId(1L); // 수정할 댓글의 ID
        reply.setReply("수정된 댓글 내용입니다.");

        int result = replyMapper.update(reply);
        log.info("댓글 수정 결과: " + result);
    }
	
	@Test
    public void testDelete() {
        Long id = 1L; // 삭제할 댓글의 ID
        int result = replyMapper.delete(id);

        log.info("댓글 삭제 결과: " + result);
    }
	
	@Test
    public void testGetList() {
        Long boardId = 999L; // 특정 게시글 ID에 대한 댓글 조회
        PageObject po = new PageObject();
        List<ReplyVO> replies = replyMapper.getListWithPaging(po, boardId);

        log.info("댓글 목록 조회 결과: " + replies);
        replies.forEach(reply -> log.info(reply));
    }
}
