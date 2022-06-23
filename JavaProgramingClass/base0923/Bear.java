package base0923;
import java.util.*;

public class Bear extends GameObject {
	private Scanner scanner;
	public Bear(int x, int y, int distance) {
		super(x, y, distance);
		scanner = new Scanner(System.in); // �����ڿ��� �޸� �Ҵ�
	}
	
	@Override
	public void move() {
		
		System.out.print("����(w), ����(a), �Ʒ�(s), ������(d)>>");
		char input = scanner.next().charAt(0);
		switch(input) {
		case 'w': // ����
			y--;
			if(y >= Game.MAX_Y) y = Game.MAX_Y -1;
			break;
		case 'a': // ����
			x--;
			if(x<0) x=0;
			break;
		case 's': // �Ʒ���
			y++;
			if(y<0) y=0;
			break;
		case 'd': // ������
			x++;
			if(x >= Game.MAX_X) x = Game.MAX_X -1;
			break;
		}
	}
	
	@Override
	public char getShape() {
		return 'B';
	}
}
