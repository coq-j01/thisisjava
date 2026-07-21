package ch20.mysql.sec06;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//mysql 에서는 게시물 등록후 자동으로 증가하는 ID를 얻는 sql 구문은 
//SELECT LAST_INSERT_ID() 을 사용하여 얻음. 
//즉 새로게 등록된 게시물의 id를 얻는 코드를 위코드를 사용하여 구현해보세요

public class Board_mysql_hw {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// JDBC Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB 연결
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:13306/kosa_db", 
					"scott", 
					"kosa1004"
					);

			// 게시글 등록
			String sql =
					"INSERT INTO boards " +
					"(btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
					"VALUES (?, ?, ?, NOW(), ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "눈오는 날");
			pstmt.setString(2, "함박눈이 내려요.");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "snow.jpg");
			pstmt.setBlob(5,
					new FileInputStream("src/ch20/mysql/sec06/snow.jpg"));

			int rows = pstmt.executeUpdate();
			pstmt.close();

			if (rows == 1) {
				System.out.println("게시물 등록 성공!");

				// 방금 등록된 AUTO_INCREMENT 번호 얻기
				String sqlId = "SELECT LAST_INSERT_ID()";

				pstmt = conn.prepareStatement(sqlId);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					int bno = rs.getInt(1);

					System.out.println("새로 등록된 게시물 번호 : " + bno);
				}

				rs.close();
				pstmt.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}
}