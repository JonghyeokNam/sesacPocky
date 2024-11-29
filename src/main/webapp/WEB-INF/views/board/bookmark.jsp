<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ include file="../include/header.jsp" %>

<div class="bookmark-container">
    <i class="my-page-title">북마크 목록</i>
    <div class="bookmark-table">
        <c:if test="${not empty bookmarkedBoards }">
	        <table border="1" >
	        	<thead>
	        		<tr>
	        			<th>게시글 번호</th>
	        			<th>제목</th>
	        			<th>내용</th>
	        			<th>조회수</th>
	        			<th>작성일</th>
	        		</tr>
	        	</thead>
	        	<br>
	        	<tbody>
	        		<c:forEach var="board" items="${bookmarkedBoards }">
	        			<tr>
	        				<i>⭐</i>
	        				<td>${board.bno }   ☆</td>
	        				<td>${board.title }   ☆</td>
	        				<td>
	        					<a href="/board/detail?bno=${board.bno }">${board.content }   ☆</a>
	        				</td>
	        				<td>${board.hit }   ☆</td>
	        				<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd" />   ☆</td>
	        			</tr>
	        			<br>
	        		</c:forEach>	
	        	</tbody>
	        </table>
        </c:if>
        <c:if test="${empty bookmarkedBoards }">
        	<p>북마크된 게시글이 없습니다</p>
        </c:if>
    </div>
</div>
<div class="move-icon">
	<button class="move-detail">⭐</button>
	<button class="move-detail">👤</button>
</div>
</body>
</html>
