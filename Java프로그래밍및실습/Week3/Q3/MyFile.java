package hw;

public class MyFile {

	//Ŭ������ ���� ����
	private String title;
	private int page;
	
	//�������� private������ ����Ǿ����Ƿ� set�޼ҵ� �ʿ�
	public void setTitle(String title) {
		this.title = title;
	}
	
	//�������� private������ ����Ǿ����Ƿ� set�޼ҵ� �ʿ�
	public void setPage(int page) {
		this.page= page;
	}
	
	//���ο� file�� ���� ������ ����� ������ ���� ������ ����Ű���� ����
	public void filecopy(MyFile file) {
		file.setTitle(title);
		file.setPage(page);
	}
	
	//������ ����� ���������� ����ϴ� �޼ҵ�
	public void fileInfo() {
		System.out.println("��������:"+title);
		System.out.println("������:"+page);
	}
}
