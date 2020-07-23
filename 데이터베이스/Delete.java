import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete extends JFrame implements ActionListener{
	/**
	 * Variables used in various functions are declared as global variables.
	 */
	
	static Connection myConn = null;
	static PreparedStatement pStmt = null;
	static Statement myState = null;
	static ResultSet myResSet = null;
	static String sql = "";

	JRadioButton RB1;
	JRadioButton RB2;
	JButton button;
	JTextField text;
	JLabel label3;
	
	static String command1;
	static String command2;
	
	public Delete() {
		setSize(480,240);
		
		Dimension frameSize = getSize();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((screenSize.width - frameSize.width) /2, (screenSize.height - frameSize.height) /2);
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Delete");
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("<html><center/><br/>삭제할 테이블과 음식 이름을 입력하세요.</html>");
		panel.add(label);
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("테이블 선택 :");
		RB1= new JRadioButton("Caution");
		RB2= new JRadioButton("PersonalOption");
		ButtonGroup bg = new ButtonGroup();
		bg.add(RB1);bg.add(RB2);
		panel1.add(label1);panel1.add(RB1);panel1.add(RB2);
		
		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel("메뉴 이름 : ");
		text = new JTextField(17);
		panel2.add(label2);
		panel2.add(text);
		
		JPanel panel3 = new JPanel();
		button = new JButton("DELETE");
		panel3.add(button);

		JPanel panel4 = new JPanel(new GridLayout(3,1));
		panel4.add(panel1);
		panel4.add(panel2);
		panel4.add(panel3);
		
		JPanel panel5 = new JPanel();
		label3 = new JLabel("<html><br/><br/></html>");
		panel5.add(label3);
		
		button.addActionListener(this);
		RB1.addActionListener(this);
		RB2.addActionListener(this);
		
		add(panel, BorderLayout.PAGE_START);
		add(panel4, BorderLayout.CENTER);
		add(panel5, BorderLayout.PAGE_END);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			/**
			 * Create a Connection object
			 */
			myConn = connectionfile.getConn();
			/**
			 * RB decides table
			 */
		if(e.getSource() == RB1) {
			command1 = "Caution";
			sql = "delete from Caution where name = ?";
			/**
			 * Create a PreparedStatement object
			 */
			pStmt = myConn.prepareStatement(sql);
		}else if (e.getSource() == RB2) {
			command1 = "PersonalOption";
			sql = "delete from PersonalOption where name = ?";
			pStmt = myConn.prepareStatement(sql);
		}
		
		/**
		 * when you press the button, this statement works in DB
		 * UPDATE
		 */
		if(e.getSource()==button) {
			command2 = text.getText();
			System.out.println("삭제...");
			pStmt.setString(1, command2);
			pStmt.executeUpdate();
			String fin = "<html>"+command1+" 테이블의 "+command2+"가 삭제되었습니다.<br/><br/></html>";
			label3.setText(fin);
		}
		}catch (SQLException er) {
			er.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

	}

}
