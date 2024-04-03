import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution{
	static int answer;
	static int N;
	static int M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int Test = 1; Test<T+1; Test++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			Boolean[][] table = new Boolean[N+1][N+1];
			
			for(int i = 0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
			
				table[a][b] = false;
				table[b][a] = true;
				
			}
			
			for(int i = 1; i< N+1; i++) 
				dfs(i, new boolean[N+1],table);
			bw.append("#").append(Integer.toString(Test)).append(" ").append(Integer.toString(answer)).append("\n");
		}
		bw.close();
	}
	
	static void dfs(int num , boolean[] check,Boolean[][] table) {
		int count = 1;
		check[num] = true;
		for(int i = 1; i<N+1; i++) {
			if(i== num)
				continue;
			if(table[num][i] != null && !check[i]) {
				count++;
				check[i] = true;
				count += link(table,check,table[num][i], i,count);
			}
			if(count == N)
				break;
		}
		
		if(count == N)
			answer++;
		
	}
	
	static int link(Boolean[][] table,boolean[] check, boolean upOrDown, int num,int total) {
		int count = 0;
		
		for(int i = 1; i<N+1; i++) {
			if(i==num)
				continue; 
			if(!check[i] && table[num][i] != null && table[num][i] == upOrDown) {
				check[i] = true;
				count++;
				count += link(table,check,upOrDown,i,total+count);
			}
			if(total+count ==N)
				break;
		}
		return count;
		
	}

}