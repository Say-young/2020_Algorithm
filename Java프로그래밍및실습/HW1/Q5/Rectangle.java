package hw5;

public class Rectangle extends Shape{
	/*
	System.out.println("=============");
	System.out.println("���� : ��ǻ�Ͱ���");
	System.out.println("�й� : 1871047");
	System.out.println("���� : �弼��");
	System.out.println("=============");
	*/
	
	//���� ����. private�̹Ƿ� getter�� setter �ʿ�
	private int width;
	private int height;
	
	//�������� �����ϴ� �޼���
	public void setPoint(int x, int y, int width, int height) {
		super.setPoint(x,y);//�θ�Ŭ������ �޼��� ȣ��
		this.width = width;//�߰� ���� ����
		this.height = height;//�߰� ���� ����
	}
	
	public void display() {
		super.display();//�θ�Ŭ������ �޼��� ȣ��
		System.out.println("Width: "+width+", Height: "+height); //�߰� ��� ����
	}
}
