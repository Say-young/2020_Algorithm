import java.util.Scanner;
public class Week2_5_�弼�� {
	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		//����ڰ� �Է��ϴ� ���� �ޱ� ���� scanner
		Scanner scanner = new Scanner(System.in);
		
		//����ڿ��� �� �Է¹ޱ�. ������� �Է°��� �� �� �ﰢ���� ���̴�.
		System.out.print("Enter the height of the triangle :");
		int height = scanner.nextInt();

		//�Է¹��� ���̸�ŭ �ݺ�
		for(int i = 0; i<height ; i++) {
			//��ĭ�� ����ϴ� �κ�. �ٱ� �ݺ����� i�� Ȱ��.
			for(int j = 0; j<height-i; j++) {
				System.out.printf(" ");
			}
			//*�� ����ϴ� �κ�. ���� �ٱ� �ݺ����� i�� Ȱ��.
			for(int k = 0; k<2*i-1; k++) {
				System.out.printf("*");
			}
			//i�� �ϳ��� ���� Ŀ�� ������ ����
			System.out.println("");
		}
	}
}
