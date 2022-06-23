package 호기심;

import java.util.Random;
import java.util.Scanner;

/* 몬티홀의 문제 시뮬레이션 프로그램 */
public class ChangeOrNot {
	Random ran = new Random();
	String[] box = new String[3]; // 3개의 상자
	int carIndex; // 자동차가 들어있는 인덱스 저장할 변수
	int choose; // 선택할 인덱스 저장할 변수
	int open; // 오픈할 인덱스 저장할 변수
	
	public void run() {
		int time, correctChangeSimul, correctNotChangeSimul; // 시도 횟수와 정답 횟수를 저장할 변수 선언
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("시뮬레이션을 시작합니다.");
		System.out.print("몇 번 반복하시겠습니까?>> ");
		time = scanner.nextInt();
		correctChangeSimul = 0;
		correctNotChangeSimul = 0;
		// 입력한 횟수만큼 반복
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
		
		
		
		// 확률 계산
		System.out.println("선택을 바꾼 시뮬레이션 정답률 " + (double)correctChangeSimul/time*100 + "%");
		System.out.println("선택을 바꾸지 않은 시뮬레이션 정답률 " + (double)correctNotChangeSimul/time*100 + "%");
		
		scanner.close();
		return;
	}
	
	// 시뮬레이션 돌릴 함수
	public boolean changeSimul() {
		// 세 가지 보기 중 둘에 '양' 삽입
		carIndex = ran.nextInt(3);
		for(int i=0; i<box.length; i++)
		{
			if(i==carIndex)
			{
				box[i] = "자동차";
			}
			else
			{
				box[i] = "양";
			}
		}
		// 하나를 선택
		choose = ran.nextInt(3);
		
		// 나머지 중 랜덤으로 하나를 오픈
		while(true)
		{
			open = ran.nextInt(3);
			if(open != choose) 
			{
				if(box[open] == "양")
					break;
			}
		}
		
		// 선택을 오픈한 것 빼고 다른 것으로 바꿈
		// 양이 choose에 들어있지 않으면 true 리턴
		if(box[choose] == "자동차")
			return false;
		else
			return true;
	}
	
	public boolean notChangeSimul() {
		// 세 가지 보기 중 둘에 '양' 삽입
		carIndex = ran.nextInt(3);
		for(int i=0; i<box.length; i++)
		{
			if(i==carIndex)
			{
				box[i] = "자동차";
			}
			else
			{
				box[i] = "양";
			}
		}
		// 하나를 선택
		choose = ran.nextInt(3);
		
		if(box[choose] == "자동차")
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args) {
		ChangeOrNot s = new ChangeOrNot();
		s.run();
		}
	
}
