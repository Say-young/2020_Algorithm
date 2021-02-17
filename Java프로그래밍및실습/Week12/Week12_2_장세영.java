package asm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Week12_2_�弼�� extends JFrame implements ActionListener{
	
	Color color = Color.RED; //�⺻ ������ red�� ����
	
	JRadioButton RB1 = new JRadioButton("RED"); //���� ��ư 3�� ����. �޼��忡�� �����ؾ��ϱ� ������ ������ �ۿ� ����
	JRadioButton RB2 = new JRadioButton("GREEN");
	JRadioButton RB3 = new JRadioButton("BLUE");
	
	//������
	public Week12_2_�弼��() {
		Toolkit tk = getToolkit(); //getToolkit()�޼���� Component�� ���ǵǾ� ����
		Dimension d = tk.getScreenSize(); //��ũ�� ������ �޾ƿ���
		int screenWidth = d.width; //��ũ�� ���� ���� �޾ƿ���
		int	screenHeight = d.height; //��ũ�� ���� ���� �޾ƿ���
		setSize(500,350); //��� â�� �ʺ�� ���� ����
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2); //â�� ��ũ�� �Ѱ�� �ߵ��� ��ġ ����
		setTitle("MyCar - �弼��");//â Ÿ��Ʋ ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);//X������ ���α׷� ���� �ǵ���
		
		JPanel panel = new JPanel();
		ButtonGroup bg = new ButtonGroup(); //��ư �׷� ����
		bg.add(RB1); bg.add(RB2); bg.add(RB3); //���� ��ư�� �� �߿� �ϳ��� ���� �����ϵ��� �׷쿡 �߰�
		RB1.setSelected(true); //red��ư�� ó���� ���õǾ� �ֵ��� ����
		JButton button = new JButton("Paint"); //��ư ����
		button.addActionListener(this); //��ư�� �׼Ǹ����� �߰�
		panel.add(RB1); panel.add(RB2); panel.add(RB3); panel.add(button); //�гο� ��� �ø���
		add(panel, BorderLayout.SOUTH);//�����̳� ���ʿ� �ش� �г� ���̱�
		setVisible(true); //â�� ���̵���
	}
	
	//�����ϸ� �׷����� paint �޼���
	public void paint(Graphics g) {
		g.setColor(color);//�� ó�� ���� red
		g.fillRect(180, 80, 140, 60); //�� ������ ��ġ�� width height ����
		g.fillRect(110, 140, 280, 100);
		
		Color c = Color.lightGray;
		g.setColor(c);//���� ���� lightGray�� ����
		g.fillOval(150, 200,80, 80); //�� ������ ��ġ�� �ʺ� ����
		g.fillOval(270, 200,80, 80);
		
		c = Color.BLACK;
		g.setColor(c);//���� ���� ���� black���� ����
		g.drawArc(250, 110, 80, 150, 60,63); //���� �� �׸���. ���� ��Ƽ� ���� �� ���� �׸�
		g.drawArc(250, 109, 80, 150, 60,63);
		g.drawArc(249, 110, 80, 150, 60,63);
	}
	
	//� ���� ��ư�� �����ϴ��Ŀ� ���� �ڵ����� ���� �ٲ�� �����ϴ� �޼���
	public void actionPerformed(ActionEvent e) {
		if(RB1.isSelected()) { //red ��ư�� ���õǾ����� ���
			color = Color.RED; //��ü�� color�� red�� ����
		}else if(RB2.isSelected()) {//green ��ư�� ���õǾ����� ���
			color = color.GREEN;//��ü�� color�� green���� ����
		}else if(RB3.isSelected()) {//blue ��ư�� ���õǾ����� ���
			color = color.BLUE;//��ü�� color�� blue�� ����
		}
		repaint(); //�� ������ �� repaint() �ʼ�
	}
	
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		new Week12_2_�弼��(); //â ����
	}

}
