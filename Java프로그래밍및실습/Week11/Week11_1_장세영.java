package today;

import java.awt.*;
import javax.swing.*;

public class Week11_1_장세영 extends JFrame{

	public Week11_1_장세영(){

		//System.out.println("=============");
		//System.out.println("전공 : 컴퓨터공학")
		//System.out.println("학번 : 1871047");
		//System.out.println("성명 : 장세영");
		//System.out.println("=============");
		
		setTitle("Calculator"); //팝업창 상단바에 뜨는 이름
		
		JTextField field = new JTextField(20); //계산 값을 입력할 textfield 생성
		add(field, BorderLayout.NORTH);//sector 위쪽에 textfield 추가
		field.setHorizontalAlignment(JTextField.RIGHT);//textfield의 커서가 오른쪽에 와있도록 초기화
		
		JPanel Center_panel = new JPanel(); //Center에 들어갈 컴포넌트가 많으므로 패널 생성
		Center_panel.setLayout(new GridLayout(5,4,10,0)); //Gridlayout 설정 (열, 행, 가로여백, 세로여백)
		makeButton("ON", Center_panel); //순서대로 패널에 버튼 추가
		makeButton("AC", Center_panel);
		makeButton("C", Center_panel);
		makeButton("OFF", Center_panel);
		makeButton("7", Center_panel);
		makeButton("8", Center_panel);
		makeButton("9", Center_panel);
		makeButton("/", Center_panel);
		makeButton("4", Center_panel);
		makeButton("5", Center_panel);
		makeButton("6", Center_panel);
		makeButton("X", Center_panel);
		makeButton("1", Center_panel);
		makeButton("2", Center_panel);
		makeButton("3", Center_panel);
		makeButton("-", Center_panel);
		makeButton("0", Center_panel);
		makeButton(".", Center_panel);
		makeButton("=", Center_panel);
		makeButton("+", Center_panel);
		add(Center_panel, BorderLayout.CENTER); //sector 가운데에 패널 추가
	}
	
	//패널에 버튼 추가하는 메서드
	public void makeButton(String text, JPanel panel) {
		JButton button = new JButton(text); //파라미터로 받은 String을 가진 버튼 생성
		panel.add(button); //파라미터로 받은 패널에 버튼 추가
	}
	
	public static void main(String[] args) {
		Week11_1_장세영 lab1 = new  Week11_1_장세영(); //인스턴스 생성
		lab1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x누를 경우 종료하도록
		lab1.setSize(300,200); //사이즈 설정
		lab1.setVisible(true); //화면에 해당 그림이 보이도록
	}

}
