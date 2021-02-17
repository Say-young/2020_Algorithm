package asm13_2;

public class MyThread extends Thread{
	
	SharedArea sharedarea; //정보를 주고 받아야 하므로 sharedarea instance 선언
	boolean stop;
	public void setStop(boolean stop) {
		this.stop = stop; //파라미터로 받은 값으로 stop의 t/f 상태 결정
	}

	//랜덤으로 출력할 문자열 배열 생성
	String names[] = {"cake", "java", "love","fine", "like", "lion", "count", "blue", "list", "well", "clock", "more", "late", "final", "thread"};
	int rand; //랜덤한 수를 입력받을 변수 선언
	
	//start()하면 실행되는 메서드
	public void run() {
		//20초 동안 랜덤 단어를 출력해야 하므로 -> 20번 단어를 랜덤하게 출력하되 그 텀을 1초로 하는 것으로 설계했음
		for(int i = 20; i>0; i--) { //20번 반복
			if(stop == true) { //만약 stop이 true가 되면
				System.out.println("성공!"); //성공 메세지 출력 후
				System.out.println("Time is stopped.");
				break; //for문 종료
			}
			
			rand = (int)(Math.random()*15); //0~14 랜덤 수
			sharedarea.name = names[rand]; //rand번째 names 원소의 문자열을 sharedarea의 name에 넘겨주기
			System.out.println(sharedarea.name); //해당 문자열 출력하기
			
			try {
				sleep(1000); //문자열 랜덤 출력 사이에 1초간 텀 주기
			}catch(InterruptedException e){
				System.out.println(e.getMessage()); //interruptedException 핸들링 필수
			}
		}

		//만약 20초가 지나고 문자열 출력이 끝났는데도 stop이 false이면
		if(stop != true) {
			System.out.println("실패"); //실패메세지 출력 후
			System.exit(0); //프로그램 종료
		}
	}
}