package base0909;

import java.util.Scanner;

public class GameGBBMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������� �����Դϴ�. ����, ����, �� �߿��� �Է��ϼ���.");
		System.out.print("��ȭ >> ");
		String a = scanner.next(); // ��ȭ�� ����, ����, ��, ���ڿ��� �Է¹޴´�.
		System.out.print("�İ� >> ");
		String b = scanner.next(); // �İ��� ����, ����, ��, ���ڿ��� �Է¹޴´�.

		if(a.equals("����")) {
			if(b.equals("����")) 
				System.out.println("�����ϴ�.");
			else if(b.equals("����")) 
				System.out.println("�İ��� �̰���ϴ�.");
			else if(b.equals("��")) 
				System.out.println("��ȭ�� �̰���ϴ�.");
		}
		
		else if(a.equals("����")) {
			if(b.equals("����")) 
				System.out.println("��ȭ�� �̰���ϴ�.");
			else if(b.equals("����")) 
				System.out.println("�����ϴ�.");
			else if(b.equals("��")) 
				System.out.println("�İ��� �̰���ϴ�.");
		}
		
		else if(a.equals("��")) {
			if(b.equals("����")) 
				System.out.println("�İ��� �̰���ϴ�.");
			else if(b.equals("����")) 
				System.out.println("��ȭ�� �̰���ϴ�.");
			else if(b.equals("��")) 
				System.out.println("�����ϴ�.");
		}
		
		scanner.close();
	}

}
