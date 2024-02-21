import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] domado_array;
	static boolean[][][] visited;
	static int M;
	static int N;
	static int H;
	static int tomato_quantity = 0; //총 토마토 갯수
	static int top_tomato; // 다 익었을때 토마토 갯수
	static Queue <int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		M = Integer.parseInt(st.nextToken()); //가로
		N = Integer.parseInt(st.nextToken()); //세로
		H = Integer.parseInt(st.nextToken()); //높이
		
		domado_array = new int[H][N][M];
		visited = new boolean[H][N][M];
		top_tomato = N*M*H;
		
		for(int i = 0; i<H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k<M; k++) {
					int tomato = Integer.parseInt(st.nextToken());
					if(tomato == 1) {
						q.offer(new int[] {i,j,k,1}); //{높이, 세로, 가로,일수}
						tomato_quantity++;
					}
					if(tomato == -1)
						top_tomato--;
					
					domado_array[i][j][k] = tomato;
				}
				
			}
		}
		
		//탐색전 체크 
		if(tomato_quantity == top_tomato) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(Integer.toString(0));
			bw.close();
			return;
		}
		if(q.isEmpty()) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(Integer.toString(-1));
			bw.close();
			return;
		}

		bfs(q,new int[][][] {},visited);
		
	}
	
	static void bfs(Queue<int[]> q, int[][][] previous_array,boolean[][][] visited) throws IOException {
		
		while(!q.isEmpty()) {
			
			int[] tomato_position = q.poll();
			int y = tomato_position[0];
			int x = tomato_position[1];
			int z = tomato_position[2];
			int answer = tomato_position[3];

		//상 (위쪽 방향 좌표를 확인후 큐에 추가)
			if(y>0) {
				if(domado_array[y-1][x][z] == 0 && !visited[y-1][x][z]) {
					domado_array[y-1][x][z] = 1;
					tomato_quantity++;
					visited[y-1][x][z] = true;
					q.offer(new int[] {y-1,x,z,answer+1});
				}
			}
				
		//하 (아래쪽 방향 좌표를 확인후 큐에 추가)
			if(y<H-1) {
				if(domado_array[y+1][x][z] == 0&& !visited[y+1][x][z]) {
					domado_array[y+1][x][z] = 1;
					tomato_quantity++;
					visited[y+1][x][z] = true;
					q.offer(new int[] {y+1,x,z,answer+1});
				}
				
			}
		//좌 (왼쪽 방향 좌표를 확인후 큐에 추가)
			if(x>0) {
				if(domado_array[y][x-1][z] == 0 && !visited[y][x-1][z]) {
					domado_array[y][x-1][z] = 1;
					tomato_quantity++;
					visited[y][x-1][z] =true;
					q.offer(new int[] {y,x-1,z,answer+1});
				}
				
			}
		//우 (오른쪽 방향 좌표를 확인후 큐에 추가)
			if(x<N-1) {
				if(domado_array[y][x+1][z] == 0 && !visited[y][x+1][z]) {
					domado_array[y][x+1][z] = 1;
					tomato_quantity++;
					visited[y][x+1][z] =true;
					q.offer(new int[] {y,x+1,z,answer+1});
				}
				
			}
		//남
			if(z>0) {
				if(domado_array[y][x][z-1] == 0 && !visited[y][x][z-1]) {
					domado_array[y][x][z-1] = 1;
					tomato_quantity++;
					visited[y][x][z-1] =true;
					q.offer(new int[] {y,x,z-1,answer+1});
				}
				
			}
		//북
			if(z<M-1) {
				if(domado_array[y][x][z+1] == 0 && !visited[y][x][z+1]) {
					domado_array[y][x][z+1] = 1;
					tomato_quantity++;
					visited[y][x][z+1] =true;
					q.offer(new int[] {y,x,z+1,answer+1});
				}
				
			}
			
			if(tomato_quantity == top_tomato) {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				bw.write(Integer.toString(answer));
				bw.close();
				return;
			}
		//전과 비교하여 변했는지 체크 (변하지 않았으면 -1출력)
			
			if(q.isEmpty()) {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				bw.write(Integer.toString(-1));
				bw.close();
				return;
			}
			
		}
	}

}