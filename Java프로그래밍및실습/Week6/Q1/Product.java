package lab;

public class Product {
	
//	System.out.println("=============");
//	System.out.println("���� : ��ǻ�Ͱ���");
//	System.out.println("�й� : 1871047");
//	System.out.println("���� : �弼��");
//	System.out.println("=============");
	
	int price;
	int bonusPoint;
	
	//������ ���ڷ� ����
	Product(int price){
		this.price = price; //���� ������ ���� ������ product Ÿ�� �ν��Ͻ��� ���ݿ� ����
		bonusPoint = (int)(price/10.0); //������ 10���θ� ���ʽ� ����Ʈ�� ����
	}
}
