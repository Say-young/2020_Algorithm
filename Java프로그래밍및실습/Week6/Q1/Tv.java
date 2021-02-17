package lab;

public class Tv extends Product{
	
//	System.out.println("=============");
//	System.out.println("전공 : 컴퓨터공학");
//	System.out.println("학번 : 1871047");
//	System.out.println("성명 : 장세영");
//	System.out.println("=============");
	
	Tv(){
		super(100);//가격 100, 포인트 10인 인스턴스 객체 생성 가능한 생성자
	}
	
	public String toString() {
		return "TV";
	}
}
