<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${param.title!=null?param.title:"My WebPage!"}</title>
		<link rel="stylesheet" type="text/css" href="/home/layout/layout.css">
		
	</head>
	<body>
		<div align = "center">
			<div class = "header" align = "center">
			<c:choose>
				<c:when test="${sessionScope.currentNickname==null}">
					<a href="/home/login/loginView.jsp">LOGIN</a> |
					<a href="/home/join/joinView.jsp">JOIN </a>| 
				</c:when>
				<c:otherwise>
					${sessionScope.currentNickname }님 |
					<a href="/home/logout/logoutLogic.jsp">LOGOUT</a> | 
					<a href="/home/mypage/mypageView.jsp">MY PAGE</a> |
				</c:otherwise>
			</c:choose>
			<a href="/home/board/BoardList.do?page=1">BOARD </a>
			</div>
			<div class="main" align="center">
			

