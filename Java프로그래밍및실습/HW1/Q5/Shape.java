package hw5;

public class Shape {
	/*
	System.out.println("=============");
	System.out.println("���� : ��ǻ�Ͱ���");
	System.out.println("�й� : 1871047");
	System.out.println("���� : �弼��");
	System.out.println("=============");
	*/
	
	//���� ����. private�̹Ƿ� getter�� setter �ʿ�
	private int x;
	private int y;
	
	//�������� �����ϴ� �޼���
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//x,y�� ����ϴ� �޼���
	public void display() {
		System.out.println("Point (x,y) = ("+x+","+y+")");
	}
}
