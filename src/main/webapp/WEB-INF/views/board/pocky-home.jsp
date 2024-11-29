<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@include file="../include/header.jsp" %>

    <div class="personal-info">	
    	<i class="my-page">로그인 성공</i>
    	<h2>Welcome, <sec:authentication property="principal"/></h2>
    	<h2>Welcome, <sec:authentication property="principal.name"/></h2>  <!-- 로그인한 사용자의 아이디 출력 -->
	    
	    <p>Your role: <sec:authentication property="principal.authority"/></p>  <!-- 사용자의 권한 출력 -->
	
	    <%-- <c:if test="${principal != null and principal.authorities[0].authority == 'ROLE_USER'}">
	        <p>Welcome User! You have access to this page.</p>
	    </c:if> --%>

    </div>
</body>
</html>
