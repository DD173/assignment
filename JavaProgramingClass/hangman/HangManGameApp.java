package hangman;

import java.util.*;

public class HangManGameApp {
	private final int HIDDENCHAR = 2;  // 숨기는 글자 개수
	private StringBuffer hiddenWord; // 숨긴 글자를 가진 단어
	private String newWord; // 게임을 위해 선정된 단어
	private Scanner scanner; // 키 입력
	private int failCount; // 틀린 횟수
	
	public HangManGameApp() {
		scanner = new Scanner(System.in);
	}

	public void run() {
		System.out.println("지금부터 행맨 게임을 시작합니다.");
		Words words = new Words("words.txt"); // word.txt 파일의 모든 단어
		while(true) {
			newWord = words.getRandomWord(); // 랜덤한 단어 선택
			if(newWord == null) break;
			makeHidden(); // 2개의 글자를 숨긴 단어 만들기
			go(); // 게임 진행
			System.out.print("Next(y/n)?");
			String answer = scanner.next();
			if(answer.equals("n"))
				break; //n을 입력하면 종료
		}
	}
	
	private void makeHidden() {
		hiddenWord = new StringBuffer(newWord);
		Random r = new Random();
		
		for(int k=0; k<HIDDENCHAR; k++) { // 숨길 인덱스 고르기
			int index = r.nextInt(newWord.length());
			// System.out.println("index = " + index);
			char c = newWord.charAt(index);
			// System.out.println("c = " + c);
		
			for(int i=0; i<newWord.length(); i++) { // 알파벳 숨기기
				if(hiddenWord.charAt(i) == c)
					hiddenWord.setCharAt(i, '-');
			}
		}
	}

	// 사용자 키를 입력받으면서 행맨 게임을 진행한다. 5번 틀리면 종료한다.
	// 한 단어 진행 후 y/n 물음에 대해 n을 입력하면 종료한다.
	private void go() {
		failCount = 0;
		char key;
		do {
			if(failCount==5) {
				System.out.println("5번 실패했습니다.");
				break;
			}
			System.out.println(hiddenWord);
			System.out.print(">>");
		
			String text = scanner.next();
			key = text.charAt(0);
			
		}while(!complete(key));
	
		System.out.println(newWord);
	}

	private boolean complete(char key) {
		boolean hit = false;
		for(int i=0; i<newWord.length(); i++) {
			if(hiddenWord.charAt(i) == '-' && newWord.charAt(i) == key) {
				hiddenWord.setCharAt(i, key);
				hit = true;
			}
		}
		if(!hit)
			failCount++;
		for(int i=0; i<newWord.length(); i++) {
			if(hiddenWord.charAt(i) == '-')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		HangManGameApp app = new HangManGameApp();
		app.run();
	}
} // end class

