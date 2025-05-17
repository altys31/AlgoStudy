class Solution {
    
   public int solution(int m, int n, int[][] puddles) {
    int[][] dp = new int[n][m]; // dp[y][x]

    for (int[] puddle : puddles) {
        dp[puddle[1] - 1][puddle[0] - 1] = -1;
    }

    dp[0][0] = 1;

    for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
            if (dp[y][x] == -1) {
                dp[y][x] = 0;
                continue;
            }
            if (y > 0) dp[y][x] += dp[y - 1][x];
            if (x > 0) dp[y][x] += dp[y][x - 1];
            dp[y][x] %= 1_000_000_007;
        }
    }

    return dp[n - 1][m - 1];
}

}