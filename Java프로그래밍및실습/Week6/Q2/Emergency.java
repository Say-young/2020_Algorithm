package lab2;

public class Emergency {
//	System.out.println("=============");
//	System.out.println("���� : ��ǻ�Ͱ���");
//	System.out.println("�й� : 1871047");
//	System.out.println("���� : �弼��");
//	System.out.println("=============");
	
	//�ν��Ͻ� �迭�� ���� �������� ����. �ִ� 10���� �ν��Ͻ� ���� ����
	Car emgList[] = new Car[10];
	int i;
	
	//��ȣ����ϰ� Car �迭�� �ش� �ν��Ͻ� ����
	public void EM_Call(Car car) {
		//��� ������ Car Ÿ���� �ν��Ͻ��� �޾� "call 112" Ȥ�� "call 119"�� ����ϰ� ��ü �迭�� �ν��Ͻ��� ����
		System.out.println("Call " + car.getNumber());
		emgList[i++] = car;
	}
	
	//�ݺ��� �̿��Ͽ� �迭�� ��� instance ���
	public void EM_record() {
		//��������� ��� ������ ���
		System.out.println("Emergency\tNumber\tCar_Type\tRequired");
		for(int j=0; j<i; j++) {
			System.out.println(emgList[j]); //�� ��ü�� toString�޼���� getStr()�� ���
		}
	}
}