package com.javaex.user;

public class UserVo {
		
		//필드
	   private int userId; // 회원번호
	   private String id; // 계정 아이디
	   private String pw; // 계정 비밀번호
	   private String name; // 회원 이름
	   private String hp; // 회원 전화번호
	   	//
	   private int food;
	   private int amount;
	   
	   //생성자
	   public UserVo() { // 기본생성자

	   }
	   
	   //스캐너 입력받는 생성자
	   public UserVo(int food, int amount) {
		   this.food = food;
		   this.amount = amount;
	   }
	   
	   public UserVo(String id, String pw) {
		   this.id = id;
		   this.pw = pw;
	   }

	   public UserVo(int userId, String id, String pw, String name, String hp) { // 회원가입시 입력하는 정보
	      this.userId = userId;
	      this.id = id;
	      this.pw = pw;
	      this.name = name;
	      this.hp = hp;
	   }

	   public int getUserId() {
	      return userId;
	   }

	   public void setUserId(int userId) {
	      this.userId = userId;
	   }

	   public String getId() {
	      return id;
	   }

	   public void setId(String id) {
	      this.id = id;
	   }

	   public String getPw() {
	      return pw;
	   }

	   public void setPw(String pw) {
	      this.pw = pw;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getHp() {
	      return hp;
	   }

	   public void setHp(String hp) {
	      this.hp = hp;
	   }
	   
	   

	   public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	   public String toString() {
	      return "UserVo [userId=" + userId + ", id=" + id + ", pw=" + pw + ", name=" + name + ", hp=" + hp + "]";
	   }
	
}
