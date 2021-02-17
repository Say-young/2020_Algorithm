// y/n 익셉션 생각해보기

package hw3;
import java.util.*;

public class HW1_3_장세영 {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		String ch;
		String string;
		char Arr[] = new char[100];
		
		while(true) { //1번 반복문. n을 입력받기 전까지 전체 과정을 계속 반복
			System.out.println("Input a word");
			string = scanner.next(); //사용자에게 string을 입력받아
			Arr = string.toCharArray(); //charArray에 저장
			if(check(Arr)) { //대칭을 검사하는 메서드를 메인 밖에 따로 구현했음.
				System.out.println("symmetry"); //만약 대칭이라면 대칭 출력
			}
			else {
				System.out.println("Asymmetry"); //비대칭이라면 비대칭 출력
			}
			scanner.nextLine(); //다음 입력을 위해 버퍼 비우기
			
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
	}
	
	//대칭을 검사하는 메서드. 참/거짓을 결과로 반환
	public static boolean check(char[] Arr) { //배열의 주소를 파라미터로 받아옴
		for(int i=0; i<Arr.length/2; i++) { //배열의 길이의 절반(전체 원소의 개수가 홀수일경우 절반에서 내림한 곳)까지 반복
			char s = Arr[i]; //s에는 앞에서부터 차례대로 배열의 원소를 대입하고
			char e = Arr[Arr.length-1-i]; //e에는 뒤에서부터 차례대로 배열의 원소를 대입한다
			if(s==e) //만약 앞과 뒤의 원소들이 중앙으로 올 때까지 모두 짝을 이룬다면
				return true; //true 반환 = 대칭
			else
				return false;//아니라면 false 반환
		}
		return false; //기본은 false를 반환하도록 설정했음.
	}
}
