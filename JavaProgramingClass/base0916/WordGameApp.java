package base0916;
import java.util.*;

public class WordGameApp {

	/* private은 같은 클래스 안에선 의미 없음 */
	private Scanner scanner;  // 키보드 입력
	private String startWord = "아버지";  // 시작 단어
	private Player[] players; // 게임 참가자들
	
	
	public WordGameApp(){
		scanner = new Scanner(System.in);  // 메모리 할당
	} 

	
	// 게임 참가자 수를 입력받고 Player[]을 생성하는 메소드 
	private void createPlayers() {
		while(true) {
		try {
			System.out.print("게임에 참가하는 인원은 몇명입니까>>");
			int nPlayers = scanner.nextInt();
			scanner.nextLine();
			players = new Player[nPlayers]; // Player[] 레퍼런스 배열 생성
			// 각 참여자의 이름을 입력받아 Player 객체 생성
			for(int i=0;i<nPlayers;i++) {
				System.out.print("참가자의 이름을 입력하세요>>");
				String name = scanner.nextLine();
				players[i] = new Player(name);}
			break;
		} // end try{}
		catch(InputMismatchException e){
			System.out.println("정수를 입력하여 주십시오.");
			scanner.next();
			continue;
		} // end catch{}
		} // end while(true);
		
	} // end createPlayers()
	public void run() {
		System.out.println("끝말잇기 게임을 시작합니다...");
		createPlayers(); // 참가자를 위한 Player []을 생성한다. 같은 클래스 안에서 다른 메소드를 부른 것
		String lastWord = startWord; // startWord에서부터 시작한다.
		System.out.println("시작하는 단어는 "+lastWord+"입니다");
		int next = 0; // 참가자들의 순서대로 증가
		
		//게임이 끝날 때까지 루프
		while(true) {
			// next 참가자가 단어를 말하도록 한다.
			String newWord = players[next].getWordFromUser();
			if(!players[next].checkSuccess(lastWord)) {
				System.out.print(players[next].getName() + "이(가) 졌습니다.");
				break; // 게임을 종료한다.
			} // end if() in while()
			next++; // 다음 참가자
			next %= players.length; // next가 참가자의 개수보다 많게 증가하는 것을 막는다.
			lastWord = newWord;
		} // end while()
		scanner.close();
	} //end run()
	
	// 메인 함수
	public static void main(String[] args) {
		WordGameApp game = new WordGameApp();
		game.run();
	}
}
