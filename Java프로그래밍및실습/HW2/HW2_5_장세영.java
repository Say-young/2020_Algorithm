package hw2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HW2_5_�弼�� extends JFrame{
	
	//�ʿ��� ��ҵ� �̸� ����(�Ʒ����� �ٸ� �Լ��� innerclass���� ���̴� ��쵵 �����Ƿ� ������ �ۿ� ����)
		mypaint panel1; Panel panel2;
		JTextField text1, text2, text3, text4;
		JLabel label1, label2, label3, label4;
		JButton button;
		int Kim, Lee, Park, Etc, judge;
		
		//������
		HW2_5_�弼��(){
			Toolkit tk = getToolkit(); //getToolkit()�޼���� Component�� ���ǵǾ� ����
			Dimension d = tk.getScreenSize(); //��ũ�� ������ �޾ƿ���
			int screenWidth = d.width; //��ũ�� ���� ���� �޾ƿ���
			int	screenHeight = d.height; //��ũ�� ���� ���� �޾ƿ���
			setSize(520,460); //������ ũ�� ����
			setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2); //â�� ��ũ�� �Ѱ�� �ߵ��� ��ġ ����
			setTitle("Pie Chart of Student names - �弼��"); //������ Ÿ��Ʋ ����
			setDefaultCloseOperation(EXIT_ON_CLOSE); //X������ ���α׷� ����ǵ���
			
			panel1 = new mypaint(); //panel�� extends�� innerclass�� instance ����
			panel2 = new Panel();
			
			//�ʿ��� �󺧰� �ؽ�Ʈ�ʵ� �����
			label1 = new JLabel("Kim");
			text1 = new JTextField(5);
			label2 = new JLabel("Lee");
			text2 = new JTextField(5);
			label3 = new JLabel("Park");
			text3 = new JTextField(5);
			label4 = new JLabel("Etc");
			text4 = new JTextField(5);
			button = new JButton("Graph");
			button.addActionListener(panel1);
			
			//��ҵ��� �гο� ���̰�
			panel2.add(label1);
			panel2.add(text1);
			panel2.add(label2);
			panel2.add(text2);
			panel2.add(label3);
			panel2.add(text3);
			panel2.add(label4);
			panel2.add(text4);
			panel2.add(button);
			add(panel1, BorderLayout.CENTER); //�׸��� ������ ���Ϳ�
			add(panel2, BorderLayout.SOUTH); //������ ��ҵ��� ������ �Ʒ��� ����
			setVisible(true);//������ ���̰� �ϱ�
		}
		
		//innerclass�� ������
		private class mypaint extends Panel implements ActionListener{
		public void paint(Graphics g) {
			
			//�Ͼ� ��� �׸�
			Color c = Color.white;
			g.setColor(c);
			g.fillRect(0, 0, 520, 460);
			
			switch(judge) {
				case 0 : //�� ó���� �����ϴ� ȭ��(�ʷϻ� ���� �׷����� �� �����ϱ� ���� ���� ����)
						c = Color.yellow;
						g.setColor(c);
						g.drawString("YELLOW: KIMs", 360, 180); //���� ��µǴ� ����
						c = Color.red;
						g.setColor(c);
						g.drawString("RED: LEEs", 360, 200);//���� ��µǴ� ����
						c = Color.blue;
						g.setColor(c);
						g.drawString("BLUE: PARKs", 360, 220);//���� ��µǴ� ����
						c = Color.green;
						g.setColor(c);
						g.drawString("GREEN: Etcs", 360, 240);//���� ��µǴ� ����
						break;
				case 1://�������� �Է��� �޾��� ���
						//�达�� �ش��ϴ� ��ҵ��� yellow�� �׸�
						c = Color.yellow;
						g.setColor(c);
						g.drawString("YELLOW: KIMs", 360, 180); //���� ��µǴ� ����
						g.fillArc(130, 100, 200, 200, 0, (int)(Kim*3.6)); //������Ʈ �׸�
					
						//�达�� �ش��ϴ� ��ҵ��� red�� �׸�
						c = Color.red;
						g.setColor(c);
						g.drawString("RED: LEEs", 360, 200);//���� ��µǴ� ����
						g.fillArc(130, 100, 200, 200, (int)(Kim*3.6), (int)(Lee*3.6));//������Ʈ �׸�
					
						//�达�� �ش��ϴ� ��ҵ��� blue�� �׸�
						c = Color.blue;
						g.setColor(c);
						g.drawString("BLUE: PARKs", 360, 220);//���� ��µǴ� ����
						g.fillArc(130, 100, 200, 200, ((int)(Kim*3.6)+(int)(Lee*3.6)), (int)(Park*3.6));//������Ʈ �׸�
					
						//�达�� �ش��ϴ� ��ҵ��� green�� �׸�
						c = Color.green;
						g.setColor(c);
						g.drawString("GREEN: Etcs", 360, 240);//���� ��µǴ� ����
						g.fillArc(130, 100, 200, 200, ((int)(Kim*3.6)+(int)(Lee*3.6)+(int)(Park*3.6)), 360-((int)(Kim*3.6)+(int)(Lee*3.6)+(int)(Park*3.6)));//������Ʈ �׸�
						break;
				case 2://�Է¹��� �� ���� ���� 100�� ���� ���
						g.setColor(Color.black);
						g.drawString("Number of students is 100.", 180, 360);
						break;
				case 3://���ڰ� �ƴ� ���� �Է¹޾��� ���
						g.setColor(Color.black);
						g.drawString("Input numbers of students names.", 170, 360);	
						break;
			}
		}
		
		//actionlistener �޼��� �������̵�
		public void actionPerformed(ActionEvent e) {
			try {
				//���� ���� string�̹Ƿ� int�� �����ؼ� ����
				Kim = Integer.parseInt(text1.getText());
				Lee = Integer.parseInt(text2.getText());
				Park = Integer.parseInt(text3.getText());
				
				//���� �Է¹��� ������ ������ ����ٸ�
				if((Kim+Lee+Park)>100) {
					judge = 2; //paint �޼��忡�� case�� ������ ���� judge�Լ��� ��Ȳ���� ���� ���� ������ ���� ����. 1�� ������ ��� ���� �Է� �޾��� ���
					Kim = Lee = Park = Etc = 0;//�׷��� ������� ����
					repaint();//�׸� �׸���
				}else { //�������� �Է��� �޾Ҵٸ�
					judge = 1;
					Etc = 100-(Kim+Lee+Park);//etc ����ؼ�
					text4.setText(Integer.toString(Etc)); //ȭ�鿡 etc ���� ������ְ�
					repaint(); //�׸��׸���
				}
			}catch(NumberFormatException a){//������ ��ȯ�� �� ���� ������ �Է��� �޾Ҵٸ�
				judge = 3;
				Kim = Lee = Park = Etc = 0;//�׷��� ������� ����
				repaint();//�׸� �׸���
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

		HW2_5_�弼�� myframe = new HW2_5_�弼��();//������ ����!
	}

}

