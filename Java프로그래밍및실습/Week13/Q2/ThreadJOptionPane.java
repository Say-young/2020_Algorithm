package asm13_2;
import javax.swing.JOptionPane;

public class ThreadJOptionPane {

	public static void main(String[] args){
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		//thread�� sharedarea �ν��Ͻ� ����
		MyThread thread = new MyThread();
		SharedArea SH = new SharedArea();
		
		//thread�� sharedarea�� SH�� ������ ����
		thread.sharedarea = SH;
		
		//thread ����
		thread.start();

		while(true) {
			String st = JOptionPane.showInputDialog("Enter a string"); //�ȳ�â ����
			System.out.println("<"+st+">�� �Է��ϼ̽��ϴ�."); //���� �Է��ϸ� �ش� �޼����� �ܼ�â�� ����
			if(st.equals(SH.name)) //���� �Է��� ���ڿ��� ���� ��µ� ������ ���ڿ��� ���ٸ�
				break; //while�� Ż��
		}
		thread.setStop(true); //thread�� stop�� true�� �ٲٱ�
	}
}
