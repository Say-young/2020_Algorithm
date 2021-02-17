package hw;

public class MyFile {

	//클래스의 변수 선언
	private String title;
	private int page;
	
	//변수들이 private형으로 선언되었으므로 set메소드 필요
	public void setTitle(String title) {
		this.title = title;
	}
	
	//변수들이 private형으로 선언되었으므로 set메소드 필요
	public void setPage(int page) {
		this.page= page;
	}
	
	//새로운 file이 기존 파일의 제목과 페이지 수의 정보를 가리키도록 대입
	public void filecopy(MyFile file) {
		file.setTitle(title);
		file.setPage(page);
	}
	
	//파일의 제목과 페이지수를 출력하는 메소드
	public void fileInfo() {
		System.out.println("파일제목:"+title);
		System.out.println("페이지:"+page);
	}
}
