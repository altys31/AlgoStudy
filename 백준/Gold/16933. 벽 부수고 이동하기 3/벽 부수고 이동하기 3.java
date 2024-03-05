import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	static int N;
	static int M;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int K;
	
	static class Node{
		int y;
		int x;
		int dt;
		int bk;
		
		public Node(int y, int x, int dt, int bk) {
			super();
			this.y = y;
			this.x = x;
			this.dt = dt;
			this.bk = bk;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		
		boolean[][] map = new boolean[N][M];
		
		for(int i = 0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j<M; j++) {
				if(line[j] =='1')
					map[i][j] = true;
			}
		}

		Queue<Node>q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[K+1][N][M];
		q.add(new Node (0,0,1,K));
		bfs(q,map,visited);
	}
	static void bfs(Queue<Node>q,boolean[][] map, boolean[][][] visited) {
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			visited[n.bk][n.y][n.x] = true;
			
			if(n.y == N-1 && n.x == M-1) {
				answer = Math.min(n.dt, answer);
				break;
			}
			
			for(int i = 0; i<4; i++) {
				int ny = n.y+dy[i];
				int nx = n.x+dx[i];
				
				if(ny <N && ny >= 0 && nx <M && nx>=0) {
					if(n.bk != 0 && map[ny][nx] && !visited[n.bk-1][ny][nx] && n.dt %2 == 1) {
						q.add(new Node(ny,nx,n.dt+1,n.bk-1));
						visited[n.bk-1][ny][nx] = true;
					}
					else if(!map[ny][nx] && !visited[n.bk][ny][nx]) {
						q.add(new Node(ny,nx,n.dt+1,n.bk));
						visited[n.bk][ny][nx] = true;
					}
				}
			}
			if(n.bk != 0 && n.dt % 2 == 0) {
				n.dt++;
				q.add(n);
			}
		}
		
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
		
	}

}