package hw;
import java.util.Scanner;
public class Week3_3_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");

		//사용자에게 파일 제목 입력받기
		Scanner kbd = new Scanner(System.in);
		
		//변수선언
		String title;
		int page;
		
		//MyFile 객체 2개 만들기
		MyFile fold = new MyFile();
		MyFile fNew = new MyFile();
		
		System.out.println("--File정보입력(제목,페이지수)--");
		
		//제목이랑 페이지 입력받기. title과 page는 private 변수이므로 직접 대입이 불가능하고 set메소드 이용해야 함.
		fold.setTitle(kbd.nextLine());
		fold.setPage(kbd.nextInt());
		
		//copy 메소드를 이용해 fold의 내용을 fNew로 복사
		fold.filecopy(fNew);
		
		//각각의 객체 내용을 출력하는 함수 fileInfo를 이용해 복사가 완료된 것을 확인
		System.out.println("<원래File>");
		fold.fileInfo();
		System.out.println("<복사된File>");
		fNew.fileInfo();
	}

}
