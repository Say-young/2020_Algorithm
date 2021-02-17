package asm13_2;

public class MyThread extends Thread{
	
	SharedArea sharedarea; //������ �ְ� �޾ƾ� �ϹǷ� sharedarea instance ����
	boolean stop;
	public void setStop(boolean stop) {
		this.stop = stop; //�Ķ���ͷ� ���� ������ stop�� t/f ���� ����
	}

	//�������� ����� ���ڿ� �迭 ����
	String names[] = {"cake", "java", "love","fine", "like", "lion", "count", "blue", "list", "well", "clock", "more", "late", "final", "thread"};
	int rand; //������ ���� �Է¹��� ���� ����
	
	//start()�ϸ� ����Ǵ� �޼���
	public void run() {
		//20�� ���� ���� �ܾ ����ؾ� �ϹǷ� -> 20�� �ܾ �����ϰ� ����ϵ� �� ���� 1�ʷ� �ϴ� ������ ��������
		for(int i = 20; i>0; i--) { //20�� �ݺ�
			if(stop == true) { //���� stop�� true�� �Ǹ�
				System.out.println("����!"); //���� �޼��� ��� ��
				System.out.println("Time is stopped.");
				break; //for�� ����
			}
			
			rand = (int)(Math.random()*15); //0~14 ���� ��
			sharedarea.name = names[rand]; //rand��° names ������ ���ڿ��� sharedarea�� name�� �Ѱ��ֱ�
			System.out.println(sharedarea.name); //�ش� ���ڿ� ����ϱ�
			
			try {
				sleep(1000); //���ڿ� ���� ��� ���̿� 1�ʰ� �� �ֱ�
			}catch(InterruptedException e){
				System.out.println(e.getMessage()); //interruptedException �ڵ鸵 �ʼ�
			}
		}

		//���� 20�ʰ� ������ ���ڿ� ����� �����µ��� stop�� false�̸�
		if(stop != true) {
			System.out.println("����"); //���и޼��� ��� ��
			System.exit(0); //���α׷� ����
		}
	}
}