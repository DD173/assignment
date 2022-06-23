package ex;
import java.io.*;

public class BinaryCopyEx {
	public static void main(String[] args) {
		File src = new File("c:\\Temp\\javasample\\img7.jpg");
		File dest1 = new File("c:\\Temp\\test1\\copyimg1.jpg");
		File dest2 = new File("c:\\Temp\\test1\\copyimg2.jpg");
		File dest3 = new File("c:\\Temp\\test1\\copyimg3.jpg");
		File dest4 = new File("c:\\Temp\\test1\\copyimg4.jpg");
		int c;
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo1 = new FileOutputStream(dest1);
			FileOutputStream fo2 = new FileOutputStream(dest2);
			FileOutputStream fo3 = new FileOutputStream(dest3);
			FileOutputStream fo4 = new FileOutputStream(dest4);
			while((c = fi.read()) != -1) {
				fo1.write((byte)c);
				fo2.write((byte)c);
				fo3.write((byte)c);
				fo4.write((byte)c);
			}
			fi.close();fo1.close();fo2.close();fo3.close();fo4.close();
			System.out.println(src.getPath()+"를 " 
					+ dest1.getPath()+ "로 복사하였습니다.");
			System.out.println(src.getPath()+"를 " 
					+ dest2.getPath()+ "로 복사하였습니다.");
			System.out.println(src.getPath()+"를 " 
					+ dest3.getPath()+ "로 복사하였습니다.");
			System.out.println(src.getPath()+"를 " 
					+ dest4.getPath()+ "로 복사하였습니다.");
			
			
		}catch (IOException e) {
			System.out.println("파일 복사 오류");
		}

	}

}
