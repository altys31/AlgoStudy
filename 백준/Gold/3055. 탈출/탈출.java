import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Water{
		int y;
		int x;
		
		public Water(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
	
	static class Hog{
		int y;
		int x;
		int time;
		
		public Hog(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}
		

	}
	
	static int[] startPos = new int[2];
	static int answer = -1;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static int R;
	static int C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		
		Queue<Water> wq = new ArrayDeque<>();
		
		for(int i = 0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j<C; j++) {
				if (map[i][j] =='S') {
					startPos[0] = i;
					startPos[1] = j;
					map[i][j] = '.';
				}
				else if(map[i][j] == '*' ) {
					wq.add(new Water(i,j));
				}
			}
		}
		
		bfs(wq, map);
		if(answer == -1) {
			System.out.println("KAKTUS");
		}
		else {
			System.out.println(answer);
		}
		
	}
	
	static void bfs(Queue<Water> wq, char[][] map) {
		Queue<Water> wq2 = new ArrayDeque<>();
		Queue<Hog> hq = new ArrayDeque<>();
		Queue<Hog> hq2 = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		hq.add(new Hog(startPos[0],startPos[1],0));
		
		while(true) {
			while(!wq.isEmpty()) {
				
				Water wt = wq.poll();
				int y = wt.y;
				int x = wt.x;
				
				for(int i = 0; i<4; i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					if(ny<R && ny >= 0 && nx<C && nx >= 0 && map[ny][nx] =='.') {
						map[ny][nx] = '*';
						wq2.add(new Water(ny,nx));
					}
				}
			}
			
			while(!hq.isEmpty()) {
				
				Hog hg = hq.poll();
				int y = hg.y;
				int x = hg.x;
				
				if(map[y][x] == 'D') {
					answer = hg.time;
					return;
				}
				
				for(int i =0; i<4; i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					if(ny<R && ny >= 0 && nx<C && nx >= 0 && (map[ny][nx] =='.' || map[ny][nx]=='D') && !visited[ny][nx]) {
						visited[ny][nx] = true;
						hq2.add(new Hog(ny,nx, hg.time+1));
					}
				}
			}
			while(!wq2.isEmpty()) {
				wq.add(wq2.poll());
			}
			while(!hq2.isEmpty()) {
				hq.add(hq2.poll());
			}
			
			if(hq.isEmpty()) 
				break;
			
		}
		
	}
}
