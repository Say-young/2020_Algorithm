package hwhw;

public class Production {
	private String title;
	private String director;
	private String writer;
	
	//title�� private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ get�޼ҵ带 Ȱ���� ���� ȣ���Ѵ�
	public String getTitle() {
		return title;
	}
	//director�� private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ get�޼ҵ带 Ȱ���� ���� ȣ���Ѵ�
	public String getDirector() {
		return director;
	}
	//writer�� private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ get�޼ҵ带 Ȱ���� ���� ȣ���Ѵ�
	public String getWriter() {
		return writer;
	}
	
	//title�� private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ set�޼ҵ带 Ȱ���� ���� �����Ѵ�
	public void setTitle(String title) {
		this.title = title;
	}
	//director�� private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ set�޼ҵ带 Ȱ���� ���� �����Ѵ�
	public void setDirector(String director) {
		this.director = director;
	}
	//writer�� private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ set�޼ҵ带 Ȱ���� ���� �����Ѵ�
	public void setWriter(String writer) {
		this.writer = writer;
	}
	//�� �������� private�̹Ƿ� ���� ������ �Ұ��ϱ⿡ get�޼ҵ带 Ȱ���� ���� ȣ���Ѵ�
	public void display() {
		System.out.println("Title: "+getTitle());
		System.out.println("Director: "+getDirector());
		System.out.println("Writer: "+getWriter());
	}
	
}
