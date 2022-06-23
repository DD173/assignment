package base0909;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class UpAndDown {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // Ű���� �Է±� ����
		int low, high; //ī�忡 ���� ���� ����
		int card; // ī�忡 ���� ��ȣ ��(����)
		Random r = new Random(); // ���� �߻��� ����
		int num; // ����ڰ� �Է��� ����
		int i; // ������� ���� Ƚ��
		
		card = r.nextInt(100); // 0�� 99 ������ ���� ���� ����
		System.out.println("���� �����Ͽ����ϴ�. ���߾� ������.");
		low = 0; // ī�� ���� �ּ� ����
		high = 99; // ī�� ���� �ִ� ����
		i=1;
		// "n"�� �Էµ� ������ �ݺ��Ͽ� ������ �����Ѵ�.
		while(true) { 
			System.out.println(low + "-" + high); // ���� ���
			System.out.print(i + ">>");

				
			// ���� �Է� �ޱ�
			try{
				num = sc.nextInt();
				if(num==card) { //������ ��
					System.out.println(i + "�� ���� ������ϴ�");
					System.out.println("�ٽ��Ͻðڽ��ϱ�(y/n)");
					String answer = sc.next(); //���÷��� ���� �Է�
					if(answer.equals("y")) { 
						card = r.nextInt(100); // 0�� 99 ������ ���� ���� ����
						System.out.println("���� �����Ͽ����ϴ�. ���߾� ������.");
						low = 0; // ī�� ���� �ּ� ����
						high = 99; // ī�� ���� �ִ� ����
						i=1; // Ƚ�� �ʱ�ȭ
						continue;
					}
					break;
				}
				else if(num<card) { // �� ���� ���� �Էµ��� ��
					System.out.println("�� ����");
					low = num; // �ּҰ� ����
					i++;
					continue;
				}
				else{ // �� ū ���� �Էµ��� ��
					System.out.println("�� ����");
					high = num; // �ִ밪 ����
					i++;
					continue;
				}
					} // end try
			
			catch(InputMismatchException e){
				System.out.println("0�� 99 ������ ������ �Է����ּ���.");
				sc.nextLine(); // ���Ͱ� ���������Ƿ� ��� Ű�� ������.
				i = 1;
				continue; //�ٽ� �õ��Ѵ�.
				} // end catch
			
		} // end while
		sc.close();
	}  //end main
} // end class
