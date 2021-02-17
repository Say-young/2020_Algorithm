import java.util.Scanner;
public class Week2_2_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");

		//사용자에게 값 받기
		Scanner scanner = new Scanner(System.in);
		String a = "y";
               
                while(a.equalsIgnoreCase("y")){
                    
                //입력받기
		System.out.print("섭씨의경우 'C', 화씨의경우 'F' 입력:");
		a = scanner.nextLine();
		
		//온도 초기값 설정
		double c=0; 
		int f = 0;
		
		//대소문자 상관 없이 섭씨인 경우
		if(a.equalsIgnoreCase("c")){
			System.out.print("섭씨온도 입력:");
			c = scanner.nextDouble();
			f = (int)(9*(c/5)+32);
			System.out.printf("현재온도는 섭씨 %.1f도, 화씨 %d도입니다.\n", c, f);
                        //반복할 것을 묻는다
                        System.out.print("계속하시겠습니까?(y/n)");
                        a = scanner.nextLine();//엔터 삭제용
                        a = scanner.nextLine();
		}
		
		//대소문자 상관 없이 화씨인경우
		else if(a.equalsIgnoreCase("f")){
			System.out.print("화씨온도 입력:");
			f = scanner.nextInt();
			c=5*((double)f-32)/9;
			System.out.printf("현재온도는 화씨 %d도, 섭씨 %.1f도입니다.\n", f, c);
                        //반복할 것을 묻는다
                        System.out.print("계속하시겠습니까?(y/n)");
                        a = scanner.nextLine();//엔터 삭제용
                        a = scanner.nextLine();
		}
		
		//잘못된 문자를 입력받은 경우
		else{
			System.out.println("잘못된 입력");
                        //반복할 것을 묻는다
                        System.out.print("계속하시겠습니까?(y/n)");
                        a = scanner.nextLine();
		}
            }      
	System.out.println("프로그램종료");
	}
}
