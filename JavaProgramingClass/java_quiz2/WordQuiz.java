package java_quiz2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;


public class WordQuiz {
	private String name; // WordQuiz 프로그램의 이름
	private Scanner scanner = new Scanner(System.in);
	private Vector<Word> v;
	public WordQuiz(String name) {
	this.name = name;
	v = new Vector<Word>();
	v.add(new Word("love", "사랑"));
	v.add(new Word("animal", "동물"));
	v.add(new Word("emotion", "감정"));
	v.add(new Word("human", "인간"));
	v.add(new Word("stock", "주식"));
	v.add(new Word("trade", "거래"));
	v.add(new Word("society", "사회"));
	v.add(new Word("baby", "아기"));
	v.add(new Word("honey", "애인"));
	v.add(new Word("dall", "인형"));
	v.add(new Word("bear", "곰"));
	v.add(new Word("picture", "사진"));
	v.add(new Word("painting", "그림"));
	v.add(new Word("fault", "오류"));
	v.add(new Word("example", "보기"));
	v.add(new Word("eye", "눈"));
	v.add(new Word("statue", "조각상"));
	}
	
	
	public static void main(String[] args) {
	WordQuiz quiz = new WordQuiz("명품영어");
	quiz.run();
	}
	 
	private int makeExample(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1}; // -1로 초기화
		int index;
		for(int i=0; i<n.length; i++) {
		do {
		index = (int)(Math.random()*v.size());
		} while(index == answerIndex || exists(n, index)); // 다시 시도
		n[i] = index;
		}
		for(int i=0; i<n.length; i++) ex[i] = n[i];
		return (int)(Math.random()*n.length); // ex[] 배열 내의 임의의 위치리턴. 이곳에 정답을 심는다.
	}
	
	private boolean exists(int n[], int index) {
		for(int i=0; i<n.length; i++) {
			if(n[i] == index)
				return true;
			}
		return false;
		}
	
	private void finish() {
		System.out.println("\"" + name + "\"를 종료합니다.");
		scanner.close();
	}
	
	public void run() {
		System.out.println("**** 영어 단어 테스트 프로그램 \"" + name + "\" 입니다. ****");
		while(true) {
			System.out.print("단어 테스트:1, 단어 삽입:2, 단어 삭제:3, 종료:4>>");
			try {
				int input = scanner.nextInt(); // 사용자가 메뉴 입력
				switch(input) {
				case 1:
					wordQuiz();
					System.out.println(); // 공백 추가
					continue;
				case 2:
					insertWords();
					System.out.println(); // 공백 추가
					continue;
				case 3:
					deleteWords();
					System.out.println(); // 공백 추가
					continue;
				case 4:
					break;
				default:
					System.out.println("1~3 사이의 정수를 입력하시오 !!");
					continue;
				}
				break;
			}
			catch(InputMismatchException e) {
				scanner.next();
				System.out.println("숫자를 입력하시오 !!");
			}
		}
		finish();
	}
	
	/* 1. 단어 테스트 */
	private void wordQuiz() {
		System.out.print("현재 " + v.size() + "개의 단어가 들어 있습니다. ");
		System.out.println("-1을 입력하면 테스트를 종료합니다.");
		while(true) {
			int answerIndex = (int)(Math.random()*v.size());
			String eng = v.get(answerIndex).getEnglish();
			
			// 4개의 보기를 만들 벡터의 index 배열
			int example[] = new int[4];
			
			int answerLoc = makeExample(example, answerIndex);
			example[answerLoc] = answerIndex; // 보기에 정답 인덱스 저장
			// System.out.println("example["+answerLoc+"] = " + answerIndex);
			
			//문제를 출력합니다.
			System.out.println(eng + "?");
			for(int i=0; i<example.length; i++)
				System.out.print("(" + (i+1) + ")" + v.get(example[i]).getKorean() + " ");
			System.out.print(":>"); // 프롬프트
			try {
				int in = scanner.nextInt();
				if(in == -1) {
					break;
				}
			// 사용자가 1~4 사이의 정답 입력
			in--;
			if(in == answerLoc)
				System.out.println("Excellent !!");
			else
				System.out.println("No !!");
			}
			catch(InputMismatchException e) {
				scanner.next();
				System.out.println("숫자를 입력하세요 !!");
				// while 문으로 다시 반복
			}
		}
	} // end wordQuiz()
	
	/* 2. 단어 삽입 */
	private void insertWords() {
		System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
		String inputEng, inputKor;
		while(true) {
			System.out.print("영어 한글 입력 >> ");
			inputEng = scanner.next();
			// 영어 단어에 그만을 입력하면 종료
			if(inputEng.equals("그만")) {
				scanner.nextLine();
				break;
			}
			inputKor = scanner.next();
			v.add(new Word(inputEng, inputKor));
		}
	} // end insertWords
	 
	/* 3. 단어 삭제 */
	private void deleteWords() {
		// 백터가 비어있는 경우
		if(v.isEmpty()) {
			System.out.println("삭제할 단어가 존재하지 않습니다.");
			return;
		}
		
		int input;
		
		System.out.println("번호에 -1을 입력하면 입력을 종료합니다.");
		
		while(true) {
			try {
			System.out.print("번호 >> ");
			input = scanner.nextInt();
			// -1을 입력하면 종료
			if(input==-1)
				break;
			else if(v.size() <= input) { // 요소의 개수보다 더 큰 인덱스값 입력
				System.out.println("인덱스 " + input + "번째 단어는 존재하지 않습니다.");
				continue;
			}
			System.out.println(v.get(input).getEnglish() + "를 삭제했습니다");
			v.remove(input);
			}catch(InputMismatchException e) {
				scanner.next();
				System.out.println("숫자를 입력하세요 !!");
				// while 문으로 다시 반복
			}
		}
		return;
	}
}
