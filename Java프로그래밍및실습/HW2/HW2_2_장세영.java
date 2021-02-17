package hw2;
import java.util.*;


public class HW2_2_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		String input = null; //while문의 조건으로 이용하기 위해 밖에서 선언
		ArrayList<Character>list = new ArrayList<Character>();
		LinkedList<Character>stack = new LinkedList<Character>(); //linkedlist로 스택 생성

		while(true) {
		System.out.print("\nInput : ");
		input = scanner.nextLine(); //사용자에게 입력받음
		if(input.equals("0")) break; //사용자가 0을 입력시 반복문 종료
		
			if(check(input, list, stack)==true) { //TRUE를 리턴받았을 경우에만
				System.out.println("Correct"); //CORRECT 메세지 출력
			}else {
				stack.clear();
				list.clear();
			}
		}
		System.out.println("Program finished"); //종료시 메세지 출력
	}
	
	//보기에 깔끔하도록 스택처리 부분을 별도의 메서드로 정의함
	public static boolean check (String input, List<Character>list, LinkedList<Character>stack) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
				
				for(int i=0; i<input.length(); i++) {//input 길이만큼 반복
					list.add(input.charAt(i)); //받은 한 줄의 모든 내용을 하나씩 잘라 배열에 저장
				}
				
				for(int i=0; i<input.length(); i++) { //배열의 길이만큼 반복
					if(list.get(i)=='{' || list.get(i)=='(' || list.get(i)=='[') {
						stack.addLast(list.get(i)); //만약 여는 괄호에 해당한다면 stack에 push
					}
					
					
					else if(list.get(i)=='}' || list.get(i)==')' || list.get(i)==']') { //만약 i번째 원소가 닫는 괄호에 해당한다면
						if(stack.isEmpty()) { //그런데 스택이 비어있다면
							System.out.println("Incorrect"); //incorrect 메세지 출력하고
							return false; //false 반환하기
						}
						else {
							char last = stack.removeLast(); //만약 닫는 괄호에 해당한다면 stack에서 top의 원소 pop
							if((last=='{')&&(list.get(i)!='}') || (last=='(')&&(list.get(i)!=')') || (last=='[')&&(list.get(i)!=']')) { //그런데 만약 쌍이 맞지 않다면
								System.out.println("Incorrect"); //incorrect 메세지 출력하고
								return false; //false 반환하기
							}
						}
					}else {
						System.out.println("Wrong Input");//6개의 괄호에 해당하지 않음
						return false;//false 반환하기
					}
				}
				
				if(stack.isEmpty()!=true) {//만약 위의 과정이 모두 끝났는데도 스택이 비어있지 않으면
					System.out.println("Incorrect");//incorrect 메세지 출력하고
					return false;//false 반환하기
				}
				return true; //조건들에 걸리지 않았을 경우 정상 종료된 것이므로 true 반환
		}
	}
	
}
