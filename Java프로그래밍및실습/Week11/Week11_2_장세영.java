package today;

import java.awt.*;
import javax.swing.*;

public class Week11_2_�弼�� extends JFrame {

	public Week11_2_�弼��() {
		
		//System.out.println("=============");
		//System.out.println("���� : ��ǻ�Ͱ���");
		//System.out.println("�й� : 1871047");
		//System.out.println("���� : �弼��");
		//System.out.println("=============");
		
		setTitle("Student Information"); //�˾�â ��ܹٿ� �ߴ� �̸�
		
		//sector�� ��ġ�� panel�� ����
		JPanel Center_panel = new JPanel();
		JPanel South_panel = new JPanel();
		JPanel North_panel = new JPanel();
		JPanel Gender_panel = new JPanel();
		
		//center�� �� textfield ����
		JTextField name = new JTextField();
		JTextField id = new JTextField();
		JTextField department = new JTextField();
		
		//center�� �� radiobutton ����
		JRadioButton RB1 = new JRadioButton("Female");
		JRadioButton RB2 = new JRadioButton("Male");
		Gender_panel.setLayout(new GridLayout(1,2)); //���ٿ� 2�� �ֱ� ���� gridlayout ���
		Gender_panel.add(RB2); //�гο� ��ư �ø���
		Gender_panel.add(RB1);
		ButtonGroup bg = new ButtonGroup(); //�� ���� ��ư�� Ŭ���ǵ��� �ϱ� ���� ��ư �׷���
		bg.add(RB1);bg.add(RB2);
		RB1.setSelected(true); //female ��ư�� ���õǾ� �ֵ��� �ʱ�ȭ
		
		//���� �г�
		North_panel.add(new JLabel("STUDENT INFORMATION")); //�� �߰�
		North_panel.setAlignmentX(CENTER_ALIGNMENT); //��� ����
		add(North_panel, BorderLayout.NORTH); //sector�� ���ʿ� �г� ���

		//��� �г�
		Center_panel.setLayout(new GridLayout(4,2)); //gridlayout ���
		Center_panel.add(new JLabel("NAME")); //label�� textfield �߰�
		Center_panel.add(name);
		Center_panel.add(new JLabel("GENDER"));
		Center_panel.add(Gender_panel); //������ �����ص� gender panel ���
		Center_panel.add(new JLabel("ID"));
		Center_panel.add(id);
		Center_panel.add(new JLabel("DEPARTMENT"));
		Center_panel.add(department);
		add(Center_panel); //sector�� ����� �г� ���
		
		//�Ʒ����г�
		South_panel.add(new JButton("Save")); //��ư �߰�
		South_panel.add(new JButton("Cancel")); //��ư �߰�
		South_panel.setAlignmentX(CENTER_ALIGNMENT); //�ش� �г� ��� ����
		add(South_panel, BorderLayout.SOUTH); //sector�� �Ʒ��ʿ� �г� ���

	}
	
	public static void main(String[] args) {
		Week11_2_�弼�� lab2 = new Week11_2_�弼��(); //�ν��Ͻ� ����
		lab2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x���� ��� �����ϵ���
		lab2.setSize(350,200); //������ ����
		lab2.setVisible(true); //ȭ�鿡 �ش� �׸��� ���̵���
	}

}
