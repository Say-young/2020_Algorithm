package asm13_2;
import javax.swing.JOptionPane;

public class ThreadJOptionPane {

	public static void main(String[] args){
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		//thread와 sharedarea 인스턴스 생성
		MyThread thread = new MyThread();
		SharedArea SH = new SharedArea();
		
		//thread의 sharedarea를 SH와 같도록 연결
		thread.sharedarea = SH;
		
		//thread 구동
		thread.start();

		while(true) {
			String st = JOptionPane.showInputDialog("Enter a string"); //안내창 띄우기
			System.out.println("<"+st+">을 입력하셨습니다."); //값을 입력하면 해당 메세지를 콘솔창에 띄우기
			if(st.equals(SH.name)) //만약 입력한 문자열과 현재 출력된 랜덤한 문자열이 같다면
				break; //while문 탈출
		}
		thread.setStop(true); //thread의 stop을 true로 바꾸기
	}
}
