package lab2;

public class Car {
//	System.out.println("=============");
//	System.out.println("���� : ��ǻ�Ͱ���");
//	System.out.println("�й� : 1871047");
//	System.out.println("���� : �弼��");
//	System.out.println("=============");
	
	//private���� ���� ����
	private String emgType;
	private int number;
	private String carType;
	private String reqPerson;
	
	//private ������ ���� �����ϴ� �����ڸ� ����
	Car(String emgType, int number, String carType, String reqPerson){
		this.emgType = emgType;
		this.number = number;
		this.carType = carType;
		this.reqPerson = reqPerson;
	}
	
	//private ������ ���� �����ϵ��� get set �޼ҵ� ����. �� ������ setter�� ���� ����
	public String getEmgType(){
		return emgType;
	}
	public void setEmgType(String emgType) {
		this.emgType = emgType;
	}
	
	public int getNumber(){
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getCarType(){
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	public String getReqPerson(){
		return reqPerson;
	}
	public void setReqPerson(String reqPerson) {
		this.reqPerson = reqPerson;
	}
	
	//���� ��� �޼���
	public String getStr() {
		return getEmgType()+"\t\t"+getNumber()+"\t"+getCarType()+"\t"+getReqPerson();
	}
	
}
