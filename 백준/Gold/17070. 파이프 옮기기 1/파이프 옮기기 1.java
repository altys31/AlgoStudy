import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map; 
	static int N;
	static int answer =0; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new boolean[N][N];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					map[i][j] = true;
			}
		}

			
		tracking(1,0,1);
		System.out.println(answer);

	}
	static void tracking(int x, int y,int position) {
		//System.out.println("x is "+ x +" y is "+ y);
		// position 1 이면 가로
		// 2이면 세로
		// 3이면 대각
		if(x == N-1 && y == N-1) {
			answer += 1;
		}
		if(x < N-1 && !map[y][x+1] && (position == 3 || position == 1)) {
			tracking(x+1,y,1);
		}
		if(y< N-1 && !map[y+1][x]&& (position == 2 || position == 3)) {
			tracking(x,y+1,2);
			
		}
		if(x<N-1 && y<N-1 && !map[y+1][x+1]&& !map[y][x+1]&& !map[y+1][x]) {
			tracking(x+1,y+1,3);
		}
		
	}
	
	
}
