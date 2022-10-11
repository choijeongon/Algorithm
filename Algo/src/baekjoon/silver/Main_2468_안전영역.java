package baekjoon.silver;

import java.util.Scanner;

public class Main_2468_안전영역 {
	static int N;
	static int[][] board;
	static boolean[][] visit;
	
	static int[] dx = {-1,0,+1,0};
	static int[] dy = {0,+1,0,-1};
	
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		board = new int[N][N];
		
		max = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
//		print();
		
		for (int h = 1; h <= 100; h++) {
			visit= new boolean[N][N];
			
			// 1. 물에 잠기기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(board[i][j] <= h) {
						visit[i][j] = true;
					}
				}
			}
			
			int count = 0;
			
			// 2. 안전 영역 구하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			
			// 3. max값 업데이트
			max = Math.max(max, count);
		}
		
		System.out.println(max);
		
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nextX = x + dx[d];
			int nextY = y + dy[d];
			
			if(nextX < 0  || nextY < 0 || nextX >= N || nextY >= N) {
				continue;
			}
			
			if(!visit[nextX][nextY]) {
				dfs(nextX, nextY);
			}
				
		}
	}
	
	
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}
}
