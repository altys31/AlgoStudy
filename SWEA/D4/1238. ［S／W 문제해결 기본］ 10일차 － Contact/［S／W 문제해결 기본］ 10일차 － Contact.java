
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

//sw 1238
public class Solution {
	static boolean visited[];
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for(int Test = 1; Test<11; Test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			Queue<int[]> q = new ArrayDeque<>();
			visited = new boolean[101];
			
			answer = new int[] {0,0};
			
			ArrayList<Integer>[] list = new ArrayList[101];
			for(int i = 1; i<101; i++) 
				list[i] = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
			
			q.add(new int[] {start,0});
			bfs(q,list);
			
			bw.append("#").append(Integer.toString(Test)).append(" ").append(Integer.toString(answer[0])).append("\n");
			
		
		}
		
		bw.close();
		
		
	}
	
	static void bfs(Queue<int[]> q, ArrayList<Integer>[] list) {
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int num = node[0];
			int depth = node[1];
			
			if(!visited[num]) {
				
				visited[num] = true;
				
				if(answer[1] < depth) {
					answer[0] =  num;
					answer[1] = depth;
				}
				else if(answer[1] == depth && answer[0] < num) {
					answer[0] = num;
				}
				
				for(int a : list[num]) {
					if(!visited[a])
						q.add(new int[] {a,depth+1});
				}
				
				
				
			}
			
		}
	}

}
