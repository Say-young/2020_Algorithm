package hw4;

public class StudentInformation {
	/*
	System.out.println("=============");
	System.out.println("전공 : 컴퓨터공학");
	System.out.println("학번 : 1871047");
	System.out.println("성명 : 장세영");
	System.out.println("=============");
	*/
	
	//변수 선언. private이므로 getter와 setter 필요
	private String name;
	private String id;
	
	//생성자. 사실 같은 클래스 안이라 변수에 바로 대입 가능하나 get 메서드를 사용해봄.
	StudentInformation(){
		name = getName();
		id = getID();
	}
	
	//name setter
	public void setName(String name) {
		this.name = name;
	}
	//id setter
	public void setID(String id) {
		this.id = id;
	}
	//name getter
	public String getName() {
		return name;
	}
	//id getter
	public String getID() {
		return id;
	}
	//getter를 이용해 이름과 id 출력하는 메서드
	public void display() {
		System.out.print(getName()+"\t"+getID()+"\t");
	}
	
}
