package page245;
import java.util.*;

public class PhoneBook {
	/* 저장할 사람의 수를 입력받고 Phone 객체 배열 생성.
	 * 한 사람의 정보는 하나의 Phone 객체에 저장. */
	private Scanner scanner; //키보드 입력
	private Phone[] phones; //이름과 전화번호 
	int nPhones;
	
	public PhoneBook(){
		scanner = new Scanner(System.in);  // 메모리 할당
	} 
	
	// 인원수를 입력받고 Phone[]을 생성하는 메소드
	private void createPhones() {
		while(true) {
			try {
				System.out.print("인원수>>");
				nPhones = scanner.nextInt();
				scanner.nextLine();
				phones = new Phone[nPhones]; // Phone[] 레퍼런스 배열 생성
				// 각 참여자의 이름을 입력받아 Player 객체 생성
				for(int i=0;i<nPhones;i++) {
					System.out.print("이름과 전화번호(이름과 번호는 빈칸 없이 입력)>>");
					String name = scanner.next();
					String tel = scanner.nextLine();
					phones[i] = new Phone(name, tel);
					} 
				break;
			} // end try{}
			catch(InputMismatchException e){
				System.out.println("정수를 입력하여 주십시오.");
				scanner.next();
				continue;} // end catch{}
			} // end while(true);
		
	
	}
	
	// 검색한 이름의 번호를 찾아 출력하는 메소드
	public void searchTel(String input) {
		for(int i=0;i<nPhones;i++) {
			if(input.equals(phones[i].getName())){
				System.out.println(input + "의 번호는" + phones[i].getTel() + "입니다.");
				return;
			}
		} // end for
		System.out.println(input + "이(가) 없습니다.");
	}
	
	
	public void run() {
		createPhones();
		System.out.println("저장되었습니다...");
		while(true) {
			System.out.print("검색할 이름>>");
			String input = scanner.nextLine();
			if(input.equals("그만"))
				break;
			else 
				searchTel(input);
			
		} //end while(true)
		scanner.close();
	} // end run();
	
	/* 메인 함수 */
	public static void main(String[] args) {
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.run();
	}

}
