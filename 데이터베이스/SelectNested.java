import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectNested extends JFrame implements ActionListener{
	
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
	
	public SelectNested() {
		setSize(480,235);
		
		Dimension frameSize = getSize();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((screenSize.width - frameSize.width) /2, (screenSize.height - frameSize.height) /2);
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SelectNested");
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("이름을 검색해서  가격, 추천하는 옵션, 주의사항을 알아보세요.");
		panel1.add(label1);
		
		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel("이름 : ");
		text = new JTextField(20);
		JButton button = new JButton("SEARCH");
		button.addActionListener(this);
		panel2.add(label2);
		panel2.add(text);
		panel2.add(button);
		
		JPanel panel3 = new JPanel();
		label3 = new JLabel("");
		panel3.add(label3);
		
		JPanel panel4 = new JPanel(new GridLayout(2,1));
		panel4.add(panel1);
		panel4.add(panel2);

		add(panel4, BorderLayout.PAGE_START);
		add(panel3, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		/**
		 * when you press the button, this statement works in DB
		 */
		String fin = "<html>";
		command = text.getText();
		
		try {
			/**
			 * Create a Connection object
			 */
			myConn = connectionfile.getConn();
			sql = "SELECT information.name, price, PersonalOption.content as tip, Caution.content as caution FROM Information, PersonalOption, Caution WHERE information.name = ? and information.name = caution.name and caution.name = personaloption.name and caution.name in (SELECT information.name from information, personaloption where information.name = personaloption.name)";
			/**
			 * Create a PreparedStatement object
			 */
			pStmt = myConn.prepareStatement(sql);
			pStmt.setString(1, command);
			/**
			 * Create a ResultSet object
			 */
			myResSet = pStmt.executeQuery();
			
			System.out.println("검색중...");
			
			while (myResSet.next()) {
				fin = fin + "음료 이름 : " + myResSet.getString("name") + "<br/>가격 : " + myResSet.getString("price") + "<br/>추천 옵션 : " + myResSet.getString("tip") + "<br/>주의사항 : " + myResSet.getString("caution");
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
