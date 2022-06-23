package java_quiz;

interface Shape {
	final double PI = 3.14;
	void draw(); // ������ �׸��� �߻� �޼ҵ�
	double getArea(); // ������ ������ �����ϴ� �߻� �޼ҵ�
	double getRound(); // ������ �ѷ��� �����ϴ� �߻� �޼ҵ�
	String getColor(); // ������ ������ �����ϴ� �߻� �޼ҵ�
	default public void redraw() { // ����Ʈ �޼ҵ�
	System.out.print("--- �ٽ� �׸��ϴ�. ");
	draw();
	}
}
