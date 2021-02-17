package lab9_2;
import java.io.*;
import java.util.*;

public class Week9_2_�弼�� {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		//Dog Ŭ���� �迭 ����� �� �迭�� object ����
		Dog myDog[] = new Dog[10];
		myDog[0] = new Dog("Merry", 3, 2.5, "Bulldog", false);
		myDog[1] = new Dog("JJong", 5, 5.5, "Mix", false);
		myDog[2] = new Dog("Kong", 4, 3, "Poodle", true);
		myDog[3] = new Dog("Apple", 2, 2.5, "Collie", true);
		myDog[4] = new Dog("Candy", 5, 5.5, "Coca", false);
		myDog[5] = new Dog("Cutie", 7, 2.5, "Chiwawa", true);
		myDog[6] = new Dog("Peace", 3, 2.5, "Huskey", false);
		myDog[7] = new Dog("Lion", 9, 1.5, "Shepard", true);
		myDog[8] = new Dog("Windy", 2, 9, "Jindo", true);
		myDog[9] = new Dog("Sweetie", 1, 2.5, "Maltiz", false);
		
		//����ڰԿ� �ش� ������ �ۼ��� ���� �̸� �Է¹ޱ�
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input File name to write Dog date");
		String fileName = scanner.next();
		
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName)); // �Է¹��� ���Ͽ� ������ �ۼ��� �غ�
			outputStream.writeObject(myDog); //myDog�� ������ object ����� �ѹ��� write
			outputStream.close(); //close�ؾ� ���Ͽ� ������ �ۼ���
		}
		catch(IOException e) { //����� ���� ������ �߻��� ���
			System.out.println("ERROR writing to file "+fileName+"."); //���� �޼��� ���
			System.exit(0); //����
		}
		
		
		Dog[] anotherArray = null; //�о�� ������ ���� Dog�� �迭 ����
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName)); //���ó� objectInputStream�� Ȱ��
			anotherArray = (Dog[])inputStream.readObject(); //(Dog[])�� �ٿ�ĳ���� ����� Object ����� �о�� ������ Dog�� �迭�� ���� ����
			System.out.println("Name\tAge\tWeight\tBreed\t\tBoosterShot\t");
			for(int i=0; i<anotherArray.length; i++) {
				System.out.println(anotherArray[i]); //�ݺ������� ���� �ѹ��� ��� - toString�� �������̵� �� ������ ��µ�
			}
			System.out.println("\nDogs older than 2 years and did not get the boosterShot.");
			for(int i=0; i<anotherArray.length; i++) { //�迭 ���̸�ŭ �ݺ�
				if((anotherArray[i].getAge()>2)&&(anotherArray[i].getBoosterShot()==false)) //���� ���� ���ΰ� X�̰� ���̰� 2�캸�� ���� ��ü�̸�
					System.out.println(anotherArray[i].getName()+"\t\t"+anotherArray[i].getBreed()); //����ض�
			}
			inputStream.close(); //���� �ݱ�
			System.out.println("\nProgram finished.");
		}
		catch(EOFException e) { //������ ���� �����ϸ� �����
			System.out.println("End of File Exception.");
		}
		catch(FileNotFoundException e) { //�о�� ������ ã�� ���� ���
			System.out.println("File not found Exception.");
		}
		catch(IOException e) { //����� ���� ������ �߻����� ���
			System.out.println("IO Exception.");
		}
		catch(Exception e) { //�� �̿ܿ� ������ �߻����� ��. �� catch�� �ش��ϴ� Exception�� ���԰��谡 ���� ũ�� ������ ���� �ϴܿ� ����� ������ ��ü���� ������ �Ÿ� �� �ִ�.
			System.out.println("Exception.");
		}
		
		
	}

}
