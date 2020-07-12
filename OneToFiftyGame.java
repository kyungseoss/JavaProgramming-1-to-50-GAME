package Game;

import java.util.Random;
import java.util.Scanner;

/* 
 * #  1 to 50 게임
 * 1. 구글에서 1 to 50 이라고 검색해본다.
 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
 * 4. 숫자 1~9는 front 배열에 저장하고,
 *    숫자 10~18은 back 배열에 저장한다.
 */

public class OneToFiftyGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		final int SIZE = 9;
		
		int[] front = new int[SIZE];
		int[] back  = new int[SIZE];
		
		for(int i=0; i<SIZE; i++) {
			front[i] = i+1;
			back[i]  = SIZE + (i+1);
		}
		
		for(int i=0; i<1000; i++) {
			int r = ran.nextInt(SIZE);
			int temp = front[0];
			front[0] = front[r];
			front[r] = temp;
			
			r = ran.nextInt(SIZE);
			temp = back[0];
			back[0] = back[r];
			back[r] = temp;
		}
		
		int num = 1;
		while(true) {
			int answer = 0;
			for(int i=0; i<SIZE; i++) {
				if(num==front[i]) {
					answer = i;
				}
			}
			
			System.out.println(num + "[" + answer + "]");
			
			for(int i=0; i<SIZE; i++) {
				if(front[i] == 0) {
					System.out.print("\t");
				}else {
					System.out.print(front[i] + "\t");
				}
				if(i%3==2) {
					System.out.println("\n");
				}
			}
			
			System.out.print("["+ num + "]의 인덱스 입력 :");
			int idx = scan.nextInt();
			if(front[idx]==num) {
				if(1<=num && num<=SIZE) {
					front[idx] = back[idx];
				}else {
					front[idx] = 0;
				}
				num+=1;
			}
			
			if(num==19) {
				break;
			}
		}
	}
}
