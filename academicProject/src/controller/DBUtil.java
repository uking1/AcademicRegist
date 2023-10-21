package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	static final String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	static final String driver = "oracle.jdbc.driver.OracleDriver";

	public static Connection getConnection() throws Exception {

		Properties properties = new Properties();
		Connection con = null;
		try {
			FileInputStream fis = new FileInputStream("src/config/db.properties");
			properties.load(fis);
			String driber = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("연결성공");
		} catch (IOException e) {
			System.out.println(e);
		}
		return con;
	}

}