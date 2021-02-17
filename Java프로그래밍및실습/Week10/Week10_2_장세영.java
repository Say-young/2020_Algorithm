package lab;

import java.util.*;

public class Week10_2_장세영 {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		//map 선언, key-string, value-string
		Map<String, String> Stmap = new HashMap<String, String>();
		//입력받기
		Scanner scanner = new Scanner(System.in);
		String ID, name;
		ID = null;
		System.out.println("학생의 ID와 이름을 차례로 입력하세요. (종료시 0 0 입력)");
		//반복문
		while(true) {
			ID = scanner.next();
			name = scanner.next();
			if(ID.equals("0")==false) //ID에 0이 아닌 다른 값이 입력되면
				Stmap.put(ID, name); //ID를 key, name을 value로 haspmap에 저장
			else //0 0을 입력받을 경우 반복문 탈출
				break;
		}
		
		
		System.out.println("<학생명단>");
		System.out.println("[ID]\t\t[NAME]");
		Set s = Stmap.keySet(); //key값으로 set 만들기
		Iterator<String> it = s.iterator(); //iterator 선언
		String str = null;
		int count = 0;
		
		while(it.hasNext()) { //다음 원소가 있으면 반복
			str = it.next(); //현재 iterator에 입력받은 key를 str에 저장
			System.out.println(str+"\t\t"+Stmap.get(str)); //해당 key의 value 출력
			count++; //count+1
		}
		
		Set a = Stmap.keySet(); //최대길이 최소길이 구하기 위해 다시 key값으로 새로운 set 생성
		it = a.iterator();
		String longNameID, shortNameID;
		longNameID = shortNameID = it.next(); //가장 긴 이름의 id와 가장 짧은 이름의 id를 담을 변수에 첫번째 키값을 넣어 초기화
		String longname, shortname;
		longname = shortname = Stmap.get(it.next()); //가장 긴 이름과 가장 짧은 이름을 담을 변수에 첫번째 키값에 해당하는 value를 넣어 초기화

		while(it.hasNext()) { //다음 원소가 있으면 반복
			str = it.next(); //현재 iterator에 입력받은 key를 str에 저장
			if(Stmap.get(str).length()>longname.length()) { //해당 key의 value의 길이가 longname의 길이보다 길면
				longname = Stmap.get(str); //longname변수에 해당 value를 저장하고
				longNameID = str; //longNameID에 해당 key를 저장
			}
			if(Stmap.get(str).length()<shortname.length()) { //해당 key의 value의 길이가 shortname의 길이보다 짧으면
				shortname = Stmap.get(str); //shortname 변수에 해당 value를 저장하고
				shortNameID = str; //shortNameID에 해당 key를 저장
			}
		}
		
		//결과 출력
		System.out.println("\n전체 학생수: "+count);
		System.out.println("<가장 긴 이름을 가진 학생>");
		System.out.println("ID:"+longNameID+" Name:"+longname+" 길이:"+longname.length());
		System.out.println("<가장 짧은 이름을 가진 학생>");
		System.out.println("ID:"+shortNameID+" Name:"+shortname+" 길이:"+shortname.length());
	}

}
