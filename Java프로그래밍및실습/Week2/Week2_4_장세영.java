import java.util.Scanner;
public class Week2_4_장세영 {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Factorial을 계산할 정수 입력");
		
		int n = scanner.nextInt(); // 사용자의 수를 입력받는다.
		int a = 1; // 합산 결과 계산을 위해 미리 초기화
		
		//범위 체크. 범위를 벗어나면 반복해서 재입력받음.
		while(n<=0 || n>10) {
			System.out.println("정수 재입력(1~10): ");
			n = scanner.nextInt();
		}
		
		//범위가 맞을 경우 출력
		System.out.print(n+"! = ");
		
		//하나씩 아래로 카운트 하며 반복문을 돌림
		for(int i = n; i>1; i--) {
			System.out.print(i);
			System.out.print(" X ");
			a*=i; //여기서 한번에 팩토리얼 계산!
		}
		System.out.printf("1 = %d",a);
	}
}
