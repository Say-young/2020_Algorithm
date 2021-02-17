package lab;

public class Product {
	
//	System.out.println("=============");
//	System.out.println("전공 : 컴퓨터공학");
//	System.out.println("학번 : 1871047");
//	System.out.println("성명 : 장세영");
//	System.out.println("=============");
	
	int price;
	int bonusPoint;
	
	//가격을 인자로 받음
	Product(int price){
		this.price = price; //받은 인자의 값을 생성할 product 타입 인스턴스의 가격에 대입
		bonusPoint = (int)(price/10.0); //가격의 10프로를 보너스 포인트에 대입
	}
}
