package lab1;

import java.util.*;
public class Triangle implements Geometry{//인터페이스는 implements
	/*
	System.out.println("=============");
			System.out.println("전공 : 컴퓨터공학");
			System.out.println("학번 : 1871047");
			System.out.println("성명 : 장세영");
			System.out.println("=============");	
	*/
	double a, b, c, s;//사용할 변수 선언
	
	//빈 생성자
	Triangle(){
	}
	
	//파라미터 값을 변수에 저장하는 생성자
	Triangle(double a, double b, double c){
		this();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//오버라이딩 - 넓이를 구하는 메서드
	public double area() {
		s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	
	//오버라이딩 - 길이를 구하는 메서드
	public double perimeter() {
		return a+b+c;
	}
	
}
