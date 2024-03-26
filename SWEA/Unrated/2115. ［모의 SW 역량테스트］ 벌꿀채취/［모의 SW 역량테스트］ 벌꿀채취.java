

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, C;
	
	static int[][] grid;
	
	static int result1, result2, result;
	
	static int[] honey1, honey2;
	
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			M = Integer.parseInt(st.nextToken());
			
			C = Integer.parseInt(st.nextToken());
			
			grid = new int[N][N];

			honey1 = new int[M];
			
			honey2 = new int[M];
			
			result1 = 0;
			
			result2 = 0;
			
			result = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			findHoney1();
			
			System.out.println("#" + t + " " + result);
			
		}
	}
	
	public static void findHoney1() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-(M-1); j++) {
				
				for (int k = 0; k < M; k++) {
					honey1[k] = grid[i][j+k]; // 첫 일꾼 채집
				}
				
				visited = new boolean[M];
				result1 = 0;
				makePowerset(0, honey1, 1);
				result2 = 0;
				findHoney2(i, j);
				
				if (result1 + result2 > result) {
					result = result1 + result2;
				}
			}
		}
	}
	
	public static void findHoney2(int honey1Y, int honey1X) {
		
		int startX = honey1X + M;
		int startY = honey1Y;
		
		if (honey1X + M + (M -1) > N-1) {
			startX = 0;
			startY = honey1Y + 1;
		} 
		
		for (int i = startY; i < N; i++) {
			if (i == honey1Y) {
				for (int j = startX; j < N-(M-1); j++) {
					
					for (int k = 0; k < M; k++) {
						honey2[k] = grid[i][j+k];
					}
					
					visited = new boolean[M];
					makePowerset(0, honey2, 2);
				}
				continue;
			}
			for (int j = 0; j < N-(M-1); j++) {
				
				for (int k = 0; k < M; k++) {
					honey2[k] = grid[i][j+k];
				}
				
				visited = new boolean[M];
				makePowerset(0, honey2, 2);
				
			}
		}
	}
	
	public static void makePowerset(int depth, int[] honey, int type) {
		if (depth == M) {
			
			int sum = 0;
			
			for (int i = 0; i < M; i++) {
				if (visited[i]) {
					sum += honey[i];
				}
			}
			
			if (sum > C) {
				return;
			} else {
				int cnt = 0;
				for (int i = 0; i < M; i++) {
					if (visited[i]) {
						cnt += Math.pow(honey[i], 2);
					}
				}
				
				if (type == 1) {
					if (cnt > result1) {
						result1 = cnt;
					}
				} else {
					if (cnt > result2) {
						result2 = cnt;
					}
				}
				
			}
			
			
			return;
		}
		
		visited[depth] = true;
		makePowerset(depth + 1, honey, type);
		visited[depth] = false;
		makePowerset(depth + 1, honey, type);
	}
	
}
