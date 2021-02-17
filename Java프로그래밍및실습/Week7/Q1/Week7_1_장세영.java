package myPackage1;
import java.util.*;

public class Week7_1_�弼�� {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Pet[] pet = new Pet[10];
		
		Scanner scanner = new Scanner(System.in);
		int num1=0, num2=0, i=0, age=0;
		String name;
		
		//3.Exit�� ������ ������ ���� �ݺ�
		while(num1!=3) {
			try {
				System.out.println("���ϴ� �۾��� �����Դϱ�?"); //����ڰ� ���ϴ� �۾� ����
				System.out.println("1. New input\t2. Output\t3. Exit");
				num1 = scanner.nextInt(); //���� �Է¹ޱ�
				if(num1>3 || num1<1) //���� ���� ���ڸ� �Է¹��� ���
					throw new Exception("1~4 ������ ���ڸ� �Է��ϼ���."); //�ٽ� �Է��϶�� �޼��� ����
				while(true) { //�� ��° ���� �ݺ�
					try{				
						switch(num1) {
							case 1: //1.New input�� ������ ���
									System.out.println("���� �����Դϱ�?"); //�� �����
									System.out.println("1. Dog\t2. Cat\t3. Snake\t4. Bird");
									num2 = scanner.nextInt(); //�亯 �ޱ�
									if(num2>4 || num2<1) //���� ���� ���ڸ� �Է¹��� ���
										throw new Exception("1~4 ������ ���ڸ� �Է��ϼ���."); //�ٽ� �Է��϶�� �޼��� ����
									
									System.out.printf("Name:");//�̸��Է¹ޱ�
									scanner.nextLine();//������ ���� ���ֱ�
									name = scanner.nextLine();//String�̹Ƿ� nextLine���� �ޱ�
									
									while(true) { //age ���� �ݺ�
									try {
										System.out.printf("Age:"); //���� �����
										age = scanner.nextInt(); //���� �Է¹ޱ�
										switch(num2) {
										case 1:
											pet[i] = new Dog("Dog", name, age);//Dog �ν��Ͻ� ��ü ����
											i++;//���ο� ��ü�� ���� ������ ��ü�� ������ +1���ش�.
											break;
										case 2:
											pet[i] = new Cat("Cat", name, age);//Cat �ν��Ͻ� ��ü ����
											i++;//���ο� ��ü�� ���� ������ ��ü�� ������ +1���ش�.
											break;
										case 3:
											pet[i] = new Snake("Snake", name, age);//Snake �ν��Ͻ� ��ü ����
											i++;//���ο� ��ü�� ���� ������ ��ü�� ������ +1���ش�.
											break;
										case 4:
											pet[i] = new Bird("Bird", name, age);//Bird �ν��Ͻ� ��ü ����
											i++;//���ο� ��ü�� ���� ������ ��ü�� ������ +1���ش�.
											break;
										}
										System.out.print("");
										break;//�ùٸ� �Է� �޾��� ��� age �ݺ��� ����
									}catch(InputMismatchException e) {
										System.out.println("���ڸ� �Է��ϼ���."); //���� age���� ���ڰ� �ƴ� �ٸ� ���� �Է����� ���
										scanner.nextLine(); //���۸� ����ְ� �ٽ� ���´�.
									}
								}
								break;
							case 2: //��� ��� �κ�
								System.out.println("\nSpecies\tName\tAge\tMovement");
								for(int j=0; j<i; j++) {
									System.out.printf(pet[j].species+"\t"+pet[j].name+"\t"+pet[j].age+"\t"); //�ݺ������� �������鼭 ��� ��ü�� ������ ������ش�
									pet[j].move();//�������̵� �ߴ� �� Ŭ������ move �޼��� ���
								}
								break;
						}
						System.out.println("");
						break;//�ùٸ� �Է��� �޾��� ��� 2�� �ݺ��� ����
					}catch(InputMismatchException e) {
						System.out.println("���ڸ� �Է��ϼ���.");//���� 2�� �������� ���ڰ� �ƴ� �ٸ� ���� �Է����� ���
						scanner.nextLine();//���۸� ����ְ� �ٽ� ���´�.
					}catch(Exception e) {
						System.out.println(e.getMessage()); //���� ���� ���� �Է¹޾��� ��� �ȳ� �޼����� ���.
					}		
			}
		}catch(InputMismatchException e) {
			System.out.println("���ڸ� �Է��ϼ���.");//���� 1�� �������� ���ڰ� �ƴ� �ٸ� ���� �Է����� ���
			scanner.nextLine();//���۸� ����ְ� �ٽ� ���´�.
		}catch(Exception e) {
			System.out.println(e.getMessage());//���� ���� ���� �Է¹޾��� ��� �ȳ� �޼����� ���.
		}
	}	
	System.out.println("����");
	}
}
