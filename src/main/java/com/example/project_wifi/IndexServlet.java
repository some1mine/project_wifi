package com.example.project_wifi;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final DBConn  dbConn = new DBConn();
	
	public IndexServlet() {
		super();
		System.out.println("IndexServlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IndexServlet doGet");
		try {
			double LAT = Double.parseDouble(req.getParameter("LAT"));
			double LNT = Double.parseDouble(req.getParameter("LNT"));
			System.out.println(LAT + " " + LNT);
			DBConn.insertHistory(LAT, LNT);
			List<Wifi> wifiList = dbConn.getData(LAT, LNT);
			req.setAttribute("wifiList", wifiList);
			req.setAttribute("LAT", LAT);
			req.setAttribute("LNT", LNT);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
