package ch20.oracle.sec06;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//오라클에서는 게시물 등록시 seq_id를 얻어 등록을 함.
//이때 게시물 등록시 seq_id를 얻어 것을 select 구문으로 구현하고 
//값을 얻는 코드를 작성하시요

public class Board_oracle_hw {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// DB 연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"scott",
					"kosa1004");

			// 1. 시퀀스 번호 얻기
			String seqSql = "SELECT SEQ_BNO.NEXTVAL FROM DUAL";
			pstmt = conn.prepareStatement(seqSql);
			rs = pstmt.executeQuery();

			int bno = 0;

			if (rs.next()) {
				bno = rs.getInt(1);
			}

			rs.close();
			pstmt.close();

			System.out.println("생성된 게시물 번호 : " + bno);

			// 2. 게시글 등록
			String sql = ""
					+ "INSERT INTO boards "
					+ "(bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) "
					+ "VALUES (?, ?, ?, ?, SYSDATE, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, bno);
			pstmt.setString(2, "눈오는 날");
			pstmt.setString(3, "함박눈이 내려요.");
			pstmt.setString(4, "winter");
			pstmt.setString(5, "snow.jpg");
			pstmt.setBlob(6, new FileInputStream("src/ch20/oracle/sec06/snow.jpg"));

			int rows = pstmt.executeUpdate();

			if (rows == 1) {
				System.out.println("게시물 등록 완료!");
			}

			pstmt.close();

			// 3. 등록된 게시글 확인
			String selectSql = "SELECT * FROM boards WHERE bno = ?";

			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("------------------------");
				System.out.println("번호 : " + rs.getInt("bno"));
				System.out.println("제목 : " + rs.getString("btitle"));
				System.out.println("내용 : " + rs.getString("bcontent"));
				System.out.println("작성자 : " + rs.getString("bwriter"));
				System.out.println("------------------------");
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}
}