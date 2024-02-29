import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		int[] num = new int[N+1];
		answer = Integer.MAX_VALUE;
		for(int i = 1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<N+1; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}	
		
		for(int i = 1; i<=N; i++)
			num[i] = i;
		
		perm(1,new int[N+1],num,arr);
		System.out.println(answer);
		
	}
	
	static void perm(int toselect, int[] selected,int[] num,int[][] arr) {
		
		if(toselect == N+1) {
//			for(int i = 1; i<N+1; i++) {
//				System.out.print(selected[i]+" ");
//			}
//			System.out.println();
			
			int total = 0;
			int start = selected[1];
			int previous = selected[1];
			for(int i = 2; i<N+1; i++ ) {
				if(arr[previous][selected[i]] != 0)
					total += arr[previous][selected[i]];
				else
					return;
				previous = selected[i];
			}
			
			if(arr[previous][start] != 0)
				total += arr[previous][start];
			else
				return;
			
			answer = Math.min(answer, total);
		}
		else {
			for(int i = 1; i<=N; i++) {
				if(num[i] != 0) {
					selected[toselect] = i;
				num[i] = 0;
				perm(toselect+1, selected,num,arr);
				num[i] = i;
				}
			}
		}
	}	
}