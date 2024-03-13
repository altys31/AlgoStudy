import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] hole;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] map;
	static boolean success = false;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		hole = new int[2];
		int[] blue = new int[2];
		int[] red = new int[2];
		
		for(int i = 0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j<M; j++) {
				if(line[j] == '#')
					map[i][j] = true;
				if(line[j] == 'O') {
					hole[0] = i;
					hole[1] = j;
				}
				if(line[j] == 'B') {
					blue[0] = i;
					blue[1] = j;
				}
				if(line[j] == 'R') {
					red[0] = i;
					red[1] = j;
				}
			}
		}
		bt(blue,red,0);
//		if(success)
//			System.out.println(1);
//		else
//			System.out.println(0);
		if(answer != Integer.MAX_VALUE)
			System.out.println(answer);
		else
			System.out.println(-1);
	}
	static void bt(int[] blue, int[] red,int count) {
		
		int blue_y = blue[0];
		int blue_x = blue[1];
		int red_y = red[0];
		int red_x = red[1];

		
		for(int i = 0; i<4; i++) {
			slide(blue,red,i,count+1);
			blue[0] = blue_y;
			blue[1] = blue_x;
			red[0] = red_y;
			red[1] = red_x;
		}
	}
	
	static void slide(int[] blue, int[] red, int dir, int count) {
		if(count > 10 || count > answer)
			return;
			
		int blue_ny = blue[0];
		int blue_nx = blue[1];
		int red_ny = red[0];
		int red_nx = red[1];
		
		boolean blue_fixed = false;
		boolean red_fixed = false;
		
		while (!red_fixed || !blue_fixed) {
			if (!blue_fixed) {
				blue_ny += dy[dir];
				blue_nx += dx[dir];
			}

			if (!red_fixed) {
				red_ny += dy[dir];
				red_nx += dx[dir];
			}

			if (!map[blue_ny][blue_nx]) {
				if (blue_ny == hole[0] && blue_nx == hole[1]) {
					blue_fixed = true;
				}
			} 
			else {
				blue_ny -= dy[dir];
				blue_nx -= dx[dir];
				blue_fixed = true;
				if (blue_ny == red_ny && blue_nx == red_nx) {
					if(!red_fixed) {
						red_ny -= dy[dir];
						red_nx -= dx[dir];
						red_fixed = true;
					}
					else {
						blue_ny -= dy[dir];
						blue_nx -= dx[dir];
					}
					
				}

			}
			if (!map[red_ny][red_nx]) {
				if (red_ny == hole[0] && red_nx == hole[1]) {
					red_fixed = true;
				}
			} else {
				red_ny -= dy[dir];
				red_nx -= dx[dir];
				red_fixed = true;
				if (blue_ny == red_ny && blue_nx == red_nx) {
					if(!blue_fixed) {
						blue_ny -= dy[dir];
						blue_nx -= dx[dir];
						blue_fixed = true;
					}
					else {
						red_ny -= dy[dir];
						red_nx -= dx[dir];
					}
				}
			}
//			for(int i = 0; i<N; i++) {
//				for(int j = 0; j<M; j++) {
//					if(i == blue_ny && j == blue_nx)
//						System.out.print("B");
//					else if(i == red_ny && j == red_nx)
//						System.out.print("R");
//					else if(map[i][j])
//						System.out.print("#");
//					else
//						System.out.print(".");
//				}
//				System.out.println();
//			}
		}
		
		if(red_ny == hole[0] && red_nx == hole[1]) {
			if(blue_ny == hole[0] && blue_nx== hole[1])
				return;
			else
				answer = Math.min(answer, count);
		}
		
		if(blue_ny == hole[0] && blue_nx== hole[1])
			return;

		
//		System.out.println("------------------");
		for(int i = 0; i<4; i++) {
			blue[0] = blue_ny;
			blue[1] = blue_nx;
			red[0] = red_ny;
			red[1] = red_nx;
			if((i == 0 || i == 1)&&(dir == 0 || dir == 1))
				continue;
			if((i== 2|| i == 3) &&(dir == 2|| dir == 3))
				continue;
			slide(blue,red,i,count+1);
		}
		blue[0] = blue_ny;
		blue[1] = blue_nx;
		red[0] = red_ny;
		red[1] = red_nx;
	}
}
