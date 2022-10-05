package 완전탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17070_파이프옮기기1 {
	static int N;
	static int ans;
	static int[][] map;
	static int[] di = { 0, +1, +1 };
	static int[] dj = { +1, 0, +1 }; // 0: right, 1:down, 2:cross

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// Input End
		
		dfs(0,1,0);
//		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,1,0));
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			if(now.i == N-1 && now.j == N-1) {
				ans++;
			}
			for (int d = 0; d < 3; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				
				if(nexti < N && nextj < N && map[nexti][nextj] == 0) {
					if(now.dir==0 && d==1) {
						continue;
					}
					if(now.dir==1 && d==0) {
						continue;
					}
					if(d==2 && (map[now.i][now.j+1] == 1 || map[now.i+1][now.j]==1)) {
						continue;
					}
					
					queue.add(new Point(nexti, nextj, d));
				}
			}
			
		}
	}

	static void dfs(int nowi, int nowj, int dir) {
		if(nowi == N-1 && nowj == N-1) {
			ans++;
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];
			
			if(nexti < N && nextj < N && map[nexti][nextj] == 0) {
				if(dir==0 && d==1) {
					continue;
				}
				if(dir==1 && d==0) {
					continue;
				}
				if(d==2 && (map[nowi][nowj+1] == 1 || map[nowi+1][nowj]==1)) {
					continue;
				}
				
				dfs(nexti, nextj, d);
			}
		}
	}
	
	static class Point{
		int i;
		int j;
		int dir;
		
		public Point(int i, int j, int dir) {
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}
}