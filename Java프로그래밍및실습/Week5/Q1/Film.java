package hwhw;

public class Film extends Production{
	private int boxOfficeGross;
	
	//빈 생성자는 습관적으로 생성해두기.
	Film(){
		super();
	}
	//아래 변수는 private이므로 직접 접근이 불가하기에 get메소드를 활용해 값을 호출한다
	public int getBoxOfficeGross() {
		return boxOfficeGross;
	}
	//아래 변수는 private이므로 직접 접근이 불가하기에 set메소드를 활용해 값을 저장한다
	public void setBoxOfficeGross(int a) {
		boxOfficeGross = a;
	}
	//production 클래스의 display 메서드를 오버라이딩.
	public void display() {
		super.display();
		System.out.println("boxOfficeGross: "+getBoxOfficeGross());
	}
}
