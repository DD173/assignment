package base1014;
import java.util.*;

public class AlphabetHistogramApp {

	private int histoData [] = new int [26];
	
	public AlphabetHistogramApp() {
		for(int i=0; i<histoData.length; i++)
			histoData[i] = 0; // 초기에 카운팅 값을 모두 0으로 설정
	}
	
	public void run() {
		String s = readString();
		makeHistogram(s);
		drawHistogram();
		System.out.print("프로그램을 종료합니다.");
	}
	
	// 키보드로부터 문자열을 읽어 스트링 버퍼에 저장한다.
	String readString() {
		System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");
		StringBuffer sb = new StringBuffer(); // 키 입력을 받을 스트링버퍼 생성
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String line = scanner.nextLine(); // 텍스트 한 라인을 읽는다.
			if(line.length() == 1 && line.charAt(0)==';')
				break; // 입력 끝
			sb.append(line); // 읽은 라인 문자열을 스트링버퍼에 추가한다.
		}
		scanner.close();
		return sb.toString();
	}
	
	private void makeHistogram(String text) {
		String s = text.toString();
		s = s.toUpperCase(); // 스트링을 모두 대문자로 변경
		
		// 입력된 모든 문자를 비교하여 히스토 데이타를 만든다.
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') { // 알파벳 문자만 카운팅
				int index = c - 'A'; // 'A' - 'A' ==> 0
				histoData[index]++;
			}
		}
	}
	
	private void drawHistogram() {
		System.out.println("\n히스토그램을 그립니다.");
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
