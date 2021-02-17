package hw2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HW2_4_�弼�� extends JFrame{
	
	//�ʿ��� ��ҵ� �̸� ����(�Ʒ����� �ٸ� �Լ��� innerclass���� ���̴� ��쵵 �����Ƿ� ������ �ۿ� ����)
	JLabel label1, label2, label3, label4;
	JTextField text1, text2, text3;
	JButton button;
	mypaint panel1; JPanel panel2;
	int kor=0, eng=0, math=0, judge;
	
	//������
	HW2_4_�弼��(){
		Toolkit tk = getToolkit(); //getToolkit()�޼���� Component�� ���ǵǾ� ����
		Dimension d = tk.getScreenSize(); //��ũ�� ������ �޾ƿ���
		int screenWidth = d.width; //��ũ�� ���� ���� �޾ƿ���
		int	screenHeight = d.height; //��ũ�� ���� ���� �޾ƿ���
		setSize(500,390); //��� â�� �ʺ�� ���� ����
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2); //â�� ��ũ�� �Ѱ�� �ߵ��� ��ġ ����
		setTitle("Score Graph");//Ÿ��Ʋ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);//X ������ ���α׷� ����ǵ���
		
		panel1 = new mypaint(); //panel�� extends�� innerclass�� instance ����
		panel2 = new JPanel();
		
		//�ʿ��� �󺧰� �ؽ�Ʈ�ʵ� �����
		label1 = new JLabel("Kor");
		text1 = new JTextField(5);
		label2 = new JLabel("Eng");
		text2 = new JTextField(5);
		label3 = new JLabel("Math");
		text3 = new JTextField(5);		
		button = new JButton("Show Graph");
		button.addActionListener(panel1); //��ư�� actionlistener ���̱�. panel1�� actionlistener implements �Ǿ� ����
		
		//��ҵ��� �гο� ���̰�
		panel2.add(label1);
		panel2.add(text1);
		panel2.add(label2);
		panel2.add(text2);
		panel2.add(label3);
		panel2.add(text3);
		panel2.add(button);
		add(panel1, BorderLayout.CENTER); //�׸��� ������ ���Ϳ�
		add(panel2, BorderLayout.SOUTH); //������ ��ҵ��� ������ �Ʒ��� ����
		setVisible(true); //������ ���̰� �ϱ�
	}
	
	//innerclass�� ������
	private class mypaint extends Panel implements ActionListener{
		public void paint(Graphics g) {	
			//�Ͼ� ��� �׸�
			g.setColor(Color.white);
			g.fillRect(0, 0, 500, 390);
			
			//�ʿ��� �� �׸�
			g.setColor(Color.black);
			g.drawLine(110, 60, 400, 60);
			g.drawLine(110, 80, 400, 80);
			g.drawLine(110, 100, 400, 100);
			g.drawLine(110, 120, 400, 120);
			g.drawLine(110, 140, 400, 140);
			g.drawLine(110, 160, 400, 160);
			g.drawLine(110, 180, 400, 180);
			g.drawLine(110, 200, 400, 200);
			g.drawLine(110, 220, 400, 220);
			g.drawLine(110, 240, 400, 240);
			g.drawLine(110, 260, 400, 260);
			g.drawLine(110, 50, 110, 260);
			
			//���� ���� �׸�
			g.drawString("100", 85, 65);
			g.drawString("90", 90, 85);
			g.drawString("80", 90, 105);
			g.drawString("70", 90, 125);
			g.drawString("60", 90, 145);
			g.drawString("50", 90, 165);
			g.drawString("40", 90, 185);
			g.drawString("30", 90, 205);
			g.drawString("20", 90, 225);
			g.drawString("10", 90, 245);
			
			//�Ʒ� ���� �̸� �׸�
			g.drawString("KOR", 150, 280);
			g.drawString("ENG", 250, 280);
			g.drawString("MATH",345, 280);
			
			switch(judge) {
				case 0://�Է¹��� ������ ���� �׷����� �׸�
					g.setColor(Color.red);
					g.fillRect(155, 260-kor*2, 10, kor*2); //���� 260�̾���ϱ� ������ ������ ������ ����
					g.fillRect(255, 260-eng*2, 10, eng*2);
					g.fillRect(355, 260-math*2, 10, math*2);
					break;
				case 1://�߸��� �Է��� ���� ��� ����� �޼���
					g.setColor(Color.black);
					g.drawString("Wrong Input", 220, 40);
					break;
			}
		}
		
		//actionlistener �޼��� �������̵�
		public void actionPerformed(ActionEvent e) {
			try {
				//���� ���� string�̹Ƿ� int�� �����ؼ� ����
				kor = Integer.parseInt(text1.getText());
				eng = Integer.parseInt(text2.getText());
				math = Integer.parseInt(text3.getText());

				//���� �Է¹��� ������ ������ ����ٸ�
				if(kor<0||kor>100||eng<0||eng>100||eng<0||eng>100){
					judge = 1;//���� �޼��� ����ϰ�
					kor = eng = math = 0; //�׷��� ������� ����
					repaint(); //�׸� �׸���
				}else { //�������� �Է��� �޾Ҵٸ�
					judge = 0;//���� �޼��� ��� �� �ϰ�
					repaint(); //�׸� �׸���
				}
			}catch(NumberFormatException a) { //������ ��ȯ�� �� ���� ������ �Է��� �޾Ҵٸ�
				judge = 1; //���� �޼��� ����ϰ�
				kor = eng = math = 0; //�׷��� ������� �ʱ�
				repaint(); //�׸� �׸���
			}
		}
	}

	//���� �޼���
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		HW2_4_�弼�� t = new HW2_4_�弼��(); //������ ����!
	}

}
