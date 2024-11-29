<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pageNav" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>축구 동호회</title>
<span><sec:authentication property="principal.member.name"/></span>
<jsp:include page="../jsp/webLib.jsp" />
<style>
	.dataRow>.card-header{
		background: #e0e0e0;
	}
	.dataRow:hover{
		border-color:orange;
		cursor:pointer;
	}
</style>
<script type="text/javascript">
$(function(){
	// 이벤트 처리
	// 글보기 이동 처리
	$(".dataRow").click(function(){
		let no = $(this).data("no");
		 //alert(no);
		location = "view.do?no=" + no + "&inc=1"
		+ "&${pageObject.pageQuery}";
		
	});
});
</script>
</head>
<body>
<jsp:include page="../jsp/include/header.jsp" />

    
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>축구 동호회</h2>
			</div>
			<div class="card-body">
				<c:forEach items="${list }" var="vo">
					<div class="card dataRow" data-no="${vo.bno }">
						<div class="card-header">
							<span class="float-right">조회수 : ${vo.hit }</span>
							글번호 :  ${vo.bno }
						</div>
						<div class="card-body">
							<pre>${vo.title }</pre>
						</div>
						<div class="card-footer">
							<span class="float-right">
								<fmt:formatDate value="${vo.writeDate }"
									pattern="yyyy-MM-dd"/> 								
							</span>
							 ${vo.member_id }
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="card-footer">
			<div>
				<pageNav:pageNav listURI="list.do" pageObject="${pageObject }"></pageNav:pageNav>
				<a href="writeForm.do" class="btn btn-primary"  style="float:right">글등록</a>
			</div>
		 		
		 	</div>
		</div>

	</div>
	<jsp:include page="../jsp/include/footer.jsp" />
</body>
</html>