import java.util.Scanner;
public class Week2_4_�弼�� {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Factorial�� ����� ���� �Է�");
		
		int n = scanner.nextInt(); // ������� ���� �Է¹޴´�.
		int a = 1; // �ջ� ��� ����� ���� �̸� �ʱ�ȭ
		
		//���� üũ. ������ ����� �ݺ��ؼ� ���Է¹���.
		while(n<=0 || n>10) {
			System.out.println("���� ���Է�(1~10): ");
			n = scanner.nextInt();
		}
		
		//������ ���� ��� ���
		System.out.print(n+"! = ");
		
		//�ϳ��� �Ʒ��� ī��Ʈ �ϸ� �ݺ����� ����
		for(int i = n; i>1; i--) {
			System.out.print(i);
			System.out.print(" X ");
			a*=i; //���⼭ �ѹ��� ���丮�� ���!
		}
		System.out.printf("1 = %d",a);
	}
}
