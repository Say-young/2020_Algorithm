package myPackage1;

//�߻� Ŭ����
public abstract class Pet{
	/*
	System.out.println("=============");
			System.out.println("���� : ��ǻ�Ͱ���");
			System.out.println("�й� : 1871047");
			System.out.println("���� : �弼��");
			System.out.println("=============");	
	*/
	//����� ���� ����
	public String species;
	public String name;
	public int age;
	
	//�Ķ���͸� �޾ƿ� ������ �����ϴ� ������
	Pet(String species, String name, int age){
		this.species = species;
		this.name = name;
		this.age = age;
	}
	
	//�߻� �޼���� ����. �� Ŭ������ ��ӹ��� �ٸ� �ڽ� Ŭ�������� �������̵��� ���
	public abstract void move();
}
