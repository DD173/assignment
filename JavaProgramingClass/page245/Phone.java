package page245;


public class Phone {
	private String name; // 이름
	private String tel; // 전화번호 
	
	public Phone(String name, String tel) {
		this.name = name; // 여기서 this.name은 위에 선언한 private name
		this.tel = tel;
		
	}

	public String getName() {return name;}  // 메소드로 접근
	
	public String getTel() {return tel;}
}
