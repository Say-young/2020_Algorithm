package lab;
	import java.util.Scanner;
	public class Week3_4_장세영 {

		public static void main(String[] args) {

			System.out.println("=============");
			System.out.println("전공 : 컴퓨터공학");
			System.out.println("학번 : 1871047");
			System.out.println("성명 : 장세영");
			System.out.println("=============");
			
			//MenuOrder 객체 생성
			MenuOrder order = new MenuOrder();
			String input;
			
			//사용자의 값을 입력 받기
			Scanner scanner = new Scanner(System.in);
			
			//음료 가격 설정하기
			System.out.println("---음료 가격 설정---");
			System.out.print("Coke가격:");
			order.setPrice("coke", scanner.nextInt());
			System.out.print("Lemonade가격:");
			order.setPrice("lemonade", scanner.nextInt());
			System.out.print("Coffee가격:");
			order.setPrice("coffee", scanner.nextInt());

			
			//아래 3,4번 과정 반복 (단, y일경우)
			do {
				
			//사용자에게 돈의 총 액수 받기
			System.out.println("\n---돈을 넣으세요---");
			order.setInputMoney(scanner.nextInt());
			int need=0;
			
			//메뉴를 보여줌
			order.showMenu();
			
			//메뉴 번호를 선택한 것을 받음
			int choice = scanner.nextInt();
			
			//받은 메뉴번호로 계산
			order.showResult(order, choice);
		
			//choice에 해당하는 조건문을 설정하지 않았더니 없는 메뉴를 선택해도 잔액 표시 문구가 출력이 되어 이 조건문을 추가했다.
			//이 조건문을 추가하지 않고도 예시와 같이 표현할 수 있는 방법이 있는지 궁금함
			if(choice ==1 || choice ==2 || choice==3) {
				if(order.getInputMoney()>=0)
					System.out.println("잔돈은 "+order.getInputMoney()+"원입니다.");
				else //잔액이 마이너스일 경우 돈이 부족하다는 뜻이므로
					{
					need = Math.abs(order.getInputMoney()); //마이너스인 잔액을 절댓값처리하여 부족한 금액으로 출력
					System.out.println(need+"원 더 넣어주세요.");
				}
			}
			
			//사용자에게 반복 의사를 질문
			System.out.println("계속 하시겠습니까? (y/n)");
			input = scanner.nextLine(); //엔터먹기
			input = scanner.nextLine();
			}while(input.equalsIgnoreCase("y")); // y일 경우 반복
		}

	}
