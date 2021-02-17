package lab;

import java.util.*;

public class Week10_1_�弼�� {

	public static void main(String[] args) {
		

		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in); //�Է¹��� scanner
		ArrayList<Student> student = new ArrayList<Student>(); //student ��ü ���� arraylist ����
		//����� ���� ����
		String name = null;
		String ID;
		int age, num, location;
		num=0;
		
		
		System.out.println("Input Student Name, ID, and age. 0 for to quit.");
		while(true) { //�ݺ���
			name =scanner.next(); //name �Է¹ޱ�. ����� �����ϹǷ� next()�� ����
			if(name.equals("0")==false) { //���� 0�� �ƴ� �ٸ� ���� �Է¹޴´ٸ�
				ID=scanner.next(); //ID ����
				age=scanner.nextInt(); //age ����
				student.add(new Student(name, ID,age)); //�Է¹��� ������ student ��ü ���� �� �迭�� �߰�
			}
			else
				break; //0�� �Է¹����� �ݺ��� Ż��
		}
		printResult(student); //����Ʈ ���� ��� �޼��� ȣ��
		
		
	while(num !=4) { //�Է°��� 4�� �ƴϸ� ��� �ݺ�
		System.out.println("Choose the operation you want.");
		System.out.println("1.add information  2.delete information  3. show list  4. Finish program");
		num = scanner.nextInt(); //�Է¹ޱ�
		switch(num) {
			case 1:
				addStudent(student); //1�� �Է¹޾��� ��� �߰� �޼��� ȣ��
				break;
			case 2:
				deleteStudent(student); //2�� �Է¹޾��� ��� ���� �޼��� ȣ��
				break;
			case 3:
				printResult(student); //3�� �Է¹޾��� ��� ����Ʈ ���� ��� �޼��� ȣ��
				break;
			case 4:
				break; //4�� �Է¹޾��� ��� Ż��
			default : 
				System.out.println("Wrong input"); //1234 �̿��� ���� �Է¹޾��� ��� ���� �޼��� ���
				System.out.println("");
				break;
		}
	}
}
	
	//����Ʈ ���� ��� �޼��� - �Ķ���ʹ� student list
	public static void printResult(List<Student> student) {
		System.out.println("NUMBER\tNAME\tID\tAGE");
		//�迭 size��ŭ �ݺ��ϸ� �迭 ���� ���
		for (int i = 0; i<student.size(); i++) {
			System.out.println((i+1)+"\t"+student.get(i).name+"\t"+student.get(i).ID+"\t"+student.get(i).age);
		}
		System.out.println("");
	}
	
	//���� �޼��� - �Ķ���ʹ� student list
	public static void deleteStudent(List<Student> Stu) {
		System.out.println("Input Student Number to delete.");
		//scanner �ٽ� ����. ���� ���̹Ƿ� ���ο��� ������ scanner�� ��� �Ұ�
		Scanner scanner =new Scanner(System.in);
		int location=scanner.nextInt(); //�Է¹��� ���� location���� ���
		Stu.remove(location-1); //��µ� ����Ʈ�� 1������ �����ϹǷ� n��° ���Ҹ� �����ϱ� ���ؼ��� n-1��° ���Ҹ� remove �ؾ���
		printResult(Stu); //��� �޼��� ȣ��
	}
	
	//�߰� �޼��� - �Ķ���ʹ� student list
	public static void addStudent(ArrayList<Student> Stu) {
		System.out.println("Input new Student Name, ID, age, and the location.");
		//scanner �ٽ� ����. ���� ���̹Ƿ� ���ο��� ������ scanner�� ��� �Ұ�
		Scanner scanner =new Scanner(System.in);
		//student �ν��Ͻ� ������ �ʿ��� ���� ��� �Է¹޾� ����
		String name =scanner.next();
		String ID=scanner.next();
		int age=scanner.nextInt();
		int location=scanner.nextInt();//�Է¹��� ���� location���� ���
		Stu.add((location-1), new Student(name, ID,age)); //��µ� ����Ʈ�� 1������ �����ϹǷ� n��° ���Ҹ� �߰��ϱ� ���ؼ��� n-1��° ���Ҹ� add �ؾ���
		printResult(Stu); //��� �޼��� ȣ��
	}

}
