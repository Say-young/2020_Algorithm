package hw;

public class Cat extends Pet {
	
	private String color;
	
	Cat(){
		super();
	}
	
	public void writeOutput() { //Pet 클래스에 있는 동일한 이름의 메소드 오버라이딩
		System.out.println("Color: "+color); // 색깔에 대한 메세지 출력.
	}
	
	//color 변수는 private이므로 직접 접근이 불가능하다. set 메소드를 통해 접근
	public void setColor(String color) {
		this.color = color; //예방접종여부를 바꿔주는 set 메소드
	}
	
	//출력 역시 private 변수에는 직접 접근이 불가능하므로 get 메소드를 통해 접근해야 한다.
	public String getColor() {
		return color;
	}
	
	public void move() {
		System.out.println(super.getName() + " creeps and jumps."); //Pet 클래스의 name 변수는 private이므로 getName 메소드를 통해 호출해야 한다.
	}
}
