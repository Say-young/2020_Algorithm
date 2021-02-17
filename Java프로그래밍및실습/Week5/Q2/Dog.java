package hw;

public class Dog extends Pet {
	
	boolean boosterShot; //예방접종 여부 변수 선언
	
	Dog(){
		super();
	}
	
	public void writeOutput() { //Pet 클래스에 있는 동일한 이름의 메소드 오버라이딩
		System.out.println("Boostershot: "+boosterShot); // 예방접종에 대한 메세지 출력.
	}
	
	//boosterShot변수는 private이므로 직접 접근이 불가능하다. set 메소드를 통해 접근
	public void setBoosterShot(boolean boosterShot) {
		this.boosterShot = boosterShot; //예방접종여부를 바꿔주는 set 메소드
	}
	
	//출력 역시 private 변수에는 직접 접근이 불가능하므로 get 메소드를 통해 접근해야 한다.
	public boolean getBoosterShot() {
		return boosterShot;
	}
	
	public void move() {
		System.out.println(super.getName() + " walks and runs."); //Pet 클래스의 name 변수는 private이므로 getName 메소드를 통해 호출해야 한다.
	}
}
