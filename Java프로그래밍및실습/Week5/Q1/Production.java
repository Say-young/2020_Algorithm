package hwhw;

public class Production {
	private String title;
	private String director;
	private String writer;
	
	//title은 private이므로 직접 접근이 불가하기에 get메소드를 활용해 값을 호출한다
	public String getTitle() {
		return title;
	}
	//director은 private이므로 직접 접근이 불가하기에 get메소드를 활용해 값을 호출한다
	public String getDirector() {
		return director;
	}
	//writer은 private이므로 직접 접근이 불가하기에 get메소드를 활용해 값을 호출한다
	public String getWriter() {
		return writer;
	}
	
	//title은 private이므로 직접 접근이 불가하기에 set메소드를 활용해 값을 저장한다
	public void setTitle(String title) {
		this.title = title;
	}
	//director은 private이므로 직접 접근이 불가하기에 set메소드를 활용해 값을 저장한다
	public void setDirector(String director) {
		this.director = director;
	}
	//writer은 private이므로 직접 접근이 불가하기에 set메소드를 활용해 값을 저장한다
	public void setWriter(String writer) {
		this.writer = writer;
	}
	//각 변수들은 private이므로 직접 접근이 불가하기에 get메소드를 활용해 값을 호출한다
	public void display() {
		System.out.println("Title: "+getTitle());
		System.out.println("Director: "+getDirector());
		System.out.println("Writer: "+getWriter());
	}
	
}
