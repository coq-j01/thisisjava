package ch20.oracle.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardExample0 {
	//Field

	Connection conn = null;
	Scanner scanner = new Scanner(System.in);
	
	//Constructor

	public BoardExample0() {
		try {
			//JDBC Driver 등록

			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결하기

			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/xe", 
				"scott", 
				"kosa1004"
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//Method		

	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-24s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------------------");
		
		try {
			//매개변수화된 SQL 문 작성

			String sql = "SELECT bno, bwriter, bdate, btitle FROM boards order by bno desc";
			
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
				board.setBdate(rs.getDate("bdate"));
				
				//콘솔에 출력

				System.out.printf("%-6d%-24s%-16s%-40s \n", 
						board.getBno(), board.getBwriter(), board.getBdate(), board.getBtitle());
				
			}
			rs.close();
			
			//PreparedStatement 닫기

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mainMenu();
	}
	
	public void mainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		
		String menuNo = scanner.nextLine();
		
		switch(menuNo) {
		case "1" -> create();
		case "2" -> read();
		case "3" -> clear();
		case "4" -> exit();
		}
	}

	private void exit() {
		
		scanner.close();
		
		if(conn != null) {
			try { 
				//연결 끊기

				conn.close(); 
			} catch (SQLException e) {}
		}
		
		System.out.println("Exit() 함수 호출");
		System.exit(0);
	}

	private void clear() {
		System.out.println("게시글을 전체 삭제하시겠습니까?(1:예,2:아니오)");
		System.out.print("선택 : ");
		String isdelete = scanner.nextLine();
		if(isdelete.equals("1")) {
		try {			
            // SQL 작성
            String sql = "DELETE FROM boards ";

            // PreparedStatement 생성

            PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//SQL 문 실행
			pstmt.executeUpdate();
			
			//PreparedStatement 닫기
			pstmt.close();
			
			System.out.println("모든 게시물이 삭제 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		list();
	}

	private void read() {
		System.out.print("게시글 번호 : ");
		String num = scanner.nextLine();
		
		String sql = "SELECT bno, btitle, bcontent, bwriter, bdate FROM boards where bno = ?";
        try {
        	// PreparedStatement 생성
        	PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			// SQL 실행

	        ResultSet rs = pstmt.executeQuery();

	        // 결과 읽기
	        if (rs.next()) {
	        	System.out.println("번호 : "+rs.getInt(1));
	        	System.out.println("제목"+rs.getString(2));
	        	System.out.println("내용 : "+rs.getString(3));
	        	System.out.println("작성자 : "+rs.getString(4));
	        	System.out.println("날짜 : "+rs.getDate(5));
	        }
			System.out.println("1. 수정 2. 삭제");
			System.out.print("번호 : ");
			String n = scanner.nextLine();
			switch(n) {
			case "1"-> {
				System.out.print("제목 : ");
				String btitle = scanner.nextLine();
				System.out.print("내용 : ");
				String bcontent = scanner.nextLine();

				sql = "UPDATE boards "
					    + "SET btitle = ?, bcontent = ?, bdate = SYSDATE "
					    + "WHERE bno = ?";
					
				int bno = Integer.parseInt(num);

				PreparedStatement pstmt2 = conn.prepareStatement(sql);
				pstmt2.setString(1, btitle);
				pstmt2.setString(2, bcontent);
				pstmt2.setInt(3, bno);

				pstmt2.executeUpdate();
				pstmt2.close();				
			}
			case "2"-> {
				sql = "DELETE FROM boards "
					    + "WHERE bno = ?";
				
				int bno = Integer.parseInt(num);

				PreparedStatement pstmt2 = conn.prepareStatement(sql);
				pstmt2.setInt(1, bno);

				pstmt2.executeUpdate();
				pstmt2.close();			
			}
			}
	        rs.close();
	        pstmt.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list();
	}

	private void create() {
		//System.out.println("Create() 함수 호출");

		try {
			String btitle; 
			String bcontent; 
			String bwriter; 
			
			System.out.print("제목 : ");
			btitle = scanner.nextLine();
			System.out.print("내용 : ");
			bcontent = scanner.nextLine();
			System.out.print("작성자 : ");
			bwriter = scanner.nextLine();
			
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
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bwriter);
			
			//SQL 문 실행

			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: " + rows);
			
			//PreparedStatement 닫기
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		list();
	}	
	
	public static void main(String[] args) {
		BoardExample0 boardExample = new BoardExample0();
		boardExample.list();
	}
}
