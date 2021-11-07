package com.home.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.board.action.Action;
import com.home.board.action.ActionForward;
import com.home.board.action.BoardDeleteAction;
import com.home.board.action.BoardListAction;
import com.home.board.action.BoardModifyAction;
import com.home.board.action.BoardReadAction;
import com.home.board.action.BoardWriteAction;
import com.home.board.action.CommentDeleteAction;
import com.home.board.action.CommentWriteAction;


@WebServlet("*.do")
public class Controller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI=request.getRequestURI();
		int lastIndex=requestURI.lastIndexOf("/")+1;
		String requestPage=requestURI.substring(lastIndex);
		
		System.out.println("requestURI: "+requestURI);
		System.out.println("requestPage: "+requestPage);
		
		Action action=null;
		ActionForward actionForward=null;
		
		try {
			if(requestPage.equals("BoardList.do")) {
				action=new BoardListAction();
				actionForward=action.execute(request,response);
			}
			else if(requestPage.equals("BoardListView.do")) {
				actionForward=new ActionForward();
				actionForward.setNextPath("boardListView.jsp");
				actionForward.setRedirect(false);
			}
			else if(requestPage.equals("BoardWriteForm.do")) {
				actionForward=new ActionForward();
				actionForward.setNextPath("boardWriteView.jsp");
				actionForward.setRedirect(false);
			}
			else if(requestPage.equals("BoardWrite.do")) {
				action=new BoardWriteAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("Result.do")) {
				actionForward=new ActionForward();
				actionForward.setNextPath("boardResultView.jsp");
				actionForward.setRedirect(false);
			}
			else if(requestPage.equals("BoardRead.do")) {
				action=new BoardReadAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("BoardReadView.do")) {
				actionForward=new ActionForward();
				actionForward.setNextPath("boardReadView.jsp");
				actionForward.setRedirect(false);
			}
			else if(requestPage.equals("BoardDelete.do")) {
				action=new BoardDeleteAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("BoardModify.do")) {
				action=new BoardReadAction();
				actionForward=action.execute(request, response);
				actionForward.setNextPath("BoardModifyForm.do");
				actionForward.setRedirect(false);
			}
			else if(requestPage.equals("BoardModifyForm.do")) {
				actionForward=new ActionForward();
				actionForward.setNextPath("boardModifyView.jsp");
				actionForward.setRedirect(false);
			}
			else if(requestPage.equals("BoardModifyAction.do")) {
				action=new BoardModifyAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("CommentWrite.do")) {
				action=new CommentWriteAction();
				actionForward=action.execute(request, response);
			}
			else if(requestPage.equals("CommentResult.do")) {
				actionForward=new ActionForward();
				actionForward.setNextPath("commentResultView.jsp");
				actionForward.setRedirect(false);
			}
			else if(requestPage.equals("CommentDelete.do")) {
				action=new CommentDeleteAction();
				actionForward=action.execute(request, response);
			}
			
			if(actionForward!=null) {
				if(actionForward.isRedirect()) {
					response.sendRedirect(actionForward.getNextPath());
				}else {
					request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
