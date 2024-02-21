
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] value_map;
	static int N;
	static int K;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		Queue<int[]> q = new ArrayDeque<>();
		answer = 0;

		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		value_map = new int[N+1][K+1];
		
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			list.add(new int[] {W,V});
		}
		
		int stage = 0;
		int weight = K;
		q.add(new int[] {stage,weight});
		
		while (!q.isEmpty()) {
			
			if(q.peek()[0] != stage)
				stage = q.peek()[0];
			
			if(stage >= N)
				break;
			int[] item = list.get(stage);
//			System.out.println("item weight : "+item[0]+" item value : "+item[1]);
			

			int[] bp = q.poll();
			int pS = bp[0];
			int pW = bp[1];
//			System.out.println("stage : " + pS + " weight : "+ pW + " value : " + value_map[pS][pW]);
			if(value_map[pS+1][pW] <= value_map[pS][pW]) {
				q.add(new int[] {pS+1,pW});
				value_map[pS+1][pW] = value_map[pS][pW];
			}
			
			if(pW-item[0]>=0) {
				if(value_map[pS+1][pW-item[0]] < value_map[pS][pW]+item[1]) {
				value_map[pS+1][pW-item[0]] = value_map[pS][pW]+item[1];
				answer = Math.max(answer,value_map[pS+1][pW-item[0]]);
				q.add(new int[] {pS+1,pW-item[0]});
				}
			}
			

		}
//		for(int[] a: q) {
//			System.out.println("stage : " + a[0] + " weight : "+ a[1] + " value : " + value_map[a[0]][a[1]]);
//		}
		System.out.println(answer);
	}
}
