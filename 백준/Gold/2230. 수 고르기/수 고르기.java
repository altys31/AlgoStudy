import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		list.sort(null);
		
		int left = 0;
		int right = 1;
		int difference = Integer.MAX_VALUE;
		
		while(true) {
			
			if(right >= N)
				break;
			
			int gap = list.get(right)-list.get(left);
			
			if(gap >= M && right-left != 1)
				left++;
			else 
				right++;
			
			if(gap >= M && gap <= difference) {
				difference = gap;		
			}
			
			if(gap == M)
				break;
		}
		System.out.println(difference);
	}
}