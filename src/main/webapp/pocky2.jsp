<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../resources/css/pocky_css.css" type="text/css" rel="stylesheet">
    <title>My Page</title>
</head>
<body>
    <header>
        <div class="logo">
            <img src="../resources/img/pocky-logo.png" alt="Pocky Logo">
        </div>
        <nav>
            <a href="#">Soccer</a>
            <a href="#">Climbing</a>
            <a href="#">Game</a>
            <a href="#">Fitness</a>
            <a href="#">Coding</a>
            <a href="#">Contact</a>
        </nav>
        <div class="auth-buttons">
            <button class="sign-in">Sign in</button>
            <button class="register">Register</button>
        </div>
    </header>
    <div class="personal-info">	
    	<i class="my-page">마이 페이지</i>
		<div class="personal-details">
		    <div class="left">
		        <i>⭐</i>
		        <span>NAME</span>
		    </div>
		    <div class="right">
		        <span>Sesac</span>
		    </div>
		</div>
		
		<div class="personal-details">
		    <div class="left">
		        <i>⭐</i>
		        <span>PHONE NUMBER</span>
		    </div>
		    <div class="right">
		        <span>02-2088-2792</span>
		    </div>
		</div>
		
		<div class="personal-details">
		    <div class="left">
		        <i>⭐</i>
		        <span>EMAIL</span>
		    </div>
		    <div class="right">
		        <span>sesac@sba.seoul.kr</span>
		    </div>
		</div>
		<div class="personal-details">
		    <div class="left">
		        <i>⭐</i>
		        <span>MY CLUB</span>
		    </div>
		    <div class="right">
		        <span>서울경제진흥원</span>
		    </div>
		</div>
    </div>
    <div class="move-icon">
        <button class="move-detail">⭐</button>
        <button class="move-detail">👤</button>
    </div>
</body>
</html>
