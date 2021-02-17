package hw;
import java.util.Scanner;
public class Week3_2_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");

		//circle 객체 생성
		Circle mycircle = new Circle();
		
		//사용자에게 값 입력받기
		Scanner scanner = new Scanner(System.in);
		System.out.print("반지름입력:");
		//double로 받자
		mycircle.setRadius(scanner.nextDouble());
		//radius는 private 변수로 선언되었기 때문에 바로 호출 불가능. getRadius 메소드 이용
		System.out.println("반지름:"+mycircle.getRadius());
		//원둘레와 원넓이를 출력해주는 song클래스의 메소드 불러오기
		mycircle.circleInfo();
	}

}
