import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_Server_�弼�� {
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		
		ServerSocket serverSocket = null; //server�̹Ƿ� serversocket ����
		Socket socket = null; //socket����
		int sum=0; double avg; //����� ���� ���� �� �ʱ�ȭ
		
		try {
			serverSocket = new ServerSocket(8884); //������ ��Ʈ��ȣ
			socket = serverSocket.accept(); //client�� request ����ϱ�
			
			Scanner in = new Scanner(socket.getInputStream()); //client���� �޾ƿ� �Է�
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //client�� ���
			
			//1 �ޱ�
			String strIn = in.nextLine(); //Hello?
			System.out.println(strIn);
			
			//2 ����
			out.println("How many numbers?");
			out.flush();//flush�ؾ� buffer�� ������ server�� ��µȴ�

			//3 �ޱ�
			strIn = in.nextLine();
			System.out.println(strIn);
			int num = Integer.parseInt(strIn);//string���� �޾ƿ����Ƿ� ����ȯ�ؼ� ����
			
			
			//4����
			out.println("Input "+num+" numbers");
			out.flush();
			
			//5�ޱ�
			for(int i=0; i<num; i++) {
				int num2 = Integer.parseInt(in.nextLine()); //���ڵ� ���ʷ� ����ȯ�ؼ� �޾ƿ���
				sum+=num2; //sum�� �������� ���ϱ�
			}
			avg=(double)sum/num; //sum �� ���� �� avg ���ϱ�
			
			//6����
			out.println("Sum: "+sum);
			out.flush(); //�� ���� �� ������ flush �ؾ� �ٷιٷ� ���δ�
			
			//7����
			out.println("Avg: "+avg);
			out.flush();
			
			//8�ޱ�
			strIn = in.nextLine(); //service finished.
			System.out.println(strIn);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());//�ͼ��� �ڵ鸵 �ʼ�
		}finally {
			try {
				socket.close(); //���� �ݱ�
			}catch(Exception e) {
				System.out.println(e.getMessage());//�ͼ��� �ڵ鸵 �ʼ�
			}
			try {
				serverSocket.close();//�������ϴݱ�
			}catch(Exception e) {
				System.out.println(e.getMessage());//�ͼ��� �ڵ鸵 �ʼ�
			}
		}
	}
}
