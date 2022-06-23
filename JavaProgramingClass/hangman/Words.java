package hangman;

import java.io.*;
import java.util.*;

public class Words {
	Vector<String> wordVector = new Vector<String>();
	
	public Words(String fileName) {
		try {
			Scanner scanner = new Scanner(new FileReader(fileName));
			while(scanner.hasNext()) { // ���� ������ ����
				String word = scanner.nextLine();
				wordVector.add(word); // ���ڿ��� ���Ϳ� ����
			}
			scanner.close();
		}catch(FileNotFoundException e) {
			System.out.println("file not found error");
			System.exit(0);
		}
	}
	public String getRandomWord() {
		final int WORDMAX = wordVector.size(); // �� �ܾ��� ����
		int index = (int)(Math.random()*WORDMAX);
		return wordVector.get(index);
	}
}
