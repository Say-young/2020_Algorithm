package hw;
import java.util.Scanner;
public class Week3_1_�弼�� {
	public static void main(String[] args) {

		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		//����ڿ��� �� �Է¹ޱ� ����
		Scanner scanner = new Scanner(System.in);
		
		//���߿� ���� üũ�� ���ϰ� �ϱ� ���ؼ� ���Ƿ� ���� ������
		int choice;
		
		//song ��ü 2�� ����
		Song song1 = new Song();
		Song song2 = new Song();
		
		//�Է¹ޱ�
		System.out.println("*Song 1*");
		//�Է� �޴� �͸��� �ش� ��ü�� ������ �ֱ�
		System.out.print("����Է�:");
		song1.title = scanner.nextLine();
		System.out.print("�������Է�:");
		song1.singer = scanner.nextLine();
		//���� string �Ʒ��� int ���̹Ƿ� �޴� ������ �ٸ���
		System.out.print("�����Է�:");
		song1.price = scanner.nextInt();
		
		System.out.println("");
		
		//�Է¹ޱ�
		System.out.println("*Song 2*");
		//�Է� �޴� �͸��� �ش� ��ü�� ������ �ֱ�
		System.out.print("����Է�:");
		song2.title = scanner.nextLine();
		song2.title = scanner.nextLine();
		System.out.print("�������Է�:");
		song2.singer = scanner.nextLine();
		//���� string �Ʒ��� int ���̹Ƿ� �޴� ������ �ٸ���
		System.out.print("�����Է�:");
		song2.price = scanner.nextInt();
		
		System.out.println("");
		
		System.out.println("�뷡�� ������");
		System.out.println("1:"+song1.title+" 2:"+song2.title);
		//�Ʊ� ������ ������ Ȱ��. ������� �Է°� �ޱ�
		choice = scanner.nextInt();
		
		//�Է¹��� ������ ���� üũ
		if(choice == 1) {
			//����ڰ� 1�� �Է����� ��� 1�� ��ü�� �ش��ϴ� �޼ҵ� ����
			song1.play();
			song1.price();
		}
		else {
			//����ڰ� 1�� �ƴ� �ٸ� ���� �Է����� ��� 2�� ��ü�� �ش��ϴ� �޼ҵ� ����
			song2.play();
			song2.price();
		}
		
		System.out.println("�����մϴ�.");
	}
}
