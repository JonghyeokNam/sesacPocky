<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<spring:url value='/resources/css/pocky_css.css' />" type="text/css" rel="stylesheet">
    <title>My Page</title>
</head>
<body>
    <header>
        <div class="logo">
            <img src="/resources/img/pocky-logo.png" alt="Pocky Logo">
        </div>
        <nav>
        	<form action="/loginAsUser1" method="POST">
        		<input type="hidden" name="_csrf" value="${_csrf.token}" />
        		<button type="submit">Soccer</button>
        	</form>
        	<form action="/loginAsUser2" method="POST">
        		<input type="hidden" name="_csrf" value="${_csrf.token}" />
        		<button type="submit">Climbing</button>
        	</form>
        	<form action="/loginAsUser3" method="POST">
        		<input type="hidden" name="_csrf" value="${_csrf.token}" />
        		<button type="submit">Game</button>
        	</form>
        	<form action="/loginAsUser4" method="POST">
        		<input type="hidden" name="_csrf" value="${_csrf.token}" />
        		<button type="submit">Fitness</button>
        	</form>
        	<form action="/loginAsUser5" method="POST">
        		<input type="hidden" name="_csrf" value="${_csrf.token}" />
        		<button type="submit">Coding</button>
        	</form>
        	<form action="/board/pocky-main">
        		<button>Contact</button>
        	</form>
        </nav>
        <div class="auth-buttons">
        	<button class="my-page">My Page</button>
            <button class="sign-in">Sign in</button>
            <button class="register">Register</button>
        </div>
    </header>