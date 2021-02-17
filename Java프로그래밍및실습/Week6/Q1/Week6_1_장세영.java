package lab;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Week6_1_�弼�� {

	public static void main(String[] args) {

		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");

		Scanner scanner = new Scanner(System.in);

		int choice = 10;
		
		//������ �ν��Ͻ� ����
		Buyer Buyer1 = new Buyer();
		//���� ������ ��ǰ �ν��Ͻ� ����. �θ� Ŭ������ Product �迭�� ���� �� �ȿ� �ϳ��� �ִ´�. java�� ������ �̿�.
		Product[] pd = new Product[10];
		pd[0] = new Tv();
		pd[1] = new Computer();
		pd[2] = new Video();
		pd[3] = new Audio();
		pd[4] = new NoteBook();
		
		//������� ���� ���´�.
		while(true) {
			try {
				System.out.println("How much money do you have?");
				Buyer1.money=scanner.nextInt();
				break;
			}
			//���ڰ� �Էµ��� ���� ��� �ٽ� ���
			catch(InputMismatchException e) {
				scanner.nextLine(); //���ۺ���
				System.out.println("���ڸ� �Է� �����մϴ�. �ٽ� �Է����ּ���.");//�ȳ��޼���
			}
		}
		
		//����ڰ� ������ ����� ���´�.
		do {
			try{
				System.out.println("What do you want to buy? Input 0 to quit.");
				//���� ������ ��ǰ ����� �����ش�.
				for(int i=0; i<5; i++) {
					System.out.print((i+1)+". "+pd[i]+"("+pd[i].price+")\t");
				}
				System.out.println("");
				choice=scanner.nextInt();
				switch(choice) {
					case 0: //0�� �Է¹����� ���� ����� ���
						Buyer1.summary();
						break;
					//0�̿��� ���ڸ� �Է¹����� �ش� ��ȣ�� �ش��ϴ� ��ǰ ���� �޼����� buy �޼��� �۵�
					case 1:
						Buyer1.buy(pd[0]);
						break;
					case 2:
						Buyer1.buy(pd[1]);
						break;
					case 3:
						Buyer1.buy(pd[2]);
						break;
					case 4:
						Buyer1.buy(pd[3]);
						break;
					case 5:
						Buyer1.buy(pd[4]);
						break;
					//0~5 �̿��� ���� �Է½� ��� ���� �޼��� ���
					default :
						System.out.println("No such item.");
				}
			}//���ڰ� �Էµ��� ���� ��� �ٽ� ���
			catch(InputMismatchException e) {
				scanner.nextLine(); //���ۺ���
				System.out.println("���ڸ� �Է� �����մϴ�. �ٽ� �Է����ּ���.");//�ȳ��޼���
			}
		}while(choice!=0); //����ڰ� 0�� �Է����� �ʴ� �� ��� �ݺ�
		
		
	}
}
