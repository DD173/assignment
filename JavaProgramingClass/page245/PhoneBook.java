package page245;
import java.util.*;

public class PhoneBook {
	/* ������ ����� ���� �Է¹ް� Phone ��ü �迭 ����.
	 * �� ����� ������ �ϳ��� Phone ��ü�� ����. */
	private Scanner scanner; //Ű���� �Է�
	private Phone[] phones; //�̸��� ��ȭ��ȣ 
	int nPhones;
	
	public PhoneBook(){
		scanner = new Scanner(System.in);  // �޸� �Ҵ�
	} 
	
	// �ο����� �Է¹ް� Phone[]�� �����ϴ� �޼ҵ�
	private void createPhones() {
		while(true) {
			try {
				System.out.print("�ο���>>");
				nPhones = scanner.nextInt();
				scanner.nextLine();
				phones = new Phone[nPhones]; // Phone[] ���۷��� �迭 ����
				// �� �������� �̸��� �Է¹޾� Player ��ü ����
				for(int i=0;i<nPhones;i++) {
					System.out.print("�̸��� ��ȭ��ȣ(�̸��� ��ȣ�� ��ĭ ���� �Է�)>>");
					String name = scanner.next();
					String tel = scanner.nextLine();
					phones[i] = new Phone(name, tel);
					} 
				break;
			} // end try{}
			catch(InputMismatchException e){
				System.out.println("������ �Է��Ͽ� �ֽʽÿ�.");
				scanner.next();
				continue;} // end catch{}
			} // end while(true);
		
	
	}
	
	// �˻��� �̸��� ��ȣ�� ã�� ����ϴ� �޼ҵ�
	public void searchTel(String input) {
		for(int i=0;i<nPhones;i++) {
			if(input.equals(phones[i].getName())){
				System.out.println(input + "�� ��ȣ��" + phones[i].getTel() + "�Դϴ�.");
				return;
			}
		} // end for
		System.out.println(input + "��(��) �����ϴ�.");
	}
	
	
	public void run() {
		createPhones();
		System.out.println("����Ǿ����ϴ�...");
		while(true) {
			System.out.print("�˻��� �̸�>>");
			String input = scanner.nextLine();
			if(input.equals("�׸�"))
				break;
			else 
				searchTel(input);
			
		} //end while(true)
		scanner.close();
	} // end run();
	
	/* ���� �Լ� */
	public static void main(String[] args) {
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.run();
	}

}
