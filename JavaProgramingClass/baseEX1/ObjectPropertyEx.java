package baseEX1;

public class ObjectPropertyEx {

	public static void print(Object obj) {
		System.out.println(obj.getClass().getName()); // 클래스 이름
		System.out.println(obj.hashCode()); // 해시 코드 값
		System.out.println(obj.toString()); // 객체를 문자열로 만들어 출력
		System.out.println(obj); // 객체 출력
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(2,3);
		print(p);
	}

}
