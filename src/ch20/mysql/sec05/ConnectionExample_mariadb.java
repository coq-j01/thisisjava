package ch20.mysql.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//mariadb 연결
public class ConnectionExample_mariadb {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//JDBC Driver 등록
			Class.forName("org.mariadb.jdbc.Driver");
			
			//연결하기
			conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:23306/kosa_db", 
				"root", 
				"kosa1004"
			);	
			
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try { 
					//연결 끊기
					conn.close(); 
					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}
	}
}
