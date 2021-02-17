package lab1;

public class Circle implements Geometry{//인터페이스는 implements
	
	/*
	System.out.println("=============");
			System.out.println("전공 : 컴퓨터공학");
			System.out.println("학번 : 1871047");
			System.out.println("성명 : 장세영");
			System.out.println("=============");	
	*/
	
	double radius; //사용할 변수 선언
	
	//빈 생성자
	Circle(){
	}
	
	//파라미터 값을 변수에 저장하는 생성자
	Circle(double radius){
		this();
		this.radius = radius;
	}
	
	//오버라이딩 - 넓이를 구하는 메서드
	public double area() {
		return radius*radius*PI;
	}
	
	//오버라이딩 - 길이를 구하는 메서드
	public double perimeter() {
		return radius*PI*2;
	}
}
