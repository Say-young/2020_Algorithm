package hw;

public class Song {
	
	//Song Ŭ������ ������ ����
	String title;
	String singer;
	int price;
	
	//�뷡�� ���並 ����ϴ� �޼ҵ�
	public void play() {
		System.out.println("�뷡����: \""+title+"\" by "+singer);
	}
	
	//������ ����ϴ� �޼ҵ�
	public void price() {
		System.out.println(price+"���Դϴ�.");
	}
}
