package baekjoon.silver;

import java.util.Scanner;

public class Main_21921_블로그 {
	// 블로그를 하고 지난 일수
	static int N;
	
	// X일 동안 들어온 방문자 수
	static int X;
	
	static int[] list;
	
	static int currentValue;
	
	static int max;
	
	static int maxCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		X = sc.nextInt();
		
		list = new int[N];
		
		currentValue= 0;
		max= 0;
		maxCount=0;
		
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N-X+1; i++) {
			if(i==0) {
				for (int j = 0; j < X; j++) {
					currentValue += list[j];
				}
				max = currentValue;
				maxCount++;
			} else {
				//맨 앞에 값 빼주기
				currentValue -= list[i-1];
				//맨 뒤에 값 더해주기
				currentValue += list[i+X-1];
				
				if(max == currentValue) {
					maxCount++;
				} else if(currentValue > max) {
					max = currentValue;
					maxCount = 1;
				}
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(maxCount);
		}

	}
}
