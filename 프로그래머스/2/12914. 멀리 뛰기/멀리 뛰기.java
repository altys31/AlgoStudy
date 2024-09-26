class Solution {
    static long[] dp = new long[2001];
    
    public long solution(int n) {
        // DP 초기화
        dp[1] = 1;
        dp[2] = 2;
        
        // DP 채우기
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        // n번째 칸에 도달하는 방법의 수 반환
        return dp[n];
    }
}
