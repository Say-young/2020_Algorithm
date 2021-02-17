package hw2;
import java.util.*;


public class HW2_2_�弼�� {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		String input = null; //while���� �������� �̿��ϱ� ���� �ۿ��� ����
		ArrayList<Character>list = new ArrayList<Character>();
		LinkedList<Character>stack = new LinkedList<Character>(); //linkedlist�� ���� ����

		while(true) {
		System.out.print("\nInput : ");
		input = scanner.nextLine(); //����ڿ��� �Է¹���
		if(input.equals("0")) break; //����ڰ� 0�� �Է½� �ݺ��� ����
		
			if(check(input, list, stack)==true) { //TRUE�� ���Ϲ޾��� ��쿡��
				System.out.println("Correct"); //CORRECT �޼��� ���
			}else {
				stack.clear();
				list.clear();
			}
		}
		System.out.println("Program finished"); //����� �޼��� ���
	}
	
	//���⿡ ����ϵ��� ����ó�� �κ��� ������ �޼���� ������
	public static boolean check (String input, List<Character>list, LinkedList<Character>stack) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
				
				for(int i=0; i<input.length(); i++) {//input ���̸�ŭ �ݺ�
					list.add(input.charAt(i)); //���� �� ���� ��� ������ �ϳ��� �߶� �迭�� ����
				}
				
				for(int i=0; i<input.length(); i++) { //�迭�� ���̸�ŭ �ݺ�
					if(list.get(i)=='{' || list.get(i)=='(' || list.get(i)=='[') {
						stack.addLast(list.get(i)); //���� ���� ��ȣ�� �ش��Ѵٸ� stack�� push
					}
					
					
					else if(list.get(i)=='}' || list.get(i)==')' || list.get(i)==']') { //���� i��° ���Ұ� �ݴ� ��ȣ�� �ش��Ѵٸ�
						if(stack.isEmpty()) { //�׷��� ������ ����ִٸ�
							System.out.println("Incorrect"); //incorrect �޼��� ����ϰ�
							return false; //false ��ȯ�ϱ�
						}
						else {
							char last = stack.removeLast(); //���� �ݴ� ��ȣ�� �ش��Ѵٸ� stack���� top�� ���� pop
							if((last=='{')&&(list.get(i)!='}') || (last=='(')&&(list.get(i)!=')') || (last=='[')&&(list.get(i)!=']')) { //�׷��� ���� ���� ���� �ʴٸ�
								System.out.println("Incorrect"); //incorrect �޼��� ����ϰ�
								return false; //false ��ȯ�ϱ�
							}
						}
					}else {
						System.out.println("Wrong Input");//6���� ��ȣ�� �ش����� ����
						return false;//false ��ȯ�ϱ�
					}
				}
				
				if(stack.isEmpty()!=true) {//���� ���� ������ ��� �����µ��� ������ ������� ������
					System.out.println("Incorrect");//incorrect �޼��� ����ϰ�
					return false;//false ��ȯ�ϱ�
				}
				return true; //���ǵ鿡 �ɸ��� �ʾ��� ��� ���� ����� ���̹Ƿ� true ��ȯ
		}
	}
	
}
