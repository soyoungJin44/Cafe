package com.javaex.admin;

public class SaleAmountVo {
	private String drinkName; // 음료 이름
	private int drinkCnt; // 주문된 음료 수량
	private int drinkPrice; // 음료 개당 가격
	private int saleAmountSum; // 판매수량 총합
	private String ymd; // 주문 날짜
	private String rtime; // 주문 시간

	public SaleAmountVo() {

	}

	public SaleAmountVo(String drinkName, int drinkCnt, int drinkPrice, int saleAmountSum, String ymd, String rtime) {
		this.drinkName = drinkName;
		this.drinkCnt = drinkCnt;
		this.drinkPrice = drinkPrice;
		this.saleAmountSum = saleAmountSum;
		this.ymd = ymd;
		this.rtime = rtime;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public int getDrinkCnt() {
		return drinkCnt;
	}

	public void setDrinkCnt(int drinkCnt) {
		this.drinkCnt = drinkCnt;
	}

	public int getDrinkPrice() {
		return drinkPrice;
	}

	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}

	public int getSaleAmountSum() {
		return saleAmountSum;
	}

	public void setSaleAmountSum(int saleAmountSum) {
		this.saleAmountSum = saleAmountSum;
	}

	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	@Override
	public String toString() {
		return "SaleAmountVo [drinkName=" + drinkName + ", drinkCnt=" + drinkCnt + ", drinkPrice=" + drinkPrice
				+ ", saleAmountSum=" + saleAmountSum + ", ymd=" + ymd + ", rtime=" + rtime + "]";
	}

}

	


