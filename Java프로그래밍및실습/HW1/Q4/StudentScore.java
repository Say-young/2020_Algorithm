package hw4;

public class StudentScore extends StudentInformation{
	/*
	System.out.println("=============");
	System.out.println("���� : ��ǻ�Ͱ���");
	System.out.println("�й� : 1871047");
	System.out.println("���� : �弼��");
	System.out.println("=============");
	*/
	
	//���� ����. private�̹Ƿ� getter�� setter �ʿ�
	private int korean;
	private int math;
	private int english;
	
	//������. ��� ���� Ŭ���� ���̶� ������ �ٷ� ���� �����ϳ� get �޼��带 ����غ�.
	StudentScore(){
		super(); //StudentInformation Ŭ������ ������ ȣ��
		korean = getKorean();
		math = getMath();
		english = getEnglish();
	}
	
	//korean setter
	public void setKorean(int korean) {
		this.korean = korean;
	}
	//math setter
	public void setMath(int math) {
		this.math = math;
	}
	//english setter
	public void setEnglish(int english) {
		this.english = english;
	}
	//korean getter
	public int getKorean() {
		return korean;
	}
	//math getter
	public int getMath() {
		return math;
	}
	//english getter
	public int getEnglish() {
		return english;
	}
	//�̸�, id, ���� ������ ����ϴ� �޼���(��������
	public void display() {
		super.display();//�̸��� ���̵� ���
		System.out.print(getKorean()+"\t"+getMath()+"\t"+getEnglish());
	}
}
