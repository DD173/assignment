package java_quiz;
public class Rect implements Shape{
	
	int a, b; // ����, ����
	double area, round;
	String color;
	
	public Rect(int a, int b, String color) {
		this.a = a;
		this.b = b;
		this.color = color;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(a + "x" + b + "ũ���� �簢�� �Դϴ�.");
	}
	@Override
	public double getArea() {
		area = a*b; // ����
		return area;
	}
	@Override
	public double getRound() {
		round = 2*a + 2*b; // �ѷ�
		return round;
	}
	@Override
	public String getColor() {
		return color;
	}

}
