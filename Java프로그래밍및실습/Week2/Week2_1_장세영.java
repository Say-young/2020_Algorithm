import java.util.Scanner;

public class Week2_1_�弼�� {

	public static void main(String[] args) {
	
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		//����ڷκ��� �� �Է¹ޱ�
		Scanner scanner = new Scanner(System.in);
		System.out.print("�� �Է�:");
		int month = scanner.nextInt();
		
		//���� �ϼ� �з��ϱ�
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12://case stacking�� ����� ���� ��� ���� �Ʒ��� ��¹� ���
			System.out.printf("%d������ 31���� �ֽ��ϴ�.", month);
			break;
		case 4:
		case 6:
		case 9:
		case 11://case stacking�� ����� ���� ��� ���� �Ʒ��� ��¹� ���
			System.out.printf("%d������ 30���� �ֽ��ϴ�.", month);
			break;
		case 2:
			System.out.printf("%d������ 28���� �ֽ��ϴ�.", month);
			break;
		default://���� ���� ���� ��� �ش��� ���� ���� ��� ���� ���� ���̹Ƿ� �Է� ���� ���
			System.out.println("�Է� ����");
			break;
		}
	}
}
