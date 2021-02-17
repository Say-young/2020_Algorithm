package lab;

public class Buyer {

//	System.out.println("=============");
//	System.out.println("���� : ��ǻ�Ͱ���");
//	System.out.println("�й� : 1871047");
//	System.out.println("���� : �弼��");
//	System.out.println("=============");
	
	int money;
	int bonusPoint, i;
	Product item[] = new Product[10]; //���� ��� �迭 ����. �ִ� ũ��� 10���� ����.
	
	void buy(Product pd) {
		if(pd.price>money) {
			System.out.println("Money is not enough.\n"); //�ݾ��� �����ϴٴ� �޼��� ���
			summary(); //���� ��� ���
			System.exit(0); //�ý��� ����
		}
			money = money-pd.price; //�ܵ� ���
			bonusPoint += pd.bonusPoint; //���ʽ�����Ʈ ���
			System.out.println("You bought "+pd+"("+pd.price+")."); //���� �ȳ� �޼��� ���
			item[i++]=pd; //shopping list�� ������ ��ǰ �̸� �߰�
	}
	
	//shopping list ��� ��� �޼���
	void summary() {
		System.out.print("\nShopping List: ");
		
		for(int j=0; j<i; j++) {
			System.out.print(item[j]+" "); //�迭�� ���ҵ��� ��� ���
		}
		System.out.println("\nMoney left : "+money); //���� �ܵ� ���
		System.out.println("Current bonus point : " +bonusPoint); //���� ����Ʈ ���
	}
}
