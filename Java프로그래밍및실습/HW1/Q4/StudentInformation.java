package hw4;

public class StudentInformation {
	/*
	System.out.println("=============");
	System.out.println("���� : ��ǻ�Ͱ���");
	System.out.println("�й� : 1871047");
	System.out.println("���� : �弼��");
	System.out.println("=============");
	*/
	
	//���� ����. private�̹Ƿ� getter�� setter �ʿ�
	private String name;
	private String id;
	
	//������. ��� ���� Ŭ���� ���̶� ������ �ٷ� ���� �����ϳ� get �޼��带 ����غ�.
	StudentInformation(){
		name = getName();
		id = getID();
	}
	
	//name setter
	public void setName(String name) {
		this.name = name;
	}
	//id setter
	public void setID(String id) {
		this.id = id;
	}
	//name getter
	public String getName() {
		return name;
	}
	//id getter
	public String getID() {
		return id;
	}
	//getter�� �̿��� �̸��� id ����ϴ� �޼���
	public void display() {
		System.out.print(getName()+"\t"+getID()+"\t");
	}
	
}
