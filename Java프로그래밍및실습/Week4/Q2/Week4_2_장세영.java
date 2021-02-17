
public class Week4_2_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");

		//main메소드는 예시와 동일
		int a =5, b = 10;
		double da = 3.4, db = 5.2;
		char ca = 'a', cb = 'b';
		int iarr[] = {1,2,3};
		double darr[] = {1.1, 2.2, 3.3};
		char carr[] = {'a', 'p', 'p', 'l', 'e'};
		System.out.println("a+b = "+sum(a,b));
		System.out.println("da+b = "+sum(da,b));
		System.out.println("da+b = "+sum(a,db));
		System.out.println("da+db = "+sum(da,db));
		System.out.println("ca+cb = "+sum(ca,cb));
		System.out.println("sum of Int_Arr = "+sum(iarr));
		System.out.println("sum of Double_Arr = "+sum(darr));
		System.out.println("sum of Char_Arr = "+sum(carr));
	} //End of main

	
	//메소드 오버로딩
	//메소드 리턴 타입은 각각 변수의 연산 결과에 맞게 설정
	public static int sum(int a, int b) {
		return a+b;
	}
	
	//소수점이 포함되어 있으므로 double
	public static double sum(double da, int b) {
		return da+b;
	}
	
	public static double sum(int a, double db) {
		return a+db;
	}
	
	public static double sum(double da, double db) {
		return da+db;
	}
	
	//string으로 반환할 경우 리턴 타입을 string으로 설정해줘야 함
	//String.valueOf(char변수)를 이용하면 char변수들을 연결해 String으로 반환할 수 있다
	public static String sum(char ca, char cb) {
		return String.valueOf(ca)+String.valueOf(cb);
	}
	
	//반복문을 이용해 배열의 모든 원소들을 더해서 반환하기. 리턴 타입은 int
	public static int sum(int[] iarr) {
		int total = 0;
		for (int i=0; i<iarr.length; i++) {
			total += iarr[i];
		}
		return total;
	}

	//반복문을 이용해 배열의 모든 원소들을 더해서 반환하기. 리턴 타입은 double
	public static double sum(double[] darr) {
		double total = 0;
		for (int i=0; i<darr.length; i++) {
			total += darr[i];
		}
		return total;
	}
	
	
	//char 배열의 경우 String.valueOf(char배열이름)으로 간단하게 모든 원소들을 연결해 출력할 수 있다
	public static String sum(char[] carr) {
		return String.valueOf(carr);
	}

}
