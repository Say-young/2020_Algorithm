package lab;
public class MenuOrder {

	//변수선언
	private int cokePrice;
	private int lemonadePrice;
	private int coffeePrice;
	private int inputMoney;
	private String drinkSelected;
	
	//사용자의 입력에 따라 각 음료를 저장하는 메소드
	public void setPrice(String drinkSelected, int price) {
			//함께 받아온 string으로 메뉴를 구분해서 각각의 변수에 가격을 대입
			if(drinkSelected.equalsIgnoreCase("coke"))
				cokePrice = price;
			else if(drinkSelected.equalsIgnoreCase("lemonade"))
				lemonadePrice = price;
			else if(drinkSelected.equalsIgnoreCase("coffee"))
				coffeePrice = price;
	}
	
	//private로 선언한 변수들의 값을 반환해주는 메소드
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
		inputMoney = money; //총액 입력받는 메소드~
	}
	public void setDrinkSelected(String string) {
		drinkSelected = string;
	}
	public void getDrinkSelected() {
		System.out.println(drinkSelected);
	}
	
	
	//각 음료와 가격 정보를 화면에 보여주는 메소드
	public void showMenu() {
		System.out.println("---음료를 선택하세요---");
		System.out.println("1. Coke: "+getCokePrice());
		System.out.println("2. Lemonade: "+getLemonadePrice());
		System.out.println("3. Coffee: "+getCoffeePrice());
	}
	
	//사용자가 입력한 금액과 선택 메뉴에 따라 결과를 화면에 출력하는 메소드
	public void showResult(MenuOrder order, int choice) {
		switch(choice) {
		case 1:
			order.setDrinkSelected("Coke를 선택하셨습니다."); //출력해야할 문장을 set메소드를 이용해 받아온 후
			order.getDrinkSelected(); // get메소드를 이용해 출력하기
			inputMoney-=cokePrice; //총 금액에서 메뉴값 제외
			break;
		case 2:
			order.setDrinkSelected("Lemonade를 선택하셨습니다.");
			order.getDrinkSelected();
			inputMoney-=lemonadePrice;//총 금액에서 메뉴값 제외
			break;
		case 3:
			order.setDrinkSelected("Coffee를 선택하셨습니다.");
			order.getDrinkSelected();
			inputMoney-=coffeePrice;//총 금액에서 메뉴값 제외
			break;
		default :
			System.out.println("없는 메뉴를 선택하셨습니다.");
			break;
		}
	}
}