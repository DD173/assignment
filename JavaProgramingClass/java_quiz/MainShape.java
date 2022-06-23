package java_quiz;

public class MainShape {
	
	static void line() {
		 System.out.println("-----------------------------------");
	}

	public static void main(String[] args) {
		Shape [] list = new Shape[3]; // Shape�� ��ӹ��� Ŭ���� ��ü�� ���۷��� �迭
		 list[0] = new Circle(20, "RED"); // �������� 20�� �� ��ü
		 list[1] = new Oval(20, 60, "GREEN"); // 20x60 �簢���� �����ϴ� Ÿ��
		 list[2] = new Rect(20, 50, "BLUE"); // 20x50 ũ���� �簢
		 
		line();
		for(int i=0; i<list.length; i++) list[i].redraw();
		line();
		for(int i=0; i<list.length; i++) System.out.println("������ " + list[i].getArea());
		line();
		for(int i=0; i<list.length; i++) System.out.println("�ѷ��� " + list[i].getRound());
		line();
		for(int i=0; i<list.length; i++) System.out.println("������ " + list[i].getColor());
		line();
		System.out.println("��ȭ���� �ι����д��� 2026007 ������");
		line();

	}

}
