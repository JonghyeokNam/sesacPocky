<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글보기</title>
<jsp:include page="../jsp/webLib.jsp" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/resources/js/reply.js"></script>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">
            <h2>게시글 상세보기</h2>
        </div>
        <div class="card-body">
            <div class="card" data-no="${vo.bno}">
                <div class="card-header">
                    <span class="float-right">조회수: ${vo.hit}</span>
                    ${vo.bno}. ${vo.title}
                </div>
                <div class="card-body">
                    <pre>${vo.content}</pre>
                </div>
                <div class="card-footer">
                    <span class="float-right">
                        <fmt:formatDate value="${vo.writeDate}" pattern="yyyy-MM-dd" />
                    </span>
                    ${vo.member_id}
                </div>
            </div>
        </div>
        <div class="card-footer">
            <div class="btn-group">
                <button class="btn btn-primary" id="updateBtn">수정</button>
                <button class="btn btn-danger" id="deleteBtn">삭제</button>
                <button class="btn btn-warning" id="listBtn">목록</button>
            </div>
        </div>
    </div>

    <!-- 댓글 영역 -->
    <div class="card mt-3">
        <div class="card-header">
            <h4>댓글</h4>
        </div>
        <div class="card-body">
            <ul class="list-group" id="replyList">
                <!-- 댓글 목록이 JavaScript로 여기에 삽입됩니다 -->
            </ul>
        </div>
        <div class="card-footer">
            <form id="replyForm">
                <div class="form-group">
                    <textarea class="form-control" rows="3" id="replyContent" placeholder="댓글을 입력하세요"></textarea>
                </div>
                <button type="button" class="btn btn-primary" id="replySubmitBtn">댓글 작성</button>
            </form>
        </div>
    </div>
</div>

<script>
$(document).ready(function() {
    const boardId = "${vo.bno}"; // 현재 게시글 ID
    const replyList = $("#replyList");
    const replyContent = $("#replyContent");

    console.log("Current board ID: ", boardId);
    if (!boardId) {
        alert("게시글 ID가 유효하지 않습니다.");
        return;
    }

    // 댓글 리스트 표시 함수
    function loadReplies() {
        replyService.getList({ board_id: boardId, page: 1 }, function(list) {
            replyList.empty();
            if (!list || list.length === 0) {
                replyList.append("<li class='list-group-item'>댓글이 없습니다.</li>");
                return;
            }
            list.forEach(reply => {
                replyList.append(`
                    <li class="list-group-item" data-id="\${reply.id}">
                        <strong>\${reply.member_id}</strong> - \${reply.replydate}
                        <p>\${reply.reply}</p>
                        <span>좋아요: \${reply.likes_count}</span>
                        <button class="btn btn-danger btn-sm deleteReplyBtn">삭제</button>
                    </li>
                `);
            });
        }, function(error) {
            console.error("댓글 불러오기 실패:", error);
        });
    }

    // 댓글 작성 이벤트
    $("#replySubmitBtn").on("click", function() {
        const replyText = replyContent.val().trim();
        if (replyText === "") {
            alert("댓글 내용을 입력하세요!");
            return;
        }
        const replyData = {
            reply: replyText,
            board_id: boardId,
            member_id: "testUser" // 임시 사용자 ID
        };
        console.log("Adding reply: ", replyData);

        replyService.add(replyData, function(result) {
            alert("댓글이 작성되었습니다.");
            replyContent.val("");
            loadReplies();
        }, function(error) {
            console.error("댓글 작성 실패:", error);
        });
    });

    // 댓글 삭제 이벤트 (이벤트 위임)
    replyList.on("click", ".deleteReplyBtn", function() {
        const id = $(this).closest("li").data("id");
        console.log("Deleting reply with ID: ", id);

        if (!id) {
            alert("댓글 ID가 유효하지 않습니다.");
            return;
        }

        replyService.remove(id, function(result) {
            alert("댓글이 삭제되었습니다.");
            loadReplies();
        }, function(error) {
            console.error("댓글 삭제 실패:", error);
        });
    });

    // 초기 댓글 로드
    loadReplies();
});
</script>
</body>
</html>
