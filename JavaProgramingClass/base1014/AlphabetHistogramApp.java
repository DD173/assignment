package base1014;
import java.util.*;

public class AlphabetHistogramApp {

	private int histoData [] = new int [26];
	
	public AlphabetHistogramApp() {
		for(int i=0; i<histoData.length; i++)
			histoData[i] = 0; // �ʱ⿡ ī���� ���� ��� 0���� ����
	}
	
	public void run() {
		String s = readString();
		makeHistogram(s);
		drawHistogram();
		System.out.print("���α׷��� �����մϴ�.");
	}
	
	// Ű����κ��� ���ڿ��� �о� ��Ʈ�� ���ۿ� �����Ѵ�.
	String readString() {
		System.out.println("���� �ؽ�Ʈ�� �Է��ϰ� �����ݷ��� �Է��ϼ���.");
		StringBuffer sb = new StringBuffer(); // Ű �Է��� ���� ��Ʈ������ ����
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String line = scanner.nextLine(); // �ؽ�Ʈ �� ������ �д´�.
			if(line.length() == 1 && line.charAt(0)==';')
				break; // �Է� ��
			sb.append(line); // ���� ���� ���ڿ��� ��Ʈ�����ۿ� �߰��Ѵ�.
		}
		scanner.close();
		return sb.toString();
	}
	
	private void makeHistogram(String text) {
		String s = text.toString();
		s = s.toUpperCase(); // ��Ʈ���� ��� �빮�ڷ� ����
		
		// �Էµ� ��� ���ڸ� ���Ͽ� ������ ����Ÿ�� �����.
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') { // ���ĺ� ���ڸ� ī����
				int index = c - 'A'; // 'A' - 'A' ==> 0
				histoData[index]++;
			}
		}
	}
	
	private void drawHistogram() {
		System.out.println("\n������׷��� �׸��ϴ�.");
		for(int i=0; i<histoData.length; i++) {
			System.out.print((char)('A'+i) + ":");
			
			for(int j=0; j<histoData[i]; j++) {
				System.out.print('-');
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlphabetHistogramApp app = new AlphabetHistogramApp();
		app.run();
	}
	
	

}
