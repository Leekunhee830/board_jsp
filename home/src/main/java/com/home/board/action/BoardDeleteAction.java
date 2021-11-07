package com.home.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.BoardDao;

public class BoardDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int brdNum=Integer.parseInt(request.getParameter("brdNo"));
		boolean result=false;
		ActionForward actionForward=null;
		BoardDao dao=null;
		result=dao.getInstance().delete(brdNum);
		
		request.setAttribute("state", "delete");
		request.setAttribute("result", result);
		
		actionForward=new ActionForward();
		actionForward.setNextPath("Result.do");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
