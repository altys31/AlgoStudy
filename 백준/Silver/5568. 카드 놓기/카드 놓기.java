import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static Set<String> set = new HashSet<>();
	static List<Integer> list = new ArrayList<Integer>();
	static boolean[] visited;
 	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		 visited = new boolean[N];
		 
		backtrack("", 0);
		
		System.out.println(set.size());
		
	}
	
	static void backtrack (String current, int count) {
		
		if(count == K) {
			set.add(current);
			return;
		}
		
		for(int i= 0; i<N; i++) {
			if(!visited[i]) {
				visited[i]= true;
				backtrack(current + list.get(i), count+1);
				visited[i] =false;
			}
		}
		
		
	}
}
