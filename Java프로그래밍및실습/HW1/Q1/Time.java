package hw1;
import java.util.*;

public class Time {
	/*
	System.out.println("=============");
	System.out.println("전공 : 컴퓨터공학");
	System.out.println("학번 : 1871047");
	System.out.println("성명 : 장세영");
	System.out.println("=============");
	*/
	
	//사용할 변수를 private으로 선언했으므로 getter와 setter 필요
	private int hour;
	private int minute;
	
	//입력된 시와 분이 범위 내에 있으면 true 반환
	private boolean isValid(int hour, int minute) {
		if(hour>=0 && hour<24 && minute>=0 && minute<60)
			return true;
		else
			return false;
	}
	
	//isValid 결과가 참이면 hour, minute 값을 저장
	public void setTime(int hour, int minute) {
		if(isValid(hour, minute)) {
			this.hour = hour;
			this.minute = minute;
		}
		else
			System.out.println("Wrong Input");
	}
	
	//시를 반환하는 메서드
	public int getHour() {
		return hour;
	}
	//분을 반환하는 메서드
	public int getMinute() {
		return minute;
	}
	
	
	//ch가 H 혹은 h면 hour를 반환하고 ch가 M 혹은 m이면 minute를 반환
	public int getHourOrMinute(char ch) {
		if(ch=='h' || ch=='H')
			return getHour();
		else if(ch=='m' || ch=='M')
			return getMinute();
		else
			return 0;
	}
	
}
