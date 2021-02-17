package lab9_1;

import java.io.*;
import java.util.*;

public class Week9_1_장세영 {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");

		//사용자에게 입력받기
		Scanner scanner = new Scanner(System.in);
		System.out.println("File name for input:");
		String fileName1 = scanner.next(); //fileName1에 입력
		System.out.println("File name for output:");
		String fileName2 = scanner.next(); //fileName2에 입력
		
		//inputStream과 outputStream을 ObjectInputStream으로 선언
		ObjectInputStream inputStream = null;
		ObjectOutputStream outputStream = null;
		
		System.out.println("The numbers in File, "+fileName1);
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName1)); //fileName1에 연결
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName2)); //fileName2에 연결
			try {
				while(true) { //파일의 내용이 남아있을 때까지
					int anInteger = inputStream.readInt(); //int형태로 fileName1의 내용을 읽어옴
					System.out.println(anInteger); //읽어온 내용을 출력하고
					outputStream.writeInt(anInteger*2); //해당 수를 2배해 fileName2에 작성
				}
			}
			catch(EOFException e) { //fileName1의 끝에 도달할 경우 종료
				System.out.println("End of reading from file, "+fileName1); //안내 메세지 출력
				System.out.println(fileName2 + " is generated.\n");
			}
			inputStream.close(); //읽어오기가 끝난 후 파일을 닫아야 함
			outputStream.close(); //쓰기가 끝난 후 파일을 닫아야 내용이 작성됨
		}
		catch(FileNotFoundException e) { //만약 읽어올 파일이 없는 경우
			System.out.println("Cannot find file "+fileName1); //오류 메세지 출력
		}
		catch(IOException e) { //입출력 관련 문제가 발생할 경우
			System.out.println("Problem with input from file "+ fileName1); //오류 메시지 출력
		}
		
		System.out.println("The numbers in new File, "+fileName2);
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName2)); //작성한 fileName2를 다시 열어오기 위해 inputStream 사용
			try {
				while(true) { //파일의 내용이 남아있을 때까지
					int anInteger = inputStream.readInt(); // int 형태로 내용 읽어오기
					System.out.println(anInteger); //내용 출력
				}
			}
			catch(EOFException e) { //파일의 끝에 도달했을 경우 종료
				System.out.println("End of reading from 2nd file, "+fileName2); //안내 메세지 출력
			}
			inputStream.close(); //읽어오기가 끝난 후 파일 닫기
		}
		catch(FileNotFoundException e) { //읽어올 파일을 찾지 못했을 경우
			System.out.println("Cannot find 2nd file "+fileName2); //오류 메세지 출력
		}
		catch(IOException e) { //입출력 관련 문제가 발생했을 경우
			System.out.println("Problem with input from 2nd file "+ fileName2); //오류 메세지 출력
		}
	}

}
