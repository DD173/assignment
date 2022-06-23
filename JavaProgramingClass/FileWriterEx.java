import java.io.*;
import java.util.*;

public class FileWriterEx {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("c:\\Temp\\test.txt"); // 만약 해당 파일이 없으면 만든다!
			while(true) {
				String line = scanner.nextLine();
				if(line.length() == 0)
					break;
				fout.write(line, 0, line.length()); 
				// ->> 처음(0)부터 배열 크키(line.length개 문자)만큼 쓰기
				fout.write("\r\n", 0, 2); // 한 줄 띄우기 위해 /r/n을 파일에 저장
			}
			fout.close();
		} catch(IOException e) {
			System.out.println("입출력 오류");
		}
		scanner.close();
	}
}
