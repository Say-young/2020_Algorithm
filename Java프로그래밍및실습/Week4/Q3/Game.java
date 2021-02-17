package lab;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	int user = 0, computer=0; //가위바위보 값이 저장될 변수 선언과 초기화
	int usercount = 0, comcount =0; //이긴 횟수를 저장할 변수 선언과 초기화
	
	
	
	public void start(){
		System.out.println("가위바위보게임을 시작합니다.\n");
		do {
			input();//값 입력받기
			compare(); //값 비교하기
			writeOutput(); //매번 결과 출력
		}while(usercount !=3 && comcount!=3); // 이긴 횟수가 3번이 될 때까지 반복
		
		//최종 결과 출력
		if(usercount == 3)
			System.out.println("당신이 이겼습니다.");
		else
			System.out.println("당신이 졌습니다.");
		
		//게임 종료
		System.out.println("게임을 종료합니다.");
	}
	

	
	
	//사용자의 값을 입력받는 메서드
	public void input() {
		Scanner scanner = new Scanner(System.in);
		boolean a;
		do {
			try {
				System.out.println("당신의 선택은?");
				System.out.println("가위(1) 바위(2) 보(3)");
				user = scanner.nextInt(); //사용자의 입력값을 받음
				a = false;//a값 초기화. 옳은 값을 받을 경우 반복문을 빠져나가기 위함.
				if(user<1 || user>3)//만약 사용자의 입력 값이 숫자이긴 하나 범위를 벗어났다면 오류 메세지 출력
					throw new Exception("범위가 잘못되었습니다.\n");
			}
			catch(InputMismatchException e) {
				System.out.println("범위가 잘못되었습니다.\n"); //숫자가 아닌 다른 값을 입력받았을 경우
				scanner.nextLine();
				a = true; //true로 바꿀 경우 while문의 반복 조건이 달성되기 떄문에 다시 입력받을 수 있다
			}
			catch(Exception e) {
				System.out.println(e.getMessage());//입력받은 숫자 범위가 잘못되었을 경우 오류 메세지 출력
				a = true;//true로 바꿀 경우 while문의 반복 조건이 달성되기 떄문에 다시 입력받을 수 있다
			}
		}while(a);//잘못된 범위 입력시 올바른 값을 받을 때까지 반복
	}
	
	
	
	
	
	//사용자 입력과 컴퓨터 값 비교하기 - 승부 카운터 계산
	public void compare() {
		computer = (int)(Math.random()*3)+1; //컴퓨터의 랜덤 가위바위보 선택
		
		if(user == 1) {
			//사용자가 가위를 냈을 때
			switch(computer) {
				case 2:
					comcount++;
					break;
				case 3:
					usercount++;
					break;
				default:
					break;
			}
		}
		else if(user ==2) {
			//사용자가 바위를 냈을 때
			switch(computer) {
				case 1:
					usercount++;
					break;
				case 3:
					comcount++;
					break;
				default:
					break;
			}
		}
		else {
			//사용자가 보를 냈을 때
			switch(computer) {
				case 1:
					comcount++;
					break;
				case 2:
					usercount++;
					break;
				default:
					break;
			}
		}
		
	}
	
	
	
	
	
	//결과 출력
	public void writeOutput(){
		if(user == 1) {
			//사용자가 가위를 냈을 때
			switch(computer) {
				case 1:
					System.out.println("비김\n");
					break;
				case 2:
					System.out.println("컴퓨터 승\n");
					break;
				case 3:
					System.out.println("당신 승\n");
					break;
				default : 
					break;
			}
		}
		else if(user ==2) {
			//사용자가 바위를 냈을 때
			switch(computer) {
				case 1:
					System.out.println("당신 승\n");
					break;
				case 2 :
					System.out.println("비김\n");
					break;
				case 3:
					System.out.println("컴퓨터 승\n");
					break;
				default : 
					break;
			}
		}
		else {
			//사용자가 보를 냈을 때
			switch(computer) {
				case 1:
					System.out.println("컴퓨터 승\n");
					break;
				case 2:
					System.out.println("당신 승\n");
					break;
				case 3:
					System.out.println("비김\n");
					break;
				default : 
					break;
			}
		}
	}
}
