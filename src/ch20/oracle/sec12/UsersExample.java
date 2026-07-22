package ch20.oracle.sec12;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsersExample {
		//Field
		Connection conn = null;
		Scanner scanner = new Scanner(System.in);
		
		//Constructor
		public UsersExample() {
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
			System.out.println("[사용자 목록]");
			System.out.println("-----------------------------------------------------------------------");
			System.out.printf("%-20s%-15s%-20s%-6s%-30s\n", "id", "name", "password", "age", "email");
			System.out.println("-----------------------------------------------------------------------");
			
			try {
				//매개변수화된 SQL 문 작성

				String sql = "SELECT userid, username, userpassword, userage, useremail FROM users order by userid";
				
				//PreparedStatement 얻기 및 값 지정
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				//SQL 문 실행 후, ResultSet을 통해 데이터 읽기

				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {		
					//데이터 행을 읽고 Board 객체 생성

					Users users = new Users();
					users.setUserid(rs.getString("userid"));
					users.setUsername(rs.getString("username"));
					users.setUserpassword(rs.getString("userpassword"));
					users.setUserage(rs.getInt("userage"));
					users.setUseremail(rs.getString("useremail"));
					
					//콘솔에 출력
					System.out.printf("%-20s%-15s%-20s%-6d%-30s \n", 
							users.getUserid(), users.getUsername(), users.getUserpassword(), users.getUserage(), users.getUseremail());
					
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
			System.out.println();
			
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
			//1. 삭제메시지 출력

			System.out.println("게시물 전체를 삭제합니다.");
			System.out.println("보조 메뉴 : 1. 게시물 전체, 2. 취소");
			System.out.print("원하는 메뉴를 입력하세요 : ");
			//2. 사용자에게 메뉴 선택에 대한 입력을 받는다 

			String menuNo = scanner.nextLine();
			
			//3. 사용자가 입력한 값을 검증하여 맞으면 전제 자료를 삭제한다

			if (!"1".equals(menuNo)) {
				list();
				return;
			}
			
			try {
				//매개변수화된 SQL 문 작성

				String sql = "DELETE FROM users";
				
				//PreparedStatement 얻기 및 값 지정

				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				//SQL 문 실행

				int rows = pstmt.executeUpdate();
				System.out.println("삭제된 행 수: " + rows);
				
				//PreparedStatement 닫기

				pstmt.close();
				
				System.out.println("모든 게시물이 삭제 되었습니다");
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}

			list();
		}

		private void read() {
			try {
				System.out.println("아이디를 입력해주세요");
				System.out.println("아이디 : ");
				String id = scanner.nextLine();
				
				//매개변수화된 SQL 문 작성

				String sql = "" +
					"SELECT userid, username, userpassword, userage, useremail " +
					"FROM users " +
					"WHERE userid=?";
				
				//PreparedStatement 얻기 및 값 지정

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				//SQL 문 실행 후, ResultSet을 통해 데이터 읽기

				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {		
					//데이터 행을 읽고 Board 객체 생성

					Users users = new Users();
					users.setUserid(rs.getString("userid"));
					users.setUsername(rs.getString("username"));
					users.setUserpassword(rs.getString("userpassword"));
					users.setUserage(rs.getInt("userage"));
					users.setUseremail(rs.getString("useremail"));
					
					//콘솔에 출력

					System.out.println(">>>>> 회원정보 상세 보기 <<<<<");
					System.out.println("아이디 : " + users.getUserid());
					System.out.println("이름 : " + users.getUsername());
					System.out.println("비밀번호 : " + users.getUserpassword());
					System.out.println("나이 : " + users.getUserage());
					System.out.println("이메일 : " + users.getUseremail());
					
					System.out.println();
					System.out.println("-----------------------------------------------------------------------");
					System.out.println("서브 메뉴: 1.Update | 2.Delete | 3.List ");
					System.out.print("메뉴 선택: ");
					System.out.println();
					
					String menuNo = scanner.nextLine();
					
					switch(menuNo) {
					case "1" -> update(users);
					case "2" -> delete(users);
					case "3" -> list();
					}
					
				} else {
					System.out.println("게시물이 존재하지 않습니다");
				}
				rs.close();
				
				//PreparedStatement 닫기

				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			list();
		}

		private void create() {
			Users users = new Users();

			try {				
				System.out.print("아이디 : ");
				users.setUserid(scanner.nextLine());
				System.out.print("이름 : ");
				users.setUsername(scanner.nextLine());
				System.out.print("비밀번호 : ");
				users.setUserpassword(scanner.nextLine());
				System.out.print("나이 : ");
				users.setUserage(Integer.parseInt(scanner.nextLine()));
				System.out.print("이메일 : ");
				users.setUseremail(scanner.nextLine());

				//매개변수화된 SQL 문 작성
				String sql = "" +
					"INSERT INTO users (userid, username, userpassword, userage, useremail) " +
					"VALUES (?, ?, ?, ?, ?)";
				
				//PreparedStatement 얻기 및 값 지정

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, users.getUserid());
				pstmt.setString(2, users.getUsername());
				pstmt.setString(3, users.getUserpassword());
				pstmt.setInt(4, users.getUserage());
				pstmt.setString(5, users.getUseremail());
				
				//SQL 문 실행
				pstmt.executeUpdate();
				
				//PreparedStatement 닫기
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			list();
		}	
		
		private void update(Users users) {
			try {
				String pw = "";
				String email = "";
				
				System.out.print("비밀번호 : ");
				pw = scanner.nextLine();
				System.out.print("이메일 : ");
				email = scanner.nextLine();
				
				System.out.println();
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("서브 메뉴: 1.수정 | 2.취소 ");
				System.out.print("메뉴 선택: ");
				System.out.println();
				
				String menuNo = scanner.nextLine();
				
				if(!"1".equals(menuNo)) return;

				//매개변수화된 SQL 문 작성

				String sql = new StringBuilder()
						.append("UPDATE users SET ")
						.append(" userpassword=?,")
						.append(" useremail=? ")
						.append(" WHERE userid=?")
						.toString();
				
				//PreparedStatement 얻기 및 값 지정

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pw);
				pstmt.setString(2, email);
				pstmt.setString(3, users.getUserid());

				
				//SQL 문 실행
				pstmt.executeUpdate();
				
				//PreparedStatement 닫기

				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		private void delete(Users users) {
			try {
				//매개변수화된 SQL 문 작성

				String sql = "DELETE FROM users WHERE userid=?";
				
				//PreparedStatement 얻기 및 값 지정

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, users.getUserid());
				
				//SQL 문 실행
				pstmt.executeUpdate();
				
				//PreparedStatement 닫기
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			UsersExample usersexample = new UsersExample();
			usersexample.list();
		}
}
