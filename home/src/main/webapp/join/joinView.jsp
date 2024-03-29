<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp">
	<jsp:param name="title" value="Join"/>
</jsp:include>
<script type="text/javascript" src="script.js"></script>
	<form name="joinForm" method="post" action="joinLogic.jsp">
		<h3>회원가입</h3>
		<table border="1" align="center">
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="user_id" placeholder="아이디를 입력하세요" required>
					<input type="button" value="중복확인" onclick="checkId()">
				</td>
			</tr>
			<tr>
				<th rowspan="2">Password</th>
				<td>
					<input type="password" name="user_password" placeholder="비밀번호를 다시입력하세요." required>
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="user_repassword" placeholder="비밀번호를 입력하세요." required>
				</td>
			</tr>
			<tr>
				<th>Nickname</th>
				<td>
					<input type="text" name="user_nickname" placeholder="닉네임을 입력하세요." required>
				</td>
			</tr>
			<tr>
				<th>Email</th>
				<th>
					<input type="text" name="user_email1" size="7">
					<select name="user_email2">
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="daum.com">daum.com</option>
					</select>
				</th>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<script type="text/javascript" src="script.js"></script>
					<input type="button" value="가입" onclick="checkPassword()">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>

<jsp:include page="/layout/footer.jsp"/>