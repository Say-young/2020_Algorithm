package hw2;
import java.util.*;
import java.io.*;


public class HW2_1_�弼�� {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);//���ϸ��� �Է¹ޱ� ���� ��ĳ��
		System.out.println("Input the filename to read."); //������� ���ϸ� �Է¹ޱ�
		String inputfile = scanner.nextLine();
		System.out.println("Input the filename to write.");
		String outputfile = scanner.nextLine();
		
		//����½�Ʈ�� �����صα�(try�� �ۿ��� close()�ϱ� ���� ���� ����
		Scanner inputStream = null;
		PrintWriter outputStream=null;
		
		try {
			//������ ���� ���ϸ��� ���ڷ� �־� ����� ��Ʈ�� ����
			inputStream = new Scanner(new File(inputfile));
			outputStream = new PrintWriter(outputfile);
		
			//�Է¹��� ���Ͽ� �о�� ������ ����������
			while(inputStream.hasNextLine()) {
				String str = inputStream.nextLine(); //text�� �� ������ �о��
				StringTokenizer tk = new StringTokenizer(str, " ,\n"); //�и��� 3�� ����
				while(tk.hasMoreTokens()) { //���� ��ū�� ����������
					String next = tk.nextToken(); //������ �޾ƿ� ��ū�� string ������ ����
					if(next.length()>4) { //���̰� 4���� ū �ܾ��̸�
						outputStream.println(next); //������Ͽ� ����
					}
				}
			}
			System.out.println(outputfile+" is generated."); //�� ����� ���Ŀ� ��������� �����Ǿ��ٴ� �޼��� ���
		}
		//����� ��Ʈ���� ������ exception handling
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		//����� ��Ʈ�� �ݱ�
		outputStream.close();
		inputStream.close();
	}

}
