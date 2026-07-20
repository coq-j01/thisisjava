package ch20.oracle.sec06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInsertExample0 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결하기
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/xe", 
				"scott", 
				"kosa1004"
			);	
			
			//매개변수화된 SQL 문 작성
			String sql = "INSERT INTO users (userid, username, userpassword, userage, useremail) VALUES('userid3', 'username', 'userpassword', 20, 'useremail')";
			
			//Statement 얻기 및 값 지정
			Statement stmt = conn.createStatement();
			
			//SQL 문 실행
			int rows = stmt.executeUpdate(sql);
			System.out.println("저장된 행 수: " + rows);
			
			//Statement 닫기
			stmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try { 
					//연결 끊기
					conn.close(); 
				} catch (SQLException e) {}
			}
		}
	}
}