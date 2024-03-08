import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int S;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		answer =0;
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(num);
		
		System.out.println(answer);
		
	}
	
	static void subset(int[] num) {
		
		for(int i = 1; i< (1<<N); i++) {
			int total = 0; 
			for(int j =0; j<N; j++) {
				if(((1<<j) & i) != 0) {
					total += num[j];
				}
			}
			if(total == S)
				answer++;
		}
	}
}