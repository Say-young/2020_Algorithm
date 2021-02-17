package week1;
import java.util.Scanner;
public class Week1_3_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : Computer Engineering");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		//첫문장 입력받기
		Scanner text = new Scanner(System.in);
		System.out.println("Enter a line of text.");
		String a = text.nextLine();
		
		//입력받은 원래 문장 보여주기. 큰따옴표를 출력하기 위해서는 백슬래쉬를 사용해야 한다.
		System.out.println("Your text is \""+a+"\"");
		
		//바꿀 단어 입력받기
		System.out.println("Input a word to replace.");
		String b = text.nextLine();
		
		//새로운 단어 입력받기
		System.out.println("Input a word to insert.");
		String c = text.nextLine();
		
		//기존 단어를 새로운 단어로 대체
		String d = a.replaceFirst(b, c);
		
		//새로운 문장 출력. 모든 문자를 대문자로 변경하기
		System.out.println("New Sencence is \""+d.toUpperCase()+"\"");
		
		//문장의 길이를 표현하는 length 메소드
		System.out.println("The length of \""+d.toUpperCase()+"\" is "+ a.length() + ".");
	}
}
