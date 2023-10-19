package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static Connection makeConnection() {
		String ur1 = "jdbc:oracle:thin:@127.0.0.1:1521";
		String user = "javauser";
		String pwd = "javauser";
		Connection con = null;
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 오라클데이타베이스 연결
			con = DriverManager.getConnection(ur1,user,pwd);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("오라클 적재 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("오라클 접속 실패");
		}	
		return con;
	}

	public static void main(String[] args) {
		Connection con = makeConnection();
		
	}
}
