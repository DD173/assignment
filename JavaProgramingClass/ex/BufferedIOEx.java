package ex;

import java.io.*;
import java.util.Scanner;

public class BufferedIOEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("c:\\Temp\\test2.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
			while((c=fin.read()) != -1) {
				out.write(c); // ���۰� �� �� �� ���ڰ� ȭ�鿡 ���
			}
			//���� �����Ͱ� ��� ��µ� ����
			new Scanner(System.in).nextLine(); // <Enter> Ű ��ٸ�
			out.flush();
			fin.close();
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
