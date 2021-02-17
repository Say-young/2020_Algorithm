package hw;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Week5_2_�弼�� {
	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
	
		Dog[] a = new Dog[3];
		a[0] = new Dog();
		a[1] = new Dog();
		a[2] = new Dog();
		
		Cat[] b = new Cat[3];
		b[0] = new Cat();
		b[1] = new Cat();
		b[2] = new Cat();

		//�� �ν��Ͻ��� ������ �ݺ����� �̿��Ͽ� �Է��ϱ�
		
		//3������ ������ Ŭ���� ���� �Է��� �޴� �޼���
		for(int i=0; i<3; i++) {
			System.out.println("<<Dog "+(i+1)+">>");
			System.out.print("Name :");
			a[i].setName(scanner.nextLine()); //String���� �Է¹޾ƾ� ��. ���� set �޼���� ����
			
			while(true) {
				try {
					System.out.print("Age :");
					a[i].setAge(scanner.nextInt()); //int�� �Է¹޾ƾ� ��. ���� set �޼���� ����
					break;
				}
				catch(InputMismatchException e) {
					scanner.nextLine(); // ���� ���� �̰� ������ ���ѷ��� ����
					System.out.println("������ �Է� �����մϴ�.");
				}
			}
			
			while(true) {
				try {
					System.out.print("Weight :");
					a[i].setWeight(scanner.nextDouble()); //double�� �Է¹޾ƾ� ��. ���� set �޼���� ����
					break;
				}
				catch(InputMismatchException e) {
					scanner.nextLine(); // ���� ���� �̰� ������ ���ѷ��� ����
					System.out.println("���ڸ� �Է� �����մϴ�.");
				}
			}
					
			scanner.nextLine(); //���ۿ��� ���� ���ֱ�. �̰� ������ ���� �Է¿� ���� ����
			System.out.print("BoosterShot(y/n) :");
			if(scanner.nextLine().equalsIgnoreCase("y")) //���� �Է��� ���� y���
				a[i].setBoosterShot(true); //������ boolean �����̹Ƿ� true �� ����. ���� set �޼���� ����
			else
				a[i].setBoosterShot(false); //y �̿��� ��� �Է°��̶�� ������ boolean �����̹Ƿ� false �� ����. ���� set �޼���� ����
			System.out.println("");
		}
		
		//3������ ����� Ŭ���� ���� �Է��� �޴� �޼���
		for(int i=0; i<3; i++) {
			System.out.println("<<Cat "+(i+1)+">>");
			System.out.print("Name :");
			b[i].setName(scanner.nextLine()); //String���� �Է¹޾ƾ� ��. ���� set �޼���� ����
			
			while(true) {
				try {
					System.out.print("Age :");
					b[i].setAge(scanner.nextInt()); //int�� �Է¹޾ƾ� ��. ���� set �޼���� ����
					break;
				}
				catch(InputMismatchException e) {
					scanner.nextLine(); // ���� ���� �̰� ������ ���ѷ��� ����
					System.out.println("������ �Է� �����մϴ�.");
				}
			}
			
			while(true) {
				try {
					System.out.print("Weight :");
					b[i].setWeight(scanner.nextDouble()); //double�� �Է¹޾ƾ� ��. ���� set �޼���� ����
					break;
				}
				catch(InputMismatchException e) {
					scanner.nextLine(); // ���� ���� �̰� ������ ���ѷ��� ����
					System.out.println("���ڸ� �Է� �����մϴ�.");
				}
			}
			
			scanner.nextLine(); //���ۿ��� ���� ���ֱ�
			System.out.print("Color: ");
			b[i].setColor(scanner.nextLine()); //String���� �Է¹޾ƾ� ��. ���� set �޼���� ����
			System.out.println("");
		}
		
		
		//�� �ν��Ͻ��� ������ �ݺ��� ������ writeOutput() �޼��带 �̿��� ����ϱ�
		
		System.out.println("\n<<Dog List>>");
		//3������ ������ Ŭ���� ������ ����ϴ� �޼���
		for(int i=0; i<3; i++) {
			System.out.println("Name : "+a[i].getName()); //private �����̹Ƿ� get �޼���� ����
			System.out.println("Age : "+a[i].getAge()); //private �����̹Ƿ� get �޼���� ����
			System.out.println("Weight : "+a[i].getWeight()); //private �����̹Ƿ� get �޼���� ����
			if(a[i].getBoosterShot() == true)
				System.out.println("BoosterShot : O"); // ���� ���ΰ� true�� ��� O ���. private �����̹Ƿ� get �޼���� ����
			else
				System.out.println("BoosterShot : X");// ���� ���ΰ� false�� ��� X ���. private �����̹Ƿ� get �޼���� ����
			a[i].move(); //move �޼��� ���
			System.out.println(""); //���� ����	
		}
		
		System.out.println("\n<<Cat List>>");
		//3������ ����� Ŭ���� ������ ����ϴ� �޼���
		for(int i=0; i<3; i++) {
			System.out.println("Name : "+b[i].getName()); //private �����̹Ƿ� get �޼���� ����
			System.out.println("Age : "+b[i].getAge()); //private �����̹Ƿ� get �޼���� ����
			System.out.println("Weight : "+b[i].getWeight()); //private �����̹Ƿ� get �޼���� ����
			System.out.println("Color : "+b[i].getColor()); //private �����̹Ƿ� get �޼���� ����
			b[i].move(); //move �޼��� ���
			System.out.println(""); //���� ����	
		}
		
		
		
		System.out.println("* Dogs older than 2 years and no boostershot are...");
		for(int i=0; i<3; i++) {
			if(a[i].getAge()>2) //���� ���̰� 2�캸�� ���̰� ���� ���������� ã��
			{
				if(a[i].getBoosterShot()==false) //�������� ���ΰ� false�� �������� ã����
					System.out.print(a[i].getName() + " "); //�ش� ������ �̸� ����ϱ�
			}
		}
		
		System.out.println("\n\n* Black cats weights more than 3kg are...");
		for(int i=0; i<3; i++) {
			if(b[i].getColor().equalsIgnoreCase("black")) //���� ������ black�� ����̸� ã��
			{
				if(b[i].getWeight()>3) //���̰� 3�� �̻��� ����̸� ã����
					System.out.print(b[i].getName() + " "); //�ش� ����� �̸� ����ϱ�
			}
		}
		
	}
}
