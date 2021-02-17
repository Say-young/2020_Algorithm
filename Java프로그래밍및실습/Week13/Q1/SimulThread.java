package asm13_1;
import java.util.*;

public class SimulThread extends Thread{
	SharedArea sharedarea; //���� �Ѱ���� �ϹǷ� sharedarea instance ����
	
	//start()�ϸ� ����Ǵ� �޼���
	public void run() {
		System.out.println("Input the number of coin toss:");
		Scanner scanner = new Scanner(System.in); //����ڿ��� N�� �Է¹ޱ�
		int total = scanner.nextInt();
		
		int count = 0; //������ �ո��� ���� Ƚ���� ������ ���� ����
		for(int i = 0; i<total ; i++) { //����ڰ� �Է��� ����ŭ ���� ������(�ݺ�)
			int rand = (int)(Math.random()*2); //���� ����� random��(0 �Ǵ� 1�� ����)
			if(rand%2==0) //0�� �ո��̶�� ������
				count++; //0�� ���� ��� count+1
		}
		sharedarea.ratio = (double)count/total*100; //�ݺ����� ����� �Ŀ� ratio�� ����Ͽ� sharedarea�� ratio�� ���� �Ѱ���
		sharedarea.isReady = true; //sharedarea�� isReady�� true�� �ٲ���
		
		synchronized(sharedarea) {
			sharedarea.notify(); //�ٸ� thread�� ��ȣ ����
		}
	}
}
