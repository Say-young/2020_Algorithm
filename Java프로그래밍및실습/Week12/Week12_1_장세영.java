package asm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Week12_1_�弼�� extends JFrame{

	private JButton button; //���콺����Ϳ��� ���� �����ϵ��� ��ư�� ������ �ۿ��� ����
	
	public Week12_1_�弼��(){
		setTitle("�� ��ƺ�~��! - �弼��"); //frame title ����
		setSize(300,300); //frame ������ ����
		setResizable(false); //frame ������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x������ ���α׷� ����ǵ���
		JPanel panel = new JPanel(); //�г� ����
		button = new JButton("Click!"); //��ư ����
		button.addMouseListener(new myMouseEvent()); //���콺 �̺�Ʈ ������ ��ư�� �߰�
		panel.add(button); //�гο� ��ư �߰�
		add(panel, BorderLayout.CENTER); //�����̳� �߾ӿ� �г� �߰�
		setVisible(true); //â�� ���̵���
	}
	
	//���콺 �����(�ʿ��� �޼��常 ���� ����)
	class myMouseEvent extends MouseAdapter{
		
		//���콺�� button�� ���� �ȿ� ���� ���
		public void mouseEntered(MouseEvent e) {
			button.setLocation((int)(Math.random()*200),(int)(Math.random()*200)); //��ư ��ġ �������� �ٲ�. â ������ ������ �ʵ��� 200�� �ִ�� ����.
			int x = e.getX(); //��ư�� x��ǥ �޾Ƽ�
			int y = e.getY();//��ư�� y��ǥ �޾Ƽ�
			System.out.println("x = "+x+", y = "+y); //�ܼ�â�� ��ư�� ��ġ ���
		}
		
		//���콺�� button�� Ŭ������ ���
		public void mouseClicked(MouseEvent e) {
			System.out.println("��,,, �����٤Ф�"); //�ܼ�â�� �����ٴ� �޼��� ���
			mouseEntered(e);//Ŭ���� �� �ٷ� ��ư�� ������ �� �ֵ���
		}
	}
	
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		new Week12_1_�弼��(); //â ����
	}

}
