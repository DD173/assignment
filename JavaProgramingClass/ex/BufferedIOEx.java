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
				out.write(c); // 버퍼가 꽉 찰 때 문자가 화면에 출력
			}
			//파일 데이터가 모두 출력된 상태
			new Scanner(System.in).nextLine(); // <Enter> 키 기다림
			out.flush();
			fin.close();
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
