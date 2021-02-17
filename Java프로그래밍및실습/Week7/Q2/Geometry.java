package lab1;

public interface Geometry {
	/*
	System.out.println("=============");
			System.out.println("전공 : 컴퓨터공학");
			System.out.println("학번 : 1871047");
			System.out.println("성명 : 장세영");
			System.out.println("=============");	
	*/
	//인터페이스 선언
	public final double PI = 3.14159;//상수PI선언
	public double area();//다른 클래스에서 implements해 오버라이딩할 메서드들
	public double perimeter();
}