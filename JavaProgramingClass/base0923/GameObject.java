package base0923;

public abstract class GameObject { // �߻� Ŭ����
	protected int distance; // �� �� �̵� �Ÿ�
	protected int x, y; // ���� ��ġ(ȭ�� �� ���� ��ġ)
	
	public GameObject(int startX, int startY, int distance) { 
		this.x = startX; this.y = startY;
		this.distance = distance;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public boolean collide(GameObject p) {
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else 
			return false;
	}
	
	/*�������̵� �ؾ� ��*/
	protected abstract void move(); // �̵��� ���� ���ο� ��ġ�� x, y ����
	protected abstract char getShape(); // ��ü�� ����� ��Ÿ���� ���� ����
}
