import java.util.Scanner;
public class Week2_3_�弼�� {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		String input = "y"; //�ʱ�ȭ
		
		do { //�ϴ� ������ �� �ݺ� ���� ������
		//���� �Է� �ޱ�
		System.out.print("�����Է�:");
		int score = scanner.nextInt();
		
		if(score>100 || score <0) {
			System.out.println("������ 0~100 �����Դϴ�.");
		}
		
		else {
			int a = score/10;
			char grade;
			
			switch(a) {
			case 10:
			case 9 : 
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
				break;
			}
			System.out.printf("������ %d���̰� grade�� %c�Դϴ�.\n", score, grade);
		}
		System.out.println("�ݺ��Ͻðڽ��ϱ�?(y/n)");
		input=scanner.nextLine();//���ۿ� �����ִ� ���� ����
		input=scanner.nextLine();
		}while(input.equalsIgnoreCase("y")); //��ҹ��ڿ� ��� ���� y�� �Է��ϸ� �ݺ�
	System.out.println("����");
	}
}
