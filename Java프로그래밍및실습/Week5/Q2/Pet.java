package hw;

public class Pet {
	private String name;
	private int age;
	private double weight;
	
	public void writeOutput() { // name, age, weight ���
		System.out.println("Name : "+name);
		System.out.println("Age: "+age);
		System.out.println("Weight: "+weight);
	}
	
	public void setPet(String name, int age, double weight) {
		//private������ ���������Ƿ� ���� ���� �Ұ���. ������ ���� set�޼ҵ�� �����ؾ� �Ѵ�.
		//�Ʒ��� �̸�, ����, �����Ը� �����ϴ� �޼ҵ尡 �����Ƿ� Ȱ���ϱ�
		setName(name);
		setAge(age);
		setWeight(weight);
	}
	
	public void setName(String name) {
		this.name = name; //�̸��� �ٲ��ִ� set �޼ҵ�
	}
	
	public void setAge(int age) {
		this.age = age; //���̸� �ٲ��ִ� set �޼ҵ�
		
	}
	
	public void setWeight(double weight) {
		this.weight = weight; //�����Ը� �ٲ��ִ� set �޼ҵ�
	}
	
	//��� ���� private �������� ���� ������ �Ұ����ϹǷ� get �޼ҵ带 ���� �����ؾ� �Ѵ�.
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
