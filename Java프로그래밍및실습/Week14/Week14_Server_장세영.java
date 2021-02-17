import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_Server_장세영 {
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		
		ServerSocket serverSocket = null; //server이므로 serversocket 선언
		Socket socket = null; //socket선언
		int sum=0; double avg; //사용할 변수 선언 및 초기화
		
		try {
			serverSocket = new ServerSocket(8884); //서버와 포트번호
			socket = serverSocket.accept(); //client의 request 대기하기
			
			Scanner in = new Scanner(socket.getInputStream()); //client에서 받아올 입력
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //client로 출력
			
			//1 받기
			String strIn = in.nextLine(); //Hello?
			System.out.println(strIn);
			
			//2 쓰기
			out.println("How many numbers?");
			out.flush();//flush해야 buffer의 내용이 server에 출력된다

			//3 받기
			strIn = in.nextLine();
			System.out.println(strIn);
			int num = Integer.parseInt(strIn);//string으로 받아왔으므로 형변환해서 저장
			
			
			//4쓰기
			out.println("Input "+num+" numbers");
			out.flush();
			
			//5받기
			for(int i=0; i<num; i++) {
				int num2 = Integer.parseInt(in.nextLine()); //숫자들 차례로 형변환해서 받아오기
				sum+=num2; //sum에 차곡차곡 더하기
			}
			avg=(double)sum/num; //sum 다 구한 후 avg 구하기
			
			//6쓰기
			out.println("Sum: "+sum);
			out.flush(); //한 문장 쓸 때마다 flush 해야 바로바로 보인다
			
			//7쓰기
			out.println("Avg: "+avg);
			out.flush();
			
			//8받기
			strIn = in.nextLine(); //service finished.
			System.out.println(strIn);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());//익셉션 핸들링 필수
		}finally {
			try {
				socket.close(); //소켓 닫기
			}catch(Exception e) {
				System.out.println(e.getMessage());//익셉션 핸들링 필수
			}
			try {
				serverSocket.close();//서버소켓닫기
			}catch(Exception e) {
				System.out.println(e.getMessage());//익셉션 핸들링 필수
			}
		}
	}
}
