package myPackage1;
import java.util.*;

public class Week7_1_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Pet[] pet = new Pet[10];
		
		Scanner scanner = new Scanner(System.in);
		int num1=0, num2=0, i=0, age=0;
		String name;
		
		//3.Exit을 누르기 전까지 무한 반복
		while(num1!=3) {
			try {
				System.out.println("원하는 작업은 무엇입니까?"); //사용자가 원하는 작업 묻기
				System.out.println("1. New input\t2. Output\t3. Exit");
				num1 = scanner.nextInt(); //숫자 입력받기
				if(num1>3 || num1<1) //범위 밖의 숫자를 입력받을 경우
					throw new Exception("1~4 사이의 숫자를 입력하세요."); //다시 입력하라고 메세지 띄우기
				while(true) { //두 번째 질문 반복
					try{				
						switch(num1) {
							case 1: //1.New input을 선택한 경우
									System.out.println("종은 무엇입니까?"); //종 물어보고
									System.out.println("1. Dog\t2. Cat\t3. Snake\t4. Bird");
									num2 = scanner.nextInt(); //답변 받기
									if(num2>4 || num2<1) //범위 밖의 숫자를 입력받은 경우
										throw new Exception("1~4 사이의 숫자를 입력하세요."); //다시 입력하라고 메세지 띄우기
									
									System.out.printf("Name:");//이름입력받기
									scanner.nextLine();//버퍼의 엔터 없애기
									name = scanner.nextLine();//String이므로 nextLine으로 받기
									
									while(true) { //age 질문 반복
									try {
										System.out.printf("Age:"); //나이 물어보고
										age = scanner.nextInt(); //숫자 입력받기
										switch(num2) {
										case 1:
											pet[i] = new Dog("Dog", name, age);//Dog 인스턴스 객체 생성
											i++;//새로운 객체를 만들 때마다 객체의 개수를 +1해준다.
											break;
										case 2:
											pet[i] = new Cat("Cat", name, age);//Cat 인스턴스 객체 생성
											i++;//새로운 객체를 만들 때마다 객체의 개수를 +1해준다.
											break;
										case 3:
											pet[i] = new Snake("Snake", name, age);//Snake 인스턴스 객체 생성
											i++;//새로운 객체를 만들 때마다 객체의 개수를 +1해준다.
											break;
										case 4:
											pet[i] = new Bird("Bird", name, age);//Bird 인스턴스 객체 생성
											i++;//새로운 객체를 만들 때마다 객체의 개수를 +1해준다.
											break;
										}
										System.out.print("");
										break;//올바른 입력 받았을 경우 age 반복문 종료
									}catch(InputMismatchException e) {
										System.out.println("숫자를 입력하세요."); //만약 age에서 숫자가 아닌 다른 것을 입력했을 경우
										scanner.nextLine(); //버퍼를 비워주고 다시 묻는다.
									}
								}
								break;
							case 2: //결과 출력 부분
								System.out.println("\nSpecies\tName\tAge\tMovement");
								for(int j=0; j<i; j++) {
									System.out.printf(pet[j].species+"\t"+pet[j].name+"\t"+pet[j].age+"\t"); //반복문으로 돌려가면서 모든 객체의 정보를 출력해준다
									pet[j].move();//오버라이드 했던 각 클래스의 move 메서드 출력
								}
								break;
						}
						System.out.println("");
						break;//올바른 입력을 받았을 경우 2번 반복문 종료
					}catch(InputMismatchException e) {
						System.out.println("숫자를 입력하세요.");//만약 2번 질문에서 숫자가 아닌 다른 것을 입력했을 경우
						scanner.nextLine();//버퍼를 비워주고 다시 묻는다.
					}catch(Exception e) {
						System.out.println(e.getMessage()); //범위 밖의 수를 입력받았을 경우 안내 메세지를 띄움.
					}		
			}
		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력하세요.");//만약 1번 질문에서 숫자가 아닌 다른 것을 입력했을 경우
			scanner.nextLine();//버퍼를 비워주고 다시 묻는다.
		}catch(Exception e) {
			System.out.println(e.getMessage());//범위 밖의 수를 입력받았을 경우 안내 메세지를 띄움.
		}
	}	
	System.out.println("종료");
	}
}
