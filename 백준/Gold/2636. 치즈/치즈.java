import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int H;
	static int W;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Boolean[][] map = new Boolean[H][W];
		
		
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0; j<W; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					map[i][j] = true;
			}
		}
		
		bfs(0,map,0);
		
	}
	
	static void bfs(int depth,Boolean[][] map,int previous) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[H][W];
		
		boolean check = false;
		int answer = 0;
		
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				if(i == 0 || i == H-1 || j == 0 || j == W-1) {
					if(map[i][j] != null && map[i][j] ) {
						map[i][j] = false;
						answer++;
					}
					else {
						q.add(new int[] {i,j});
					}
				}
				else
					continue;
			}
		}
		
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			
			if(!visited[pos[0]][pos[1]]) {
				visited[pos[0]][pos[1]] = true;
				
				if(map[pos[0]][pos[1]] != null && !map[pos[0]][pos[1]])
					continue;
				
				if(map[pos[0]][pos[1]] != null && map[pos[0]][pos[1]]) {
					map[pos[0]][pos[1]] = false;
					continue;
				}
				
				for(int i = 0; i<4; i++) {
					int ny = pos[0] +dy[i];
					int nx = pos[1] +dx[i];
					
					if(ny < H && ny>= 0 && nx <W && nx>= 0 && !visited[ny][nx]) {
						if((map[ny][nx] != null && map[ny][nx]) || map[ny][nx] == null) {
							q.add(new int[] {ny,nx});
						}
					}
				}
			}
		}
		
		
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				if(map[i][j] != null && !map[i][j]) {
					answer++;
					check = true;
					map[i][j] = null;
				}
			}
		}

		if(!check) {
			System.out.println(depth);
			System.out.println(previous);
		}
		else {
			bfs(depth+1,map,answer);
		}
	}
}