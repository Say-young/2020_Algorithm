package lab2;

public class Car {
//	System.out.println("=============");
//	System.out.println("전공 : 컴퓨터공학");
//	System.out.println("학번 : 1871047");
//	System.out.println("성명 : 장세영");
//	System.out.println("=============");
	
	//private으로 변수 선언
	private String emgType;
	private int number;
	private String carType;
	private String reqPerson;
	
	//private 변수에 각각 대입하는 생성자를 정의
	Car(String emgType, int number, String carType, String reqPerson){
		this.emgType = emgType;
		this.number = number;
		this.carType = carType;
		this.reqPerson = reqPerson;
	}
	
	//private 변수에 접근 가능하도록 get set 메소드 선언. 안 쓰더라도 setter도 같이 정의
	public String getEmgType(){
		return emgType;
	}
	public void setEmgType(String emgType) {
		this.emgType = emgType;
	}
	
	public int getNumber(){
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getCarType(){
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public String getReqPerson(){
		return reqPerson;
	}
	public void setReqPerson(String reqPerson) {
		this.reqPerson = reqPerson;
	}
	
	//정보 출력 메서드
	public String getStr() {
		return getEmgType()+"\t\t"+getNumber()+"\t"+getCarType()+"\t"+getReqPerson();
	}
	
}
