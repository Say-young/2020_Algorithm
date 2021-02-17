import java.util.Scanner;
public class Week2_3_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		String input = "y"; //초기화
		
		do { //일단 실행한 후 반복 조건 따지기
		//점수 입력 받기
		System.out.print("점수입력:");
		int score = scanner.nextInt();
		
		if(score>100 || score <0) {
			System.out.println("점수는 0~100 사이입니다.");
		}
		
		else {
			int a = score/10;
			char grade;
			
			switch(a) {
			case 10:
			case 9 : 
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
				break;
			}
			System.out.printf("점수는 %d점이고 grade는 %c입니다.\n", score, grade);
		}
		System.out.println("반복하시겠습니까?(y/n)");
		input=scanner.nextLine();//버퍼에 남아있는 엔터 제거
		input=scanner.nextLine();
		}while(input.equalsIgnoreCase("y")); //대소문자에 상관 없이 y를 입력하면 반복
	System.out.println("종료");
	}
}
