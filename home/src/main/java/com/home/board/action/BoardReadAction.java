package com.home.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.dao.BoardDao;
import com.home.dao.CommentDao;
import com.home.dto.BoardDto;
import com.home.dto.CommentDto;

public class BoardReadAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward=new ActionForward();
		BoardDao dao=null;
		BoardDto dto=new BoardDto();
		CommentDao commentDao=CommentDao.getInstance();
		HttpSession session=request.getSession();
		dao=BoardDao.getInstance();
		
		int boardNum=Integer.parseInt(request.getParameter("brdNo"));
		String attName="brd_"+boardNum;
		
		ArrayList<CommentDto> commentList=commentDao.getList(boardNum);
		
		if(session.getAttribute(attName)==null) {
			dao.updateHit(boardNum);
			session.setAttribute(attName, "Y");
		}
		
		dto=dao.select(boardNum);
		request.setAttribute("brdDto", dto);
		request.setAttribute("commentList", commentList);
		
		actionForward.setNextPath("BoardReadView.do");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
