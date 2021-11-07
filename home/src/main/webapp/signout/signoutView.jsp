<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Sign out"/>
</jsp:include>

	<form action="signoutLogic.jsp" method="post">
		<caption><h3>회원탈퇴</h3></caption>
		<table border="1">
			<tr>
				<td><input type="text" name="user_id" placeholder="아이디를 입력하세요."></td>
			</tr>
			<tr>
				<td><input type="password" name="user_password" placeholder="비밀번호를 입력하세요."></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="탈퇴"></td>
			</tr>
			
		</table>
	</form>

<jsp:include page="/layout/footer.jsp"/>