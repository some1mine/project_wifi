package com.example.project_wifi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookmark-add")
public class BookmarkAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final DBConn dbConn = new DBConn();

	public BookmarkAdd() {
		super();
		System.out.println("BookmarkAdd");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookmarkAdd doGet");
		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/bookmark-group.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BookmarkAdd Do Post...");
		req.setCharacterEncoding("UTF-8");
		String bookmarkName = req.getParameter("bookmark_group");
		String wifiName = req.getParameter("wifiName");
		System.out.println(bookmarkName + " " + wifiName);
		DBConn.insertBookmark(bookmarkName, wifiName);
		resp.sendRedirect("/bookmark-list");
	}
}
