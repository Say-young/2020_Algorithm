import java.util.Scanner;
public class Week2_5_장세영 {
	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		//사용자가 입력하는 수를 받기 위한 scanner
		Scanner scanner = new Scanner(System.in);
		
		//사용자에게 수 입력받기. 사용자의 입력값은 곧 이 삼각형의 높이다.
		System.out.print("Enter the height of the triangle :");
		int height = scanner.nextInt();

		//입력받은 높이만큼 반복
		for(int i = 0; i<height ; i++) {
			//빈칸을 출력하는 부분. 바깥 반복문의 i를 활용.
			for(int j = 0; j<height-i; j++) {
				System.out.printf(" ");
			}
			//*을 출력하는 부분. 역시 바깥 반복문의 i를 활용.
			for(int k = 0; k<2*i-1; k++) {
				System.out.printf("*");
			}
			//i가 하나씩 값이 커질 때마다 엔터
			System.out.println("");
		}
	}
}
