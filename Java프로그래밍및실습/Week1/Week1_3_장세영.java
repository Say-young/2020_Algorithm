package week1;
import java.util.Scanner;
public class Week1_3_�弼�� {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : Computer Engineering");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		//ù���� �Է¹ޱ�
		Scanner text = new Scanner(System.in);
		System.out.println("Enter a line of text.");
		String a = text.nextLine();
		
		//�Է¹��� ���� ���� �����ֱ�. ū����ǥ�� ����ϱ� ���ؼ��� �齽������ ����ؾ� �Ѵ�.
		System.out.println("Your text is \""+a+"\"");
		
		//�ٲ� �ܾ� �Է¹ޱ�
		System.out.println("Input a word to replace.");
		String b = text.nextLine();
		
		//���ο� �ܾ� �Է¹ޱ�
		System.out.println("Input a word to insert.");
		String c = text.nextLine();
		
		//���� �ܾ ���ο� �ܾ�� ��ü
		String d = a.replaceFirst(b, c);
		
		//���ο� ���� ���. ��� ���ڸ� �빮�ڷ� �����ϱ�
		System.out.println("New Sencence is \""+d.toUpperCase()+"\"");
		
		//������ ���̸� ǥ���ϴ� length �޼ҵ�
		System.out.println("The length of \""+d.toUpperCase()+"\" is "+ a.length() + ".");
	}
}
