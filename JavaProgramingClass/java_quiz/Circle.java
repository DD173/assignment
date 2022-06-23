package java_quiz;
public class Circle implements Shape{

	int r; // 반지름
	double area, round;
	String color;

	public Circle(int r, String color) {
		this.r = r;
		this.color = color;
	}
	
	@Override
	public void draw() {
		System.out.println("반지름이 " + r + "인 원입니다.");
	}
	@Override
	public double getArea() {
		area = r*r*PI;
		return area;
	}
	@Override
	public double getRound() {
		round = 2*r*PI;
		return round;
	}
	@Override
	public String getColor() {
		return color;
	}

}
