package com.home.member;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.MemberDao;


@WebServlet("/findid/findIdLogic.jsp")
public class FindId extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email=request.getParameter("user_email");
		
		MemberDao dao=new MemberDao();
		String id=dao.findIdbyEmail(email);
		
		if(id!=null){
			int index=id.length()-2;
			String tmpId=id.substring(0,2);
			
			for(int i=0;i<index;++i){
				tmpId+="*";
			}
			id=tmpId;
			request.setAttribute("id", id);
		}	
		//PageContext.forward("findidResultView.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("findIdResultView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
