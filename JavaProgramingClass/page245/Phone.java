package page245;


public class Phone {
	private String name; // �̸�
	private String tel; // ��ȭ��ȣ 
	
	public Phone(String name, String tel) {
		this.name = name; // ���⼭ this.name�� ���� ������ private name
		this.tel = tel;
		
	}

	public String getName() {return name;}  // �޼ҵ�� ����
	
	public String getTel() {return tel;}
}
