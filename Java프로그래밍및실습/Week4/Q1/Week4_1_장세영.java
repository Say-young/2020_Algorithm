package lab;
import java.util.Scanner;

public class Week4_1_장세영 {
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");

		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*Song 정보*");
		String singer="", title = "";
		int price;
		
		do {
			try {
				System.out.print("곡명:"); //곡명 입력받기
				title = scanner.nextLine();
				//만약 엔터만 입력받았을 경우
				if(title.equals(""))
					throw new Exception("곡명은 반드시 필요합니다."); //해당 에러 메세지 던지기
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(title.equals("")); //곡명에 엔터가 들어왔을 경우 타이틀을 입력받을 때까지 반복

		
		System.out.print("가수명:"); //가수명 입력받기
		singer = scanner.nextLine();
				
		
		System.out.print("가격:"); //가격 입력받기
		price = scanner.nextInt();
		int lastprice =0;
		
		Song song; //먼저 참조 변수만 선언
		//아래에서 입력받은 값의 종류에 따라 다른 인스턴스 생성
		if(singer.equals("")) {
			song = new Song(title, price);
		}
		else {
			song = new Song(title, singer, price);
		}
		
		System.out.println("몇번 들으시겠습니까? "); //반복 횟수 입력받기
		int num = scanner.nextInt();
		for(int i=1; i<=num; i++) {
			song.play(); //입력 받은 횟수만큼 노래 재생 출력하고
			lastprice += song.price;
		}
		
		System.out.printf("총 %d원입니다.", lastprice); //총 가격 출력
	}
}
