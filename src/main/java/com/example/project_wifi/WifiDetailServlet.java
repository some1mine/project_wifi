package com.example.project_wifi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/wifiDetail")
public class WifiDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final DBConn  dbConn = new DBConn();

	public WifiDetailServlet() {
		super();
		System.out.println("WifiDetailServlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("WifiDetailServlet doGet");
		try {
			double LAT = Double.parseDouble(req.getParameter("LAT"));
			double LNT = Double.parseDouble(req.getParameter("LNT"));
			String X_SWIFI_MAIN_NM = req.getParameter("X_SWIFI_MAIN_NM");
			System.out.println(X_SWIFI_MAIN_NM + " " + LAT + " " + LNT);
			Wifi wifi = DBConn.getWifi(LAT, LNT, X_SWIFI_MAIN_NM);
			List<BookmarkGroup> groupList = DBConn.getAllBookmarkGroup();
			req.setAttribute("groupList", groupList);
			req.setAttribute("wifi", wifi);
			req.setAttribute("LAT", LAT);
			req.setAttribute("LNT", LNT);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/wifi-detail.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("WifiDetailServlet Do Post...");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		DBConn.deleteHistory(id);
		resp.sendRedirect("/history");
	}
}
