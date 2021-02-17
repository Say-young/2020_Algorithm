package myPackage1;

//추상 클래스
public abstract class Pet{
	/*
	System.out.println("=============");
			System.out.println("전공 : 컴퓨터공학");
			System.out.println("학번 : 1871047");
			System.out.println("성명 : 장세영");
			System.out.println("=============");	
	*/
	//사용할 변수 선언
	public String species;
	public String name;
	public int age;
	
	//파라미터를 받아와 변수에 저장하는 생성자
	Pet(String species, String name, int age){
		this.species = species;
		this.name = name;
		this.age = age;
	}
	
	//추상 메서드로 정의. 이 클래스를 상속받을 다른 자식 클래스에서 오버라이딩해 사용
	public abstract void move();
}
