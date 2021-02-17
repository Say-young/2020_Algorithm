package lab2;

public class PoliceCar extends Car{
//	System.out.println("=============");
//	System.out.println("전공 : 컴퓨터공학");
//	System.out.println("학번 : 1871047");
//	System.out.println("성명 : 장세영");
//	System.out.println("=============");

	//자식 클래스의 객체를 생성할 때 부모 생성자를 호출하여 각 변수값 초기화
	PoliceCar(){
		super("Thief", 112, "PoliceCar", "PoliceOfficer");
	}
	
	//toString()메서드를 getStr()을 출력하도록 오버라이드
	public String toString() {
		return getStr();
	}
	
}
