package today;

import java.awt.*;
import javax.swing.*;

public class Week11_1_�弼�� extends JFrame{

	public Week11_1_�弼��(){

		//System.out.println("=============");
		//System.out.println("���� : ��ǻ�Ͱ���")
		//System.out.println("�й� : 1871047");
		//System.out.println("���� : �弼��");
		//System.out.println("=============");
		
		setTitle("Calculator"); //�˾�â ��ܹٿ� �ߴ� �̸�
		
		JTextField field = new JTextField(20); //��� ���� �Է��� textfield ����
		add(field, BorderLayout.NORTH);//sector ���ʿ� textfield �߰�
		field.setHorizontalAlignment(JTextField.RIGHT);//textfield�� Ŀ���� �����ʿ� ���ֵ��� �ʱ�ȭ
		
		JPanel Center_panel = new JPanel(); //Center�� �� ������Ʈ�� �����Ƿ� �г� ����
		Center_panel.setLayout(new GridLayout(5,4,10,0)); //Gridlayout ���� (��, ��, ���ο���, ���ο���)
		makeButton("ON", Center_panel); //������� �гο� ��ư �߰�
		makeButton("AC", Center_panel);
		makeButton("C", Center_panel);
		makeButton("OFF", Center_panel);
		makeButton("7", Center_panel);
		makeButton("8", Center_panel);
		makeButton("9", Center_panel);
		makeButton("/", Center_panel);
		makeButton("4", Center_panel);
		makeButton("5", Center_panel);
		makeButton("6", Center_panel);
		makeButton("X", Center_panel);
		makeButton("1", Center_panel);
		makeButton("2", Center_panel);
		makeButton("3", Center_panel);
		makeButton("-", Center_panel);
		makeButton("0", Center_panel);
		makeButton(".", Center_panel);
		makeButton("=", Center_panel);
		makeButton("+", Center_panel);
		add(Center_panel, BorderLayout.CENTER); //sector ����� �г� �߰�
	}
	
	//�гο� ��ư �߰��ϴ� �޼���
	public void makeButton(String text, JPanel panel) {
		JButton button = new JButton(text); //�Ķ���ͷ� ���� String�� ���� ��ư ����
		panel.add(button); //�Ķ���ͷ� ���� �гο� ��ư �߰�
	}
	
	public static void main(String[] args) {
		Week11_1_�弼�� lab1 = new  Week11_1_�弼��(); //�ν��Ͻ� ����
		lab1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x���� ��� �����ϵ���
		lab1.setSize(300,200); //������ ����
		lab1.setVisible(true); //ȭ�鿡 �ش� �׸��� ���̵���
	}

}
