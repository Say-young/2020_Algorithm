package lab1;

public class Circle implements Geometry{//�������̽��� implements
	
	/*
	System.out.println("=============");
			System.out.println("���� : ��ǻ�Ͱ���");
			System.out.println("�й� : 1871047");
			System.out.println("���� : �弼��");
			System.out.println("=============");	
	*/
	
	double radius; //����� ���� ����
	
	//�� ������
	Circle(){
	}
	
	//�Ķ���� ���� ������ �����ϴ� ������
	Circle(double radius){
		this();
		this.radius = radius;
	}
	
	//�������̵� - ���̸� ���ϴ� �޼���
	public double area() {
		return radius*radius*PI;
	}
	
	//�������̵� - ���̸� ���ϴ� �޼���
	public double perimeter() {
		return radius*PI*2;
	}
}
