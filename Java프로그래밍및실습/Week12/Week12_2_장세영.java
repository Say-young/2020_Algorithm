package asm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Week12_2_장세영 extends JFrame implements ActionListener{
	
	Color color = Color.RED; //기본 색상은 red로 설정
	
	JRadioButton RB1 = new JRadioButton("RED"); //라디오 버튼 3개 생성. 메서드에서 접근해야하기 때문에 생성자 밖에 생성
	JRadioButton RB2 = new JRadioButton("GREEN");
	JRadioButton RB3 = new JRadioButton("BLUE");
	
	//생성자
	public Week12_2_장세영() {
		Toolkit tk = getToolkit(); //getToolkit()메서드는 Component에 정의되어 있음
		Dimension d = tk.getScreenSize(); //스크린 사이즈 받아오기
		int screenWidth = d.width; //스크린 가로 길이 받아오기
		int	screenHeight = d.height; //스크린 세로 길이 받아오기
		setSize(500,350); //띄울 창의 너비와 높이 설정
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2); //창이 스크린 한가운데 뜨도록 위치 설정
		setTitle("MyCar - 장세영");//창 타이틀 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);//X누르면 프로그램 종료 되도록
		
		JPanel panel = new JPanel();
		ButtonGroup bg = new ButtonGroup(); //버튼 그룹 생성
		bg.add(RB1); bg.add(RB2); bg.add(RB3); //라디오 버튼을 셋 중에 하나만 선택 가능하도록 그룹에 추가
		RB1.setSelected(true); //red버튼이 처음에 선택되어 있도록 설정
		JButton button = new JButton("Paint"); //버튼 생성
		button.addActionListener(this); //버튼에 액션리스너 추가
		panel.add(RB1); panel.add(RB2); panel.add(RB3); panel.add(button); //패널에 모두 올리고
		add(panel, BorderLayout.SOUTH);//컨테이너 남쪽에 해당 패널 붙이기
		setVisible(true); //창이 보이도록
	}
	
	//실행하면 그려지는 paint 메서드
	public void paint(Graphics g) {
		g.setColor(color);//맨 처음 색은 red
		g.fillRect(180, 80, 140, 60); //두 상자의 위치와 width height 설정
		g.fillRect(110, 140, 280, 100);
		
		Color c = Color.lightGray;
		g.setColor(c);//바퀴 색은 lightGray로 고정
		g.fillOval(150, 200,80, 80); //두 바퀴의 위치와 너비 설정
		g.fillOval(270, 200,80, 80);
		
		c = Color.BLACK;
		g.setColor(c);//웃는 눈의 색은 black으로 고정
		g.drawArc(250, 110, 80, 150, 60,63); //웃는 눈 그리기. 선이 얇아서 여러 번 겹쳐 그림
		g.drawArc(250, 109, 80, 150, 60,63);
		g.drawArc(249, 110, 80, 150, 60,63);
	}
	
	//어떤 라디오 버튼을 선택하느냐에 따라 자동차의 색이 바뀌도록 설정하는 메서드
	public void actionPerformed(ActionEvent e) {
		if(RB1.isSelected()) { //red 버튼이 선택되어있을 경우
			color = Color.RED; //차체의 color를 red로 설정
		}else if(RB2.isSelected()) {//green 버튼이 선택되어있을 경우
			color = color.GREEN;//차체의 color를 green으로 설정
		}else if(RB3.isSelected()) {//blue 버튼이 선택되어있을 경우
			color = color.BLUE;//차체의 color를 blue로 설정
		}
		repaint(); //색 변경할 때 repaint() 필수
	}
	
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		new Week12_2_장세영(); //창 생성
	}

}
