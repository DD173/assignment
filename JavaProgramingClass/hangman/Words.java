package hangman;

import java.io.*;
import java.util.*;

public class Words {
	Vector<String> wordVector = new Vector<String>();
	
	public Words(String fileName) {
		try {
			Scanner scanner = new Scanner(new FileReader(fileName));
			while(scanner.hasNext()) { // 파일 끝까지 읽음
				String word = scanner.nextLine();
				wordVector.add(word); // 문자열을 벡터에 저장
			}
			scanner.close();
		}catch(FileNotFoundException e) {
			System.out.println("file not found error");
			System.exit(0);
		}
	}
	public String getRandomWord() {
		final int WORDMAX = wordVector.size(); // 총 단어의 개수
		int index = (int)(Math.random()*WORDMAX);
		return wordVector.get(index);
	}
}
