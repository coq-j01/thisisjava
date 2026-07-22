package ch20.oracle.sec13.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ch20.oracle.sec13.entity.Board;
import ch20.oracle.sec13.util.DBUtil;

public class BoardRepository {
	//Field
	Connection conn = DBUtil.getConnection();
	Scanner scanner = new Scanner(System.in);
	
	//Method		
	public List<Board> list() {
		List<Board> array = new ArrayList<Board>();
		
		try {
			//매개변수화된 SQL 문 작성
			String sql = "SELECT bno, bwriter, to_char(bdate, 'YYYY.MM.DD') bdate, btitle FROM boards order by bno desc";
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//SQL 문 실행 후, ResultSet을 통해 데이터 읽기
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {		
				//데이터 행을 읽고 Board 객체 생성
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getString("bdate"));
				
				array.add(board);
			}
			rs.close();
			
			//PreparedStatement 닫기
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return array;
	}
	
	public int clear() {
		int rows = 0;
		try {
			//매개변수화된 SQL 문 작성
			String sql = "DELETE FROM boards";
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//SQL 문 실행
			rows = pstmt.executeUpdate();
			
			//PreparedStatement 닫기
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	public Board findById(Board board) {
		try {

			//매개변수화된 SQL 문 작성
			String sql = "" +
				"SELECT bno, btitle, bcontent, bwriter, bdate " +
				"FROM boards " +
				"WHERE bno=?";
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			
			//SQL 문 실행 후, ResultSet을 통해 데이터 읽기
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {		
				//데이터 행을 읽고 Board 객체 생성
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getString("bdate"));				
			} else {
				board = null;
			}
			rs.close();
			
			//PreparedStatement 닫기
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	public Board insert(Board board) {
		try {
            // SQL 작성
            String sql = "SELECT SEQ_BNO.NEXTVAL FROM DUAL";

            // PreparedStatement 생성
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // SQL 실행
            ResultSet rs = pstmt.executeQuery();

            // 결과 읽기
            int bno = 0;
            if (rs.next()) {
            	bno = rs.getInt(1);
                System.out.println("게시글 번호 : " + bno);
            }
			
            rs.close();
            pstmt.close();
			
			//매개변수화된 SQL 문 작성
			sql = "" +
				"INSERT INTO boards (bno, btitle, bcontent, bwriter) " +
				"VALUES (?, ?, ?, ?)";
			
			//PreparedStatement 얻기 및 값 지정
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setString(4, board.getBwriter());
			
			//SQL 문 실행
			int rows = pstmt.executeUpdate();
			
			board.setBno(bno);
			
			//PreparedStatement 닫기
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}	
	
	public int update(Board board) {
		int rows = 0;
		try {
			//매개변수화된 SQL 문 작성
			String sql = new StringBuilder()
					.append("UPDATE boards SET ")
					.append(" btitle=?,")
					.append(" bcontent=? ")
					.append(" WHERE bno=?")
					.toString();
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setInt(3, board.getBno());  //boards 테이블에 있는 게시물 번호(bno) 지정
			
			//SQL 문 실행
			rows = pstmt.executeUpdate();
			
			//PreparedStatement 닫기
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int delete(Board board) {
		int rows = 0;
		try {
			//매개변수화된 SQL 문 작성
			String sql = "DELETE FROM boards WHERE bno=?";
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			
			//SQL 문 실행
			rows = pstmt.executeUpdate();
			
			//PreparedStatement 닫기
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}