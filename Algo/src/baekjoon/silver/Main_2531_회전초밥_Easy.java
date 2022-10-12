package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2531_회전초밥_Easy {
	// 접시의 수
	static int N;
	// 초밥의 가짓수
	static int d;
	// 연속해서 먹는 접시의 수
	static int k;
	// 쿠폰 번호
	static int c;
	
	static int[] list;
	
	static boolean[] visit;
	
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		d = sc.nextInt();
		
		k = sc.nextInt();
		
		c = sc.nextInt();
		
		max = 0;
		
		list = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		
		for (int i = 0; i < N; i++) {
			visit = new boolean[d+1];
			// 쿠폰 발급받은 번호
			visit[c] = true;
			for (int j = 0; j < k; j++) {
				int index = i+j;
				
				if(index >= N) {
					index = i+j-N;
				}
//				System.out.println("index: " + index);
				
				visit[list[index]] = true;
			}
			
//			System.out.println(Arrays.toString(visit));
			
			max = Math.max(max, getCountVisitTrue());
		}
		
		System.out.println(max);
//		System.out.println(Arrays.toString(list));
		
	}
	
	static int getCountVisitTrue() {
		int count = 0;
		
		for (int i = 0; i < visit.length; i++) {
			if(visit[i]) {
				count++;
			}
		}
		
		return count;
	}
}