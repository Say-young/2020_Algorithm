package hw;
import java.util.Scanner;
public class Week3_2_�弼�� {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");

		//circle ��ü ����
		Circle mycircle = new Circle();
		
		//����ڿ��� �� �Է¹ޱ�
		Scanner scanner = new Scanner(System.in);
		System.out.print("�������Է�:");
		//double�� ����
		mycircle.setRadius(scanner.nextDouble());
		//radius�� private ������ ����Ǿ��� ������ �ٷ� ȣ�� �Ұ���. getRadius �޼ҵ� �̿�
		System.out.println("������:"+mycircle.getRadius());
		//���ѷ��� �����̸� ������ִ� songŬ������ �޼ҵ� �ҷ�����
		mycircle.circleInfo();
	}

}
