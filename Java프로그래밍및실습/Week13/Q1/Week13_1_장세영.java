package asm13_1;

public class Week13_1_�弼�� {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		//������ thread�� sharedarea �ν��Ͻ� ����
		PrintThread thread1 = new PrintThread();
		SimulThread thread2 = new SimulThread();
		SharedArea SH = new SharedArea();
		
		//�� thread�� sharedarea�� ������ ����(������ �ְ�޾ƾ���)
		thread1.sharedarea = SH;
		thread2.sharedarea = SH;
		
		//thread ����
		thread1.start();
		thread2.start();
	}
}
