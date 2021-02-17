//객체 생성할 방법 찾기
//3번에서 출력 안 되는 문제 해결
package hw5;
import java.util.*;

public class HW1_5_장세영 {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		//부모 클래스로 인스턴스 배열 생성
		Shape[] myShape = new Shape[10];
		Rectangle rec; //rectangle 참조변수 선언
		Circle cir; //circle 참조변수 선언
		Scanner scanner = new Scanner(System.in);
		int x, y, r, w, h; //앞으로 사용할 변수 선언
		
		Label: //4번을 입력받았을 때 한번에 종료하기 위해 라벨링했음
		for(int i=0; i<10; i++) { //배열 길이를 10으로 선언했으므로 반복문은 10까지만 돌린다
			System.out.println("1.Circle\t2.Rectangle\t3.Show\t4.Exit");
			int num = scanner.nextInt(); //입력받기
			switch(num) {
				case 1: //1번을 입력받았을 경우
					System.out.print("x = ");
					x = scanner.nextInt(); //값 입력받기
					System.out.print("y = ");
					y = scanner.nextInt();//값 입력받기
					System.out.print("r = ");
					r = scanner.nextInt();//값 입력받기
					myShape[i] = new Circle(); //circle 인스턴스를 생성해 참조변수 myShape[i]에 연결
					cir = (Circle)myShape[i]; //자식클래스의 메서드를 사용해야하므로 myShape[i]를 다운캐스팅해서 cir 참조변수에 저장
					cir.setPoint(x,y,r); //circle에 정의된 setPoint 메서드를 이용해 데이터 저장
					myShape[i]=cir; //데이터를 저장한 cir의 주소를 myShape[i]에 다시 저장
					System.out.println("");
					break;
				case 2:
					System.out.print("x = ");
					x = scanner.nextInt();//값 입력받기
					System.out.print("y = ");
					y = scanner.nextInt();//값 입력받기
					System.out.print("w = ");
					w = scanner.nextInt();//값 입력받기
					System.out.print("h = ");
					h = scanner.nextInt();//값 입력받기
					myShape[i] = new Rectangle();//rectangle 인스턴스를 생성해 참조변수 myShape[i]에 연결
					rec = (Rectangle)myShape[i];//자식클래스의 메서드를 사용해야하므로 myShape[i]를 다운캐스팅해서 rec 참조변수에 저장
					rec.setPoint(x,y,w,h);//rectangle에 정의된 setPoint 메서드를 이용해 데이터 저장
					myShape[i]=rec;//데이터를 저장한 rec의 주소를 myShape[i]에 다시 저장
					System.out.println("");
					break;
				case 3:
					for(int j=0; j<i; j++)
						myShape[j].display(); //객체수만큼 반복해서 정보 출력하기
					System.out.println("");
					i--; //이번 turn에서는 객체를 생성하지 않았으므로 i를 -1해줌. i가 생성된 객체의 개수를 나타내는 셈. 이 작업이 없으면 다음에 비어있는 배열이 생겨서 오류남
					break;
				case 4:
					break Label; //종료 누를 시 이 모든 반복문 탈출
			}
		}
	}
}
