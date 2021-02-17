package lab2;
import java.util.*;

public class Week6_2_�弼�� {
	public static void main(String[] args) {

		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");

		Scanner scanner = new Scanner(System.in);

		Car car[] = new Car[3];
		//�� �ν��Ͻ��� ����
		car[0] = new FireEngine();
		car[1] = new Ambulance();
		car[2] = new PoliceCar();
		Emergency em = new Emergency();
		
		//�ݺ����� ����Ͽ� ����� �Է��� ����
		int j=0;
		//����ڰ� 5�� �Է��ϱ� ������ ��� �ݺ�
		while(j!=5) {
			try {
			System.out.println("What kind of Emergency?");
			System.out.println("1.Fire   2.Patient   3.Thief   4.Record   5.End");
			j = scanner.nextInt(); //����ڿ��� ���� �Է¹ޱ�
			//�Է¹��� ���ڿ� ���� �ٸ� ��ü�� EM_Call �޼��� ȣ��
			switch(j) {
				case 1:
					em.EM_Call(car[0]);
					break;
				case 2:
					em.EM_Call(car[1]);
					break;
				case 3:
					em.EM_Call(car[2]);
					break;
				case 4: //4�� �Է½� EM_record()�޼��� ȣ��
					em.EM_record();
					break;
				case 5://����
					System.out.println("Finished"); 
					break;
				default://1~5 �̿��� �Է��� ���� ���
					System.out.println("Wrong Input");
			}
			}//���� ���ڰ� �ƴ� �ٸ� ���� �Է¹�����
			catch(InputMismatchException e) {
				scanner.nextLine(); //���ۺ���
				System.out.println("���ڸ� �Է� �����մϴ�. �ٽ� �Է����ּ���.");//�ȳ��޼���
			}
		}
	}
}
