
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int H;
	static int[] ladder_num;
	static int total_ladder;
	static int answer = Integer.MAX_VALUE;
	static int how = 0;
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	H = Integer.parseInt(st.nextToken());
	int[][] ladder;
	ladder = new int[N+1][H+1];
	ladder_num = new int[N+1];
	
	for(int i = 0; i<M; i++) {
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		ladder[b][a] = b+1;
		ladder[b+1][a] = b;
		total_ladder += 1;
	}

	tracking(ladder,0,1);
	if(answer > 3)
		System.out.println(-1);
	else
		System.out.println(answer);
	
	
	
	
	
	}
	
	static void tracking(int[][] ladder,int time,int start) {
		if(check(ladder)) {
			answer = Math.min(answer, time);
			return;
		}
		if(time >= 3)
			return;
		else {
			for(int i = start; i<N; i++) {
				for(int j = 1; j<H+1; j++) {
					if(ladder[i-1][j] != i && ladder[i][j] ==0 && ladder[i+1][j]== 0) {
						ladder[i][j] = i+1;
						ladder[i+1][j] = i;
						total_ladder += 1;
						tracking(ladder,time+1,i);
						total_ladder -= 1;
						ladder[i][j] = 0;
						ladder[i+1][j] = 0;
					}
				}
				
			}
			
		}
		
		
	}
	
	
	static boolean check(int[][] ladder) {
		if(total_ladder % 2 == 1)
			return false;
		
		for(int i = 1; i<N+1; i++) {
			int position = i;
			for(int j = 1; j<H+1; j++) {
				if(ladder[position][j] != 0) {
					position = ladder[position][j];
//					System.out.println("start : " + i+ " line : " + j + " position : "+ position);
				}
			}
			if(position != i) 
				return false;
			
		
		}
		return true;
	}
}