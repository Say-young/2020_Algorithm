package week1;

import java.util.Scanner;
public class Week1_1_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : Computer Engineering");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		//변수 선언
		int f;
		double c;
		
		//화씨온도 입력받기
		Scanner a = new Scanner(System.in);
		System.out.print("화씨온도 입력:");
		
		//입력받은 값 화씨 온도에 대입
		f = a.nextInt();
		
		//화씨 온도로 섭씨 온도 계산해서 대입
		c = (double)5/9*(f-32);
		
		//결과값 출력
		System.out.println("");
		System.out.println("화씨온도:"+f);
		System.out.print("섭씨온도:");
		System.out.printf("%.1f",c); //소수점 한자리까지만 나타내기
	}

}
