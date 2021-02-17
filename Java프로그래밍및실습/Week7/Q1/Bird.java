package myPackage1;

public class Bird extends Pet{//Pet을 상속받음
/*
System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");	
*/
	//파라미터를 받아와 Pet의 생성자 호출
	Bird(String species, String name, int age){
		super(species, name, age);
	}
	//Pet의 메서드 오버라이딩
	public void move() {
		System.out.println("fly");
	}
}