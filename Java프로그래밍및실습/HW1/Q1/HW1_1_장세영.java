package hw1;
import java.util.*;

public class HW1_1_�弼�� {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		Time time = new Time(); //Time �ν��Ͻ� ����
		int hour = 0, minute = 0; //�Է� ���� ���� �ʱ�ȭ
		
		//�ùٸ� �Է��� ���� ������ �ݺ�
		while(true) {
			try {
				System.out.println("Hour:"); //�ð� �����
				hour = scanner.nextInt(); //���� �Է¹ޱ�
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("�߸��� �Է��Դϴ�. ���ڸ� �Է��Ͻʽÿ�."); //���� ���ڰ� �ƴ� �ٸ� ���� �Է¹޾��� ��� �ȳ� �޼����� ����
				scanner.nextLine(); //���� ��� �� �Է� �ٽ� �ޱ�
			}
		}
		
		while(true) {
			try {
				System.out.println("Minute:"); //�� �����
				minute = scanner.nextInt(); //���� �Է¹ޱ�
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("�߸��� �Է��Դϴ�. ���ڸ� �Է��Ͻʽÿ�.");//���� ���ڰ� �ƴ� �ٸ� ���� �Է¹޾��� ��� �ȳ� �޼����� ����
				scanner.nextLine();//���� ��� �� �Է� �ٽ� �ޱ�
			}
		}
		
		time.setTime(hour,minute); //time��ü�� �ð��� ���� �����ϴ� �޼���
		System.out.println(time.getHourOrMinute('h')+":"+time.getHourOrMinute('m')); //getHourOrMinute �޼��带 ȣ���Ͽ� �ÿ� �� ����ϱ�

	}

}
