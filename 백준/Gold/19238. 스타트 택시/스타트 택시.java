import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int f;
	static ArrayList<int[]> passenger;
	static ArrayList<int[]> arrival;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int complete;
	static boolean[][] map;
	static boolean isno;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		passenger = new ArrayList<>();
		Queue<int[]> q = new ArrayDeque<>();
		
		map = new boolean[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		for(int i = 1; i <N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<N+1; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) 
					map[i][j] = true;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start_y = Integer.parseInt(st.nextToken());
		int start_x = Integer.parseInt(st.nextToken());
		
		
		for(int i = 1; i<M+1; i++) {
			st = new StringTokenizer(br.readLine());
			int py = Integer.parseInt(st.nextToken());
			int px = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			int ax = Integer.parseInt(st.nextToken());
			passenger.add(new int[] {px,py,0,ax,ay,0});
		}
		
		q.add(new int[] {start_x,start_y,0,f});
		passenger_bfs(q);
		if(complete == M) 
			System.out.println(f);
		else
			System.out.println(-1);
		
	}
	
	static void passenger_bfs(Queue<int[]> q){
		
		int find  = 0;
		for(int i = 1; i<N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				visited[i][j] = map[i][j];
			}
		}
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int x = arr[0];
			int y = arr[1];
			int distance = arr[2];
			int fuel = arr[3];
			if(!visited[y][x]) {
//			System.out.println("x : "+ x+" y : "+ y+" fuel : "+ fuel );
			visited[y][x] = true;
			
			
			for(int i = 0; i<passenger.size(); i++) {
				if(x == passenger.get(i)[0] && y == passenger.get(i)[1]) {
					passenger.get(i)[2] = distance;
					passenger.get(i)[5] = fuel;
					find++;
				}
			}
//			System.out.println(find);

			
			if(find == passenger.size() || (q.isEmpty() && fuel<0)) {
				passenger.sort(
		                Comparator.<int[], Integer>comparing(arr1 -> arr1[2])
		                        .thenComparingInt(arr1 -> arr1[1])
		                        .thenComparingInt(arr1 -> arr1[0])
		        );
				
				q.clear();
				arr = passenger.get(0);
				x = arr[0];
				y = arr[1];
				distance = arr[2];
				int arrival_x = arr[3];
				int arrival_y = arr[4];
				fuel = arr[5];
//				System.out.println(x+" "+y+" "+ distance+" "+arrival_x+" "+arrival_y+" "+fuel);
				q.add(new int[] {x,y,0,fuel});
				passenger.remove(0);
 				arrival_bfs(q,arrival_x,arrival_y,fuel);
 				return;
				

			
			}
			
			for(int i = 0; i <4; i++) {
				int nx = x +dx[i];
				int ny = y +dy[i];
				
				if(nx >= 1 && nx <= N && ny>= 1 && ny<= N && !visited[ny][nx]) {
					q.add(new int[]{nx,ny,distance+1,fuel-1});
				}
					
				}
			}
		
		}
		}
	
	static void arrival_bfs(Queue<int[]> q, int arrival_x, int arrival_y,int first_fuel) {
		
		for(int i = 1; i<N+1; i++) {
			for(int j = 1; j<N+1; j++) {
				visited[i][j] = map[i][j];
			}
		}
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int x = arr[0];
			int y = arr[1];
			int distance = arr[2];
			int fuel = arr[3];
			if(!visited[y][x]) {
			visited[y][x] =true;
//			System.out.println(" arr x : "+ x+" y : "+ y+" fuel : "+ fuel+" distance : "+distance);
			
			if(fuel <0) {
				isno = true;
				return;
			}
			
			
			if(x == arrival_x && y == arrival_y) {
				complete++;
				fuel += distance*2;
				f = fuel;
				q.clear();
				q.add(new int[] {x,y,0,fuel});
//				System.out.println("complete : "+ complete + "M" +M);
				if(complete == M)
					return;
				else
					passenger_bfs(q);
			}
			
			for(int i = 0; i <4; i++) {
				int nx = x +dx[i];
				int ny = y +dy[i];
				
				if(nx >= 1 && nx <= N && ny>= 1 && ny<= N && !visited[ny][nx])
					q.add(new int[]{nx,ny,distance+1,fuel-1});
					
				}
			
			if(complete == M)
				return;
		
		}
		}
		
	}

}