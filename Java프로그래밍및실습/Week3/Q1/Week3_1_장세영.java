package hw;
import java.util.Scanner;
public class Week3_1_장세영 {
	public static void main(String[] args) {

		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		//사용자에게 값 입력받기 위해
		Scanner scanner = new Scanner(System.in);
		
		//나중에 조건 체크를 편하게 하기 위해서 임의로 변수 선언함
		int choice;
		
		//song 객체 2개 생성
		Song song1 = new Song();
		Song song2 = new Song();
		
		//입력받기
		System.out.println("*Song 1*");
		//입력 받는 것마다 해당 객체의 변수에 넣기
		System.out.print("곡명입력:");
		song1.title = scanner.nextLine();
		System.out.print("가수명입력:");
		song1.singer = scanner.nextLine();
		//위는 string 아래는 int 형이므로 받는 형식이 다르다
		System.out.print("가격입력:");
		song1.price = scanner.nextInt();
		
		System.out.println("");
		
		//입력받기
		System.out.println("*Song 2*");
		//입력 받는 것마다 해당 객체의 변수에 넣기
		System.out.print("곡명입력:");
		song2.title = scanner.nextLine();
		song2.title = scanner.nextLine();
		System.out.print("가수명입력:");
		song2.singer = scanner.nextLine();
		//위는 string 아래는 int 형이므로 받는 형식이 다르다
		System.out.print("가격입력:");
		song2.price = scanner.nextInt();
		
		System.out.println("");
		
		System.out.println("노래를 고르세요");
		System.out.println("1:"+song1.title+" 2:"+song2.title);
		//아까 선언한 변수를 활용. 사용자의 입력값 받기
		choice = scanner.nextInt();
		
		//입력받은 값으로 조건 체크
		if(choice == 1) {
			//사용자가 1을 입력했을 경우 1번 객체에 해당하는 메소드 실행
			song1.play();
			song1.price();
		}
		else {
			//사용자가 1이 아닌 다른 수를 입력했을 경우 2번 객체에 해당하는 메소드 실행
			song2.play();
			song2.price();
		}
		
		System.out.println("감사합니다.");
	}
}
