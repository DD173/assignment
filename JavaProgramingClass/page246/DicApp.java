package page246;
import java.util.*;


public class DicApp {
	
	Scanner scanner = new Scanner(System.in);
	String word;
	
	public void run() {
		System.out.println("�ѿ� �ܾ� �˻� ���α׷��Դϴ�.");
		
		while(true) {
			System.out.print("�ѱ� �ܾ�?");
			word = scanner.next();
			if(word.equals("�׸�")) {
				break; //"�׸�"�� �Է��� ������ �ݺ�
			}
			else {
				if(Dictionary.findWord(word)) {
					System.out.println(word + "�� " + Dictionary.kor2Eng(word));
				}
				else
					System.out.println(word + "�� ���� ������ �����ϴ�.");
			}
		} //end while()
		scanner.close();
	} //end run()
	
	/* �����Լ� */
	public static void main(String[] args) {
		DicApp dicApp = new DicApp();
		dicApp.run();
	}
}

