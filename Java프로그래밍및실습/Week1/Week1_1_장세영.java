package week1;

import java.util.Scanner;
public class Week1_1_�弼�� {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : Computer Engineering");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		//���� ����
		int f;
		double c;
		
		//ȭ���µ� �Է¹ޱ�
		Scanner a = new Scanner(System.in);
		System.out.print("ȭ���µ� �Է�:");
		
		//�Է¹��� �� ȭ�� �µ��� ����
		f = a.nextInt();
		
		//ȭ�� �µ��� ���� �µ� ����ؼ� ����
		c = (double)5/9*(f-32);
		
		//����� ���
		System.out.println("");
		System.out.println("ȭ���µ�:"+f);
		System.out.print("�����µ�:");
		System.out.printf("%.1f",c); //�Ҽ��� ���ڸ������� ��Ÿ����
	}

}
