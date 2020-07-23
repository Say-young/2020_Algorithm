import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends JFrame implements ActionListener{
	
	/**
	 * Variables used in various functions are declared as global variables.
	 */
	
	static Connection myConn = null;
	static PreparedStatement pStmt = null;
	static Statement myState = null;
	static ResultSet myResSet = null;
	static String sql = "";
	
	public Main() {
		/**
		 * create JFrame
		 */
		setSize(480,300);
		
		Dimension frameSize = getSize();
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((screenSize.width - frameSize.width) /2, (screenSize.height - frameSize.height) /2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Starbucks");
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel(new GridLayout(2,2));
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel(new GridLayout(1,3));
		JPanel panel6 = new JPanel(new BorderLayout());
		JPanel panel7 = new JPanel(new GridLayout(2,1));
		JPanel panel8 = new JPanel(new BorderLayout());
		JPanel panel9 = new JPanel();
		JPanel panel10 = new JPanel();
		JPanel panel11 = new JPanel(new GridLayout(2,1));
		
		JLabel label1 = new JLabel("Select the function you want to perform.");
		
		JLabel label2 = new JLabel("------------------------------------------------------------------select------------------------------------------------------------------");
		JButton button = new JButton("in one table");
		JButton button1 = new JButton("nested");
		JButton button2 = new JButton("using view");
		JButton button3 = new JButton("all contents");
		
		JLabel label3 = new JLabel("------------------------------------------------------------------other functions------------------------------------------------------------------");
		JButton button4 = new JButton("insert");
		JButton button5 = new JButton("update");
		JButton button6 = new JButton("delete");
		
		JButton button7 = new JButton("FINISH");
		
		/**
		 * must put addActionListener on the button.
		 */
		
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		
		//안내멘트
		panel1.add(label1);
		
		//select 안내멘트
		panel2.add(label2);
		
		//select 버튼
		panel3.add(button);
		panel3.add(button1);
		panel3.add(button2);
		panel3.add(button3);
		
		panel6.add(panel2, BorderLayout.PAGE_START);
		panel6.add(panel3, BorderLayout.PAGE_END);
		
		//others 안내버튼
		panel4.add(label3);
		
		//others button
		panel5.add(button4);
		panel5.add(button5);
		panel5.add(button6);
		
		panel7.add(panel4);
		panel7.add(panel5);
		
		//finish 버튼
		JLabel label4 = new JLabel("------------------------------------------------------------------finish button------------------------------------------------------------------");
		panel9.add(label4);
		panel10.add(button7);
		
		panel11.add(panel9);
		panel11.add(panel10);
		
		panel8.add(panel6, BorderLayout.PAGE_START);
		panel8.add(panel7, BorderLayout.CENTER);
		panel8.add(panel11, BorderLayout.PAGE_END);
		
		add(panel1, BorderLayout.PAGE_START);
		add(panel8, BorderLayout.CENTER);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		/**
		 * when I click the button, this method will be worked.
		 * Pressing each button brings up a new window.
		 */
		if(e.getActionCommand().equals("in one table")) {
			Select select = new Select();
		}else if(e.getActionCommand().equals("nested")) {
			SelectNested nested = new SelectNested();
		}else if(e.getActionCommand().equals("using view")) {
			SelectbyView view = new SelectbyView();
		}else if(e.getActionCommand().equals("all contents")) {
			SelectAll all = new SelectAll();
		}else if(e.getActionCommand().equals("insert")) {
			Insert insert = new Insert();
		}else if(e.getActionCommand().equals("update")) {
			Update update = new Update();
		}else if(e.getActionCommand().equals("delete")) {
			Delete delte = new Delete();
		}else if(e.getActionCommand().equals("FINISH")) {
			/**
			 * When you want to finish this work
			 * PRESS the FINISH BUTTON
			 * then everything will be closed.
			 */
			if (myResSet != null) {
				try {
					myResSet.close();
					System.out.println("... Close ResultSet ...");
				} catch (SQLException er) {
					er.printStackTrace();
				}
			}
			
			if (myState != null || pStmt != null) {
				try {
					pStmt.close();
					myState.close();
					System.out.println("... Close Statement ...");
				} catch (SQLException er) {
					er.printStackTrace();
				}
			}
			
			if (myConn != null) {
				try {
					myConn.close();
					System.out.println("... Close Connection " + myConn.toString() + " ...");
					System.out.println("BYE");
				} catch (SQLException er) {
					er.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		/**
		 * create JFrame so that you can see the new window.
		 */
		Main main = new Main();
	}
}










