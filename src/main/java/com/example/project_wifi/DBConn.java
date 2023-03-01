package com.example.project_wifi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConn {
	public static Connection connectDB() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void createTable() {
		
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS WIFI("
					+ "X_SWIFI_MGR_NO VARCHAR(20),"
					+ "X_SWIFI_WRDOFC VARCHAR(10),"
					+ "X_SWIFI_MAIN_NM VARCHAR(100),"
					+ "X_SWIFI_ADRES1 VARCHAR(200),"
					+ "X_SWIFI_ADRES2 VARCHAR(1000),"
					+ "X_SWIFI_INSTL_FLOOR VARCHAR(20),"
					+ "X_SWIFI_INSTL_TY VARCHAR(200),"
					+ "X_SWIFI_INSTL_MBY VARCHAR(50),"
					+ "X_SWIFI_SVC_SE VARCHAR(20),"
					+ "X_SWIFI_CMCWR VARCHAR(50),"
					+ "X_SWIFI_CNSTC_YEAR INTEGER,"
					+ "X_SWIFI_INOUT_DOOR VARCHAR(5),"
					+ "X_SWIFI_REMARS3 VARCHAR(200),"
					+ "LAT REAL,"
					+ "LNT REAL,"
					+ "WORK_DTTM VARCAHR(40),"
					+ "PRIMARY KEY (X_SWIFI_MAIN_NM, X_SWIFI_ADRES1))";

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}
	public static void createHistory() {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS HISTORY("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "LAT REAL,"
					+ "LNT REAL,"
					+ "WORK_DTTM VARCAHR(40))";

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}
	public static void createBookmarkGroup() {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS BOOK_MARK_GROUP("
					+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "BOOKMARK_NAME VARCHAR(100),"
					+ "ORD INTEGER,"
					+ "REGISTER_DATE VARCHAR(40),"
					+ "UPDATE_DATE VARCAHR(40))";

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}
	public static void createBookmarkTable() {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS BOOK_MARK("
					+ "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "BOOKMARK_NAME VARCHAR(100),"
					+ "WIFI_NAME VARCHAR(100),"
					+ "REGISTER_DATE VARCHAR(40),"
					+ "FOREIGN KEY (BOOKMARK_NAME) REFERENCES BOOK_MARK_GROUP(BOOKMARK_NAME) ON DELETE CASCADE)";

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}

	public static void insert(Wifi wifi) {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "INSERT OR IGNORE INTO WIFI VALUES ("
				+ "'" + wifi.getX_SWIFI_MGR_NO() + "', "
					+ "'" + wifi.getX_SWIFI_WRDOFC() + "', "
					+ "'" + wifi.getX_SWIFI_MAIN_NM() + "', "
					+ "'" + wifi.getX_SWIFI_ADRES1() + "', "
					+ "'" + wifi.getX_SWIFI_ADRES2() + "', "
					+ "'" + wifi.getX_SWIFI_ADRES2() + "', "
					+ "'" + wifi.getX_SWIFI_INSTL_TY() + "', "
					+ "'" + wifi.getX_SWIFI_INSTL_MBY() + "', "
					+ "'" + wifi.getX_SWIFI_SVC_SE() + "', "
					+ "'" + wifi.getX_SWIFI_CMCWR() + "', "
					+ wifi.getX_SWIFI_CNSTC_YEAR() + ", "
					+ "'" + wifi.getX_SWIFI_INOUT_DOOR() + "', "
					+ "'" + wifi.getX_SWIFI_REMARS3() + "', "
					+ wifi.getLNT() + ", "
					+ wifi.getLAT() + ", "
					+ "'" + wifi.getWORK_DTTM() + "')";

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}
	public static void insertHistory(double LAT, double LNT) {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "INSERT INTO HISTORY (LAT, LNT, WORK_DTTM) VALUES (" + LAT + ", " + LNT + ", " + "DATETIME('now' , 'LOCALTIME'))";

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}
	public static void insertBookmarkGroup(String bookmarkName, int ord) {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "INSERT INTO BOOK_MARK_GROUP (BOOKMARK_NAME, ORD, REGISTER_DATE) VALUES ('" + bookmarkName + "', " + ord + ", " + "DATETIME('now' , 'LOCALTIME'))";

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}

	public static void insertBookmark(String bookmarkName, String wifiName) {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "INSERT INTO BOOK_MARK (BOOKMARK_NAME, WIFI_NAME, REGISTER_DATE) VALUES ('" + bookmarkName +  "', '" + wifiName + "', DATETIME('now' , 'LOCALTIME'))";

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}
	public static List<Wifi> getData(double LAT, double LNT) {
		List<Wifi> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "SELECT " +
				" 6371 * ACOS ( COS ( RADIANS ( " + LAT  + " ) ) * COS ( RADIANS ( LAT ) )" +
				"    * COS ( RADIANS ( LNT ) - RADIANS ( + " + LNT + " ) ) " +
				"    + SIN ( RADIANS ( " + LAT + " ) ) * SIN ( RADIANS ( LAT ) ) ) AS DISTANCE, *" +
				" FROM WIFI ORDER BY DISTANCE" +
				" LIMIT 20";
		conn = connectDB();
		try {
			stmt = conn.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				Wifi wifi = new Wifi();
				wifi.setDistance(resultSet.getString("DISTANCE"));
				wifi.setX_SWIFI_MGR_NO(resultSet.getString("X_SWIFI_MGR_NO"));
				wifi.setX_SWIFI_WRDOFC(resultSet.getString("X_SWIFI_WRDOFC"));
				wifi.setX_SWIFI_MAIN_NM(resultSet.getString("X_SWIFI_MAIN_NM"));
				wifi.setX_SWIFI_ADRES1(resultSet.getString("X_SWIFI_ADRES1"));
				wifi.setX_SWIFI_ADRES2(resultSet.getString("X_SWIFI_ADRES2"));
				wifi.setX_SWIFI_INSTL_FLOOR(resultSet.getString("X_SWIFI_INSTL_FLOOR"));
				wifi.setX_SWIFI_INSTL_TY(resultSet.getString("X_SWIFI_INSTL_TY"));
				wifi.setX_SWIFI_INSTL_MBY(resultSet.getString("X_SWIFI_INSTL_MBY"));
				wifi.setX_SWIFI_SVC_SE(resultSet.getString("X_SWIFI_SVC_SE"));
				wifi.setX_SWIFI_CMCWR(resultSet.getString("X_SWIFI_CMCWR"));
				wifi.setX_SWIFI_CNSTC_YEAR(resultSet.getInt("X_SWIFI_CNSTC_YEAR"));
				wifi.setX_SWIFI_INOUT_DOOR(resultSet.getString("X_SWIFI_INOUT_DOOR"));
				wifi.setX_SWIFI_REMARS3(resultSet.getString("X_SWIFI_REMARS3"));
				wifi.setLAT(resultSet.getDouble("LAT"));
				wifi.setLNT(resultSet.getDouble("LNT"));
				wifi.setWORK_DTTM(resultSet.getString("WORK_DTTM"));
				list.add(wifi);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				resultSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}
	public static Wifi getWifi(double LAT, double LNT, String X_SWIFI_MAIN_NM) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		Wifi wifi = new Wifi();
		String sql = "SELECT " +
				" 6371 * ACOS ( COS ( RADIANS ( " + LAT  + " ) ) * COS ( RADIANS ( LAT ) )" +
				"    * COS ( RADIANS ( LNT ) - RADIANS ( + " + LNT + " ) ) " +
				"    + SIN ( RADIANS ( " + LAT + " ) ) * SIN ( RADIANS ( LAT ) ) ) AS DISTANCE, *" +
				" FROM WIFI WHERE X_SWIFI_MAIN_NM = '" + X_SWIFI_MAIN_NM + "'";
		conn = connectDB();
		try {
			stmt = conn.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				wifi.setDistance(resultSet.getString("DISTANCE"));
				wifi.setX_SWIFI_MGR_NO(resultSet.getString("X_SWIFI_MGR_NO"));
				wifi.setX_SWIFI_WRDOFC(resultSet.getString("X_SWIFI_WRDOFC"));
				wifi.setX_SWIFI_MAIN_NM(resultSet.getString("X_SWIFI_MAIN_NM"));
				wifi.setX_SWIFI_ADRES1(resultSet.getString("X_SWIFI_ADRES1"));
				wifi.setX_SWIFI_ADRES2(resultSet.getString("X_SWIFI_ADRES2"));
				wifi.setX_SWIFI_INSTL_FLOOR(resultSet.getString("X_SWIFI_INSTL_FLOOR"));
				wifi.setX_SWIFI_INSTL_TY(resultSet.getString("X_SWIFI_INSTL_TY"));
				wifi.setX_SWIFI_INSTL_MBY(resultSet.getString("X_SWIFI_INSTL_MBY"));
				wifi.setX_SWIFI_SVC_SE(resultSet.getString("X_SWIFI_SVC_SE"));
				wifi.setX_SWIFI_CMCWR(resultSet.getString("X_SWIFI_CMCWR"));
				wifi.setX_SWIFI_CNSTC_YEAR(resultSet.getInt("X_SWIFI_CNSTC_YEAR"));
				wifi.setX_SWIFI_INOUT_DOOR(resultSet.getString("X_SWIFI_INOUT_DOOR"));
				wifi.setX_SWIFI_REMARS3(resultSet.getString("X_SWIFI_REMARS3"));
				wifi.setLAT(resultSet.getDouble("LAT"));
				wifi.setLNT(resultSet.getDouble("LNT"));
				wifi.setWORK_DTTM(resultSet.getString("WORK_DTTM"));
				return wifi;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				resultSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return wifi;
	}
	public static List<History> getHistory() {
		List<History> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM HISTORY";
		conn = connectDB();
		try {
			stmt = conn.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				History history = new History();
				history.setId(resultSet.getInt("ID"));
				history.setLAT(resultSet.getDouble("LAT"));
				history.setLNT(resultSet.getDouble("LNT"));
				history.setWORK_DTTM(resultSet.getString("WORK_DTTM"));
				list.add(history);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				resultSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}
	public static List<BookmarkGroup> getAllBookmarkGroup() {
		List<BookmarkGroup> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM BOOK_MARK_GROUP ORDER BY ORD DESC";
		conn = connectDB();
		try {
			stmt = conn.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				BookmarkGroup group = new BookmarkGroup();
				group.setId(resultSet.getInt("ID"));
				group.setOrd(resultSet.getInt("ORD"));
				group.setBookmarkName(resultSet.getString("BOOKMARK_NAME"));
				group.setRegisterDate(resultSet.getString("REGISTER_DATE"));
				group.setUpdateDate(resultSet.getString("UPDATE_DATE"));
				list.add(group);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				resultSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}
	public static BookmarkGroup getBookmarkGroup(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		BookmarkGroup group = new BookmarkGroup();
		String sql = "SELECT * FROM BOOK_MARK_GROUP WHERE ID = " + id;
		conn = connectDB();
		try {
			stmt = conn.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				group.setId(resultSet.getInt("ID"));
				group.setOrd(resultSet.getInt("ORD"));
				group.setBookmarkName(resultSet.getString("BOOKMARK_NAME"));
				group.setRegisterDate(resultSet.getString("REGISTER_DATE"));
				group.setUpdateDate(resultSet.getString("UPDATE_DATE"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				resultSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return group;
	}

	public static List<Bookmark> getAllBookmark() {
		List<Bookmark> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM BOOK_MARK ORDER BY ID";
		conn = connectDB();
		try {
			stmt = conn.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				Bookmark bookmark = new Bookmark();
				bookmark.setId(resultSet.getInt("ID"));
				bookmark.setBookmarkName(resultSet.getString("BOOKMARK_NAME"));
				bookmark.setWifiName(resultSet.getString("WIFI_NAME"));
				bookmark.setRegisterDate(resultSet.getString("REGISTER_DATE"));
				list.add(bookmark);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				resultSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}
	public static void deleteHistory(int id) {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "DELETE FROM HISTORY WHERE ID = " + id;

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}
	public static void deleteBookmarkGroup(int id) {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "DELETE FROM BOOK_MARK_GROUP WHERE ID = " + id;

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}

	public static void deleteBookmark(int id) {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "DELETE FROM BOOK_MARK WHERE ID = " + id;

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}

	public static void updateBookmarkGroup(String bookmarkName, int ord, int id) {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
			System.out.println("Connected");

			stmt = c.createStatement();

			String sql = "UPDATE BOOK_MARK_GROUP SET BOOKMARK_NAME = '" + bookmarkName + "', ORD = " + ord + ", UPDATE_DATE = DATETIME('now' , 'LOCALTIME')" +
					"WHERE ID = " + id;

			stmt.executeUpdate(sql);

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		List<History> list = getHistory();
		for(History history : list) System.out.println(history.toString());
		connectDB();
	}

}
