package asm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Week12_1_장세영 extends JFrame{

	private JButton button; //마우스어댑터에서 접근 가능하도록 버튼을 생성자 밖에서 선언
	
	public Week12_1_장세영(){
		setTitle("나 잡아봐~라! - 장세영"); //frame title 설정
		setSize(300,300); //frame 사이즈 설정
		setResizable(false); //frame 사이즈 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x누르면 프로그램 종료되도록
		JPanel panel = new JPanel(); //패널 생성
		button = new JButton("Click!"); //버튼 생성
		button.addMouseListener(new myMouseEvent()); //마우스 이벤트 리스너 버튼에 추가
		panel.add(button); //패널에 버튼 추가
		add(panel, BorderLayout.CENTER); //컨테이너 중앙에 패널 추가
		setVisible(true); //창이 보이도록
	}
	
	//마우스 어댑터(필요한 메서드만 구현 가능)
	class myMouseEvent extends MouseAdapter{
		
		//마우스가 button의 범위 안에 들어갔을 경우
		public void mouseEntered(MouseEvent e) {
			button.setLocation((int)(Math.random()*200),(int)(Math.random()*200)); //버튼 위치 랜덤으로 바꿈. 창 밖으로 나가지 않도록 200을 최대로 잡음.
			int x = e.getX(); //버튼의 x좌표 받아서
			int y = e.getY();//버튼의 y좌표 받아서
			System.out.println("x = "+x+", y = "+y); //콘솔창에 버튼의 위치 출력
		}
		
		//마우스가 button을 클릭했을 경우
		public void mouseClicked(MouseEvent e) {
			System.out.println("흑,,, 잡혔다ㅠㅠ"); //콘솔창에 잡혔다는 메세지 출력
			mouseEntered(e);//클릭한 후 바로 버튼이 도망갈 수 있도록
		}
	}
	
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		new Week12_1_장세영(); //창 생성
	}

}
