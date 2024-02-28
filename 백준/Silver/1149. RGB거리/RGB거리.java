import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] cost;
	static int[][] dp;
 	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[3][N];
		int[][] dp = new int[3][N];
		int answer =0;
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[0][i] = Integer.parseInt(st.nextToken()); //R
			cost[1][i] = Integer.parseInt(st.nextToken()); //G
			cost[2][i] = Integer.parseInt(st.nextToken()); //B
		}
		
		dp[0][0] = cost[0][0];
		dp[1][0] = cost[1][0];
		dp[2][0] = cost[2][0];
		
		answer = Math.min(dp(0,N-1,cost,dp), dp(1,N-1,cost,dp));
		answer = Math.min(answer, dp(2,N-1,cost,dp));
		System.out.println(answer);
	}
	
	
	static int dp(int color,int depth,int[][] cost,int[][] dp) {
		
		if(dp[color][depth] != 0)
			return dp[color][depth];
		else {
			if(color == 0)
				dp[color][depth] = Math.min(dp(1,depth-1,cost,dp)+cost[color][depth],dp(2,depth-1,cost,dp)+cost[color][depth]);
			else if(color == 1)
				dp[color][depth] = Math.min(dp(0,depth-1,cost,dp)+cost[color][depth],dp(2,depth-1,cost,dp)+cost[color][depth]);
			else
				dp[color][depth] = Math.min(dp(0,depth-1,cost,dp)+cost[color][depth],dp(1,depth-1,cost,dp)+cost[color][depth]);
			return dp[color][depth];
		}
		
	}
}