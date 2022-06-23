package baseEX2;

class Point {
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	// toString은 반드시 오버라이딩을 해야한다.
	public String toString() {
		return "Point(" + x + "," + y + ")";
	}
}

