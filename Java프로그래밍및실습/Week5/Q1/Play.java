package hwhw;

public class Play extends Production{
	private int performanceCost;
	
	//�� �����ڴ� ���������� �����صα�.
	Play(){
		super();
	}
	//�Ʒ� ������ private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ get�޼ҵ带 Ȱ���� ���� ȣ���Ѵ�
	public int getPerformanceCost() {
		return performanceCost;
	}
	//�Ʒ� ������ private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ set�޼ҵ带 Ȱ���� ���� �����Ѵ�
	public void setPerformanceCost(int cost) {
		performanceCost = cost;
	}
	//production Ŭ������ display �޼��带 �������̵�.
	public void display() {
		super.display();
		System.out.println("performance cost: "+getPerformanceCost());
		System.out.println("");
	}
	
}