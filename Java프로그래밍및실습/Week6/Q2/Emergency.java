package lab2;

public class Emergency {
//	System.out.println("=============");
//	System.out.println("전공 : 컴퓨터공학");
//	System.out.println("학번 : 1871047");
//	System.out.println("성명 : 장세영");
//	System.out.println("=============");
	
	//인스턴스 배열을 위한 참조변수 선언. 최대 10개의 인스턴스 저장 가능
	Car emgList[] = new Car[10];
	int i;
	
	//번호출력하고 Car 배열에 해당 인스턴스 연결
	public void EM_Call(Car car) {
		//모든 종류의 Car 타입의 인스턴스를 받아 "call 112" 혹은 "call 119"를 출력하고 객체 배열에 인스턴스를 저장
		System.out.println("Call " + car.getNumber());
		emgList[i++] = car;
	}
	
	//반복문 이용하여 배열의 모든 instance 출력
	public void EM_record() {
		//현재까지의 모든 데이터 출력
		System.out.println("Emergency\tNumber\tCar_Type\tRequired");
		for(int j=0; j<i; j++) {
			System.out.println(emgList[j]); //각 객체의 toString메서드는 getStr()을 출력
		}
	}
}