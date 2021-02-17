package lab;

public class Song {
	
	//Song 클래스의 변수들 선언
	public String title;
	public String singer;
	public int price;
	
	
	//default 생성자 생성
	Song(){
		
	}
	
	//title, price 생성자
	Song(String title, int price){
		this(title, "모름", price); //노래 가수명 모를 시, "모름"을 singer에 넣고 다른 생성자 호출
	}
	
	//title, singer, price가 있는 생성자 생성
	Song(String title, String singer, int price){
		this.title = title;
		this.singer = singer;
		this.price = price;
	}
	

	//노래를 들어요를 출력하는 메소드
	public void play() {
		System.out.println(title+" by "+singer);
	}
	
	//가격을 출력하는 메소드
	public void price() {
		System.out.println(price+"원입니다.");
	}
}