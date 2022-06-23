package base0909;

import java.util.Scanner;

public class GameGBBMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요.");
		System.out.print("이화 >> ");
		String a = scanner.next(); // 이화의 가위, 바위, 보, 문자열을 입력받는다.
		System.out.print("컴공 >> ");
		String b = scanner.next(); // 컴공의 가위, 바위, 보, 문자열을 입력받는다.

		if(a.equals("가위")) {
			if(b.equals("가위")) 
				System.out.println("비겼습니다.");
			else if(b.equals("바위")) 
				System.out.println("컴공이 이겼습니다.");
			else if(b.equals("보")) 
				System.out.println("이화가 이겼습니다.");
		}
		
		else if(a.equals("바위")) {
			if(b.equals("가위")) 
				System.out.println("이화가 이겼습니다.");
			else if(b.equals("바위")) 
				System.out.println("비겼습니다.");
			else if(b.equals("보")) 
				System.out.println("컴공이 이겼습니다.");
		}
		
		else if(a.equals("보")) {
			if(b.equals("가위")) 
				System.out.println("컴공이 이겼습니다.");
			else if(b.equals("바위")) 
				System.out.println("이화가 이겼습니다.");
			else if(b.equals("보")) 
				System.out.println("비겼습니다.");
		}
		
		scanner.close();
	}

}
