package base1028;



public class Word { // ���� �ܾ�� �ѱ� �ܾ ������ ���� �ϳ��� �ܾ� ǥ��
	private String english; // ���� �ܾ�
	private String korean; // ���� �ܾ �ش��ϴ� �ѱ� �ܾ�
	
	public Word(String english, String korean) {
		this.english = english;
		this.korean = korean;
	}
	public String getEnglish() {return english;}
	public String getKorean() {return korean;}
}
