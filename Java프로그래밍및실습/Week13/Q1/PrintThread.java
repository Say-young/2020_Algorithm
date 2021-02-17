package asm13_1;

public class PrintThread extends Thread{
	SharedArea sharedarea; //���� �Ѱܹ޾ƾ� �ϹǷ� sharedarea instance ����
	
	//start()�ϸ� ����Ǵ� �޼���
	public void run() {
		//���� sharedarea�� isReady�� false�� ���
		if(sharedarea.isReady!=true) {
			try {
				synchronized(sharedarea) {
					sharedarea.wait(); //�ٸ� thread�κ��� ��ȣ�� ��ٸ�
				}
			}catch(InterruptedException e) {
				System.out.println(e.getMessage()); //interruptedException�� ���� ����ó�� �ʼ�
			}
		}
		System.out.printf("Front Ratio: %.2f",sharedarea.ratio); //sharedarea�� ratio���� ���
		System.out.println("%");
	}
}