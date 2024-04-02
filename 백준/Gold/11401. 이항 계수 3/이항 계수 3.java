import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,R;
	static long M = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[] dp = new long[4000001];

		dp[0] = 1;
		for(int i = 1; i<dp.length; i++) {
			dp[i] = dp[i-1]*i%M;
		}

		long answer = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		// nCr = N!/r!(n-r)! mod p === N!*r!(n-r)!^(p-2) mod p;

		answer = dp[R] * dp[N - R] % M;

		answer = dnc(answer, M - 2);

		answer = answer * dp[N] % M;

		System.out.println(answer);
		
	}

	static long dnc(long A, long B) {
		if(B == 1)
			return A%M;
		else {
			long next = dnc(A,B/2);
			if(B % 2 == 1)
				return (next*next%M*A)%M;
			else
				return (next*next)%M;
		}
		
	}
}