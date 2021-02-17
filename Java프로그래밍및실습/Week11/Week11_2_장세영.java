package today;

import java.awt.*;
import javax.swing.*;

public class Week11_2_장세영 extends JFrame {

	public Week11_2_장세영() {
		
		//System.out.println("=============");
		//System.out.println("전공 : 컴퓨터공학");
		//System.out.println("학번 : 1871047");
		//System.out.println("성명 : 장세영");
		//System.out.println("=============");
		
		setTitle("Student Information"); //팝업창 상단바에 뜨는 이름
		
		//sector에 배치할 panel들 선언
		JPanel Center_panel = new JPanel();
		JPanel South_panel = new JPanel();
		JPanel North_panel = new JPanel();
		JPanel Gender_panel = new JPanel();
		
		//center에 들어갈 textfield 선언
		JTextField name = new JTextField();
		JTextField id = new JTextField();
		JTextField department = new JTextField();
		
		//center에 들어갈 radiobutton 선언
		JRadioButton RB1 = new JRadioButton("Female");
		JRadioButton RB2 = new JRadioButton("Male");
		Gender_panel.setLayout(new GridLayout(1,2)); //한줄에 2개 넣기 위해 gridlayout 사용
		Gender_panel.add(RB2); //패널에 버튼 올리기
		Gender_panel.add(RB1);
		ButtonGroup bg = new ButtonGroup(); //한 개의 버튼만 클릭되도록 하기 위해 버튼 그룹핑
		bg.add(RB1);bg.add(RB2);
		RB1.setSelected(true); //female 버튼이 선택되어 있도록 초기화
		
		//위쪽 패널
		North_panel.add(new JLabel("STUDENT INFORMATION")); //라벨 추가
		North_panel.setAlignmentX(CENTER_ALIGNMENT); //가운데 정렬
		add(North_panel, BorderLayout.NORTH); //sector의 위쪽에 패널 얹기

		//가운데 패널
		Center_panel.setLayout(new GridLayout(4,2)); //gridlayout 사용
		Center_panel.add(new JLabel("NAME")); //label과 textfield 추가
		Center_panel.add(name);
		Center_panel.add(new JLabel("GENDER"));
		Center_panel.add(Gender_panel); //위에서 설정해둔 gender panel 얹기
		Center_panel.add(new JLabel("ID"));
		Center_panel.add(id);
		Center_panel.add(new JLabel("DEPARTMENT"));
		Center_panel.add(department);
		add(Center_panel); //sector의 가운데에 패널 얹기
		
		//아래쪽패널
		South_panel.add(new JButton("Save")); //버튼 추가
		South_panel.add(new JButton("Cancel")); //버튼 추가
		South_panel.setAlignmentX(CENTER_ALIGNMENT); //해당 패널 가운데 정렬
		add(South_panel, BorderLayout.SOUTH); //sector의 아래쪽에 패널 얹기

	}
	
	public static void main(String[] args) {
		Week11_2_장세영 lab2 = new Week11_2_장세영(); //인스턴스 생성
		lab2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x누를 경우 종료하도록
		lab2.setSize(350,200); //사이즈 설정
		lab2.setVisible(true); //화면에 해당 그림이 보이도록
	}

}
