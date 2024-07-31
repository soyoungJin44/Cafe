package com.javaex.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	// 필드
	// 1번
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 2번
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/book_db";
	private String id = "cafe";
	private String pw = "cafe";

	// db연결 일반메소드
	private void getConnection() {
		try {
		// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);
			
		// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id , pw );
			
		}catch (ClassNotFoundException e) {
				System.out.println("error: 드라이버 로딩 실패 - " + e);
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
	} // db연결 메소드 끝

	// 자원정리 메소드
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	// 삭제
	public int deleteDrink(int drink_id) {

		int count = -1;

		try {
			
			// 3. SQL문 준비 / 바인딩 / 실행
			//sql문
			String query = "";
			
			query += " delete from drink ";
			query += " where drink_id = ? ";
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,drink_id);
			
			//실행
			count = pstmt.executeUpdate();
			
			// 4.결과처리
			
			System.out.println(count + "건 삭제되었습니다.");
		
		}catch (SQLException e) {
			System.out.println("error:" + e);
			} 
		
		return count;
		} //삭제 메서드 끝
		
	} 

	

