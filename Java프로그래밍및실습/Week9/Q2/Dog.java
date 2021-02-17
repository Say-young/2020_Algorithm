package lab9_2;
import java.io.Serializable;

public class Dog extends Pet implements Serializable{ //Pet 클래스를 상속받고, object 덩어리로 파일 입출력하기 위해 Serializable 인터페이스를 구현함

	//System.out.println("=============");
	//System.out.println("전공 : 컴퓨터공학");
	//System.out.println("학번 : 1871047");
	//System.out.println("성명 : 장세영");
	//System.out.println("=============");
	
	//dog의 private 변수 선언
	private String breed;
	private boolean boosterShot;
	
	//Dog의 생성자. Pet의 private 변수들에 정보를 저장할 수 있는 setPet 메서드를 활용한다.
	public Dog(String newName, int newAge, double newWeight, String breed, boolean boosterShot){
		super.setPet(newName, newAge, newWeight);
		setBreed(breed);
		setBoosterShot(boosterShot);
	}
	
	//해당 클래스의 인스턴스 참조변수를 출력했을 때 출력되는 메세지를 오버라이딩하는 메서드
	public String toString() {
	if(this.getBoosterShot()==true) //예방 접종 여부에 따라 O/X로 표기해야 하므로 이렇게 조건을 나눴다
		return (this.getName() + "\t" + this.getAge() + "\t" + this.getWeight() + "\t" + this.getBreed() + "\t\tO"); //예방접종 맞은 경우
	else
		return (this.getName() + "\t" + this.getAge() + "\t" + this.getWeight() + "\t" + this.getBreed() + "\t\tX"); //안 맞은 경우 이렇게 출력
	}
	
	
	//아래는 private 변수에 대한 getters와 setters임
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public void setBoosterShot(boolean boosterShot) {
		this.boosterShot = boosterShot;
	}
	public String getBreed() {
		return breed;
	}
	public boolean getBoosterShot() {
		return boosterShot;
	}
}
