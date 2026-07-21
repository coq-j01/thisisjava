package ch20.mysql.sec06;

import java.sql.*;
import java.util.Scanner;

public class JdbcLoginExam {
    public static void main(String[] args) {
        // DB 연결 정보 (환경에 맞게 수정)
        String url = "jdbc:mysql://localhost:13306/kosa_db";
        String user = "scott";
        String password = "kosa1004"; // 본인 DB 비밀번호 입력

        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디를 입력하세요: ");
        String inputId = scanner.nextLine();
        
        System.out.print("비밀번호를 입력하세요: ");
        String inputPwd = scanner.nextLine();
   
        // ❌ 일부러 Statement를 사용하여 취약하게 만든 SQL문
        //String sql = "SELECT * FROM members WHERE id = '" + inputId + "' AND password = '" + inputPwd + "'";
        //preparestatement 사용
        String sql = "SELECT * FROM members WHERE id = ? AND password = ?";
        
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.prepareStatement(sql);
            
            //인자설정
            stmt.setString(1, inputId);
            stmt.setString(2, inputPwd);
            
            // 쿼리 실행
            rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("\n========= 로그인 성공 =========");
                System.out.println("환영합니다, " + rs.getString("name") + "님!");
                System.out.println("권한: " + rs.getString("role"));
                System.out.println("===============================");
            } else {
                System.out.println("\n❌ 로그인 실패: 아이디 또는 비밀번호가 틀렸습니다.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL 실행 에러");
            e.printStackTrace();
        } finally {
            // 전통적인 자원 반납 (지저분한 코드 체감용)
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}