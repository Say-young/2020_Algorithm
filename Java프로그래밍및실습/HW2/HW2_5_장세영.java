package hw2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HW2_5_장세영 extends JFrame{
	
	//필요한 요소들 미리 선언(아래에서 다른 함수나 innerclass에서 쓰이는 경우도 있으므로 생성자 밖에 선언)
		mypaint panel1; Panel panel2;
		JTextField text1, text2, text3, text4;
		JLabel label1, label2, label3, label4;
		JButton button;
		int Kim, Lee, Park, Etc, judge;
		
		//생성자
		HW2_5_장세영(){
			Toolkit tk = getToolkit(); //getToolkit()메서드는 Component에 정의되어 있음
			Dimension d = tk.getScreenSize(); //스크린 사이즈 받아오기
			int screenWidth = d.width; //스크린 가로 길이 받아오기
			int	screenHeight = d.height; //스크린 세로 길이 받아오기
			setSize(520,460); //프레임 크기 설정
			setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2); //창이 스크린 한가운데 뜨도록 위치 설정
			setTitle("Pie Chart of Student names - 장세영"); //프레임 타이틀 설정
			setDefaultCloseOperation(EXIT_ON_CLOSE); //X누르면 프로그램 종료되도록
			
			panel1 = new mypaint(); //panel을 extends한 innerclass의 instance 선언
			panel2 = new Panel();
			
			//필요한 라벨과 텍스트필드 만들기
			label1 = new JLabel("Kim");
			text1 = new JTextField(5);
			label2 = new JLabel("Lee");
			text2 = new JTextField(5);
			label3 = new JLabel("Park");
			text3 = new JTextField(5);
			label4 = new JLabel("Etc");
			text4 = new JTextField(5);
			button = new JButton("Graph");
			button.addActionListener(panel1);
			
			//요소들을 패널에 붙이고
			panel2.add(label1);
			panel2.add(text1);
			panel2.add(label2);
			panel2.add(text2);
			panel2.add(label3);
			panel2.add(text3);
			panel2.add(label4);
			panel2.add(text4);
			panel2.add(button);
			add(panel1, BorderLayout.CENTER); //그림은 프레임 센터에
			add(panel2, BorderLayout.SOUTH); //나머지 요소들은 프레임 아래에 붙임
			setVisible(true);//프레임 보이게 하기
		}
		
		//innerclass로 선언함
		private class mypaint extends Panel implements ActionListener{
		public void paint(Graphics g) {
			
			//하얀 배경 그림
			Color c = Color.white;
			g.setColor(c);
			g.fillRect(0, 0, 520, 460);
			
			switch(judge) {
				case 0 : //맨 처음에 시작하는 화면(초록색 원이 그려지는 걸 방지하기 위해 따로 설정)
						c = Color.yellow;
						g.setColor(c);
						g.drawString("YELLOW: KIMs", 360, 180); //옆에 출력되는 글자
						c = Color.red;
						g.setColor(c);
						g.drawString("RED: LEEs", 360, 200);//옆에 출력되는 글자
						c = Color.blue;
						g.setColor(c);
						g.drawString("BLUE: PARKs", 360, 220);//옆에 출력되는 글자
						c = Color.green;
						g.setColor(c);
						g.drawString("GREEN: Etcs", 360, 240);//옆에 출력되는 글자
						break;
				case 1://정상적인 입력을 받았을 경우
						//김씨에 해당하는 요소들은 yellow로 그림
						c = Color.yellow;
						g.setColor(c);
						g.drawString("YELLOW: KIMs", 360, 180); //옆에 출력되는 글자
						g.fillArc(130, 100, 200, 200, 0, (int)(Kim*3.6)); //파이차트 그림
					
						//김씨에 해당하는 요소들은 red로 그림
						c = Color.red;
						g.setColor(c);
						g.drawString("RED: LEEs", 360, 200);//옆에 출력되는 글자
						g.fillArc(130, 100, 200, 200, (int)(Kim*3.6), (int)(Lee*3.6));//파이차트 그림
					
						//김씨에 해당하는 요소들은 blue로 그림
						c = Color.blue;
						g.setColor(c);
						g.drawString("BLUE: PARKs", 360, 220);//옆에 출력되는 글자
						g.fillArc(130, 100, 200, 200, ((int)(Kim*3.6)+(int)(Lee*3.6)), (int)(Park*3.6));//파이차트 그림
					
						//김씨에 해당하는 요소들은 green로 그림
						c = Color.green;
						g.setColor(c);
						g.drawString("GREEN: Etcs", 360, 240);//옆에 출력되는 글자
						g.fillArc(130, 100, 200, 200, ((int)(Kim*3.6)+(int)(Lee*3.6)+(int)(Park*3.6)), 360-((int)(Kim*3.6)+(int)(Lee*3.6)+(int)(Park*3.6)));//파이차트 그림
						break;
				case 2://입력받은 세 수의 합이 100이 넘을 경우
						g.setColor(Color.black);
						g.drawString("Number of students is 100.", 180, 360);
						break;
				case 3://숫자가 아닌 것을 입력받았을 경우
						g.setColor(Color.black);
						g.drawString("Input numbers of students names.", 170, 360);	
						break;
			}
		}
		
		//actionlistener 메서드 오버라이드
		public void actionPerformed(ActionEvent e) {
			try {
				//받은 값은 string이므로 int로 변형해서 대입
				Kim = Integer.parseInt(text1.getText());
				Lee = Integer.parseInt(text2.getText());
				Park = Integer.parseInt(text3.getText());
				
				//만약 입력받은 정수가 범위를 벗어난다면
				if((Kim+Lee+Park)>100) {
					judge = 2; //paint 메서드에서 case를 나누기 위한 judge함수에 상황마다 내가 정한 임의의 수를 배정. 1은 범위를 벗어난 수를 입력 받았을 경우
					Kim = Lee = Park = Etc = 0;//그래프 출력하지 말기
					repaint();//그림 그리기
				}else { //정상적인 입력을 받았다면
					judge = 1;
					Etc = 100-(Kim+Lee+Park);//etc 계산해서
					text4.setText(Integer.toString(Etc)); //화면에 etc 값을 출력해주고
					repaint(); //그림그리기
				}
			}catch(NumberFormatException a){//정수로 변환할 수 없는 형태의 입력을 받았다면
				judge = 3;
				Kim = Lee = Park = Etc = 0;//그래프 출력하지 말기
				repaint();//그림 그리기
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

		HW2_5_장세영 myframe = new HW2_5_장세영();//프레임 실행!
	}

}

