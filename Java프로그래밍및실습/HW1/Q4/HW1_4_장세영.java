package hw4;
import java.util.*;

public class HW1_4_�弼�� {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		int num=0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How many students are there?");
		num=scanner.nextInt(); //�л� �� �Է¹ޱ�
		System.out.println("Input the information.\n");
		scanner.nextLine(); // ���ۺ���
		
		StudentScore[] stlist = new StudentScore[num]; //�Է¹��� �л� ����ŭ �л����� ������ ���� �ν��Ͻ� �迭 �����ϱ�
		int[] sum = new int[num]; //�Է¹��� �л� ����ŭ �л����� ���� ������ ���� int �迭 �����ϱ�
		double[] avg = new double[num];//�Է¹��� �л� ����ŭ �л����� ���� ����� ���� double �迭 �����ϱ�
		
		for(int i=0; i<num; i++) {
			stlist[i] = new StudentScore(); //i��° ���������� �ν��Ͻ� ����
			System.out.print("ID:"); //���̵�, �̸�, �� ������ ������ ���� �Է¹޾� �ν��Ͻ��� ����
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
			scanner.nextLine();//���ۺ���
			sum[i] = stlist[i].getKorean() + stlist[i].getMath()+ stlist[i].getEnglish(); //���� ���� ����
			avg[i] = (double)sum[i] / 3; //���� ��� ����
		}
		
		int kosum=0, mathsum=0, engsum=0; //�� ���� ���� ���� ���ϱ� ���� ���� ����
		System.out.println("NAME\t\tID\tKOREAN\tMATH\tENGLISH\tSUM\tAVG");
		for(int i=0; i<num; i++) { //�л� ����ŭ �ݺ��� ������
			stlist[i].display(); //�л����� ���� ��� ����ϱ�
			kosum += stlist[i].getKorean(); //������� �л����� ���� ������ ��� ���ϰ�
			mathsum += stlist[i].getMath(); //���п� ����
			engsum += stlist[i].getEnglish(); //��� ���� ����
			System.out.printf("\t"+sum[i]+"\t%.2f\n",avg[i]); //�׸��� �� �л��� ������ �Բ� ���� ����, ��յ� �Բ� ���
		}
		double koavg = (double)kosum/num, mathavg = (double)mathsum/num, engavg = (double)engsum/num; //�� ���� ���� ��� ���ϱ�. ��� ������ int�̹Ƿ� double�� ����ȯ�� �����.
		System.out.printf("Subject Avt\t\t%.2f\t%.2f\t%.2f\n",koavg, mathavg, engavg); //���� ��� ���

		
		System.out.println("\n<Student over the average>\n");
		System.out.println("Korean:");
		for(int i=0; i<num; i++) { //�л�����ŭ �ݺ�
			if(stlist[i].getKorean()>koavg) //��պ��� ���������� ������ �̸� ���
				System.out.print(stlist[i].getName()+"\t");
		}
		System.out.println("\nMath:");
		for(int i=0; i<num; i++) {//�л�����ŭ �ݺ�
			if(stlist[i].getMath()>mathavg)//��պ��� ���������� ������ �̸� ���
				System.out.print(stlist[i].getName()+"\t");;
		}
		System.out.println("\nEnglish:");
		for(int i=0; i<num; i++) {//�л�����ŭ �ݺ�
			if(stlist[i].getEnglish()>engavg)//��պ��� ���������� ������ �̸� ���
				System.out.print(stlist[i].getName()+"\t");;
		}
	}

}
