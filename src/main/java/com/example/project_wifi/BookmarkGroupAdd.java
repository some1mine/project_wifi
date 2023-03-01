package com.example.project_wifi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookmark-group-add")
public class BookmarkGroupAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final DBConn dbConn = new DBConn();

	public BookmarkGroupAdd() {
		super();
		System.out.println("BookmarkGroupAdd");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookmarkGroupAdd doGet");
		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/bookmark-group.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookmarkGroupAdd Do Post...");
		req.setCharacterEncoding("UTF-8");
		String bookmarkName = req.getParameter("bookmark_name");
		int ord = Integer.parseInt(req.getParameter("ord"));
		System.out.println(bookmarkName + " " + ord);
		DBConn.insertBookmarkGroup(bookmarkName, ord);
		resp.sendRedirect("/bookmark-group");
	}
}
