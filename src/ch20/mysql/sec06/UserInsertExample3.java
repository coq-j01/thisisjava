package ch20.mysql.sec06;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import ch20.oracle.sec06.UserInsertExample4;

public class UserInsertExample3 {
   public static void main(String[] args) {
      Connection conn = null;
      try {
    	  	//Properties 컬렉션 생성
			Properties properties = new Properties();
			properties.load(UserInsertExample4.class.getResourceAsStream("database.properties"));

			//주어진 키에 대한 값 읽기
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			//JDBC Driver 등록
			Class.forName(driver);
			
			//연결하기
			conn = DriverManager.getConnection(
					url, 
					username, 
					password
			);	
         
         //매개변수화된 SQL문 작성
         String sql = "" +
            "INSERT INTO users (userid, username, userpassword, userage, useremail) " +
            "VALUES (?, ?, ?, ?, ?)";
         
         //PreparedStatement 얻기 및 값 지정
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, "winter"+System.nanoTime());
         pstmt.setString(2, "한겨울");
         pstmt.setString(3, "12345");
         pstmt.setInt(4, 25);
         pstmt.setString(5, "winter@mycompany.com");
         
         //SQL문 실행
         int rows = pstmt.executeUpdate();
         System.out.println("저장된 행 수: " + rows);
         
         //PreparedStatement 닫기
         pstmt.close();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (IOException e) {
		// TODO Auto-generated catch block
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
