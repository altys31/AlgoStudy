import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] stairs = new int[3][N];
		int[][] maxDp = new int[3][N];
		int[][] minDp = new int[3][N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				stairs[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxDp[0][0] = stairs[0][0];
		maxDp[1][0] = stairs[1][0];
		maxDp[2][0] = stairs[2][0];
		
		minDp[0][0] = stairs[0][0];
		minDp[1][0] = stairs[1][0];
		minDp[2][0] = stairs[2][0];
		
		
		for(int i = 1; i<N; i++) {
			maxDp[0][i] = Math.max(maxDp[0][i-1]+stairs[0][i], maxDp[1][i-1]+stairs[0][i]);
			maxDp[1][i] = Math.max(Math.max(maxDp[0][i-1]+stairs[1][i], maxDp[1][i-1]+stairs[1][i]), maxDp[2][i-1]+stairs[1][i]);
			maxDp[2][i] = Math.max(maxDp[2][i-1]+stairs[2][i], maxDp[1][i-1]+stairs[2][i]);
			
			minDp[0][i] = Math.min(minDp[0][i-1]+stairs[0][i], minDp[1][i-1]+stairs[0][i]);
			minDp[1][i] = Math.min(Math.min(minDp[0][i-1]+stairs[1][i], minDp[1][i-1]+stairs[1][i]), minDp[2][i-1]+stairs[1][i]);
			minDp[2][i] = Math.min(minDp[2][i-1]+stairs[2][i], minDp[1][i-1]+stairs[2][i]);
		}
		
		int maxValue = 0;
		int minValue = 1_000_000_000;
		
		for(int i =0; i<3; i++) {
			minValue = Math.min(minDp[i][N-1], minValue);
			maxValue = Math.max(maxDp[i][N-1], maxValue);
			
		}
		System.out.println(maxValue + " " +minValue);

	}

}
