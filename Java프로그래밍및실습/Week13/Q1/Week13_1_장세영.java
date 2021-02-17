package asm13_1;

public class Week13_1_장세영 {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		//각각의 thread와 sharedarea 인스턴스 생성
		PrintThread thread1 = new PrintThread();
		SimulThread thread2 = new SimulThread();
		SharedArea SH = new SharedArea();
		
		//두 thread의 sharedarea가 같도록 연결(정보를 주고받아야함)
		thread1.sharedarea = SH;
		thread2.sharedarea = SH;
		
		//thread 구동
		thread1.start();
		thread2.start();
	}
}
