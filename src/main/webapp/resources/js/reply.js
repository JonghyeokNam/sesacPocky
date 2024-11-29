console.log("Reply Module....");

let replyService = (function() {

    // 댓글 작성
    function add(reply, callback, error) {
        console.log("Adding reply: ", reply);

        if (!reply.reply || !reply.board_id || !reply.member_id) {
            alert("댓글 데이터가 유효하지 않습니다.");
            return;
        }

        $.ajax({
            type: 'post',
            url: '/replies/new',
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result) {
                if (callback) callback(result);
            },
            error: function(xhr, status, er) {
                if (error) error(er);
            }
        });
    }

    // 댓글 리스트 가져오기
    function getList(param, callback, error) {
        const board_id = param.board_id;
        const page = param.page || 1;

        console.log("Fetching replies for board ID: ", board_id);

        $.getJSON(`/replies/pages/${board_id}/${page}.json`, function(data) {
            console.log("Fetched replies: ", data);
            if (callback) callback(data);
        }).fail(function(xhr, status, err) {
            console.error("Error fetching replies: ", err);
            if (error) error(err);
        });
    }

    // 댓글 삭제
    function remove(id, callback, error) {
        console.log("Deleting reply with ID: ", id);

        if (!id) {
            alert("댓글 ID가 유효하지 않습니다.");
            return;
        }

        $.ajax({
            type: 'delete',
            url: `/replies/${id}`,
            success: function(deleteResult) {
                if (callback) callback(deleteResult);
            },
            error: function(xhr, status, er) {
                if (error) error(er);
            }
        });
    }

    // 댓글 수정
    function update(reply, callback, error) {
        console.log("Updating reply: ", reply);

        if (!reply.id || !reply.reply) {
            alert("댓글 수정에 필요한 데이터가 부족합니다.");
            return;
        }

        $.ajax({
            type: 'put',
            url: `/replies/${reply.id}`,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result) {
                if (callback) callback(result);
            },
            error: function(xhr, status, er) {
                if (error) error(er);
            }
        });
    }

    // 특정 댓글 조회
    function get(id, callback, error) {
        console.log("Fetching reply with ID: ", id);

        if (!id) {
            alert("댓글 ID가 없습니다.");
            return;
        }

        $.get(`/replies/${id}.json`, function(result) {
            if (callback) callback(result);
        }).fail(function(xhr, status, err) {
            if (error) error(err);
        });
    }

    return {
        add: add,
        getList: getList,
        remove: remove,
        update: update,
        get: get
    };

})();
