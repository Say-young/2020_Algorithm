// y/n �ͼ��� �����غ���

package hw3;
import java.util.*;

public class HW1_3_�弼�� {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		String ch;
		String string;
		char Arr[] = new char[100];
		
		while(true) { //1�� �ݺ���. n�� �Է¹ޱ� ������ ��ü ������ ��� �ݺ�
			System.out.println("Input a word");
			string = scanner.next(); //����ڿ��� string�� �Է¹޾�
			Arr = string.toCharArray(); //charArray�� ����
			if(check(Arr)) { //��Ī�� �˻��ϴ� �޼��带 ���� �ۿ� ���� ��������.
				System.out.println("symmetry"); //���� ��Ī�̶�� ��Ī ���
			}
			else {
				System.out.println("Asymmetry"); //���Ī�̶�� ���Ī ���
			}
			scanner.nextLine(); //���� �Է��� ���� ���� ����
			
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
	}
	
	//��Ī�� �˻��ϴ� �޼���. ��/������ ����� ��ȯ
	public static boolean check(char[] Arr) { //�迭�� �ּҸ� �Ķ���ͷ� �޾ƿ�
		for(int i=0; i<Arr.length/2; i++) { //�迭�� ������ ����(��ü ������ ������ Ȧ���ϰ�� ���ݿ��� ������ ��)���� �ݺ�
			char s = Arr[i]; //s���� �տ������� ���ʴ�� �迭�� ���Ҹ� �����ϰ�
			char e = Arr[Arr.length-1-i]; //e���� �ڿ������� ���ʴ�� �迭�� ���Ҹ� �����Ѵ�
			if(s==e) //���� �հ� ���� ���ҵ��� �߾����� �� ������ ��� ¦�� �̷�ٸ�
				return true; //true ��ȯ = ��Ī
			else
				return false;//�ƴ϶�� false ��ȯ
		}
		return false; //�⺻�� false�� ��ȯ�ϵ��� ��������.
	}
}
