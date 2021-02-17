package lab;

public class Song {
	
	//Song Ŭ������ ������ ����
	public String title;
	public String singer;
	public int price;
	
	
	//default ������ ����
	Song(){
		
	}
	
	//title, price ������
	Song(String title, int price){
		this(title, "��", price); //�뷡 ������ �� ��, "��"�� singer�� �ְ� �ٸ� ������ ȣ��
	}
	
	//title, singer, price�� �ִ� ������ ����
	Song(String title, String singer, int price){
		this.title = title;
		this.singer = singer;
		this.price = price;
	}
	

	//�뷡�� ���並 ����ϴ� �޼ҵ�
	public void play() {
		System.out.println(title+" by "+singer);
	}
	
	//������ ����ϴ� �޼ҵ�
	public void price() {
		System.out.println(price+"���Դϴ�.");
	}
}