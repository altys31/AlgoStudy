import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int R;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i<R; i++) {
			arr = spin(arr);
		}
		
		for(int i = 0; i<N; i++) {
			for(int j= 0; j<M; j++) {
				bw.append(Integer.toString(arr[i][j])).append(" ");
			}
			bw.append("\n");
		}
		
		bw.close();

		
	}
	static int[][] spin(int[][] arr) {
		int[][] new_arr = new int[N][M];
		
		int in = 0;
		int jn = 0;
		int n = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(i <= N/2-1)
						in = i;
					else
						in = Math.abs(N-i)-1;
					if(j <= M/2-1)
						jn = j;
					else
						jn = Math.abs(M-j)-1;
					n = Math.min(in, jn);
					if (j-n == 0 && i-n ==0) {
						new_arr[i+1][j] = arr[i][j];
					}
					else if(j+n == M-1 && i-n == 0){
						new_arr[i][j-1] = arr[i][j];
					}
					else if(j-n == 0 && i+n == N-1) {
						new_arr[i][j+1] = arr[i][j];
					}
					else if(j+n == M-1 && i+n == N-1) {
						new_arr[i-1][j] = arr[i][j];
					}
					//////
					
					else if (j-n == 0 && i+n+1 < N) {
						new_arr[i+1][j] = arr[i][j];
					}
					else if (j+n == M-1 && i-n-1 >= 0) {
						new_arr[i-1][j] = arr[i][j];
					}
					else if(i-n == 0 && j-n-1 >= 0) {
						new_arr[i][j-1] = arr[i][j];
					}
					else if (i+n == N-1 && j+n+1 < M ) {
						new_arr[i][j+1] = arr[i][j];
					}
					
				}
			}
		
		return new_arr;
	}
}