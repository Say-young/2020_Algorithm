package lab;
	import java.util.Scanner;
	public class Week3_4_�弼�� {

		public static void main(String[] args) {

			System.out.println("=============");
			System.out.println("���� : ��ǻ�Ͱ���");
			System.out.println("�й� : 1871047");
			System.out.println("���� : �弼��");
			System.out.println("=============");
			
			//MenuOrder ��ü ����
			MenuOrder order = new MenuOrder();
			String input;
			
			//������� ���� �Է� �ޱ�
			Scanner scanner = new Scanner(System.in);
			
			//���� ���� �����ϱ�
			System.out.println("---���� ���� ����---");
			System.out.print("Coke����:");
			order.setPrice("coke", scanner.nextInt());
			System.out.print("Lemonade����:");
			order.setPrice("lemonade", scanner.nextInt());
			System.out.print("Coffee����:");
			order.setPrice("coffee", scanner.nextInt());

			
			//�Ʒ� 3,4�� ���� �ݺ� (��, y�ϰ��)
			do {
				
			//����ڿ��� ���� �� �׼� �ޱ�
			System.out.println("\n---���� ��������---");
			order.setInputMoney(scanner.nextInt());
			int need=0;
			
			//�޴��� ������
			order.showMenu();
			
			//�޴� ��ȣ�� ������ ���� ����
			int choice = scanner.nextInt();
			
			//���� �޴���ȣ�� ���
			order.showResult(order, choice);
		
			//choice�� �ش��ϴ� ���ǹ��� �������� �ʾҴ��� ���� �޴��� �����ص� �ܾ� ǥ�� ������ ����� �Ǿ� �� ���ǹ��� �߰��ߴ�.
			//�� ���ǹ��� �߰����� �ʰ� ���ÿ� ���� ǥ���� �� �ִ� ����� �ִ��� �ñ���
			if(choice ==1 || choice ==2 || choice==3) {
				if(order.getInputMoney()>=0)
					System.out.println("�ܵ��� "+order.getInputMoney()+"���Դϴ�.");
				else //�ܾ��� ���̳ʽ��� ��� ���� �����ϴٴ� ���̹Ƿ�
					{
					need = Math.abs(order.getInputMoney()); //���̳ʽ��� �ܾ��� ����ó���Ͽ� ������ �ݾ����� ���
					System.out.println(need+"�� �� �־��ּ���.");
				}
			}
			
			//����ڿ��� �ݺ� �ǻ縦 ����
			System.out.println("��� �Ͻðڽ��ϱ�? (y/n)");
			input = scanner.nextLine(); //���͸Ա�
			input = scanner.nextLine();
			}while(input.equalsIgnoreCase("y")); // y�� ��� �ݺ�
		}

	}
