// y/n �ͼ��� �����غ���

package hw2;
import java.util.*;

public class HW1_2_�弼�� {

	public static void main(String[] args) {

		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		String ch; // y/n�� ����� ���� ����
		DiceGame dicegame = new DiceGame(); //�ν��Ͻ� ����
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("<< GAME START >>");
		while(true) { //1���ݺ���. n�� �Է¹ޱ� ������ ��� �ݺ�
			System.out.println("Dice is rolled!!!");
			dicegame.startPlaying();//�ش� �޼��忡 ���ǵǾ� �ִ� ��� �޼��� �۵�
			while(true) { //2�� �ݺ���. try again�� ����� �� ���� �޾��� �� ���������� �ݺ���
			try {
			System.out.println("Try agian?(y/n)");
			ch = scanner.nextLine(); //���� �Է¹���
			if(ch.equalsIgnoreCase("n")||ch.equalsIgnoreCase("y")){ //���� �� ���� n�̳� y(�� �ùٸ� ���̶��) 2�� �ݺ��� ��������
				System.out.println("");
				break;
				}
			else if(!ch.equalsIgnoreCase("n")&&!ch.equalsIgnoreCase("y")) // n�̳� y�� ���� �Է¹��� �ʾ��� ��
				throw new Exception("y Ȥ�� n�� �Է����ּ���");//���� throw
			}catch(Exception e) {
				System.out.println(e.getMessage()); //y �Ǵ� n�� �Է��϶�� �޼����� ��� �� 2�� �ݺ��� �ٽ� �ݺ�
			}
			}if(ch.equalsIgnoreCase("n")) //y�� ��쿡�� 1�� �ݺ����� ������ �ʰ� ��� �ݺ�, n�� ��쿡�� 1�� �ݺ����� �������� ����
				break;
		}
		System.out.println("Game finished.");

	}

}
