<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ include file="../include/header.jsp" %>

<div class="personal-info">
	<i class="my-page-title">회원 정보 수정</i>
    <form action="/updateMypage" method="POST" id="modifyForm">
    	<input type="hidden" name="_csrf" value="${_csrf.token}" />
        <!-- 이름 -->
        <div class="personal-details">
            <div class="left">
                <i>⭐</i>
                <span>이름</span>
            </div>
            <div class="right">
                <input type="text" name="name" value="<sec:authentication property='principal.member.name'/>" required>
            </div>
        </div>

        <!-- 전화번호 -->
        <div class="personal-details">
            <div class="left">
                <i>⭐</i>
                <span>전화번호</span>
            </div>
            <div class="right">
                <input type="text" name="phone" value="<sec:authentication property='principal.member.phone_num'/>" required>
            </div>
        </div>

        <!-- 이메일 -->
        <div class="personal-details">
            <div class="left">
                <i>⭐</i>
                <span>이메일</span>
            </div>
            <div class="right">
                <input type="email" name="email" value="<sec:authentication property='principal.member.email'/>" required>
            </div>
        </div>

        <!-- 소속 클럽 -->
        <div class="personal-details">
            <div class="left">
                <i>⭐</i>
                <span>소속 클럽</span>
            </div>
            <div class="right">
                <input type="text" name="club_name" value="<sec:authentication property='principal.member.club_name'/>" required>
            </div>
        </div>

        <!-- 수정 버튼 -->
        <div class="personal-details">
            <div class="right">
                <button type="submit" class="btn btn-primary">수정하기</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>

