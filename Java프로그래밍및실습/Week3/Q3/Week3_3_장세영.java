package hw;
import java.util.Scanner;
public class Week3_3_�弼�� {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");

		//����ڿ��� ���� ���� �Է¹ޱ�
		Scanner kbd = new Scanner(System.in);
		
		//��������
		String title;
		int page;
		
		//MyFile ��ü 2�� �����
		MyFile fold = new MyFile();
		MyFile fNew = new MyFile();
		
		System.out.println("--File�����Է�(����,��������)--");
		
		//�����̶� ������ �Է¹ޱ�. title�� page�� private �����̹Ƿ� ���� ������ �Ұ����ϰ� set�޼ҵ� �̿��ؾ� ��.
		fold.setTitle(kbd.nextLine());
		fold.setPage(kbd.nextInt());
		
		//copy �޼ҵ带 �̿��� fold�� ������ fNew�� ����
		fold.filecopy(fNew);
		
		//������ ��ü ������ ����ϴ� �Լ� fileInfo�� �̿��� ���簡 �Ϸ�� ���� Ȯ��
		System.out.println("<����File>");
		fold.fileInfo();
		System.out.println("<�����File>");
		fNew.fileInfo();
	}

}
