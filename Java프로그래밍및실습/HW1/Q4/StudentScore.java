package hw4;

public class StudentScore extends StudentInformation{
	/*
	System.out.println("=============");
	System.out.println("전공 : 컴퓨터공학");
	System.out.println("학번 : 1871047");
	System.out.println("성명 : 장세영");
	System.out.println("=============");
	*/
	
	//변수 선언. private이므로 getter와 setter 필요
	private int korean;
	private int math;
	private int english;
	
	//생성자. 사실 같은 클래스 안이라 변수에 바로 대입 가능하나 get 메서드를 사용해봄.
	StudentScore(){
		super(); //StudentInformation 클래스의 생성자 호출
		korean = getKorean();
		math = getMath();
		english = getEnglish();
	}
	
	//korean setter
	public void setKorean(int korean) {
		this.korean = korean;
	}
	//math setter
	public void setMath(int math) {
		this.math = math;
	}
	//english setter
	public void setEnglish(int english) {
		this.english = english;
	}
	//korean getter
	public int getKorean() {
		return korean;
	}
	//math getter
	public int getMath() {
		return math;
	}
	//english getter
	public int getEnglish() {
		return english;
	}
	//이름, id, 과목별 점수를 출력하는 메서드(오버라이
	public void display() {
		super.display();//이름과 아이디 출력
		System.out.print(getKorean()+"\t"+getMath()+"\t"+getEnglish());
	}
}
