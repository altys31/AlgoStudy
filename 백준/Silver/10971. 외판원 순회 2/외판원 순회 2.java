
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int answer;
	static int[][] arr;
	static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		num = new int[N+1];
		answer = Integer.MAX_VALUE;
		for(int i = 1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<N+1; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}	
		
		for(int i = 1; i<=N; i++)
			num[i] = i;
		
		perm(1,new int[N+1],0,0);
		System.out.println(answer);
		
	}
	
	static void perm(int toselect, int[] selected, int total,int previous) {
		
		if(total >= answer)
			return;
		
		if(toselect == N+1) {
			if(arr[previous][selected[1]] != 0)
				total += arr[previous][selected[1]];
			else
				return;
			answer = Math.min(answer, total);
		}
		else {
			for(int i = 1; i<=N; i++) {
				if(previous != 0 && arr[previous][i] == 0)
					continue;
				
				if(num[i] != 0) {
					if(previous != 0)
						total += arr[previous][i];
					selected[toselect] = i;
					num[i] = 0;
					perm(toselect+1, selected,total,i);
					if(previous != 0)
						total -= arr[previous][i];
					num[i] = i;
				}
			}
		}
	}	
}
