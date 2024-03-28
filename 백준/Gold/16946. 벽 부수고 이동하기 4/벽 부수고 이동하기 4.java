import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static ArrayList<Integer> group;
	static int[][] district;
	
	static class Node{
		int y;
		int x;
		
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static class Wall_Node{
		int y;
		int x;
		int value;
		
		public Wall_Node(int y, int x, int value) {
			super();
			this.y = y;
			this.x = x;
			this.value = value;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		district = new int[N][M];
		group = new ArrayList<Integer>();
		Queue<Node> q = new ArrayDeque<Node>();
		ArrayList<Wall_Node> wall_list = new ArrayList<>();
		group.add(0);
		for(int i = 0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j<M; j++) {
				if(line[j] =='1') {
					map[i][j] = -1;
				}
			}
		}
		
		int no = 1;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0) {
					Node wall = new Node(i,j);
					q.add(wall);
					bfs(q,wall,map,no);
					no++;
				}
				else if(map[i][j] == -1){
					wall_list.add(new Wall_Node(i,j,1));
				}
			}
		}
		

		for(int n = 0; n<wall_list.size(); n++) {
			Wall_Node node = wall_list.get(n);
			int total = 1;
			
			HashSet<Integer> used = new HashSet<>();
			for(int i = 0; i<4; i++) {
				int ny = node.y+dy[i];
				int nx = node.x+dx[i];
				if(ny<N && ny>=0 && nx < M && nx >= 0&& district[ny][nx] != 0  && !used.contains(district[ny][nx])) {
					total += group.get(district[ny][nx]);
					used.add(district[ny][nx]);
				}
			}
			wall_list.get(n).value = total%10;
		}
		
		int cursor = 0;
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				Wall_Node node = null;
				if(wall_list.size() != 0)
					node = wall_list.get(cursor);
				if(node != null && node.x == j && node.y == i) {
					bw.append(Integer.toString(node.value));
					if(cursor < wall_list.size()-1)
						cursor++;
				}
				else {
					bw.append(Integer.toString(0));
				}
			}
			bw.append("\n");
		}
		bw.close();
	}
	
	static void bfs(Queue<Node> q, Node wall,int[][] map,int no) {
		Queue<Node> zero_q = new ArrayDeque<Node>();
		
		int size = 1;
		map[wall.y][wall.x] = 1;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			zero_q.add(node);
			for(int i = 0; i<4; i++) {
				int ny = node.y+dy[i];
				int nx = node.x+dx[i];
				if(ny<N && ny>=0 && nx < M && nx >= 0&& map[ny][nx] == 0) {
					map[ny][nx]++;
					q.add(new Node(ny,nx));
					size++;
				}
			}
		}
		
		while(!zero_q.isEmpty()) {
			Node node = zero_q.poll();
			district[node.y][node.x] = no;
		}
		group.add(size);
		
	}
}