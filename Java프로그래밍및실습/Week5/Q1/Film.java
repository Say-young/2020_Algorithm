package hwhw;

public class Film extends Production{
	private int boxOfficeGross;
	
	//�� �����ڴ� ���������� �����صα�.
	Film(){
		super();
	}
	//�Ʒ� ������ private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ get�޼ҵ带 Ȱ���� ���� ȣ���Ѵ�
	public int getBoxOfficeGross() {
		return boxOfficeGross;
	}
	//�Ʒ� ������ private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ set�޼ҵ带 Ȱ���� ���� �����Ѵ�
	public void setBoxOfficeGross(int a) {
		boxOfficeGross = a;
	}
	//production Ŭ������ display �޼��带 �������̵�.
	public void display() {
		super.display();
		System.out.println("boxOfficeGross: "+getBoxOfficeGross());
	}
}
