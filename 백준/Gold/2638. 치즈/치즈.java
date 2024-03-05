import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
 			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		bfs(q, map,1);
		
	}
	
	static void bfs(Queue<int[]> q, int[][] map,int depth){
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i< N; i++) {
			for(int j = 0; j<M; j++) {
				if(i== 0 || i == N-1 || j == 0 || j == M-1) {
					q.add(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			
			for(int i =0; i<4; i++) {
				int ny = pos[0]+dy[i];
				int nx = pos[1]+dx[i];
				
				if(ny <N && ny >=0 && nx <M && nx>=0) {
					if(map[ny][nx] > 0)
						map[ny][nx]++;
					else if(map[ny][nx] ==0 &&!visited[ny][nx]) {
						q.add(new int[] {ny,nx});
						visited[ny][nx] = true;
					}
				}
			}
		}
		
		boolean check = false;
		for(int i= 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] > 2) {
					map[i][j] = 0;
				}
				if(map[i][j] == 2) {
					map[i][j] = 1;
				}
				if(map[i][j] != 0)
					check = true;
			}
		}
		
		if(check)
			bfs(q,map,depth+1);
		else
			System.out.println(depth);
	}
}
