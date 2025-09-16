import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] dp;
	static int[][] stickers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCases = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<testCases; i++) {
			
			n = Integer.parseInt(br.readLine());
			
			stickers = new int[2][n];
			dp = new int[2][n];
			
			for(int j =0; j<2; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {
					int point = Integer.parseInt(st.nextToken());
					stickers[j][k] = point;
				}
			}
			
			dp[0][0] = stickers[0][0];
			dp[1][0] = stickers[1][0];
			if(n > 1) { 
				 dp[0][1] = dp[1][0] + stickers[0][1];
				 dp[1][1] = dp[0][0] + stickers[1][1];
			}
			
			for(int j = 2; j < n; j++) {
				dp[0][j] = Math.max(dp[1][j-1] , dp[1][j-2]) + stickers[0][j];
				dp[1][j] = Math.max(dp[0][j-1] , dp[0][j-2]) + stickers[1][j];

			}
			
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));

			
		}
		

	}
	

}
