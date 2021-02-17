package lab;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Week6_1_장세영 {

	public static void main(String[] args) {

		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");

		Scanner scanner = new Scanner(System.in);

		int choice = 10;
		
		//구매자 인스턴스 생성
		Buyer Buyer1 = new Buyer();
		//구매 가능한 물품 인스턴스 생성. 부모 클래스인 Product 배열을 만들어서 그 안에 하나씩 넣는다. java의 다형성 이용.
		Product[] pd = new Product[10];
		pd[0] = new Tv();
		pd[1] = new Computer();
		pd[2] = new Video();
		pd[3] = new Audio();
		pd[4] = new NoteBook();
		
		//사용자의 돈을 묻는다.
		while(true) {
			try {
				System.out.println("How much money do you have?");
				Buyer1.money=scanner.nextInt();
				break;
			}
			//숫자가 입력되지 않을 경우 다시 물어봄
			catch(InputMismatchException e) {
				scanner.nextLine(); //버퍼비우기
				System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");//안내메세지
			}
		}
		
		//사용자가 구매할 목록을 묻는다.
		do {
			try{
				System.out.println("What do you want to buy? Input 0 to quit.");
				//구매 가능한 물품 목록을 보여준다.
				for(int i=0; i<5; i++) {
					System.out.print((i+1)+". "+pd[i]+"("+pd[i].price+")\t");
				}
				System.out.println("");
				choice=scanner.nextInt();
				switch(choice) {
					case 0: //0을 입력받으면 쇼핑 결과문 출력
						Buyer1.summary();
						break;
					//0이외의 숫자를 입력받으면 해당 번호에 해당하는 물품 구매 메서드인 buy 메서드 작동
					case 1:
						Buyer1.buy(pd[0]);
						break;
					case 2:
						Buyer1.buy(pd[1]);
						break;
					case 3:
						Buyer1.buy(pd[2]);
						break;
					case 4:
						Buyer1.buy(pd[3]);
						break;
					case 5:
						Buyer1.buy(pd[4]);
						break;
					//0~5 이외의 숫자 입력시 결과 없음 메세지 출력
					default :
						System.out.println("No such item.");
				}
			}//숫자가 입력되지 않을 경우 다시 물어봄
			catch(InputMismatchException e) {
				scanner.nextLine(); //버퍼비우기
				System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");//안내메세지
			}
		}while(choice!=0); //사용자가 0을 입력하지 않는 한 계속 반복
		
		
	}
}
