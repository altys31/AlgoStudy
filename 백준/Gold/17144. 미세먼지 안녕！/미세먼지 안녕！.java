import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int circulTop = -1;
	static int circulBottom = -1;
	static int R;
	static int C;
	static int T;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<C; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if(value == -1 && circulTop == -1)
					circulTop = i;
				else if(value == -1 && circulBottom == -1)
					circulBottom = i;
			}
		}
		
		for(int i = 0; i<T; i++) {
			map = diffusion(map);
			//debugPrint(map);
			map = dustMove(map);
			//debugPrint(map);
		}
		
		int answer = 0;
		
		for(int[] a : map) {
			for(int b : a) {
				if(b != -1)
					answer += b;
			}
			
		}
		
		System.out.print(answer);
		
	}
	
	static int[][] diffusion (int[][] map) {
		

		int[][] newMap = new int[R][C];
		
		for(int i = 0; i<R; i++) {
			for(int j=0; j<C; j++) {
				
				if(map[i][j] == -1) {
					newMap[i][j] = -1;
					continue;
				}
				
				if(map[i][j] != -1) {
					int difCount = 0;
					int dust = map[i][j]/5;
					for(int k =0; k<4; k++) {
						
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						if(ny < R && ny >= 0 && nx <C && nx >= 0 && map[ny][nx] != -1) {
							newMap[ny][nx] += dust;
							difCount++;
						}
					}
					newMap[i][j] += map[i][j] - dust*(difCount);
				}
				
			}
		}
		
		return newMap;
		
	}
	
	static int[][] dustMove(int[][] map){
		
		int[][] newMap = new int[R][C];
		
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				
				int ny = i;
				int nx = j;
				
				if(map[i][j] == -1) {
					newMap[i][j] = -1;
					continue;
				}
				
				else if(j != 0 && i == circulTop) {
					if(j == C-1)
						ny--;
					else
						nx++;
				}
				
				else if(j != 0 && i == circulBottom) {
					if(j == C-1)
						ny++;
					else
						nx++;
				}
				
				
				else if(j == C-1 && circulTop > i) {
					if(i == 0) 
						nx--;
					else
						ny--;
				}
				
				else if(j == C-1 && circulBottom < i) {
					if(i == R-1) 
						nx--;
					else
						ny++;
				}
				
				else if(i == 0 && i != circulTop) {
					if(j == 0)
						ny++;
					else
						nx--;	
				}
				

				else if(i == R-1 && i != circulBottom) {
					if(j == 0)
						ny--;
					else
						nx--;
				}
				
				else if(j == 0 && circulTop > i) {
					ny++;
				}
				
				else if(j == 0 && circulBottom < i ) {
					ny--;
				}
				
		
				
				if(map[ny][nx] != -1)
					newMap[ny][nx] = map[i][j];
	
			}
		}
		
		return newMap;
	}
	
	static void debugPrint(int[][] map) {
		
		for(int[] a : map) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println("");
		
		}
		System.out.println("################");
		
	}

}
