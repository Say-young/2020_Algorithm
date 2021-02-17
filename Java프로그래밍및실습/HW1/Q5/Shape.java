package hw5;

public class Shape {
	/*
	System.out.println("=============");
	System.out.println("전공 : 컴퓨터공학");
	System.out.println("학번 : 1871047");
	System.out.println("성명 : 장세영");
	System.out.println("=============");
	*/
	
	//변수 선언. private이므로 getter와 setter 필요
	private int x;
	private int y;
	
	//변수값을 저장하는 메서드
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//x,y를 출력하는 메서드
	public void display() {
		System.out.println("Point (x,y) = ("+x+","+y+")");
	}
}
