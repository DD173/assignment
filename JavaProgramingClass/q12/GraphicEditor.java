package q12;

import java.util.Scanner;

public class GraphicEditor {
	private Shape start, last;
	private Scanner scanner;
	
	public GraphicEditor(){
		start = null;
		last = null;
		scanner = new Scanner(System.in);
	}
	
	int input; // �Է¹��� ������ ����
	Shape p;
	
	public void run() {
		
		System.out.println("�׷��� ������ beauty�� �����մϴ�.");
		
		while(true) {
			System.out.print("����(1), ����(2), ��� ����(3), ����(4)>>");
			input = scanner.nextInt();
			switch(input) {
				case 1: // 1. ����
					System.out.print("Line(1), Rect(2), Circle(3)>>");
					input = scanner.nextInt();
					insert(input);
					continue;
				case 2: // 2. ����
					System.out.print("������ ������ ��ġ>>");
					input = scanner.nextInt();
					delete(input);
					continue;
				case 3: // 3. ��� ����
					// last.setNext(null); // ���� �ݱ�
					view();
					continue;
				case 4: // 4. ����
					System.out.print("beauty�� �����մϴ�.");
					break;
				default: 
					System.out.println("1~4 �߿��� �Է��Ͻÿ�.");
					continue;
				} // end switch1
			break;
		} // end while
	}
	
	/* 1. ���� */
	public void insert(int input) {
		Shape graphic = null;
		// �׸���
		switch(input) {
		case 1: // Line
			graphic = new Line();
			break;
		case 2: // Rect
			graphic = new Rect();
			break;
		case 3: // Circle
			graphic = new Circle();
			break;
		default:
			System.out.println("Wrong Input");
			break;
		}
		if(start==null) { // ó�� insert�ϸ� ���۰� ���� ���� ����
			start = graphic;
			last = graphic;
		}
		else {
			last.setNext(graphic); // ��ü ����
			last = graphic; // �� ����
		}
	}	
	
	/* 2. ���� */
	public void delete(int input) {
		p = start; // ���� ���
		Shape temp = start; // �ӽ� ���
		int i;
		if(input==1) { // ù ��° ��� ����
			start = start.getNext();
			return;
		}
		for(i=1;i<input;i++) { // �� ��°~ ��� ����
			temp = p; // ���� ��� ����
			p = p.getNext(); // ���� ���� �̵�
			if(p==null) { // ������ �������� input�� Ŭ ��� ���� �Ұ���
				System.out.println("������ �� �����ϴ�.");
				return;
			}
		}
		if(i==input) { // ������ ��尡 �� ����� ��
			temp.setNext(p.getNext());
			last = temp; // ���� �ڸ���
		}
		else {
			while(p!=null)
				temp.setNext(p.getNext()); // ��� �� �߶�Ա�
		}
		
	}

	public void view() {
		p = start;
		while(p!=null) {
			p.draw();
			p = p.getNext();
		}
	}
	
	
	public static void main(String[] args) {
		GraphicEditor ge = new GraphicEditor();
		ge.run();
	}
}
