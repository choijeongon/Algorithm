package 시뮬레이션.골드;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_14502_연구소 {
	
	static int N;
	static int M;
	static int totalCount;
	static int[][] board;
	static int[][] copyBoard;
	static HashMap<Integer, Position> map = new HashMap<>();
	
	static int[] numbers;
	static List<Integer> inputList;
	
	static int[] dx = {-1,0,+1,0};
	static int[] dy = {0,+1,0,-1};
	
	static boolean[][] visited;
	
	static int max;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		max = Integer.MIN_VALUE;
		totalCount = 0;
		board = new int[N][M];
		copyBoard = new int[N][M];
		
		numbers = new int[3];
		inputList= new ArrayList<>();
		int index = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
				
				//해당 칸이 빈칸이라면
				if(board[i][j] == 0) {
					map.put(index, new Position(i, j));
					inputList.add(index++);
					
				}
			}
		}
		//Input End
		
		
//		printBoard();
		
		comb(0,0);
//		
		System.out.println(max);
//		System.out.println("totalCount: " + totalCount);
		
		
	}
	
	static void comb(int cnt, int start) {
		if(cnt == 3) {
//			System.out.println(Arrays.toString(numbers));
			copy();
			visited = new boolean[N][M];
			
			//배치
			for(int value : numbers) {
				Position p = map.get(value);
				copyBoard[p.x][p.y] = 1;
			}
			
			//테스트
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copyBoard[i][j] == 2) {
						dfs(i, j);
					}
				}
			}
			
			int result = getCountZero();
			
			max = Math.max(max, result);
			return;
		}
		
		for (int i = start; i < inputList.size(); i++) {
			numbers[cnt] = inputList.get(i);
			comb(cnt+1, i+1);
		}
	}
	
	static int getCountZero() {
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copyBoard[i][j] == 0) {
					result++;
				}
			}
		}
		
		return result;
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		//감염시키기
		copyBoard[x][y] = 2;
		
		
		for (int d = 0; d < 4; d++) {
			int nextX = x+dx[d];
			int nextY = y+dy[d];
			
			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
				continue;
			}
			
			if(visited[nextX][nextY]) {
				continue;
			}
			
			if(copyBoard[nextX][nextY] == 0) {
				dfs(nextX, nextY);
			}
		}
	}
	
	static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyBoard[i][j] = board[i][j];
			}
		}
	}
	
	static void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
	
	static class Position{
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
	}
}
