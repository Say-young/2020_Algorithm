package lab;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	int user = 0, computer=0; //���������� ���� ����� ���� ����� �ʱ�ȭ
	int usercount = 0, comcount =0; //�̱� Ƚ���� ������ ���� ����� �ʱ�ȭ
	
	
	
	public void start(){
		System.out.println("���������������� �����մϴ�.\n");
		do {
			input();//�� �Է¹ޱ�
			compare(); //�� ���ϱ�
			writeOutput(); //�Ź� ��� ���
		}while(usercount !=3 && comcount!=3); // �̱� Ƚ���� 3���� �� ������ �ݺ�
		
		//���� ��� ���
		if(usercount == 3)
			System.out.println("����� �̰���ϴ�.");
		else
			System.out.println("����� �����ϴ�.");
		
		//���� ����
		System.out.println("������ �����մϴ�.");
	}
	

	
	
	//������� ���� �Է¹޴� �޼���
	public void input() {
		Scanner scanner = new Scanner(System.in);
		boolean a;
		do {
			try {
				System.out.println("����� ������?");
				System.out.println("����(1) ����(2) ��(3)");
				user = scanner.nextInt(); //������� �Է°��� ����
				a = false;//a�� �ʱ�ȭ. ���� ���� ���� ��� �ݺ����� ���������� ����.
				if(user<1 || user>3)//���� ������� �Է� ���� �����̱� �ϳ� ������ ����ٸ� ���� �޼��� ���
					throw new Exception("������ �߸��Ǿ����ϴ�.\n");
			}
			catch(InputMismatchException e) {
				System.out.println("������ �߸��Ǿ����ϴ�.\n"); //���ڰ� �ƴ� �ٸ� ���� �Է¹޾��� ���
				scanner.nextLine();
				a = true; //true�� �ٲ� ��� while���� �ݺ� ������ �޼��Ǳ� ������ �ٽ� �Է¹��� �� �ִ�
			}
			catch(Exception e) {
				System.out.println(e.getMessage());//�Է¹��� ���� ������ �߸��Ǿ��� ��� ���� �޼��� ���
				a = true;//true�� �ٲ� ��� while���� �ݺ� ������ �޼��Ǳ� ������ �ٽ� �Է¹��� �� �ִ�
			}
		}while(a);//�߸��� ���� �Է½� �ùٸ� ���� ���� ������ �ݺ�
	}
	
	
	
	
	
	//����� �Է°� ��ǻ�� �� ���ϱ� - �º� ī���� ���
	public void compare() {
		computer = (int)(Math.random()*3)+1; //��ǻ���� ���� ���������� ����
		
		if(user == 1) {
			//����ڰ� ������ ���� ��
			switch(computer) {
				case 2:
					comcount++;
					break;
				case 3:
					usercount++;
					break;
				default:
					break;
			}
		}
		else if(user ==2) {
			//����ڰ� ������ ���� ��
			switch(computer) {
				case 1:
					usercount++;
					break;
				case 3:
					comcount++;
					break;
				default:
					break;
			}
		}
		else {
			//����ڰ� ���� ���� ��
			switch(computer) {
				case 1:
					comcount++;
					break;
				case 2:
					usercount++;
					break;
				default:
					break;
			}
		}
		
	}
	
	
	
	
	
	//��� ���
	public void writeOutput(){
		if(user == 1) {
			//����ڰ� ������ ���� ��
			switch(computer) {
				case 1:
					System.out.println("���\n");
					break;
				case 2:
					System.out.println("��ǻ�� ��\n");
					break;
				case 3:
					System.out.println("��� ��\n");
					break;
				default : 
					break;
			}
		}
		else if(user ==2) {
			//����ڰ� ������ ���� ��
			switch(computer) {
				case 1:
					System.out.println("��� ��\n");
					break;
				case 2 :
					System.out.println("���\n");
					break;
				case 3:
					System.out.println("��ǻ�� ��\n");
					break;
				default : 
					break;
			}
		}
		else {
			//����ڰ� ���� ���� ��
			switch(computer) {
				case 1:
					System.out.println("��ǻ�� ��\n");
					break;
				case 2:
					System.out.println("��� ��\n");
					break;
				case 3:
					System.out.println("���\n");
					break;
				default : 
					break;
			}
		}
	}
}
