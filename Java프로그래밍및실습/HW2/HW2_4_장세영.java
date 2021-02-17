package hw2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HW2_4_장세영 extends JFrame{
	
	//필요한 요소들 미리 선언(아래에서 다른 함수나 innerclass에서 쓰이는 경우도 있으므로 생성자 밖에 선언)
	JLabel label1, label2, label3, label4;
	JTextField text1, text2, text3;
	JButton button;
	mypaint panel1; JPanel panel2;
	int kor=0, eng=0, math=0, judge;
	
	//생성자
	HW2_4_장세영(){
		Toolkit tk = getToolkit(); //getToolkit()메서드는 Component에 정의되어 있음
		Dimension d = tk.getScreenSize(); //스크린 사이즈 받아오기
		int screenWidth = d.width; //스크린 가로 길이 받아오기
		int	screenHeight = d.height; //스크린 세로 길이 받아오기
		setSize(500,390); //띄울 창의 너비와 높이 설정
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2); //창이 스크린 한가운데 뜨도록 위치 설정
		setTitle("Score Graph");//타이틀설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);//X 누르면 프로그램 종료되도록
		
		panel1 = new mypaint(); //panel을 extends한 innerclass의 instance 선언
		panel2 = new JPanel();
		
		//필요한 라벨과 텍스트필드 만들기
		label1 = new JLabel("Kor");
		text1 = new JTextField(5);
		label2 = new JLabel("Eng");
		text2 = new JTextField(5);
		label3 = new JLabel("Math");
		text3 = new JTextField(5);		
		button = new JButton("Show Graph");
		button.addActionListener(panel1); //버튼에 actionlistener 붙이기. panel1에 actionlistener implements 되어 있음
		
		//요소들을 패널에 붙이고
		panel2.add(label1);
		panel2.add(text1);
		panel2.add(label2);
		panel2.add(text2);
		panel2.add(label3);
		panel2.add(text3);
		panel2.add(button);
		add(panel1, BorderLayout.CENTER); //그림은 프레임 센터에
		add(panel2, BorderLayout.SOUTH); //나머지 요소들은 프레임 아래에 붙임
		setVisible(true); //프레임 보이게 하기
	}
	
	//innerclass로 선언함
	private class mypaint extends Panel implements ActionListener{
		public void paint(Graphics g) {	
			//하얀 배경 그림
			g.setColor(Color.white);
			g.fillRect(0, 0, 500, 390);
			
			//필요한 선 그림
			g.setColor(Color.black);
			g.drawLine(110, 60, 400, 60);
			g.drawLine(110, 80, 400, 80);
			g.drawLine(110, 100, 400, 100);
			g.drawLine(110, 120, 400, 120);
			g.drawLine(110, 140, 400, 140);
			g.drawLine(110, 160, 400, 160);
			g.drawLine(110, 180, 400, 180);
			g.drawLine(110, 200, 400, 200);
			g.drawLine(110, 220, 400, 220);
			g.drawLine(110, 240, 400, 240);
			g.drawLine(110, 260, 400, 260);
			g.drawLine(110, 50, 110, 260);
			
			//좌측 점수 그림
			g.drawString("100", 85, 65);
			g.drawString("90", 90, 85);
			g.drawString("80", 90, 105);
			g.drawString("70", 90, 125);
			g.drawString("60", 90, 145);
			g.drawString("50", 90, 165);
			g.drawString("40", 90, 185);
			g.drawString("30", 90, 205);
			g.drawString("20", 90, 225);
			g.drawString("10", 90, 245);
			
			//아래 과목 이름 그림
			g.drawString("KOR", 150, 280);
			g.drawString("ENG", 250, 280);
			g.drawString("MATH",345, 280);
			
			switch(judge) {
				case 0://입력받은 점수에 따라 그래프를 그림
					g.setColor(Color.red);
					g.fillRect(155, 260-kor*2, 10, kor*2); //끝이 260이어야하기 때문에 시작점 적절히 조절
					g.fillRect(255, 260-eng*2, 10, eng*2);
					g.fillRect(355, 260-math*2, 10, math*2);
					break;
				case 1://잘못된 입력을 받을 경우 출력할 메세지
					g.setColor(Color.black);
					g.drawString("Wrong Input", 220, 40);
					break;
			}
		}
		
		//actionlistener 메서드 오버라이드
		public void actionPerformed(ActionEvent e) {
			try {
				//받은 값은 string이므로 int로 변형해서 대입
				kor = Integer.parseInt(text1.getText());
				eng = Integer.parseInt(text2.getText());
				math = Integer.parseInt(text3.getText());

				//만약 입력받은 정수가 범위를 벗어난다면
				if(kor<0||kor>100||eng<0||eng>100||eng<0||eng>100){
					judge = 1;//오류 메세지 출력하고
					kor = eng = math = 0; //그래프 출력하지 말기
					repaint(); //그림 그리기
				}else { //정상적인 입력을 받았다면
					judge = 0;//오류 메세지 출력 안 하고
					repaint(); //그림 그리기
				}
			}catch(NumberFormatException a) { //정수로 변환할 수 없는 형태의 입력을 받았다면
				judge = 1; //오류 메세지 출력하고
				kor = eng = math = 0; //그래프 출력하지 않기
				repaint(); //그림 그리기
			}
		}
	}

	//메인 메서드
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		HW2_4_장세영 t = new HW2_4_장세영(); //프레임 실행!
	}

}
