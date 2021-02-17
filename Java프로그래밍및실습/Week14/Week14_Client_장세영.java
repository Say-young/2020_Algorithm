import java.io.*;
import java.net.*;
import java.util.*;

public class Week14_Client_장세영 {
	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		Socket socket = null; //socket 선언
		
		try {
			socket = new Socket("192.168.43.189", 8884);//서버 아이피와 포트 맞춰서	

			Scanner scanner = new Scanner(System.in); //표준입력
			Scanner in = new Scanner(socket.getInputStream()); //server에서 받아올 입력
			PrintWriter out = new PrintWriter(socket.getOutputStream()); //server로 출력
			
			//1 쓰기
			out.println("Hello?");
			out.flush(); //flush해야 buffer의 내용이 server에 출력된다
			
			//2 받기
			String strIn = in.nextLine(); //How many numbers?
			System.out.println(strIn);

			//3 쓰기
			strIn = scanner.nextLine();
			out.println(strIn); //n
			out.flush();
			int num=Integer.parseInt(strIn); //string으로 받아왔으므로 형변환해서 저장

			//4 받기
			strIn = in.nextLine(); //input num numbers
			System.out.println(strIn);
				
			//5쓰기
			for(int i= 0; i<num; i++) {
				strIn = scanner.nextLine();
				out.println(strIn);
				out.flush();
			}
			
			//6받기
			strIn = in.nextLine(); //sum
			System.out.println(strIn);
			
			//7받기
			strIn = in.nextLine(); //avt
			System.out.println(strIn);
			
			//8쓰기
			out.println("Service finished.");
			out.flush();
			
		}catch(Exception e) {
			System.out.println(e.getMessage()); //익셉션 핸들링 필수
		}finally {
			try {
				socket.close();//소켓 닫기
			}catch(Exception e) {
				System.out.println(e.getMessage());//익셉션 핸들링 필수
			}
		}
	}
}







