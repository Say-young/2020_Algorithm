package hw1;
import java.util.*;

public class HW1_1_장세영 {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		Time time = new Time(); //Time 인스턴스 생성
		int hour = 0, minute = 0; //입력 받을 변수 초기화
		
		//올바른 입력을 받을 때까지 반복
		while(true) {
			try {
				System.out.println("Hour:"); //시간 물어보고
				hour = scanner.nextInt(); //숫자 입력받기
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 숫자를 입력하십시오."); //만약 숫자가 아닌 다른 것을 입력받았을 경우 안내 메세지를 띄우고
				scanner.nextLine(); //버퍼 비운 후 입력 다시 받기
			}
		}
		
		while(true) {
			try {
				System.out.println("Minute:"); //분 물어보고
				minute = scanner.nextInt(); //숫자 입력받기
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 숫자를 입력하십시오.");//만약 숫자가 아닌 다른 것을 입력받았을 경우 안내 메세지를 띄우고
				scanner.nextLine();//버퍼 비운 후 입력 다시 받기
			}
		}
		
		time.setTime(hour,minute); //time객체에 시간과 분을 저장하는 메서드
		System.out.println(time.getHourOrMinute('h')+":"+time.getHourOrMinute('m')); //getHourOrMinute 메서드를 호출하여 시와 분 출력하기

	}

}
