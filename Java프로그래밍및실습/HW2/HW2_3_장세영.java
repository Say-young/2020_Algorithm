package hw2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HW2_3_�弼�� extends JFrame implements ActionListener{
	
	//�ʿ��� ��ҵ� ����
	private JPanel panel1, panel2;
	private JButton[] buttons;
	private JButton BtnPlus, BtnMinus, BtnProduct, BtnDivide, BtnResult, BtnNew;
	private JTextField textfield;
	private int op;
	private String first;
	
	//������
	HW2_3_�弼��(){
		setTitle("Calculator"); //������ Ÿ��Ʋ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X������ ���α׷� ����ǵ���
		
		textfield = new JTextField(25); //�Է�â ũ�� ����
		textfield.setHorizontalAlignment(JTextField.RIGHT); //�����ʺ��� �Է� �޵���
		
		panel1 = new JPanel(); //textfield �ø� �г� ����
		panel1.add(textfield); //�гο� �ø���
		
		panel2 = new JPanel(new GridLayout(0,4)); //��ư���� �� panel�� girdlayout���� ����(����Ʈ�� flow��)
		buttons = new JButton[10]; //��ư 10���� ���� �� �ִ� �迭 ����
		for(int i=0; i<buttons.length; i++) { //0~9������ ��ư�� �ѹ��� �����ϰ� ActionListener ���̱�
			buttons[i] = new JButton(Integer.toString(i));
			buttons[i].addActionListener(this);
		}
		//���ڰ� �ƴ� ���� ��ư�� ����
		BtnPlus = new JButton("+");
		BtnMinus = new JButton("-");
		BtnProduct = new JButton("*");
		BtnDivide = new JButton("/");
		BtnResult = new JButton("=");
		BtnNew = new JButton("New");
		//���� ��ư�� �׼� ������ ���̱�
		BtnPlus.addActionListener(this);
		BtnMinus.addActionListener(this);
		BtnProduct.addActionListener(this);
		BtnDivide.addActionListener(this);
		BtnResult.addActionListener(this);
		BtnNew.addActionListener(this);
		
		//������� �гο� ��ư�� ���̱�
		panel2.add(buttons[7]);
		panel2.add(buttons[8]);
		panel2.add(buttons[9]);
		panel2.add(BtnDivide);
		panel2.add(buttons[4]);
		panel2.add(buttons[5]);
		panel2.add(buttons[6]);
		panel2.add(BtnProduct);
		panel2.add(buttons[1]);
		panel2.add(buttons[2]);
		panel2.add(buttons[3]);
		panel2.add(BtnMinus);
		panel2.add(BtnNew);
		panel2.add(buttons[0]);
		panel2.add(BtnResult);
		panel2.add(BtnPlus);
		
		//�г��� frame�� ���̱�
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		
		pack(); //������ ������ ���� �������Ƿ� ��
		setVisible(true); //�������� ȭ�鿡 ���̵���
	}

	
	//�̺�Ʈ �ڵ鸵 �޼���
	public void actionPerformed(ActionEvent e) {
		
		//0~9������ ���� �ش��ϴ� ��ư�� ������ �� textfield�� �ش� ���� ��µǵ��� �ϴ� �޼���
		for(int i=0; i<buttons.length; i++) {
			if(e.getSource() == buttons[i]){
				if(textfield.getText().equals("0")){
					textfield.setText(""+i);
				}else {
					textfield.setText(""+i);
				}
			}
		}

		//�� �����ư�� ������ �� �۵��ϴ� �޼���
		if(e.getSource() == BtnPlus){ //���ϱ� ��ư�� ������
			first=textfield.getText(); //first�� �Է¹��� string�� �״�� �����Ѵ�
			op=1; //op 1�� ���Ƿ� ���ϱ�� ���Ѵ�
		}else if(e.getSource() == BtnMinus){//���� ��ư�� ������
			first=textfield.getText();
			op=2;//op 2�� ���Ƿ� ����� ���Ѵ�
		}else if(e.getSource() == BtnProduct){//���ϱ� ��ư�� ������
			first=textfield.getText();
			op=3;//op 3�� ���Ƿ� ���ϱ�� ���Ѵ�
		}else if(e.getSource() == BtnDivide){//������ ��ư�� ������
			first=textfield.getText();
			op=4;//op 4�� ���Ƿ� ������� ���Ѵ�
		}
		
		//�ʱ�ȭ ��ư�� ������
		if(e.getSource() == BtnNew){ 
			first=""; //first ������ �ʱ�ȭ
			textfield.setText(""); //�ƹ��͵� ����� �ʴ´�
		}
		//��� ��ư�� ������
		if(e.getSource() == BtnResult){
			int num1, num2; double result; //��� �Լ� ������ ����� ������
			num1 = Integer.parseInt(first); //num1�� ������ ��Ƶ״� first�� ������ int�� �޾ƿ´�
			num2 = Integer.parseInt(textfield.getText()); //num2�� textfield�� ������ int�� �޾ƿ´�
			if(op==1){ //���ϱ�
				result = num1 + num2;
				textfield.setText("" + result); //���ϱ��� ��� ���
			}else if(op==2){ //����
				result = num1 - num2;
				textfield.setText("" + result); //������ ��� ���
			}else if(op==3){ //���ϱ�
				result = num1 * num2;
				textfield.setText("" + result); //���ϱ��� ��� ���
			}else if(op==4){ //������
				result = (double)num1 / num2;
				textfield.setText("" + result); //�������� ��� ���
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
		
		HW2_3_�弼�� myframe = new HW2_3_�弼��(); //������ ����!
	}

}
