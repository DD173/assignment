package base0916;
import java.util.*;

// �� ����� �����ڸ� ǥ���ϴ� Ŭ����
public class Player {
	private Scanner scanner; //Ű���� �Է� 
	private String name; // ���� �������� �̸�
	private String word; // �����ڰ� ���� �ܾ� 
	// ��� �ʵ�� �ʱ�ȭ x, �����ڿ� ���� �ؾ���
	
	public Player(String name) {
		this.name = name; // ���⼭ this.name�� ���� ������ private name
		scanner = new Scanner(System.in);
		
	}
	
	public String getName() {return name;}  // �޼ҵ�� ����
	
	public String getWordFromUser() {
		System.out.print(name + ">>");
		word = scanner.nextLine();
		return word;
	}
	
	// lastWord�� �����ڰ� ���� word�� ���Ͽ� �����ձⰡ �� �Ǿ����� �Ǵ�.
	// �����Ͽ����� true ����
	public boolean checkSuccess(String lastWord) {
		int lastIndex = lastWord.length()-1; // ���� �ܾ��� �� ������ ���ڿ� �����ڰ� ���� �ܾ��� ù ���ڰ� ������ ��
		if(lastWord.charAt(lastIndex)==word.charAt(0))
			return true;
		else
			return false;
	}
}
