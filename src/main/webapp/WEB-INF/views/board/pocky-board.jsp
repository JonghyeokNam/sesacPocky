<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ include file="../include/header.jsp" %>

    <div class="board-header">
        <img src="soccer-icon.png" alt="Soccer">
        <h1>Soccer</h1>
    </div>
    <div class="board-list">
        <div class="board-item">
            <div class="title">
                <i>A</i>
                <span>List item</span>
            </div>
            <div class="count">100+</div>
            <div class="check">✔</div>
        </div>
        <!-- 반복 가능한 아이템 -->
        <div class="board-item">
            <div class="title">
                <i>A</i>
                <span>List item</span>
            </div>
            <div class="count">100+</div>
            <div class="check">✔</div>
        </div>
        <!-- 추가 -->
    </div>
    <div class="pagination">
        <a href="#" class="prev">← Previous</a>
        <a href="#" class="active">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#" class="next">Next →</a>
    </div>
</body>
</html>
