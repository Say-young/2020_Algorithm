package hwhw;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Week5_1_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");

		
		Scanner scanner = new Scanner(System.in);
		
		//각각의 인스턴스 객체 생성
		Play play = new Play();
		Film film = new Film();
		
		
		//값 입력받기. 각 변수들은 private이므로 직접 접근이 불가하기에 set메소드를 활용해 값을 저장한다
		System.out.println("Input Title for Play");
		play.setTitle(scanner.nextLine());
		System.out.println("Input Director for Play");
		play.setDirector(scanner.nextLine());
		System.out.println("Input Writer for Play");
		play.setWriter(scanner.nextLine());
		System.out.println("Input Title for Film");
		film.setTitle(scanner.nextLine());
		System.out.println("Input Director for Film");
		film.setDirector(scanner.nextLine());
		System.out.println("Input Writer for Film");
		film.setWriter(scanner.nextLine());
		
		//아래는 정수를 받아야 하는데 정수가 아닌 다른 것을 입력했을 경우 경고문을 띄우고 다시 입력을 받는 과정
		while(true) {
			try {
				System.out.println("Input Performance Cost for Play");
				play.setPerformanceCost((scanner.nextInt()));
				break;
			}
			catch(InputMismatchException e) {
				scanner.nextLine(); // 버퍼 비우기 이거 없으면 무한루프 돈다
				System.out.println("정수만 입력 가능합니다.");
			}
		}
		
		while(true) {
			try {
				System.out.println("Input boxOfficeGross for Film");
				film.setBoxOfficeGross((scanner.nextInt()));
				break;
			}
			catch(InputMismatchException e) {
				scanner.nextLine(); // 버퍼 비우기 이거 없으면 무한루프 돈다
				System.out.println("정수만 입력 가능합니다.");
			}
		}
		
		//각 변수들은 private이므로 직접 접근이 불가하기에 get메소드를 활용해 값을 호출한다
		play.display();
		film.display();
	}

}
