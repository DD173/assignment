package page246;
import java.util.*;


public class DicApp {
	
	Scanner scanner = new Scanner(System.in);
	String word;
	
	public void run() {
		System.out.println("한영 단어 검색 프로그램입니다.");
		
		while(true) {
			System.out.print("한글 단어?");
			word = scanner.next();
			if(word.equals("그만")) {
				break; //"그만"을 입력할 때까지 반복
			}
			else {
				if(Dictionary.findWord(word)) {
					System.out.println(word + "는 " + Dictionary.kor2Eng(word));
				}
				else
					System.out.println(word + "는 저의 사전에 없습니다.");
			}
		} //end while()
		scanner.close();
	} //end run()
	
	/* 메인함수 */
	public static void main(String[] args) {
		DicApp dicApp = new DicApp();
		dicApp.run();
	}
}

