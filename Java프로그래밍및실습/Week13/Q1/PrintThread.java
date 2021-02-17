package asm13_1;

public class PrintThread extends Thread{
	SharedArea sharedarea; //값을 넘겨받아야 하므로 sharedarea instance 생성
	
	//start()하면 실행되는 메서드
	public void run() {
		//만약 sharedarea의 isReady가 false일 경우
		if(sharedarea.isReady!=true) {
			try {
				synchronized(sharedarea) {
					sharedarea.wait(); //다른 thread로부터 신호를 기다림
				}
			}catch(InterruptedException e) {
				System.out.println(e.getMessage()); //interruptedException에 대한 예외처리 필수
			}
		}
		System.out.printf("Front Ratio: %.2f",sharedarea.ratio); //sharedarea의 ratio값을 출력
		System.out.println("%");
	}
}