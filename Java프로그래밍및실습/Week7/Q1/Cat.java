package myPackage1;

public class Cat extends Pet{//Pet�� ��ӹ���
	/*
	System.out.println("=============");
			System.out.println("���� : ��ǻ�Ͱ���");
			System.out.println("�й� : 1871047");
			System.out.println("���� : �弼��");
			System.out.println("=============");	
	*/
	//�Ķ���͸� �޾ƿ� Pet�� ������ ȣ��
	Cat(String species, String name, int age){
		super(species, name, age);
	}
	//Pet�� �޼��� �������̵�
	public void move() {
		System.out.println("jump");
	}
}
