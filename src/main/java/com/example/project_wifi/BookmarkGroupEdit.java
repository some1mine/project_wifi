package com.example.project_wifi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookmark-group-edit")
public class BookmarkGroupEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final DBConn dbConn = new DBConn();

	public BookmarkGroupEdit() {
		super();
		System.out.println("BookmarkGroupEdit");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookmarkGroupEdit doGet");
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			BookmarkGroup group = DBConn.getBookmarkGroup(id);
			req.setAttribute("group", group);
			req.setAttribute("id", id);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/bookmark-group-edit.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookmarkGroupEdit Do Post...");
		req.setCharacterEncoding("UTF-8");
		String bookmarkName = req.getParameter("bookmark_name");
		int ord = Integer.parseInt(req.getParameter("ord"));
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(bookmarkName + " " + ord);
		DBConn.updateBookmarkGroup(bookmarkName, ord, id);
		resp.sendRedirect("/bookmark-group");
	}
}
