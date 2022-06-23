package base1028;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class WordQuiz {
	private String name; // 퀴즈 프로그램의 이름
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
		v.add(new Word("honey", "꿀"));
		v.add(new Word("football", "축구"));
		v.add(new Word("mother", "엄마"));
		v.add(new Word("father", "아빠"));
		v.add(new Word("spring", "봄"));
		v.add(new Word("summer", "여름"));
		v.add(new Word("autumn", "가을"));
		v.add(new Word("winter", "겨울"));
		v.add(new Word("room", "방"));
	}
	
	//보기 만들기
	private int makeExample(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1}; // -1로 초기화
		int index;
		for(int i=0; i<n.length; i++) {
			do {
				index = (int)(Math.random()*v.size());
			}while(index == answerIndex || exists(n, index));
			n[i] = index;
		} // end for
		
		for(int i=0; i<n.length; i++) {
			ex[i] = n[i];
		}
		return (int)(Math.random()*n.length);
		// ex[] 배열 내의 임의의 위치 리턴. 여기에 정답을 심는다.
	}
	
	
	private boolean exists(int[] n, int index) {
		for(int i=0; i<n.length;i++) {
			if(n[i] == index)
				return true;
		}
		return false;
	}
	
	
	/* 1. 단어 테스트 */
	private void wordTest() {
		Scanner scanner = new Scanner(System.in);
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
	}
	
	
	/* 2. 단어 삽입 */
	private void insertWord() {
		Scanner scanner = new Scanner(System.in);
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
	}
	
	
	

	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("**** 영어 단어 테스트 프로그램 \"" + name + "\" 입니다. ****");
		while(true) {
			System.out.print("단어 테스트:1, 단어 삽입:2, 종료:3>>");
			try {
				int input = scanner.nextInt(); // 사용자가 메뉴 입력
				switch(input) {
				case 1:
					wordTest();
					System.out.println(); // 공백 추가
					continue;
				case 2:
					insertWord();
					System.out.println(); // 공백 추가
					continue;
				case 3:
					System.out.println(); // 공백 추가
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
		scanner.close();
		System.out.print("\"" + name + "\"를 종료합니다.");
	}
	
	public static void main(String[] args) {
		 WordQuiz quiz = new WordQuiz("명품영어");
		 quiz.run();
	}
}
