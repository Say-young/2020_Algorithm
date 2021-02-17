package hw2;
import java.util.*;
import java.io.*;


public class HW2_1_장세영 {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);//파일명을 입력받기 위한 스캐너
		System.out.println("Input the filename to read."); //입출력한 파일명 입력받기
		String inputfile = scanner.nextLine();
		System.out.println("Input the filename to write.");
		String outputfile = scanner.nextLine();
		
		//입출력스트림 선언해두기(try문 밖에서 close()하기 위해 먼저 선언
		Scanner inputStream = null;
		PrintWriter outputStream=null;
		
		try {
			//위에서 받은 파일명을 인자로 넣어 입출력 스트림 생성
			inputStream = new Scanner(new File(inputfile));
			outputStream = new PrintWriter(outputfile);
		
			//입력받을 파일에 읽어올 내용이 남아있으면
			while(inputStream.hasNextLine()) {
				String str = inputStream.nextLine(); //text를 줄 단위로 읽어옴
				StringTokenizer tk = new StringTokenizer(str, " ,\n"); //분리자 3개 적용
				while(tk.hasMoreTokens()) { //다음 토큰이 남아있으면
					String next = tk.nextToken(); //다음에 받아올 토큰을 string 변수에 저장
					if(next.length()>4) { //길이가 4보다 큰 단어이면
						outputStream.println(next); //출력파일에 쓰기
					}
				}
			}
			System.out.println(outputfile+" is generated."); //다 종료된 이후에 출력파일이 생성되었다는 메세지 출력
		}
		//입출력 스트림에 적절한 exception handling
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		//입출력 스트림 닫기
		outputStream.close();
		inputStream.close();
	}

}
