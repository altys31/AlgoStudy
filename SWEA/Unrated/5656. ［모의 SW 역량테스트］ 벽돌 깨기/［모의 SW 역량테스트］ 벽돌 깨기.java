import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int W;
	static int H;
	static int answer;
	static int brickNum;
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int Test = 1; Test <= T; Test++) {
			
			st = new StringTokenizer(br.readLine());
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			brickNum = 0;
			int[] colNum = new int[W];
			
			int[][] map = new int[H][W];
			
			for(int i = 0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<W; j++) {
					int brick = Integer.parseInt(st.nextToken());
					map[i][j] = brick;
					if(brick > 0) {
						colNum[j]++;
						brickNum++;
					}
				}
			}
			
			dfs(map,0, colNum);
			bw.append("#").append(Integer.toString(Test)).append(" ").append(Integer.toString(answer)).append("\n");
			
		}
		bw.close();
	}
	
	
	static void dfs(int[][] map, int depth, int[] colNum) {
		
		if(depth == N) {
			int total = 0;
			for(int a : colNum) {
				total += a;
			}
//			for(int y = 0; y<H; y++) {
//				for(int x = 0; x<W; x++) {
//					System.out.print(map[y][x]);
//				}
//				System.out.println();
//			}
//			System.out.println("#####################");
			answer = Math.min(answer, total);
			return;
		}
		
		int[][] copiedMap = copyMap(map);
		
		
		for(int j = 0; j<W; j++) {
			if(colNum[j] != 0) {
			map = explodeBrick(H-colNum[j],j,map,map[H-colNum[j]][j]);
			map = dropBrick(map, colNum);
			}
			dfs(map,depth+1,colNum);

			
			restoreMap(copiedMap, map,colNum);
		}
		
	}
	
	static int[] copiedcolNum(int[] colNum) {
		int[] copiedcolNum = new int[W];
		for(int i = 0; i<W; i++) {
			copiedcolNum[i] = colNum[i];
		}
		return copiedcolNum;
	}
	
	
	static int[][] copyMap(int[][] map){
		int[][] copiedMap = new int[H][W];
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				copiedMap[i][j] = map[i][j];
			}
		}
		return copiedMap;
	}
	
	static void restoreMap(int[][]copiedMap, int[][] map, int[] colNum){
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				map[i][j] = copiedMap[i][j];
				if(map[i][j] != 0) {
					colNum[j] = Math.max(colNum[j], H-i);
				}
			}
		}
	}
	
	
	
	static int[][] explodeBrick(int y,int x, int[][] map, int size) {
		
		map[y][x] = 0;
		
		for(int i = 1; i<size; i++) {
			
			for(int j = 0; j<4; j++) {
				int ny = y+dy[j]*i;
				int nx = x+dx[j]*i;
				if(ny< H && ny >= 0 && nx<W && nx >=0 && map[ny][nx] > 0) {
					if(map[ny][nx] > 1) {
						map = explodeBrick(ny, nx , map, map[ny][nx]);
						map[ny][nx] = 0;
					}
					map[ny][nx] = 0;
	
				}
			}
		}
		return map;
	}
	
	
	static int[][] dropBrick(int[][] map, int[] colNum) {
		int[][] droppedmap = new int[H][W];
		
		for(int j = 0; j<W; j++) {
			int num = H-1;
			for(int i = H-1; i>=0; i--) {
				if(map[i][j] != 0) {
					droppedmap[num][j] = map[i][j];
					num--;
				}
			}
			colNum[j] = H-1-num;
		}
		
		return droppedmap;
		
	}
}