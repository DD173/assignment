package baseEX1;

public class ObjectPropertyEx {

	public static void print(Object obj) {
		System.out.println(obj.getClass().getName()); // Ŭ���� �̸�
		System.out.println(obj.hashCode()); // �ؽ� �ڵ� ��
		System.out.println(obj.toString()); // ��ü�� ���ڿ��� ����� ���
		System.out.println(obj); // ��ü ���
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(2,3);
		print(p);
	}

}