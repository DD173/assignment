package base1028;



public class Word { // 영어 단어와 한글 단어를 쌍으로 가진 하나의 단어 표현
	private String english; // 영어 단어
	private String korean; // 영어 단어에 해당하는 한글 단어
	
	public Word(String english, String korean) {
		this.english = english;
		this.korean = korean;
	}
	public String getEnglish() {return english;}
	public String getKorean() {return korean;}
}
