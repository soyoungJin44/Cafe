package com.javaex.user;

public class UserDrinkVo {
	
	//필드
	private int drinkId;	//상품번호
	private String drink;	//상품명
	private String drinkContent;	//상품설명
	private String drinkPrice;		//상품가격
	
	//생성자

	public UserDrinkVo() {
		super();
	}
	
	public UserDrinkVo(int drinkId, String drink, String drinkContent, String drinkPrice) {
		this.drinkId = drinkId;
		this.drink = drink;
		this.drinkContent = drinkContent;
		this.drinkPrice = drinkPrice;
	}
	//메서드 gs

	public int getDrink_id() {
		return drinkId;
	}

	public void setDrink_id(int drinkid) {
		this.drinkId = drinkId;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getDrinkContent() {
		return drinkContent;
	}

	public void setDrinkContent(String drinkContent) {
		this.drinkContent = drinkContent;
	}

	public String getDrinkPrice() {
		return drinkPrice;
	}

	public void setDrink_price(String drinkPrice) {
		this.drinkPrice = drinkPrice;
	}


	
	//메서드 일반
	@Override
	public String toString() {
		return "DrinkVo [drinkId=" + drinkId + ", drink=" + drink + ", drinkContent=" + drinkContent
				+ ", drinkPrice=" + drinkPrice + "]";
	}
	
	
}
