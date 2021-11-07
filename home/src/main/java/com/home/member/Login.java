package com.home.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.dao.MemberDao;
import com.home.dto.MemberDto;


@WebServlet("/login/loginLogic.jsp")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("user_id");
		String password=request.getParameter("user_password");
		
		MemberDao dao=new MemberDao();
		MemberDto dto=dao.select(id, password);
		
		boolean rememberMe=Boolean.parseBoolean(request.getParameter("remember_me"));
		
		if(rememberMe) {
			Cookie cookie=new Cookie("rememberId",id);
			cookie.setMaxAge(60*60*24);
			cookie.setPath("/");
			response.addCookie(cookie);
		}else {
			Cookie cookie=new Cookie("rememberId",null);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		if(dto!=null){
			//request.setAttribute("nickname",dto.getNickname());
			HttpSession session=request.getSession();
			session.setAttribute("currentNickname",dto.getNickname());
			session.setAttribute("currentId", dto.getId());
		}else{
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("loginResultView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
