package hwhw;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Week5_1_�弼�� {

	public static void main(String[] args) {
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");

		
		Scanner scanner = new Scanner(System.in);
		
		//������ �ν��Ͻ� ��ü ����
		Play play = new Play();
		Film film = new Film();
		
		
		//�� �Է¹ޱ�. �� �������� private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ set�޼ҵ带 Ȱ���� ���� �����Ѵ�
		System.out.println("Input Title for Play");
		play.setTitle(scanner.nextLine());
		System.out.println("Input Director for Play");
		play.setDirector(scanner.nextLine());
		System.out.println("Input Writer for Play");
		play.setWriter(scanner.nextLine());
		System.out.println("Input Title for Film");
		film.setTitle(scanner.nextLine());
		System.out.println("Input Director for Film");
		film.setDirector(scanner.nextLine());
		System.out.println("Input Writer for Film");
		film.setWriter(scanner.nextLine());
		
		//�Ʒ��� ������ �޾ƾ� �ϴµ� ������ �ƴ� �ٸ� ���� �Է����� ��� ����� ���� �ٽ� �Է��� �޴� ����
		while(true) {
			try {
				System.out.println("Input Performance Cost for Play");
				play.setPerformanceCost((scanner.nextInt()));
				break;
			}
			catch(InputMismatchException e) {
				scanner.nextLine(); // ���� ���� �̰� ������ ���ѷ��� ����
				System.out.println("������ �Է� �����մϴ�.");
			}
		}
		
		while(true) {
			try {
				System.out.println("Input boxOfficeGross for Film");
				film.setBoxOfficeGross((scanner.nextInt()));
				break;
			}
			catch(InputMismatchException e) {
				scanner.nextLine(); // ���� ���� �̰� ������ ���ѷ��� ����
				System.out.println("������ �Է� �����մϴ�.");
			}
		}
		
		//�� �������� private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ get�޼ҵ带 Ȱ���� ���� ȣ���Ѵ�
		play.display();
		film.display();
	}

}
