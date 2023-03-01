package com.example.project_wifi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookmark-group")
public class BookmarkGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final DBConn dbConn = new DBConn();

	public BookmarkGroupServlet() {
		super();
		System.out.println("BookmarkGroupServlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookmarkGroupServlet doGet");
		try {
			List<BookmarkGroup> groupList = DBConn.getAllBookmarkGroup();
			req.setAttribute("groupList", groupList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/bookmark-group.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookmarkGroupServlet Do Post...");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		DBConn.deleteBookmarkGroup(id);
		resp.sendRedirect("/bookmark-group");
	}
}
