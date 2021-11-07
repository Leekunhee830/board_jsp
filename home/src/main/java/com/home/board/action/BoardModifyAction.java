package com.home.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.BoardDao;

public class BoardModifyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao dao=BoardDao.getInstance();
		ActionForward actionForward=new ActionForward();
		boolean result=false;
		
		request.setCharacterEncoding("UTF-8");
		
		int num=Integer.parseInt(request.getParameter("board_num"));
		String newTitle=request.getParameter("board_title");
		String newContent=request.getParameter("board_content");
		
		result=dao.update(num, newTitle, newContent);
		request.setAttribute("state", "modify");
		request.setAttribute("result", result);
		
		actionForward.setNextPath("Result.do");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
