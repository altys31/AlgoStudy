import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int y;
		int x;
		int distance;
		int key;
		
		public Node(int y, int x, int distance, int key) {
			super();
			this.y = y;
			this.x = x;
			this.distance = distance;
			this.key = key;
		}

	}
	
	static int[] dy = {1,0,0,-1};
	static int[] dx = {0,-1,1,0};
	
	static int N;
	static int M;
	
	
	static int answer = -1;
	static char[][] map;
	static int[] startPos;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		startPos = new int[2];
		
		for(int i = 0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j<M; j++) {
				if(map[i][j] =='0') {
					startPos[0] = i;
					startPos[1] = j;
				}
			}
		}
		
		
		Queue<Node> q = new ArrayDeque();

		q.add(new Node(startPos[0],startPos[1],0,0));
		
		bfs(q,map);
		
		System.out.println(answer);
		

		

	}
	
	static void bfs(Queue<Node> q, char[][] map) {
		boolean[][][] visited = new boolean[1<<6][N][M];
		visited[0][startPos[0]][startPos[1]] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int y = node.y;
			int x = node.x;
//			System.out.println(y+" "+x);
			if(map[y][x] == '1') {
				answer = node.distance;
//				System.out.println(node.key);
				return;
			}
			
//			System.out.println("############");
//			for(int i = 0; i<N; i++) {
//				for(int j = 0; j<M; j++) {
//					if(y == i && x == j)
//						System.out.print('0');
//					else
//						System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}

			
			for(int i = 0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				int copiedKey = node.key;
				if(ny<N && ny>= 0 && nx<M && nx>=0  && !visited[node.key][ny][nx] && check(ny,nx,node)) {
					visited[node.key][ny][nx] =true;
					q.add(new Node(ny,nx,node.distance+1 ,node.key));
					node.key = copiedKey;
				}
			}
		}
			
			
	}
		
	
	
	static boolean check(int ny, int nx, Node node) {
		
		switch(map[ny][nx]) {
			case'#':
				return false;
			case'.':
				return true;
			case'A':
				if((node.key & 1<<0) == 0)
					return false;
				return true;
			case'B':
				if((node.key & 1<<1) == 0)
					return false;
				return true;
			case'C':
				if((node.key & 1<<2) == 0)
					return false;
				return true;
			case'D':
				if((node.key & 1<<3) == 0)
					return false;
				return true;
			case'E':
				if((node.key & 1<<4) == 0)
					return false;
				return true;
			case'F':
				if((node.key & 1<<5) == 0)
					return false;
				return true;
			case'a':
				if((node.key & 1<<0) == 0) {
					node.key += 1<<0;
				}
				return true;
			case'b':
				if((node.key & 1<<1) == 0) {
					node.key += 1<<1;
				}
				return true;
			case'c':
				if((node.key & 1<<2) == 0) {
					node.key += 1<<2;
				}
				return true;
			case'd':
				if((node.key & 1<<3) == 0) {
					node.key += 1<<3;
				}
				return true;
			case'e':
				if((node.key & 1<<4) == 0) {
					node.key += 1<<4;
				}
				return true;
			case'f':
				if((node.key & 1<<5) == 0) {
					node.key += 1<<5;
				}
				return true;
			default:
				return true;

		}

	}
	
	static boolean[][] newVisited(){
		boolean[][] visited = new boolean[N][M];
		return visited;
	}
	
}