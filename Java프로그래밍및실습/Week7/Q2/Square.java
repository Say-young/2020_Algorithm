package lab1;


public class Square implements Geometry{//�������̽��� implements
	/*
	System.out.println("=============");
			System.out.println("���� : ��ǻ�Ͱ���");
			System.out.println("�й� : 1871047");
			System.out.println("���� : �弼��");
			System.out.println("=============");	
	*/
	double side; //����� ���� ����
	
	//�� ������
	Square(){
	}
	
	//�Ķ���� ���� ������ �����ϴ� ������
	Square(double side){
		this();
		this.side = side;
	}
	
	//�������̵� - ���̸� ���ϴ� �޼���
	public double area() {
		return side*side;
	}
	
	//�������̵� - ���̸� ���ϴ� �޼���
	public double perimeter() {
		return side*4;
	}
	
}
