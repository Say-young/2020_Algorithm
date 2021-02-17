package hw2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HW2_3_장세영 extends JFrame implements ActionListener{
	
	//필요한 요소들 선언
	private JPanel panel1, panel2;
	private JButton[] buttons;
	private JButton BtnPlus, BtnMinus, BtnProduct, BtnDivide, BtnResult, BtnNew;
	private JTextField textfield;
	private int op;
	private String first;
	
	//생성자
	HW2_3_장세영(){
		setTitle("Calculator"); //프레임 타이틀 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X누르면 프로그램 종료되도록
		
		textfield = new JTextField(25); //입력창 크기 설정
		textfield.setHorizontalAlignment(JTextField.RIGHT); //오른쪽부터 입력 받도록
		
		panel1 = new JPanel(); //textfield 올릴 패널 생성
		panel1.add(textfield); //패널에 올리기
		
		panel2 = new JPanel(new GridLayout(0,4)); //버튼들이 들어갈 panel을 girdlayout으로 생성(디폴트는 flow임)
		buttons = new JButton[10]; //버튼 10개를 담을 수 있는 배열 생성
		for(int i=0; i<buttons.length; i++) { //0~9까지의 버튼을 한번에 생성하고 ActionListener 붙이기
			buttons[i] = new JButton(Integer.toString(i));
			buttons[i].addActionListener(this);
		}
		//숫자가 아닌 연산 버튼들 생성
		BtnPlus = new JButton("+");
		BtnMinus = new JButton("-");
		BtnProduct = new JButton("*");
		BtnDivide = new JButton("/");
		BtnResult = new JButton("=");
		BtnNew = new JButton("New");
		//각각 버튼에 액션 리스너 붙이기
		BtnPlus.addActionListener(this);
		BtnMinus.addActionListener(this);
		BtnProduct.addActionListener(this);
		BtnDivide.addActionListener(this);
		BtnResult.addActionListener(this);
		BtnNew.addActionListener(this);
		
		//순서대로 패널에 버튼들 붙이기
		panel2.add(buttons[7]);
		panel2.add(buttons[8]);
		panel2.add(buttons[9]);
		panel2.add(BtnDivide);
		panel2.add(buttons[4]);
		panel2.add(buttons[5]);
		panel2.add(buttons[6]);
		panel2.add(BtnProduct);
		panel2.add(buttons[1]);
		panel2.add(buttons[2]);
		panel2.add(buttons[3]);
		panel2.add(BtnMinus);
		panel2.add(BtnNew);
		panel2.add(buttons[0]);
		panel2.add(BtnResult);
		panel2.add(BtnPlus);
		
		//패널을 frame에 붙이기
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		
		pack(); //사이즈 설정이 따로 없었으므로 팩
		setVisible(true); //프레임이 화면에 보이도록
	}

	
	//이벤트 핸들링 메서드
	public void actionPerformed(ActionEvent e) {
		
		//0~9까지의 수에 해당하는 버튼이 눌렸을 때 textfield에 해당 수가 출력되도록 하는 메서드
		for(int i=0; i<buttons.length; i++) {
			if(e.getSource() == buttons[i]){
				if(textfield.getText().equals("0")){
					textfield.setText(""+i);
				}else {
					textfield.setText(""+i);
				}
			}
		}

		//각 연산버튼을 눌렀을 때 작동하는 메서드
		if(e.getSource() == BtnPlus){ //더하기 버튼을 누르면
			first=textfield.getText(); //first에 입력받은 string을 그대로 저장한다
			op=1; //op 1을 임의로 더하기로 정한다
		}else if(e.getSource() == BtnMinus){//빼기 버튼을 누르면
			first=textfield.getText();
			op=2;//op 2를 임의로 빼기로 정한다
		}else if(e.getSource() == BtnProduct){//곱하기 버튼을 누르면
			first=textfield.getText();
			op=3;//op 3을 임의로 곱하기로 정한다
		}else if(e.getSource() == BtnDivide){//나누기 버튼을 누르면
			first=textfield.getText();
			op=4;//op 4를 임의로 나누기로 정한다
		}
		
		//초기화 버튼을 누르면
		if(e.getSource() == BtnNew){ 
			first=""; //first 변수를 초기화
			textfield.setText(""); //아무것도 띄우지 않는다
		}
		//결과 버튼을 누르면
		if(e.getSource() == BtnResult){
			int num1, num2; double result; //결과 함수 내에서 사용할 변수들
			num1 = Integer.parseInt(first); //num1에 기존에 담아뒀던 first의 내용을 int로 받아온다
			num2 = Integer.parseInt(textfield.getText()); //num2에 textfield의 내용을 int로 받아온다
			if(op==1){ //더하기
				result = num1 + num2;
				textfield.setText("" + result); //더하기한 결과 출력
			}else if(op==2){ //빼기
				result = num1 - num2;
				textfield.setText("" + result); //빼기한 결과 출력
			}else if(op==3){ //곱하기
				result = num1 * num2;
				textfield.setText("" + result); //곱하기한 결과 출력
			}else if(op==4){ //나누기
				result = (double)num1 / num2;
				textfield.setText("" + result); //나누기한 결과 출력
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
		
		HW2_3_장세영 myframe = new HW2_3_장세영(); //프레임 실행!
	}

}
