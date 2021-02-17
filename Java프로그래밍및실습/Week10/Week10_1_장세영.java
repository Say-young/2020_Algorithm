package lab;

import java.util.*;

public class Week10_1_장세영 {

	public static void main(String[] args) {
		

		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in); //입력받을 scanner
		ArrayList<Student> student = new ArrayList<Student>(); //student 객체 담을 arraylist 선언
		//사용할 변수 선언
		String name = null;
		String ID;
		int age, num, location;
		num=0;
		
		
		System.out.println("Input Student Name, ID, and age. 0 for to quit.");
		while(true) { //반복문
			name =scanner.next(); //name 입력받기. 띄어쓰기로 구분하므로 next()로 받음
			if(name.equals("0")==false) { //만약 0이 아닌 다른 것을 입력받는다면
				ID=scanner.next(); //ID 저장
				age=scanner.nextInt(); //age 저장
				student.add(new Student(name, ID,age)); //입력받은 정보로 student 객체 생성 후 배열에 추가
			}
			else
				break; //0을 입력받으면 반복문 탈출
		}
		printResult(student); //리스트 내용 출력 메서드 호출
		
		
	while(num !=4) { //입력값이 4가 아니면 계속 반복
		System.out.println("Choose the operation you want.");
		System.out.println("1.add information  2.delete information  3. show list  4. Finish program");
		num = scanner.nextInt(); //입력받기
		switch(num) {
			case 1:
				addStudent(student); //1을 입력받았을 경우 추가 메서드 호출
				break;
			case 2:
				deleteStudent(student); //2를 입력받았을 경우 삭제 메서드 호출
				break;
			case 3:
				printResult(student); //3을 입력받았을 경우 리스트 내용 출력 메서드 호출
				break;
			case 4:
				break; //4를 입력받았을 경우 탈출
			default : 
				System.out.println("Wrong input"); //1234 이외의 값을 입력받았을 경우 오류 메세지 출력
				System.out.println("");
				break;
		}
	}
}
	
	//리스트 내용 출력 메서드 - 파라미터는 student list
	public static void printResult(List<Student> student) {
		System.out.println("NUMBER\tNAME\tID\tAGE");
		//배열 size만큼 반복하며 배열 정보 출력
		for (int i = 0; i<student.size(); i++) {
			System.out.println((i+1)+"\t"+student.get(i).name+"\t"+student.get(i).ID+"\t"+student.get(i).age);
		}
		System.out.println("");
	}
	
	//삭제 메서드 - 파라미터는 student list
	public static void deleteStudent(List<Student> Stu) {
		System.out.println("Input Student Number to delete.");
		//scanner 다시 선언. 메인 밖이므로 메인에서 선언한 scanner는 사용 불가
		Scanner scanner =new Scanner(System.in);
		int location=scanner.nextInt(); //입력받은 값을 location으로 사용
		Stu.remove(location-1); //출력된 리스트는 1번부터 시작하므로 n번째 원소를 삭제하기 위해서는 n-1번째 원소를 remove 해야함
		printResult(Stu); //출력 메서드 호출
	}
	
	//추가 메서드 - 파라미터는 student list
	public static void addStudent(ArrayList<Student> Stu) {
		System.out.println("Input new Student Name, ID, age, and the location.");
		//scanner 다시 선언. 메인 밖이므로 메인에서 선언한 scanner는 사용 불가
		Scanner scanner =new Scanner(System.in);
		//student 인스턴스 생성에 필요한 값들 모두 입력받아 저장
		String name =scanner.next();
		String ID=scanner.next();
		int age=scanner.nextInt();
		int location=scanner.nextInt();//입력받은 값을 location으로 사용
		Stu.add((location-1), new Student(name, ID,age)); //출력된 리스트는 1번부터 시작하므로 n번째 원소를 추가하기 위해서는 n-1번째 원소를 add 해야함
		printResult(Stu); //출력 메서드 호출
	}

}
