package java_quiz;
public class Oval implements Shape{

	int a, b; // 내접 사각형 가로, 세로
	double area, round;
	String color;

	public Oval(int a, int b, String color) {
		this.a = a;
		this.b = b;
		this.color = color;
	}
	
	@Override
	public void draw() {
		System.out.println(a + "x" + b + "에 내접하는 타원입니다.");
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
