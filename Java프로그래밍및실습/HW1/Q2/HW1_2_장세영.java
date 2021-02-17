// y/n 익셉션 생각해보기

package hw2;
import java.util.*;

public class HW1_2_장세영 {

	public static void main(String[] args) {

		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		String ch; // y/n에 사용할 변수 선언
		DiceGame dicegame = new DiceGame(); //인스턴스 생성
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("<< GAME START >>");
		while(true) { //1번반복문. n을 입력받기 전까지 계속 반복
			System.out.println("Dice is rolled!!!");
			dicegame.startPlaying();//해당 메서드에 정의되어 있던 모든 메서드 작동
			while(true) { //2번 반복문. try again에 제대로 된 값을 받았을 때 빠져나가는 반복문
			try {
			System.out.println("Try agian?(y/n)");
			ch = scanner.nextLine(); //값을 입력받음
			if(ch.equalsIgnoreCase("n")||ch.equalsIgnoreCase("y")){ //만약 그 값이 n이나 y(즉 올바른 값이라면) 2번 반복문 빠져나감
				System.out.println("");
				break;
				}
			else if(!ch.equalsIgnoreCase("n")&&!ch.equalsIgnoreCase("y")) // n이나 y로 값을 입력받지 않았을 때
				throw new Exception("y 혹은 n을 입력해주세요");//에러 throw
			}catch(Exception e) {
				System.out.println(e.getMessage()); //y 또는 n을 입력하라는 메세지를 띄운 후 2번 반복문 다시 반복
			}
			}if(ch.equalsIgnoreCase("n")) //y일 경우에는 1번 반복문을 나가지 않고 계속 반복, n일 경우에는 1번 반복문도 빠져나가 종료
				break;
		}
		System.out.println("Game finished.");

	}

}
