import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAll extends JFrame{
	
	/**
	 * Variables used in various functions are declared as global variables.
	 */
	
	static JLabel label2 = new JLabel(""); //firstCategory
	static JLabel label3 = new JLabel(""); //secondCategory
	static JLabel label4 = new JLabel(""); //information
	static JLabel label5 = new JLabel(""); //caution
	static JLabel label6 = new JLabel(""); //personalOption
	
	static Connection myConn = null;
	static PreparedStatement pStmt = null;
	static Statement myState = null;
	static ResultSet myResSet = null;
	static String sql = "";

	public SelectAll() {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(480,screenSize.height-50);
		Dimension frameSize = getSize();
	    setLocation((screenSize.width - frameSize.width) /2, (screenSize.height - frameSize.height) /2);
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SelectAll");
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("<html><br/>※모든 정보를 출력합니다.※<br/><br/><html>");
		panel1.add(label1);
		add(panel1, BorderLayout.PAGE_START);

		JPanel panel2 = new JPanel();
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(label6);
		
		add(panel2, BorderLayout.CENTER);
		
		setVisible(true);
		
		try{
			/**
			 * Create a Connection object
			 */
			myConn = connectionfile.getConn();
			/**
			 * Create a Statement object
			 */
			myState = myConn.createStatement();
			String fin = "<html>";
			System.out.println(String.format("검색중..."));
			
			sql = "SELECT * FROM FirstCategory";
			/**
			 * Create a ResultSet object
			 */
			myResSet = myState.executeQuery(sql);
			
			String[] string = new String[20];
			
			int i = 1;
			fin = fin + "---------------------1. FirstCategory table의 records---------------------";
			fin = fin + "<br/>" + "| idx | firstCategory |";
			while (myResSet.next()) {
				string[i] = myResSet.getString("first");
				fin = fin + "<br/>| " + i + " | " + string[i] + " |";
				i++;
			}
			fin = fin + "<br/><br/><br/></html>";
			label2.setText(fin);
			
			//
			
			sql = "SELECT * FROM SecondCategory";
			myResSet = myState.executeQuery(sql);
			
			i = 1;
			fin = "<html>------------------2. SecondCategory table의 records------------------";
			fin = fin + "<br/>" + "| idx | secondCategory |";
			while (myResSet.next()) {
				string[i] = myResSet.getString("second");
				fin = fin + "<br/>| " + i + " | " + string[i] + " |";
				i++;
			}
			fin = fin + "<br/><br/></html>";
			label3.setText(fin);
			
			//
			
			sql = "SELECT * FROM Information";
			myResSet = myState.executeQuery(sql);
			
			i = 1;
			fin = "<html>----------------------3. Information table의 records----------------------";
			fin = fin + "<br/>" + "| idx | name | price | firstCategoryidx | secondCategoryidx |";
			while (myResSet.next()) {
				string[i] = " " +myResSet.getString("name") + " | " + myResSet.getString("price") + "원 | " + myResSet.getString("firstCategoryIdx") +" | "+ myResSet.getString("secondCategoryIdx")+" |";
				fin = fin + "<br/>| " + i + " |" + string[i];
				i++;
			}
			fin = fin + "<br/><br/></html>";
			label4.setText(fin);
			
			//
			
			sql = "SELECT * FROM Caution";
			myResSet = myState.executeQuery(sql);
			
			i = 1;
			fin = "<html>-------------------------4. Caution table의 records-------------------------";
			fin = fin + "<br/>" + "| idx | name | content |";
			while (myResSet.next()) {
				string[i] = " " +myResSet.getString("name") + " | " + myResSet.getString("content") + " |";
				fin = fin + "<br/>| " + i + " |" + string[i];
				i++;
			}
			fin = fin + "<br/><br/></html>";
			label5.setText(fin);
			
			//
			
			sql = "SELECT * FROM PersonalOption";
			myResSet = myState.executeQuery(sql);
			
			i = 1;
			fin = "<html>--------------------5. PersonalOption table의 records--------------------";
			fin = fin + "<br/>" + "| idx | name | content |";
			while (myResSet.next()) {
				string[i] = " " +myResSet.getString("name") + " | " + myResSet.getString("content") + " |";
				fin = fin + "<br/>| " + i + " |" + string[i];
				i++;
			}
			fin = fin + "<br/><br/></html>";
			label6.setText(fin);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	}
}
