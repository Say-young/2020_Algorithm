package lab;

public class Computer extends Product{
	
//	System.out.println("=============");
//	System.out.println("전공 : 컴퓨터공학");
//	System.out.println("학번 : 1871047");
//	System.out.println("성명 : 장세영");
//	System.out.println("=============");

	Computer(){
		super(200); //가격 200, 포인트 20인 인스턴스 객체 생성 가능한 생성자
	}
	
	//toString 메서드 오버라이드
	public String toString() {
		return "Computer";
	}
}
