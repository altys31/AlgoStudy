
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class unionfind{
		int[] parent;
		int[] rank;
		
		public unionfind(int size) {
			super();
			parent = new int[size+1];
			rank = new int[size+1];
			
			for(int i = 1; i<size+1; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
		}
		
		public int find(int x) {
			if(parent[x] != x)
				return find(parent[x]);
			return parent[x];
		}
		
		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			
			if(rootX != rootY) {
				if(rank[rootX] > rank[rootY]) 
					parent[rootY] = rootX;
				else if(rank[rootY] > rank[rootX])
					parent[rootX] = rootY;
				else {
					parent[rootY] = rootX;
					rank[rootX]++;
				}	
			}
		}
		
		
		
	}
	static class Line{
		int start;
		int end;
		double dt;
		
		public Line(int start,int end) {
			super();
			this.start = start;
			this.end = end;
			this.dt = Math.sqrt(Math.pow(Math.abs(gods.get(start)[0]-gods.get(end)[0]),2)+Math.pow(Math.abs(gods.get(start)[1]-gods.get(end)[1]),2));
		}

		
	}
	static ArrayList<int[]> gods;
	static ArrayList<Line> lines;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		double answer =0;
		int linked =0;
		double[][] arr = new double[N+1][N+1];
		gods = new ArrayList<>();
		lines = new ArrayList<>();
		
		gods.add(new int[] {0,0});
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			gods.add(new int[] {y,x});
		}
		
		for(int i = 1; i<N+1; i++) {
			int[] pos1 = gods.get(i);
			for(int j = 1; j<N+1; j++) {
				if(i == j)
					continue;
				int[] pos2 = gods.get(j);
				lines.add(new Line(i,j));
			}
		}
		
//		for(int i = 0; i<N; i++) {
//			for(int j = 0; j<N; j++) {
//				System.out.print(arr[i+1][j+1]+" ");
//			}
//			System.out.println();
//		}
		
		unionfind uf = new unionfind(N);
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(uf.find(a) != uf.find(b)) {
				uf.union(a, b);
			}
			
		}
		
		lines.sort((o1,o2) -> o1.dt < o2.dt  ? -1 : 1);
		
		for(Line l : lines) {
			if(uf.find(l.start) != uf.find(l.end)) {
				uf.union(l.start,l.end);
				answer += l.dt;
			}
		}
		
		
		
		System.out.print(String.format("%.2f", answer));
		

	}

}
