package hangman;

import java.util.*;

public class HangManGameApp {
	private final int HIDDENCHAR = 2;  // ����� ���� ����
	private StringBuffer hiddenWord; // ���� ���ڸ� ���� �ܾ�
	private String newWord; // ������ ���� ������ �ܾ�
	private Scanner scanner; // Ű �Է�
	private int failCount; // Ʋ�� Ƚ��
	
	public HangManGameApp() {
		scanner = new Scanner(System.in);
	}

	public void run() {
		System.out.println("���ݺ��� ��� ������ �����մϴ�.");
		Words words = new Words("words.txt"); // word.txt ������ ��� �ܾ�
		while(true) {
			newWord = words.getRandomWord(); // ������ �ܾ� ����
			if(newWord == null) break;
			makeHidden(); // 2���� ���ڸ� ���� �ܾ� �����
			go(); // ���� ����
			System.out.print("Next(y/n)?");
			String answer = scanner.next();
			if(answer.equals("n"))
				break; //n�� �Է��ϸ� ����
		}
	}
	
	private void makeHidden() {
		hiddenWord = new StringBuffer(newWord);
		Random r = new Random();
		
		for(int k=0; k<HIDDENCHAR; k++) { // ���� �ε��� ����
			int index = r.nextInt(newWord.length());
			// System.out.println("index = " + index);
			char c = newWord.charAt(index);
			// System.out.println("c = " + c);
		
			for(int i=0; i<newWord.length(); i++) { // ���ĺ� �����
				if(hiddenWord.charAt(i) == c)
					hiddenWord.setCharAt(i, '-');
			}
		}
	}

	// ����� Ű�� �Է¹����鼭 ��� ������ �����Ѵ�. 5�� Ʋ���� �����Ѵ�.
	// �� �ܾ� ���� �� y/n ������ ���� n�� �Է��ϸ� �����Ѵ�.
	private void go() {
		failCount = 0;
		char key;
		do {
			if(failCount==5) {
				System.out.println("5�� �����߽��ϴ�.");
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

