package com.javaex.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserApp {

	public static void main(String[] args) {

		UserDao userDao = new UserDao(); // UserDao 주소값 가져오기
		Scanner sc = new Scanner(System.in);
		List<UserVo> foodList = new ArrayList<UserVo>();

		boolean on = true; // 목록 while문
		boolean on2 = true; // 로그인 while문
		boolean on3 = true; // 로그인성공시 while문
		boolean on4 = true; // 회원가입 while문
		boolean stop = true; // 임시 while문(주문받기)

		int loginNo = 0; // 로그인된 번호(입력받을번호)

		while (on) {
			// 디폴트 화면 (목록)
			System.out.println("============= 목록 ===============");
			System.out.println("1.로그인");
			System.out.println("2.회원가입");
			System.out.println("3.종료");
			System.out.print("번호를 입력해주세요:");
			String num = sc.nextLine();

			// (로그인)
			loginNo = 3;
			if (num.equals("1")) {

				while (on2) {
					System.out.println("============= 로그인 ===============");
					System.out.print("아이디를 입력해주세요:");
					String id = sc.nextLine();
					System.out.print("비밀번호를 입력해주세요:");
					String pw = sc.nextLine();

					// 로그인

					System.out.println("============= 로그인성공 ===============");

					while (on3) {
						System.out.println("=====================================");
						System.out.println("1.회원정보수정");
						System.out.println("2.지금까지의 주문내역");
						System.out.println("3.주문하기");
						System.out.println("4.뒤로가기: 0번");
						System.out.println("=====================================");
						System.out.print("번호를 입력해주세요:");
						String choice = sc.nextLine();

						if (choice.equals("1")) {
							// 정보수정 로직
							System.out.println("회원정보가 수정되었습니다.");

						} else if (choice.equals("2")) {
							// 지금까지의 주문내역 로직짜기
							System.out.println("지금까지의 주문내역입니다.");

						} else if (choice.equals("3")) {
							// 상품 리스트 출력로직
							List<UserDrinkVo> drink = userDao.selectDrinkAll();
							for (int i = 0; i < drink.size(); i++) {
								System.out.println(drink.get(i));
							}
								boolean stop2 = true;
								int rid = 0;
							// List<Integer> foodList = new ArrayList<Integer>(); : 주문받은것 관리용 리스트
							// 주문하기 로직
							// 반복
							while (stop) {
								
								int food = 0;
								int amount = 0;
								int count = 0;
								
								
								while (stop2) {
									
									System.out.print("원하시는 상품을 입력해주세요(0이면 종료):");
									food = sc.nextInt(); // 번호로 입력받고
									
									if (food == 0) {
										stop2 = false;
										
									}else{
										System.out.print("수량을 입력해주세요:");
										amount = sc.nextInt();
										count++;
									}	
									
									System.out.println("<주문내역>");
									
									rid = userDao.insertReceipt(loginNo);
								

								UserVo result = new UserVo(food, amount);
								foodList.add(result);
								
								}
							}
							
							for(int i=0; i<foodList.size();i++) {
								userDao.insertUserOrder(rid,loginNo,foodList.get(i).getFood(),foodList.get(i).getAmount());
								
								System.out.println();
							}
							

							// 반복
							/*
							 * 주문 음료 리스트로 가지고 있어라 0
							 * 
							 * 영수증번호를 인설트해주고 >> 인설트된 영수증번호로 userDao.insetReceipt(loginNo); int receiptId =
							 * userDao.selectReceiptId();
							 * 
							 * 반복 리스트의 사이즈만큼 userDao.insertOrderUser(receiptId,회원번호, food, mount ) 반복
							 */

						} else if (choice.equals("0")) {
							System.out.println("뒤로가기");

							on2 = false;
							on3 = false;

						} else {
							System.out.println("잘못입력하셨습니다.");
						}
					}
				}

				// 회원가입

			} else if (num.equals("2")) {

				while (on4) {
					System.out.print("이름을 입력해주세요:");
					String name = sc.nextLine();
					System.out.print("전화번호를 입력해주세요:");
					String hp = sc.nextLine();
					System.out.print("아이디를 입력해주세요:");
					String id = sc.nextLine();
					System.out.print("비밀번호를 입력해주세요:");
					String pw = sc.nextLine();

					System.out.println("회원가입이 완료되었습니다");

					break;

				}

				// 프로그램 종료
			} else if (num.equals("3")) {
				System.out.println("프로그램이 종료되었습니다.");
				on = false;
			}

		} // 목록 while 끝

	}
}
