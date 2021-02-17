package hw1;
import java.util.*;

public class Time {
	/*
	System.out.println("=============");
	System.out.println("���� : ��ǻ�Ͱ���");
	System.out.println("�й� : 1871047");
	System.out.println("���� : �弼��");
	System.out.println("=============");
	*/
	
	//����� ������ private���� ���������Ƿ� getter�� setter �ʿ�
	private int hour;
	private int minute;
	
	//�Էµ� �ÿ� ���� ���� ���� ������ true ��ȯ
	private boolean isValid(int hour, int minute) {
		if(hour>=0 && hour<24 && minute>=0 && minute<60)
			return true;
		else
			return false;
	}
	
	//isValid ����� ���̸� hour, minute ���� ����
	public void setTime(int hour, int minute) {
		if(isValid(hour, minute)) {
			this.hour = hour;
			this.minute = minute;
		}
		else
			System.out.println("Wrong Input");
	}
	
	//�ø� ��ȯ�ϴ� �޼���
	public int getHour() {
		return hour;
	}
	//���� ��ȯ�ϴ� �޼���
	public int getMinute() {
		return minute;
	}
	
	
	//ch�� H Ȥ�� h�� hour�� ��ȯ�ϰ� ch�� M Ȥ�� m�̸� minute�� ��ȯ
	public int getHourOrMinute(char ch) {
		if(ch=='h' || ch=='H')
			return getHour();
		else if(ch=='m' || ch=='M')
			return getMinute();
		else
			return 0;
	}
	
}
