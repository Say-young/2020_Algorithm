package lab2;

public class Ambulance extends Car{
//	System.out.println("=============");
//	System.out.println("���� : ��ǻ�Ͱ���");
//	System.out.println("�й� : 1871047");
//	System.out.println("���� : �弼��");
//	System.out.println("=============");

	//�ڽ� Ŭ������ ��ü�� ������ �� �θ� �����ڸ� ȣ���Ͽ� �� ������ �ʱ�ȭ
	Ambulance(){
		super("Patient", 119, "Ambulance", "Doctor");
	}
	
	//toString()�޼��带 getStr()�� ����ϵ��� �������̵�
	public String toString() {
		return getStr();
	}
}
