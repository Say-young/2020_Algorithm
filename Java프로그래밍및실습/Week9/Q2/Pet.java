package lab9_2;

import java.io.Serializable;

public class Pet implements Serializable{ //pet Ŭ������ Serializable �������̽��� �����ؾ� ��.

	//System.out.println("=============");
	//System.out.println("���� : ��ǻ�Ͱ���");
	//System.out.println("�й� : 1871047");
	//System.out.println("���� : �弼��");
	//System.out.println("=============");
	
	//����� ���� private���� ����
	private String name;
	private int age;
	private double weight;
	
	//pet �ν��Ͻ��� ������ �������ִ� �޼���
	public void setPet(String newName, int newAge, double newWeight) {
		setName(newName);
		setAge(newAge);
		setWeight(newWeight);
	}
	
	//�Ʒ��� private ������ ���� getters�� setters��
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
