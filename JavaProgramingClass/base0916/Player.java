package base0916;
import java.util.*;

// 한 사람의 참가자를 표현하는 클래스
public class Player {
	private Scanner scanner; //키보드 입력 
	private String name; // 게임 참가자의 이름
	private String word; // 참가자가 말한 단어 
	// 멤버 필드는 초기화 x, 생성자에 가서 해야함
	
	public Player(String name) {
		this.name = name; // 여기서 this.name은 위에 선언한 private name
		scanner = new Scanner(System.in);
		
	}
	
	public String getName() {return name;}  // 메소드로 접근
	
	public String getWordFromUser() {
		System.out.print(name + ">>");
		word = scanner.nextLine();
		return word;
	}
	
	// lastWord와 참가자가 말한 word를 비교하여 끝말잇기가 잘 되었는지 판단.
	// 성공하였으면 true 리턴
	public boolean checkSuccess(String lastWord) {
		int lastIndex = lastWord.length()-1; // 최종 단어의 맨 마지막 문자와 참가자가 말한 단어의 첫 문자가 같은지 비교
		if(lastWord.charAt(lastIndex)==word.charAt(0))
			return true;
		else
			return false;
	}
}
