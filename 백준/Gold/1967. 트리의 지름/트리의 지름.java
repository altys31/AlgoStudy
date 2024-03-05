import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	static int longest;
	static int V;
	
	static class E{
		int point;
		int cost;
		
		public E(int point, int cost) {
			super();
			this.point = point;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		
		ArrayList<E>[] list = new ArrayList[V+1];
		answer = 0;
		longest = 0;
		if(V ==1) {
			System.out.println(0);
			return;
		}
		
		for(int i =1; i<V+1; i++) {
			if(list[i] == null)
				list[i] = new ArrayList<E>();
		}
		for(int i =1; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new E(end,cost));
			list[end].add(new E(start,cost));	
		}
		
//		for(int i = 1; i<V+1; i++) {
//			for(int j = 1; j<V+1; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		boolean[] visited = new boolean[V+1];
		visited[1] = true;
		dfs(1,0,list,visited);
		visited = new boolean[V+1];
		visited[longest] = true;
		dfs(longest,0,list,visited);
		System.out.println(answer);
		
	}
	static void dfs(int start,int total,ArrayList<E>[] list,boolean[] visited) {

		for(E end : list[start]) {
			if(!visited[end.point]) {
				visited[end.point] = true;
				dfs(end.point,total+end.cost,list,visited);
			}
		}
		if(answer < total) {
			answer = total;
			longest = start;
		}
			
	}
}