package base0916;
import java.util.*;

public class WordGameApp {

	/* private�� ���� Ŭ���� �ȿ��� �ǹ� ���� */
	private Scanner scanner;  // Ű���� �Է�
	private String startWord = "�ƹ���";  // ���� �ܾ�
	private Player[] players; // ���� �����ڵ�
	
	
	public WordGameApp(){
		scanner = new Scanner(System.in);  // �޸� �Ҵ�
	} 

	
	// ���� ������ ���� �Է¹ް� Player[]�� �����ϴ� �޼ҵ� 
	private void createPlayers() {
		while(true) {
		try {
			System.out.print("���ӿ� �����ϴ� �ο��� ����Դϱ�>>");
			int nPlayers = scanner.nextInt();
			scanner.nextLine();
			players = new Player[nPlayers]; // Player[] ���۷��� �迭 ����
			// �� �������� �̸��� �Է¹޾� Player ��ü ����
			for(int i=0;i<nPlayers;i++) {
				System.out.print("�������� �̸��� �Է��ϼ���>>");
				String name = scanner.nextLine();
				players[i] = new Player(name);}
			break;
		} // end try{}
		catch(InputMismatchException e){
			System.out.println("������ �Է��Ͽ� �ֽʽÿ�.");
			scanner.next();
			continue;
		} // end catch{}
		} // end while(true);
		
	} // end createPlayers()
	public void run() {
		System.out.println("�����ձ� ������ �����մϴ�...");
		createPlayers(); // �����ڸ� ���� Player []�� �����Ѵ�. ���� Ŭ���� �ȿ��� �ٸ� �޼ҵ带 �θ� ��
		String lastWord = startWord; // startWord�������� �����Ѵ�.
		System.out.println("�����ϴ� �ܾ�� "+lastWord+"�Դϴ�");
		int next = 0; // �����ڵ��� ������� ����
		
		//������ ���� ������ ����
		while(true) {
			// next �����ڰ� �ܾ ���ϵ��� �Ѵ�.
			String newWord = players[next].getWordFromUser();
			if(!players[next].checkSuccess(lastWord)) {
				System.out.print(players[next].getName() + "��(��) �����ϴ�.");
				break; // ������ �����Ѵ�.
			} // end if() in while()
			next++; // ���� ������
			next %= players.length; // next�� �������� �������� ���� �����ϴ� ���� ���´�.
			lastWord = newWord;
		} // end while()
		scanner.close();
	} //end run()
	
	// ���� �Լ�
	public static void main(String[] args) {
		WordGameApp game = new WordGameApp();
		game.run();
	}
}
