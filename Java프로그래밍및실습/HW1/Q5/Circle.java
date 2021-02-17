package hw5;

public class Circle extends Shape{
	/*
	System.out.println("=============");
	System.out.println("전공 : 컴퓨터공학");
	System.out.println("학번 : 1871047");
	System.out.println("성명 : 장세영");
	System.out.println("=============");
	*/
	
	//변수 선언. private이므로 getter와 setter 필요
	private int radius;
	
	//변수값을 저장하는 메서드
	public void setPoint(int x, int y, int radius) {
		super.setPoint(x, y);//부모클래스의 메서드 호출
		this.radius = radius;//추가 저장 사항
	}
	
	public void display() {
		super.display();//부모클래스의 메서드 호출
		System.out.println("Radius r = "+radius);//추가 출력 사항
	}
}
