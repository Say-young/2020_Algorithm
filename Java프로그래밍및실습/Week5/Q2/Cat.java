package hw;

public class Cat extends Pet {
	
	private String color;
	
	Cat(){
		super();
	}
	
	public void writeOutput() { //Pet Ŭ������ �ִ� ������ �̸��� �޼ҵ� �������̵�
		System.out.println("Color: "+color); // ���� ���� �޼��� ���.
	}
	
	//color ������ private�̹Ƿ� ���� ������ �Ұ����ϴ�. set �޼ҵ带 ���� ����
	public void setColor(String color) {
		this.color = color; //�����������θ� �ٲ��ִ� set �޼ҵ�
	}
	
	//��� ���� private �������� ���� ������ �Ұ����ϹǷ� get �޼ҵ带 ���� �����ؾ� �Ѵ�.
	public String getColor() {
		return color;
	}
	
	public void move() {
		System.out.println(super.getName() + " creeps and jumps."); //Pet Ŭ������ name ������ private�̹Ƿ� getName �޼ҵ带 ���� ȣ���ؾ� �Ѵ�.
	}
}
