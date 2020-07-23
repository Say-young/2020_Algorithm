import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Select extends JFrame implements ActionListener{
	
	/**
	 * Variables used in various functions are declared as global variables.
	 */
	
	static Connection myConn = null;
	static PreparedStatement pStmt = null;
	static Statement myState = null;
	static ResultSet myResSet = null;
	static String sql = "";
	
	JTextField text;
	JLabel label3;
	static String command;
	JButton button;
	
	public Select() {
		setSize(480,235);
		
		Dimension frameSize = getSize();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((screenSize.width - frameSize.width) /2, (screenSize.height - frameSize.height) /2);
	    setLayout(new BorderLayout());
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Select");
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		
		JLabel label1 = new JLabel("��޴��� �˻��� �ش��ϴ� �޴� ����� Ȯ���غ�����.");
		JLabel label2 = new JLabel("���� or Ǫ�� : ");
		text = new JTextField(10);
		button = new JButton("SEARCH");
		button.addActionListener(this);
		label3 = new JLabel("");
		
		panel1.add(label1);
		panel2.add(label2);
		panel2.add(text);
		panel2.add(button);
		panel3.add(panel1);
		panel3.add(panel2);
		panel4.add(label3);
		add(panel3, BorderLayout.CENTER);
		add(panel4, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String fin = "<html>";
		
		/**
		 * when you press the button, this statement works in DB
		 */
		if(e.getSource() == button) {
			command = text.getText();
			if(text.getText().equals("����")) {
				command = "1";
				fin = fin + "------------------�˻��Ͻ� ���� ����Դϴ�------------------";
			}else if(command.equals("Ǫ��")) {
				command = "2";
				fin = fin + "------------------�˻��Ͻ� Ǫ�� ����Դϴ�------------------";
			}else {
				label3.setText("�ش� ��޴��� �������� �ʽ��ϴ�.");
			}
		}
		try {
			/**
			 * Create a Connection object
			 */
			myConn = connectionfile.getConn();
			sql = "SELECT name FROM Information WHERE firstCategoryIdx = ?";
			/**
			 * Create a PreparedStatement object
			 */
			pStmt = myConn.prepareStatement(sql);
			pStmt.setString(1, command);
			/**
			 * Create a ResultSet object
			 */
			myResSet = pStmt.executeQuery();
			
			System.out.println("�˻���...");
			
			String[] name = new String[20];
			
			int i = 1;
			while (myResSet.next()) {
				name[i] = myResSet.getString("name");
				fin = fin + "<br/>" + i + ". " + name[i];
				i++;
			}
			fin = fin + "</html>";
			label3.setText(fin);
			
		}catch (SQLException er) {
			er.printStackTrace();
		}
	}

	public static void main(String[] args) {
	}
}