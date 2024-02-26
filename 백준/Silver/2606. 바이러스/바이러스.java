import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(br.readLine());
		
	    list = new ArrayList[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		answer = 0;
		
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			if(list[v1] == null) {
				list[v1] = new ArrayList<Integer>();
			}
			if(list[v2] == null) {
				list[v2] = new ArrayList<Integer>();
			}
			list[v1].add(v2);
			list[v2].add(v1);
		}
		visited = new boolean[N+1];
		q.add(Integer.valueOf(1));
		bfs(q);
		System.out.println(answer);

	}
	static void bfs(Queue<Integer> q) {
		while(!q.isEmpty()) {
			int num = q.poll();
			if(!visited[num]) {
				if(num != 1)
					answer++;
				visited[num] = true;
				
				if(list[num] != null) {
				for(int a : list[num]) {
					if(!visited[a])
						q.add(a);
					}
				}
				
				
			}
		}
	}
}