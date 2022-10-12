package baekjoon.gold;

import java.util.Scanner;

public class Main_15961_회전초밥_Profesor {
	static int[] sushi;
	// 접시의 수
	static int N;
	// 초밥의 가짓수
	static int d;
	// 연속해서 먹는 접시의 수
	static int k;
	// 쿠폰 번호
	static int c;
	// 최대 초밥 가짓수
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		d = sc.nextInt();
		k = sc.nextInt();
		c = sc.nextInt();
		
		sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = sc.nextInt();
		}
		
		// 내가 먹은 초밥 카운트 기록용 배열 (초밥번호 1~d번까지)
		int[] cnt = new int[d+1];
		
		//쿠폰 초밥은 일단 먹고 시작하자. 나중에 처음먹나 어쩌나 처리하기 더 귀찮아
		cnt[c]++;
		
		// 일단 쿠폰으로 한가지 초밥 먹었음
		int tmp = 1;
		
		// 일단 맨 앞 k접시 먹어보자.
		for (int i = 0; i < k; i++) {
			if(cnt[sushi[i]] == 0) { // 오 처음 먹어보는 i번 접시의 초밥
				tmp++;
			}
			cnt[sushi[i]]++; // 처음 먹든 두번째 먹든 해당 번호 초밥 카운트 세어놓기
		}
		
		// i접시부터 k개 시작임
		for (int i = 1; i < N; i++) {
			//현재 시작접시 앞 접시의 초밥 카운트 빼기
			cnt[sushi[i-1]]--;
			
			// 앞 초밥은 이제 먹어본적 없어짐. 가짓수--
			if(cnt[sushi[i-1]] ==0) {
				tmp--;
			}
			// 처음 먹는 초밥이다!! 가짓수++
			// 영역을 초과할 수 있으므로 나머지로 계산해야 한다.
			if(cnt[sushi[(i+k-1)%N]] == 0) {
				tmp++;
			}
			//처음이든 아니든 해당 초밥 먹은 카운트
			cnt[sushi[(i+k-1)%N]]++;
			
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}
}
