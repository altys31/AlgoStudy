import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int T;
	static int[][] circle;
	static int x;
	static int d;
	static int k;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean issame;
	static Queue<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		circle = new int[N][M];
		
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<T; i++) {
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		spin(x,d,k);
		
//		System.out.println("연산 후 "+ (issame?" - 같은거":" - 평균"));
//		for(int[] a : circle) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
		}
		
		int total = 0;
		for(int i = 0; i <N; i++) {
			for(int j = 0; j<M; j++) {
				total += circle[i][j];
			}
		}
		System.out.println(total);

	}
	
	static void spin(int x, int d, int k) {
		//인접한 같은 수가 있는지 확인
		issame =false;

		//k칸 회전
		for(int t = 0; t<k; t++) {
		for(int i = 0; i<N; i++) {
			//x의 배수이면
			if((i+1) % x  == 0) {
			//시계 방향
			if(d == 0) {
				int temp = circle[i][M-1];
				for(int j = M-1; j>0; j--) {
					circle[i][j] = circle[i][j-1];
				}
				circle[i][0] = temp;
			
			}
			// 반시계 방향
			else if(d == 1) {
				int temp = circle[i][0];
				for(int j = 1; j<M; j++) {
					circle[i][j-1] = circle[i][j];
				}
				circle[i][M-1] = temp;
			
			}
			}
		}
		}
//		System.out.println();
//		System.out.println("회전 후" );
//		for(int[] a : circle) {
//			for(int b : a) {
//				System.out.print(b+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		
		// 인접한 수 체크 
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(circle[i][j] != 0) {
					q.add(new int[] {i,j,0});
					bfs(q);
				}
			}
		}
		
	
		
		
		//인접한 같은 수가 없다면
		if(!issame) {
		int total = 0;
		int num =0;
		double avg;
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j<M; j++) {
				if(circle[i][j] != 0) {
					num++;
				total += circle[i][j];
				}
			}
		}
		
		avg = (double)total/num;
//		System.out.println(avg);
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j<M; j++) {
				if(avg > circle[i][j] && circle[i][j] != 0)
					circle[i][j]++;
				else if(avg < circle[i][j] && circle[i][j] != 0)
					circle[i][j]--;
			}
		}
		}


	}
	
	// 회전 완료후 탐색 BFS
	static void bfs(Queue<int[]> q) {
		
	while(!q.isEmpty()) {
		int[] arr = q.poll();
		int i = arr[0];
		int j = arr[1];
		int temp = arr[2];
		
		if(temp ==0)
			temp = circle[i][j];
		
		for (int n = 0; n < 4; n++) {
			int nx = j + dx[n];
			int ny = i + dy[n];
			

			// 맨뒤와 맨 앞을 이어줌
			if (nx == M)
				nx = 0;
			if (nx == -1)
				nx = M-1;

			if (nx < M && nx >= 0 && ny < N && ny >= 0) {
				if (circle[ny][nx] == temp && temp != 0) {
					circle[i][j] =0;
					circle[ny][nx] = 0;
					issame = true;
					q.add(new int[] {ny,nx,temp});
				}
			}

		}

	}
	}

}
