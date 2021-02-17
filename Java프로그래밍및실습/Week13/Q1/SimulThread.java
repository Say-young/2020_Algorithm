package asm13_1;
import java.util.*;

public class SimulThread extends Thread{
	SharedArea sharedarea; //값을 넘겨줘야 하므로 sharedarea instance 생성
	
	//start()하면 실행되는 메서드
	public void run() {
		System.out.println("Input the number of coin toss:");
		Scanner scanner = new Scanner(System.in); //사용자에게 N값 입력받기
		int total = scanner.nextInt();
		
		int count = 0; //동전의 앞면이 나온 횟수를 저장할 변수 선언
		for(int i = 0; i<total ; i++) { //사용자가 입력한 값만큼 동전 던지기(반복)
			int rand = (int)(Math.random()*2); //던진 결과는 random함(0 또는 1만 나옴)
			if(rand%2==0) //0을 앞면이라고 정했음
				count++; //0이 나올 경우 count+1
		}
		sharedarea.ratio = (double)count/total*100; //반복문이 종료된 후에 ratio를 계산하여 sharedarea의 ratio에 값을 넘겨줌
		sharedarea.isReady = true; //sharedarea의 isReady를 true로 바꿔줌
		
		synchronized(sharedarea) {
			sharedarea.notify(); //다른 thread에 신호 전달
		}
	}
}
