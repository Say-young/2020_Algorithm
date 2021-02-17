package hw4;
import java.util.*;

public class HW1_4_장세영 {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("전공 : 컴퓨터공학");
		System.out.println("학번 : 1871047");
		System.out.println("성명 : 장세영");
		System.out.println("=============");
		
		int num=0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How many students are there?");
		num=scanner.nextInt(); //학생 수 입력받기
		System.out.println("Input the information.\n");
		scanner.nextLine(); // 버퍼비우기
		
		StudentScore[] stlist = new StudentScore[num]; //입력받은 학생 수만큼 학생들의 정보를 담을 인스턴스 배열 선언하기
		int[] sum = new int[num]; //입력받은 학생 수만큼 학생들의 점수 총합을 담을 int 배열 선언하기
		double[] avg = new double[num];//입력받은 학생 수만큼 학생들의 점수 평균을 담을 double 배열 선언하기
		
		for(int i=0; i<num; i++) {
			stlist[i] = new StudentScore(); //i번째 참조변수에 인스턴스 연결
			System.out.print("ID:"); //아이디, 이름, 세 과목의 점수를 각각 입력받아 인스턴스에 저장
			stlist[i].setID(scanner.nextLine());
			System.out.print("Name:");
			stlist[i].setName(scanner.nextLine());
			System.out.print("Korean:");
			stlist[i].setKorean(scanner.nextInt());
			System.out.print("Math:");
			stlist[i].setMath(scanner.nextInt());
			System.out.print("English:");
			stlist[i].setEnglish(scanner.nextInt());
			System.out.println("");
			scanner.nextLine();//버퍼비우기
			sum[i] = stlist[i].getKorean() + stlist[i].getMath()+ stlist[i].getEnglish(); //점수 총합 저장
			avg[i] = (double)sum[i] / 3; //점수 평균 저장
		}
		
		int kosum=0, mathsum=0, engsum=0; //각 과목별 점수 합을 구하기 위해 변수 선언
		System.out.println("NAME\t\tID\tKOREAN\tMATH\tENGLISH\tSUM\tAVG");
		for(int i=0; i<num; i++) { //학생 수만큼 반복문 돌리기
			stlist[i].display(); //학생들의 정보 모두 출력하기
			kosum += stlist[i].getKorean(); //국어과목엔 학생들의 국어 성적을 모두 더하고
			mathsum += stlist[i].getMath(); //수학엔 수학
			engsum += stlist[i].getEnglish(); //영어엔 영어 더함
			System.out.printf("\t"+sum[i]+"\t%.2f\n",avg[i]); //그리고 각 학생의 정보와 함께 점수 총합, 평균도 함께 출력
		}
		double koavg = (double)kosum/num, mathavg = (double)mathsum/num, engavg = (double)engsum/num; //각 과목별 점수 평균 구하기. 모든 변수가 int이므로 double로 형변환을 해줘야.
		System.out.printf("Subject Avt\t\t%.2f\t%.2f\t%.2f\n",koavg, mathavg, engavg); //최종 결과 출력

		
		System.out.println("\n<Student over the average>\n");
		System.out.println("Korean:");
		for(int i=0; i<num; i++) { //학생수만큼 반복
			if(stlist[i].getKorean()>koavg) //평균보다 국어점수가 높으면 이름 출력
				System.out.print(stlist[i].getName()+"\t");
		}
		System.out.println("\nMath:");
		for(int i=0; i<num; i++) {//학생수만큼 반복
			if(stlist[i].getMath()>mathavg)//평균보다 수학점수가 높으면 이름 출력
				System.out.print(stlist[i].getName()+"\t");;
		}
		System.out.println("\nEnglish:");
		for(int i=0; i<num; i++) {//학생수만큼 반복
			if(stlist[i].getEnglish()>engavg)//평균보다 영어점수가 높으면 이름 출력
				System.out.print(stlist[i].getName()+"\t");;
		}
	}

}
