<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ include file="../include/header.jsp" %>

<div>
	<div>
		<div class="move-icon">
			<i class="my-page-bookmark">북마크 목록</i>
		   	<form action="/board/pocky-mypage" method="GET">
		  		<button class="move-detail" type="submit">⭐</button>
		  	</form>
			<button class="move-detail">👤</button>
		</div>
	</div>
    <div>
        <table >
        	<thead>
        		<tr>
        			<th></th>
        			<th>게시글 번호</th>
        			<th>제목</th>
        			<th>내용</th>
        			<th>조회수</th>
        			<th>작성일</th>
        		</tr>
        	</thead>
        	<tbody>
       		<c:forEach var="board" items="${bookmarkedBoards }">
       			<tr>
       				<td><i>⭐</i></td>
       				<td><c:out value="${board.bno}"/></td>
       				<td><c:out value="${board.title}"/></td>
       				<td>
       					<a class="moveboard" href="/board/detail?bno=${board.bno }">
       						<c:out value="${board.content}"/>
       					</a>
       				</td>
       				<td><c:out value="${board.hit}"/></td>
       				<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd" /></td>
       			</tr>
       		</c:forEach>
       		</tbody>
        </table>
    </div>
</div>
</body>
</html>
