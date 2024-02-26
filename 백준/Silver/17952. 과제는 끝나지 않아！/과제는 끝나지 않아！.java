import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		for(int i = 0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			int num  = Integer.parseInt(st.nextToken());
			if(num == 1) {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				time --;
				
				if(time == 0) {
					answer += score;
				}
				else {
					q.add(new int[] {score,time});
				}
			}
			else {
				if(!q.isEmpty()) {
					q.peekLast()[1]--;
					if(q.peekLast()[1] == 0) 
						answer += q.pollLast()[0];	
				}
				
			}
			
			
		}
		
		System.out.println(answer);
		
		
		
		
		
	}

}
