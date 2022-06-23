package java_quiz;

public class MainShape {
	
	static void line() {
		 System.out.println("-----------------------------------");
	}

	public static void main(String[] args) {
		Shape [] list = new Shape[3]; // Shape을 상속받은 클래스 객체의 레퍼런스 배열
		 list[0] = new Circle(20, "RED"); // 반지름이 20인 원 객체
		 list[1] = new Oval(20, 60, "GREEN"); // 20x60 사각형에 내접하는 타원
		 list[2] = new Rect(20, 50, "BLUE"); // 20x50 크기의 사각
		 
		line();
		for(int i=0; i<list.length; i++) list[i].redraw();
		line();
		for(int i=0; i<list.length; i++) System.out.println("면적은 " + list[i].getArea());
		line();
		for(int i=0; i<list.length; i++) System.out.println("둘레는 " + list[i].getRound());
		line();
		for(int i=0; i<list.length; i++) System.out.println("색상은 " + list[i].getColor());
		line();
		System.out.println("이화여대 인문과학대학 2026007 김지우");
		line();

	}

}
