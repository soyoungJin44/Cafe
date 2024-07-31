package com.javaex.admin;

public class UserVo {
	
	//필드
	private int drink_id;
	private String drink;
	private String drink_content;
	private String drink_price;
	
	//생성자

	public UserVo() {
		super();
	}
	
	public UserVo(int drink_id, String drink, String drink_content, String drink_price) {
		this.drink_id = drink_id;
		this.drink = drink;
		this.drink_content = drink_content;
		this.drink_price = drink_price;
	}
	//메서드 gs

	public int getDrink_id() {
		return drink_id;
	}

	public void setDrink_id(int drink_id) {
		this.drink_id = drink_id;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getDrink_content() {
		return drink_content;
	}

	public void setDrink_content(String drink_content) {
		this.drink_content = drink_content;
	}

	public String getDrink_price() {
		return drink_price;
	}

	public void setDrink_price(String drink_price) {
		this.drink_price = drink_price;
	}


	
	//메서드 일반
	@Override
	public String toString() {
		return "DrinkVo [drink_id=" + drink_id + ", drink=" + drink + ", drink_content=" + drink_content
				+ ", drink_price=" + drink_price + "]";
	}
	
	
}
