package lab9_2;
import java.io.*;
import java.util.*;

public class Week9_2_장세영 {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		//Dog 클래스 배열 만들고 각 배열에 object 생성
		Dog myDog[] = new Dog[10];
		myDog[0] = new Dog("Merry", 3, 2.5, "Bulldog", false);
		myDog[1] = new Dog("JJong", 5, 5.5, "Mix", false);
		myDog[2] = new Dog("Kong", 4, 3, "Poodle", true);
		myDog[3] = new Dog("Apple", 2, 2.5, "Collie", true);
		myDog[4] = new Dog("Candy", 5, 5.5, "Coca", false);
		myDog[5] = new Dog("Cutie", 7, 2.5, "Chiwawa", true);
		myDog[6] = new Dog("Peace", 3, 2.5, "Huskey", false);
		myDog[7] = new Dog("Lion", 9, 1.5, "Shepard", true);
		myDog[8] = new Dog("Windy", 2, 9, "Jindo", true);
		myDog[9] = new Dog("Sweetie", 1, 2.5, "Maltiz", false);
		
		//사용자게에 해당 내용을 작성할 파일 이름 입력받기
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input File name to write Dog date");
		String fileName = scanner.next();
		
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName)); // 입력받은 파일에 내용을 작성할 준비
			outputStream.writeObject(myDog); //myDog의 내용을 object 덩어리로 한번에 write
			outputStream.close(); //close해야 파일에 내용이 작성됨
		}
		catch(IOException e) { //입출력 관련 문제가 발생할 경우
			System.out.println("ERROR writing to file "+fileName+"."); //에러 메세지 출력
			System.exit(0); //종료
		}
		
		
		Dog[] anotherArray = null; //읽어올 내용을 받을 Dog형 배열 선언
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName)); //역시나 objectInputStream을 활용
			anotherArray = (Dog[])inputStream.readObject(); //(Dog[])로 다운캐스팅 해줘야 Object 덩어리로 읽어온 내용을 Dog형 배열에 저장 가능
			System.out.println("Name\tAge\tWeight\tBreed\t\tBoosterShot\t");
			for(int i=0; i<anotherArray.length; i++) {
				System.out.println(anotherArray[i]); //반복문으로 내용 한번에 출력 - toString에 오버라이딩 된 내용이 출력됨
			}
			System.out.println("\nDogs older than 2 years and did not get the boosterShot.");
			for(int i=0; i<anotherArray.length; i++) { //배열 길이만큼 반복
				if((anotherArray[i].getAge()>2)&&(anotherArray[i].getBoosterShot()==false)) //예방 접종 여부가 X이고 나이가 2살보다 많은 객체이면
					System.out.println(anotherArray[i].getName()+"\t\t"+anotherArray[i].getBreed()); //출력해라
			}
			inputStream.close(); //파일 닫기
			System.out.println("\nProgram finished.");
		}
		catch(EOFException e) { //파일의 끝에 도달하면 종료됨
			System.out.println("End of File Exception.");
		}
		catch(FileNotFoundException e) { //읽어올 파일을 찾지 못할 경우
			System.out.println("File not found Exception.");
		}
		catch(IOException e) { //입출력 관련 오류가 발생했을 경우
			System.out.println("IO Exception.");
		}
		catch(Exception e) { //그 이외에 오류가 발생했을 때. 이 catch에 해당하는 Exception의 포함관계가 가장 크기 떄문에 가장 하단에 적어야 위에서 구체적인 오류를 거를 수 있다.
			System.out.println("Exception.");
		}
		
		
	}

}
