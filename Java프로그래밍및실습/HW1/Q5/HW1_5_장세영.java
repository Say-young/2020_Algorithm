//��ü ������ ��� ã��
//3������ ��� �� �Ǵ� ���� �ذ�
package hw5;
import java.util.*;

public class HW1_5_�弼�� {

	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		//�θ� Ŭ������ �ν��Ͻ� �迭 ����
		Shape[] myShape = new Shape[10];
		Rectangle rec; //rectangle �������� ����
		Circle cir; //circle �������� ����
		Scanner scanner = new Scanner(System.in);
		int x, y, r, w, h; //������ ����� ���� ����
		
		Label: //4���� �Է¹޾��� �� �ѹ��� �����ϱ� ���� �󺧸�����
		for(int i=0; i<10; i++) { //�迭 ���̸� 10���� ���������Ƿ� �ݺ����� 10������ ������
			System.out.println("1.Circle\t2.Rectangle\t3.Show\t4.Exit");
			int num = scanner.nextInt(); //�Է¹ޱ�
			switch(num) {
				case 1: //1���� �Է¹޾��� ���
					System.out.print("x = ");
					x = scanner.nextInt(); //�� �Է¹ޱ�
					System.out.print("y = ");
					y = scanner.nextInt();//�� �Է¹ޱ�
					System.out.print("r = ");
					r = scanner.nextInt();//�� �Է¹ޱ�
					myShape[i] = new Circle(); //circle �ν��Ͻ��� ������ �������� myShape[i]�� ����
					cir = (Circle)myShape[i]; //�ڽ�Ŭ������ �޼��带 ����ؾ��ϹǷ� myShape[i]�� �ٿ�ĳ�����ؼ� cir ���������� ����
					cir.setPoint(x,y,r); //circle�� ���ǵ� setPoint �޼��带 �̿��� ������ ����
					myShape[i]=cir; //�����͸� ������ cir�� �ּҸ� myShape[i]�� �ٽ� ����
					System.out.println("");
					break;
				case 2:
					System.out.print("x = ");
					x = scanner.nextInt();//�� �Է¹ޱ�
					System.out.print("y = ");
					y = scanner.nextInt();//�� �Է¹ޱ�
					System.out.print("w = ");
					w = scanner.nextInt();//�� �Է¹ޱ�
					System.out.print("h = ");
					h = scanner.nextInt();//�� �Է¹ޱ�
					myShape[i] = new Rectangle();//rectangle �ν��Ͻ��� ������ �������� myShape[i]�� ����
					rec = (Rectangle)myShape[i];//�ڽ�Ŭ������ �޼��带 ����ؾ��ϹǷ� myShape[i]�� �ٿ�ĳ�����ؼ� rec ���������� ����
					rec.setPoint(x,y,w,h);//rectangle�� ���ǵ� setPoint �޼��带 �̿��� ������ ����
					myShape[i]=rec;//�����͸� ������ rec�� �ּҸ� myShape[i]�� �ٽ� ����
					System.out.println("");
					break;
				case 3:
					for(int j=0; j<i; j++)
						myShape[j].display(); //��ü����ŭ �ݺ��ؼ� ���� ����ϱ�
					System.out.println("");
					i--; //�̹� turn������ ��ü�� �������� �ʾ����Ƿ� i�� -1����. i�� ������ ��ü�� ������ ��Ÿ���� ��. �� �۾��� ������ ������ ����ִ� �迭�� ���ܼ� ������
					break;
				case 4:
					break Label; //���� ���� �� �� ��� �ݺ��� Ż��
			}
		}
	}
}
