package hw;

public class Dog extends Pet {
	
	boolean boosterShot; //�������� ���� ���� ����
	
	Dog(){
		super();
	}
	
	public void writeOutput() { //Pet Ŭ������ �ִ� ������ �̸��� �޼ҵ� �������̵�
		System.out.println("Boostershot: "+boosterShot); // ���������� ���� �޼��� ���.
	}
	
	//boosterShot������ private�̹Ƿ� ���� ������ �Ұ����ϴ�. set �޼ҵ带 ���� ����
	public void setBoosterShot(boolean boosterShot) {
		this.boosterShot = boosterShot; //�����������θ� �ٲ��ִ� set �޼ҵ�
	}
	
	//��� ���� private �������� ���� ������ �Ұ����ϹǷ� get �޼ҵ带 ���� �����ؾ� �Ѵ�.
	public boolean getBoosterShot() {
		return boosterShot;
	}
	
	public void move() {
		System.out.println(super.getName() + " walks and runs."); //Pet Ŭ������ name ������ private�̹Ƿ� getName �޼ҵ带 ���� ȣ���ؾ� �Ѵ�.
	}
}
