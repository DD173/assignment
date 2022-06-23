package ȣ���;

import java.util.Random;
import java.util.Scanner;

/* ��ƼȦ�� ���� �ùķ��̼� ���α׷� */
public class ChangeOrNot {
	Random ran = new Random();
	String[] box = new String[3]; // 3���� ����
	int carIndex; // �ڵ����� ����ִ� �ε��� ������ ����
	int choose; // ������ �ε��� ������ ����
	int open; // ������ �ε��� ������ ����
	
	public void run() {
		int time, correctChangeSimul, correctNotChangeSimul; // �õ� Ƚ���� ���� Ƚ���� ������ ���� ����
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�ùķ��̼��� �����մϴ�.");
		System.out.print("�� �� �ݺ��Ͻðڽ��ϱ�?>> ");
		time = scanner.nextInt();
		correctChangeSimul = 0;
		correctNotChangeSimul = 0;
		// �Է��� Ƚ����ŭ �ݺ�
		for(int i=0; i<time; i++) 
		{
			if(changeSimul()) 
			{
				correctChangeSimul++;
			}
			if(notChangeSimul())
			{
				correctNotChangeSimul++;
			}
		} // end for()
		
		
		
		// Ȯ�� ���
		System.out.println("������ �ٲ� �ùķ��̼� ����� " + (double)correctChangeSimul/time*100 + "%");
		System.out.println("������ �ٲ��� ���� �ùķ��̼� ����� " + (double)correctNotChangeSimul/time*100 + "%");
		
		scanner.close();
		return;
	}
	
	// �ùķ��̼� ���� �Լ�
	public boolean changeSimul() {
		// �� ���� ���� �� �ѿ� '��' ����
		carIndex = ran.nextInt(3);
		for(int i=0; i<box.length; i++)
		{
			if(i==carIndex)
			{
				box[i] = "�ڵ���";
			}
			else
			{
				box[i] = "��";
			}
		}
		// �ϳ��� ����
		choose = ran.nextInt(3);
		
		// ������ �� �������� �ϳ��� ����
		while(true)
		{
			open = ran.nextInt(3);
			if(open != choose) 
			{
				if(box[open] == "��")
					break;
			}
		}
		
		// ������ ������ �� ���� �ٸ� ������ �ٲ�
		// ���� choose�� ������� ������ true ����
		if(box[choose] == "�ڵ���")
			return false;
		else
			return true;
	}
	
	public boolean notChangeSimul() {
		// �� ���� ���� �� �ѿ� '��' ����
		carIndex = ran.nextInt(3);
		for(int i=0; i<box.length; i++)
		{
			if(i==carIndex)
			{
				box[i] = "�ڵ���";
			}
			else
			{
				box[i] = "��";
			}
		}
		// �ϳ��� ����
		choose = ran.nextInt(3);
		
		if(box[choose] == "�ڵ���")
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args) {
		ChangeOrNot s = new ChangeOrNot();
		s.run();
		}
	
}
