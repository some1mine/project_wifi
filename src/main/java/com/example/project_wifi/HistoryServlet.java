package com.example.project_wifi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final DBConn  dbConn = new DBConn();

	public HistoryServlet() {
		super();
		System.out.println("HistoryServlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HistoryServlet doGet");
		try {
			List<History> historyList = DBConn.getHistory();
			req.setAttribute("historyList", historyList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/history.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HistoryServlet Do Post...");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		DBConn.deleteHistory(id);
		resp.sendRedirect("/history");
	}
}
