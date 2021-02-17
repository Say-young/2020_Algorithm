package week1;
import java.util.Scanner;
public class Week1_2_장세영 {

    public static void main(String[] args) {

		System.out.println("=============");
		System.out.println("전공 : Computer Engineering");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
                //입력받을 변수 선언
		int money;
		
                //돈 입력받기
		Scanner z = new Scanner(System.in);
		System.out.print("Input the amoount of money(0~100000) : ");

		//입력 값을 변수에 대입
		money = z.nextInt();

                //입력 값의 범위 구하기
		if(money >= 0 && money <= 100000){
		
		//각 지폐 갯수 구하기
		int a = money / 50000;
		int b = money % 50000 / 10000;
		int c = money % 50000 % 10000 / 5000;
		int d = money % 50000 % 10000 % 5000 / 1000;
		int e = money % 50000 % 10000 % 5000 % 1000 / 500;
		int f = money % 50000 % 10000 % 5000 % 1000 % 500 / 100;
		int g = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 / 50;
		int h = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 / 10;
		int i = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 % 10;
		
		//값들 형식에 맞게 출력하기
		System.out.println("The ouput will be");
		System.out.println("50000 won: " + a);
		System.out.println("10000 won: "+b);
		System.out.println("5000 won: "+c);
		System.out.println("1000 won: "+d);
		System.out.println("500 won: "+e);
		System.out.println("100 won: "+f);
		System.out.println("50 won: "+g);
		System.out.println("10 won: "+h);
		System.out.println("Remainder : "+i);
		}
	}
}