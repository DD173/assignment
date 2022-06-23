package base0909;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class UpAndDown {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 키보드 입력기 생성
		int low, high; //카드에 적힌 수의 범위
		int card; // 카드에 적힌 번호 값(정답)
		Random r = new Random(); // 난수 발생기 생성
		int num; // 사용자가 입력한 정수
		int i; // 사용자의 시행 횟수
		
		card = r.nextInt(100); // 0과 99 사이의 정수 난수 생성
		System.out.println("수를 결정하였습니다. 맞추어 보세요.");
		low = 0; // 카드 값의 최소 범위
		high = 99; // 카드 값의 최대 범위
		i=1;
		// "n"가 입력될 때까지 반복하여 게임을 진행한다.
		while(true) { 
			System.out.println(low + "-" + high); // 범위 출력
			System.out.print(i + ">>");

				
			// 정수 입력 받기
			try{
				num = sc.nextInt();
				if(num==card) { //맞췄을 때
					System.out.println(i + "번 만에 맞췄습니다");
					System.out.println("다시하시겠습니까(y/n)");
					String answer = sc.next(); //리플레이 여부 입력
					if(answer.equals("y")) { 
						card = r.nextInt(100); // 0과 99 사이의 정수 난수 생성
						System.out.println("수를 결정하였습니다. 맞추어 보세요.");
						low = 0; // 카드 값의 최소 범위
						high = 99; // 카드 값의 최대 범위
						i=1; // 횟수 초기화
						continue;
					}
					break;
				}
				else if(num<card) { // 더 작은 수가 입력됐을 때
					System.out.println("더 높게");
					low = num; // 최소값 수정
					i++;
					continue;
				}
				else{ // 더 큰 수가 입력됐을 때
					System.out.println("더 낮게");
					high = num; // 최대값 수정
					i++;
					continue;
				}
					} // end try
			
			catch(InputMismatchException e){
				System.out.println("0과 99 사이의 정수를 입력해주세요.");
				sc.nextLine(); // 엔터가 남아있으므로 모든 키를 버린다.
				i = 1;
				continue; //다시 시도한다.
				} // end catch
			
		} // end while
		sc.close();
	}  //end main
} // end class
