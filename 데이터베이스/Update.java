
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update extends JFrame implements ActionListener{
	
	/**
	 * Variables used in various functions are declared as global variables.
	 */
	
	static Connection myConn = null;
	static PreparedStatement pStmt = null;
	static Statement myState = null;
	static ResultSet myResSet = null;
	static String sql = "";
	
	static String fin;
	JRadioButton RB1;
	JRadioButton RB2;
	JRadioButton RB3;
	JRadioButton RB4;
	JRadioButton RB5;
	JTextField text, text2;
	JButton button;
	JButton button2;
	JLabel label3, label5;

	public Update() {
		setSize(600,320);
		
		Dimension frameSize = getSize();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((screenSize.width - frameSize.width) /2, (screenSize.height - frameSize.height) /2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Update");
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		JLabel label1 = new JLabel("업데이트할 테이블을 선택하세요.");
		
		RB1 = new JRadioButton("FirstCategory");
		RB2 = new JRadioButton("SecondCategory");
		RB3 = new JRadioButton("Information");
		RB4 = new JRadioButton("Caution");
		RB5 = new JRadioButton("Option");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(RB1);bg.add(RB2);bg.add(RB3);bg.add(RB4);bg.add(RB5);
		
		RB1.addActionListener(this);
		RB2.addActionListener(this);
		RB3.addActionListener(this);
		RB4.addActionListener(this);
		RB5.addActionListener(this);
		
		JLabel label = new JLabel("기존 이름 : ");
		JLabel label4 = new JLabel("변경할 내용 : ");
		text = new JTextField(10);
		text2 = new JTextField(10);
		
		button = new JButton("UPDATE");
		JLabel label2 = new JLabel("------------------------------------------------------------------------------------------------------------------------");
		button2 = new JButton("transaction을 사용한 UPDATE 결과를 보고싶다면?");
		label3 = new JLabel("");
		button.addActionListener(this);
		button2.addActionListener(this);
		
		panel1.add(label1);
		
		panel2.add(RB1);
		panel2.add(RB2);
		panel2.add(RB3);
		panel2.add(RB4);
		panel2.add(RB5);
		
		panel3.add(label);
		panel3.add(text);
		panel3.add(label4);
		panel3.add(text2);
		panel3.add(button);
		
		panel4.add(button2);

		label5 = new JLabel("");
		panel5.add(label5);
		
		JPanel panel6 = new JPanel();
		panel6.add(label3);
		
		JPanel panel7 = new JPanel();
		panel7.add(label2);
		
		JPanel panel8 = new JPanel(new GridLayout(7,1));
		panel8.add(panel1);
		panel8.add(panel2);
		panel8.add(panel3);
		panel8.add(panel5);
		panel8.add(panel7);
		panel8.add(panel4);
		panel8.add(panel6);

		
		add(panel8, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		/**
		 * when you press the button, this statement works in DB
		 */
		int flag = 0;
		String command1, command2, command3;
		try {
			/**
			 * Create a Connection object
			 * Create a Statement object
			 */
			myConn = connectionfile.getConn();
			if(e.getSource()==RB1) {
				flag = 1;
				command3 = "FirstCategory";
				sql = "UPDATE FirstCategory SET first = ? WHERE first = ?";
				pStmt = myConn.prepareStatement(sql);
				fin = "<html><center/>"+command3+" 테이블의 '";
			}else if(e.getSource()==RB2) {
				flag = 2;
				command3 = "SecondCategory";
				sql = "UPDATE SecondCategory SET second = ? WHERE second = ?";
				pStmt = myConn.prepareStatement(sql);
				fin = "<html><center/>"+command3+" 테이블의 '";
			}else if(e.getSource()==RB3) {
				flag = 3;
				command3 = "Information";
				sql = "UPDATE Information SET name = ? WHERE name = ?";
				pStmt = myConn.prepareStatement(sql);	
				fin = "<html><center/>"+command3+" 테이블의 '";
			}else if(e.getSource()==RB4) {
				flag = 4;
				command3 = "Caution";
				sql = "UPDATE Caution SET content = ? WHERE name = ?";
				pStmt = myConn.prepareStatement(sql);
				fin = "<html><center/>"+command3+" 테이블의 '";
			}else if(e.getSource()==RB5) {
				flag = 5;
				command3 = "PersonalOption";
				sql = "UPDATE PersonalOption SET content = ? WHERE name = ?";
				pStmt = myConn.prepareStatement(sql);
				fin = "<html><center/>"+command3+" 테이블의 '";
			}
			
			if(e.getSource()==button) {
				command1 = text.getText();
				command2 = text2.getText();
				pStmt.setString(2, command1);
				pStmt.setString(1, command2);
				/**
				 * Update
				 */
				pStmt.executeUpdate();
				fin = fin + command1+"'를 <br/>'"+command2+"'로 update 했습니다.<br/><br/></html>";
				label5.setText(fin);
			}else if(e.getSource() == button2) {
				/**
				 * how to transaction
				 * 1. setAutoCommit -> false
				 * 2. do 'excuteUpdate' as you want
				 * 3. commit
				 * 4. setAutoCommit -> true
				 */
				myConn.setAutoCommit(false);
				myState = myConn.createStatement();
				sql = "INSERT into firstCategory (first) values ('상품')";
				myState.executeUpdate(sql);
				sql = "UPDATE information SET firstCategoryIdx = 3 WHERE name = '자바 칩 프라푸치노'";
				myState.executeUpdate(sql);
				myConn.commit();
				myConn.setAutoCommit(true);
				label3.setText("<html>3. 상품 카테고리 추가 후 자바 칩 프라푸치노의 firstCategoryIdx를 3으로 변경했습니다!</html>");
			}
		}catch (SQLException er) {
			er.printStackTrace();
			if(myConn!=null) {
				try{
					myConn.rollback();
				}catch(SQLException sqle){
				}
			}
		}
	}
	
	public static void main(String[] args) {
	}
}
