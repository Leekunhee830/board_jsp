<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="My Page"/>
</jsp:include>

<c:set var="dto" value="${requestScope.dto}" scope="page"/>
<c:remove var="dto" scope="request"/>

<c:if test="${dto==null }">
	<script>
		alert("잘못된 ID 혹은 비밀번호입니다.");
		history.back();
	</script>
</c:if>

<form action="modifyLogic.jsp" method="post">
	<input type="hidden" name="user_no" value="${dto.no}">
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th rowspan="2">
				Password
			</th>
			<td>
				<input type="password" name="user_password" value="${dto.password}" required>
			</td>
		</tr>
		<tr>
			<td>
				<input type="password" name="user_repassword" value="${dto.password}" required>
			</td>
		</tr>
		
		<tr>
			<th>
				Nickname
			</th>
			<td>
				<input type="text" name="user_nickname" value="${dto.nickname}">
			</td>
		</tr>
		<tr>
			<th>
				Email
			</th>
			<td>
				<input type="email" name="user_email" value="${dto.email}">
			</td>
		</tr>
		<tr>
			<th>가입날짜</th>
			<td>${dto.regdate}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="확인" onclick="location.href='/myhome'">
				<input type="submit" value="수정">
				<c:if test="${dto.id=='admin'}">
					<input type="button" value="전회원 정보" onclick="location.href='adminpage.jsp'">
				</c:if>
			</td>
		</tr>
	</table>
</form>

<jsp:include page="/layout/footer.jsp"/>