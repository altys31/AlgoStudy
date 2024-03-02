import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int safe_area;
	static int answer;
	static int total;
	static Boolean[][] copied_arr;
	static ArrayList<int[]> virus;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Boolean[][] arr = new Boolean[N][M];
		virus = new ArrayList<int[]>();
		answer = 0;
		safe_area = 0;
		
		for(int i = 0;i <N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					arr[i][j] = true;
				}
				else if(num == 2) {
					arr[i][j] = false;
					virus.add(new int[] {i,j});
				}
				else
					safe_area++;
			}
		}
		
		bt(arr,0,0,-1);
		System.out.println(answer);

	}
	
	static void bt(Boolean[][] arr, int count,int start_y, int start_x) {
		if(count == 3) {
			
			Queue<int[]> q = new ArrayDeque<>();

			total = safe_area-3;
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(arr[i][j] != null && !arr[i][j]) {
						q.add(new int[] {i,j});
						bfs(arr,q);
					}
				}
			}
			
				
			answer = Math.max(total, answer);
			
			for(int n = 0; n<N; n++) {
				for(int k = 0; k<M; k++) {
					boolean check = false;
					
					if(arr[n][k] != null && !arr[n][k]) {
						for(int[] a : virus) {
							if(n==a[0] && k== a[1])
								check = true;
						}
						if(!check)
							arr[n][k] = null;
					}
				}
			}

			return;
		}
		
		for(int i= start_y; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(start_y == i && start_x >= j)
					continue;

				if(arr[i][j] == null) {
					bt(arr,count,i,j);
					arr[i][j] = true;
					bt(arr,count+1,i,j);
					arr[i][j] = null;
					return;
				} 
			}
		}

	}
	
	static void bfs(Boolean[][] arr,Queue<int[]> q) {
		int y;
		int x;
		int[] pos;

		while(!q.isEmpty()) {
			pos = q.poll();
			y = pos[0];
			x = pos[1];
			
			if(arr[y][x] == null) {
				arr[y][x] = false;
				total--;
			}
				
				for(int i = 0; i<4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if(ny < N && ny >= 0 && nx<M && nx >= 0 && arr[ny][nx] == null) {
						q.add(new int[] {ny,nx});
					}
				}
			
		}

		
	}

}
