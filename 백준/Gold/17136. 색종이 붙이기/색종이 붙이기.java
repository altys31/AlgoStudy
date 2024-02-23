import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {1,1,0};
	static int[] dy = {0,1,1};
	static int N;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 10;
		boolean[][] arr = new boolean[N][N];
		int[] papers = {0,5,5,5,5,5};
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j =0; j<N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1)
					arr[i][j] = true;
			}
		}
		
		bt(arr,0,papers);
		
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
		


	}
	static void bt(boolean[][] arr,int depth,int[] papers) {
		
		boolean isdone = true;

		//종이가 없으면 컷
		for(int i = 1; i<6; i++) 
			if(papers[i] < 0) 
				return;
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j])
					isdone = false;
			}
		}
		
		if(isdone)
			answer = Math.min(depth, answer);

		
		boolean[][] copied_arr = new boolean[N][N];
		for(int i = 0; i<N; i++) 
			for(int j =0; j<N; j++) 
				copied_arr[i][j] = arr[i][j];
		
		
		for(int i = 0; i<10; i++) {
			for(int j =0; j<10; j++) {
				if(copied_arr[i][j]) {
					//1x1 ~ 가능한만큼 붙이고, 백트래킹
					int size = check(i,j,copied_arr,0);
//					System.out.println(size);
						for(int k = size+1; k >= 1; k--) {
							papers[k]--;
							for(int n = i; n < i+k; n++) {
								for(int l = j; l < j+k; l++) {
									copied_arr[n][l] = false;
								}
							}
							
							bt(copied_arr,depth+1,papers);
							
							for(int y = i; y<i+k; y++) 
								for(int x =j; x<j+k; x++) 
									copied_arr[y][x] = arr[y][x];
							papers[k]++;
							
							
						}
						return;
				}
			}
		}
	}
	
	// 해당 좌표에 얼마 까지 큰 색종이를 붙일 수 있는지 확인 하는 매서드
	static int check(int y,int x,boolean[][] arr,int deep) {
		
		int depth = 0;
		boolean checked =true;
		
		if(deep > 3)
			return 4;
		
		for(int k = 0; k<3; k++) {
			int nx = x +dx[k];
			int ny = y +dy[k];
			if(ny >= N || nx >=N || !arr[ny][nx])
				checked = false;
		}
		
		if(checked) {
			depth++;
			int a = Math.min(check(y+1,x+1,arr,deep+1),check(y+1,x,arr,deep+1));
			int b = Math.min(check(y,x+1,arr,deep+1),a);
			depth += b;
		}
		return Math.min(4, depth);
	}

}
