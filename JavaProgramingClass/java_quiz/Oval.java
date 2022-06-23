package java_quiz;
public class Oval implements Shape{

	int a, b; // ���� �簢�� ����, ����
	double area, round;
	String color;

	public Oval(int a, int b, String color) {
		this.a = a;
		this.b = b;
		this.color = color;
	}
	
	@Override
	public void draw() {
		System.out.println(a + "x" + b + "�� �����ϴ� Ÿ���Դϴ�.");
	}
	@Override
	public double getArea() {
		area = (a/2)*(b/2)*PI;
		return area;
	}
	@Override
	public double getRound() {
		round = 2*PI*Math.pow((0.5*(((a/2)*(a/2))+((b/2)*(b/2)))),0.5);
		return round;
	}
	@Override
	public String getColor() {
		return color;
	}
}
