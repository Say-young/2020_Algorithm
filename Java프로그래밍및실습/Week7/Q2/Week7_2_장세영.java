package lab1;

import java.util.*;
public class Week7_2_장세영 {
	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		
		int a,b,c; //입력 받을 변수 선언
		System.out.println("Input radius for a circle");
		a=scanner.nextInt();//숫자입력받기
		Circle circle = new Circle(a);//circle 객체 생성
		
		System.out.println("Input radius for a square");
		a=scanner.nextInt();//숫자입력받기
		Square square = new Square(a);//square 객체 생성

		System.out.println("Input radius for a triangle");
		a=scanner.nextInt();//숫자 입력 받기
		System.out.println("Input radius for b triangle");
		b=scanner.nextInt();
		System.out.println("Input radius for c triangle");
		c=scanner.nextInt();
		Triangle triangle = new Triangle(a, b, c);//triangle 객체 생성
		
		//각각의 area, perimeter 메서드를 이용해 결과값 출력
		System.out.println("<Circle>");
		System.out.println("Area: "+circle.area());
		System.out.println("Perimeter: "+circle.perimeter());
		
		System.out.println("<Sqaure>");
		System.out.println("Area: "+square.area());
		System.out.println("Perimeter: "+square.perimeter());
		
		System.out.println("<Triangle>");
		System.out.println("Area: "+triangle.area());
		System.out.println("Perimeter: "+triangle.perimeter());
	}
}
