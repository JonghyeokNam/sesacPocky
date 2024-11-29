<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ include file="../include/header.jsp" %>

<div class="personal-info">
    <i class="my-page-title">마이 페이지</i>
    <div class="personal-details">
        <div class="left">
            <i>⭐</i>
            <span>이름</span>
        </div>
        <div class="right">
            <span><sec:authentication property="principal.member.name"/></span>
        </div>
    </div>
    <div class="personal-details">
        <div class="left">
            <i>⭐</i>
            <span>전화번호</span>
        </div>
        <div class="right">
            <span><sec:authentication property="principal.phoneNum"/></span>
        </div>
    </div>
    <div class="personal-details">
        <div class="left">
            <i>⭐</i>
            <span>이메일</span>
        </div>
        <div class="right">
            <span><sec:authentication property="principal.member.email"/></span>
        </div>
    </div>
    <div class="personal-details">
        <div class="left">
            <i>⭐</i>
            <span>소속 클럽</span>
        </div>
        <div class="right">
            <span><sec:authentication property="principal.member.club_name"/></span>
        </div>
    </div>
</div>
<div class="move-icon">
   	<form id="bookmarkForm" method="GET">
   		<sec:authentication property="principal.member.name" var="username" />
  		<button class="move-detail" type="submit">⭐</button>
  	</form>
   	<form id="ModifyForm" method="GET">
   		<sec:authentication property="principal.member.name" var="username" />
   		<input type="hidden" name="username" value='${username }' />
  		<button class="move-detail" type="submit">👤</button>
  	</form>
</div>

<script>
	document.getElementById('bookmarkForm')
			.setAttribute('action', '/board/' + '${username}' + '/bookmark2');
	
	document.getElementById('ModifyForm')
			.setAttribute('action', '/board/mypage/modify?username=' + '${username}');
</script>
</body>
</html>
