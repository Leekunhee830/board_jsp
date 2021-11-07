package com.home.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.dao.CommentDao;
import com.home.dto.CommentDto;

public class CommentWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		int parentNum=Integer.parseInt(request.getParameter("parent_num"));
		String comment=request.getParameter("user_comment");
		HttpSession session=request.getSession();
		CommentDto dto=new CommentDto();
		CommentDao dao=CommentDao.getInstance();
		
		dto.setId((String)session.getAttribute("currentId"));
		dto.setNickname((String)session.getAttribute("currentNickname"));
		dto.setComment(comment);
		dto.setParentNum(parentNum);
		
		boolean result=dao.insert(dto);
		request.setAttribute("result", result);
		request.setAttribute("state", "write");
		request.setAttribute("parentNum", parentNum);
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("CommentResult.do");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
