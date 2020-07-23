
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert extends JFrame implements ActionListener{
	
	/**
	 * Variables used in various functions are declared as global variables.
	 */
	
	static Connection myConn = null;
	static PreparedStatement pStmt = null;
	static Statement myState = null;
	static ResultSet myResSet = null;
	static String sql = "";
	
	/**
	 * I used cardlayout to control multiple pages effectively
	 */
	
	Cards cards;
	
	JRadioButton RB1;
	JRadioButton RB2;
	JRadioButton RB3;
	JRadioButton RB4;
	JRadioButton RB5;
	JLabel label5;
	int flag;
	
	JTextField text1, text2, text31, text32, text33, text34, text41, text42, text51, text52;

	JButton button;
	
	public Insert() {
		setSize(800,235);
		
		Dimension frameSize = getSize();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((screenSize.width - frameSize.width) /2, (screenSize.height - frameSize.height) /2);
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Insert");
		setLayout(new BorderLayout());
		
		cards = new Cards();
		
		button = new JButton("추가");
		button.addActionListener(this);
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("어떤 테이블에 데이터를 넣으시겠어요?");
		RB1= new JRadioButton("FirstCategory");
		RB2= new JRadioButton("SecondCategory");
		RB3= new JRadioButton("Information");
		RB4= new JRadioButton("Caution");
		RB5= new JRadioButton("Option");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(RB1);bg.add(RB2);bg.add(RB3);bg.add(RB4);bg.add(RB5);
		
		RB1.addActionListener(this);
		RB2.addActionListener(this);
		RB3.addActionListener(this);
		RB4.addActionListener(this);
		RB5.addActionListener(this);
		
		panel1.add(label1);
		
		JPanel panel2 = new JPanel();
		panel2.add(RB1);
		panel2.add(RB2);
		panel2.add(RB3);
		panel2.add(RB4);
		panel2.add(RB5);
		
		JPanel panel3 = new JPanel();
		panel3.add(panel1);
		panel3.add(panel2);
		
		JPanel panel4 = new JPanel();
		panel4.add(cards);
	
		JPanel panel5 = new JPanel();
		label5 = new JLabel("");
		panel5.add(label5);
		
		JPanel panel6 = new JPanel();
		panel6.add(button);
		
		JPanel panel7 = new JPanel(new GridLayout(2,1));
		panel7.add(panel6);
		panel7.add(panel5);
		
		add(panel3, BorderLayout.PAGE_START);
		add(panel4, BorderLayout.CENTER);
		add(panel7, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	private class Cards extends JPanel {
		CardLayout layout;
		
		public Cards() {
			layout = new CardLayout();
			setLayout(layout);
			
			JPanel card = new JPanel();
			JPanel card1 = new JPanel();
			JPanel card2 = new JPanel();
			JPanel card3 = new JPanel();
			JPanel card4 = new JPanel();
			JPanel card5 = new JPanel();
			
			JLabel label = new JLabel("상단의 조건을 선택하세요.");
			
			JLabel label11= new JLabel("대분류 : ");
			text1 = new JTextField(10);
			
			JLabel label22= new JLabel("소분류 : ");
			text2 = new JTextField(10);
			
			JLabel label31= new JLabel("음료 이름 : ");
			text31 = new JTextField(10);
			JLabel label32 = new JLabel("대분류 : ");
			text32 = new JTextField(10);
			JLabel label33 = new JLabel("소분류 : ");
			text33 = new JTextField(10);
			JLabel label34 = new JLabel("가격 : ");
			text34 = new JTextField(10);
			
			JLabel label41= new JLabel("음료 이름 : ");
			text41 = new JTextField(10);
			JLabel label42= new JLabel("주의사항 : ");
			text42 = new JTextField(20);
			
			JLabel label51= new JLabel("음료 이름 : ");
			text51 = new JTextField(10);
			JLabel label52= new JLabel("내가 추천하는 옵션 : ");
			text52 = new JTextField(20);
			
			card.add(label);
			
			card1.add(label11);
			card1.add(text1);
			
			card2.add(label22);
			card2.add(text2);
		
			card3.add(label31);
			card3.add(text31);
			card3.add(label32);
			card3.add(text32);
			card3.add(label33);
			card3.add(text33);
			card3.add(label34);
			card3.add(text34);
			
			card4.add(label41);
			card4.add(text41);
			card4.add(label42);
			card4.add(text42);
			
			card5.add(label51);
			card5.add(text51);
			card5.add(label52);
			card5.add(text52);
			
			add(card);
			add(card1);
			add(card2);
			add(card3);
			add(card4);
			add(card5);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		/**
		 * when you press the button, this statement works in DB
		 */
		String command1, command2, command3, command4;
		String fin;
		try {
			/**
			 * Create a Connection object
			 * Create a PreparedStatement object
			 */
			myConn = connectionfile.getConn();
		if(e.getActionCommand().equals("FirstCategory")) {
			flag = 1;
			cards.layout.next(cards);
			sql = "INSERT INTO FirstCategory (first) VALUES (?)";
			pStmt = myConn.prepareStatement(sql);
		}else if(e.getActionCommand().equals("SecondCategory")) {
			flag = 2;
			cards.layout.next(cards);
			sql = "INSERT INTO SecondCategory (second) VALUES (?)";
			pStmt = myConn.prepareStatement(sql);
		}else if(e.getActionCommand().equals("Information")) {
			flag = 3;
			cards.layout.next(cards);
			sql = "INSERT INTO Information (name, price, firstCategoryIdx, secondCategoryIdx) VALUES (?,?,?,?)";
			pStmt = myConn.prepareStatement(sql);	
		}else if(e.getActionCommand().equals("Caution")) {
			flag = 4;
			cards.layout.next(cards);
			sql = "INSERT INTO Caution (name, content) VALUES (?,?)";
			pStmt = myConn.prepareStatement(sql);	
		}else if(e.getActionCommand().equals("Option")) {
			flag = 5;
			cards.layout.next(cards);
			sql = "INSERT INTO PersonalOption (name, content) VALUES (?,?)";
			pStmt = myConn.prepareStatement(sql);
		}
		/**
		 * Use the flag determined above
		 * Update
		 */
		if(e.getSource()==button) {
			if(flag == 1) {
				command1 = text1.getText();
				pStmt.setString(1, command1);
				pStmt.executeUpdate();
				fin = "<html>"+"FirstCategory 테이블에 "+command1+"이/가 추가되었습니다.<br/><br/></html>";
				label5.setText(fin);
			}else if(flag == 2) {
				command1 = text2.getText();
				pStmt.setString(1, command1);
				pStmt.executeUpdate();
				fin = "<html>"+"SecondCategory 테이블에 "+command1+"이/가 추가되었습니다.<br/><br/></html>";
				label5.setText(fin);
			}else if(flag == 3) {
				command1 = text31.getText();
				command2 = text32.getText();
				command3 = text33.getText();
				command4 = text34.getText();
				pStmt.setString(1, command1);
				pStmt.setString(2, command4);
				pStmt.setString(3, command2);
				pStmt.setString(4, command3);
				pStmt.executeUpdate();
				fin = "<html>"+"Information 테이블에 "+command1+"이/가 추가되었습니다.<br/><br/></html>";
				label5.setText(fin);
			}else if(flag == 4) {
				command1 = text41.getText();
				command2 = text42.getText();
				pStmt.setString(1, command1);
				pStmt.setString(2, command2);
				pStmt.executeUpdate();
				fin = "<html>"+"Caution 테이블에 "+command1+"이/가 추가되었습니다.<br/><br/></html>";
				label5.setText(fin);
			}else if(flag == 5) {
				command1 = text51.getText();
				command2 = text52.getText();
				pStmt.setString(1, command1);
				pStmt.setString(2, command2);
				pStmt.executeUpdate();
				fin = "<html>"+"PersonalOption 테이블에 "+command1+"이/가 추가되었습니다.<br/><br/></html>";
				label5.setText(fin);
			}
		}
	}catch (SQLException er) {
		er.printStackTrace();
	}
}

	public static void main(String[] args) {
	}
}
