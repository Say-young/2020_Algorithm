package hw;

public class Pet {
	private String name;
	private int age;
	private double weight;
	
	public void writeOutput() { // name, age, weight 출력
		System.out.println("Name : "+name);
		System.out.println("Age: "+age);
		System.out.println("Weight: "+weight);
	}
	
	public void setPet(String name, int age, double weight) {
		//private변수로 선언했으므로 직접 접근 불가능. 선언할 때는 set메소드로 접근해야 한다.
		//아래에 이름, 나이, 몸무게를 변경하는 메소드가 있으므로 활용하기
		setName(name);
		setAge(age);
		setWeight(weight);
	}
	
	public void setName(String name) {
		this.name = name; //이름을 바꿔주는 set 메소드
	}
	
	public void setAge(int age) {
		this.age = age; //나이를 바꿔주는 set 메소드
		
	}
	
	public void setWeight(double weight) {
		this.weight = weight; //몸무게를 바꿔주는 set 메소드
	}
	
	//출력 역시 private 변수에는 직접 접근이 불가능하므로 get 메소드를 통해 접근해야 한다.
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void move() {
		System.out.println(name + " moves.");
	}
	
}
