package hw;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Week5_2_장세영 {
	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
	
		Dog[] a = new Dog[3];
		a[0] = new Dog();
		a[1] = new Dog();
		a[2] = new Dog();
		
		Cat[] b = new Cat[3];
		b[0] = new Cat();
		b[1] = new Cat();
		b[2] = new Cat();

		//각 인스턴스의 정보를 반복문을 이용하여 입력하기
		
		//3번동안 강아지 클래스 정보 입력을 받는 메서드
		for(int i=0; i<3; i++) {
			System.out.println("<<Dog "+(i+1)+">>");
			System.out.print("Name :");
			a[i].setName(scanner.nextLine()); //String으로 입력받아야 함. 역시 set 메서드로 접근
			
			while(true) {
				try {
					System.out.print("Age :");
					a[i].setAge(scanner.nextInt()); //int로 입력받아야 함. 역시 set 메서드로 접근
					break;
				}
				catch(InputMismatchException e) {
					scanner.nextLine(); // 버퍼 비우기 이거 없으면 무한루프 돈다
					System.out.println("정수만 입력 가능합니다.");
				}
			}
			
			while(true) {
				try {
					System.out.print("Weight :");
					a[i].setWeight(scanner.nextDouble()); //double로 입력받아야 함. 역시 set 메서드로 접근
					break;
				}
				catch(InputMismatchException e) {
					scanner.nextLine(); // 버퍼 비우기 이거 없으면 무한루프 돈다
					System.out.println("숫자만 입력 가능합니다.");
				}
			}
					
			scanner.nextLine(); //버퍼에서 엔터 없애기. 이거 없으면 다음 입력에 엔터 들어간다
			System.out.print("BoosterShot(y/n) :");
			if(scanner.nextLine().equalsIgnoreCase("y")) //만약 입력한 값이 y라면
				a[i].setBoosterShot(true); //변수가 boolean 형태이므로 true 값 저장. 역시 set 메서드로 접근
			else
				a[i].setBoosterShot(false); //y 이외의 모든 입력값이라면 변수가 boolean 형태이므로 false 값 저장. 역시 set 메서드로 접근
			System.out.println("");
		}
		
		//3번동안 고양이 클래스 정보 입력을 받는 메서드
		for(int i=0; i<3; i++) {
			System.out.println("<<Cat "+(i+1)+">>");
			System.out.print("Name :");
			b[i].setName(scanner.nextLine()); //String으로 입력받아야 함. 역시 set 메서드로 접근
			
			while(true) {
				try {
					System.out.print("Age :");
					b[i].setAge(scanner.nextInt()); //int로 입력받아야 함. 역시 set 메서드로 접근
					break;
				}
				catch(InputMismatchException e) {
					scanner.nextLine(); // 버퍼 비우기 이거 없으면 무한루프 돈다
					System.out.println("정수만 입력 가능합니다.");
				}
			}
			
			while(true) {
				try {
					System.out.print("Weight :");
					b[i].setWeight(scanner.nextDouble()); //double로 입력받아야 함. 역시 set 메서드로 접근
					break;
				}
				catch(InputMismatchException e) {
					scanner.nextLine(); // 버퍼 비우기 이거 없으면 무한루프 돈다
					System.out.println("숫자만 입력 가능합니다.");
				}
			}
			
			scanner.nextLine(); //버퍼에서 엔터 없애기
			System.out.print("Color: ");
			b[i].setColor(scanner.nextLine()); //String으로 입력받아야 함. 역시 set 메서드로 접근
			System.out.println("");
		}
		
		
		//각 인스턴스의 정보를 반복문 내에서 writeOutput() 메서드를 이용해 출력하기
		
		System.out.println("\n<<Dog List>>");
		//3번동안 강아지 클래스 정보를 출력하는 메서드
		for(int i=0; i<3; i++) {
			System.out.println("Name : "+a[i].getName()); //private 변수이므로 get 메서드로 접근
			System.out.println("Age : "+a[i].getAge()); //private 변수이므로 get 메서드로 접근
			System.out.println("Weight : "+a[i].getWeight()); //private 변수이므로 get 메서드로 접근
			if(a[i].getBoosterShot() == true)
				System.out.println("BoosterShot : O"); // 접종 여부가 true일 경우 O 출력. private 변수이므로 get 메서드로 접근
			else
				System.out.println("BoosterShot : X");// 접종 여부가 false일 경우 X 출력. private 변수이므로 get 메서드로 접근
			a[i].move(); //move 메서드 출력
			System.out.println(""); //한줄 공백	
		}
		
		System.out.println("\n<<Cat List>>");
		//3번동안 고양이 클래스 정보를 출력하는 메서드
		for(int i=0; i<3; i++) {
			System.out.println("Name : "+b[i].getName()); //private 변수이므로 get 메서드로 접근
			System.out.println("Age : "+b[i].getAge()); //private 변수이므로 get 메서드로 접근
			System.out.println("Weight : "+b[i].getWeight()); //private 변수이므로 get 메서드로 접근
			System.out.println("Color : "+b[i].getColor()); //private 변수이므로 get 메서드로 접근
			b[i].move(); //move 메서드 출력
			System.out.println(""); //한줄 공백	
		}
		
		
		
		System.out.println("* Dogs older than 2 years and no boostershot are...");
		for(int i=0; i<3; i++) {
			if(a[i].getAge()>2) //먼저 나이가 2살보다 나이가 많은 강아지부터 찾고
			{
				if(a[i].getBoosterShot()==false) //예방접종 여부가 false인 강아지를 찾으면
					System.out.print(a[i].getName() + " "); //해당 강아지 이름 출력하기
			}
		}
		
		System.out.println("\n\n* Black cats weights more than 3kg are...");
		for(int i=0; i<3; i++) {
			if(b[i].getColor().equalsIgnoreCase("black")) //먼저 색깔이 black인 고양이를 찾고
			{
				if(b[i].getWeight()>3) //나이가 3살 이상인 고양이를 찾으면
					System.out.print(b[i].getName() + " "); //해당 고양이 이름 출력하기
			}
		}
		
	}
}
