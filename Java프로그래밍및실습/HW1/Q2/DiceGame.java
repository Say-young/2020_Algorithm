package hw2;
import java.util.*;

public class DiceGame {
	/*
	System.out.println("=============");
	System.out.println("���� : ��ǻ�Ͱ���");
	System.out.println("�й� : 1871047");
	System.out.println("���� : �弼��");
	System.out.println("=============");
	*/
	
	//����� ������ private���� ���������Ƿ� getter�� setter �ʿ�
	private int diceFace;
	private int userGuess;
	
	//�ֻ����� ���� �������� �����ϴ� �޼���
	private int rollDice() {
		int randnum = (int)(Math.random()*6)+1;
		return randnum;
	};
	
	//����ڿ��� ���� �Է¹޴� �޼���
	private void setUserInput() {
		int num;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Guess the number! What do you think?");
		while(true) { //�ùٸ� ���� �Է¹��� ������ �ݺ�
			try {
				num = scanner.nextInt();
				if(num>=1 && num<=6) {
					userGuess = num;
					break; //������ �´� ���� �Է¹����� num�� ���� �Ŀ� �ݺ����� ��������
				}
				else
					System.out.println("Input number between 1~6."); //�ƴ϶�� �ȳ��޼����� ���� �ٽ� ���Է¹���
			}catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է� �����մϴ�. �ٽ� �Է����ּ���."); //���ڰ� �ƴ� ���� �Է¹޾��� ��� �ȳ��޼����� ���� �ٽ� ���Է¹���
				scanner.nextLine();//���ۺ���
			}
		}
	}
	
	//�������� ������ ���� �ֻ����� ���� ����ڰ� �Է��� ���� ������ �ٸ��� ���� �Ŀ� ������ �´� �޼����� ����ϴ� �޼���
	private void checkUserGuess() {
		if(diceFace==userGuess)
			System.out.println("Bingo!");
		else
			System.out.println("Wrong!");
	}
	
	//���� Ŭ���� �������� private�� �����Ӱ� ���� ����. �� �޼��带 public���� �����߱� ������ ���ο��� Ȱ���� �����ϴ�. 
	public void startPlaying() {
		diceFace = rollDice();//diceFace�� rollDice()�� ���� ������ �� ����
		setUserInput();//����ڿ��� �� �Է� �ް�
		checkUserGuess();//������ �ٸ��� ��
		System.out.println("The face was "+diceFace);//�ֻ����� ���� �������� �˷��ֱ�
	}
}
