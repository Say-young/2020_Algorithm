package lab;

public class Buyer {

//	System.out.println("=============");
//	System.out.println("전공 : 컴퓨터공학");
//	System.out.println("학번 : 1871047");
//	System.out.println("성명 : 장세영");
//	System.out.println("=============");
	
	int money;
	int bonusPoint, i;
	Product item[] = new Product[10]; //구매 목록 배열 선언. 최대 크기는 10개로 설정.
	
	void buy(Product pd) {
		if(pd.price>money) {
			System.out.println("Money is not enough.\n"); //금액이 부족하다는 메세지 출력
			summary(); //쇼핑 결과 출력
			System.exit(0); //시스템 종료
		}
			money = money-pd.price; //잔돈 계산
			bonusPoint += pd.bonusPoint; //보너스포인트 계산
			System.out.println("You bought "+pd+"("+pd.price+")."); //구매 안내 메세지 출력
			item[i++]=pd; //shopping list에 구매한 물품 이름 추가
	}
	
	//shopping list 목록 출력 메서드
	void summary() {
		System.out.print("\nShopping List: ");
		
		for(int j=0; j<i; j++) {
			System.out.print(item[j]+" "); //배열의 원소들을 모두 출력
		}
		System.out.println("\nMoney left : "+money); //최종 잔돈 출력
		System.out.println("Current bonus point : " +bonusPoint); //최종 포인트 출력
	}
}
