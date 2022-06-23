package java_quiz2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;


public class WordQuiz {
	private String name; // WordQuiz ���α׷��� �̸�
	private Scanner scanner = new Scanner(System.in);
	private Vector<Word> v;
	public WordQuiz(String name) {
	this.name = name;
	v = new Vector<Word>();
	v.add(new Word("love", "���"));
	v.add(new Word("animal", "����"));
	v.add(new Word("emotion", "����"));
	v.add(new Word("human", "�ΰ�"));
	v.add(new Word("stock", "�ֽ�"));
	v.add(new Word("trade", "�ŷ�"));
	v.add(new Word("society", "��ȸ"));
	v.add(new Word("baby", "�Ʊ�"));
	v.add(new Word("honey", "����"));
	v.add(new Word("dall", "����"));
	v.add(new Word("bear", "��"));
	v.add(new Word("picture", "����"));
	v.add(new Word("painting", "�׸�"));
	v.add(new Word("fault", "����"));
	v.add(new Word("example", "����"));
	v.add(new Word("eye", "��"));
	v.add(new Word("statue", "������"));
	}
	
	
	public static void main(String[] args) {
	WordQuiz quiz = new WordQuiz("��ǰ����");
	quiz.run();
	}
	 
	private int makeExample(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1}; // -1�� �ʱ�ȭ
		int index;
		for(int i=0; i<n.length; i++) {
		do {
		index = (int)(Math.random()*v.size());
		} while(index == answerIndex || exists(n, index)); // �ٽ� �õ�
		n[i] = index;
		}
		for(int i=0; i<n.length; i++) ex[i] = n[i];
		return (int)(Math.random()*n.length); // ex[] �迭 ���� ������ ��ġ����. �̰��� ������ �ɴ´�.
	}
	
	private boolean exists(int n[], int index) {
		for(int i=0; i<n.length; i++) {
			if(n[i] == index)
				return true;
			}
		return false;
		}
	
	private void finish() {
		System.out.println("\"" + name + "\"�� �����մϴ�.");
		scanner.close();
	}
	
	public void run() {
		System.out.println("**** ���� �ܾ� �׽�Ʈ ���α׷� \"" + name + "\" �Դϴ�. ****");
		while(true) {
			System.out.print("�ܾ� �׽�Ʈ:1, �ܾ� ����:2, �ܾ� ����:3, ����:4>>");
			try {
				int input = scanner.nextInt(); // ����ڰ� �޴� �Է�
				switch(input) {
				case 1:
					wordQuiz();
					System.out.println(); // ���� �߰�
					continue;
				case 2:
					insertWords();
					System.out.println(); // ���� �߰�
					continue;
				case 3:
					deleteWords();
					System.out.println(); // ���� �߰�
					continue;
				case 4:
					break;
				default:
					System.out.println("1~3 ������ ������ �Է��Ͻÿ� !!");
					continue;
				}
				break;
			}
			catch(InputMismatchException e) {
				scanner.next();
				System.out.println("���ڸ� �Է��Ͻÿ� !!");
			}
		}
		finish();
	}
	
	/* 1. �ܾ� �׽�Ʈ */
	private void wordQuiz() {
		System.out.print("���� " + v.size() + "���� �ܾ ��� �ֽ��ϴ�. ");
		System.out.println("-1�� �Է��ϸ� �׽�Ʈ�� �����մϴ�.");
		while(true) {
			int answerIndex = (int)(Math.random()*v.size());
			String eng = v.get(answerIndex).getEnglish();
			
			// 4���� ���⸦ ���� ������ index �迭
			int example[] = new int[4];
			
			int answerLoc = makeExample(example, answerIndex);
			example[answerLoc] = answerIndex; // ���⿡ ���� �ε��� ����
			// System.out.println("example["+answerLoc+"] = " + answerIndex);
			
			//������ ����մϴ�.
			System.out.println(eng + "?");
			for(int i=0; i<example.length; i++)
				System.out.print("(" + (i+1) + ")" + v.get(example[i]).getKorean() + " ");
			System.out.print(":>"); // ������Ʈ
			try {
				int in = scanner.nextInt();
				if(in == -1) {
					break;
				}
			// ����ڰ� 1~4 ������ ���� �Է�
			in--;
			if(in == answerLoc)
				System.out.println("Excellent !!");
			else
				System.out.println("No !!");
			}
			catch(InputMismatchException e) {
				scanner.next();
				System.out.println("���ڸ� �Է��ϼ��� !!");
				// while ������ �ٽ� �ݺ�
			}
		}
	} // end wordQuiz()
	
	/* 2. �ܾ� ���� */
	private void insertWords() {
		System.out.println("���� �ܾ �׸��� �Է��ϸ� �Է��� �����մϴ�.");
		String inputEng, inputKor;
		while(true) {
			System.out.print("���� �ѱ� �Է� >> ");
			inputEng = scanner.next();
			// ���� �ܾ �׸��� �Է��ϸ� ����
			if(inputEng.equals("�׸�")) {
				scanner.nextLine();
				break;
			}
			inputKor = scanner.next();
			v.add(new Word(inputEng, inputKor));
		}
	} // end insertWords
	 
	/* 3. �ܾ� ���� */
	private void deleteWords() {
		// ���Ͱ� ����ִ� ���
		if(v.isEmpty()) {
			System.out.println("������ �ܾ �������� �ʽ��ϴ�.");
			return;
		}
		
		int input;
		
		System.out.println("��ȣ�� -1�� �Է��ϸ� �Է��� �����մϴ�.");
		
		while(true) {
			try {
			System.out.print("��ȣ >> ");
			input = scanner.nextInt();
			// -1�� �Է��ϸ� ����
			if(input==-1)
				break;
			else if(v.size() <= input) { // ����� �������� �� ū �ε����� �Է�
				System.out.println("�ε��� " + input + "��° �ܾ�� �������� �ʽ��ϴ�.");
				continue;
			}
			System.out.println(v.get(input).getEnglish() + "�� �����߽��ϴ�");
			v.remove(input);
			}catch(InputMismatchException e) {
				scanner.next();
				System.out.println("���ڸ� �Է��ϼ��� !!");
				// while ������ �ٽ� �ݺ�
			}
		}
		return;
	}
}
