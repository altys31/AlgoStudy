import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy= {1,0,-1,0};
	static int[] dx= {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case=0;
		
		while(true) {
			test_case++;
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			int[][] map = new int[N][N];
			int[][] dt = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			boolean[][] inqueue = new boolean[N][N];
			
			PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(dt[o1[0]][o1[1]], dt[o2[0]][o2[1]]);
				}
			});
			
			
			
			for(int i = 0; i<N; i++) {
				Arrays.fill(dt[i], 1_000_000_000);
			}
			
			if(N == 0)
				break;
			
			
			
			
			
			for(int i = 0; i <N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dt[0][0] = map[0][0];
			pq.add(new int[] {0,0});
			inqueue[0][0] = true;
			
			//방문처리 되지 않은 최소비용의 정점을 찾아서 모두 탐색해본다.
			
			
			while(!pq.isEmpty()) {
				int[] pos = pq.poll();
				int y = pos[0];
				int x = pos[1];
				
				int min_cost = 1_000_000_000;
				
				for(int i =0; i<4; i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny<N && ny>=0 && nx<N && nx>=0 && !visited[ny][nx]) {
						dt[ny][nx] = Math.min(dt[y][x] + map[ny][nx], dt[ny][nx]);
						if(!inqueue[ny][nx]) {
							pq.add(new int[] {ny,nx});
							inqueue[ny][nx] = true;
						}
					}
					
				}
				
				visited[y][x] =true;
				
			}
			
			answer = dt[N-1][N-1];
			
			bw.append("Problem ").append(Integer.toString(test_case)).append(": ").append(Integer.toString(answer)).append("\n");
			
		}
		
		bw.close();
	}
	
}
