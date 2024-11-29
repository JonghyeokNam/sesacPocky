package net.developia.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.developia.reply.domain.ReplyVO;
import net.developia.reply.service.ReplyService;
import net.developia.util.page.PageObject;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

    @Qualifier("replyServiceImpl")
    private ReplyService service;

    // 댓글 등록
    @PostMapping(value = "/new",
                 consumes = "application/json",
                 produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
        log.info("댓글 등록 요청: " + vo);

        int insertCount = service.register(vo);

        return insertCount == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 특정 게시글의 댓글 목록 조회
    @GetMapping(value = "/pages/{boardId}/{page}",
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ReplyVO>> getList(
            @PathVariable("page") long page,
            @PathVariable("boardId") Long boardId) {

        log.info("댓글 목록 요청 - 게시글 ID: " + boardId);

        PageObject pageObject = new PageObject(page, 10); // 기본값: 한 페이지 10개
        log.info("페이지 정보: " + pageObject);

        return new ResponseEntity<>(service.getList(pageObject, boardId), HttpStatus.OK);
    }

    // 댓글 조회
    @GetMapping(value = "/{id}",
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReplyVO> get(@PathVariable("id") Long id) {
        log.info("댓글 조회 - ID: " + id);

        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    // 댓글 삭제
    @DeleteMapping(value = "/{id}",
                   produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> remove(@PathVariable("id") Long id) {
        log.info("댓글 삭제 요청 - ID: " + id);

        return service.remove(id) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 댓글 수정
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
                    value = "/{id}",
                    consumes = "application/json",
                    produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> modify(@RequestBody ReplyVO vo,
                                         @PathVariable("id") Long id) {
        vo.setId(id);

        log.info("댓글 수정 요청 - ID: " + id);

        return service.modify(vo) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
