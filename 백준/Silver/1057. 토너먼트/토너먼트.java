import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int round = 1;
		
		while(true) {
			if (Math.abs(A-B) == 1 && Math.min(A, B) % 2 == 1) {
				System.out.println(round);
				System.exit(0);
			}
			A = (int)((A+1)/2);
			B = (int)((B+1)/2);
			round += 1;
		}
	}

}
