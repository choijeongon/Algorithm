package sw_expert_academy.d3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_3307_최장증가부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N]; //수열의 수들
			int[] C = new int[N]; // 동적테이블C[k] : 해당(k) 길이를 만족하는 자리(k자리)에 오는 수의 최소값
			
			for(int i =0; i< N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int size = 0;
			
			for(int i =0; i< N; i++) {
				int pos = Arrays.binarySearch(C, 0, size, arr[i]);
				if(pos >= 0) {
					continue;
				}
				
				int insertPos = Math.abs(pos)-1; //맨뒤, 기존원소 대체자리
				C[insertPos] = arr[i];
				
				if(insertPos == size) {
					size++;
				}
			}
			
			System.out.println("#"+tc +" " + size);
		}
	}
}
