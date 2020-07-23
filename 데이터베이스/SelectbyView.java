import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectbyView extends JFrame implements ActionListener{
	
	/**
	 * Variables used in various functions are declared as global variables.
	 */
	
	static Connection myConn = null;
	static PreparedStatement pStmt = null;
	static Statement myState = null;
	static ResultSet myResSet = null;
	static String sql = "";
	
	static JLabel label2 = new JLabel("");
	static JLabel label3 = new JLabel("");
	JTextField text;
	JButton button;
	static String command;
	
	public SelectbyView() {
	    setSize(480,235);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
	    setLocation((screenSize.width - frameSize.width) /2, (screenSize.height - frameSize.height) /2);
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SelectbyView");
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("<html><br/>※view로 정의되어 있는 [주의사항이 있는 음식 목록] 중에서 검색합니다.※<br/><html>");
		panel1.add(label1);
		add(panel1, BorderLayout.PAGE_START);

		JPanel panel2 = new JPanel();
		text = new JTextField(20);
		button = new JButton("Select with View");
		button.addActionListener(this);
		panel2.add(text);
		panel2.add(button);
		panel2.add(label2);
		add(panel2, BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel();
		add(panel3, BorderLayout.PAGE_END);
		
		setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		/**
		 * when you press the button, this statement works in DB
		 */
		if(e.getSource()==button) {
			try {
				/**
				 * Create a Connection object
				 */
				myConn = connectionfile.getConn();
				String fin = "<html>";
				
				command = text.getText();	
				sql = "select * from priceNcaution where name = ?";
				/**
				 * Create a PreparedStatement object
				 */
				pStmt = myConn.prepareStatement(sql);
				pStmt.setString(1, command);
				/**
				 * Create a ResultSet object
				 */
				myResSet = pStmt.executeQuery();
				
				String[] string = new String[20];
				
				int i = 1;
				fin = fin + "<br/>" + "| name | price | caution |";
				while (myResSet.next()) {
					string[i] = " " +myResSet.getString("name") + " | " + myResSet.getString("price") + " | " + myResSet.getString("content") + " | ";
					fin = fin + "<br/>| " + string[i];
					i++;
				}
				fin = fin + "<br/><br/><br/></html>";
				label2.setText(fin);
				
				fin = fin+"</html>";
			} catch (SQLException er) {
				er.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
	}
}
