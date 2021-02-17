package lab9_2;
import java.io.Serializable;

public class Dog extends Pet implements Serializable{ //Pet Ŭ������ ��ӹް�, object ����� ���� ������ϱ� ���� Serializable �������̽��� ������

	//System.out.println("=============");
	//System.out.println("���� : ��ǻ�Ͱ���");
	//System.out.println("�й� : 1871047");
	//System.out.println("���� : �弼��");
	//System.out.println("=============");
	
	//dog�� private ���� ����
	private String breed;
	private boolean boosterShot;
	
	//Dog�� ������. Pet�� private �����鿡 ������ ������ �� �ִ� setPet �޼��带 Ȱ���Ѵ�.
	public Dog(String newName, int newAge, double newWeight, String breed, boolean boosterShot){
		super.setPet(newName, newAge, newWeight);
		setBreed(breed);
		setBoosterShot(boosterShot);
	}
	
	//�ش� Ŭ������ �ν��Ͻ� ���������� ������� �� ��µǴ� �޼����� �������̵��ϴ� �޼���
	public String toString() {
	if(this.getBoosterShot()==true) //���� ���� ���ο� ���� O/X�� ǥ���ؾ� �ϹǷ� �̷��� ������ ������
		return (this.getName() + "\t" + this.getAge() + "\t" + this.getWeight() + "\t" + this.getBreed() + "\t\tO"); //�������� ���� ���
	else
		return (this.getName() + "\t" + this.getAge() + "\t" + this.getWeight() + "\t" + this.getBreed() + "\t\tX"); //�� ���� ��� �̷��� ���
	}
	
	
	//�Ʒ��� private ������ ���� getters�� setters��
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
