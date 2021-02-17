import java.util.Scanner;

public class Week2_1_장세영 {

	public static void main(String[] args) {
	
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		//사용자로부터 월 입력받기
		Scanner scanner = new Scanner(System.in);
		System.out.print("월 입력:");
		int month = scanner.nextInt();
		
		//월별 일수 분류하기
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12://case stacking을 사용해 위의 모든 월엔 아래의 출력문 출력
			System.out.printf("%d월에는 31일이 있습니다.", month);
			break;
		case 4:
		case 6:
		case 9:
		case 11://case stacking을 사용해 위의 모든 월엔 아래의 출력문 출력
			System.out.printf("%d월에는 30일이 있습니다.", month);
			break;
		case 2:
			System.out.printf("%d월에는 28일이 있습니다.", month);
			break;
		default://만약 위의 수에 모두 해당이 되지 않을 경우 범위 밖의 수이므로 입력 오류 출력
			System.out.println("입력 오류");
			break;
		}
	}
}
