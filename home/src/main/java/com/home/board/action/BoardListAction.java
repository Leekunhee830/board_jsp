package com.home.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.dao.BoardDao;
import com.home.dto.BoardDto;

public class BoardListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page=Integer.parseInt(request.getParameter("page"));
		BoardDao dao=BoardDao.getInstance();
		ArrayList<BoardDto> list=dao.getList(page);
		int totalpages=dao.getTotalPages();
		ActionForward actionForward=new ActionForward();
		
		
		request.setAttribute("totalPages", totalpages);
		request.setAttribute("list", list);
		request.setAttribute("currentPage", page);
		actionForward.setNextPath("BoardListView.do");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
