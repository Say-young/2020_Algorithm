package lab9_1;

import java.io.*;
import java.util.*;

public class Week9_1_�弼�� {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");

		//����ڿ��� �Է¹ޱ�
		Scanner scanner = new Scanner(System.in);
		System.out.println("File name for input:");
		String fileName1 = scanner.next(); //fileName1�� �Է�
		System.out.println("File name for output:");
		String fileName2 = scanner.next(); //fileName2�� �Է�
		
		//inputStream�� outputStream�� ObjectInputStream���� ����
		ObjectInputStream inputStream = null;
		ObjectOutputStream outputStream = null;
		
		System.out.println("The numbers in File, "+fileName1);
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName1)); //fileName1�� ����
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName2)); //fileName2�� ����
			try {
				while(true) { //������ ������ �������� ������
					int anInteger = inputStream.readInt(); //int���·� fileName1�� ������ �о��
					System.out.println(anInteger); //�о�� ������ ����ϰ�
					outputStream.writeInt(anInteger*2); //�ش� ���� 2���� fileName2�� �ۼ�
				}
			}
			catch(EOFException e) { //fileName1�� ���� ������ ��� ����
				System.out.println("End of reading from file, "+fileName1); //�ȳ� �޼��� ���
				System.out.println(fileName2 + " is generated.\n");
			}
			inputStream.close(); //�о���Ⱑ ���� �� ������ �ݾƾ� ��
			outputStream.close(); //���Ⱑ ���� �� ������ �ݾƾ� ������ �ۼ���
		}
		catch(FileNotFoundException e) { //���� �о�� ������ ���� ���
			System.out.println("Cannot find file "+fileName1); //���� �޼��� ���
		}
		catch(IOException e) { //����� ���� ������ �߻��� ���
			System.out.println("Problem with input from file "+ fileName1); //���� �޽��� ���
		}
		
		System.out.println("The numbers in new File, "+fileName2);
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName2)); //�ۼ��� fileName2�� �ٽ� ������� ���� inputStream ���
			try {
				while(true) { //������ ������ �������� ������
					int anInteger = inputStream.readInt(); // int ���·� ���� �о����
					System.out.println(anInteger); //���� ���
				}
			}
			catch(EOFException e) { //������ ���� �������� ��� ����
				System.out.println("End of reading from 2nd file, "+fileName2); //�ȳ� �޼��� ���
			}
			inputStream.close(); //�о���Ⱑ ���� �� ���� �ݱ�
		}
		catch(FileNotFoundException e) { //�о�� ������ ã�� ������ ���
			System.out.println("Cannot find 2nd file "+fileName2); //���� �޼��� ���
		}
		catch(IOException e) { //����� ���� ������ �߻����� ���
			System.out.println("Problem with input from 2nd file "+ fileName2); //���� �޼��� ���
		}
	}

}
