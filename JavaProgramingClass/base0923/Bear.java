package base0923;
import java.util.*;

public class Bear extends GameObject {
	private Scanner scanner;
	public Bear(int x, int y, int distance) {
		super(x, y, distance);
		scanner = new Scanner(System.in); // 생성자에서 메모리 할당
	}
	
	@Override
	public void move() {
		
		System.out.print("위쪽(w), 왼쪽(a), 아래(s), 오른쪽(d)>>");
		char input = scanner.next().charAt(0);
		switch(input) {
		case 'w': // 위쪽
			y--;
			if(y >= Game.MAX_Y) y = Game.MAX_Y -1;
			break;
		case 'a': // 왼쪽
			x--;
			if(x<0) x=0;
			break;
		case 's': // 아래쪽
			y++;
			if(y<0) y=0;
			break;
		case 'd': // 오른쪽
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
