package lab;
import java.util.Scanner;

public class Week4_1_�弼�� {
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");

		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*Song ����*");
		String singer="", title = "";
		int price;
		
		do {
			try {
				System.out.print("���:"); //��� �Է¹ޱ�
				title = scanner.nextLine();
				//���� ���͸� �Է¹޾��� ���
				if(title.equals(""))
					throw new Exception("����� �ݵ�� �ʿ��մϴ�."); //�ش� ���� �޼��� ������
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(title.equals("")); //��� ���Ͱ� ������ ��� Ÿ��Ʋ�� �Է¹��� ������ �ݺ�

		
		System.out.print("������:"); //������ �Է¹ޱ�
		singer = scanner.nextLine();
				
		
		System.out.print("����:"); //���� �Է¹ޱ�
		price = scanner.nextInt();
		int lastprice =0;
		
		Song song; //���� ���� ������ ����
		//�Ʒ����� �Է¹��� ���� ������ ���� �ٸ� �ν��Ͻ� ����
		if(singer.equals("")) {
			song = new Song(title, price);
		}
		else {
			song = new Song(title, singer, price);
		}
		
		System.out.println("��� �����ðڽ��ϱ�? "); //�ݺ� Ƚ�� �Է¹ޱ�
		int num = scanner.nextInt();
		for(int i=1; i<=num; i++) {
			song.play(); //�Է� ���� Ƚ����ŭ �뷡 ��� ����ϰ�
			lastprice += song.price;
		}
		
		System.out.printf("�� %d���Դϴ�.", lastprice); //�� ���� ���
	}
}
