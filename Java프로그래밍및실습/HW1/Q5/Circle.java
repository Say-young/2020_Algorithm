package hw5;

public class Circle extends Shape{
	/*
	System.out.println("=============");
	System.out.println("���� : ��ǻ�Ͱ���");
	System.out.println("�й� : 1871047");
	System.out.println("���� : �弼��");
	System.out.println("=============");
	*/
	
	//���� ����. private�̹Ƿ� getter�� setter �ʿ�
	private int radius;
	
	//�������� �����ϴ� �޼���
	public void setPoint(int x, int y, int radius) {
		super.setPoint(x, y);//�θ�Ŭ������ �޼��� ȣ��
		this.radius = radius;//�߰� ���� ����
	}
	
	public void display() {
		super.display();//�θ�Ŭ������ �޼��� ȣ��
		System.out.println("Radius r = "+radius);//�߰� ��� ����
	}
}
