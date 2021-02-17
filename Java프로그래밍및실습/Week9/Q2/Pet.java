package lab9_2;

import java.io.Serializable;

public class Pet implements Serializable{ //pet 클래스도 Serializable 인터페이스를 구현해야 함.

	//System.out.println("=============");
	//System.out.println("전공 : 컴퓨터공학");
	//System.out.println("학번 : 1871047");
	//System.out.println("성명 : 장세영");
	//System.out.println("=============");
	
	//사용팔 변수 private으로 선언
	private String name;
	private int age;
	private double weight;
	
	//pet 인스턴스의 정보를 저장해주는 메서드
	public void setPet(String newName, int newAge, double newWeight) {
		setName(newName);
		setAge(newAge);
		setWeight(newWeight);
	}
	
	//아래는 private 변수에 대한 getters와 setters임
	public void setName(String newName) {
		name = newName;
	}
	public void setAge(int newAge) {
		age = newAge;
	}
	public void setWeight(double newWeight) {
		weight = newWeight;
	}
	public String getName() {
		return name;
	}	
	public int getAge() {
		return age;
	}
	public double getWeight() {
		return weight;
	}
}
