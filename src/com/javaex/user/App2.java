package com.javaex.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {

		UserDao userDao = new UserDao(); // UserDao 주소값 가져오기
		Scanner sc = new Scanner(System.in);
		List foodList = new ArrayList();
		UserVo userVo = new UserVo();	//로그인시 아이디확인용

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

			// (로그인) 130번
			
			if (num.equals("1")) {
				

				while (on2) {
					System.out.println("============= 로그인 ===============");
					System.out.print("아이디를 입력해주세요:");
					String id = sc.nextLine();
					System.out.print("비밀번호를 입력해주세요:");
					String pw = sc.nextLine();

					userVo = userDao.userLogin(id, pw);
					if ( userVo == null ) {
						System.out.println("아이디와 비번을 확인해주세요");
						break;
					} else {
						loginNo = userVo.getUserId();
						//회원번호
					}
					
					
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
							System.out.print("아이디를 입력해주세요:");
							String rid = sc.nextLine();
							System.out.print("비밀번호를 입력해주세요:");
							String rpw = sc.nextLine();
							System.out.print("이름을 입력해주세요:");
							String rname = sc.nextLine();
							System.out.print("번호를 입력해주세요:");
							String rhp = sc.nextLine();
							
							userDao.updateUser(rid, rpw, rname, rhp, loginNo);
							
							System.out.println("회원정보가 수정되었습니다.");
							
							

		                  } else if (choice.equals("2")) {
		                      // 지금까지의 주문내역 로직짜기
		                      //System.out.println("지금까지의 주문내역입니다.");
		                      
		                      List<AllVo> receList = userDao.selectAllOrderReceipt(loginNo);
		                      
		                      for (int i = 0; i < receList.size(); i++) {
		                         System.out.println(receList.get(i).getReceiptId());
		                         System.out.println(receList.get(i).getReceiptFinish());

		                      }
		                      
		                      
		                      

		                   } else if (choice.equals("3")) {
		                     // 상품 리스트 출력로직 : OK

		                     List<UserDrinkVo> drink = userDao.selectDrinkAll();

		                     int food = 0;
		                     int amount = 0;
		                     int count = 0;

		                     // 주문 출력
		                     int drinkCnt = 0; // 음료리스트
		                     for (int i = 0; i < drink.size(); i++) {
		                        System.out.println(drink.get(i));
		                        drinkCnt++;
		                     }

		                     while (stop) {
		                    	int rid = userDao.insertReceipt(loginNo); // 영수증 등록
		                        
		                    	System.out.print("원하시는 상품을 입력해주세요(-1이면 종료):");
		                        food = sc.nextInt();

		                        if (food == -1) {
		                           stop = false;

		                        } else if (food > drinkCnt) {
		                           // drink_id가 기존에 없는값이 들어왔을때
		                           System.out.println("잘못된 입력입니다");
		                           stop = false;

		                        } else {
		                           System.out.print("수량을 입력해주세요:");
		                           amount = sc.nextInt();
		                           
		                        }
		                        userDao.InsertUserOrder(rid,loginNo,food,amount);
		                        // UserVo result = new UserVo(food, amount);
		                        //foodList.add(result);

		                     }

		                     System.out.println("<주문내역>");
		                     System.out.println("=====================");
		                     System.out.println(foodList+ "여기");
		                     System.out.println("=====================");

		                     // 영수증 값이 0일떄 false
		                    
		                     /*
		                     for (int i = 0; i < foodList.size(); i++) {
		                        userDao.insertUserOrder(rid, loginNo, foodList.get(i).getFood(),
		                              foodList.get(i).getAmount());

		                     }*/

		                  }

		                  else if (choice.equals("0")) {
		                     System.out.println("뒤로가기");

		                    on2 = false;
		                    
		                     break;

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

		                 int cnt = userDao.insertUser(name, hp, id, pw);

		                 if (cnt == 1) {
		                    System.out.println("회원가입이 완료되었습니다");
		                 } else {
		                    System.out.println("회원가입 실패하였습니다");
		                    break;
		                 }
		                 	// 프로그램종료
		              } else if (num.equals("3")) {
		            System.out.println("프로그램이 종료되었습니다.");
		            on = false;
		         }

		      } // 목록 while 끝

		   }
		}