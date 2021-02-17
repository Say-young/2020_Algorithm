package hw2;
import java.util.*;

public class DiceGame {
	/*
	System.out.println("=============");
	System.out.println("전공 : 컴퓨터공학");
	System.out.println("학번 : 1871047");
	System.out.println("성명 : 장세영");
	System.out.println("=============");
	*/
	
	//사용할 변수를 private으로 선언했으므로 getter와 setter 필요
	private int diceFace;
	private int userGuess;
	
	//주사위의 수를 랜덤으로 결정하는 메서드
	private int rollDice() {
		int randnum = (int)(Math.random()*6)+1;
		return randnum;
	};
	
	//사용자에게 수를 입력받는 메서드
	private void setUserInput() {
		int num;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Guess the number! What do you think?");
		while(true) { //올바른 값을 입력받을 때까지 반복
			try {
				num = scanner.nextInt();
				if(num>=1 && num<=6) {
					userGuess = num;
					break; //범위에 맞는 수를 입력받으면 num에 저장 후에 반복문을 빠져나감
				}
				else
					System.out.println("Input number between 1~6."); //아니라면 안내메세지를 띄우고 다시 재입력받음
			}catch(InputMismatchException e) {
				System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요."); //숫자가 아닌 것을 입력받았을 경우 안내메세지를 띄우고 다시 재입력받음
				scanner.nextLine();//버퍼비우기
			}
		}
	}
	
	//랜덤으로 굴려서 나온 주사위의 수와 사용자가 입력한 값이 같은지 다른지 비교한 후에 각각에 맞는 메세지를 출력하는 메서드
	private void checkUserGuess() {
		if(diceFace==userGuess)
			System.out.println("Bingo!");
		else
			System.out.println("Wrong!");
	}
	
	//동일 클래스 내에서는 private에 자유롭게 접근 가능. 이 메서드를 public으로 선언했기 때문에 메인에서 활용이 가능하다. 
	public void startPlaying() {
		diceFace = rollDice();//diceFace엔 rollDice()로 구한 랜덤한 값 대입
		setUserInput();//사용자에게 값 입력 받고
		checkUserGuess();//같은지 다른지 비교
		System.out.println("The face was "+diceFace);//주사위의 눈이 뭐였는지 알려주기
	}
}
