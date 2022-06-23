package java_quiz;
public class Rect implements Shape{
	
	int a, b; // 가로, 세로
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
		System.out.println(a + "x" + b + "크기의 사각형 입니다.");
	}
	@Override
	public double getArea() {
		area = a*b; // 면적
		return area;
	}
	@Override
	public double getRound() {
		round = 2*a + 2*b; // 둘레
		return round;
	}
	@Override
	public String getColor() {
		return color;
	}

}
