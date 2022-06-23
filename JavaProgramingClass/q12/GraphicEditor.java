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
	
	int input; // 입력받은 정수값 저장
	Shape p;
	
	public void run() {
		
		System.out.println("그래픽 에디터 beauty를 실행합니다.");
		
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
			input = scanner.nextInt();
			switch(input) {
				case 1: // 1. 삽입
					System.out.print("Line(1), Rect(2), Circle(3)>>");
					input = scanner.nextInt();
					insert(input);
					continue;
				case 2: // 2. 삭제
					System.out.print("삭제할 도형의 위치>>");
					input = scanner.nextInt();
					delete(input);
					continue;
				case 3: // 3. 모두 보기
					// last.setNext(null); // 꼬리 닫기
					view();
					continue;
				case 4: // 4. 종료
					System.out.print("beauty를 종료합니다.");
					break;
				default: 
					System.out.println("1~4 중에서 입력하시오.");
					continue;
				} // end switch1
			break;
		} // end while
	}
	
	/* 1. 삽입 */
	public void insert(int input) {
		Shape graphic = null;
		// 그리기
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
		if(start==null) { // 처음 insert하면 시작과 끝에 도형 저장
			start = graphic;
			last = graphic;
		}
		else {
			last.setNext(graphic); // 객체 연결
			last = graphic; // 끝 변경
		}
	}	
	
	/* 2. 삭제 */
	public void delete(int input) {
		p = start; // 현재 노드
		Shape temp = start; // 임시 노드
		int i;
		if(input==1) { // 첫 번째 노드 삭제
			start = start.getNext();
			return;
		}
		for(i=1;i<input;i++) { // 두 번째~ 노드 삭제
			temp = p; // 현재 노드 저장
			p = p.getNext(); // 다음 노드로 이동
			if(p==null) { // 도형의 개수보다 input이 클 경우 삭제 불가능
				System.out.println("삭제할 수 없습니다.");
				return;
			}
		}
		if(i==input) { // 삭제할 노드가 끝 노드일 때
			temp.setNext(p.getNext());
			last = temp; // 꼬리 자르기
		}
		else {
			while(p!=null)
				temp.setNext(p.getNext()); // 가운데 똑 잘라먹기
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
