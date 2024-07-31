package com.javaex.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
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

	// << 삭제 메서드 >>
	public int deleteDrink(int drinkId) {

		int count = -1;

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문
			String query = "";

			query += " delete from drink ";
			query += " where drink_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, drinkId);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println(count + "건 삭제되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return count;
	} // 삭제 메서드 끝

	// << 회원정보 추가 (유저번호, 아이디, 비번, 이름, 폰번호) >>
	public int insertUser(int userId, String id, String pw, String userName, String userHp) {

		int count = -1;

		// DB연결 메소드 호출
		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행

			// - sql문 준비
			String query = "";
			query += " insert into users ";
			query += " values(null, ?, ?, ?, ?) ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, userName);
			pstmt.setString(5, userHp);

			// - 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 등록 되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;
	}

	// 회원정보 수정메서드
	public int updateUser(String id, String pw, String name, String hp, int userId) {
		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// *sql문 준비
			String query = "";
			query += " update Users ";
			query += " set id = ?, ";
			query += "     pw = ?, ";
			query += "     user_name = ?, ";
			query += "     user_hp = ? ";
			query += " where user_id = ? ";

			// *바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, hp);
			pstmt.setInt(5, userId);

			// *실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;
	}

	// 상품출력 메서드
	public List<UserDrinkVo> selectDrinkAll() {

		List<UserDrinkVo> drinkList = new ArrayList<UserDrinkVo>();

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문
			String query = "";
			query += " select drink_id ";
			query += " 		 ,drink ";
			query += " 	     ,drink_cotent ";
			query += " 		 ,drink_price ";
			query += " from Drink ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			rs = pstmt.executeQuery();

			// 반복
			while (rs.next()) {
				int id = rs.getInt("drink_id");
				String drink = rs.getString("drink");
				String content = rs.getString("drink_content");
				String price = rs.getString("drink_price");

				UserDrinkVo DrinkVo = new UserDrinkVo(id, drink, content, price);
				drinkList.add(DrinkVo);

			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		this.close();
		return drinkList;
		

	}

}
