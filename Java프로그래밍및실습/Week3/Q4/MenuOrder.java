package lab;
public class MenuOrder {

	//��������
	private int cokePrice;
	private int lemonadePrice;
	private int coffeePrice;
	private int inputMoney;
	private String drinkSelected;
	
	//������� �Է¿� ���� �� ���Ḧ �����ϴ� �޼ҵ�
	public void setPrice(String drinkSelected, int price) {
			//�Բ� �޾ƿ� string���� �޴��� �����ؼ� ������ ������ ������ ����
			if(drinkSelected.equalsIgnoreCase("coke"))
				cokePrice = price;
			else if(drinkSelected.equalsIgnoreCase("lemonade"))
				lemonadePrice = price;
			else if(drinkSelected.equalsIgnoreCase("coffee"))
				coffeePrice = price;
	}
	
	//private�� ������ �������� ���� ��ȯ���ִ� �޼ҵ�
	public int getCokePrice() {
		return cokePrice;
	}
	public int getLemonadePrice() {
		return lemonadePrice;
	}
	public int getCoffeePrice() {
		return coffeePrice;
	}
	public int getInputMoney() {
		return inputMoney;
	}
	public void setInputMoney(int money) {
		inputMoney = money; //�Ѿ� �Է¹޴� �޼ҵ�~
	}
	public void setDrinkSelected(String string) {
		drinkSelected = string;
	}
	public void getDrinkSelected() {
		System.out.println(drinkSelected);
	}
	
	
	//�� ����� ���� ������ ȭ�鿡 �����ִ� �޼ҵ�
	public void showMenu() {
		System.out.println("---���Ḧ �����ϼ���---");
		System.out.println("1. Coke: "+getCokePrice());
		System.out.println("2. Lemonade: "+getLemonadePrice());
		System.out.println("3. Coffee: "+getCoffeePrice());
	}
	
	//����ڰ� �Է��� �ݾװ� ���� �޴��� ���� ����� ȭ�鿡 ����ϴ� �޼ҵ�
	public void showResult(MenuOrder order, int choice) {
		switch(choice) {
		case 1:
			order.setDrinkSelected("Coke�� �����ϼ̽��ϴ�."); //����ؾ��� ������ set�޼ҵ带 �̿��� �޾ƿ� ��
			order.getDrinkSelected(); // get�޼ҵ带 �̿��� ����ϱ�
			inputMoney-=cokePrice; //�� �ݾ׿��� �޴��� ����
			break;
		case 2:
			order.setDrinkSelected("Lemonade�� �����ϼ̽��ϴ�.");
			order.getDrinkSelected();
			inputMoney-=lemonadePrice;//�� �ݾ׿��� �޴��� ����
			break;
		case 3:
			order.setDrinkSelected("Coffee�� �����ϼ̽��ϴ�.");
			order.getDrinkSelected();
			inputMoney-=coffeePrice;//�� �ݾ׿��� �޴��� ����
			break;
		default :
			System.out.println("���� �޴��� �����ϼ̽��ϴ�.");
			break;
		}
	}
}