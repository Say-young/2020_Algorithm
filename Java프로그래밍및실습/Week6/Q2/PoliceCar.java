package lab2;

public class PoliceCar extends Car{
//	System.out.println("=============");
//	System.out.println("���� : ��ǻ�Ͱ���");
//	System.out.println("�й� : 1871047");
//	System.out.println("���� : �弼��");
//	System.out.println("=============");

	//�ڽ� Ŭ������ ��ü�� ������ �� �θ� �����ڸ� ȣ���Ͽ� �� ������ �ʱ�ȭ
	PoliceCar(){
		super("Thief", 112, "PoliceCar", "PoliceOfficer");
	}
	
	//toString()�޼��带 getStr()�� ����ϵ��� �������̵�
	public String toString() {
		return getStr();
	}
	
}
