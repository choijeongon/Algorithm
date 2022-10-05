package 완전탐색.골드;

import java.util.Scanner;

public class Main_17070_파이프옮기기1 {
	static int N;
	
	static int board[][];
	
	static int totalCount;
	
	//가로, 세로, 대각선
	static int[] dx = {0, +1, +1};
	static int[] dy = {+1, 0, +1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		board = new int[N][N];
		
		totalCount = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
//		printBoard();
		
		//0: 가로, 1: 세로, 2: 대각선
		//초기 셋팅
		dfs(0, 1, 0);
		
		System.out.println(totalCount);
	}
	
	static void dfs(int x, int y, int direct) {
//		System.out.println("x: " + x + " y: " + y + " direct: " + direct);
		//기저 조건
		if((x == (N-1)) && (y == (N-1))) {
//			System.out.println("도착!!");
			totalCount += 1;
			return;
		}
		
		//방향이 가로인 경우
		if(direct == 0) {
			// 갈 수 있는 방법 2가지
			for (int d = 0; d <= 2; d+=2) {
				int nextX = x + dx[d];
				int nextY = y + dy[d];
				
//				System.out.println("nextX: " + nextX + " nextY: " + nextY);
				//대각선이 범위 벗어나는지 체크
				if(nextX >= N || nextY>= N) {
//					System.out.println("범위 벗어남");
					continue;
				}
				
				//가로방향 이동이라면
				if(d== 0) {
					// 오른쪽에 벽이 있다면 갈 수 없음
					if(board[nextX][nextY] == 1) {
//						System.out.println("가로 이동했는데 오른쪽 벽에 막힘");
						continue;
					}
					//통과했다면 이동하자!
					dfs(nextX, nextY, 0);
				} 
				//대각선 방향 이동이라면
				else if(d==2) {
					//3방향 체크
					//가로 체크
					if(board[x][y+1] == 1) {
						continue;
					}
					//세로 체크
					if(board[x+1][y] == 1) {
						continue;
					}
					//대각선 체크
					if(board[nextX][nextY] == 1) {
						continue;
					}
					//셋다 통과했다면 이동하자!
					dfs(nextX, nextY, 2);
				}
			}
		}
		//방향이 세로인 경우
		else if(direct == 1) {
			// 갈 수 있는 방법 2가지
			for (int d = 1; d <= 2; d++) {
				int nextX = x + dx[d];
				int nextY = y + dy[d];
				
//				System.out.println("nextX: " + nextX + " nextY: " + nextY);
				//대각선이 범위 벗어나는지 체크
				if(nextX >= N || nextY>= N) {
//					System.out.println("범위 벗어남");
					continue;
				}
				
				//세로방향 이동이라면
				if(d== 1) {
					// 아래에 벽이 있다면 갈 수 없음
					if(board[nextX][nextY] == 1) {
						continue;
					}
					//통과했다면 이동하자!
					dfs(nextX, nextY, 1);
				} 				
				//대각선 방향 이동이라면
				else if(d==2) {
					//3방향 체크
					//가로 체크
					if(board[x][y+1] == 1) {
						continue;
					}
					//세로 체크
					if(board[x+1][y] == 1) {
						continue;
					}
					//대각선 체크
					if(board[nextX][nextY] == 1) {
						continue;
					}
					//셋다 통과했다면 이동하자!
					dfs(nextX, nextY, 2);
				}
			}
		}
		//방향이 대각선인 경우
		else if(direct == 2) {
			// 갈 수 있는 방법 3가지
			for (int d = 0; d < 3; d++) {
				int nextX = x + dx[d];
				int nextY = y + dy[d];
				
				
//				System.out.println("nextX: " + nextX + " nextY: " + nextY);
				//대각선이 범위 벗어나는지 체크
				if(nextX >= N || nextY>= N) {
//					System.out.println("범위 벗어남");
					continue;
				}
				
				//가로 방향 이동이라면
				if(d== 0) {
					//가로 체크
					if(board[x][y+1] == 1) {
						continue;
					}
					
					//통과했다면 이동하자!
					dfs(nextX, nextY, 0);
				} else if(d==1) {
					//세로 체크
					if(board[x+1][y] == 1) {
						continue;
					}
					
					//통과했다면 이동하자!
					dfs(nextX, nextY, 1);
				} else if(d==2) {
					//3방향 체크
					//가로 체크
					if(board[x][y+1] == 1) {
						continue;
					}
					//세로 체크
					if(board[x+1][y] == 1) {
						continue;
					}
					//대각선 체크
					if(board[nextX][nextY] == 1) {
						continue;
					}
					//셋다 통과했다면 이동하자!
					dfs(nextX, nextY, 2);
				}
			}
		}
	}
	
	static void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}
}