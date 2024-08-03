
package com.javaex.user;

public class UserOrderVo {

	// 필드
	private int userOrderId;
	private int receiptId;
	private int drinkId;
	private int userId;
	private int drink_cnt;

	// 생성자
	public UserOrderVo() {

	}
	
	public UserOrderVo(int drinkId, int drink_cnt) {
		this.drinkId = drinkId;
		this.drink_cnt = drink_cnt;

	}

	public UserOrderVo( int receiptId, int drinkId, int userId, int drink_cnt) {
		this.receiptId = receiptId;
		this.drinkId = drinkId;
		this.userId = userId;
		this.drink_cnt = drink_cnt;
	}
	
	public UserOrderVo(int userOrderId, int receiptId, int drinkId, int userId, int drink_cnt) {
		super();
		this.userOrderId = userOrderId;
		this.receiptId = receiptId;
		this.drinkId = drinkId;
		this.userId = userId;
		this.drink_cnt = drink_cnt;
	}

	// 메서드 gs
	public int getUserOrderId() {
		return userOrderId;
	}

	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}

	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public int getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(int drinkId) {
		this.drinkId = drinkId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDrink_cnt() {
		return drink_cnt;
	}

	public void setDrink_cnt(int drink_cnt) {
		this.drink_cnt = drink_cnt;
	}

	// 메서드 일반

	@Override
	public String toString() {
		return "userOrderVo [userOrderId=" + userOrderId + ", receiptId=" + receiptId + ", drinkId=" + drinkId
				+ ", userId=" + userId + ", drink_cut=" + drink_cnt + "]";
	}

}
