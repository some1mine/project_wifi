package com.example.project_wifi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "load-wifi", urlPatterns = { "/load-wifi" })
public class LoadWiFi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int listTotalCount;
	public static final DBConn  dbConn = new DBConn();
    public LoadWiFi() {
        super();

        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		int cnt = 0;
		int start = 1;
		int end = 200;
		boolean flag = true;
		try {
			DBConn.createTable();
			DBConn.createHistory();
			DBConn.createBookmarkGroup();
			DBConn.createBookmarkTable();
			while(flag) {
				StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
				urlBuilder.append("/" +  URLEncoder.encode("6150486a57736f6d39336946504169","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
				urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
				urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
				urlBuilder.append("/" + URLEncoder.encode(Integer.toString(start),"UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
				urlBuilder.append("/" + URLEncoder.encode(Integer.toString(end),"UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
				// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.

				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-type", "application/json");
				System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
				BufferedReader rd;

				// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
				if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} else {
					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				}
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = rd.readLine()) != null) {
					if(line.contains("없습니다.")) {
						flag = false; break;
					}
					line = line.replace("'", "''");
					JsonObject jsonObject = (JsonObject) JsonParser.parseString(line);
					JsonObject TbPublicWifiInfo = (JsonObject) jsonObject.get("TbPublicWifiInfo");
					listTotalCount = TbPublicWifiInfo.get("list_total_count").getAsInt();
					JsonArray jsonArray = (JsonArray) TbPublicWifiInfo.get("row");
					Gson gson = new Gson();
					Wifi[] datas = gson.fromJson(jsonArray.toString(), Wifi[].class);
					for(Wifi wifi : datas) {
						System.out.println(wifi.toString());
						dbConn.insert(wifi);
					}
					sb.append(line).append("\n");
				}
				rd.close();
				start += 200;
				end += 200;
				System.out.println(sb);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(cnt);

		response.sendRedirect("/load-wifi.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
