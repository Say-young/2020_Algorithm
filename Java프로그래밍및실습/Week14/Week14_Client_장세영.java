import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_Client_�弼�� {
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Socket socket = null; //socket ����
		
		try {
			socket = new Socket("192.168.43.189", 8884);//���� �����ǿ� ��Ʈ ���缭	

			Scanner scanner = new Scanner(System.in); //ǥ���Է�
			Scanner in = new Scanner(socket.getInputStream()); //server���� �޾ƿ� �Է�
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //server�� ���
			
			//1 ����
			out.println("Hello?");
			out.flush(); //flush�ؾ� buffer�� ������ server�� ��µȴ�
			
			//2 �ޱ�
			String strIn = in.nextLine(); //How many numbers?
			System.out.println(strIn);

			//3 ����
			strIn = scanner.nextLine();
			out.println(strIn); //n
			out.flush();
			int num=Integer.parseInt(strIn); //string���� �޾ƿ����Ƿ� ����ȯ�ؼ� ����

			//4 �ޱ�
			strIn = in.nextLine(); //input num numbers
			System.out.println(strIn);
				
			//5����
			for(int i= 0; i<num; i++) {
				strIn = scanner.nextLine();
				out.println(strIn);
				out.flush();
			}
			
			//6�ޱ�
			strIn = in.nextLine(); //sum
			System.out.println(strIn);
			
			//7�ޱ�
			strIn = in.nextLine(); //avt
			System.out.println(strIn);
			
			//8����
			out.println("Service finished.");
			out.flush();
			
		}catch(Exception e) {
			System.out.println(e.getMessage()); //�ͼ��� �ڵ鸵 �ʼ�
		}finally {
			try {
				socket.close();//���� �ݱ�
			}catch(Exception e) {
				System.out.println(e.getMessage());//�ͼ��� �ڵ鸵 �ʼ�
			}
		}
	}
}







