package ch20.oracle.sec13.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	//Field
	private static Connection conn = null;
	
	public static Connection getConnection() {
		return conn;
	}
	
	static {
		try {
			//Properties 컬렉션 생성
			Properties properties = new Properties();
	
			//PropertiesExample.class와 동일한 ClassPath에 있는 database.properties 파일 로드
			properties.load(DBUtil.class.getResourceAsStream("../../config/database.properties"));
	
			//주어진 키에 대한 값 읽기
			String jdbcDriver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			
			Class.forName(jdbcDriver);
			
			conn = DriverManager.getConnection(url, username, password);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
