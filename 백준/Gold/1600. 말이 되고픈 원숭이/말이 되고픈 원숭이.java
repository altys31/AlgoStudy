
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[] angle_x = {1,-1,1,-1};
	static int[] angle_y = {1,1,-1,-1};
	static int[][] horse_move = {{2,1},{1,2}};
	
	static boolean[][][] visited;
	
	static int W;
	static int H;
	static int answer;
	
	static class Pos{
		int x;
		int y;
		int k;
		int dt;
		
		public Pos(int y, int x, int k, int dt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.dt = dt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		boolean [][] map = new boolean[H][W];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<W; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = true;
				}
			}
		}
		visited = new boolean[K+1][H][W];
		map[0][0] = true;
		
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(0,0,K,0));
		bfs(q,0,0,0,map);
		
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
		
	}
	
	static void bfs(Queue<Pos> q, int y, int x,int depth, boolean[][] map) {
		int nx;
		int ny;
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			if(pos.y == H-1 && pos.x == W-1) {
				answer = pos.dt;
				return;
			}
			
			if(!visited[pos.k][pos.y][pos.x]) {
				visited[pos.k][pos.y][pos.x] = true;
				if(pos.k > 0) {
					for(int i = 0; i<8; i++) {
						nx = pos.x + horse_move[i/4][0]*angle_x[i%4];
						ny = pos.y + horse_move[i/4][1]*angle_y[i%4];
						
						if(ny < H && ny >= 0 && nx <W && nx >=0 && !map[ny][nx] && !visited[pos.k-1][ny][nx]) {
							q.add(new Pos(ny,nx,pos.k-1,pos.dt+1));
						}
					}
				}
				
				for(int i = 0; i<4; i++) {
					nx = pos.x + dx[i];
					ny = pos.y + dy[i];
					if(ny < H && ny >= 0 && nx <W && nx >=0 && !map[ny][nx]&& !visited[pos.k][ny][nx]) {
						q.add(new Pos(ny,nx,pos.k,pos.dt+1));
					}
				}
			}
		}
	}
}