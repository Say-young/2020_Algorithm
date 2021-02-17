package lab2;
import java.util.*;

public class Week6_2_장세영 {
	public static void main(String[] args) {

		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");

		Scanner scanner = new Scanner(System.in);

		Car car[] = new Car[3];
		//각 인스턴스를 생성
		car[0] = new FireEngine();
		car[1] = new Ambulance();
		car[2] = new PoliceCar();
		Emergency em = new Emergency();
		
		//반복문을 사용하여 사용자 입력을 받음
		int j=0;
		//사용자가 5를 입력하기 전까지 계속 반복
		while(j!=5) {
			try {
			System.out.println("What kind of Emergency?");
			System.out.println("1.Fire   2.Patient   3.Thief   4.Record   5.End");
			j = scanner.nextInt(); //사용자에게 숫자 입력받기
			//입력받은 숫자에 따라 다른 객체의 EM_Call 메서드 호출
			switch(j) {
				case 1:
					em.EM_Call(car[0]);
					break;
				case 2:
					em.EM_Call(car[1]);
					break;
				case 3:
					em.EM_Call(car[2]);
					break;
				case 4: //4번 입력시 EM_record()메서드 호출
					em.EM_record();
					break;
				case 5://종료
					System.out.println("Finished"); 
					break;
				default://1~5 이외의 입력을 받을 경우
					System.out.println("Wrong Input");
			}
			}//만약 숫자가 아닌 다른 것을 입력받으면
			catch(InputMismatchException e) {
				scanner.nextLine(); //버퍼비우기
				System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");//안내메세지
			}
		}
	}
}
