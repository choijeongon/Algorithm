package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2636_치즈 {

	static int H;
	static int W;
	static int[][] board;
	static boolean[][] visit; 
	static boolean[][] checked; 
	
	static int[] dx = {-1,0,+1,0};
	static int[] dy = {0,+1,0,-1};
	
	static int count;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		H = sc.nextInt();
		W = sc.nextInt();
		board = new int[H][W];
		count = 0;

		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		//Input End
		
		int time = 0;
		countChize();
		
		//치즈가 있으면 실행
		if(checkChize()) {
			while(true) {
				time++;
				
				//치즈 체크
				bfs();
				//치즈 삭제
				removeChecked();
				
				//치즈가 다 녹았으면 탈출
				if(!checkChize()) {
					break;
				}
				
				//치즈 갯수 새기
				countChize();
			}
		}
		
		System.out.println(time);
		System.out.println(count);
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		// 녹을 부분을 저장하는 배열
		checked = new boolean[H][W];
		visit = new boolean[H][W];
		
		queue.offer(new Point(0, 0));
		visit[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point currentPoint = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nextX = currentPoint.x + dx[d];
				int nextY = currentPoint.y + dy[d];
				
				//배열을 범위를 벗어난 친구들
				if(nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) {
					continue;
				}
				
				//이미 갔던곳은 안가도 된다.
				if(visit[nextX][nextY]) {
					continue;
				}
				
				if(board[nextX][nextY] == 0) {
					queue.offer(new Point(nextX, nextY));
					visit[nextX][nextY] = true;
				} else if(board[nextX][nextY] == 1) {
					checked[nextX][nextY] = true;
					visit[nextX][nextY] = true;
				}
			}
		}
	}
	
	// true이면 치즈가 있는거임
	static boolean checkChize() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(board[i][j] == 1) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	static void countChize() {
		count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(board[i][j] == 1) {
					count++;
				}
			}
		}
	}
	
	static void removeChecked() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(checked[i][j]) {
					board[i][j] = 0;
				}
			}
		}
	}
	
	static void printBoard() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
