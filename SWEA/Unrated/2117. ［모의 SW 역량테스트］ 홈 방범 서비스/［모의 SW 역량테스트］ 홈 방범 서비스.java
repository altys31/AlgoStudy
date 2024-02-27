import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int answer;
	static int homes;
	static int N;
	static int M;
	static int max_size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int Test = 1; Test<T+1; Test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			boolean[][] map = new boolean[N][N];
			answer = 0; 
			homes = 0;
			
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					if(Integer.parseInt(st.nextToken()) == 1) {
						map[i][j] = true;
						homes++;
					}
				}
			}
			int max_revenue = homes*M;
			max_size = 1;
			while(max_size*max_size+(max_size-1)*(max_size-1) < max_revenue) 
				max_size++;
			
			
//			System.out.println("TEST : "+Test+" max_size "+ max_size+" max_ revenue  "+max_revenue );
			for(int i = 0; i<N; i++) {
				for (int j =0; j<N; j++) {
					for(int n = 0; n< max_size; n++){
						int cost = (n+1)*(n+1)+(n)*(n);
						int total = 0;
						int home =0;
						for(int k = -n; k<= n; k++ ) {
							for(int l = -n; l<=n; l++) {
								if(i+k >= 0 && i+k <N && j+l >= 0 && j+l <N && Math.abs(k)+Math.abs(l) <= n ) {
									if (map[i+k][j+l]) {
										total += M;
										home++;
									}
								}
								
							}
						}
						if(cost <= total) 
							answer = Math.max(home, answer);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(Integer.toString(Test)).append(" ").append(Integer.toString(answer)).append("\n");
			bw.write(sb.toString());
		}
		bw.close();
	}
}