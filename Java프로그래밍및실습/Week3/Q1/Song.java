package hw;

public class Song {
	
	//Song 클래스의 변수들 선언
	String title;
	String singer;
	int price;
	
	//노래를 들어요를 출력하는 메소드
	public void play() {
		System.out.println("노래들어요: \""+title+"\" by "+singer);
	}
	
	//가격을 출력하는 메소드
	public void price() {
		System.out.println(price+"원입니다.");
	}
}
