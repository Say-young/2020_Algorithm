
public class Week4_2_�弼�� {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");

		//main�޼ҵ�� ���ÿ� ����
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

	
	//�޼ҵ� �����ε�
	//�޼ҵ� ���� Ÿ���� ���� ������ ���� ����� �°� ����
	public static int sum(int a, int b) {
		return a+b;
	}
	
	//�Ҽ����� ���ԵǾ� �����Ƿ� double
	public static double sum(double da, int b) {
		return da+b;
	}
	
	public static double sum(int a, double db) {
		return a+db;
	}
	
	public static double sum(double da, double db) {
		return da+db;
	}
	
	//string���� ��ȯ�� ��� ���� Ÿ���� string���� ��������� ��
	//String.valueOf(char����)�� �̿��ϸ� char�������� ������ String���� ��ȯ�� �� �ִ�
	public static String sum(char ca, char cb) {
		return String.valueOf(ca)+String.valueOf(cb);
	}
	
	//�ݺ����� �̿��� �迭�� ��� ���ҵ��� ���ؼ� ��ȯ�ϱ�. ���� Ÿ���� int
	public static int sum(int[] iarr) {
		int total = 0;
		for (int i=0; i<iarr.length; i++) {
			total += iarr[i];
		}
		return total;
	}

	//�ݺ����� �̿��� �迭�� ��� ���ҵ��� ���ؼ� ��ȯ�ϱ�. ���� Ÿ���� double
	public static double sum(double[] darr) {
		double total = 0;
		for (int i=0; i<darr.length; i++) {
			total += darr[i];
		}
		return total;
	}
	
	
	//char �迭�� ��� String.valueOf(char�迭�̸�)���� �����ϰ� ��� ���ҵ��� ������ ����� �� �ִ�
	public static String sum(char[] carr) {
		return String.valueOf(carr);
	}

}
